package com.syntel.digital.one.logstreaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.digital.one.logstreaming.domain.ClusterDetails;
import com.syntel.digital.one.logstreaming.dto.Input;
import com.syntel.digital.one.logstreaming.dto.ResponseDTO;
import com.syntel.digital.one.logstreaming.service.StartStreaming;



@RestController
@RequestMapping(value = "/dataingestion")
public class LogStreamingController {

	
	@Autowired
	StartStreaming startStreaming;
	
	public static final String VERSION = "1.0";
	
	@RequestMapping(value="/logstreaming/"+VERSION, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseDTO logstartrequest(@RequestBody Input input, ClusterDetails clusterdetail) {
		ResponseDTO response = new ResponseDTO();
	    
		
try {
			
			boolean status = startStreaming.startStreamRequest(input,clusterdetail);

			if (status) {
				response.setStatus(true);
				response.setMessage("Logs Ingested Successfully!!");
			} else {
				response.setMessage("Failed to Ingest Logs!!");
				response.setStatus(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Failed to Ingest Log!!");
			response.setStatus(false);
		}
		return response;
	   }
}
	
