package com.rmm.rest.pojo;

import java.util.List;

public class ResponseListRmm<T> {

	private List<T> responseList;
	private String codError;
	private String descError;

	

	public List<T> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<T> responseList) {
		this.responseList = responseList;
	}

	public String getCodError() {
		return codError;
	}

	public void setCodError(String codError) {
		this.codError = codError;
	}

	public String getDescError() {
		return descError;
	}

	public void setDescError(String descError) {
		this.descError = descError;
	}

}
