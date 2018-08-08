package com.designpattern.thothDemo;

public class ThothLeagueCreateResponse implements IThothResponse<ThothLeagueValidator> {
    @Override
    public void accept(ThothLeagueValidator thothLeagueValidator) {
        thothLeagueValidator.validate(this);
    }
}
