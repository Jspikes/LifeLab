package LifeLab;

import CALab.GridPanel;

public class LifeLab {
    public static void main (String[] args){
        LifeFactory factory = new LifeFactory();
        GridPanel app = new GridPanel(factory);
    }
}
