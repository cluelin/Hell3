package Operation;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Condition extends Operation {


	@Override
	public JLabel getLabel() {
		// TODO Auto-generated method stub

		JLabel operateLabel = new JLabel("조건");
		// 이미지 설정하기.
		try {
			Image img = ImageIO.read(new File("resources/isWall.png"));
			operateLabel.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		return operateLabel;
	}
}
