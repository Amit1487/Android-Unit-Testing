package com.learn.junit;

import com.learn.junit.NegativeNumberValidator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NegativeNumberValidatorTest {


    NegativeNumberValidator SUT;

    @Before
    public void setUp() {
        SUT = new NegativeNumberValidator();
    }

    @Test
    public void test1() {
        boolean result = SUT.isNegativeNumber(-1);
        Assert.assertThat(result, is(true));
    }

    @Test
    public void test2() {
        boolean result = SUT.isNegativeNumber(0);
        Assert.assertThat(result, is(false));
    }

    @Test
    public void test3() {
        boolean result = SUT.isNegativeNumber(1);
        Assert.assertThat(result, is(false));
    }


}