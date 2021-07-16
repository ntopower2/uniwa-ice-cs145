import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class aboutWindow extends Frame {
    boolean imageOpened = false;
    JFrame createAboutWindow(JFrame frame) {
        frame.setTitle("About");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font font = new Font("Serif", Font.PLAIN, 19);
        JPanel mainPanel = new JPanel(new GridLayout(5,1,1,5));
        JLabel[] labels = {
                new JLabel("Name: Ticket Ledger"),
                new JLabel("Author: Victor Lebaut"),
                new JLabel("AM: ice18390300"),
                new JLabel("Date: 11/06/2021")
        };
        for (JLabel l:labels) {
            l.setFont(font);
            mainPanel.add(l);
        }
        MyCanvas m = new MyCanvas("small.png");
        JDialog d = new JDialog();
        MyCanvas m2 = new MyCanvas("screenshot.png");
        d.add(m2);
        d.setTitle("Full res screenshot");
        d.setSize(1010, 970);
        d.setResizable(false);

        m.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                d.setVisible(!imageOpened);
                imageOpened=!imageOpened;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        mainPanel.add(m);
        frame.add(mainPanel);
        return frame;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        aboutWindow aW = new aboutWindow();
        aW.createAboutWindow(f);
    }
}
