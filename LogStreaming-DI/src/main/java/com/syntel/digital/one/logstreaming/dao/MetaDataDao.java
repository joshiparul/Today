package com.syntel.digital.one.logstreaming.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.syntel.digital.one.logstreaming.domain.ClusterDetails;

@Component
public class MetaDataDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public ClusterDetails getclusterdetails(String clusterId)
	{
		
		String sql="select * from haas.ClusterDetails where clusterId=?";
		
		ClusterDetails clusterdetail = (ClusterDetails)jdbcTemplate.queryForObject(
				sql, new Object[] {clusterId}, new BeanPropertyRowMapper<ClusterDetails>(ClusterDetails.class));
		
		
		return clusterdetail;
	}
}