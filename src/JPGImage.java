import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Concrete component class. JPG image to be decorated
 * @author Xijie Guo
 *
 */
public class JPGImage implements Image {
	
	/**
	 * Get the JPG image
	 */
	@Override
	public BufferedImage getImage() {
		//Read the image from the file
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("superhero.jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}


}

