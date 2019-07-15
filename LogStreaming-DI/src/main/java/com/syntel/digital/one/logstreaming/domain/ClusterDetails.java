package com.syntel.digital.one.logstreaming.domain;

public class ClusterDetails {

	private String clusterDetailsId;
	private String clusterId;
	private String clusterIp;
	private String clusterUsername;
	private String clusterPassword;
	
	public ClusterDetails()
	{
		
	}
	
	public String getClusterIp() {
		return clusterIp;
	}
	public void setClusterIp(String clusterIp) {
		this.clusterIp = clusterIp;
	}
	public String getClusterUsername() {
		return clusterUsername;
	}
	public void setClusterUsername(String clusterUsername) {
		this.clusterUsername = clusterUsername;
	}
	public String getClusterPassword() {
		return clusterPassword;
	}
	public void setClusterPassword(String clusterPassword) {
		this.clusterPassword = clusterPassword;
	}

	public String getClusterDetailsId() {
		return clusterDetailsId;
	}

	public void setClusterDetailsId(String clusterDetailsId) {
		this.clusterDetailsId = clusterDetailsId;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}
	
}
