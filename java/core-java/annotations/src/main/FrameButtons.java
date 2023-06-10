import javax.swing.*;
import java.awt.*;

public class FrameButtons extends JFrame {
    private static final int WIDTH_DEFAULT = 300;
    private static final int HEIGHT_DEFAULT = 300;

    private JPanel leaf;
    private JButton buttonYellow;
    private JButton buttonBlue;
    private JButton buttonRed;

    public FrameButtons() {
        setTitle("TestButtons");
        setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
        leaf = new JPanel();
        add(leaf);

        buttonYellow = new JButton("Yellow");
        buttonBlue = new JButton("Blue");
        buttonRed = new JButton("Red");

        leaf.add(buttonYellow);
        leaf.add(buttonBlue);
        leaf.add(buttonRed);
    }

    @ActionListener(origin="buttonYellow")
    public void backgroundYellow() {
        leaf.setBackground(Color.YELLOW);
    }

    @ActionListener(origin="buttonBlue")
    public void backgroundBlue() {
        leaf.setBackground(Color.BLUE);
    }

    @ActionListener(origin="buttonRed")
    public void backgroundRed() {
        leaf.setBackground(Color.RED);
    }
}
