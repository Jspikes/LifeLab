package LifeLab;

import CALab.GridPanel;

public class VotingLab {
    public static void main (String[] args){
        VotingFactory factory = new VotingFactory();
        GridPanel app = new GridPanel(factory);
    }
}
