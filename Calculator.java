/**
 * 
 */
package CalculatorCode;

/**
 * 
 */
import javax.swing.*; //import all classes related to swing package for GUI (graphical user interface) 
import java.awt.*; //imports "Abstract Window Toolkit" package, creates GUIs in java
import java.awt.event.*; //imports AWT event package, used to handle interactions with GUI e.g,mouseEvent

public class Calculator implements ActionListener{

	/**
	 * @param args
	 */
	JFrame frame; //variable named frame to create GUI window using JFrame from AWT
	JTextField textfield; //variable named textfield to create field for the user to enter and display text
	JButton[] numberButtons = new JButton[10];//Array that represents buttons GUI that holds 10 digits (0-9)
	JButton[] functionButtons = new JButton[9];//Array that will hold buttons for mathematical functions like addition
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equaButton, delButton, clrButton, negButton;
	JPanel panel;//variable for panel/container
	
	Font myFont = new Font("Ink Free", Font.BOLD,30);//object that will control text style, size and style
	
	double num1=0, num2=0, result=0;//these double types will be the values used in the calculations
	char operator;//a character to store operators used in the calculations  
	
	Calculator() {
		
		frame = new JFrame("Calculator"); //Creating a new frame with Calculator as the title of the frame will be displayed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminate the application when the frame is closed
		frame.setSize(450, 550);//sets the dimensions of the JFrame (width, height) in pixels
		frame.setLayout(null);//sets the layout manager for the Frame to null
		
		textfield = new JTextField(); //Create text field
		textfield.setBounds(50, 25, 300, 50);//sets the position and size of the JTextField within the JFrame: setBounds(x, y, width, height)
		textfield.setFont(myFont);// font is specified to myFont
		textfield.setEditable(false);
		
		//buttons in the frame and how they are represented
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equaButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		//buttons are assigned to corresponding element
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equaButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i = 0; i < 9; i++) { //for loop that will not stop as long as i is less then 8
			functionButtons[i].addActionListener(this);//adds ActionListener to the current button in the loop, will be notified when the button is clicked.
			functionButtons[i].setFont(myFont);// sets the font of the current button to myFont
			functionButtons[i].setFocusable(false);//prevents the button from receiving keyboard focus
		}
		
		for(int i = 0; i < 10; i++) { 
			numberButtons[i] = new JButton(String.valueOf(i));//creates a new JButton, assign it to the corresponding numberButtons array
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		//sets the position and size of the button within the frame
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,125,50);
		clrButton.setBounds(250,430,120,50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 350, 300);
		panel.setLayout(new GridLayout(4,4,10,10)); //new GridLayout creates a GridLayout with:4 rows,4 columns,10 pixels gap between components
		panel.setBackground(Color.GREEN);
		
		//adding the number and operator buttons using the Grid layout 
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equaButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);//Adds the text field to the frame
		frame.setVisible(true);//makes the JFrame visible on the screen
				
	}
	
	
	public static void main(String[] args) {
		// calling the constructors
		Calculator calc = new Calculator();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++) { //loop iterates through the numberButtons array
			if(e.getSource() == numberButtons[i]) {//condition checks if the source of the event (button clicked) is the current button in the loop
				textfield.setText(textfield.getText().concat(String.valueOf(i)));//if the condition is true, display text
			}
		}
		
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());	
			operator = '+';
			textfield.setText("");
		}
		
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());	
			operator = '-';
			textfield.setText("");	
		}
		
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());	
			operator = '*';
			textfield.setText("");	
		}
		
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());	
			operator = '/';
			textfield.setText("");	
		}
		
		if(e.getSource() == equaButton) {
			num2 = Double.parseDouble(textfield.getText());	

			switch(operator) {
			case'+':
				result = num1 + num2;
				break;
				
			case'-':
				result = num1 - num2;
				break;
				
			case'*':
				result = num1 * num2;
				break;
				
			case'/':
				result = num1 / num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length()-1; i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
		
	}

}
