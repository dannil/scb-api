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

package com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetcounty.PublicFinancesAnnualAccountsBalanceSheetCountyClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.balancesheetmunicipality.PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountscounty.PublicFinancesAnnualAccountsStatementAccountsCountyClient;
import com.github.dannil.scbjavaclient.client.publicfinances.annualaccounts.statementaccountsmunicipality.PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient;
import com.github.dannil.scbjavaclient.http.URLEndpoint;
import com.github.dannil.scbjavaclient.test.extensions.TestSuite;

import org.junit.jupiter.api.Test;

@TestSuite
public class PublicFinancesAnnualAccountsClientTest {

    @Test
    public void createWithLocaleConstructor() {
        Locale locale = new Locale("sv", "SE");
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient(locale);

        assertEquals(locale, client.getLocale());
    }

    @Test
    public void balanceSheetCountyClient() {
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient();

        assertEquals(client.balanceSheetCounty().getClass(),
                PublicFinancesAnnualAccountsBalanceSheetCountyClient.class);
    }

    @Test
    public void balanceSheetMunicipalityClient() {
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient();

        assertEquals(client.balanceSheetMunicipality().getClass(),
                PublicFinancesAnnualAccountsBalanceSheetMunicipalityClient.class);
    }

    @Test
    public void statementAccountsCountyClient() {
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient();

        assertEquals(client.statementAccountsCounty().getClass(),
                PublicFinancesAnnualAccountsStatementAccountsCountyClient.class);
    }

    @Test
    public void statementAccountsMunicipalityClient() {
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient();

        assertEquals(client.statementAccountsMunicipality().getClass(),
                PublicFinancesAnnualAccountsStatementAccountsMunicipalityClient.class);
    }

    @Test
    public void getUrl() {
        // Check with a locale that isn't the fallback locale; results in a more specific
        // test with harder constraints
        Locale locale = new Locale("en", "US");
        PublicFinancesAnnualAccountsClient client = new PublicFinancesAnnualAccountsClient(locale);

        assertEquals(URLEndpoint.getRootUrl(locale).append("OE/OE0107/"), client.getUrl());
    }

}
