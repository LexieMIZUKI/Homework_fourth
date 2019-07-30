package com.lexie.homeworkFourth;

public class GenerateWeather implements Runnable{
	private Weather w1 = new Weather();
	
	public GenerateWeather() {}
	public GenerateWeather(Weather w1) {
		this.setWeather(w1);
	}
	public void setWeather(Weather w1) {
		this.w1 = w1;
	}
	public Weather getWeather() {
		return w1;
	}
	@Override
	public synchronized void run() {
		int i = 0;
		while(i < 100) {
			w1.generate();
			i++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
