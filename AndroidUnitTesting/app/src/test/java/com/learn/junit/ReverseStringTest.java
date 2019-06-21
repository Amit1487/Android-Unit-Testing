package com.learn.junit;

import com.learn.junit.ReverseString;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * pattern to name test case is <UnitOfWork>_<stateUnderTest>_<ExpectedBehaviour>
 */
public class ReverseStringTest {


    ReverseString SUT;
    @Before
    public void setUp() throws Exception {
        SUT = new ReverseString();
    }

    /**
     * <UnitOfWork>_<stateUnderTest>_<ExpectedBehaviour>
     *     reverse_emptyString_emptyStringReturned
     */
    @Test
    public void reverse_emptyString_emptyStringReturned() {
        String result = SUT.reverse("");
        assertThat(result, is(""));
    }

    @Test
    public void reverse_singleString_singleStringReturned() {
        String result = SUT.reverse("a");
        assertThat(result,is("a"));
    }

    @Test
    public void reverse_longString_reversedStringReturned() {
        String result = SUT.reverse("Amit");
        assertThat(result, is("timA"));
    }


}