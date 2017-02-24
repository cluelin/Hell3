package CodePart;


import java.util.ArrayList;
import java.util.List;

import Operation.Condition;
import Operation.Move;
import Operation.Operation;
import Operation.Repeat;
import Operation.Rotate;

public class CodeMaker {
	private int indentation;
	private String code;
	
	public CodeMaker()
	{
		indentation = 0;
	}
	
	public String codeMake(List<Operation> operationQueue) 
	{
		ArrayList<Operation> operations = new ArrayList<Operation>();
		
		//copy queue
		for (Operation op : operationQueue) {
			operations.add(op);
		}
		
		String instanceCode = "";
		
		for (Operation op : operationQueue) {
			instanceCode += indent(indentation);
			if (op instanceof Repeat) {
				instanceCode += String.format("for (int i = 0; i < %d; i++) {\n", ((Repeat)op).getRepeatCount());
				indentation++;
				instanceCode += codeMake(((Repeat)op).getOpertionList());
				indentation--;
				
				instanceCode += indent(indentation);
				instanceCode += "}\n";
			} else if (op instanceof Condition) {
				instanceCode += String.format("if () {\n");
				indentation++;
				indentation--;
				instanceCode += indent(indentation);
				instanceCode += "}\n";
			} else if (op instanceof Move){
				if (((Move)op).getFlag() == 0) {
					instanceCode += "Move Forward(); \n";
				} else {
					instanceCode += "Move Backward(); \n";
				}
			} else if (op instanceof Rotate) {
				if (((Rotate)op).getFlag() == 0) {
					instanceCode += "Rotate Left(); \n";
				} else {
					instanceCode += "Rotate Right(); \n";
				}
			}
		}
		
		return instanceCode;
	}
	
	public String indent(int count)
	{
		String _return = "";
		
		for (int i = 0; i < count; i++) {
			_return += "\t";
		}
		
		return _return;
	}
}
