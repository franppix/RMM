package com.rmm.util.types;

public enum TypeError {
	ERROR_INSERT("ER001","PROBLEM INSERTING FIELD"), 
	ERROR_UPDATE("ER002","PROBLEM UPDATING FIELD"),
	ERROR_DELETE("ER003","PROBLEM DELETING FIELD"),
	NO_CUSTOMER("EF001","CUSTOMER DOES NOT EXIST"),
	SERVICE_EXIST("EF002","THE SERVICE ALREADY EXIST"),
	NO_SERVICE("EF003","THE SERVICE DOES NOT EXIST"),
	NO_DEVICE("EF004","DEVICE DOES NOT EXIST"),
	OK("IN000","OK");
	
	private String errorCode;
	private String errorDesc;
	
	private TypeError (String errorCode, String errorDesc) {
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	
	
	
}
