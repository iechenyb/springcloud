package com.cyb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyb.entity.InterfaceLimit;
import com.cyb.mapper.InterfaceLimitMapper;
import com.cyb.service.InterfaceLimitService;

@Service
public class InterfaceLimitServiceImpl implements InterfaceLimitService {
	
	@Autowired
	private InterfaceLimitMapper mapper;

	public InterfaceLimit getEntityByPri(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

}
