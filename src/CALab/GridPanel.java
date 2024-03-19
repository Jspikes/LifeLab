package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import mvc.*;
public class GridPanel extends AppPanel{

    public Grid grid;
    public ControlPanel controls;
    public GridPanel() {
        view = new GridView(grid);
        controls = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("Life");
        frame.setSize(1000, 650);
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"Run 1", "Run 50", "Populate", "Clear"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "Run 1": {
                    grid.updateLoop(1);
                }
                case "Run 50": {
                    grid.updateLoop(50);
                }
                case "New": {
                    break;
                }
                case "Open": {
                    break;
                }
                case "Save": {
                    break;
                }
                case "Quit": {
                    System.exit(0);
                    break;
                }
                case "About": {
                    Utilities.inform("Spikes/Nassimi, 2024. If anyone asks, rights are reserved.");
                    break;
                }
                case "Help": {
                    String[] cmmds = new String[]{
                            "Can I help you?"
                    };
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
    public static void main(String[] args) {
        GridPanel app = new GridPanel();
    }

}
