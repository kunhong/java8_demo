package com.designpattern.thothDemo;

public class ThothMatchEndResponse implements IThothResponse<ThothLeagueValidator> {
    @Override
    public void accept(ThothLeagueValidator thothLeagueValidator) {
        thothLeagueValidator.validate(this);
    }
}
