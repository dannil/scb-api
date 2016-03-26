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

import java.nio.charset.Charset;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/**
 * HTTP requester for GET requests.
 * 
 * @author Daniel Nilsson
 */
public class GETRequester extends AbstractRequester {

	/**
	 * Default constructor.
	 */
	public GETRequester() {
		super();
		super.requestProperties.put("Request-Method", "GET");
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param charset
	 *            the charset
	 */
	public GETRequester(Charset charset) {
		this();
		super.charset = charset;
	}

	@Override
	public String getResponseBody(String url) {
		HttpGet request = new HttpGet(url);
		for (Entry<String, String> entry : super.requestProperties.entrySet()) {
			request.addHeader(entry.getKey(), entry.getValue());
		}

		HttpResponse response = super.getResponse(request);

		return super.getBody(response);
	}

}
