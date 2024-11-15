import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Decorator class. Decorate the original image using grayscale
 * @author Xijie Guo
 *
 */
public class GrayImageDecorator extends ImageDecorator {

	/**
	 * Constructor of GrayImageDecorator
	 * @param original the image to be decorated 
	 */
	public GrayImageDecorator(Image original) {
		super(original);
	}

	/**
	 * Get the image after decorating(graysclaing) it
	 */
	@Override
	public BufferedImage getImage() {
		BufferedImage inputImage = original.getImage();
		return grayScale(inputImage);
	}

	/**
	 * Implement grayscale to the original image and get the decorated one after decoration
	 * @param image the image to be decorated on
	 * @return the image after decoration(grayscale)
	 */
	private BufferedImage grayScale(BufferedImage image) {
		//Get the width and height of the image
		int width = image.getWidth();
		int height = image.getHeight();
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				//Get the color of every pixel
				Color c = new Color(image.getRGB(j, i));
				//Set RGB value 
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				int gray = (red + green + blue) / 3;
				
				//Generate a new color for gray scale
				Color newColor = new Color(gray, gray, gray);
				
				//Set the color of every pixel to the new color generated
				image.setRGB(j, i, newColor.getRGB());
			}
		} 
		return image;
	}
}
