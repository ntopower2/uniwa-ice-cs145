import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Employee {
    private String fName;
    private String lName;
    private double base;
    private String job;
    private int start;
    private int ymo;
    private int overtime;
    private double salary;

    public Employee(String fName, String lName, double base, String job, int start, int ymo) {
        this.fName = fName;
        this.lName = lName;
        this.base = base;
        this.job = job;
        this.start = start;
        this.ymo = ymo;
    }

    public Employee(String @NotNull [] s) throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        assert s.length == 6;
        this.fName = s[0];
        this.lName = s[1];
        this.base = format.parse(s[2]).doubleValue();
        this.job  = s[3];
        this.start = Integer.parseInt(s[4]);
        this.ymo = Integer.parseInt(s[5]);
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
        calcSalary();
    }

    public double getSalary() {
        return salary;
    }

    public void calcSalary() {
        if (job.equals("Καθηγητής") || job.equals("ΕΔΙΠ") || job.equals("Λέκτορας")
                || job.equals("Αναπληρωτής") || job.equals("Επίκουρος"))
            salary = base + (overtime*base*1.5/ymo);
        else salary = base + (overtime*base*1.6/ymo);
    }

    public void printLabels(JLabel[] labels) {
        assert labels.length == 8;
        labels[0].setText(fName);
        labels[1].setText(lName);
        labels[2].setText(String.valueOf(base));
        labels[3].setText(job);
        labels[4].setText(String.valueOf(start));
        labels[5].setText(String.valueOf(ymo));
        labels[6].setText(String.valueOf(overtime));
        labels[7].setText(String.valueOf(salary));
    }

    @Override
    public String toString() {
        return fName + '#' + lName + '#' + base + '#'+job + '#' + '#' +
                start +'#'+ overtime+'#'+salary +"\n";
    }
}
