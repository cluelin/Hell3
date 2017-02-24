package Operation;

// flag == 0 move forward
// flag == 1 move backward
public abstract class Move extends Operation
{
	int flag;
	
	public Move(int flag)
	{
		this.flag = flag;
	}
	
	public int getFlag()
	{
		return flag;
	}
	
	public String toString()
	{
		if (flag == 0) {
			return "MoveForward();\n";
		} 
		return "MoveBackward();\n";
	}
}
