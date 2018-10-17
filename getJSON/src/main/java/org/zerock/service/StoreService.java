package org.zerock.service;

import java.util.List;

import org.zerock.domain.StoreVO;

public interface StoreService {
	
	public List<StoreVO> getStores(String cat);

	
}
