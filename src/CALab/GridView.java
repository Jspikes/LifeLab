package CALab;

import mvc.*;

import java.awt.*;

public class GridView extends View {

    private CellView[][] cellViews;
    private int dim;

    public GridView(Grid grid) {
        super(grid);
        dim = grid.dim;
        cellViews = new CellView[dim][dim];
        this.setLayout((new GridLayout(dim, dim)));
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                Cell cell = grid.getCell(i, j);
                CellView cellView = new CellView(cell);
                cellViews[i][j] = cellView;
                cell.row = i;
                cell.col = j;
                this.add(cellView);
            }
        }
        update();
    }

    public void update() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cellViews[i][j].update();
            }
        }
        repaint();
    }
}
