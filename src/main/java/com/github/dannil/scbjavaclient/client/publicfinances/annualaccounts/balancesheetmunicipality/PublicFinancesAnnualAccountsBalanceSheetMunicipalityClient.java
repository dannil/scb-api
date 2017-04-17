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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetmunicipality;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.model.ResponseModel;

/**
 * <p>Client which handles public finances annual accounts balance sheet municipality data
 * fetching.</p>
 *
 * @since 0.3.0
 */
public class PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient extends AbstractClient {

    /**
     * <p>Default constructor.</p>
     */
    public PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient(Locale locale) {
        super(locale);
    }

    // Daniel 2017-04-17: Returns HTTP 403
    //
    // public List<ResponseModel> getIncomeStatements() {
    // return getIncomeStatements(null, null, null);
    // }

    public List<ResponseModel> getIncomeStatements(Collection<String> regions, Collection<String> incomeStatements,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Resultatraknposter", incomeStatements);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("ResultKn", mappings);
    }

    // Daniel 2017-04-17: Returns HTTP 403
    //
    // public List<ResponseModel> getBalanceSheet() {
    // return getBalanceSheet(null, null, null);
    // }
    public List<ResponseModel> getBalanceSheet(Collection<String> regions, Collection<String> balanceSheets,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Balansraknposter", balanceSheets);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BalansKn", mappings);
    }

    public List<ResponseModel> getGuaranteesAndContingentLiabilities() {
        return getGuaranteesAndContingentLiabilities(null, null, null);
    }

    public List<ResponseModel> getGuaranteesAndContingentLiabilities(Collection<String> regions,
            Collection<Integer> typesOfGuarantees, Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("BorgenAnsvarsposter", typesOfGuarantees);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("BorgensforbKn", mappings);
    }

    public List<ResponseModel> getLocalGovernmentIncomes() {
        return getLocalGovernmentIncomes(null, null, null);
    }

    public List<ResponseModel> getLocalGovernmentIncomes(Collection<String> regions, Collection<Integer> items,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Kontopost", items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("VerksInt", mappings);
    }

    public List<ResponseModel> getMunicipalitiesCosts() {
        return getMunicipalitiesCosts(null, null, null);
    }

    public List<ResponseModel> getMunicipalitiesCosts(Collection<String> regions, Collection<Integer> items,
            Collection<Integer> years) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        mappings.put(APIConstants.REGION_CODE, regions);
        mappings.put("Kontopost", items);
        mappings.put(APIConstants.TIME_CODE, years);

        return getResponseModels("VerksKostn", mappings);
    }

    @Override
    public URLEndpoint getUrl() {
        return getRootUrl().append("OE/OE0107/OE0107A/");
    }

}
