package Map;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
	private int map[][];
	private Point playerOriginPoint;
	
	public Map(String fileName, int x, int y) throws FileNotFoundException
	{
		map = new int[x + 2][y + 2];
		
		Scanner file = new Scanner(new File(fileName));
		
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				map[i][j] = file.nextInt();
			}
		}
		
		int inputX = file.nextInt();
		int inputY = file.nextInt();
		playerOriginPoint = new Point(inputX, inputY);
		
		// 외부 벽 생성
		for (int i = 0; i < x + 2; i++) {
			map[i][0] = -1;
			map[i][y + 1] = -1;
		}
		
		for (int i = 0; i < y + 2; i++) {
			map[0][i] = -1;
			map[x + 1][i] = -1;
		}
		
		file.close();
	}
	
	public boolean isWall(Point point)
	{
		if (map[point.x][point.y] == 1) {
			return true;
		}
		return false;
	}
	
	public boolean isCandy(Point point)
	{
		if (map[point.x][point.y] == 2) {
			return true;
		}
		return false;
	}
	
	public int getMap(int x, int y)
	{
		return map[x][y];
	}

	public Point getPlayerOriginPoint()
	{
		return playerOriginPoint;
	}
}
