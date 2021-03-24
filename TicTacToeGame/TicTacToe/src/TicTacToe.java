import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener
{
	Random random = new Random();
	JFrame frame = new JFrame();
	JLabel textfield = new JLabel();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JPanel button_panel2 = new JPanel();
	JButton[] buttons = new JButton[9]; // Arayüzdeki büyük butonlarýn oluþturulmasý için kullanýlan kod.
	JButton restart_button = new JButton();
	boolean player1_turn; // Turun kimde olduðunu tutmak için boolean oluþturuldu. False ise player 2 true ise player 1 in turu olacak.

	
	TicTacToe()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,900);
		frame.getContentPane().setBackground(new Color(50,50,50)); 
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(255,255,0));
		textfield.setForeground(new Color(25,25,25));
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Welcome to Tic-Tac-Toe Game!");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,900,100);
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i = 0; i < 9 ; i++)
		{
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD , 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
			
		firstTurn();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i<9 ; i++) //Burada oyun boyunca üst bölümde sýranýn kimde olduðunu belirten kodu yazdýk.
		{
			if(e.getSource()== buttons[i])
			{
				if(player1_turn)
				{
					if(buttons[i].getText() == "" )
					{
						buttons[i].setForeground(new Color(0,0,255)); // X in rengi mavi oldu.
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O Turn");
						check();
					}
				}
				
				else 
				{
					if(buttons[i].getText() == "" )
					{
						buttons[i].setForeground(new Color(255,0,0)); // Y in rengi mavi oldu.
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X Turn");
						check();
					}
				}
			}
		}
		
	}
	
	public void firstTurn()
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2) == 0)
		{
			player1_turn = true;
			textfield.setText("X turn");
		}
		
		else 
		{
			player1_turn = false;
			textfield.setText("O turn");
		}
	}
	
	public void check() 
	{
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			x_wins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			x_wins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			x_wins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			x_wins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			x_wins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			x_wins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			x_wins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			x_wins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			o_wins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			o_wins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			o_wins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			o_wins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			o_wins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			o_wins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			o_wins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			o_wins(2,4,6);
		}
		
		
			
		
		
	}
	
	public void x_wins(int x, int y, int z)
	{
		buttons[x].setBackground(Color.GREEN);
		buttons[y].setBackground(Color.GREEN);
		buttons[z].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9 ; i++)
		{
			buttons[i].setEnabled(false);
		}
		textfield.setText("X Won the Game!");
	}
	
	public void o_wins(int x, int y, int z)
	{
		buttons[x].setBackground(Color.GREEN);
		buttons[y].setBackground(Color.GREEN);
		buttons[z].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9 ; i++)
		{
			buttons[i].setEnabled(false);
		}
		textfield.setText("O Won the Game!");
	}

}
