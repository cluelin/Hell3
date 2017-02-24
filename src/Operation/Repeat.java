package Operation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Repeat extends Operation{

	LinkedList<Operation> opertionList = new LinkedList<Operation>();
	int repeatCount;
	String label;
	
	
	public Repeat(int repeatCount, String label) {

		this.repeatCount = repeatCount;
		this.label = label;
	}
	
	public int getRepeatCount() 
	{
		return this.repeatCount;
	}
	
	public LinkedList<Operation> getOpertionList() {
		return opertionList;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(repeatCount + "È¸ ¹Ýº¹ - ");
	}
	
	

	@Override
	public JLabel getLabel() {
		// TODO Auto-generated method stub
		
		JLabel operateLabel = new JLabel();
		operateLabel.setLayout(new BorderLayout());
		
		
		JLabel temp = new JLabel("            " + repeatCount);
		temp.setLayout(new BorderLayout());
		temp.setBackground(Color.black);

		
		try {
			Image img = ImageIO.read(new File("resources/repeat_1.png"));
			operateLabel.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		operateLabel.add(temp, BorderLayout.WEST);
		
		
		
		return operateLabel;
	}


}
