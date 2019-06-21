package com.learn.junit;

class Interval {

    private final int mStart;
    private final int mEnd;

    public Interval(int mStart, int mEnd) {

        if(mStart>=mEnd){
            throw new IllegalArgumentException("invalid interval range");
        }
        this.mStart = mStart;
        this.mEnd = mEnd;
    }

    public int getStart() {
        return mStart;
    }

    public int getEnd() {
        return mEnd;
    }
}
