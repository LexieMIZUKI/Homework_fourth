package com.lexie.homeworkFourth;

import java.util.Random;

public class Weather {
	private int temperature;
	private int humidity;
	private boolean flag = true;
	
	public Weather() {}
	public Weather(int temperature, int humidity, boolean flag) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.flag = flag;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public synchronized void generate() {
		Random ran = new Random();
		if(!flag) {
	    try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		this.setTemperature(ran.nextInt(41));
		this.setHumidity(ran.nextInt(101));
		System.out.println("生成天气数据："+this);
		notifyAll();
		flag = false;
	}
	
	public synchronized void read() {
		if(flag) {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		this.getTemperature();
		this.getHumidity();
		System.out.println("读取天气数据："+this);
		flag = true;
		notifyAll();
	}
	
	public String toString() {
		return "[温度："+temperature+"℃,湿度："+humidity+"%]";
		
	}
	
}
