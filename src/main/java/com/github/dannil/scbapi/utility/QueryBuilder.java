/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package com.github.dannil.scbapi.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class QueryBuilder {

	private static QueryBuilder builder;

	public static QueryBuilder getInstance() {
		if (builder == null) {
			builder = new QueryBuilder();
		}
		return builder;
	}

	private QueryBuilder() {

	}

	public String build(Map<String, List<?>> inputMap) {
		// Filter out null values
		Map<String, List<?>> filteredMap = new HashMap<String, List<?>>();

		for (Entry<String, List<?>> entry : inputMap.entrySet()) {
			if (entry.getValue() != null) {
				List<Object> values = new ArrayList<Object>();
				for (Object o : entry.getValue()) {
					if (o != null) {
						values.add(o);
					}
				}
				filteredMap.put(entry.getKey(), values);
			}
		}

		// Approximate a good initial capacity for the string buffer
		int size = Math.max(44 + (80 * filteredMap.size()), 256);
		StringBuilder builder = new StringBuilder(size);

		// Construct the query
		builder.append("{\"query\": [");
		int i = 0;
		for (Entry<String, List<?>> entry : filteredMap.entrySet()) {
			builder.append("{\"code\": \"" + entry.getKey() + "\",\"selection\": {\"filter\": \"item\",\"values\": [");
			List<?> values = entry.getValue();
			for (int j = 0; j < values.size(); j++) {
				builder.append("\"" + values.get(j) + "\"");
				if (j != values.size() - 1) {
					builder.append(',');
				}
			}
			builder.append("]}}");
			if (i != filteredMap.keySet().size() - 1) {
				builder.append(',');
			}
			i++;
		}
		builder.append("],\"response\": {\"format\": \"json\"}}");

		return builder.toString();
	}
}
