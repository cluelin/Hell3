package Operation;

// flag == 0 rotate left
// flag == 1 rotate right
public abstract class Rotate extends Operation
{
	int flag;
	
	public Rotate(int flag)
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
			return "RotateLeft();\n";
		}
		return "RotateRight();\n";
	}
}
