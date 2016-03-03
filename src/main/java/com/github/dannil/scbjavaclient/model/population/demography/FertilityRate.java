package com.github.dannil.scbjavaclient.model.population.demography;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dannil.scbjavaclient.model.AbstractRegionYearAndValueModel;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.RequestPoster;

public class FertilityRate extends AbstractRegionYearAndValueModel<String, Integer, Double> {

	@JsonProperty("kon")
	private Integer gender;

	public FertilityRate() {
		super();
	}

	public FertilityRate(String region, Integer gender, Integer year, Double value) {
		super(region, year, value);
		this.gender = gender;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.gender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FertilityRate)) {
			return false;
		}

		FertilityRate other = (FertilityRate) obj;
		return super.equals(other) && Objects.equals(this.gender, other.gender);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(128);

		builder.append(this.getClass().getSimpleName());
		builder.append(" [gender=");
		builder.append(this.gender);
		builder.append(", region=");
		builder.append(super.region);
		builder.append(", year=");
		builder.append(super.year);
		builder.append(", value=");
		builder.append(super.value);
		builder.append(']');

		return builder.toString();
	}

	/**
	 * Get the codes for the population model from the API.
	 * 
	 * @return a list of codes that is used by the API to index the values
	 */
	public static List<String> getCodes() {
		return JsonUtility.getCodes(RequestPoster.getCodes("BE/BE0701/FruktsamhetSumNy"));
	}

}
