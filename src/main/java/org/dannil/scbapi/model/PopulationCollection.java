package org.dannil.scbapi.model;

import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.PopulationOperations;

import com.fasterxml.jackson.databind.JsonNode;

public final class PopulationCollection implements PopulationOperations {

	// TODO

	private List<Population> populations;

	private PopulationCollection() {
		this.populations = new ArrayList<Population>();
	}

	public PopulationCollection(JsonNode data) {
		this();

		List<JsonNode> keys = data.findValues("key");
		List<JsonNode> values = data.findValues("values");

		for (int i = 0; i < keys.size(); i++) {
			JsonNode keyAtPosition = keys.get(i);
			final String region = keyAtPosition.get(0).asText();
			final Integer year = keyAtPosition.get(1).asInt();

			JsonNode valueAtPosition = values.get(i);
			final Long amount = valueAtPosition.get(0).asLong();

			Population p = new Population(region, year, amount);
			this.populations.add(p);
		}
	}

	@Override
	public PopulationCollection getPopulation() {
		return this;
	}

	@Override
	public PopulationCollection getPopulationForYear(int year) {
		final PopulationCollection c = new PopulationCollection();
		for (Population p : this.populations) {
			if (p.equals(year)) {
				c.add(p);
			}
		}
		return c;
	}

	@Override
	public PopulationCollection getPopulationBetweenYears(int startYear, int endYear) {
		final PopulationCollection c = new PopulationCollection();
		for (Population p : this.populations) {
			if (p.getYear() >= startYear && p.getYear() <= endYear) {
				c.add(p);
			}
		}
		return c;
	}

	@Override
	public PopulationCollection getPopulationForYears(List<Integer> years) {
		final PopulationCollection c = new PopulationCollection();
		for (Population p : this.populations) {
			for (Integer year : years) {
				if (p.getYear().equals(year)) {
					c.add(p);
				}
			}
		}
		return c;
	}

	@Override
	public PopulationCollection getPopulationForRegion(String region) {
		final PopulationCollection c = new PopulationCollection();
		for (Population p : this.populations) {
			if (p.getRegion().equals(region)) {
				c.add(p);
			}
		}
		return c;
	}

	@Override
	public PopulationCollection getPopulationForRegion(String region, Integer year) {
		final PopulationCollection c = new PopulationCollection();
		for (Population p : this.populations) {
			if (p.getRegion().equals(region) && p.getYear().equals(year)) {
				c.add(p);
			}
		}
		return c;
	}

	@Override
	public PopulationCollection getPopulationForRegion(String region, List<Integer> years) {
		final PopulationCollection c = new PopulationCollection();
		for (Population p : this.populations) {
			for (Integer year : years) {
				if (p.getRegion().equals(region) && p.getYear().equals(year)) {
					c.add(p);
				}
			}
		}
		return c;
	}

	@Override
	public PopulationCollection getPopulationForRegions(List<String> regions) {
		final PopulationCollection c = new PopulationCollection();
		for (Population p : this.populations) {
			for (String region : regions) {
				if (p.equals(region)) {
					c.add(p);
				}
			}
		}
		return c;
	}

	@Override
	public PopulationCollection getPopulationForRegions(List<String> regions, List<Integer> years) {
		final PopulationCollection c = new PopulationCollection();
		for (Population p : this.populations) {
			for (String region : regions) {
				for (Integer year : years) {
					if (p.getRegion().equals(region) && p.getYear().equals(year)) {
						c.add(p);
					}
				}
			}
		}
		return c;
	}

	public void add(Population p) {
		this.populations.add(p);
	}

	public List<Population> getPopulations() {
		return this.populations;
	}

	public void setPopulations(List<Population> populations) {
		this.populations = populations;
	}

}
