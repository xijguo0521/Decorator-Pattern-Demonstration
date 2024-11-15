import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A user interface to show original and decorated images
 * @author Xijie Guo
 *
 */
@SuppressWarnings("serial")
public class ImageGUI extends JPanel{
	
	//Buttons for generating different decorating effects
	private JButton grayButton;
	private JButton flipButton;
	private JButton blurButton;
	
	//Buttons for displaying original image
	private JButton originalButton;
	
	//The original image which needs to be decorated on
	private Image originalImg = new JPGImage();
	
	//The buffered original image
	private BufferedImage bufferedImg = originalImg.getImage();
	
	private JComboBox<String> imageMenu = new JComboBox<String>();

	//Current decorator
	private Image currentDecorator = originalImg;
	
	//Last decorator
	private Image lastDecorator;
	
	//The image panel containing the image
	private ImagePanel imagePanel;

	/**
	 * Constructor for ImageGUI
	 */
	public ImageGUI() {
		super(new BorderLayout());
		createView();
	}
	
	/**
	 * Create the view of the program
	 */
	private void createView() {
		add(createButtonPanel(), BorderLayout.SOUTH);
	    imagePanel = new ImagePanel(bufferedImg);
		add(imagePanel, BorderLayout.CENTER);
	}
	
	/**
	 * Create the button for grayscaling the image
	 * @return the grayscale button
	 */
	private JButton createGrayButton() {
		JButton button = new JButton("Gray");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Remember the last decorator and have new decoration effect based on the 
				//previous decoration
				lastDecorator = currentDecorator;
				currentDecorator = new GrayImageDecorator(lastDecorator);
				decorate(currentDecorator);
			}
		
		});
		return button;
	}
	
	/**
	 * Create the button panel containing five buttons
	 * @return the button panel
	 */
	private JPanel createButtonPanel() {
		grayButton = createGrayButton();
		flipButton = createFlipButton();
		blurButton = createBlurButton();
		originalButton = createOriginalButton();
		JPanel panel = new JPanel();
		panel.add(grayButton);
		panel.add(flipButton);
		panel.add(blurButton);
		panel.add(originalButton);
		panel.add(createImageMenu());
		panel.setLayout(new GridLayout(1, 5));
		return panel;
	}
	
	/**
	 * Create the button for flipping the image
	 * @return the flip button
	 */
	private JButton createFlipButton() {
		JButton button = new JButton("Flip");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lastDecorator = currentDecorator;
				currentDecorator = new FlipImageDecorator(lastDecorator);
				decorate(currentDecorator);
			}
		
		});
		return button;
	}
	
	/**
	 * Create the button for blurring the image
	 * @return the blur button
	 */
	private JButton createBlurButton() {
		JButton button = new JButton("Blur");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lastDecorator = currentDecorator;
				currentDecorator = new BlurImageDecorator(lastDecorator);
				decorate(currentDecorator);
			}
		
		});
		return button;
	}
	
	private JComboBox<String> createImageMenu() {
		imageMenu.addItem("JPG Image");
		imageMenu.addItem("PNG Image");
		imageMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedImageType = (String) imageMenu.getSelectedItem();
				if(selectedImageType.equals("JPG Image")) {
					originalImg = new JPGImage();
					currentDecorator = originalImg;
					bufferedImg = originalImg.getImage();
					decorate(currentDecorator);
				}
				else {
					originalImg = new PNGImage();
					currentDecorator = originalImg;
					bufferedImg = originalImg.getImage();
					decorate(currentDecorator);
				}
			}
		
		});
		return imageMenu;
	}
	
	/**
	 * Create the button for displaying original image 
	 * @return
	 */
	private JButton createOriginalButton() {
		JButton button = new JButton("Original");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lastDecorator = currentDecorator;
				currentDecorator = originalImg;
				decorate(currentDecorator);
			}
		
		});
		return button;
	}
	
	/**
	 * Decorate the original image using current image
	 * @param currentImage the current image after decoration
	 */
	private void decorate(Image currentImage) {
		
		//Set the decorated image to be displayed
		imagePanel.setImage(currentImage.getImage());
		
		//Update the image to the decorated image
		repaint();
	}
	
	/**
	 * Start the program
	 * @param args for String array
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Image Processing");
		frame.setSize(600, 800);
		frame.add(new ImageGUI());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
