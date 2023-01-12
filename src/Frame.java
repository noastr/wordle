import javax.swing.*;

public class Frame extends JFrame {
    public static void main(String[] args) {
        Frame frame = new Frame();
    }

    public Frame() {
        this.setVisible(true);
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(new ImageIcon("ressources/img_Johan.jpg"));
        this.setBounds(100, 100, 700, 500);
        this.add(label);
    }
}