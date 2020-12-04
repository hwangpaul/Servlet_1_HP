package com.choa.board;

import java.sql.Date;

public class BoardDTO {
	
	private long num;
	private String title;
	private String writer;
	private String contentes;
	private Date reg_date;
	private long hit;
	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContentes() {
		return contentes;
	}
	public void setContentes(String contentes) {
		this.contentes = contentes;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	

	

}
