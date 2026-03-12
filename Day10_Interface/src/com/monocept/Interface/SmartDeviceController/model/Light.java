package com.monocept.Interface.SmartDeviceController.model;

public class Light implements Controllable  {
	@Override
	public void turnOn() {
		System.out.println("Light turned ON");
		
	}
	
	 @Override
	    public void setMode(String mode) {
	        System.out.println("Light mode set to: " + mode);
	    }
	
	
	@Override
	public void turnOff() {
		System.out.println("Light turned OFF");
		
	}

}
