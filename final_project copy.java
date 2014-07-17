import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/***
****************
*********************************
*************************************************
*****************************************************************
*****************************************************************************************************************
          *                                     TEAM PROJECT CS501                                              *
          * AUTHORS: Guanhua Fan(10372733)                                                                      *
          *                                                                                                     *
          * PROJECT II:                                                                                         *
          *     GRAPHICALLY DISPLAY THE DISTRIBUTION OF THE NUMBER OF DIFFERENT PRIME FACTORS OF NON-PRIME      *                                                                                    
          * NUMBER RANGE.                                                                                       *
          *                                                                                                     *
          * PROGRAM ILLUSTRATION:                                                                               *
          *     WHEN THE PROGRAM RUNS, IT WILL DISPLAY A CALCULATOR-LIKE USER INTERFACE.                        *
          * USER MAY CLICK THE BUTTONS ON THE PANEL TO DETERMINE BOTH THE BEGINNING                             *                  
          * NUMBER AND THE ENDING NUMBER. AFTER HE/SHE PRESSES THE "CONFIRM A" BUTTON,                          *                    
          * THE BEGINNING NUMBER WILL BE LOCKED, WHICH MEANS THE PROGRAM HAS GOT THAT                           *                    
          * NUMBER AND THEN IT WILL NOT ALLOW USER TO MODIFY IT UNLESS "RESET ALL" BUTTON BEEN                  *                             
          * PRESSED. SO AS THE ENDING NUMBER("CONFIRM B" WILL TAKE CARE OF THAT). IN                            *                
          * ADDITION, OUR PROGRAM WILL KEEP AN EYE ON USERS' INPUTS. FOR EXAMPLE, A                             *                 
          * USER WILL NOT BE ABLE TO ENTER A ENDING NUMBER NEITHER LESS THAN OR EQUAL                           *                 
          * TO THE BEGINNING NUMBER. ALSO, THE BEGINNING NUMBER CANNOT BE "ZERO" OR                             *                
          * "ONE". PRESSING THESE TWO CONFIRM BUTTONS WILL AUTOMATICALLY CLEAR THE                              *                
          * TEXT FIELD ONCE THE PROGRAM FINDS ANY CURRENT INVALID INPUT.ANOTHER IMPORTANT                       *                      
          * RULE IN THIS PROGRAM IS THAT USER CANNOT GET THE RESULT WHEN ANY OF THESE                           *
          * TWO NUMBERS HAS YET BEEN CONFIRMED. OUR PANEL WILL BE ABLE TO CALCULATE MORE                        *
          * THAN ONCE. AFTER THE RESULT IS GENERATED, THESE TWO TEXT FIELDS WILL BE CLEARED                     *
          * IN ORDER TO LET USER GIVE ANOTHER RANGE OF NON-PRIME NUMBERS. FOR YOUR INFORMATION,                 *                      
          * IF NUMBERS YOU ENTER ARE TOO BIG, THE PROGRAM MIGHT TAKE A CONSIDERABLE TIME. SO                    *                                                                                                      *
          * WE SUGGEST USER TO ENTER NUMBERS WITH ABSOLUTE VALUES UNDER 99999.                                  *                                                                 *
		  *																										*
          * BASIC INSTRUCTIONS:                                                                                 *
          * <1> PRESS NUMBER BUTTONS TO DECIDE THE STARTING NUMBER                                              *
          * <2> CLICK "CONFIRM A" BUTTON TO CONFIRM(LOCK) THE BEGINNING NUMBER AND MOVE TO                      *
          *     NEXT TEXTAREA                                                                                   *
          * <3> PRESS NUMBER BUTTONS TO DETERMINE THE ENDING NUMBER                                             *
          * <4> CLICK "CONFIRM B" BUTTON TO CONFIRM THE ENDING NUMBER                                           *
          * <5> CLICK "RESULT" BUTTON TO MAKE THE PROGRAM CALCULATE THEN GENERATE THE BAR GRAPH                 *
          * <OPTION> CLICK "RESET ALL" WHEN USER WANT TO RE-ENTER ANY OF THESE NUMBERS                          * 
		  *																										*
		  * CONTACT AUTHORS:																					*
		  *		GUANHUA FAN GFAN@STEVENS.EDU																	*
		  *																										*
		  * (c)2013 Guanhua Fan All Rights Reserved												                *
*****************************************************************************************************************
*****************************************************************
*************************************************
*********************************
****************
***/


