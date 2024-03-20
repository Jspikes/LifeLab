package LifeLab;

import CALab.*;

import java.util.*;

public class Society extends Grid {
    public static Set<Integer> rebirth = new HashSet<Integer>();
    public static Set<Integer> death = new HashSet<Integer>();
    public static int percentAlive = 50;

    static {
        rebirth.add(3);
        death.add(0);
        death.add(1);
        death.add(4);
        death.add(5);
        death.add(6);
        death.add(7);
        death.add(8);
    }

    public Agent makeCell(boolean uniform) {
        Agent agent = new Agent();

        if (!uniform) {
            int d100 = (int) Math.round(Math.random() * 100);
            if (d100 < percentAlive) {
                agent.status = 1;
                agent.myGrid = this;
                return agent;
            }
        }

        agent.status = 0;
        agent.myGrid = this;
        return agent;
    }

}
