import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 * Decorator class. Decorate the original image by Gaussian blur
 * @author Xijie Guo
 *
 */
public class BlurImageDecorator extends ImageDecorator {

	/**
	 * Constructor of BlurImageDecorator
	 * @param original the original jpg image
	 */
	public BlurImageDecorator(Image original) {
		super(original);
	}

	/**
	 * Get the image that needs to be decorated on
	 * @return the image that needs to be decorated on
	 */
	public BufferedImage getImage() {
		BufferedImage inputImage = original.getImage();
		return blur(inputImage);
	}

	/**
	 * Blur the image and get the image after blurring
	 * @param image the image needs to be decorated 
	 * @return the image after decoration
	 */
	private BufferedImage blur(BufferedImage image) {
		//average together each pixel with its eight immediate neighbors
		float[] blurMatrix = {
				1/9f, 1/9f, 1/9f, 
				1/9f, 1/9f, 1/9f, 
				1/9f, 1/9f, 1/9f, 
		};

		BufferedImageOp imageOp = new ConvolveOp(new Kernel(3, 3, blurMatrix));
		
		//Filter the source image and the destination image remains null
		image = imageOp.filter(image, null);
		return image;
	}
}
