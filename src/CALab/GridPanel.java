package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import mvc.*;
public class GridPanel extends AppPanel{

    public static GridFactory factory;
    ControlPanel controls;
    public Grid grid;

    public GridPanel(AppFactory factory) {
        super(factory);
        grid = (Grid) model;
        controls = new ControlPanel();
        this.add(controls, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "Save": {
                    Utilities.inform("It is now safe to power down your grid.");
                    break;
                }
                case "RUN1": {
                    RunCommand command = new RunCommand(1);
                    command.execute(grid);
                    break;
                }
                case "RUN50": {
                    RunCommand command = new RunCommand(50);
                    command.execute(grid);
                    break;
                }
                case "POPULATE": {
                    PopulateCommand command = new PopulateCommand(true);
                    command.execute(grid);
                    break;
                }
                case "New", "Open", "CLEAR": {
                    ClearCommand command = new ClearCommand();
                    command.execute(grid);
                    break;
                }
                case "Quit": {
                    System.exit(0);
                    break;
                }
                case "About": {
                    Utilities.inform(factory.about());
                    break;
                }
                case "Help": {
                    String[] cmmds = factory.getHelp();
                    Utilities.inform(cmmds);
                    break;
                }
                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }

        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }
    class ControlPanel extends JPanel {
        public ControlPanel() {
            setBackground(Color.LIGHT_GRAY);
            JPanel p = new JPanel();
            p.setBackground(Color.LIGHT_GRAY);
            add(p);
            p.setLayout(new GridLayout(2, 2, 300, 200));
            JButton run1 = new JButton("RUN1");
            JButton run50 = new JButton("RUN50");
            JButton populate = new JButton("POPULATE");
            JButton clear = new JButton("CLEAR");
            run1.addActionListener(GridPanel.this);
            run50.addActionListener(GridPanel.this);
            populate.addActionListener(GridPanel.this);
            clear.addActionListener(GridPanel.this);
            p.add(run1);
            p.add(run50);
            p.add(populate);
            p.add(clear);
        }
    }
//    public static void main(String[] args) {
//        GridPanel grid = new GridPanel(factory);
//    }

}