class Grid extends JComponent 
{
    static int CountTwo = 0;
    static int CountThree = 0;
    static int CountFive = 0;
    static int CountSeven = 0;
    static int CountEleven = 0;
    static int num1 = 0;
    static int num2 = 0;
    
    static  void clearALL()
    {
        CountTwo = 0;
        CountThree = 0;
        CountFive = 0;
        CountSeven = 0;
        CountEleven = 0;
    }
  static void findFactor(int number)
  {
    int counter =2;
   
    while(number>=counter)
    {
      if(number%counter == 0)
      {
        
       
        switch(counter)
        {
          case 2:
            CountTwo ++;
            break;
          case 3:
            CountThree ++;
            break;
          case 5:
            CountFive ++;
            break;
          case 7:
            CountSeven ++;
            break;
          case 11 :
            CountEleven ++;
            break;
        }
      
        number /= counter;
        continue;
      }
      else
      {
        counter ++;
      }
    }
  }




  static void collect(int num, int number)
  {
        num1 = num;
        num2 = number;
    
        if(number >= 2)
        {
          for(int j = num; j <= number ; j ++)
          {
            findFactor(j);
          }

        }else{

        }
  }





    public void paint(Graphics g) 
    {
         
        int iArr[] = {CountTwo, CountThree, CountFive, CountSeven, CountEleven};
        Arrays.sort(iArr);
        int denomiator = iArr[4];
        int two = (int)(((double)CountTwo/denomiator)*500);
        int ctwo = 540- two;
        

        int three = (int)(((double)CountThree/denomiator)*500);
        int cthree = 540- three;

        int five = (int)(((double)CountFive/denomiator)*500);
        int cfive = 540- five;

        int seven = (int)(((double)CountSeven/denomiator)*500);
        int cseven = 540- seven;

        int eleven = (int)(((double)CountEleven/denomiator)*500);
        int celeven = 540- eleven;
        int dr = 10;
        
        g.setColor(Color.blue);
        g.fillRect (80, ctwo, 80, two); 
        g.drawLine(80, ctwo, (80+2*dr), (ctwo-dr));
        g.drawLine(160, ctwo, (160+2*dr), (ctwo-dr));
        g.drawLine((80+2*dr), (ctwo-dr), (160+2*dr), (ctwo-dr));
        g.drawLine(160, 540, (160+2*dr), (540-dr));
        g.drawLine((160+2*dr), (ctwo-dr), (160+2*dr), (540-dr));
        
        g.setColor(Color.green);
        g.fillRect (230, cthree, 80, three);
        g.drawLine(230, cthree, (230+2*dr), (cthree-dr));
        g.drawLine(310, cthree, (310+2*dr), (cthree-dr));
        g.drawLine((230+2*dr), (cthree-dr), (310+2*dr), (cthree-dr));
        g.drawLine(310, 540, (310+2*dr), (540-dr));
        g.drawLine((310+2*dr), (cthree-dr), (310+2*dr), (540-dr));
        
        g.setColor(Color.yellow);
        g.fillRect (380, cfive, 80, five);
        g.drawLine(380, cfive, (380+2*dr), (cfive-dr));
        g.drawLine(460, cfive, (460+2*dr), (cfive-dr));
        g.drawLine((380+2*dr), (cfive-dr), (460+2*dr), (cfive-dr));
        g.drawLine(460, 540, (460+2*dr), (540-dr));
        g.drawLine((460+2*dr), (cfive-dr), (460+2*dr), (540-dr));
        
        g.setColor(Color.orange);
        g.fillRect (530, cseven, 80, seven);
        g.drawLine(530, cseven, (530+2*dr), (cseven-dr));
        g.drawLine(610, cseven, (610+2*dr), (cseven-dr));
        g.drawLine((530+2*dr), (cseven-dr), (610+2*dr), (cseven-dr));
        g.drawLine(610, 540, (610+2*dr), (540-dr));
        g.drawLine((610+2*dr), (cseven-dr), (610+2*dr), (540-dr));
        
        g.setColor(Color.red);
        g.fillRect (680, celeven, 80, eleven);
        g.drawLine(680, celeven, (680+2*dr), (celeven-dr));
        g.drawLine(760, celeven, (760+2*dr), (celeven-dr));
        g.drawLine((680+2*dr), (celeven-dr), (760+2*dr), (celeven-dr));
        g.drawLine(760, 540, (760+2*dr), (540-dr));
        g.drawLine((760+2*dr), (celeven-dr), (760+2*dr), (540-dr));
        
        
        g.setColor(Color.black);
        g.drawLine (30, 540, 810, 540);
        g.drawLine (30, 540, 30, 30);
        g.drawLine (810, 540, 795, 545);
        g.drawLine (810, 540, 795, 535);
        g.drawLine (30, 30, 25, 45);
        g.drawLine (30, 30, 35, 45);
        g.setFont(new Font(null, Font.PLAIN, 16));
        g.setColor(Color.magenta);
        g.drawString("TWO", 95, 570);
        g.drawString("THREE", 245, 570);
        g.drawString("FIVE", 395, 570);
        g.drawString("SEVEN", 545, 570);
        g.drawString("ELEVEN", 695, 570);
        
        String a = ""+CountTwo;
        String b = ""+CountThree;
        String c = ""+CountFive;
        String d = ""+CountSeven;
        String e = ""+CountEleven;
        
        g.setColor(Color.black);
        g.drawString(a, 120, (ctwo-15));
        g.drawString(b, 270, (cthree-15));
        g.drawString(c, 420, (cfive-15));
        g.drawString(d, 570, (cseven-15));
        g.drawString(e, 720, (celeven-15));
        
        g.drawString("The distribution of prime factors of a range from "+num1+" to "+num2+" are collected as above", 180, 600);
        
        

    }
}





