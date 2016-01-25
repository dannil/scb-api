/*
Copyright 2014, 2015 Daniel Nilsson

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

package com.github.dannil.scbapi.api.environment.landandwaterarea;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbapi.api.AbstractAPI;
import com.github.dannil.scbapi.model.environment.landandwaterarea.Area;
import com.github.dannil.scbapi.utility.JsonUtility;
import com.github.dannil.scbapi.utility.ListUtility;

public class LandAndWaterAreaAPI extends AbstractAPI implements IArea {

	public LandAndWaterAreaAPI() {
		super();
	}

	public LandAndWaterAreaAPI(Locale locale) {
		super(locale);
	}

	// public List<String> getRegions() {
	// return super.getRegions(getUrl());
	// }
	//
	// public List<Integer> getYears() {
	// List<String> fetchedYears = super.getYears(getUrl());
	//
	// List<Integer> years = new ArrayList<Integer>(fetchedYears.size());
	// for (String fetchedYear : fetchedYears) {
	// years.add(Integer.valueOf(fetchedYear));
	// }
	// return years;
	// }

	@Override
	public List<Area> getArea() {
		return this.getArea(null, null, null);
	}

	@Override
	public List<Area> getArea(List<String> regions, List<String> types, List<Integer> years) {
		Map<String, List<?>> mappings = new HashMap<String, List<?>>();
		mappings.put("ContentsCode", ListUtility.toList("MI0802AA"));
		mappings.put("Region", regions);
		mappings.put("ArealTyp", types);
		mappings.put("Tid", years);

		String response = super.post("MI/MI0802/Areal2012", super.queryBuilder.build(mappings));

		return JsonUtility.parseAreas(JsonUtility.getNode(response));
	}
}
