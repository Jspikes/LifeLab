package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
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
        populate(false);
    }

    public Grid() {
        this(20);
    }

    protected void populate(boolean randomly) {
        // 1. use makeCell to fill in cells
        // 2. use getNeighbors to set the neighbors field of each cell
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j] = makeCell(!randomly);
            }
        }
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].neighbors = getNeighbors(cells[i][j], 1);
            }
        }
    }


        // called when Populate button is clicked
        public void repopulate (boolean randomly){
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    cells[i][j].reset(randomly);
                }
            }
            // randomly set the status of each cell or set status of all cells to 0
            notifySubscribers();
            // notify subscribers
        }



        public Set<Cell> getNeighbors (Cell asker,int radius){
            Set<Cell> neighbors = new HashSet<>();
            int imin = asker.row - radius;
            int imax = asker.row + radius;
            int jmin = asker.col - radius;
            int jmax = asker.col + radius;
            if (imin < 0) {
                imin = 0;
            }
            if (imax >= dim) {
                imax = dim;
            }
            if (jmin < 0) {
                jmin = 0;
            }
            if (jmax >= dim) {
                jmax = dim;
            }
            for (int i = imin; i < imax; i++) {
                for (int j = jmin; j <= jmax; j++) {
                    neighbors.add(cells[i][j]);
                }
            }
            neighbors.remove(asker);
            return neighbors;
        }

        // override these

        // cell phases:

        public void observe () {
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    cells[i][j].observe();
                }
            }
            notifySubscribers();
        }

        public void interact () {
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    cells[i][j].interact();
                }
            }
            notifySubscribers();
        }

        public void update () {
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    cells[i][j].update();
                }
            }
            notifySubscribers();
        }

        public void updateLoop ( int cycles){
            observe();
            for (int cycle = 0; cycle < cycles; cycle++) {
                interact();
                update();
                observe();
                time++;
                System.out.println("time = " + time);
            }
        }
    }

