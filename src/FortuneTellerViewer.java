import javax.swing.*;

public class FortuneTellerViewer {

    public static void main(String[] args) {
        JFrame frame = new FortuneTellerFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Fortune Teller");
    }
}
