import javax.swing.*;
public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				new WeatherAppGui().setVisible(true);
				
				
//				System.out.println(WeatherAppBckEnd.getLocationData("Philippines"));
			}
		});
	}

}
