package com.min.fresh.utils;

import java.io.Serializable;

public class RandomNum implements Serializable {

	private static final long serialVersionUID = -9148822763551885024L;

	public String randomNum() {
		String n = "";
		while(n.length()<4) {
			n = String.valueOf((int)(Math.random()*10*Math.random()*23*Math.random()*15*Math.random()*27));
		}
		return n;
	}
	
	public static void main(String[] args) {
		RandomNum r = new RandomNum();
		System.out.println(r.randomNum());
	}
}
