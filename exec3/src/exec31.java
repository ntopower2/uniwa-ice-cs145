import java.awt.*;

class exec31 extends Frame {
    exec31() {
        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        Button addButton = new Button("Add");
        Button subButton = new Button("Substract");
        Button clrButton = new Button("Clear");
        Label label = new Label("Answer goes here");

        txt1.setBounds(20, 35, 120,30);
        txt2.setBounds(150, 35, 120,30);
        addButton.setBounds(20, 70, 80, 30);
        subButton.setBounds(110,70, 80, 30);
        clrButton.setBounds(200,70, 80, 30);
        label.setBounds(80, 105, 200,20);
        add(txt1);
        add(txt2);
        add(addButton);
        add(subButton);
        add(clrButton);
        add(label);
        setFont(new Font("Consolas", Font.ITALIC, 17));
        setSize(300, 130);
        setLayout(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String args[]) {
        exec31 f = new exec31();
    }
}