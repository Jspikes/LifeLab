package LifeLab;

import CALab.GridFactory;

public class LifeFactory extends GridFactory {

    @Override
    public Society makeModel() {
        return new Society();
    }
}
