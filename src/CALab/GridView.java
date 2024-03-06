package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView  extends View {

    private CellView cellViews[][];
    private int dim;

    public GridView(Model model) {
        Grid grid = (Grid) model;
        dim = grid.dim;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                Cell cell = grid.getCell(i, j);
                CellView cellView = new CellView();
                cellViews[i][j] = cellView;
                cell.row = i;
                cell.col = j;
            }
        }
    }

    public void update(String msg, Object oldState, Object newState) {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cellViews[i][j].update(msg, oldState, newState);
            }
        }
    }
}