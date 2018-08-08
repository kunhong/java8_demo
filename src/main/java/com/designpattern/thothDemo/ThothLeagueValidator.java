package com.designpattern.thothDemo;

public class ThothLeagueValidator implements IThothValidator {
    public void validate(ThothLeagueCreateResponse response) {
        System.out.println("ThothLeagueCreateResponse validate");
    }

    public void validate(ThothMatchEndResponse response) {
        System.out.println("ThothMatchEndResponse validate");
    }
}
