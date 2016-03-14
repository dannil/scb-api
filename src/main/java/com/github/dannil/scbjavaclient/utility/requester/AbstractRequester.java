/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.utility.requester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Class which contains the logic for sending URL requests to the specified address, in this case
 * the SCB API.
 * 
 * @author Daniel Nilsson
 */
public abstract class AbstractRequester {

	protected Charset charset;

	protected Map<String, String> requestProperties;

	protected AbstractRequester() {
		this.requestProperties = new HashMap<String, String>();

		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = getClass().getClassLoader().getResourceAsStream("project.properties");

			prop.load(input);

			String artifactId = prop.getProperty("artifactId");
			String version = prop.getProperty("version");
			String url = prop.getProperty("url");

			this.requestProperties.put("Accept", "application/json");
			this.requestProperties.put("Content-Type", "application/json; charset=utf-8");

			StringBuilder builder = new StringBuilder(64);
			builder.append(artifactId);
			builder.append('/');
			builder.append(version);
			builder.append(' ');
			builder.append("(" + url + ")");
			builder.append(", ");
			builder.append(System.getProperty("os.name"));

			this.requestProperties.put("User-Agent", builder.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	protected void setRequestProperties(URLConnection urlConnection, String... props) {
		for (String prop : props) {
			urlConnection.addRequestProperty(prop, this.requestProperties.get(prop));
		}
	}

	protected HttpURLConnection prepareConnection(String address) throws IOException {
		URL url = new URL(address);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		setRequestProperties(connection, "Accept", "Content-Type", "User-Agent");

		return connection;
	}

	protected String getResponse(HttpURLConnection httpUrlConnection) throws IOException {
		StringBuilder builder = new StringBuilder(32);

		try (BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(),
				this.charset.name()))) {
			// Handle UTF-8 byte order mark (BOM)
			br.mark(4);

			// Checks if the stream contains a BOM. If it doesn't, reset the
			// stream pointer to the location specified by br.mark()
			if ('\uFEFF' != br.read()) {
				br.reset();
			}

			String line;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
		}

		httpUrlConnection.disconnect();

		return builder.toString();
	}

	/**
	 * Return the available codes from the specified table.
	 *
	 * @param table
	 *            the table to fetch the codes from
	 * @return the available codes from the specified table
	 */
	public static String getCodes(String table) {
		try {
			AbstractRequester get = RequesterFactory.getRequester("GET");
			return get.doRequest(String.format("http://api.scb.se/OV0104/v1/doris/sv/ssd/%s", table));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public abstract String doRequest(String address) throws IOException;

	public Charset getCharset() {
		return this.charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

}
