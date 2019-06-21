package com.learn.junit;

public class IntervalOverlapDetector {

    public boolean isOverlap(Interval in1, Interval in2) {


        return in1.getEnd() > in2.getStart() && in1.getStart() < in2.getEnd();
    }
}
