package OperationButton;

import Operation.Condition;

public class ConditionButton extends OperationButton{

	public ConditionButton() {
		// TODO Auto-generated constructor stub
	}
	
	public Operation.Operation GenerateNewOperateInstance() {
		return new Condition();
	};
}
