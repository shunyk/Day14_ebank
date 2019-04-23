package com.shunyk.control;

public class EbankMain {

	public static void main(String[] args) {
		EbankController ec = new EbankController();
		
		try {
			ec.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
