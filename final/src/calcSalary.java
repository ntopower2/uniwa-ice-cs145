import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class calcSalary {
    ArrayList<Employee> data;
    int currIndex = 0;

    calcSalary() {
        JFrame frame = new JFrame("Salary Window");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel mainPanel = new JPanel();
        JPanel buttonLabelPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel labelPanel = new JPanel(new GridLayout(10, 1, 1, 1));
        labelPanel.setBorder(BorderFactory.createTitledBorder("Salary Data"));
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 1));
        buttonLabelPanel.add(buttonPanel);

        JPanel overtimePanel = new JPanel();
        JLabel overtimeLabel = new JLabel("Overtime: ");
        JTextField overtimeText = new JTextField();
        JButton overtimeButton = new JButton("Add overtime");
        overtimePanel.add(overtimeLabel);
        overtimePanel.add(overtimeText);

        JButton nextButton = new JButton("Next");
        JButton prevButton = new JButton("Previous");
        buttonPanel.add(nextButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(overtimeButton);

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
        };

        for (JLabel dispLabel : dispLabels) {
            labelPanel.add(dispLabel);
        }

        readSalary(dispLabels);
        mainPanel.add(labelPanel);
        mainPanel.add(buttonPanel);
        labelPanel.add(overtimeLabel);
        labelPanel.add(overtimeText);

        nextButton.addActionListener(e -> {
            if (currIndex >= data.size() - 1) currIndex = 0;
            else currIndex++;
            data.get(currIndex).printLabels(dispLabels);
        });

        prevButton.addActionListener(e -> {
            if (currIndex != 0) currIndex--;
            else currIndex = data.size() - 1;
            data.get(currIndex).printLabels(dispLabels);
        });

        overtimeButton.addActionListener(e -> {
            StringBuilder msg = new StringBuilder();
            try {
                int overtime = Integer.parseInt(overtimeText.getText());
                if (overtime < 0) msg.append("Negative overtime!\n");
                else {
                    Employee currEmployee = data.get(currIndex);
                    currEmployee.setOvertime(overtime);
                    dispLabels[6].setText(Integer.toString(overtime));
                    dispLabels[7].setText(Double.toString(currEmployee.getSalary()));
                }
            } catch (NumberFormatException nfe) {
                msg.append("Cannot parse overtime!\n");
            }
            if (msg.length() != 0) JOptionPane.showMessageDialog(frame, msg);
        });

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    writeData(data);
                    JOptionPane.showMessageDialog(frame, "Written " + data.size() + " lines of salary!");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, "Could not write salary!");
                }
                System.exit(0);
            }
        });
        frame.getContentPane().add(mainPanel);
        frame.setResizable(false);
    }

    private void readSalary(JLabel[] dispLabels) {
//        reads salary data from filename file and displays data
        String row;
        try {
            data = new ArrayList<>(10);
            BufferedReader bufferedReader = new BufferedReader(new FileReader("salaryData.txt"));
            while ((row = bufferedReader.readLine()) != null) {
                data.add(new Employee(row.split("#")));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No salary entries!");
        } catch (IOException e) {
            System.out.println("IO error!");
        } catch (ParseException e) {
            System.out.println("Could not parse basic salary!\n");
        }
        data.get(0).printLabels(dispLabels);
    }

    private void writeData(ArrayList<Employee> d) throws IOException {
//        writes data from data
        File f = new File("salaryDataCalc.txt");
        PrintWriter out;
        if (f.exists() && !f.isDirectory())
            out = new PrintWriter(new FileOutputStream(f, true));
        else out = new PrintWriter("salaryDataCalc.txt");
        StringBuilder c = new StringBuilder();
        for (Employee e : d) c.append(e.toString());
        out.append(c);
        out.close();
    }

    public static void main(String[] args) {
        calcSalary cS = new calcSalary();
    }
}
