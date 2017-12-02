package com.github.dannil.scbjavaclient.format;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractTableFormatTest {

    private class DummyTableFormat extends AbstractTableFormat {

        private Map<String, Collection<String>> pairs;

        public DummyTableFormat(Map<String, Collection<String>> pairs) {
            this.pairs = pairs;
        }

        @Override
        public Map<String, Collection<String>> getPairs() {
            return this.pairs;
        }

    }

    private DummyTableFormat tableFormat;

    @Before
    public void setup() {
        Map<String, Collection<String>> pairs = new LinkedHashMap<>();
        pairs.put("a", Arrays.asList("a1", "a2", "a3"));
        pairs.put("b", Arrays.asList("b1", "b2", "b3"));

        this.tableFormat = new DummyTableFormat(pairs);
    }

    @Test
    public void getPairs() {
        Map<String, Collection<String>> pairs = new LinkedHashMap<>();
        pairs.put("a", Arrays.asList("a1", "a2", "a3"));
        pairs.put("b", Arrays.asList("b1", "b2", "b3"));

        assertEquals(this.tableFormat.getPairs(), pairs);
    }

    @Test
    public void getKeys() {
        List<String> keys = Arrays.asList("a", "b");

        assertEquals(this.tableFormat.getKeys(), keys);
    }

    @Test
    public void getValues() {
        List<String> values = Arrays.asList("a1", "a2", "a3");

        assertEquals(this.tableFormat.getValues("a"), values);
    }

    @Test
    public void getValuesNonExistingKey() {
        assertEquals(Collections.EMPTY_LIST, this.tableFormat.getValues("c"));
    }

}