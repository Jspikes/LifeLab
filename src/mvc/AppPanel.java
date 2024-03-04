package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel  extends JPanel implements ActionListener {
      private final Model model;
      private final ControlPanel controls;
      private final View view;

    public AppPanel() {
        model = new Model();
        view = new View(model);
        controls = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("MiniMac");
        frame.setSize(1000, 650);
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"Parse", "Run", "Clear"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
//                case "Parse": {
//                    String fName = Utilities.getFileName(System.getProperty("user.home"), true);
//                    File file = new File(fName);
//                    String fString = Files.readString(file.toPath(), Charset.defaultCharset());
//                    mac.program = (ArrayList<Instruction>) MiniMacParser.parse(fString);
//                    view.loadProgram(fString);
//                    break;
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
                    Utilities.inform("Sorry, but your file is in another castle.");
                    break;
                }

                case "Quit": {
                    System.exit(0);
                    break;
                }

                case "About": {
                    Utilities.inform("Spikes Softworks, 2024. All seals observed.");
                    break;
                }

                case "Help": {
                    String[] cmmds = new String[]{
                            "Parse: reads a file as a list of MiniMac commands",
                            "Run: executes a parsed program",
                            "Clear: clears MiniMac memory, setting all values to 0"
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
//            p.setLayout(new GridLayout(3,0,300,200));
//            JButton parse = new JButton("Parse");
//            JButton run = new JButton("Run");
//            JButton clear = new JButton("Clear");
//            parse.addActionListener(AppPanel.this);
//            run.addActionListener(AppPanel.this);
//            clear.addActionListener(AppPanel.this);
//            p.add(parse);
//            p.add(run);
//            p.add(clear);
            add(p);
        }
    }

    public static void main(String[] args) {
        AppPanel app = new AppPanel();
    }
}