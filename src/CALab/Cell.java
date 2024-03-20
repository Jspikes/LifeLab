package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Cell extends Publisher implements Serializable {

    protected int row = 0, col = 0;
    protected Set<Cell> neighbors = new HashSet<>();
    public Grid myGrid = null;
    public Cell partner = null;

    // choose a random neighbor as a partner
    public void choosePartner() {
        if (partner == null && neighbors != null) {
            Cell[] partnerOptions = neighbors.toArray(new Cell[0]);
            int randomStart = (int) Math.round(Math.random() * (partnerOptions.length + 1));
            for (int i = randomStart; i < partnerOptions.length; i++) {
                if(partnerOptions[i].partner == null) {
                    partner = partnerOptions[i];
                    partnerOptions[i].partner = this;
                    return;
                }
            }
            for (int i = 0; i < randomStart; i++) {
                if(partnerOptions[i].partner == null) {
                    partner = partnerOptions[i];
                    partnerOptions[i].partner = this;
                    return;
                }
            }
        }

    }
    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }

    // observer neighbors' states
    public abstract void observe();
    // interact with a random neighbor
    public abstract void interact();
    // update my state
    public abstract void update();
    // set status to status + 1 mod whatever
    public abstract void nextState();
    // set status to a random or initial value
    public abstract void reset(boolean randomly);
    public int getStatus() { return 0; }
    public Color getColor() { return Color.GREEN; }
}