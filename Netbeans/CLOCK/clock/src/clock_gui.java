


import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.applet.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;

/*
<html>
<head>
<title> CLOCK
</title>
</head>
<body>
<applet CODE = "AnalogClockApplet"  WIDTH = 1000  HEIGHT = 800>
</applet>
</body>
</html>
*/

public class clock_gui extends JApplet{
    private volatile Thread timer;
    ind_clock clocks[]=new ind_clock[6];
    public void init()
    {
        this.setSize(1000,800);
        Container contentpane = getContentPane();
        contentpane.setLayout(new GridLayout(2,3,2,2));
       
        clocks[0] = new ind_clock("New Delhi",5,30);
        clocks[1]= new ind_clock("London , greenwich",0,0);
        clocks[2]=new ind_clock("Tokyo",9,0);
        clocks[3]=new ind_clock("Detroit(US)",-7,0);
        clocks[4]=new ind_clock("International Date Line",-12,0);
        clocks[5]=new ind_clock("Sydney",10,0);
        for(int i=0;i<6;i++)
        {
            clocks[i].setBackground(Color.yellow);
            contentpane.add(clocks[i]);
        }
  
   
  }
  
};

class ind_clock extends JPanel implements Runnable,ActionListener
{


  Thread t;
  int GMT_hr;
  int GMT_min;
  String City_Name,thread_n;
  JPanel dig_panel,city_panel, digtime_panel;
  JTextField timetextfield;
  JButton set,set2, set3,set4;
  JLabel city;
  int radius= 75;
  double hour_angle,min_angle,sec_angle;
  public ind_clock(String s,int gmt_h,int gmt_m)
 {
   thread_n = s;
   City_Name=s;
   this.setLayout(new BorderLayout());
   GMT_hr=gmt_h;
   GMT_min=gmt_m;
   dig_panel = new JPanel(new GridLayout(2,2));
   digtime_panel = new JPanel(new BorderLayout());
   timetextfield = new JTextField();
   timetextfield.setText("12"+":"+"00"+":"+"00");
   set = new JButton("Set City name");
   set2 = new JButton("Set City Time");
   set3 = new JButton("Bigger");
   set4 = new JButton("Smaller");
   set2.addActionListener(this);
   set.addActionListener(this);
   set3.addActionListener(this);
   set4.addActionListener(this);
  
   dig_panel.add( set );
   dig_panel.add( set2 );
   dig_panel.add( set3 );
   dig_panel.add( set4 );
   this.add(dig_panel,BorderLayout.SOUTH);
   this.add(digtime_panel,BorderLayout.NORTH);
   city_panel = new JPanel();
   city = new JLabel(City_Name);
   city_panel.add(city);
   city_panel.add(timetextfield);
   this.add(city_panel,BorderLayout.NORTH);
   t = new Thread(this,thread_n);
   t.start();
  
}
  
public void paintComponent(Graphics g)
{
  Image mImage;
  super.paintComponent(g);
  Dimension dim = getSize();
  int cx = dim.width/2;
  int cy = dim.height/2;
  Graphics2D g2 = (Graphics2D)g;
  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
  long MILLIS_IN_MINUTE = 60L * 1000L;
  long MILLIS_IN_HOUR = MILLIS_IN_MINUTE * 60L;
  long MILLIS_IN_HALF_DAY = MILLIS_IN_HOUR * 12L;
  
  long t = (new Date()).getTime();
  long m = t % MILLIS_IN_MINUTE;
  long s = m / 1000L;
  long h = t %  (MILLIS_IN_HOUR);
  long q = (h/60000L+GMT_min)/60L;
  long minu= (h/60000L+GMT_min)%60L;
  h=(t%(24*MILLIS_IN_HOUR)/(MILLIS_IN_HOUR) + GMT_hr+q);
     
  long hday = t % MILLIS_IN_HALF_DAY;
  long h2 = h%24;
  int m2=(int)minu;
  if(m2<10)
	timetextfield.setText(" "+(int)h2+ ":" +"0"+(int)minu+":"+s);
  else
        timetextfield.setText(" "+(int)h2+ ":" +(int)minu+":"+s); 
           
  h=h%12;
 
  // calculate the clock hand angles
  double sec_angle = (2*Math.PI / (60L))*(s);
  double min_angle = (2*Math.PI / (60L))*(minu);
  double hour_angle = (Math.PI / 6)*(h)+(Math.PI/6)*(min_angle/(2*Math.PI));
  
  g2.setPaint(Color.blue);
  g2.setStroke(new BasicStroke(2f));
  g2.draw(new Ellipse2D.Double(cx-radius, cy-radius, 2*radius,2*radius));
  g2.setPaint(Color.white);
  g2.fill (new Ellipse2D.Double(cx-radius, cy-radius, 2*radius, 2*radius));


  g2.setFont(new Font("Dialog", Font.BOLD, radius / 5));
  g2.setPaint(Color.red);
  g2.drawString("9", cx-radius + 6, cy+3); 
  g2.drawString("3", cx+ radius -15, cy+6);
  g2.drawString("12", cx-10, cy-radius +20);
  g2.drawString("6", cx-3, cy+radius -3);
  
  g2.setPaint(Color.blue);
  g2.rotate(min_angle,cx,cy);
  g2.setStroke(new BasicStroke(2f));
  g2.draw(new Line2D.Double(cx, cy, cx, cy - (3*radius) / 4));
  g2.rotate(-min_angle,cx,cy);
      
  g2.setPaint(Color.blue);
  g2.rotate(hour_angle,cx,cy);
  g2.setStroke(new BasicStroke(4f));
  g2.draw(new Line2D.Double(cx, cy, cx, cy - radius / 2));
  g2.rotate(-hour_angle,cx,cy);
         
  g2.setPaint(Color.red);
  g2.rotate(sec_angle,cx,cy);
  g2.setStroke(new BasicStroke(1f));
  g2.draw(new Line2D.Double(cx, cy,cx, cy-radius ));
  g2.rotate(-sec_angle,cx,cy);
  g2.setPaint(Color.white);
 
}

  
public void run() {
        Thread t1 = Thread.currentThread();
	try {
	   while (true) {
	        Thread.currentThread().sleep(1000);
                  repaint();
	   }
        } catch (InterruptedException e) {
        }
}


public void Configure_time()
{
      String s2 = (String)JOptionPane.showInputDialog("Set diff from GMT:","hour");
      String s3= (String)JOptionPane.showInputDialog("Set diff from GMT:","minutes");
                
      Integer num = Integer.valueOf(s2);
      GMT_hr= num.intValue();
      Integer num1 = Integer.valueOf(s3);
      GMT_min= num1.intValue();
}


public void Configure_city()
 {
       
       City_Name= (String)JOptionPane.showInputDialog("Set City Name:",City_Name);
       city.setText(City_Name);
}

public void actionPerformed(ActionEvent ae)
{
    if(ae.getActionCommand().equals("Set City Time"))
        {
		Configure_time();
	}
	
     if(ae.getActionCommand().equals("Set City Name"))
	{
		Configure_city();
	}
     if(ae.getActionCommand().equals("Bigger"))
	{
		Increase_radius();
	}
      if(ae.getActionCommand().equals("Smaller"))
	{
		Decrease_radius();
	}
}       
public void Increase_radius(){
    if( radius != 140){
        radius = radius + 5;
    }
    else
        JOptionPane.showMessageDialog( dig_panel,"NO more zoom!!");
}
public void Decrease_radius(){
    if( radius != 50){
        radius = radius - 5;
    }
    else
        JOptionPane.showMessageDialog( dig_panel,"NO more zoom!!");
}


};