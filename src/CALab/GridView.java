package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView extends View {

    private CellView[][] cellViews;
    private int dim;

    private Grid grid;

    public GridView(Grid grid) {
        super(grid);
        this.grid = grid;
        dim = grid.dim;
        cellViews = new CellView[dim][dim];
        this.setLayout((new GridLayout(dim,dim)));
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                Cell cell = grid.getCell(i, j);
                CellView cellView = new CellView();
                cellViews[i][j] = cellView;
                cell.row = i;
                cell.col = j;
                this.add(cellView);
            }
        }
    }

    public void update(){
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cellViews[i][j].update();
            }
        }
    }
}
