import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * Decorator class. Decorate the original image by flipping it
 * @author Xijie Guo
 *
 */
public class FlipImageDecorator extends ImageDecorator {

	/**
	 * Constructor of FilpImageDecorator
	 * @param original the image needs to be decorated on
	 */
	public FlipImageDecorator(Image original) {
		super(original);
	}
	
	/**
	 * Get the image after flipping
	 * @return the image after flipping
	 */
	public BufferedImage getImage() {
		BufferedImage inputImage = original.getImage();
		return flip(inputImage);
	}
	
	/**
	 * Flip the image and get the image after flipping
	 * @param image to be flipped
	 * @return the image after flipping
	 */
	private BufferedImage flip(BufferedImage image) {
		// Do the linear transformation using the specific scaling matrix
		AffineTransform transform = AffineTransform.getScaleInstance(-1, 1);
	    transform.translate(-image.getWidth(), 0);
	    AffineTransformOp op = new AffineTransformOp(transform,
	        AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
	    
	    //The new buffered image is created with the source image 
	    //In this case we don't have desitnation image
	    image = op.filter(image, null);
	    return image;
	 }

}
