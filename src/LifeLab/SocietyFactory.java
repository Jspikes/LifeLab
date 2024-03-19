package LifeLab;

import CALab.GridFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class SocietyFactory extends GridFactory {

    @Override
    public Society makeModel() {
        return new Society();
    }
}
