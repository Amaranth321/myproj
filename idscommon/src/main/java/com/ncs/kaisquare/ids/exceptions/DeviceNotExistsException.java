package com.ncs.kaisquare.ids.exceptions;

public class DeviceNotExistsException extends IdsException {

	private String deviceId;

	public DeviceNotExistsException(String deviceId) {
		super(IdsHttpStatus.DEVICE_NOT_FOUND.value(),"device doesn't exist: device id '" + deviceId + "'");
		this.deviceId = deviceId;
	}

	public DeviceNotExistsException(int code, String deviceId) {
		super(code,"device doesn't exist: device id '" + deviceId + "'");
		this.deviceId = deviceId;
	}

	public String getDeviceId()
	{
		return deviceId;
	}

}
