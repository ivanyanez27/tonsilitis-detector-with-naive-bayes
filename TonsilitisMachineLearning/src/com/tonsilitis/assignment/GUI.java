package com.tonsilitis.assignment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI extends JFrame implements ActionListener 
{
	private JLabel label1, label2, label3, label4;
	private	JComboBox<String> tempBox, achesBox, soreThroatBox;
	private JTextField tf1;
	private JPanel panel1, panel2, panel3, panel4, panel5;
	private JButton submit_button, eval_button;
	private String[] optionString = { "No", "Yes" };
	private String[] temperatureString = { "Hot", "Cool", "Normal" };
	private String temperatureInput, soreThroatInput, achesInput;
	private NaiveBayes nb;
	
	public GUI()
	{
		// set the title
		super("Tonsilitis Program");
		
		// instantiate the labels
		label1 = new JLabel("Temperature: ");
		label2 = new JLabel("Sore Throat: ");
		label3 = new JLabel("Aches: ");
		
		// instantiate combo boxes
		tempBox = new JComboBox<String>(temperatureString);
		achesBox = new JComboBox<String>(optionString);
		soreThroatBox = new JComboBox<String>(optionString);
		tempBox.setPreferredSize(new Dimension(150, 50));
		achesBox.setPreferredSize(new Dimension(150, 50));
		soreThroatBox.setPreferredSize(new Dimension(150, 50));
		
		// instantiate panels
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		
		// instantiate buttons
		submit_button = new JButton("Submit");
		eval_button = new JButton("Evaluate");
		submit_button.setPreferredSize(new Dimension(150, 50));
		eval_button.setPreferredSize(new Dimension(150, 50));
		
		// add action listeners
		submit_button.addActionListener(this);
		tempBox.addActionListener(this);
		achesBox.addActionListener(this);
		soreThroatBox.addActionListener(this);
		
		// add components
		panel1.add(label1);
		panel1.add(tempBox);
		panel2.add(label2);
		panel2.add(achesBox);
		panel3.add(label3);
		panel3.add(soreThroatBox);
		panel4.add(submit_button);
		panel4.add(eval_button);
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		
		// set screen layouts
		setLocation(400,100);
		setSize(800, 600);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		// if submit button pressed
		if(event.getSource() == submit_button)
		{			
			// get the values given by the user through the combo box
			setTemperatureInput(tempBox.getSelectedItem().toString());
			setAchesInput(achesBox.getSelectedItem().toString());
			setSoreThroatInput(soreThroatBox.getSelectedItem().toString());
			
			// pass the input from the boxes to the Naive Bayes classifier
			getTonsilitisResult();
		}
		
		// if evaluate button is pressed
		if(event.getSource() == eval_button)
		{
			
		}
	}
	
	// calculate the result; send the input to Naive Bayes class
	public void getTonsilitisResult()
	{	
		// insert in the input to the classifier
		nb = new NaiveBayes(temperatureInput, achesInput, soreThroatInput);
		JOptionPane.showMessageDialog(this, nb.calculateTonsilitis());
	}

	// getters & setters
	public String getTemperatureInput() 
	{
		return temperatureInput;
	}

	public void setTemperatureInput(String temperatureInput) 
	{
		this.temperatureInput = temperatureInput;
	}

	public String getSoreThroatInput() 
	{
		return soreThroatInput;
	}

	public void setSoreThroatInput(String soreThroatInput) 
	{
		this.soreThroatInput = soreThroatInput;
	}

	public String getAchesInput() 
	{
		return achesInput;
	}

	public void setAchesInput(String achesInput) 
	{
		this.achesInput = achesInput;
	}
	
	
}
