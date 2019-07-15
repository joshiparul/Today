package com.syntel.digital.one.logstreaming.service;

import com.syntel.digital.one.logstreaming.domain.ClusterDetails;
import com.syntel.digital.one.logstreaming.dto.Input;

public interface StartStreaming {
	
	boolean startStreamRequest(Input input,ClusterDetails clusterdetail) throws Exception;


}
