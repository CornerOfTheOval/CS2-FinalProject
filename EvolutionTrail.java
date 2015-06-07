import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class EvolutionTrail extends Applet implements MouseListener
{
      Population pop = new Population();
      int xpos;
      int ypos;
      
      int turns;
      int R;
      int G;
      int B;
      
      int posRect1xco,posRect1yco,posRect1width,posRect1height;
      int negRect1xco,negRect1yco,negRect1width,negRect1height;
      int posRect2xco,posRect2yco,posRect2width,posRect2height;
      int negRect2xco,negRect2yco,negRect2width,negRect2height;
      int posRect3xco,posRect3yco,posRect3width,posRect3height;
      int negRect3xco,negRect3yco,negRect3width,negRect3height;
      int posRect4xco,posRect4yco,posRect4width,posRect4height;
      int negRect4xco,negRect4yco,negRect4width,negRect4height;
      int posRect5xco,posRect5yco,posRect5width,posRect5height;
      int negRect5xco,negRect5yco,negRect5width,negRect5height;
      int posRect6xco,posRect6yco,posRect6width,posRect6height;
      int negRect6xco,negRect6yco,negRect6width,negRect6height;
      int nextButtonxco,nextButtonyco,nextButtonWidth,nextButtonHeight;
      
      boolean mouseEntered;
      
      int room; //This determines which screen is showing (0 = Title screen 1 = Stats, 2 = Ev Traits,
      
      private Image img0 = null;
      private Image img1 = null;
      private Image img2 = null;
      private Image img3 = null;
      private Image img4 = null;
      private Image img5 = null;
      private Image img6 = null;
      private Image img7 = null;
      private Image img8 = null;
      private Image img9 = null;
      
      private Image deadMonkey = null;
      private Image rivalMonkeys = null;
      
      URL url0 = null;
      URL url1 = null;
      URL url2 = null;
      URL url3 = null;
      URL url4 = null;
      URL url5 = null;
      URL url6 = null;
      URL url7 = null;
      URL url8 = null;
      URL url9 = null;
      
      URL dM = null;
      URL rM = null;
      
      public void init()
      {
         try{
            url0 = new URL(getCodeBase(), "/Sprites/Berries.png");
            url1 = new URL(getCodeBase(), "/Sprites/JungleScene.png");//Forest
            url2 = new URL(getCodeBase(), "/Sprites/JungleScene.png");//Attacked
            url3 = new URL(getCodeBase(), "/Sprites/River.png");
            url4 = new URL(getCodeBase(), "/Sprites/Climb.png");
            url5 = new URL(getCodeBase(), "/Sprites/Disease.png");
            url6 = new URL(getCodeBase(), "/Sprites/Traps.png");
            url7 = new URL(getCodeBase(), "/Sprites/Forest Fire.png");
            url8 = new URL(getCodeBase(), "/Sprites/JungleScene.png");//Accident
            url9 = new URL(getCodeBase(), "/Sprites/Clfif.png");//not a typo, image file is spelled like this
            dM = new URL(getCodeBase(), "/Sprites/dead monkey 2.png");
            rM = new URL(getCodeBase(), "/Sprites/Enemy Monkeys - 4.png");
            
            img0 = ImageIO.read(url0);
            img1 = ImageIO.read(url1);
            img2 = ImageIO.read(url2);
            img3 = ImageIO.read(url3);
            img4 = ImageIO.read(url4);
            img5 = ImageIO.read(url5);
            img6 = ImageIO.read(url6);
            img7 = ImageIO.read(url7);
            img8 = ImageIO.read(url8);
            img9 = ImageIO.read(url9);
            deadMonkey = ImageIO.read(dM);
            rivalMonkeys = ImageIO.read(rM);
            
         }catch(IOException e){
         }
         
         setSize(8005, 3923);
         
         R = 150;
         G = 200;
         B = 255;
         
         turns = 30;
         
         room = 1; //change to 0 once we get a title card
         
         posRect1xco = 270;
         posRect1yco = 30; 
         posRect1width = 20; 
         posRect1height = 20;
         negRect1xco = 300; 
         negRect1yco = 30; 
         negRect1width = 20; 
         negRect1height = 20;
         
         posRect2xco = 270; 
         posRect2yco = 90; 
         posRect2width = 20; 
         posRect2height = 20;
         negRect2xco = 300; 
         negRect2yco = 90; 
         negRect2width = 20; 
         negRect2height = 20;
         
         posRect3xco = 270; 
         posRect3yco = 150; 
         posRect3width = 20; 
         posRect3height = 20;
         negRect3xco = 300; 
         negRect3yco = 150; 
         negRect3width = 20; 
         negRect3height = 20;
         
         posRect4xco = 270; 
         posRect4yco = 210; 
         posRect4width = 20; 
         posRect4height = 20;
         negRect4xco = 300; 
         negRect4yco = 210; 
         negRect4width = 20; 
         negRect4height = 20;
         
         posRect5xco = 270; 
         posRect5yco = 270; 
         posRect5width = 20; 
         posRect5height = 20;
         negRect5xco = 300; 
         negRect5yco = 270; 
         negRect5width = 20; 
         negRect5height = 20;
         
         posRect6xco = 270; 
         posRect6yco = 330; 
         posRect6width = 20; 
         posRect6height = 20;
         negRect6xco = 300; 
         negRect6yco = 330; 
         negRect6width = 20; 
         negRect6height = 20;
         
         nextButtonxco = 270;
         nextButtonyco = 372;
         nextButtonWidth = 50;
         nextButtonHeight = 20;
      
         addMouseListener(this);
      } 
     
      /*
         Create a method for the beginning of the game
         where you can click buttons to add to your stats.
         Also, be able to choose your two traits for your
         population. Possibly make this a different screen 
         where it has a list of them and maybe a short description.
      */
      
      public void paint(Graphics g)
      {
         if(room == 0){
            //paint some sort of title screen
         }
         if(room == 2){//Stats Screen
            g.setColor(Color.blue);
            
            g.fillRect(posRect1xco,posRect1yco,posRect1width,posRect1height);
            g.fillRect(posRect2xco,posRect2yco,posRect2width,posRect2height);
            g.fillRect(posRect3xco,posRect3yco,posRect3width,posRect3height);
            g.fillRect(posRect4xco,posRect4yco,posRect4width,posRect4height);
            g.fillRect(posRect5xco,posRect5yco,posRect5width,posRect5height);
            g.fillRect(posRect6xco,posRect6yco,posRect6width,posRect6height);
            
            g.setColor(Color.red);
            
            g.fillRect(negRect1xco,negRect1yco,negRect1width,negRect1height);
            g.fillRect(negRect2xco,negRect2yco,negRect2width,negRect2height);
            g.fillRect(negRect3xco,negRect3yco,negRect3width,negRect3height);
            g.fillRect(negRect4xco,negRect4yco,negRect4width,negRect4height);
            g.fillRect(negRect5xco,negRect5yco,negRect5width,negRect5height);
            g.fillRect(negRect6xco,negRect6yco,negRect6width,negRect6height);
            
            g.setColor(Color.gray);
            g.fillRect(nextButtonxco,nextButtonyco,nextButtonWidth,nextButtonHeight);
            
            g.setColor(Color.yellow);
            
            for(int i = 0; i < 6; i++){
               g.drawString("-", 306, 44+60*i);
               g.drawString("+", 276, 44+60*i);
            } 
            
            g.setColor(Color.black);
            
            g.drawString("PICK YOUR STATS", 150, 15);
            g.drawString("Next", 282, 386);
            
            g.drawString("Strength: " + pop.St, 60, 50);
            g.drawString("Defense: " + pop.De, 60, 110);
            g.drawString("Speed: " + pop.Sp, 60, 170);
            g.drawString("Intelligence: " + pop.In, 60, 230);
            g.drawString("Disease Resistance: " + pop.DR, 60, 290);
            g.drawString("Hunting Efficiency: " + pop.HE, 60, 350);
            g.drawString("Extra Points: " + pop.extraPoints, 60, 386);
         }
         else if(room == 1){//Evolution Traits Screen
            g.setColor(Color.gray);//reusing prev rectangles to save space
            g.fillRect(nextButtonxco,nextButtonyco,nextButtonWidth,nextButtonHeight);
            if(pop.PT == true)
               g.setColor(Color.yellow);
            g.fillRect(negRect1xco,negRect1yco+10,negRect1width,negRect1height);
            g.setColor(Color.gray);
            if(pop.Sw == true)
               g.setColor(Color.yellow);
            g.fillRect(negRect2xco,negRect2yco+10,negRect2width,negRect2height);
            g.setColor(Color.gray);
            if(pop.Om == true)
               g.setColor(Color.yellow);
            g.fillRect(negRect3xco,negRect3yco+10,negRect3width,negRect3height);
            g.setColor(Color.gray);
            if(pop.WP == true)
               g.setColor(Color.yellow);
            g.fillRect(negRect4xco,negRect4yco+10,negRect4width,negRect4height);
            g.setColor(Color.gray);
            if(pop.EC == true)
               g.setColor(Color.yellow);
            g.fillRect(negRect5xco,negRect5yco+10,negRect5width,negRect5height);
            
            g.setColor(Color.black);
            g.drawString("PICK YOUR EVOLUTION TRAITS", 125, 15);
            g.drawString("Next", 282, 386);
            
            g.drawString("Prehensile Tail", 60, 50);
            g.drawString("Makes your monkeys better at climbing.", 75, 80);
            g.drawString("Swimming", 60, 110);
            g.drawString("Cross rivers easier.", 75, 140);
            g.drawString("Omnivore", 60, 170);
            g.drawString("Collect more food when hunting.", 75, 200);
            g.drawString("Well Prepared", 60, 230);
            g.drawString("Start with more food and population.", 75, 260);
            g.drawString("Extra Chromosome", 60, 290);
            g.drawString("Gives you more stat points to use.", 75, 320);
            g.drawString("Traits Left: " + pop.evPoints, 60, 386);   
         }
         
         else if(room == 3){//Main Game
            int turns = 30;
            Event EV = new Event();
            do{
               setBackground(new Color(R,G,B));
               EV.RunEvent(pop);
               g.drawImage(setBg(EV.getBg()),0,0,this);
               if(EV.getBg() == 2){
                  g.drawImage(rivalMonkeys,0,0,this); //xy tbd
               }
               if(EV.getBg() == 8){
                  g.drawImage(deadMonkey,0,0,this); //xy tbd
               }
               turns--;
               if(R>0)
                  R -= 50;
               if(G>25)
                  G -= 25;
            }while(pop.size > 1 || turns > 0);
            
            FinalBoss fb = new FinalBoss(pop);
            fb.fight();
            if(fb.isWin() == true)
               room = 4;
            else
               room = 5;
         }
         
         else if(room == 4){
            //you win screen
         }
         
         else if(room == 5){
            //you lose screen
         }
      }
      
      /*
         Create a method that randomly chooses which
         event happens when you go to the next screen.
         Make some events more likely than others
         like the clearing and small traps. 
         (Most likely nested inside the "room 3" if statement)
      */
      
      /*
         Need to make a boss/big end game event to
         test the player's population and see if they
         survive. 
      */
      
      public void mousePressed (MouseEvent me) 
      {
         xpos = me.getX();
         ypos = me.getY();
         if(room == 2){
            if (xpos>posRect1xco && xpos<posRect1xco + posRect1width && ypos>posRect1yco && ypos<posRect1yco + posRect1height && pop.extraPoints > 0 && pop.St < 10){ 
               pop.St++;
               pop.extraPoints--; 
            }   
            if (xpos>negRect1xco && xpos<negRect1xco + negRect1width && ypos>negRect1yco && ypos<negRect1yco + negRect1height && pop.De > 0){ 
               pop.St--;
               pop.extraPoints++;
            }           
            if (xpos>posRect2xco && xpos<posRect2xco + posRect2width && ypos>posRect2yco && ypos<posRect2yco + posRect2height && pop.extraPoints > 0 && pop.De < 10){  
               pop.De++;
               pop.extraPoints--;
            }
            if (xpos>negRect2xco && xpos<negRect2xco + negRect2width && ypos>negRect2yco && ypos<negRect2yco + negRect2height && pop.De > 0){  
               pop.De--;
               pop.extraPoints++;
            }
            if (xpos>posRect3xco && xpos<posRect3xco + posRect3width && ypos>posRect3yco && ypos<posRect3yco + posRect3height && pop.extraPoints > 0 && pop.Sp < 10){  
               pop.Sp++;
               pop.extraPoints--;
            }  
            if (xpos>negRect3xco && xpos<negRect3xco + negRect3width && ypos>negRect3yco && ypos<negRect3yco + negRect3height && pop.Sp > 0){  
               pop.Sp--;
               pop.extraPoints++;
            }
            if (xpos>posRect4xco && xpos<posRect4xco + posRect4width && ypos>posRect4yco && ypos<posRect4yco + posRect4height && pop.extraPoints > 0 && pop.In < 10){  
               pop.In++;
               pop.extraPoints--;
            }   
            if (xpos>negRect4xco && xpos<negRect4xco + negRect4width && ypos>negRect4yco && ypos<negRect4yco + negRect4height && pop.In > 0){     
               pop.In--;
               pop.extraPoints++;
            }
            if (xpos>posRect5xco && xpos<posRect5xco + posRect5width && ypos>posRect5yco && ypos<posRect5yco + posRect5height && pop.extraPoints > 0 && pop.DR < 5){  
               pop.DR++;
               pop.extraPoints--;
            }  
            if (xpos>negRect5xco && xpos<negRect5xco + negRect5width && ypos>negRect5yco && ypos<negRect5yco + negRect5height && pop.DR > 0){   
               pop.DR--;
               pop.extraPoints++;
            }
            if (xpos>posRect6xco && xpos<posRect6xco + posRect6width && ypos>posRect6yco && ypos<posRect6yco + posRect6height && pop.extraPoints > 0 && pop.HE < 5){  
               pop.HE++;
               pop.extraPoints--;
            }  
            if (xpos>negRect6xco && xpos<negRect6xco + negRect6width && ypos>negRect6yco && ypos<negRect6yco + negRect6height && pop.HE > 0){ 
               pop.HE--;
               pop.extraPoints++;
            }    
            if (xpos>nextButtonxco && xpos<nextButtonxco+nextButtonWidth && ypos>nextButtonyco && ypos<nextButtonyco+nextButtonHeight)
               room++;
         }
         
         else if(room == 1){
            if (xpos>negRect1xco && xpos<negRect1xco + negRect1width && ypos>negRect1yco+10 && ypos<negRect1yco+10 + negRect1height){  
               if(pop.PT == false && pop.evPoints > 0){
                  pop.evPoints--;
                  pop.PT = true;
               }
               else if(pop.PT == true && pop.evPoints < 2){
                  pop.evPoints++;
                  pop.PT = false;
               }
            }
            if (xpos>negRect2xco && xpos<negRect2xco + negRect2width && ypos>negRect2yco+10 && ypos<negRect2yco+10 + negRect2height)  
               if(pop.Sw == false && pop.evPoints > 0){
                  pop.evPoints--;
                  pop.Sw = true;
               }
               else if(pop.Sw == true && pop.evPoints < 2){
                  pop.evPoints++;
                  pop.Sw = false;
               }
            }
            if (xpos>negRect3xco && xpos<negRect3xco + negRect3width && ypos>negRect3yco+10 && ypos<negRect3yco+10 + negRect3height){
               if(pop.Om == false && pop.evPoints > 0){
                  pop.evPoints--;
                  pop.Om = true;;
               }
               else if(pop.Om == true && pop.evPoints < 2){
                  pop.evPoints++;
                  pop.Om = false;
               }
            }     
            if (xpos>negRect4xco && xpos<negRect4xco + negRect4width && ypos>negRect4yco+10 && ypos<negRect4yco+10 + negRect4height){
               if(pop.WP == false && pop.evPoints > 0){
                  pop.evPoints--;
                  pop.WP = true;
                  pop.size += 100;
                  pop.food += 200;
               }
               else if(pop.WP == true && pop.evPoints < 2){
                  pop.evPoints++;
                  pop.WP = false;
                  pop.size -= 100;
                  pop.food -= 200;
               }
            }               
            if (xpos>negRect5xco && xpos<negRect5xco + negRect5width && ypos>negRect5yco+10 && ypos<negRect5yco+10 + negRect5height){
               if(pop.EC == false && pop.evPoints > 0){
                  pop.evPoints--;
                  pop.EC = true;
                  pop.extraPoints += 5;
               }
               else if(pop.EC == true && pop.evPoints < 2){
                  pop.evPoints++;
                  pop.EC = false;
                  pop.extraPoints -= 5;
               }
            } 
            if (xpos>nextButtonxco && xpos<nextButtonxco+nextButtonWidth && ypos>nextButtonyco && ypos<nextButtonyco+nextButtonHeight)
               room++;
         repaint();
         me.consume();          
      }
      
      public Image setBg(int x){
         if(x == 0){
            return img0;
         }
         else if(x == 1){
            return img1;
         }
         else if(x == 2){
            return img2;
         }
         else if(x == 3){
            return img3;
         }
         else if(x == 4){
            return img4;
         }
         else if(x == 5){
            return img5;
         }
         else if(x == 6){
            return img6;
         }
         else if(x == 7){
            return img7;
         }
         else if(x == 8){
            return img8;
         }
         else if(x == 9){
            return img9;
         }
         else
            return null;
      }
       
      public void mouseEntered (MouseEvent me) {} 
      public void mouseClicked (MouseEvent me) {} 
      public void mouseReleased (MouseEvent me) {}  
      public void mouseExited (MouseEvent me) {}  
   }
