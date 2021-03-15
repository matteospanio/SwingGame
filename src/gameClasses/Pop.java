package gameClasses;


// Java Program to create a popup and display
// it on a parent frame
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Pop extends JFrame implements ActionListener {
    // popup
    Popup p;

    // constructor
    public Pop(boolean vinto)
    {
        // create a frame
        JFrame f = new JFrame("pop");

        JLabel l;
        // create a label
        if (vinto == true) {
            l = new JLabel("Congrats, you Won!!!");
        } else {
            l = new JLabel("LOSER :P");
        }

        f.setSize(400, 400);

        PopupFactory pf = new PopupFactory();

        // create a panel
        JPanel p2 = new JPanel();

        // set Background of panel
        p2.setBackground(Color.red);

        p2.add(l);

        // create a popup
        p = pf.getPopup(f, p2, 180, 100);

        // create a button
        JButton b = new JButton("OK");

        // add action listener
        b.addActionListener(this);

        // create a panel
        JPanel p1 = new JPanel();

        p1.add(b);
        f.add(p1);
        f.show();
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        p.show();
    }
}
