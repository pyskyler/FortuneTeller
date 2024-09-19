import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPanel = new JPanel();
    JTextArea fortuneTextArea;
    int lastFortune = -1;

    public FortuneTellerFrame() {

        centerFrame();

        mainPanel.setLayout(new BorderLayout());

        topPanel();
        middlePanel();
        bottomPanel();

        add(mainPanel);
    }

    private void centerFrame() {
        // get screen dimensions

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // center frame in screen

        setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
        setLocation(screenWidth / 8, screenHeight / 8);
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

        fortuneTextArea = new JTextArea(10, 30);
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
        fortuneButton.addActionListener(e -> {
            String fortune = getFortune();
            fortuneTextArea.append(fortune + "\n");
        });

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Calibri", Font.BOLD, 24));
        quitButton.addActionListener(e -> System.exit(0));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));
        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

    }

    private String getFortune() {
        ArrayList<String> fortunes = new ArrayList<>();

        final int FORTUNES = 12;
        int fortune;

        fortunes.add("Your future is as bright as Charlie's optimism. Keep smiling!");
        fortunes.add("Expect a surprise visit from a friend. Just hope it's not Alastor!");
        fortunes.add("You'll find success in your next venture, just like Blitzø's latest scheme.");
        fortunes.add("A new opportunity is on the horizon. Embrace it with Vaggie's determination.");
        fortunes.add("Someone close to you has a secret. Channel your inner Angel Dust to uncover it.");
        fortunes.add("A little chaos is coming your way. Handle it with Stolas's grace.");
        fortunes.add("You'll soon be the center of attention. Just like Cherri Bomb at a party!");
        fortunes.add("A small act of kindness will go a long way. Think of Niffty and her helpful nature.");
        fortunes.add("Your creativity will shine through. Just like Moxxie's musical talents.");
        fortunes.add("A challenge is approaching. Face it with Millie's fierce spirit.");
        fortunes.add("You'll have a chance to mend a broken relationship. Take a cue from Loona's softer side.");
        fortunes.add("An unexpected journey awaits you. Navigate it with Husk's resilience.");

        Random random = new Random();

        if (lastFortune != -1) {
            // Generate the next fortune, but make sure it's not the same as the last one
            // Do this by generating a number between 0 and FORTUNES-2
            // If that fortune is the same or greater than the last fortune, add 1 to it to skip the last fortune
            fortune = random.nextInt(0, FORTUNES - 1);
            if (fortune >= lastFortune) {
                fortune++;
            }
        } else {
            fortune = random.nextInt(0, FORTUNES);
        }

        lastFortune = fortune;
        return fortunes.get(fortune);
    }
}
