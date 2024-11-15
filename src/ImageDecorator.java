import java.awt.image.BufferedImage;

/**
 * Abstract decorator class. Superclass of concretre decorators
 * @author Xijie Guo
 *
 */
public abstract class ImageDecorator implements Image{
	
	//The image 
	protected Image original;
	
	/**
	 * Constructor of ImageDecorator
	 * @param original image is currently in use
	 */
	public ImageDecorator(Image original) {
		this.original = original;
	}
	
	/**
	 * Get the image
	 */
	public BufferedImage getImage() {
		return original.getImage();
	}
	
}
