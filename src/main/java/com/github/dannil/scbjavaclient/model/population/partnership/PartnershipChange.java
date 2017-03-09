/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.model.population.partnership;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.constants.ModelConstants;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.model.AbstractRegionTimeAndValueModel;
import com.github.dannil.scbjavaclient.model.ValueNode;

/**
 * <p>Model for partnership data.</p>
 *
 * @since 0.1.0
 */
public class PartnershipChange extends AbstractRegionTimeAndValueModel<String, Integer, String> {

    @JsonProperty("Civilstand")
    private String maritalStatus;

    @JsonProperty("Kon")
    private String sex;

    /**
     * <p>Default constructor.</p>
     */
    public PartnershipChange() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param region
     *            the region
     * @param maritalStatus
     *            the marital status
     * @param sex
     *            the sex
     * @param year
     *            the year
     * @param values
     *            the values
     */
    public PartnershipChange(String region, String maritalStatus, String sex, Integer year,
            List<ValueNode<String>> values) {
        super(region, year, values);
        this.maritalStatus = maritalStatus;
        this.sex = sex;
    }

    /**
     * <p>Getter for marital status.</p>
     *
     * @return the marital status.
     */
    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    /**
     * <p>Setter for marital status.</p>
     *
     * @param maritalStatus
     *            the marital status
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * <p>Getter for sex.</p>
     *
     * @return the sex.
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * <p>Setter for sex.</p>
     *
     * @param sex
     *            the sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.maritalStatus, this.sex);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PartnershipChange)) {
            return false;
        }

        PartnershipChange other = (PartnershipChange) obj;
        return super.equals(other) && Objects.equals(this.maritalStatus, other.maritalStatus)
                && Objects.equals(this.sex, other.sex);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(ModelConstants.TOSTRING_BUILDER_LENGTH);

        builder.append(this.getClass().getSimpleName());
        builder.append(" [maritalStatus=");
        builder.append(this.maritalStatus);
        builder.append(", sex=");
        builder.append(this.sex);
        builder.append(", region=");
        builder.append(getRegion());
        builder.append(", time=");
        builder.append(getTime());
        builder.append(", values=");
        builder.append(getValues());
        builder.append(']');

        return builder.toString();
    }

    /**
     * <p>Get the available codes and their respective values for the partnership data
     * from the API.</p>
     *
     * @return a list of the available codes and their values
     */
    public static Map<String, Collection<String>> getInputs() {
        AbstractRequester get = new GETRequester();
        String response = get.getBodyFromTable("BE/BE0101/BE0101O/PartnerskapAndring");

        JsonAPITableFormat format = new JsonAPITableFormat(response);
        return format.getInputs();
    }

}
