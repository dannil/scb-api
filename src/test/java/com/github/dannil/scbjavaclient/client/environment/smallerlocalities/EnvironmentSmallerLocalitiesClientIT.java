/*
 * Copyright 2017 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.environment.smallerlocalities;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.runner.Date;
import com.github.dannil.scbjavaclient.test.runner.DateJUnitRunner;
import com.github.dannil.scbjavaclient.test.utility.RemoteIntegrationTestSuite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DateJUnitRunner.class)
public class EnvironmentSmallerLocalitiesClientIT extends RemoteIntegrationTestSuite {

    private EnvironmentSmallerLocalitiesClient client;

    @Before
    public void setup() {
        this.client = new EnvironmentSmallerLocalitiesClient();
    }

    @Test
    @Date("2017-05-27")
    public void getLandArea() {
        assertNotEquals(0, this.client.getLandArea().size());
    }

    @Test
    @Date("2017-05-27")
    public void getLandAreaWithParametersEmptyLists() {
        assertNotEquals(0,
                this.client.getLandArea(Collections.<String>emptyList(), Collections.<Integer>emptyList()).size());
    }

    @Test
    @Date("2017-05-27")
    public void getLandAreaWithParameters() {
        List<String> regions = Arrays.asList("S0245", "S0225");
        List<Integer> years = Arrays.asList(2005, 2010);

        assertNotEquals(0, this.client.getLandArea(regions, years).size());
    }

}
