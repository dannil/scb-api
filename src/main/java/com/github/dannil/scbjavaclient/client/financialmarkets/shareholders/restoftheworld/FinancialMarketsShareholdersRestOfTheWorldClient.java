/*
 * Copyright 2020 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.financialmarkets.shareholders.restoftheworld;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles financial markets shareholders rest of the world data
 * fetching.</p>
 *
 * @since 3.0.0
 */
public class FinancialMarketsShareholdersRestOfTheWorldClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public FinancialMarketsShareholdersRestOfTheWorldClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public FinancialMarketsShareholdersRestOfTheWorldClient(Locale locale) {
        super(locale);
    }

    /**
     * <p>Fetch all foreign ownership of shares data.</p>
     *
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     *
     * @see #getForeignOwnershipOfShares(Collection, Collection)
     */
    public List<ResponseModel> getForeignOwnershipOfShares() {
        return getForeignOwnershipOfShares(null, null);
    }

    /**
     * <p>Fetch all foreign ownership of shares data which match the input
     * constraints.</p>
     *
     * @param countries
     *            the countries to fetch data for
     * @param twoTimesPerYears
     *            the two times per years to fetch data for
     * @return the data wrapped in a list of
     *         {@link com.github.dannil.scbjavaclient.model.ResponseModel ResponseModel}
     *         objects
     */
    public List<ResponseModel> getForeignOwnershipOfShares(Collection<String> countries,
            Collection<String> twoTimesPerYears) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put("Agarland", countries);
        mappings.put(APIConstants.TIME_CODE, twoTimesPerYears);

        return getResponseModels("AktieAgarUtlandN", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("FM/FM0201/FM0201C");
    }

}
