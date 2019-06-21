package com.learn.junit;

public class IntervalAdjecentDetector {

    public boolean isAdjecent(Interval interval1, Interval interval2){

        int interval1Start = interval1.getStart();
        int interval1End = interval1.getEnd();
        int interval2Start = interval2.getStart();
        int interval2End = interval2.getEnd();
        return (interval1Start < interval1End) && (interval2Start<interval2End)
                && (interval1End < interval2Start);
    }
}
