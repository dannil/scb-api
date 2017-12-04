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

package com.github.dannil.scbjavaclient.client.businessactivities.productionindex;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.dannil.scbjavaclient.test.extensions.Date;
import com.github.dannil.scbjavaclient.test.extensions.Remote;
import com.github.dannil.scbjavaclient.test.extensions.TestSuite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestSuite
@Remote
public class BusinessActivitiesProductionIndexClientIT {

    private BusinessActivitiesProductionIndexClient client;

    @BeforeEach
    public void setup() {
        this.client = new BusinessActivitiesProductionIndexClient();
    }

    @Test
    @Date("2017-04-09")
    public void getBusinessProductionIndex() {
        assertNotEquals(0, this.client.getBusinessProductionIndex().size());
    }

    @Test
    @Date("2017-04-09")
    public void getBusinessProductionIndexWithParametersEmptyLists() {
        assertNotEquals(0, this.client.getBusinessProductionIndex(Collections.<String>emptyList(),
                Collections.<String>emptyList()).size());
    }

    @Test
    @Date("2017-04-09")
    public void getBusinessProductionIndexWithParameters() {
        List<String> industrialClassifications = Arrays.asList("B-S exkl K+O", "F");
        List<String> months = Arrays.asList("2002M03", "2008M09");

        assertNotEquals(0, this.client.getBusinessProductionIndex(industrialClassifications, months).size());
    }

}
