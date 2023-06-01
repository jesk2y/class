package org.zerock.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageParam {
	
	private static final double PER = 10.0;
	private int page, display, total, start, end, bno;
	private boolean prev, next;
	
	private boolean extend;
	
	private String[] types;
	private String keyword, type;
	
	public void setType(String type) {
		this.type = type;
		
		if(this.type == null || this.type.length() == 0) {
			return;
		}
		
		this.types = type.split("");
		
	}
	
	public PageParam() {
		this.display = 10;
		this.page = 1;
	}
	
	public int getSkip() {
		return (this.page - 1) * this.display;
	}	// limit #{skip}, #{display}
	// 페이지를 가져올 때 맨 위 글을 정해줌
	// 자동으로 호출됨
	
	public void setTotal(int total) {
		this.total = total;
		
		this.end = (int)Math.ceil(this.page/PER) * 10;
		this.start = this.end - 9;
		
		if((this.end * this.display) >= total ) {
			this.end = (int)Math.ceil(total/(double)this.display);
			this.next = false;
		}else{
			this.next = true;
		}
		
		this.prev = this.start != 1;
	}
	
	public String getLink(String path) {
		return UriComponentsBuilder.fromPath(path)
		.queryParam("bno", this.bno)
		.queryParam("page", this.page)
		.queryParam("type", this.type)
		.queryParam("keyword", this.keyword)
		.toUriString();
	}
	
	public static void main(String[] args) {
		PageParam obj = new PageParam();
		obj.setType("");
		System.out.println(Arrays.toString(obj.getTypes()));
	}
	
}
