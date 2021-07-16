import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class exec41 extends Frame {
    exec41() {
        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        Button addButton = new Button("Add");
        Button subButton = new Button("Substract");
        Button clrButton = new Button("Clear");
        Button mulButton = new Button("Multiply");
        Button divButton = new Button("Divide");
        Label label = new Label("Answer goes here");

        txt1.setBounds(20, 35, 120,30);
        txt2.setBounds(150, 35, 120,30);
        addButton.setBounds(20, 70, 80, 30);
        subButton.setBounds(110,70, 80, 30);
        clrButton.setBounds(200,70, 80, 30);
        divButton.setBounds(200,105, 80, 30);
        mulButton.setBounds(20,105, 80, 30);
        label.setBounds(80, 140, 200,20);
        add(txt1);
        add(txt2);
        add(addButton);
        add(subButton);
        add(clrButton);
        add(mulButton);
        add(divButton);
        add(label);
        setFont(new Font("Consolas", Font.ITALIC, 17));
        setSize(310, 170);
        setLayout(null);
        setVisible(true);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
        addButton.addActionListener(e -> {
            try {
                int res = Integer.parseInt(txt1.getText())+Integer.parseInt(txt2.getText());
                label.setText(txt1.getText()+"+"+txt2.getText()+"="+ res);
            } catch (NumberFormatException nfe) {
                label.setText("Empty/Incorrect number");
            }
        });
        subButton.addActionListener(e -> {
            try {
                int res = Integer.parseInt(txt1.getText()) - Integer.parseInt(txt2.getText());
                label.setText(txt1.getText() + "-" + txt2.getText() + "=" + res);
            } catch (NumberFormatException nfe) {
                label.setText("Empty/Incorrect number");
            }
        });
        clrButton.addActionListener(e -> {
            txt1.setText("");
            txt2.setText("");
            label.setText("Answer goes here");
        });
        mulButton.addActionListener(e -> {
            try {
                int res = Integer.parseInt(txt1.getText()) * Integer.parseInt(txt2.getText());
                label.setText(txt1.getText() + "*" + txt2.getText() + "=" + res);
            } catch (NumberFormatException nfe) {
                label.setText("Empty/Incorrect number");
            }
        });
        divButton.addActionListener(e -> {
            try {
                int res = Integer.parseInt(txt1.getText()) / Integer.parseInt(txt2.getText());
                label.setText(txt1.getText() + "/" + txt2.getText() + "=" + res);
            } catch (NumberFormatException nfe) {
                label.setText("Empty/Incorrect number");
            } catch (ArithmeticException ae) {
                label.setText("Zero division");
            }
        });
    }

    public static void main(String[] args) {
        exec41 f = new exec41();
    }
}