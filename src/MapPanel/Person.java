package MapPanel;

import java.awt.Point;

public class Person {
	final int xMovement = 40;	// person's 
	final int yMovement = 40;	// person's 
	
	private Point currentPoint;	// person's current point
	private Point originPoint;	// person's original point
	private double angle;	// person's current angle
	
	// Constructor Overloading
	public Person()
	{
		setCurrentPoint(new Point(0, 0));
		//시작 위치를 저장해 준다. 
		setOriginPoint(getCurrentPoint());
		setAngle(0);
	}
	
	public Person(int x, int y)
	{
		setCurrentPoint(new Point(x, y));
		//시작 위치를 저장해 준다.
		setOriginPoint(getCurrentPoint());
		setAngle(0);
	}
	
	// character motion
	public void moveForward()
	{
		System.out.println(getCurrentPoint());
		System.out.println(getFrontPoint());
		setCurrentPoint(getFrontPoint());
	}
	
	public void moveBackward()
	{
		setCurrentPoint(getBackPoint());
	}
	
	public void rotateRight()
	{
		setAngle(getAngle() + (Math.PI / 2));
	}
	
	public void rotateLeft()
	{
		setAngle(getAngle() - (Math.PI / 2));
	}
	
	//시작위치로 돌아간다. 
	public void returnToOrigin()
	{
		setCurrentPoint(getOriginPoint());
	}
	
//	-------------------------------------
	
	
	// getter and setter
	public double getAngle() {
		return angle;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
		System.out.println(this.angle);
		if (this.angle < 0) {
			this.angle += 2 * Math.PI;
		}
		if (this.angle >= (2 * Math.PI)) {
			this.angle -= 2 * Math.PI;
		}
	}
	public int getxMovement() {
		return xMovement;
	}
	public int getyMovement() {
		return yMovement;
	}
	
	public Point getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(Point currentPoint) {
		this.currentPoint = currentPoint;
	}

	public Point getOriginPoint() {
		return originPoint;
	}

	public void setOriginPoint(Point originPoint) {
		this.originPoint = originPoint;
	}
	
	// get forward and back point functions
	public Point getBackPoint()
	{
		if (angle == 0) {
			return new Point(getCurrentPoint().x + 1, getCurrentPoint().y);
		} else if (angle == Math.PI / 2) {
			return new Point(getCurrentPoint().x, getCurrentPoint().y - 1);
		} else if (angle == Math.PI) {
			return new Point(getCurrentPoint().x - 1, getCurrentPoint().y);
		} else if (angle == Math.PI / 2 * 3) {
			return new Point(getCurrentPoint().x, getCurrentPoint().y + 1);
		}
		return null;
	}
	
	public Point getFrontPoint()
	{
		if (angle == 0) {
			return new Point(getCurrentPoint().x - 1, getCurrentPoint().y);
		} else if (angle == Math.PI / 2) {
			return new Point(getCurrentPoint().x, getCurrentPoint().y + 1);
		} else if (angle == Math.PI) {
			return new Point(getCurrentPoint().x + 1, getCurrentPoint().y);
		} else if (angle == Math.PI / 2 * 3) {
			return new Point(getCurrentPoint().x, getCurrentPoint().y - 1);
		}
		return null;
	}
}
