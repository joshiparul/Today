package com.syntel.digital.one.logstreaming.dto;

public class Input {

	private String bind;//netcatsource 
	private String port; //netcat port
	
	private String hdfspath; //Destination
    
	public String getBind() {
		return bind;
	}
	public void setBind(String bind) {
		this.bind = bind;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getHdfspath() {
		return hdfspath;
	}
	public void setHdfspath(String hdfspath) {
		this.hdfspath = hdfspath;
	}
    
}
