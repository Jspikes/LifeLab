package LifeLab;

import CALab.GridFactory;

public class VotingFactory extends GridFactory {

    @Override
    public Society makeModel() {
        return new Society();
    }
}
