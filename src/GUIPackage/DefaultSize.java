package GUIPackage;

import java.awt.Dimension;
import java.awt.Toolkit;

public interface DefaultSize {

	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
//	int mainFrameWidth = res.width-300;
//	int mainFrameHeight = res.height-200;
	
	int mainFrameWidth = 1600;
	int mainFrameHeight = 900;
	
	int subPanelWidth = mainFrameWidth - mainFrameHeight;
	
	int mapPanelWidth = mainFrameHeight;
	
	int operationPanelWidth = subPanelWidth;
	int operationPanelHeight = mainFrameHeight/4 + 5;
	
	int codePanelHeight = mainFrameHeight - operationPanelHeight;
	int codePanelWidth = subPanelWidth;
	
	int buttonWidth = 150;
	int buttonHeight = 50;
}
