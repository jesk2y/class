package org.zerock.domain;

import lombok.Data;

@Data
public class ReplyPageParam {

	private static double PER = 3.0;
	
	int bno, start, end, display, page, count;
	boolean prev, next;
	
	public ReplyPageParam() {
		this.prev = true;
		this.next = true;
		this.display = 15;
		this.page = 1;
	}
	
	public int getSkip() {		
		return this.display * (this.page-1);
	}
	
	public void setCount(int count) {
		
		this.count = count;
		
		this.end = (int)(Math.ceil(this.page / PER) * PER);
		this.start = this.end - (int)PER + 1;
		
		if(this.end * this.display >= this.count) {
			this.end = (int)Math.ceil(this.count / (double)this.display);
			this.next = false;
		}
		
		if(this.start == 1) {
			this.prev = false;
		}	
	}
	
	public static void main(String[] args) {
		ReplyPageParam param = new ReplyPageParam();
		
		System.out.println(param.getSkip());
		
	}
}
