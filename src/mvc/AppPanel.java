package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel  extends JPanel implements ActionListener {
      public Model model;
      public View view;

    public AppPanel() {
        view = new View(model);
        this.setLayout((new GridLayout(1, 2)));
        this.add(view);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("");
        frame.setSize(1000, 650);
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
//                case "Run 1": {
//                    grid.updateLoop(1);
//                }
//                case "Run 50": {
//                    grid.updateLoop(50);
//                }
                case "New": {
                    break;
                }
                case "Open": {

                    break;
                }
//                case "Run": {
////                    mac.execute();
//                    break;
//                }
//                case "Clear": {
//                    mac.clear();
//                    break;
//                }
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

//    class ControlPanel extends JPanel {
//        public ControlPanel() {
//            setBackground(Color.LIGHT_GRAY);
//            JPanel p = new JPanel();
//            p.setBackground(Color.LIGHT_GRAY);
//            add(p);
//        }
//    }

    public static void main(String[] args) {
        AppPanel app = new AppPanel();
    }
}