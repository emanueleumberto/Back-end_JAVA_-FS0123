package com.epicode.config_bean;

public class Test {
	
	private String txt;
	
	public Test() {
		super();
	}
	
	public Test(String txt) {
		super();
		this.txt = txt;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String readTxt() {
		return "Testo Test: " + txt;
	}

	@Override
	public String toString() {
		return "Test [txt=" + txt + "]";
	}
	
	

}
