package com.app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.Table;




@Entity
@Table(name = "job_posts")
public class JobPost extends BaseEntity {
	
	
	@Column(length = 40)
	private String title;

	@Column(name = "company_name", length = 40)
	private String companyName;

	@Column(length = 40)
	private String location;

	@Column(length = 40)
	private String description;

	private Integer requirments;

	private Double salary;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRequirments() {
		return requirments;
	}

	public void setRequirments(Integer requirments) {
		this.requirments = requirments;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public JobPost(String title, String companyName, String location, String description, Integer requirments,
			Double salary) {
		super();
		this.title = title;
		this.companyName = companyName;
		this.location = location;
		this.description = description;
		this.requirments = requirments;
		this.salary = salary;
	}

	public JobPost() {
		super();
	}

	
	
	
	

	

}
//Job title, company name, location, description, requirements, salary, and posting date.
