package com.lexie.homeworkFourth;

public class WeatherTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weather w = new Weather();
		new Thread(new GenerateWeather(w)).start();
		new Thread(new ReadWeather(w)).start();
	}

}
