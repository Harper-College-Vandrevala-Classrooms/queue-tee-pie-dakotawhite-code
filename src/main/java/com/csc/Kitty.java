package com.csc;

public class Kitty implements Cutie {
    @Override
    public String description() {
        return "A fluffy kitten playing with a ball.";
    }

    @Override
    public Integer cutenessRating() {
        return 10;
    }
}