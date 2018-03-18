
public class StatisticsDisplay implements Observer, Display{
	
	private WeatherData weatherData;
	
	public StatisticsDisplay(WeatherData w)
	{
		this.weatherData = w;
	}
	
	public void update(String area)
	{
		if (weatherData.getArea().equals(area))
			display();
	}
	
	public void display()
	{
		System.out.print("Temperature");
		for(int i=0; i<weatherData.getTemperature().size(); i+=1)
		{
			System.out.print(" ");
			System.out.print(weatherData.getTemperature().get(i));
			
		}
		System.out.println("");
		
		System.out.print("Humidity");
		for(int i=0; i<weatherData.getHumidity().size(); i+=1)
		{
			System.out.print(" ");
			System.out.print(weatherData.getHumidity().get(i));
			
		}
		System.out.println("");
		
		System.out.print("Pressure");
		for(int i=0; i<weatherData.getBarometricPressure().size(); i+=1)
		{
			System.out.print(" ");
			System.out.print(weatherData.getBarometricPressure().get(i));
			
		}
		System.out.println("");
	}
	
	
}
