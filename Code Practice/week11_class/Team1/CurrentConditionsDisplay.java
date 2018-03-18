import java.util.*;

public class CurrentConditionsDisplay implements Observer, Display{
	private WeatherData weatherData;
	public CurrentConditionsDisplay(WeatherData weatherData){
		this.weatherData=weatherData;
	}
	@Override
	public void update(String area)
	{
		if (weatherData.getArea().equals(area))
			display();
	}

	@Override
	public void display(){
		List<Double> temperatureArray = weatherData.getTemperature();
		List<Double> humidityArray = weatherData.getHumidity();
		List<Double> pressureArray = weatherData.getBarometricPressure();
		System.out.println("Temperature "+ temperatureArray.get(temperatureArray.size()-1));
		System.out.println("Humidity "+humidityArray.get(humidityArray.size()-1));
		System.out.println("Pressure "+pressureArray.get(pressureArray.size()-1));
	}
}