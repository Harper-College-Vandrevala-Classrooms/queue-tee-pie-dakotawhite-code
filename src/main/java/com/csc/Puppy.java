package com.csc;

public class Puppy implements Cutie {
    @Override
    public String description() {
        return "A little puppy with big, sad eyes.";
    }

    @Override
    public Integer cutenessRating() {
        return 11;  // Return a cuteness rating (could be dynamic in a more advanced version)
    }
}
