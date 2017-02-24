package Operation;

import javax.swing.JLabel;

public abstract class Operation {
	
	
	public String toString(){
		return this.getClass().getSimpleName();
	}
	
	abstract public JLabel getLabel();
}
