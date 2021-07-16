import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class exec33 {
    exec33() {
        JFrame frame = new JFrame("Order Menu");
        JPanel mainPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//        size panel
        Border size = BorderFactory.createTitledBorder("Size");
        JPanel sizePanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        JRadioButton[] jRadioButtons = new JRadioButton[]{
                new JRadioButton("Small"),
                new JRadioButton("Medium"),
                new JRadioButton("Large"),
        };
        group.add(jRadioButtons[0]);
        group.add(jRadioButtons[1]);
        group.add(jRadioButtons[2]);
        sizePanel.add(jRadioButtons[0]);
        sizePanel.add(jRadioButtons[1]);
        sizePanel.add(jRadioButtons[2]);
        sizePanel.setBorder(size);
        mainPanel.add(sizePanel);

//        toppings panel
        Border toppings = BorderFactory.createTitledBorder("Toppings");
        JPanel toppingsPanel = new JPanel();
        JCheckBox checkBox1 = new JCheckBox("Pepperoni");
        JCheckBox checkBox2 = new JCheckBox("Anchovies");
        toppingsPanel.add(checkBox1);
        toppingsPanel.add(checkBox2);
        toppingsPanel.setBorder(toppings);
        mainPanel.add(toppingsPanel);

//        delivery panel
        Border delivery = BorderFactory.createTitledBorder("Delivery");
        JPanel deliveryPanel = new JPanel();
        JComboBox<String> comboBox = new JComboBox<>(new String[] {
                "(Select a delivery option)", "Eat-in", "Take out", "Home Delivery"
        });
        deliveryPanel.add(comboBox);
        deliveryPanel.setBorder(delivery);
        mainPanel.add(deliveryPanel);
        mainPanel.add(new Label("Message goes here"));

        frame.getContentPane().add(mainPanel);
        frame.setResizable(false);
    }

    public static void main(String args[]) {
        exec33 f = new exec33();
    }
}