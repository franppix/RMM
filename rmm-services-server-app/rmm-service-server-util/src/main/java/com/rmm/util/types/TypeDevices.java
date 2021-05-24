package com.rmm.util.types;

public enum TypeDevices {
	WINDOWS_WORKSTATION("Windows Workstation",1,0), 
	WINDOWS_SERVER("Windows Server",1,1), 
	MAC("Windows Workstation",2,2);
	
	private String typeName;
	private int systemCode;
	private int codeType;
	
	private TypeDevices (String typeName, int systemCode, int codeType) {
		this.typeName = typeName;
		this.systemCode = systemCode;
		this.codeType = codeType;
	}

	public String getTypeName() {
		return typeName;
	}

	public int getSystemCode() {
		return systemCode;
	}

	public int getCodeType() {
		return codeType;
	}
	
	
}
