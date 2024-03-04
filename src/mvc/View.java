package mvc;

import tools.Subscriber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View extends JPanel implements Subscriber {
    private final Model model;
//    private final JList<String> memList = new JList<>();
//    private final JList<String> progList = new JList<>();


    public View(Model model) {
        this.model = model;
        model.subscribe(this);
//        Border blackline = BorderFactory.createLineBorder(Color.black);
//        setBorder(blackline);
//        setBackground(Color.WHITE);
//        setSize(500, 600);
        //now set up memory viewer scrollPane
//        JPanel memPanel = new JPanel();
//        loadMemory();
//        JScrollPane memScrollPane = new JScrollPane(memList);
//        memScrollPane.setPreferredSize(new Dimension(480,325));
//        memPanel.add(memScrollPane);
//        memPanel.setBorder(blackline);
//        add(memPanel);
        //now set up a blank program view panel to be updated later
//        JPanel progPanel = new JPanel();
//        loadProgram("");
//        progList.setPreferredSize(new Dimension(480,225));
//        progPanel.add(progList);
//        progPanel.setBorder(blackline);
//        add(progPanel);

    }

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
//    }

    public void update() {
//        loadMemory();
        repaint();
    }
}