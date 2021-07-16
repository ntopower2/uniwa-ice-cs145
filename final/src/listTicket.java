import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;



public class listTicket extends parentFrameTicket{
    ArrayList<String[]> data;
    double totalCost, minCost, maxCost;
    int currPos = 0, ticketNumber;
    JFrame frame2;
    newTicket nT;

    JFrame listTickets(JFrame frame) {
        frame.setTitle("Ticket List");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel mainPanel = new JPanel();
        JPanel buttonLabelPanel = new JPanel(new GridLayout(2,1,10,10));
        JPanel labelPanel = new JPanel(new GridLayout(10, 1, 1, 1));
        labelPanel.setBorder(BorderFactory.createTitledBorder("Ticket Data"));
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10,1));
        JPanel statPanel = new JPanel(new GridLayout(4,1,10,10));
        statPanel.setBorder(BorderFactory.createTitledBorder("Stats"));
        buttonLabelPanel.add(statPanel);
        buttonLabelPanel.add(buttonPanel);

        List ticketID = new List();

//        fields declaration
        JLabel[] dispLabels = {
                new JLabel(""),
                new JLabel(""),
                new JLabel(""),
                new JLabel(""),
                new JLabel(""),
                new JLabel(""),
                new JLabel(""),
                new JLabel(""),
                new JLabel("")
        };

        JLabel[] statLabels = {
                new JLabel(""),
                new JLabel(""),
                new JLabel(""),
                new JLabel("")
        };
        for (JLabel l:statLabels) statPanel.add(l);

        for (int i=0;i<panels.length;i++) {
            labelPanel.add(labels[i]);
            labelPanel.add(dispLabels[i]);
        }

        readTickets(dispLabels);
        for (String[] s:data) ticketID.add(s[0]);
        refreshStats(statLabels);
        labelPanel.add(ticketID);
//        button functionality
        JButton createNewTicket = new JButton("Create ticket");
        JButton refresh = new JButton("Refresh");
        JButton exit = new JButton("Exit");

        ticketID.addActionListener(e -> {
            int index = ticketID.getSelectedIndex();
            assert data != null;
            for (int i=0;i<labels.length;i++) {
                dispLabels[i].setText(data.get(index)[i]);
            }
        });

        createNewTicket.addActionListener(e -> {
            if (frame2==null) {
                frame2 = new JFrame();
                nT = new newTicket();
                nT.createNewTicket(frame2);
            } else {
                frame2.setVisible(true);
            }
        });

        refresh.addActionListener(e -> {
            readTickets(dispLabels);
            ticketID.removeAll();
            for (String[] s:data) ticketID.add(s[0]);
            refreshStats(statLabels);
        });

        exit.addActionListener(e -> frame.dispose());

        buttonPanel.add(refresh);
        buttonPanel.add(createNewTicket);
        buttonPanel.add(exit);

        mainPanel.add(labelPanel);
        mainPanel.add(buttonLabelPanel);
        frame.add(mainPanel);
        frame.setResizable(false);
        return frame;
    }

    private void readTickets(JLabel[] dispLabels) {
//        reads ticket data from filename file and displays data
        String row; ticketNumber=0; totalCost=0; minCost=0;maxCost=0;
        try {
            data = new ArrayList<>(10);
            BufferedReader bufferedReader = new BufferedReader(new FileReader("ticketData.txt"));
            while ((row = bufferedReader.readLine()) != null) {
                data.add(row.split(";"));
                totalCost+= Double.parseDouble(data.get(ticketNumber++)[4]);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No tickets yet!");
        } catch (IOException e) {
            System.out.println("IO error!");
        }
        data.sort(Comparator.comparing(o -> Double.parseDouble(o[4])));
        if (!data.isEmpty()) {
            minCost = Double.parseDouble(data.get(0)[4]);
            maxCost = Double.parseDouble(data.get(ticketNumber-1)[4]);
        }
        for (int i=0;i<this.labels.length && !data.isEmpty();i++) dispLabels[i].setText(data.get(0)[i]);
        currPos=1;
    }

    private void refreshStats(JLabel[] statLabels) {
//        refreshes statistical data
        statLabels[0].setText(String.format("Total cost: %.2f",totalCost));
        statLabels[1].setText("Total number: "+ticketNumber);
        statLabels[2].setText(String.format("Min cost: %.2f", minCost));
        statLabels[3].setText("Max cost: "+maxCost);
    }

    public static void main(String[] args) {
        listTicket lT = new listTicket();
        JFrame f = new JFrame();
        lT.listTickets(f);
    }
}
