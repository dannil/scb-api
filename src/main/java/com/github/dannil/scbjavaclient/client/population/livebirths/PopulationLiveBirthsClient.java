/*
 * Copyright 2014 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.client.population.livebirths;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.population.livebirths.LiveBirth;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles population live births data fetching.</p>
 * 
 * @author Daniel Nilsson
 */
public class PopulationLiveBirthsClient extends AbstractClient {

	/**
	 * <p>Fetch all live births data.</p>
	 * 
	 * @return the live births data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.livebirths.LiveBirth
	 *         LiveBirth} objects
	 * 
	 * @see #getLiveBirths(Collection, Collection, Collection, Collection)
	 */
	public List<LiveBirth> getLiveBirths() {
		return getLiveBirths(null, null, null, null);
	}

	/**
	 * <p>Fetch all live births data which match the input constraints.</p>
	 * 
	 * @param regions
	 *            the regions to fetch data for
	 * @param motherAges
	 *            the mothers' ages to fetch data for
	 * @param genders
	 *            the genders to fetch data for
	 * @param years
	 *            the years to fetch data for
	 * @return the live births data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.livebirths.LiveBirth
	 *         LiveBirth} objects
	 */
	public List<LiveBirth> getLiveBirths(Collection<String> regions, Collection<String> motherAges,
			Collection<Integer> genders, Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", Arrays.asList("BE0101E2"));
		mappings.put("Region", regions);
		mappings.put("AlderModer", motherAges);
		mappings.put("Kon", genders);
		mappings.put("Tid", years);

		String response = super.post("BE/BE0101/BE0101H/FoddaK", QueryBuilder.build(mappings));

		JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
		return format.toListOf(LiveBirth.class);
	}

	@Override
	public String getUrl() {
		return super.getUrl() + "BE/BE0101/BE0101H/";
	}

}