public class final_project extends JFrame implements ActionListener
{
    JButton button[] = new JButton[12];
    String buttonString[] = {"0","1","2","3","4","5","6","7","8","9", "Confirm A","Confirm B"};
    JTextArea display = new JTextArea(1,10);
    JTextArea display2 = new JTextArea(1,10);
    Font font = new Font("Arial", Font.BOLD, 20);
    
    JButton b1 = new JButton("RESET ALL");
    JButton b2 = new JButton("RESULT");
   
    int temporary = 0;
    int temporary2 = 0;
    boolean visited = false;
    boolean complete = false;
    boolean wrong = false;
    static Grid g1 = new Grid();
    
    public final_project()
    {
        display.setEditable(false);
        display2.setEditable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JFrame frame = new JFrame();
        JPanel p1 = new JPanel();
        b1.setFont(font);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.RED);
        b2.setFont(font);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.RED);
        p1.setLayout(new GridLayout(4,3));
        b1.addActionListener(this);
        b2.addActionListener(this);
        for(int i = 0; i < 12; i++) {
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
            if(i <10)
            {
                button[i].setBackground(Color.BLACK);
                button[i].setForeground(Color.WHITE);
            }else
            {
                    button[i].setBackground(Color.BLACK);
                button[i].setForeground(Color.WHITE);
            }
            p1.add(button[i]);
        }
        
        
        JPanel p3 = new JPanel( new GridLayout(1,2));
        JPanel pi = new JPanel();
        JPanel pj = new JPanel();
        JLabel l1  =new JLabel("FROM A:");
        JLabel l2  =new JLabel("TO B: ");
        l1.setBackground(Color.PINK);
        l1.setForeground(Color.BLACK);
        l1.setFont(font);
        l2.setBackground(Color.PINK);
        l2.setForeground(Color.BLACK);
        l2.setFont(font);
        pi.add(l1);
        pi.setBackground(Color.LIGHT_GRAY);
        pi.add(display);
        pj.add(l2);
        pj.add(display2);
        pj.setBackground(Color.LIGHT_GRAY);
        p3.add(pi);
        p3.add(pj);
        JPanel p4 = new JPanel(new GridLayout(2,1));
        p4.add(b1);
        p4.add(b2);
        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(p3 , BorderLayout.NORTH);
        p2.add(p1, BorderLayout.CENTER);
        p2.add(p4, BorderLayout.WEST);
        
        add(p2);
        
    }
    public void close(){

        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

        }

    


     public void clear() {
            try {
                display.setText("");
                display2.setText("");
                temporary = 0;
                temporary2 = 0;
                
                
            } catch(NullPointerException e) {  
            }
        }
    
    public void actionPerformed(ActionEvent act) 
    {
        
            if(visited == false)
            {
                if(act.getSource() == button[0])
                
                {    
                        display.append("0");
                }
                if(act.getSource() == button[1])
                {    
                        display.append("1");
                }
                if(act.getSource() == button[2])
                {
                        display.append("2");
                }
                if(act.getSource() == button[3]) 
                {
                        display.append("3");
                }
                if(act.getSource() == button[4])
                {
                        display.append("4");
                }
                if(act.getSource() == button[5])
                {
                        display.append("5");
                }
                if(act.getSource() == button[6])
                {
                        display.append("6");
                }
                if(act.getSource() == button[7]) 
                {
                        display.append("7");
                }
                if(act.getSource() == button[8])
                {
                        display.append("8");
                }
                if(act.getSource() == button[9])
                {
                        display.append("9");
                }
                
                if(act.getSource() == button[10]) 
                {
                    g1.clearALL();
                if( display.getText().trim().length() != 0 && Integer.parseInt(display.getText()) >1)
                {
                        temporary = Integer.parseInt(display.getText());
                    visited = true;
                }else 
                {
                    display.setText("");
                } 
                        
            }
        }
                
            
            
            if(visited == true && complete == false)
            {
                
                    if(act.getSource() == button[0])
                {    
                        display2.append("0");
                }
                if(act.getSource() == button[1])
                {    
                        display2.append("1");
                }
                if(act.getSource() == button[2])
                {
                        display2.append("2");
                }
                if(act.getSource() == button[3]) 
                {
                        display2.append("3");
                }
                if(act.getSource() == button[4])
                {
                        display2.append("4");
                }
                if(act.getSource() == button[5])
                {
                        display2.append("5");
                }
                if(act.getSource() == button[6])
                {
                        display2.append("6");
                }
                if(act.getSource() == button[7]) 
                {
                        display2.append("7");
                }
                if(act.getSource() == button[8])
                {
                        display2.append("8");
                }
                if(act.getSource() == button[9])
                {
                        display2.append("9");
                }
                
                if(act.getSource() == button[11]) 
                {
                            
                        if(     display2.getText().trim().length() != 0)
                        {
                            if(temporary < Integer.parseInt(display2.getText()) )
                            {
                                temporary2 = Integer.parseInt(display2.getText());
                                complete = true;
                            }else 
                            {
                                display2.setText("");
                            } 
                        }
                        else 
                        {
                            display2.setText("");
                        }
                        
                        
                    
                }
                
                
                
            }
            if(act.getSource() == b1)
            {
                    this.clear();
                    visited = false;
                    complete = false;
            }
            if(act.getSource() == b2)
            {
                if(temporary2 != 0)
                {
                    
                JFrame window = new JFrame("DISTRIBUTION OF PRIME FACTORS");
                window.setSize(840,680);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                g1.collect(temporary,temporary2);
                window.getContentPane().add(g1);
                window.setVisible(true);
                
                
                visited = false;
                this.clear();
                temporary = 0;
                }
                    
                temporary2 = 0;
                complete = false;
                
                
                    
            }
       
    }
    
  
    public static void main (String args[])
    {
        final_project t1 = new final_project();
        t1.setTitle("Prime Factor Calculator");
        t1.setSize(700,300);
        t1.setLocationRelativeTo(null);
        t1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t1.setVisible(true);
    }

}