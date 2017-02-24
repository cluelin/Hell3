package Map;

import java.io.FileNotFoundException;

public class Stage {
	private Map[] maps;
	private int stageNumber;
	
	public Stage() throws FileNotFoundException
	{
		maps = new Map[5];
		
		for (int i = 0; i < maps.length; i++) {
			maps[i] = new Map(String.format("resources/map%d.txt", i), 10, 10);
		}
		
		setStageNumber(0);
	}
	
	public void setStageNumber(int stageNumber)
	{
		this.stageNumber = stageNumber;
		if (this.stageNumber == maps.length) {
			this.stageNumber = 0;
		}
	}
	
	public int getStageNumber()
	{
		return stageNumber;
	}
	
	public Map getCurrentMap()
	{
		return maps[getStageNumber()];
	}
}
