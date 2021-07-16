import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class newTicket extends parentFrameTicket{
    JFrame createNewTicket(JFrame frame) {
        frame.setTitle("Create a Ticket");
        JPanel mainPanel = new JPanel(new GridLayout(10, 1, 1, 1));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//        text fields declaration
        TextField[] textFields = {
                new TextField(),
                new TextField(),
                new TextField(),
                new TextField(),
                new TextField(),
                new TextField(),
                new TextField(),
                new TextField(),
                new TextField()
        };

        for (int i=0;i<panels.length;i++) {
            panels[i].add(labels[i]);
            panels[i].add(textFields[i]);
            mainPanel.add(panels[i]);
        }
//        button functionality
        JButton saveTicket = new JButton("Save Ticket");
        saveTicket.addActionListener(e -> {
            StringBuilder msg = new StringBuilder();
//            checking fields' text length
            for (int i=0; i<panels.length;i++)
                if (textFields[i].getText().length() > 18)
                    msg.append(labels[i].getText()).append(" too long!\n");
                else if (textFields[i].getText().isEmpty())
                    msg.append(labels[i].getText()).append(" empty!\n");
//                checking price field value
            try {
                double price = Double.parseDouble(textFields[4].getText());
                if (price<0) msg.append("Negative ticket price!\n");
            } catch (NumberFormatException nfe) {
                msg.append("Cannot parse ticket price!\n");
            }
//            checking luggage field value
            try {
                int luggage = Integer.parseInt(textFields[5].getText());
                if (luggage<0) msg.append("Negative number of luggage!\n");
            } catch (NumberFormatException nfe) {
                msg.append("Cannot parse number of luggage!\n");
            }
//            complete list of errors as a message
            if (msg.length()!=0) JOptionPane.showMessageDialog(frame, msg);
            else {
                try {
                    writeTicket(textFields);
                    frame.dispose();
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(frame, "IO error!");
                }
            }
        });
        mainPanel.add(saveTicket);

        frame.getContentPane().add(mainPanel);
        frame.setResizable(false);
        return frame;
    }

    private void writeTicket(TextField[] ticketData) throws IOException {
//        writes data from TextFields
        File f = new File("ticketData.txt");
        PrintWriter out;
        if (f.exists() && !f.isDirectory())
            out = new PrintWriter(new FileOutputStream(f, true));
        else out = new PrintWriter("ticketData.txt");
        StringBuilder c= new StringBuilder();
        for (TextField t:ticketData) c.append(t.getText()).append(";");
        c.append("\n");
        out.append(c);
        out.close();
        System.out.println("Successfully written ticket id: "+ ticketData[0].getText());
        for (TextField t:ticketData) t.setText("");
    }

    public static void main(String[] args) {
        newTicket nT = new newTicket();
        JFrame f = new JFrame();
        nT.createNewTicket(f);
    }
}
