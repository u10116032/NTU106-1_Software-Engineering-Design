import java.util.ArrayList;

public class WeatherData extends Observable{
	private ArrayList<Double> temperature;
	private ArrayList<Double> humidity;
	private ArrayList<Double> barometricPressure;
	private String area;
	
	WeatherData(){
		this.temperature = new ArrayList<Double>();
		this.humidity = new ArrayList<Double>();
		this.barometricPressure = new ArrayList<Double>();
		this.area = "";
	}
	ArrayList<Double> getTemperature(){
		return this.temperature;
	}
	ArrayList<Double> getHumidity(){
		return this.humidity;
	}
	ArrayList<Double> getBarometricPressure(){
		return this.barometricPressure;
	}
	String getArea() {
		return this.area;
	}
	void addTemperature(double t) {
		this.temperature.add(t);
	}
	void addHumidity(double h) {
		this.humidity.add(h);
	}
	void addBarometricPressure(double p) {
		this.barometricPressure.add(p);
	}
	void setArea(String a) {
		this.area = a;
	}
}
