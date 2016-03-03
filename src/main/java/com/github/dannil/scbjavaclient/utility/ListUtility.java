/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class which (among other things) converts elements to single-element lists.
 * 
 * @author Daniel Nilsson
 *
 * @param <E>
 *            data type of the list
 */
public class ListUtility<E> {

	private ListUtility() {

	}

	/**
	 * Convert the input to a list with the input as its only member.
	 * 
	 * @param <E>
	 *            the data type of value
	 * @param value
	 *            the value to convert to a list
	 * @return null if the input is null, otherwise a list with the input as its only member
	 */
	public static <E> List<E> toList(E value) {
		if (value == null) {
			return null;
		}
		ArrayList<E> list = new ArrayList<E>(1);
		list.add(value);
		return list;
	}

	/**
	 * Convert the input list to its string representation of its members.
	 * 
	 * @param <E>
	 *            the data type of value
	 * @param list
	 *            the list to convert to its string representation
	 * @return the string representation of the list's members
	 */
	public static <E> List<String> toString(List<E> list) {
		List<String> temp = new ArrayList<String>();
		for (E data : list) {
			temp.add(String.valueOf(data));
		}
		return temp;
	}
}
