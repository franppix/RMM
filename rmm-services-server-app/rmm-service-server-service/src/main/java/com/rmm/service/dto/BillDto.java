/**
 * POJO Object For return Monthly bill
 */
package com.rmm.service.dto;

/**
 * @author FJGM
 *
 */
public class BillDto {

	private String serviceType;
	private double cost;

	/**
	 * BillDto constructor
	 * 
	 * @param serviceType Type of service Enum
	 * @param cost        service cost
	 */
	public BillDto(String serviceType, double cost) {
		super();
		this.serviceType = serviceType;
		this.cost = cost;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "BillDto [serviceType=" + serviceType + ", cost=" + cost + "]";
	}

}
