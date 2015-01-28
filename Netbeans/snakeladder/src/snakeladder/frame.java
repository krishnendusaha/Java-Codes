/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeladder;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class frame extends javax.swing.JFrame {

    /**
     * Creates new form frame5
     */
    
    private Random generator;
    private JLabel[] blocks;
    private int[] ladstart,ladend,snakestart,snakeend;   
    private int steps,position1=1,position2=1,position3=1,count=0,xcount=0,noofsnakes,noofladders,totalcount=0;
    private JLabel label2,label3,player1,player2,player3,nump;
    int num=board.get_no_of_rows();
    int numplayers=board.get_no_of_players();
    int boardsize=num*num;
    String[] names;
    private String a;
    board prev;
    public frame(board obj) {
        initComponents();
        initialize_standard_snake_ladder();
        prev=obj;
        names=new String[numplayers];
        names=board.getplayers();
    }     
    private void initialize_standard_snake_ladder()
   	{
   		noofsnakes = noofladders =num;
   		initialize_array();
   		set_snake_ladder();
	 
   	}
  void initialize_array()
  {
    snakestart=new int[noofsnakes];
    snakeend=new int[noofsnakes];
    ladstart=new int[noofladders];
    ladend=new int[noofladders];
     initialize(ladstart);
     initialize(ladend);
     initialize(snakestart);
     initialize(snakeend);
  }  
  void set_snake_ladder()
   {
  	 	int temp,i=0;
   		generator = new Random();
    for(i=0;i<num;i++)
    {	
      	temp=random_number(num,boardsize-2,generator);
      	while(contains(snakestart,temp)||contains(snakeend,temp)||contains(ladstart,temp)||contains(ladend,temp))
      		{
                 temp=random_number(num,boardsize-2,generator);
                }
        snakestart[i]=temp; 
        temp=random_number(0,snakestart[i]-1,generator);
        while(contains(snakestart,temp)||contains(snakeend,temp)||contains(ladstart,temp)||contains(ladend,temp))
        {
       	 temp=random_number(0,snakestart[i]-1,generator);
      	}
     	snakeend[i]=temp; 
     	temp=random_number(1,boardsize-num-1,generator);
      	while(contains(snakestart,temp)||contains(snakeend,temp)||contains(ladstart,temp)||contains(ladend,temp))
      	{
       		temp=random_number(1,boardsize-num-1,generator);
      	}
     	ladstart[i]=temp; 
        temp=random_number(ladstart[i],boardsize-2,generator);
        while(contains(snakestart,temp)||contains(snakeend,temp)||contains(ladstart,temp)||contains(ladend,temp))
     	 {
             	temp=random_number(ladstart[i],boardsize-2,generator);
      	 }
      	ladend[i]=temp;
        }  
    }
   private  void creategui()throws IOException,InterruptedException {
       int j=0,i=0,x=0,labelsize=0;
        blocks=new JLabel[144];
        i=1;
        a=String.valueOf(i);
  /*     imageicon iconladder1 = createimageicon("images/ladder1.gif",
                                 "a pretty but meaningless splat");
    
	 imageicon iconsnake = createimageicon("images/snake.gif",
                                 "a pretty but meaningless splat");
	
     imageicon iconsnake1 = createimageicon("images/snake2.gif",
                                 "a pretty but meaningless splat");
                                 
     imageicon iconladder2 = createimageicon("images/ladder1.gif",
                                 "a pretty but meaningless splat");
 	
	 imageicon iconladder3 = createimageicon("images/ladder1.gif",
                                 "a pretty but meaningless splat");
    
	 imageicon iconladder4 = createimageicon("images/ladder1.gif",
                                 "a pretty but meaningless splat");
   */	  
       int k=24;
       int p=0,y=0;	
       
	 if(num==12) {
           labelsize=45;
       }
 	 if(num==11) {
           labelsize=50;
       }
     if(num<=10) {
           labelsize=60;
       }
	    
     for( j=0;j<boardsize;j++)
	    {
	       if(contains(snakestart,j+1)&&j!=0)//setting up the snake
	        {
	        	p=boardsize-j-1;
	        	if(x%2==0) {
                        blocks[p] = new JLabel(a,JLabel.CENTER);
                    }
	           	else {
                        blocks[p] = new JLabel(a,JLabel.CENTER);
                    }
	           	blocks[p].setOpaque(true);
	        	blocks[p].setBackground(Color.white);
		    	blocks[p].setPreferredSize(new Dimension(labelsize,labelsize));
		    	x++;
		   }
		   else//setting up the ladder
		 	{
		 	  if(contains(ladstart,j+1)&&j!=0)
		   		{
		   			p=boardsize-j-1;
	    	    	if(y%4==0) {
                                        blocks[p] = new JLabel(a, JLabel.CENTER);
                                    }
					if(y%4==1) {
                                        blocks[p] = new JLabel(a, JLabel.CENTER);
                                    }
					if(y%4==2) {
                                        blocks[p] = new JLabel(a,  JLabel.CENTER);
                                    }
					if(y%4==3) {
                                        blocks[p] = new JLabel(a, JLabel.CENTER);
                                    }
					blocks[p].setOpaque(true);
	    		   	blocks[p].setBackground(Color.white);
	    			blocks[p].setPreferredSize(new Dimension(labelsize,labelsize));
	    			y++;
		  		 }
		   	  else
		   		{
		   			p=boardsize-j-1;
		   			blocks[p] = new JLabel(a,null, JLabel.CENTER);
					blocks[p].setOpaque(true);
	       			blocks[p].setBackground(Color.white);
	    			blocks[p].setPreferredSize(new Dimension(labelsize,labelsize));
		   		}
		   }
		   
		   i++;
		   a=String.valueOf(i);
	     }	
    
    for(i=0;i<boardsize;i++) {
           jPanel1.add(blocks[i]);
       }
    jPanel3.add(jPanel1);
	jPanel3.add(jPanel2);
     
   
    blocks[boardsize-position1].setBackground(Color.yellow);
    label2.setText(names[0]+"'S TURN ");
    Thread.sleep(2000);
    JOptionPane.showMessageDialog(null,names[0]+" START THE GAME. YOUR COLOR IS YELLOW.");
   }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dice = new javax.swing.JButton();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        dice.setText("Throw Dice");
        dice.setPreferredSize(new java.awt.Dimension(130, 80));
        dice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diceActionPerformed(evt);
            }
        });

        Label1.setText("          You  Got");
        Label1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Label2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Label1, Label2, dice});

        Back.setText("jButton1");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addComponent(Back)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(292, Short.MAX_VALUE)
                        .addComponent(Back)
                        .addGap(133, 133, 133)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diceActionPerformed
     Random generator1 = new Random();
	int number=random_number(1,6,generator1);
 	count++;
  	if(count%6==0) {
            number=1;
        }
  	if(count%12==0) {
            number=2;
        }
    try{
		new_position_index(number);
	 }  
    catch (InterruptedException exc) {
        System.err.println("Caught IntrException: " + exc.getMessage());
     }
        try {
            new_position_index(number);
        } catch (InterruptedException ex) {
            Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
        }
}  
  
 
 public void new_position_index(int number) throws InterruptedException
 {
     
     label3.setText("YOU GOT "+number);
 
     int positiontemp;int position=0,indexnew;
     int index=totalcount%numplayers;
     steps=totalcount/numplayers;
     if(index==0) {
         position=position1;
     }
     if(index==1) {
         position=position2;
     }
     if(index==2) {
         position=position3;
     }
    
    
    
     if(boardsize-position<=6) {
         xcount++;
     }
    	 
     if(number>(boardsize-position))
    	{
		if(xcount==1) {
                JOptionPane.showMessageDialog(null,names[index]+" TO WIN YOU NEED "+(boardsize-position));
            }
         xcount++;totalcount++;
     	  return;
     }
       
    if(number==(boardsize-position))
    {
    	 JOptionPane.showMessageDialog(null,"CONGRATS "+names[index]+" YOU HAVE WON IN "+steps+" DICE THROWS");
    	if(index==0) {
            blocks[0].setBackground(Color.yellow);
        }
    	if(index==1) {
            blocks[0].setBackground(Color.green);
        }
    	if(index==2) {
            blocks[0].setBackground(Color.blue);
        }

    	test_and_change_color(index,position);
    	totalcount++;
     	return;
     }
   
   if(number<(boardsize-position)) {
         xcount=0;
     }  
    
       test_and_change_color(index,position);
   
 		position=position+number;
        if(index==0) {
         blocks[boardsize-position].setBackground(Color.yellow);
     }
    	if(index==1) {
         blocks[boardsize-position].setBackground(Color.green);
     }
    	if(index==2) {
         blocks[boardsize-position].setBackground(Color.blue);
     }
  
 	if(contains(snakestart,position))
 	 {
 	   positiontemp=position;
 	   position=snakeend[new_position_index(snakestart,position)];
       JOptionPane.showMessageDialog(null,"SNAKE AT "+positiontemp+" CAUGHT YOU! GO TO "+position);
       test_and_change_color(index,positiontemp);
     
      }
 
 	if(contains(ladstart,position))
 	{	positiontemp=position;
 		position=ladend[new_position_index(ladstart,position)];
 		JOptionPane.showMessageDialog(null,"YOU ARE UP THROUGH LADDER AT "+positiontemp+" TO "+position);
 	    test_and_change_color(index,positiontemp);
 	   
 	}
 	
    if(index==0) {
         blocks[boardsize-position].setBackground(Color.yellow);
     }
    	if(index==1) {
         blocks[boardsize-position].setBackground(Color.green);
     }
    	if(index==2) {
         blocks[boardsize-position].setBackground(Color.blue);
     }
   
   
   if(index==0) {
         position1=position;
     }
    if(index==1) {
         position2=position;
     }
    if(index==2) {
         position3=position;
     }
   
    totalcount++;
    index=totalcount%numplayers;
 
   label2.setText(names[index]+"'s TURN ");
   if(totalcount==1&&index==1)
   {
   	 blocks[boardsize-1].setBackground(Color.green);
     JOptionPane.showMessageDialog(null,names[1]+" START THE GAME. YOUR COLOR IS GREEN.");
    }
     else
     if(totalcount==2&&index==2)
    {
    	blocks[boardsize-1].setBackground(Color.blue);
   		JOptionPane.showMessageDialog(null,names[2]+" START THE GAME. YOUR COLOR IS BLUE.");
   	}
   else {
         blocks[boardsize-1].setBackground(Color.white);
     }
  
  
   
    indexnew=totalcount%numplayers;
  
 
    }//GEN-LAST:event_diceActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

 void test_and_change_color(int index1,int pos)
{
if(index1==0&&pos!=1)
    	{
    		if(pos==position2) {
                blocks[boardsize-pos].setBackground(Color.green);
            }
    		else
    			if(pos==position3) {
                blocks[boardsize-pos].setBackground(Color.blue);
            }
     				else {
                blocks[boardsize-pos].setBackground(Color.white);
            }
     	}
if(index1==1&&pos!=1)
    	{
    		if(pos==position1) {
                blocks[boardsize-pos].setBackground(Color.yellow);
            }
    		else
    			if(pos==position3) {
                blocks[boardsize-pos].setBackground(Color.blue);
            }
     				else {
                blocks[boardsize-pos].setBackground(Color.white);
            }

           }


if(index1==2&&pos!=1)
    	{
    		if(pos==position2) {
                blocks[boardsize-pos].setBackground(Color.green);
            }
    		else
    			if(pos==position1) {
                blocks[boardsize-pos].setBackground(Color.yellow);
            }
     				else {
                blocks[boardsize-pos].setBackground(Color.white);
            }
           }
 
 
 }
  int new_position_index(int[] array,int number)
  {	
  	for(int i=0;i<array.length;i++) {
          if(array[i]==number) {
                return i;
            }
      }
  
  return 0;
  
  }
    void initialize(int array[])
   {
   	for(int i=0;i<array.length;i++) {
           array[i]=0;
       }
   }
static int random_number(int aUpperLimit,int aLowerLimit,Random generator)
     {
        int number;
        long range;
        range = (long)aUpperLimit -(long)aLowerLimit + 1;
        long fraction = (long)(range * generator.nextDouble());
         number= (int)(fraction + aLowerLimit);
        return number;
       
     }
 static boolean contains(int[] array,int element)
  {
 	int i=0;
 	while(i!=array.length)
 	{
 		if(array[i]==element) {
                return true;
            }
 	i++;	
 	}
   return false;
  }
protected static ImageIcon createImageIcon(String path,
                                           String description) {
    java.net.URL imgURL = frame.class.getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
     //   java.awt.EventQueue.invokeLater(new Runnable() {
     //       public void run() {
     //           new frame().setVisible(true);
      //          final frame obj=new frame();
      //          try {
      //              obj.creategui();
      //          } catch (   IOException | InterruptedException ex) {
      //              Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
       //         }
       //     }
       // });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JButton dice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
