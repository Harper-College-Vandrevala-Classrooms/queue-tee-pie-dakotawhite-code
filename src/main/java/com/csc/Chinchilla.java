package com.csc;

public class Chinchilla implements Cutie {
    @Override
    public String description() {
        return "A small, soft chinchilla decides to take a nap in your lap.";
    }

    @Override
    public Integer cutenessRating() {
        return 9;
    }
}