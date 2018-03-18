import java.util.*;

public class WeatherSystem {
	private Map<String, WeatherData> weatherDataMap;

	public WeatherSystem()
	{
		weatherDataMap = new HashMap<String, WeatherData>();
		WeatherData asiaWeatherData = new WeatherData();
		asiaWeatherData.setArea("Asia");

		WeatherData usWeatherData = new WeatherData();
		usWeatherData.setArea("US");

		weatherDataMap.put("Asia", asiaWeatherData);
		weatherDataMap.put("US", usWeatherData);
	}

	public void addWeatherData(String area, double temperature, double humidity, double pressure)
	{
			WeatherData weatherData = weatherDataMap.get(area);
			weatherData.addTemperature(temperature);
			weatherData.addHumidity(humidity);
			weatherData.addBarometricPressure(pressure);

			weatherData.notifyObservers(area);
	}

	public void attachDisplay(String area, String displayType)
	{
		WeatherData weatherData = weatherDataMap.get(area);

		Observer observer = null;
		switch(displayType){
			case "Current":
				observer = new CurrentConditionsDisplay(weatherData);
				break;
			case "Statistics":
				observer = new StatisticsDisplay(weatherData);
				break;
			case "Forecast":
				observer = new SimpleForecastDisplay(weatherData);
				break;
		}
		weatherData.attachObserver(displayType, observer);
	}

	public void detachDisplay(String area, String displayType)
	{
		WeatherData weatherData = weatherDataMap.get(area);

		weatherData.detachObserver(displayType);
	}
}