package com.lexie.homeworkFourth;

public class ReadWeather implements Runnable{
	private Weather w2 = new Weather();
	
	public ReadWeather() {}
	public ReadWeather(Weather w2) {
		this.setWeather(w2);
	}
	public void setWeather(Weather w2) {
		this.w2 = w2;
	}
	public Weather getWeather() {
		return w2;
	}
	@Override
	public synchronized void run() {
		int i = 0;
		while(i < 100) {
			w2.read();
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
