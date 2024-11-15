import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * An image panel containing the image. The image is painted on the panel
 * @author Xijie Guo
 *
 */

@SuppressWarnings("serial")
public class ImagePanel extends JPanel{
	
	//The buffered image
	private BufferedImage img;
	
	/**
	 * Constructor for ImagePanel
	 * @param img current buffered image to be displayed
	 */
	public ImagePanel(BufferedImage img) {
		this.img = img;
	}
	
	/**
	 * paint the image on the panel
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	/**
	 * Set the image to the current image to be displayed
	 * @param newImg the image to be displayed
	 */
	public void setImage(BufferedImage newImg) {
		this.img = newImg;
	}
}
