package com.learn.junit;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IntervalOverlapDetectorTest {

    IntervalOverlapDetector SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new IntervalOverlapDetector();
    }


    //interval1 is before interval2
    @Test
    public void isOverlap_interval1BeforeInterview2_falseReturned() {
        Interval in1 = new Interval(0,5);
        Interval in2 = new Interval(6,10);

        boolean result = SUT.isOverlap(in1,in2);

        assertThat(result, is(false));



    }
    //interval1 overlaps interval2 on start

    @Test
    public void isOverlap_interval1OverlapsInterview2OnStart_trueReturned() {
        Interval in1 = new Interval(0,5);
        Interval in2 = new Interval(4,10);

        boolean result = SUT.isOverlap(in1,in2);

        assertThat(result, is(true));


    }

    //interval1 is contained between interval2

    @Test
    public void isOverlap_interval1ContainedBtwInterview2_trueReturned() {
        Interval in1 = new Interval(7,8);
        Interval in2 = new Interval(6,10);

        boolean result = SUT.isOverlap(in1,in2);

        assertThat(result, is(true));


    }
    //interval1 contains interval2
    @Test
    public void isOverlap_interval1ContainsInterview2_trueReturned() {
        Interval in1 = new Interval(0,5);
        Interval in2 = new Interval(1,4);

        boolean result = SUT.isOverlap(in1,in2);

        assertThat(result, is(true));


    }
    //interval1 onverlaps interval2 on end
    @Test
    public void isOverlap_interval1OverlapsInterview2OnEnd_falseReturned() {
        Interval in1 = new Interval(0,5);
        Interval in2 = new Interval(6,10);

        boolean result = SUT.isOverlap(in1,in2);

        assertThat(result, is(false));


    }
    //interval1 is after interval2
    @Test
    public void isOverlap_interval1AfterInterview2_falseReturned() {
        Interval in2 = new Interval(0,5);
        Interval in1 = new Interval(6,10);

        boolean result = SUT.isOverlap(in1,in2);

        assertThat(result, is(false));


    }

}