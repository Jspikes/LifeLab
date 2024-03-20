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
            if(a.getStatus() == status) {
                ambience++;
            }
        }
    }

    @Override
    public void update() {
        if(ambience <= neighbors.size()/2){nextState();}
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
        if(status == 1) {return Color.BLUE;}
        else {return Color.RED;}
    }

    @Override
    public int getStatus() {
        return status;
    }
}
