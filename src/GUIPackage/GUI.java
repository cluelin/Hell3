package GUIPackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import MapPanel.GameManager;

public class GUI {

	public static GameManager manager; 
	
	public static GUIFrame mainFrame;  

	public static void main(String[] args) throws IOException{

		
		manager = new GameManager();
		mainFrame = new GUIFrame();
		
		
		
	}
	
	
}
