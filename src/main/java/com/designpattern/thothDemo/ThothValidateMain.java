package com.designpattern.thothDemo;

public class ThothValidateMain {
    public static void main(String[] args) {
        IThothResponse response1 = new ThothLeagueCreateResponse();
        IThothResponse response2 = new ThothMatchEndResponse();
        IThothValidator validator = new ThothLeagueValidator();
        response1.accept(validator); // ThothLeagueCreateResponse validate
        response2.accept(validator); // ThothMatchEndResponse validate
    }
}
