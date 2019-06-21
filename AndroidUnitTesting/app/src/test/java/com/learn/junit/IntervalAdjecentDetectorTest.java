package com.learn.junit;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IntervalAdjecentDetectorTest {

    IntervalAdjecentDetector SUT;
    @Before
    public void setUp() throws Exception {
        SUT = new IntervalAdjecentDetector();
    }

    @Test
    public void isAdjecent_interval1BeforeInterval2_trueReturned(){
        Interval in1 = new Interval(0,5);
            Interval in2 = new Interval(7,10);

              boolean result = SUT.isAdjecent(in1,in2);

              assertThat(result, is(true));
    }

    @Test
    public void isAdjecent_interval1AfterInterval2_falseReturned(){
        Interval in2 = new Interval(0,5);
        Interval in1 = new Interval(7,10);

        boolean result = SUT.isAdjecent(in1,in2);

        assertThat(result, is(false));
    }

    @Test
    public void isAdjecent_interval2BeforeInterval1_trueReturned(){
        Interval in1 = new Interval(0,5);
        Interval in2 = new Interval(7,10);

        boolean result = SUT.isAdjecent(in1,in2);

        assertThat(result, is(true));
    }


    //is interval1 before interval2
    //is interval 1
    /**
     *  Interval in1 = new Interval(0,5);
     *         Interval in2 = new Interval(6,10);
     *
     *         boolean result = SUT.isOverlap(in1,in2);
     *
     *         assertThat(result, is(false));
     */
}