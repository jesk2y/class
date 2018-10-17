package org.zerock.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.zerock.domain.StoreVO;
import org.zerock.mapper.StoreMapper;

@Service
public class StoreServiceImpl implements StoreService {
	
	private Map<String, List<StoreVO>> storeMap;
	
	private StoreMapper todoMapper;
	
	public StoreServiceImpl() {
storeMap = new HashMap<>();
		
		List<StoreVO> korList = new ArrayList<>();
		List<StoreVO> jpList = new ArrayList<>();
		List<StoreVO> wsList = new ArrayList<>();
		
		korList.add(new StoreVO(1,"청진식당"));
		korList.add(new StoreVO(2,"뚝배기집"));
		korList.add(new StoreVO(3,"마마된장"));
		
		jpList.add(new StoreVO(1,"이춘복참치"));
		jpList.add(new StoreVO(2,"갓덴스시"));
		jpList.add(new StoreVO(3,"스시미"));
		
		wsList.add(new StoreVO(1,"양식1"));
		wsList.add(new StoreVO(2,"양식2"));
		wsList.add(new StoreVO(3,"양식3"));
		
		storeMap.put("kor",korList);
		storeMap.put("jp",jpList);
		storeMap.put("ws",wsList);
	}
	

	@Override
	public List<StoreVO> getStores(String cat) {
		
		return storeMap.get(cat);
	}

}
