import java.util.List;

public class SimpleForecastDisplay implements Display, Observer {

	private WeatherData weatherData;
	
	public SimpleForecastDisplay(WeatherData wd){
		weatherData = wd;
	}
	@Override
	public void update(String area)
	{
		if (weatherData.getArea().equals(area))
			display();
	}

	@Override
	public void display() {
		List<Double> humidity = weatherData.getHumidity();
		double tempHumidity = humidity.get(humidity.size() - 1);
		
		if( tempHumidity > 0.8 ){
			System.out.println("Forecast rain.");
		}else if( tempHumidity < 0.2 ){
			System.out.println("Forecast sunny.");
		}else{
			System.out.println("Forecast cloudy.");
		}
	}

}
