package MapPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;

import GUIPackage.DefaultSize;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Map.Stage;

public class MapPanel extends JPanel implements ActionListener
{
	private static final int tileWidth = DefaultSize.mapPanelWidth/10;	// 타일 1칸 너비
	private static final int tileHeight = DefaultSize.mainFrameHeight/10;	// 타일 1칸 높이
	private Stage stage;
	private BufferedImage[][] tileImage;
	private BufferedImage character;
	private GraphicsConfiguration gc;
	private Person personData;
	private Timer timer;
	private final int DELAY = 1000;
	
	public MapPanel() throws IOException
	{
		stage = new Stage();
		
		//스테이지 결정
		stage.setStageNumber(0);
		
		personData = new Person(stage.getCurrentMap().getPlayerOriginPoint().x, stage.getCurrentMap().getPlayerOriginPoint().y);
		tileImage = new BufferedImage[12][12];
		
		//mapPanel 크기 결정
		setPreferredSize(new Dimension(DefaultSize.mapPanelWidth, DefaultSize.mainFrameHeight));
		
		imageUpdate();
		
		gc = getDefaultConfiguration();
		
		character = ImageIO.read(new File("resources/character.png"));
		character = resizeImage(character, tileWidth, tileHeight);
		timer = new Timer(DELAY, this);
	}

	public void imageUpdate() throws IOException
	{
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				tileImage[i][j] = ImageIO.read(new File(String.format("resources/tile_%d.png", 
						stage.getCurrentMap().getMap(i, j))));
				tileImage[i][j] = resizeImage(tileImage[i][j], tileWidth, tileHeight);
			}
		}
	}
	
    public BufferedImage tilt(BufferedImage image, double angle) {
        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
        int w = image.getWidth(), h = image.getHeight();
        int neww = (int)Math.floor(w*cos+h*sin), newh = (int)Math.floor(h*cos+w*sin);
        int transparency = image.getColorModel().getTransparency();
        BufferedImage result = gc.createCompatibleImage(neww, newh, transparency);
        Graphics2D g = result.createGraphics();
        g.translate((neww-w)/2, (newh-h)/2);
        g.rotate(angle, w/2, h/2);
        g.drawRenderedImage(image, null);
        return result;
    }

    public GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }
    
    public static  BufferedImage resizeImage(BufferedImage image, int width, int height) {
       int type=0;
       
       type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
       BufferedImage resizedImage = new BufferedImage(width, height,type);
       Graphics2D g = resizedImage.createGraphics();
       g.drawImage(image, 0, 0, width, height, null);
       g.dispose();
       
       return resizedImage;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int i = 1; i <= 10; i++) {
        	for (int j = 1; j <= 10; j++) {
        		g.drawImage(tileImage[i][j], (j - 1) * tileWidth, (i - 1) * tileHeight, null);
        	}
        }
        
        Point personPoint = personData.getCurrentPoint();
        
        g.drawImage(
        		character, 
        		(personPoint.y - 1) * tileWidth, (personPoint.x - 1) * tileHeight, 
        		null
        		);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        timer.stop();
    }
    
	public BufferedImage getCharacter() {
		return character;
	}

	public BufferedImage getTileImage(int x, int y) {
		return tileImage[x][y];
	}

	public Person getPersonData() {
		return personData;
	}

	public Stage getStage() {
		return stage;
	}

	public void setCharacter(BufferedImage character) {
		this.character = character;
	}

	public Timer getTimer() {
		return timer;
	}
}
