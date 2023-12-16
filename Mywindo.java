import java.awt.Font;
import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.plaf.FontUIResource;
//import javax.swing.text.StyleConstants.FontConstants;
//import javax.swing.text.StyledEditorKit.BoldAction;

public class Mywindo  extends JFrame
{
    private JLabel heading;

    private JLabel clockJLabel;


    private Font font = new Font("", Font.BOLD,35);
    Mywindo()
    {
        super.setTitle("My Clock");
        super.setSize(400,400);
        super.setLocation(300,50);
        this.createGUI();
        this.startClock();
        super.setVisible(true);
    }

    public void createGUI()
    {
        heading = new JLabel("My Clock");

        clockJLabel=new JLabel("clock");

        heading.setFont(font);
        clockJLabel.setFont(font);

        this.setLayout(new GridLayout(2,2));

        this.add(heading);

        this.add(clockJLabel);
    }
    public void startClock()
    {
        Thread t=new Thread(){
            public void run()
            {
                try {
                    while(true)
                    {
                        Date d=new Date();
                        SimpleDateFormat sfd=new SimpleDateFormat("hh : mm : ss a");
                        String dateTime =sfd.format(d);

                        clockJLabel.setText(dateTime);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}

