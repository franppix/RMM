/**
 * Entity for get information of ServicesCost table
 * Information about differents service cost according to the type of device
 */
package com.rmm.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author FJGM
 *
 */

@Entity
@Table(name = "service_cost")
public class ServiceCost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//system type 0: for all, 1: for windows, 2: for MAC
	private int system;

	private double cost;

	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;

	public ServiceCost() {

	}

	/**
	 * Service Cost constructor
	 * 
	 * @param id      id from service cost
	 * @param system  system type 0: for all, 1: for windows, 2: for MAC
	 * @param cost    cost of service
	 * @param service service object
	 */
	public ServiceCost(int id, int system, double cost, Service service) {
		super();
		this.id = id;
		this.system = system;
		this.cost = cost;
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSystem() {
		return system;
	}

	public void setSystem(int system) {
		this.system = system;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "ServiceCost [id=" + id + ", system=" + system + ", cost=" + cost + "]";
	}

}
