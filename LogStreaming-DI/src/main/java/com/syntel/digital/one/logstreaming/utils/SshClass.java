package com.syntel.digital.one.logstreaming.utils;

import com.syntel.digital.one.logstreaming.domain.ClusterDetails;

import net.neoremind.sshxcute.core.ConnBean;
import net.neoremind.sshxcute.core.SSHExec;
import net.neoremind.sshxcute.task.CustomTask;
import net.neoremind.sshxcute.task.impl.ExecCommand;

public class SshClass {
	  
		  public static boolean uploadandput(String command, ClusterDetails clusterdetail, String sourceDir, String destDir) 
		  {
	            SSHExec ssh =null;
	            try {
	            ConnBean connBean = new ConnBean(clusterdetail.getClusterIp(), clusterdetail.getClusterUsername(),clusterdetail.getClusterPassword());
	            ssh= SSHExec.getInstance(connBean);
	            if(ssh.connect());
	            
	     
	            ssh.uploadSingleDataToServer(sourceDir,destDir);
	     

	            CustomTask sampleTask = new ExecCommand(command);
	            sampleTask = new ExecCommand(command);
	            
	            	  ssh.exec(sampleTask);
	                   
	                   return true;
	                   
	            }catch(Exception e)
	            {
	                   return false;
	            }finally
	            {
	            
	            ssh.disconnect();
	            }
		  
		  }
	  }
	  


	  
	  
