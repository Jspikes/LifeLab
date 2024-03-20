package mvc;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View extends JPanel implements Subscriber {
    public Model model;

    public View(Model model) {
        this.model = model;
        model.subscribe(this);
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackline);
        setBackground(Color.WHITE);
        setSize(500, 600);
    }

    public void update() {
        repaint();
    }
}