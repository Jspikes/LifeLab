package LifeLab;

import CALab.*;

import java.awt.*;

public class Agent extends Cell {

    public int status = 0;
    public int ambience = 8;

    @Override
    public void observe() {
        ambience = 0;
        for(Cell a: neighbors)
        {
            ambience += a.getStatus();
        }
    }

    @Override
    public void update() {
        if(Society.rebirth.contains(ambience)) {status = 1;}
        if(Society.death.contains(ambience)) {status = 0;}
    }
    @Override
    public void interact() {}
    @Override
    public void nextState() {
        status ^= 1;
    }

    @Override
    public void reset(boolean randomly) {
        if(randomly) {
            status = (int) Math.round(Math.random());
        }
        else {status = 0;}
    }

    @Override
    public Color getColor() {
        if(status == 1) {return Color.GREEN;}
        else {return Color.RED;}
    }

    @Override
    public int getStatus() {
        return status;
    }
}
