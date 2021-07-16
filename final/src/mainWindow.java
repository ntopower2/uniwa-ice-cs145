import javax.swing.*;
import java.awt.*;

public class mainWindow {
    JFrame f2;
    newTicket nT;
    listTicket lT;
    aboutWindow aW;

    mainWindow() {
        JFrame frame = new JFrame("Main Window");

        JPanel mainPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//        buttons' panel and functionality
        JPanel buttonPanel =  new JPanel(new GridLayout(4, 1, 10, 5));
        JButton[] buttons = {
                new JButton("Create new Ticket"),
                new JButton("Show Ticket List"),
                new JButton("About app"),
                new JButton("Exit")
        };
        buttons[0].addActionListener(e -> {
            if (f2==null || !f2.isVisible()) {
                f2 = new JFrame();
                nT = new newTicket();
                nT.createNewTicket(f2);
            }
        });
        buttons[1].addActionListener(e -> {
            if (f2==null || !f2.isVisible()) {
                f2 = new JFrame();
                lT = new listTicket();
                lT.listTickets(f2);
            }
        });
        buttons[2].addActionListener(e -> {
            if (f2==null || !f2.isVisible()) {
                f2 = new JFrame();
                aW = new aboutWindow();
                aW.createAboutWindow(f2);
            }
        });
        buttons[3].addActionListener(e -> System.exit(0));
        for (JButton button:buttons) buttonPanel.add(button);
        mainPanel.add(buttonPanel);

//        menu items
        MenuBar mb=new MenuBar();
        Menu menu=new Menu("Actions");
        MenuItem[] menuitem = new MenuItem[buttons.length];
        for (int i=0;i<buttons.length;i++) {
            menuitem[i] = new MenuItem(buttons[i].getText());
            menuitem[i].addActionListener(buttons[i].getActionListeners()[0]);
            menu.add(menuitem[i]);
        }
        mb.add(menu);
        frame.setMenuBar(mb);

        frame.getContentPane().add(mainPanel);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        mainWindow mW = new mainWindow();
    }
}
