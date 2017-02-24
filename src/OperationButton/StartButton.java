package OperationButton;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import CodePart.CodeMaker;
import GUIPackage.GUI;
import Operation.Operation;

public class StartButton extends JButton{

	
	
	public StartButton(int width, int height){
		
		setText("");
		try {
			Image img = ImageIO.read(new File("resources/start.png"));
			setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		setPreferredSize(new Dimension(width, height));
		
		//시작버튼 수행 
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				
				//mapPanel쪽의 큐를 설정해준다. 
				GUI.manager.setOperationData(GUI.mainFrame.getMainList());

				System.out.println("main리스트"); 
				
				for (Operation op : GUI.mainFrame.getMainList()){
					
					System.out.println(op);
				}
				
				
				
				System.out.println("getOperationQueue"); 
				
				for (Operation op : GUI.manager.getOperationData().getOperationQueue()){
					
					System.out.println(op);
				}
					
				
				//큐에 쌓인 동작 수행. 
				GUI.manager.getQueueManager().operate(GUI.manager.getOperationData().getOperationQueue());
				
				//동작 수행중 Start버튼 비활성화
				setEnabled(false);
				
				
				
			}
		});
	}
}
