package MapPanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import GUIPackage.GUI;
import GUIPackage.GUIFrame;
import Operation.Condition;
import Operation.Move;
import Operation.Operation;
import Operation.Repeat;
import Operation.Rotate;

public class GameManager {
	private OperationQueue operationData;
	private QueueManager queueManager;
	private MapPanel objectPanel;
	
	public GameManager() throws IOException
	{
		operationData = new OperationQueue();
		queueManager = new QueueManager();
		objectPanel = new MapPanel();
		
	}
	
	// queue를 관리하는 클래스
	public class QueueManager 
	{
		public void operate(Queue<Operation> operationQueue)
		{
			ArrayList<Operation> operations = new ArrayList<Operation>();
			
			//copy queue
			for (Operation op : operationQueue) {
				operations.add(op);
			}
			
			// 주기적인 작업을 위한 
	        final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
			exec.scheduleAtFixedRate(new Runnable() {
				public void run() {
					try {
						Operation op = null;
						try {
							op = operations.remove(0);	
						} catch (Exception ex) {
							objectPanel.getPersonData().returnToOrigin();
							GUI.mainFrame.getOperationPanel().getStartButton().setEnabled(true);
							objectPanel.repaint();
							exec.shutdown();
							return;
						}
						
						if (op instanceof Move) {
							// move forward
							if (((Move) op).getFlag() == 0) {
								moveForward();
							}
							// move backward
							else {
								moveBackward();
							}
						} else if (op instanceof Repeat) {
							List<Operation> repeatOperation = new ArrayList<Operation>(
									((Repeat) op).getOpertionList());
							Collections.reverse(repeatOperation);

							// add first element to list
							for (int i = 0; i < ((Repeat) op).getRepeatCount(); i++) {
								for (Operation oper : repeatOperation) {
									operations.add(0, oper);
								}
							}
						} else if (op instanceof Rotate) {
							// turn left
							if (((Rotate) op).getFlag() == 0) {
								rotateLeft();
							}
							// turn right
							else {
								rotateRight();
							}
						} else if (op instanceof Condition) {
							// 아직 미정
						}
						
						// stage clear (character is on candy)
						if (objectPanel.getStage().getCurrentMap().isCandy(objectPanel.getPersonData().getCurrentPoint())) {
							// clear window
							GUI.mainFrame.clearCodePanel();
							GUI.mainFrame.resetList();
							operationData.clear();
							GUI.mainFrame.getOperationPanel().getStartButton().setEnabled(true);
							
							// go to next stage
							objectPanel.getStage().setStageNumber(objectPanel.getStage().getStageNumber() + 1);
							
							// change player's point
							objectPanel.getPersonData().setOriginPoint(objectPanel.getStage().getCurrentMap().getPlayerOriginPoint());
							objectPanel.getPersonData().setCurrentPoint(objectPanel.getStage().getCurrentMap().getPlayerOriginPoint());
							
							// image update
							objectPanel.imageUpdate();
							GUI.mainFrame.invalidate();
							GUI.mainFrame.repaint();
							
							// function exit
							exec.shutdown();
							return;
						}
						System.out.println("operate calls");
						objectPanel.repaint();
						
						
					} catch (Exception e) {
						e.printStackTrace();
						// 에러 발생시 Executor를 중지시킨다
						exec.shutdown();
					}
				}
			}, 1, 1, TimeUnit.SECONDS);
			
			
			
		}
		
		public void moveForward()
		{
			// collide check
			if (objectPanel.getStage().getCurrentMap().isWall(objectPanel.getPersonData().getFrontPoint())) {
				return;
			}
			
			// move forward save data
			objectPanel.getPersonData().moveForward();
		}
		
		public void moveBackward()
		{
			// collide check
			if (objectPanel.getStage().getCurrentMap().isWall(objectPanel.getPersonData().getBackPoint())) {
				return;
			}
			
			// move forward save data
			objectPanel.getPersonData().moveBackward();
		}
		
		public void rotateLeft()
		{
			// rotate
			objectPanel.setCharacter((objectPanel.tilt(objectPanel.getCharacter(), -1 * Math.PI / 2)));
			
			// save data
			objectPanel.getPersonData().rotateLeft();
		}
		
		public void rotateRight()
		{
			// rotate
			objectPanel.setCharacter((objectPanel.tilt(objectPanel.getCharacter(), Math.PI / 2)));
			
			// save data
			objectPanel.getPersonData().rotateRight();
		}
	}

	public MapPanel getMapPanel() {
		return objectPanel;
	}

	public OperationQueue getOperationData() {
		return operationData;
	}
	
	//새로운 큐 설정. 
	public void setOperationData(List<Operation> list){
		operationData.clear();
		
		for(Operation o : list){
			operationData.add(o);
		}
		
		
	}

	public QueueManager getQueueManager() {
		return queueManager;
	}
}
