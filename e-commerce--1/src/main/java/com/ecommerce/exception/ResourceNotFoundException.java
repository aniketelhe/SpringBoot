package com.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String resourcename;
	private String fieldname;
	private Object fieldvalue;
	
	
	public ResourceNotFoundException(String resourcename, String fieldname, Object fieldvalue) {
		super(String.format("%s not found with %s: '%s'",resourcename,fieldname,fieldvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}


	public String getResourcename() {
		return resourcename;
	}


	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}


	public String getFieldname() {
		return fieldname;
	}


	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}


	public Object getFieldvalue() {
		return fieldvalue;
	}


	public void setFieldvalue(Object fieldvalue) {
		this.fieldvalue = fieldvalue;
	}
	

	

}