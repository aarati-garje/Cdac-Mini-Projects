package com.app.dtos;

public class JobPostDto extends BaseDTO {
 
	private String title;
	private String companyName;
	private String location;
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
	
	
}
