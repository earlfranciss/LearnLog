package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setLayout(new FlowLayout());
        panel1.add(new JLabel("Panel 1"));

        JButton switchToPanel2Button = new JButton("Switch to Panel 2");
        switchToPanel2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "Panel 2");
            }
        });
        panel1.add(switchToPanel2Button);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.GREEN);
        panel2.setLayout(new FlowLayout());
        panel2.add(new JLabel("Panel 2"));

        JButton switchToPanel1Button = new JButton("Switch to Panel 1");
        switchToPanel1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "Panel 1");
            }
        });
        panel2.add(switchToPanel1Button);

        JButton switchToPanel3Button = new JButton("Switch to Panel 3");
        switchToPanel3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "Panel 3");
            }
        });
        panel2.add(switchToPanel3Button);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.BLUE);
        panel3.setLayout(new FlowLayout());
        panel3.add(new JLabel("Panel 3"));

        JButton switchToPanel2ButtonFromPanel3 = new JButton("Switch to Panel 2");
        switchToPanel2ButtonFromPanel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
                cardLayout.show(frame.getContentPane(), "Panel 2");
            }
        });
        panel3.add(switchToPanel2ButtonFromPanel3);

        frame.add(panel1, "Panel 1");
        frame.add(panel2, "Panel 2");
        frame.add(panel3, "Panel 3");

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

