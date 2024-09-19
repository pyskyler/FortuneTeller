import javax.swing.*;
import java.awt.*;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPanel = new JPanel();

    public FortuneTellerFrame() {

        mainPanel.setLayout(new BorderLayout());

        topPanel();
        middlePanel();
        bottomPanel();

        add(mainPanel);
    }

    private void topPanel() {

        ImageIcon headerImageIcon = new ImageIcon("resources/crystal-ball.jpg");
        Image headerImageUnscaled = headerImageIcon.getImage();
        Image headerImage = headerImageUnscaled.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        headerImageIcon.setImage(headerImage);

        JLabel titleLabel = new JLabel("Fortune Teller", headerImageIcon, JLabel.CENTER);

        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        titleLabel.setFont(new Font("Papyrus", Font.BOLD, 36));

        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);

        mainPanel.add(topPanel, BorderLayout.NORTH);

    }

    private void middlePanel() {

        JTextArea fortuneTextArea = new JTextArea(10, 30);
        fortuneTextArea.setLineWrap(true);
        fortuneTextArea.setWrapStyleWord(true);
        fortuneTextArea.setEditable(false);
        fortuneTextArea.setFont(new Font("Avenir", Font.PLAIN, 16));

        JScrollPane fortuneScrollPane = new JScrollPane(fortuneTextArea);

        JPanel middlePanel = new JPanel();
        middlePanel.add(fortuneScrollPane);

        mainPanel.add(middlePanel, BorderLayout.CENTER);

    }

    private void bottomPanel() {

            JButton fortuneButton = new JButton("Read My Fortune!");
            fortuneButton.setFont(new Font("Calibri", Font.BOLD, 24));

            JButton quitButton = new JButton("Quit");
            quitButton.setFont(new Font("Calibri", Font.BOLD, 24));

            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new GridLayout(1, 2));
            bottomPanel.add(fortuneButton);
            bottomPanel.add(quitButton);

            mainPanel.add(bottomPanel, BorderLayout.SOUTH);

    }

}
