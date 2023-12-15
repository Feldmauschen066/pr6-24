import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonCounter extends JFrame {

    private int count = 0;
    private JLabel countLabel;

    public ButtonCounter() {
        setTitle("Button Counter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button = new JButton("Нажми меня!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                countLabel.setText("Количество нажатий: " + count);
            }
        });
        panel.add(button);

        countLabel = new JLabel("Количество нажатий: " + count);
        panel.add(countLabel);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonCounter().setVisible(true);
            }
        });
    }
}