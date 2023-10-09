import javax.swing.JFrame;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WeatherAppGui extends JFrame {
	public WeatherAppGui()
	{
		super("Weather App");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(450,650);
		
		setLocationRelativeTo(null);
		
		setLayout(null);
		
		setResizable(false);
		
		addGuiComponents();
	}
	
	public void addGuiComponents()
	{
		JTextField searchTextField = new JTextField();
		
		searchTextField.setBounds(15,15,351,45);
		
		searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));
		
		add(searchTextField);
		
		JButton searchB = new JButton(loadImage("assets/search.png"));
		
		searchB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		searchB.setBounds(375,13,47,45);
		
		add(searchB);
		
		//Weather Image
		JLabel weatherConditionImage = new JLabel(loadImage("assets/cloudy.png"));
		
		weatherConditionImage.setBounds(0,125,450,217);
		
		add(weatherConditionImage);
		
		//Temperature Text
		JLabel tempText = new JLabel("10 C");
		tempText.setBounds(0,350,450,54);
		tempText.setFont(new Font("Dialod",Font.BOLD, 48));
		
		tempText.setHorizontalAlignment(SwingConstants.CENTER);
		add(tempText);
		
		//Weather Condition Description
		JLabel weatherConditionDesc = new JLabel("Cloudy");
		weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
		weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
		add(weatherConditionDesc);
		
		//Humidity Image
		JLabel humidImg = new JLabel(loadImage("assets/humidity.png"));
		humidImg.setBounds(15,500,74,66);
		add(humidImg);
		
		//Humidity Text
		JLabel humidText = new JLabel("<html><b>Humidity</b> 100% </html>");
		humidText.setBounds(90,500,85,55);
		humidText.setFont(new Font("Dialog", Font.PLAIN, 16));
		add(humidText);
		
		//Windspeed Image
		JLabel windspeedImg = new JLabel(loadImage("assets/windspeed.png"));
		windspeedImg.setBounds(250,500,74,66);
		add(windspeedImg);
		
		//Windspeed Text
		JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h </html>");
		windspeedText.setBounds(310,500,85,55);
		windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
		add(windspeedText);
		
		
	}
	
	private ImageIcon loadImage(String resourcePath)
	{
		try
		{
			BufferedImage img = ImageIO.read(new File(resourcePath));
			return new ImageIcon(img);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Could not find resource");
		return null;
	}
}
