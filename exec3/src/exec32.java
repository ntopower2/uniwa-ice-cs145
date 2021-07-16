import java.awt.*;

class exec32 extends Frame {
    exec32() {
        Character[] characters = new Character[]{
                '7','8','9','+','4','5','6','-','1','2','3','*','0','.','=','/'
        };

        Button[] buttons = new Button[characters.length];
        int x,y;
        for (int i=0;i<characters.length;i++) {
            buttons[i] = new Button(characters[i].toString());
            x = 10+(i%4)*40;
            y = 80+(i/4)*40;
            buttons[i].setBounds(x,y, 40,40);
            buttons[i].setFont(new Font("Consolas", Font.ITALIC, 17));
            add(buttons[i]);
        }
        setSize(170, 240);
        setLayout(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String args[]) {
        exec32 f = new exec32();
    }
}