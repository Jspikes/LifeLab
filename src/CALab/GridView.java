package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];
    private int dim;

    private Grid grid;

    public GridView(Grid grid) {
        super(grid);
        this.grid = grid;
        dim = grid.dim;
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


    // now set up memory viewer scrollPane
//        JPanel memPanel = new JPanel();
//        loadMemory();
//        JScrollPane memScrollPane = new JScrollPane(memList);
//        memScrollPane.setPreferredSize(new Dimension(480,325));
//        memPanel.add(memScrollPane);
//        memPanel.setBorder(blackline);
//        add(memPanel);
//        now set up a blank program view panel to be updated later
//        JPanel progPanel = new JPanel();
//        loadProgram("");
//        progList.setPreferredSize(new Dimension(480,225));
//        progPanel.add(progList);
//        progPanel.setBorder(blackline);
//        add(progPanel);

//}

//    private void loadMemory(){
//        String[] mem = new String[32];
//        for (int i = 0; i < 32; i++) {mem[i] = "Memory[" + i + "] = " + mac.memory[i];}
//        DefaultListModel<String> newListModel = new DefaultListModel<>();
//        for (int i = 0; i < 32; i++) {newListModel.addElement(mem[i]);}
//        memList.setModel(newListModel);
//    }

//    public void loadProgram(String program){
//        String[] progLines = program.split("\\R");
//        DefaultListModel<String> newListModel = new DefaultListModel<>();
//        for (int i = 0; i < progLines.length; i++) {newListModel.addElement(progLines[i]);}
//        if(newListModel.get(0).isEmpty()) {newListModel.addElement("No program parsed.");}
//        progList.setModel(newListModel);
//        repaint();
//

    public void update(){
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cellViews[i][j].update();
            }
        }
    }
}
