package CALab;

import java.util.*;

import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() {
        return dim;
    }

    public int getTime() {
        return time;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }

    public Grid() {
        this(20);
    }

    protected void populate() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j] = makeCell(true);
                cells[i][j].row = i;
                cells[i][j].col = j;
            }
        }
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].neighbors = getNeighbors(cells[i][j], 1);
            }
        }
        notifySubscribers();
    }


    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].reset(randomly);
            }
        }
        notifySubscribers();
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        Set<Cell> neighbors = new HashSet<>();
        int imin = asker.row-radius;
        int imax = asker.row+radius;
        int jmin = asker.col-radius;
        int jmax = asker.col+radius;
//        if (imin < 0) {
//            imin = 0;
//        }
//        if (imax >= dim) {
//            imax = dim - 1;
//        }
//        if (jmin < 0) {
//            jmin = 0;
//        }
//        if (jmax >= dim) {
//            jmax = dim - 1;
//        }
        for (int i = imin; i <= imax; i++) {
            for (int j = jmin; j <= jmax; j++) {
                neighbors.add(cells[Math.floorMod(i, dim)][Math.floorMod(j, dim)]);
            }
        }
        neighbors.remove(asker);
        return neighbors;
    }

    public void observe() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].observe();
            }
        }
        notifySubscribers();
    }

    public void interact() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].interact();
            }
        }
        notifySubscribers();
    }

    public void update() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].update();
            }
        }
        notifySubscribers();
    }

    public void updateLoop(int cycles) {
        observe();
        for (int cycle = 0; cycle < cycles; cycle++) {
            observe();
            interact();
            update();
            time++;
            System.out.println("time = " + time);
        }
    }
}

