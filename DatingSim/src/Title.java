import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class Title extends JFrame implements MouseListener
{

	Graphics g;
	BufferedImage titleImage;
	BufferedImage helpImage;
	BufferedImage creditImage;
	BufferedImage guysImage;
	BufferedImage[] joshImages=new BufferedImage[5];
	BufferedImage[] dannyImages=new BufferedImage[5];
	BufferedImage[] tylerImages=new BufferedImage[5];
	BufferedImage code;
	BufferedImage nerdCode;
	BufferedImage twinsCode;
	BufferedImage gothCode;
	BufferedImage normalCode;
	BufferedImage failure;
	int opening = 0;
	String guy="";
	int menuNum=0;
	Girls nerd= new Girls("code","Nerd");
	Girls twins= new Girls("code","Twins");
	Girls goth= new Girls("code","Goth");
	Girls normal= new Girls("code","Normal");
	int conversation = 0;

	public BufferedImage image(String filename){
		File file = new File(filename);
		try{
			return ImageIO.read(file);
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(null,"file "+filename+" not found");
		}
		return null;
	}
	public Title(){
		titleImage= image("Title.jpg");
		helpImage= image("Help.jpg");
		creditImage= image("Credits.jpg");
		guysImage= image("Guys.jpg");
		joshImages[1]= image("Josh0.jpg");
		joshImages[2]= image("Josh1.jpg");
		joshImages[3]= image("Josh2.jpg");
		joshImages[4]= image("Josh3.jpg");
		dannyImages[1]= image("Danny0.jpg");
		dannyImages[2]= image("Danny1.jpg");
		dannyImages[3]= image("Danny2.jpg");
		dannyImages[4]= image("Danny3.jpg");
		tylerImages[1]= image("Tyler0.jpg");
		tylerImages[2]= image("Tyler1.jpg");
		tylerImages[3]= image("Tyler2.jpg");
		tylerImages[4]= image("Tyler3.jpg");
		code= image("Codeback.jpg");
		failure= image("Rejection.jpg");
		nerdCode= image("code\\nerdCode.png");
		gothCode= image("code\\gothCode.png");
		twinsCode= image("code\\twinsCode.png");
		normalCode= image("code\\normalCode.png");
		

		this.setTitle("Dating Simulator");
		this.setSize(800,625);
		this.addMouseListener(this); //notices you can click
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //This is so if you close the window the program ends
		this.setResizable(false); //people can't change the size of your window and show blank space
		this.setVisible(true);
		g=this.getGraphics();
	}
	public static void main(String []args){
		Music music = new Music("TT.wav");
		music.start();	
		new Title();
	}

	public void paint(Graphics g){
		g.drawImage(titleImage, 0, 25, null);
	}


	public void option(int x){
		if(x==1){
			System.out.println("Play");
			g.drawImage(guysImage, 0, 25, null);
			menuNum=3;
		}
		if(x==2){
			System.out.println("Help");
			g.drawImage(helpImage, 0, 25, null);
			menuNum=1;
		}
		if(x==3){
			System.out.println("Credits");
			g.drawImage(creditImage, 0, 25, null);
			menuNum=1;
		}
		if(x==4){
			System.out.println("Back");
			g.drawImage(titleImage, 0, 25, null);
			menuNum=0;
		}
		if(x==5){
			System.out.println("J");
			guy="Josh";
			menuNum=4;
			g.drawImage(joshImages[opening], 0, 25, null);
			opening++;
			if(opening==joshImages.length){
				menuNum=7;
			}
		}
		if(x==6){
			System.out.println("D");
			guy="Danny";
			menuNum=5;
			g.drawImage(dannyImages[opening], 0, 25, null);
			opening++;
			if(opening==dannyImages.length){
				menuNum=7;
			}
		}
		if(x==7){
			System.out.println("T");
			guy="Tyler";
			menuNum=6;
			g.drawImage(tylerImages[opening], 0, 25, null);
			opening++;
			if(opening==tylerImages.length){
				menuNum=7;
			}
		}

	}

	public void nerdConv(int x){
		if(x==0){
			g.drawImage(nerd.getFirstImpression(), 0, 25, null);
			g.drawImage(image("Nerd\\conversation0.png"), 0, 25, null);
			menuNum = 8;
			conversation ++;
		}
		if(x==1){
			g.drawImage(nerd.getNeutral(),0,25,null);
			g.drawImage(image("Nerd\\conversation1.png"), 0, 25, null);
			conversation ++;
		}
		if(x==2){
			g.drawImage(nerd.getHappy(),0,25,null);
			g.drawImage(image("Nerd\\conversation2.png"), 0, 25, null);
			conversation ++;
		}
		if(x==3){
			g.drawImage(nerd.getSad(),0,25,null);
			g.drawImage(image("Nerd\\conversation3.png"), 0, 25, null);
			conversation ++;
		}
		if(x==4){
			g.drawImage(nerd.getAngry(),0,25,null);
			g.drawImage(image("Nerd\\conversation4.png"), 0, 25, null);
			conversation ++;
		}	
		if(x==5){
			g.drawImage(failure, 0, 25, null);
			conversation=6;
		}
		if(x==6){
			System.out.println(nerd.getCode());
			g.drawImage(code,0,25,null);
			g.drawImage(nerdCode, 0, 25, null);
			conversation=6;
		}
	}

	public void twinsConv(int x){
		if(x==0){
			g.drawImage(twins.getNeutral(),0,25,null);
			g.drawImage(image("Twins\\conversation0.png"), 0, 25, null);
			menuNum = 9;
			conversation ++;
		}
		if(x==1){
			g.drawImage(twins.getHappy(),0,25,null);
			g.drawImage(image("Twins\\conversation1.png"), 0, 25, null);
			conversation ++;
		}
		if(x==2){
			g.drawImage(twins.getSad(),0,25,null);
			g.drawImage(image("Twins\\conversation2.png"), 0, 25, null);
			conversation ++;
		}
		if(x==3){
			g.drawImage(twins.getAngry(),0,25,null);
			g.drawImage(image("Twins\\conversation3.png"), 0, 25, null);
			conversation ++;
		}
		if(x==4){
			g.drawImage(twins.getFirstImpression(),0,25,null);
			g.drawImage(image("Twins\\conversation4.png"), 0, 25, null);
			conversation ++;
		}
		if(x==5){
			g.drawImage(failure, 0, 25, null);
			conversation=11;
		}
		if(x==6){
			System.out.println(twins.getCode());
			g.drawImage(code,0,25,null);
			g.drawImage(twinsCode, 0, 25, null);
			conversation=11;
		}
	}

	public void gothConv(int x){
		if(x==0){
			g.drawImage(goth.getFirstImpression(),0,25,null);
			g.drawImage(image("Goth\\conversation0.png"),0,25,null);
			menuNum=10;
			conversation ++;
			}
		if(x==1){
			g.drawImage(goth.getNeutral(),0,25,null);
			g.drawImage(image("Goth\\conversation1.png"),0,25,null);
			conversation ++;
			}
		if(x==2){
			g.drawImage(goth.getSad(),0,25,null);
			g.drawImage(image("Goth\\conversation2.png"),0,25,null);
			conversation ++;
			}
		if(x==3){
			g.drawImage(goth.getFirstImpression(),0,25,null);
			g.drawImage(image("Goth\\conversation3.png"),0,25,null);
			conversation ++;
			}
		if(x==4){
			g.drawImage(goth.getHappy(),0,25,null);
			g.drawImage(image("Goth\\conversation4.png"),0,25,null);
			conversation ++;
		}
		if(x==5){
			g.drawImage(failure, 0, 25, null);
			conversation = 16;
		}
		if(x==6){
			System.out.println(goth.getCode());
			g.drawImage(code,0,25,null);
			g.drawImage(gothCode, 0, 25, null);
			conversation = 16;
		}
	}

	public void normalConv(int x){
		if(x==0){
			g.drawImage(normal.getFirstImpression(),0,25,null);
			g.drawImage(image("Normal\\conversation0.png"),0,25,null);
			menuNum=11;
			conversation ++;
			}
		if(x==1){
			g.drawImage(normal.getNeutral(),0,25,null);
			g.drawImage(image("Normal\\conversation1.png"),0,25,null);
			conversation ++;
			}
		if(x==2){
			g.drawImage(normal.getHappy(),0,25,null);
			g.drawImage(image("Normal\\conversation2.png"),0,25,null);
			conversation ++;
			}
		if(x==3){
			g.drawImage(normal.getSad(),0,25,null);
			g.drawImage(image("Normal\\conversation3.png"),0,25,null);
			conversation ++;
			}
		if(x==4){
			g.drawImage(normal.getAngry(),0,25,null);
			g.drawImage(image("Normal\\conversation4.png"),0,25,null);
			conversation ++;
			}
		if(x==5){
			g.drawImage(failure, 0, 25, null);
			conversation= 22;
		}
		if(x==6){
			System.out.println(normal.getCode());
			g.drawImage(code,0,25,null);
			g.drawImage(normalCode, 0, 25, null);
			conversation= 22;
		}
	}

//BY MINDY AND STEPHANIE
	
	public void mouseClicked(MouseEvent arg0){
		//Mouse Clicks for main menu
		if(arg0.getX() >= 470 && arg0.getX() <= 780 && arg0.getY() >= 25+25 && arg0.getY() <= 130+25 && menuNum==0){
			option(1);
		}
		else if(arg0.getX() >= 470 && arg0.getX() <= 780 && arg0.getY() >= 160+25 && arg0.getY() <= 266+25 && menuNum==0){
			option(2);
		}
		else if(arg0.getX() >= 470 && arg0.getX() <= 780 && arg0.getY() >= 312+25 && arg0.getY() <= 418+25 && menuNum==0){
			option(3);
		}
		else if(arg0.getX() >= 16 && arg0.getX() <= 98 && arg0.getY() >= 529+25 && arg0.getY() <= 584+25 && menuNum==1){
			option(4);
		}

		//Mouse Clicks for guys menu
		else if(arg0.getX() >= 14 && arg0.getX() <= 268 && arg0.getY() >= 80+25 && arg0.getY() <= 488+25 && menuNum==3){
			option(5);
		}
		else if(arg0.getX() >= 280 && arg0.getX() <= 534 && arg0.getY() >= 80+25 && arg0.getY() <= 490+25 && menuNum==3){
			option(6);
		}
		else if(arg0.getX() >= 540 && arg0.getX() <= 795 && arg0.getY() >= 80+25 && arg0.getY() <= 490+25 && menuNum==3){
			option(7);
		}
		else if(arg0.getX() >= 0 && arg0.getX() <= 800 && arg0.getY() >= 0+25 && arg0.getY() <= 600+25 && menuNum==4){
			option(5);
		}
		else if(arg0.getX() >= 0 && arg0.getX() <= 800 && arg0.getY() >= 0+25 && arg0.getY() <= 600+25 && menuNum==5){
			option(6);
		}
		else if(arg0.getX() >= 0 && arg0.getX() <= 800 && arg0.getY() >= 0+25 && arg0.getY() <= 600+25 && menuNum==6){
			option(7);
		}
		else if(arg0.getX() >= 0 && arg0.getX() <= 800 && arg0.getY() >= 0+25 && arg0.getY() <= 600+25 && menuNum==7){
			nerdConv(0);
		}

		//Girls menu
		//Nerd
		else if(arg0.getX() >= 514 && arg0.getX() <= 786 && arg0.getY() >= 414+25 && arg0.getY() <= 484+25 && menuNum==8){
			if(conversation==1){
				nerdConv(1);
			}
			else if(conversation==2){
				nerdConv(2);
			} 
			else if(conversation==3){
				nerdConv(3);
			} 
			else if(conversation==4){
				nerdConv(4);
			} 
			else if(conversation==5){
				nerdConv(6);
			} 
		}
		else if(arg0.getX() >= 514 && arg0.getX() <= 786 && arg0.getY() >= 512+25 && arg0.getY() <= 580+25 && menuNum==8){
			if(conversation==1){
				nerdConv(5);
			}
			else if(conversation==2){
				nerdConv(5);
			} 
			else if(conversation==3){
				nerdConv(5);
			} 	
			else if(conversation==4){
				nerdConv(5);
			} 
			else if(conversation==5){
				nerdConv(6);
			} 	
		}
		// twins
		else if(arg0.getX() >= 514 && arg0.getX() <= 786 && arg0.getY() >= 414+25 && arg0.getY() <= 484+25 && menuNum==9){
			if(conversation==7){
				twinsConv(5);
			}
			else if(conversation==8){
				twinsConv(2);
			} 
			else if(conversation==9){
				twinsConv(3);
			} 
			else if(conversation==10){
				twinsConv(4);
			} 
			else if(conversation==11){
				twinsConv(6);
			} 
		}

		else if(arg0.getX() >= 514 && arg0.getX() <= 786 && arg0.getY() >= 512+25 && arg0.getY() <= 580+25 && menuNum==9){
			if(conversation==7){
				twinsConv(1);
			}
			else if(conversation==8){
				twinsConv(5);
			} 
			else if(conversation==9){
				twinsConv(5);
			} 	
			else if(conversation==10){
				twinsConv(5);
			} 
			else if(conversation==11){
				twinsConv(6);
			} 	
		}
		//goth
		else if(arg0.getX() >= 514 && arg0.getX() <= 786 && arg0.getY() >= 414+25 && arg0.getY() <= 484+25 && menuNum==10){
			if(conversation==12){
				gothConv(1);
			}
			else if(conversation==13){
				gothConv(5);
			} 
			else if(conversation==14){
				gothConv(5);
			} 
			else if(conversation==15){
				gothConv(5);
			} 
			else if(conversation==16){
				gothConv(6);
			} 
		}
		else if(arg0.getX() >= 514 && arg0.getX() <= 786 && arg0.getY() >= 512+25 && arg0.getY() <= 580+25 && menuNum==10){
			if(conversation==12){
				gothConv(5);
			}
			else if(conversation==13){
				gothConv(2);
			} 
			else if(conversation==14){
				gothConv(3);
			} 	
			else if(conversation==15){
				gothConv(4);
			} 
			else if(conversation==16){
				gothConv(6);
			} 	
		}
		//normal
		else if(arg0.getX() >= 514 && arg0.getX() <= 786 && arg0.getY() >= 414+25 && arg0.getY() <= 484+25 && menuNum==11){
			if(conversation==17){
				normalConv(1);
			}
			else if(conversation==18){
				normalConv(5);
			} 
			else if(conversation==19){
				normalConv(5);
			} 
			else if(conversation==20){
				normalConv(4);
			} 
			else if(conversation==21){
				normalConv(6);
			} 
		}
		else if(arg0.getX() >= 514 && arg0.getX() <= 786 && arg0.getY() >= 512+25 && arg0.getY() <= 580+25 && menuNum==11){
			if(conversation==17){
				normalConv(5);
			}
			else if(conversation==18){
				normalConv(2);
			} 
			else if(conversation==19){
				normalConv(3);
			} 	
			else if(conversation==20){
				normalConv(5);
			} 
			else if(conversation==21){
				normalConv(6);
			} 	
		}
		
		else if(arg0.getX() >=0 && arg0.getX() <= 800 && arg0.getY() >= 0 && arg0.getY() <= 600){
			if(conversation==6){
				twinsConv(0);
			}
			else if(conversation==11){
				gothConv(0);
			}
			else if(conversation==16){
				normalConv(0);
			}
			else if(conversation==22){
				//put in enter code image
				
				String codeEntered = JOptionPane.showInputDialog("Enter your code.");
				System.out.println(codeEntered);
				if(!(codeEntered.equalsIgnoreCase("sexysexy") ||codeEntered.equalsIgnoreCase("harrypotter")
						||codeEntered.equalsIgnoreCase("darkspace")||codeEntered.equalsIgnoreCase("gossip"))){
					g.drawImage(image("Fail\\"+guy+".jpg"), 0, 25, null);
				}
				else{
					if(codeEntered.equalsIgnoreCase("sexysexy")){
						if(guy=="Danny"){
							g.drawImage(twins.getDanny(),0,25,null);
						}
						if(guy=="Tyler"){
							g.drawImage(twins.getTyler(),0,25,null);
						}
						if(guy=="Josh"){
							g.drawImage(twins.getJosh(),0,25,null);
						}
					}
					if(codeEntered.equalsIgnoreCase("harrypotter")){
						if(guy=="Danny"){
							g.drawImage(nerd.getDanny(),0,25,null);
						}
						if(guy=="Tyler"){
							g.drawImage(nerd.getTyler(),0,25,null);
						}
						if(guy=="Josh"){
							g.drawImage(nerd.getJosh(),0,25,null);
						}
					}
					if(codeEntered.equalsIgnoreCase("gossip")){
						if(guy=="Danny"){
							g.drawImage(normal.getDanny(),0,25,null);
						}
						if(guy=="Tyler"){
							g.drawImage(normal.getTyler(),0,25,null);
						}
						if(guy=="Josh"){
							g.drawImage(normal.getJosh(),0,25,null);
						}
					}
					if(codeEntered.equalsIgnoreCase("darkspace")){
						if(guy=="Danny"){
							g.drawImage(goth.getDanny(),0,25,null);
						}
						if(guy=="Tyler"){
							g.drawImage(goth.getTyler(),0,25,null);
						}
						if(guy=="Josh"){
							g.drawImage(goth.getJosh(),0,25,null);
						}
					}
				}
			}
		}
	}

public void mouseEntered(MouseEvent arg0){
}
@Override
public void mouseExited(MouseEvent arg0){
}
@Override
public void mousePressed(MouseEvent arg0){
}
@Override
public void mouseReleased(MouseEvent arg0){
}
}
