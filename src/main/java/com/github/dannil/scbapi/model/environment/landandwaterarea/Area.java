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

package com.github.dannil.scbapi.model.environment.landandwaterarea;

import java.util.List;
import java.util.Objects;

import com.github.dannil.scbapi.model.AbstractRegionAndYearModel;
import com.github.dannil.scbapi.utility.JsonUtility;
import com.github.dannil.scbapi.utility.RequestPoster;

public class Area extends AbstractRegionAndYearModel<String, Integer, Double> {

	private String type;

	public Area() {
		super();
	}

	public Area(String region, String type, Integer year, Double value) {
		super(region, year, value);
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Area)) {
			return false;
		}

		Area other = (Area) obj;
		return super.equals(obj) && Objects.equals(this.type, other.type);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(128);

		builder.append(this.getClass().getSimpleName());
		builder.append(" [type=");
		builder.append(this.type);
		builder.append(", region=");
		builder.append(super.region);
		builder.append(", year=");
		builder.append(super.year);
		builder.append(", value=");
		builder.append(super.value);
		builder.append(']');

		return builder.toString();
	}

	public static List<String> getCodes() {
		return JsonUtility.getCodes(RequestPoster.getCodes("MI/MI0802/Areal2012"));
	}

}
