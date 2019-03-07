package com.ncs.kaisquare.ids.exceptions;

public class DeviceNotExistsException extends RuntimeException {
	
	private String deviceId;

	public DeviceNotExistsException(String deviceId) {
		super("device doesn't exist: device id '" + deviceId + "'");
		this.deviceId = deviceId;
	}
	
	public String getDeviceId()
	{
		return deviceId;
	}

}
