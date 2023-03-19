import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {

	Random random = new Random();			// random player
	JFrame frame = new JFrame();			//the whole frame
	JPanel title_panel = new JPanel();		//title
	JPanel button_panel = new JPanel();		// button panel
	JLabel textfield = new JLabel();      	// textfield box
	JButton[] buttons = new JButton[9]; 	// # of  buttons we need
	boolean player1_turn;					//true when player 1 plays first, false when player 2 plays first
	
	
	TicTacToe(){
		
		//frame design
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		//textfield design
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		//title panel design
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		//button panel design
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.ORANGE);
		
		
	
		
		
		//adding buttons
		for (int i=0; i<9; i++) {
			
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
		}
		
		
		//adding textfield,title panel and button panel
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//checking each of 9 buttons
		for (int i=0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.CYAN);
						buttons[i].setText("X");
						player1_turn = false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.RED);
						buttons[i].setText("O");
						player1_turn = true;
						textfield.setText("X turn");
						check();
					}
				}
			
			}
			
		}
		
	}
	//randomly selecting first player
	public void firstTurn()  {
		
		//picking turn delay 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//random turn pick
		if(random.nextInt(2) == 0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn = false;
			textfield.setText("O turn");
		}
		
	}
	
	//checks who wins
	public void check() {
		
		//Checks for Draw
		 int i = 0;
	        while (buttons[i].getText() != "") {
	            if (i == buttons.length - 1) {
	                draw();
	                break;
	            }
	            i++;
	        }
		
		//checking  X winning combs
		if (
			(buttons[0].getText()=="X") &&
			(buttons[1].getText()=="X") &&
			(buttons[2].getText()=="X") 
			
			) {
				
			xWins(0,1,2);
		}
		
		if (
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X") 
				
				) {
					
				xWins(3,4,5);
			}
		if (
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X") 
				
				) {
					
				xWins(6,7,8);
			}
		if (
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X") 
				
				) {
					
				xWins(0,3,6);
			}
		if (
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X") 
				
				) {
					
				xWins(1,4,7);
			}
		if (
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X") 
				
				) {
					
				xWins(2,5,8);
			}
		if (
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X") 
				
				) {
					
				xWins(0,4,8);
			}
		if (
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X") 
				
				) {
					
				xWins(2,5,8);
			}
		if (
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X") 
				
				) {
					
				xWins(2,4,6);
			}
		
		
		//checking O winning combs
		if (
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O") 
				
				) {
					
				oWins(0,1,2);
			}
			
			if (
					(buttons[3].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[5].getText()=="O") 
					
					) {
						
					oWins(3,4,5);
				}
			if (
					(buttons[6].getText()=="O") &&
					(buttons[7].getText()=="O") &&
					(buttons[8].getText()=="O") 
					
					) {
						
					oWins(6,7,8);
				}
			if (
					(buttons[0].getText()=="O") &&
					(buttons[3].getText()=="O") &&
					(buttons[6].getText()=="O") 
					
					) {
						
					oWins(0,3,6);
				}
			if (
					(buttons[1].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[7].getText()=="O") 
					
					) {
						
					oWins(1,4,7);
				}
			if (
					(buttons[0].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[8].getText()=="O") 
					
					) {
						
					oWins(0,4,8);
				}
			if (
					(buttons[2].getText()=="O") &&
					(buttons[5].getText()=="O") &&
					(buttons[8].getText()=="O") 
					
					) {
						
					oWins(2,5,8);
				}
			if (
					(buttons[2].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[6].getText()=="O") 
					
					) {
						
					oWins(2,4,6);
				}
	
	
	}
	
	
	//if X wins
	public void xWins(int a, int b, int c) {
		//if X wins changing the color of the Winning Line
		buttons[a].setBackground(Color.red);
		buttons[b].setBackground(Color.red);
		buttons[c].setBackground(Color.red);
		
		//disabling all buttons
		for (int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X WINS!!!!");
	}
	//if O wins
	public void oWins (int a, int b, int c) {
		//if O wins changing the color of the Winning Line
		buttons[a].setBackground(Color.ORANGE);
		buttons[b].setBackground(Color.ORANGE);
		buttons[c].setBackground(Color.ORANGE);
		
		//disabling buttons
		for (int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O WINS!!!!");
		
	}
	

public void draw() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("DRAW!!!!");
    }
}
