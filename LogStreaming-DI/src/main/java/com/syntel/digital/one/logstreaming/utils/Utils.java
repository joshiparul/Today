package com.syntel.digital.one.logstreaming.utils;

import com.syntel.digital.one.logstreaming.domain.ClusterDetails;
import com.syntel.digital.one.logstreaming.dto.Input;

public class Utils {

	public static boolean getPutCommand(Input input,ClusterDetails clusterdetail)
	
	{
		String sourceDir = "D://DI_Services//LogStreaming-DI//src//main//resources//sample.conf";
		// String Dir = "mkdir /home/"+input.getUsername()+"logdatastreaming";
		String destDir = "/home"+"/"+clusterdetail.getClusterUsername();
		String command = "/usr/hdp/2.5.0.0-1245/flume/bin/flume-ng agent -c /etc/flume/conf -f /home/"+clusterdetail.getClusterUsername()+"/sample.conf --name a1 -Dflume.root.logger=INFO,console";
		
		boolean rs= SshClass.uploadandput(command,clusterdetail.getClusterId(),sourceDir,destDir);
		
		if(rs == false)
		{
			System.out.println("false");
		}
		else
		{
			System.out.println("true");
		}
		return rs;
		
	}
		
}
