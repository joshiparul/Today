package com.syntel.digital.one.logstreaming.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.digital.one.logstreaming.dao.MetaDataDao;
import com.syntel.digital.one.logstreaming.domain.ClusterDetails;
import com.syntel.digital.one.logstreaming.dto.Input;
import com.syntel.digital.one.logstreaming.service.StartStreaming;
import com.syntel.digital.one.logstreaming.utils.Utils;

@Service
public class StartStreamingImpl implements StartStreaming {

    @Autowired
	
	MetaDataDao metaDataDao; 
    
    
	public boolean startStreamRequest(Input input,ClusterDetails clusterdetail) throws Exception {
		// TODO Auto-generated method stub
		return Utils.getPutCommand(input,clusterdetail);
	}
	

}




