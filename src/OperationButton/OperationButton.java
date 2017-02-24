package OperationButton;

import javax.swing.JButton;
import javax.swing.JLabel;

import Operation.Operation;

public abstract class OperationButton extends JButton{
	
	String name;
	
	public OperationButton() {
		// TODO Auto-generated constructor stub
	}
	
	public OperationButton(String name){
		super("");
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
	abstract public Operation GenerateNewOperateInstance();

}
