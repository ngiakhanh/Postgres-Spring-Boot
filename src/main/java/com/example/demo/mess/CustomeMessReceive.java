package com.example.demo.mess;

public class CustomeMessReceive {
	private String callStatus;
	private String message;
	private Object result;

	public String getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public CustomeMessReceive(String callStatus, String message, Object result) {
		super();
		this.callStatus = callStatus;
		this.message = message;
		this.result = result;
	}

	public CustomeMessReceive() {
		super();
	}

}