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

package com.github.dannil.scbjavaclient.client.population;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.model.RemoteIntegrationTestSuite;
import com.github.dannil.scbjavaclient.utility.ListUtility;

@RunWith(Parameterized.class)
public class PopulationClient_GetNumberOfChildrenBornWithFirstName_IntegrationTest extends RemoteIntegrationTestSuite {

	private List<String> firstnames;
	private List<Integer> years;

	private PopulationClient populationClient;

	@Parameters(name = "{index}: getNumberOfChildrenBornWithFirstName({0}, {1}")
	public static Collection<Object[]> data() {
		List<String> firstnames;
		List<Integer> years;

		firstnames = new ArrayList<String>();
		firstnames.add("AdinaK");
		firstnames.add(null);

		years = new ArrayList<Integer>();
		years.add(2002);
		years.add(null);

		List<Object[]> parameters = new ArrayList<Object[]>();

		// Test with real data
		for (String firstname : firstnames) {
			for (Integer year : years) {
				parameters.add(new Object[] { ListUtility.toList(firstname), ListUtility.toList(year) });
			}
		}

		// Special case: test with everything null
		parameters.add(new Object[] { null, null });

		// Special case: test with everything at once
		parameters.add(new Object[] { firstnames, years });

		return parameters;
	}

	private PopulationClient_GetNumberOfChildrenBornWithFirstName_IntegrationTest() {
		this.populationClient = new SCBClient().population();
	}

	public PopulationClient_GetNumberOfChildrenBornWithFirstName_IntegrationTest(List<String> firstnames,
			List<Integer> years) {
		this();

		this.firstnames = firstnames;
		this.years = years;
	}

	@Test
	public void getNumberOfChildrenBornWithFirstName() {
		assertNotEquals(0, this.populationClient.getNumberOfChildrenBornWithFirstName(this.firstnames, this.years)
				.size());
	}

}
