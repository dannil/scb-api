package org.dannil.scbapi.model.population.statistic;

import java.util.Arrays;
import java.util.List;

public final class Statistic extends AbstractStatisticModel {

	private String relationshipStatus;
	private String age;
	private Integer gender;
	private Long amount;

	public Statistic() {
		super();
	}

	public Statistic(String region, String relationshipStatus, String age, Integer gender, Integer year, Long amount) {
		super(region, year);
		this.relationshipStatus = relationshipStatus;
		this.age = age;
		this.gender = gender;
		this.amount = amount;
	}

	public final String getRelationshipStatus() {
		return this.relationshipStatus;
	}

	public final void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public final String getAge() {
		return this.age;
	}

	public final void setAge(String age) {
		this.age = age;
	}

	public final Integer getGender() {
		return this.gender;
	}

	public final void setGender(Integer gender) {
		this.gender = gender;
	}

	public final Long getAmount() {
		return this.amount;
	}

	public final void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Statistic [region=" + super.region + ", year=" + super.year + ", relationshipStatus=" + this.relationshipStatus + ", " + "age=" + this.age + ", gender=" + this.gender + ", amount="
				+ this.amount + "]";
	}

	public static List<String> getCodes() {
		return Arrays.asList("Region", "Civilstand", "Alder", "Kon", "Tid", "BE0101N1", "BE0101N2");
	}

	public static enum Codes {
		REGION, CIVILSTAND, ALDER, KON, TID, BE0101N1, BE0101N2
	}

}
