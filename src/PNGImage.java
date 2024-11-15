import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Concrete component class. PNG image to be decorated
 * @author Xijie Guo
 *
 */
public class PNGImage implements Image {

	/**
	 * Get the image
	 */
	@Override
	public BufferedImage getImage() {
		//Read the image from the file
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("wine.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;

	}

}
