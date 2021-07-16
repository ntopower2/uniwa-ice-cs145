import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class exec42 extends Frame implements ActionListener{
    Character[] characters = new Character[]{
            '7','8','9','+','4','5','6','-','1','2','3','*','0','.','=','/'
    };

    Button[] buttons = new Button[characters.length];
    Label label = new Label("");
    int x,y;
    String a, b, op;
    exec42() {
        for (int i=0;i<characters.length;i++) {
            buttons[i] = new Button(characters[i].toString());
            x = 10+(i%4)*40;
            y = 80+(i/4)*40;
            buttons[i].setBounds(x,y, 40,40);
            buttons[i].setFont(new Font("Consolas", Font.ITALIC, 17));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        label.setBounds(10, 50, 160, 20);
        label.setFont(new Font("Consolas", Font.ITALIC, 17));
        add(label);
        setSize(170, 240);
        setLayout(null);
        setVisible(true);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        int index = 0;
        for (int i = 0; i < buttons.length; i++)
            if (buttons[i] == e.getSource()) {
                index = i;
            }

        try {
            if (index != 3 && index != 7 && index != 11 && index!=13 &&
                    index != 14 && index != 15 && !label.getText().startsWith("Empty"))
                label.setText(label.getText() + characters[index]);
            else if (index == 3) {
                a = label.getText();
                op = "+";
                label.setText("");
            } else if (index == 7) {
                a = label.getText();
                op = "-";
                label.setText("");
            } else if (index == 11) {
                a = label.getText();
                op = "*";
                label.setText("");
            } else if (index == 13) {
                if (!label.getText().contains("."))
                    label.setText(label.getText()+".");
            } else if (index == 14) {
                b = label.getText();
                float num;
                switch (op) {
                    case "+":
                        num = Float.parseFloat(a) + Float.parseFloat(b);
                        label.setText(String.valueOf(num));
                        break;
                    case "-":
                        num =Float.parseFloat(a) - Float.parseFloat(b);
                        label.setText(String.valueOf(num));
                        break;
                    case "*":
                        num =Float.parseFloat(a) * Float.parseFloat(b);
                        label.setText(String.valueOf(num));
                        break;
                    case "/":
                        num =Float.parseFloat(a) / Float.parseFloat(b);
                        label.setText(String.valueOf(num));
                        break;
                }
            } else {
                a = label.getText();
                op = "/";
                label.setText("");
            }
        } catch (NumberFormatException f) {
            label.setText("Empty/Incorrect number");
        }

    }

    public static void main(String[] args) {
        exec42 f = new exec42();
    }
}