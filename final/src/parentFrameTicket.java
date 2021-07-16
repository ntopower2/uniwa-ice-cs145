import javax.swing.*;
import java.awt.*;

public class parentFrameTicket extends Frame{
    public JLabel[] labels = {
            new JLabel("Ticket Id"),
            new JLabel("Issue Date"),
            new JLabel("Client Name"),
            new JLabel("Itinerary"),
            new JLabel("Ticket Cost"),
            new JLabel("Luggage"),
            new JLabel("Plane"),
            new JLabel("Airline"),
            new JLabel("Nationality")
    };
    public JPanel[] panels = {
            new JPanel(new GridLayout(1, 20, 10, 1)),
            new JPanel(new GridLayout(1, 20, 10, 1)),
            new JPanel(new GridLayout(1, 20, 10, 1)),
            new JPanel(new GridLayout(1, 20, 10, 1)),
            new JPanel(new GridLayout(1, 20, 10, 1)),
            new JPanel(new GridLayout(1, 20, 10, 1)),
            new JPanel(new GridLayout(1, 20, 10, 1)),
            new JPanel(new GridLayout(1, 20, 10, 1)),
            new JPanel(new GridLayout(1, 20, 10, 1))
    };

    public parentFrameTicket() throws HeadlessException {
        Font font = new Font("Serif", Font.BOLD, 13);
        for(JLabel l:labels) l.setFont(font);
    }
}

class MyCanvas extends Canvas {
    String filename;
    MyCanvas(String filename) {
        this.filename = filename;
    }
    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage(filename);
        g.drawImage(i, 1, 1, this);
    }
}
