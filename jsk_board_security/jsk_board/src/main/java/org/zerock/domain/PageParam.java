package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageParam {
	
	private static double PER = 7.0;
	
	private int start, end, page, display, count, bno;
	private boolean prev, next;
	private String type, keyword;
	private String[] types;
	
	public PageParam() {
		this.page = 1;
		this.display = 10;
		this.prev = false;
		this.next = false;
	}
	
	public void setType(String type) {
		this.type = type;
		
		if(this.type.length() == 0 || this.type == null) {
			this.types = null;
			return;
		}
		
		this.types = type.split("");
	}
	
	public int getSkip() {
		
		return (this.page - 1) * this.display;
	}
	
	public void setCount(int count) {
		
		this.count = count;
		
		this.end = (int)(Math.ceil(this.page/PER) * PER);
		this.start = (int)(this.end - PER + 1);
		
		if(this.display * this.end >= this.count) {
			this.end = (int) Math.ceil(this.count / (double)this.display);
		}else {
			this.next = true;
		}
		
		if(this.start != 1) {
			this.prev = true;
		}
		
	}
	
	public String getLink(String path) {
		
		return UriComponentsBuilder.fromPath(path)
				.queryParam("bno", this.bno)
				.queryParam("page", this.page)
				.queryParam("type", this.type)
				.queryParam("keyword", this.keyword)
				.toUriString();
	}
	
	
}
