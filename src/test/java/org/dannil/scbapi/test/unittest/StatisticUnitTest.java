package org.dannil.scbapi.test.unittest;

import org.dannil.scbapi.model.population.statistic.Statistic;
import org.dannil.scbapi.model.population.statistic.Statistic.Gender;
import org.dannil.scbapi.model.population.statistic.Statistic.RelationshipStatus;
import org.jboss.resteasy.spi.NotImplementedYetException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StatisticUnitTest {

	private Statistic statistic;

	@Before
	public final void init() {
		this.statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
	}

	@Test
	public final void createWithDefaultConstructor() {
		Statistic statistic = new Statistic();

		Assert.assertNotNull(statistic);
	}

	@Test
	public final void setRegion() {
		Statistic statistic = new Statistic();

		statistic.setRegion("1267");

		Assert.assertNotNull(statistic.getRegion());
	}

	@Test
	public final void getRegion() {
		Statistic statistic = new Statistic();

		statistic.setRegion("1267");

		Assert.assertEquals("1267", statistic.getRegion());
	}

	@Test
	public final void setRelationshipStatus() {
		Statistic statistic = new Statistic();

		statistic.setRelationshipStatus(RelationshipStatus.MARRIED);

		Assert.assertNotNull(statistic.getRelationshipStatus());
	}

	@Test
	public final void getRelationshipStatus() {
		Statistic statistic = new Statistic();

		statistic.setRelationshipStatus(RelationshipStatus.MARRIED);

		Assert.assertEquals(RelationshipStatus.MARRIED, statistic.getRelationshipStatus());
	}

	@Test
	public final void setAge() {
		Statistic statistic = new Statistic();

		statistic.setAge("20");

		Assert.assertNotNull(statistic.getAge());
	}

	@Test
	public final void getAge() {
		Statistic statistic = new Statistic();

		statistic.setAge("20");

		Assert.assertEquals("20", statistic.getAge());
	}

	@Test
	public final void setGender() {
		Statistic statistic = new Statistic();

		statistic.setGender(Gender.MAN);

		Assert.assertNotNull(statistic.getGender());
	}

	@Test
	public final void getGender() {
		Statistic statistic = new Statistic();

		statistic.setGender(Gender.MAN);

		Assert.assertEquals(Gender.MAN, statistic.getGender());
	}

	@Test
	public final void setYear() {
		Statistic statistic = new Statistic();

		statistic.setYear(2011);

		Assert.assertNotNull(statistic.getYear());
	}

	@Test
	public final void getYear() {
		Statistic statistic = new Statistic();

		statistic.setYear(2011);

		Assert.assertEquals(Integer.valueOf(2011), statistic.getYear());
	}

	@Test
	public final void setAmount() {
		Statistic statistic = new Statistic();

		statistic.setAmount(12345L);

		Assert.assertNotNull(statistic.getAmount());
	}

	@Test
	public final void getAmount() {
		Statistic statistic = new Statistic();

		statistic.setAmount(12345L);

		Assert.assertEquals(Long.valueOf(12345L), statistic.getAmount());
	}

	@Test
	public final void getCodes() {
		Assert.assertNotNull(Statistic.getCodes());
	}

	@Test
	public final void equals() {
		Statistic statistic = new Statistic();
		Statistic statistic2 = new Statistic();

		Assert.assertTrue(statistic.equals(statistic2));
	}

	@Test
	public final void equalsItself() {
		Statistic statistic = new Statistic();

		Assert.assertTrue(statistic.equals(statistic));
	}

	@Test
	public final void equalsItselfWithValues() {
		throw new NotImplementedYetException();
	}

	@Test
	public final void notEqualsNull() {
		Statistic statistic = new Statistic();

		Assert.assertFalse(statistic.equals(null));
	}

	@Test
	public final void notEqualsOnRegion() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setRegion("1452");

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnNullRegion() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setRegion(null);

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnRelationshipStatus() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setRelationshipStatus(RelationshipStatus.DIVORCED);

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnNullRelationshipStatus() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setRelationshipStatus(null);

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnAge() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setAge("56");

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnNullAge() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setAge(null);

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnGender() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setGender(Gender.WOMAN);

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnNullGender() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setGender(null);

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnYear() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setYear(1999);

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnNullYear() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setYear(null);

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnAmount() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setAmount(54321L);

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void notEqualsOnNullAmount() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		statistic2.setAmount(null);

		Assert.assertFalse(statistic.equals(statistic2));
	}

	@Test
	public final void equalsHashCode() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		Statistic statistic2 = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Assert.assertEquals(statistic.hashCode(), statistic2.hashCode());
	}

	@Test
	public final void equalsHashCodeNullValues() {
		Statistic statistic = new Statistic();
		Statistic statistic2 = new Statistic();

		Assert.assertEquals(statistic.hashCode(), statistic2.hashCode());
	}

	@Test
	public final void convertToString() {
		Statistic statistic = new Statistic();

		Assert.assertNotNull(statistic.toString());
	}

	@Test
	public final void convertToStringNullValues() {
		Statistic statistic = new Statistic("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Assert.assertNotNull(statistic.toString());
	}

}
