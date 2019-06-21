package com.learn.junit;

import com.learn.junit.StringDuplicator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StringDuplicatorTest {

    StringDuplicator SUT;
    @Before
    public void setUp() throws Exception {
        SUT = new StringDuplicator();
    }

    @Test
    public void duplicate_emptyString_emptyStringReturned() {
        String result = SUT.duplicate("");
        assertThat(result, is(""));
    }

    @Test
    public void duplicate_singleCharecter_duplicatedStringReturned() {
        String result = SUT.duplicate("a");
        assertThat(result,is("aa"));
    }


    @Test
    public void duplicate_longString_duplicatedStringReturned() {
        String result = SUT.duplicate("amit");
        assertThat(result, is("amitamit"));
    }
}