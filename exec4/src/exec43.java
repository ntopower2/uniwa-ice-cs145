import javax.swing.*;
import javax.swing.border.Border;

class exec43 {
    exec43() {
        JFrame frame = new JFrame("Order Menu");
        JPanel mainPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
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

        Border buttonBorder = BorderFactory.createEmptyBorder(0,50,0,50);
        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("Complete order");
        buttonPanel.add(button);
        buttonPanel.setBorder(buttonBorder);
        mainPanel.add(buttonPanel);

        Border labelBorder = BorderFactory.createEmptyBorder(0,50,10,50);
        JPanel labelPanel = new JPanel();
        JLabel label = new JLabel("Message goes here");
        labelPanel.add(label);
        labelPanel.setBorder(labelBorder);
        mainPanel.add(labelPanel);

        button.addActionListener(e -> {
            String order = "";
            boolean sizeUnset = false, deliveryUnset = false;

            if (jRadioButtons[0].isSelected()) order += "Small, ";
            else if (jRadioButtons[1].isSelected()) order += "Medium, ";
            else if (jRadioButtons[2].isSelected()) order += "Large, ";
            else sizeUnset = true;

            if (checkBox1.isSelected())
                order += checkBox1.getText() + ", ";
            if (checkBox2.isSelected())
                order += checkBox2.getText() + ", ";

            if (comboBox.getSelectedIndex() == 0) deliveryUnset = true;
            else order += comboBox.getSelectedItem();

            if (sizeUnset) order = "Size unset!";
            if (deliveryUnset) order = "Delivery unset!";
            label.setText(order);
        });
        frame.getContentPane().add(mainPanel);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        exec43 f = new exec43();
    }
}