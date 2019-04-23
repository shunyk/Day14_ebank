package com.shunyk.view;

import java.util.ArrayList;

import com.shunyk.deal.DealDTO;

public class EbankView {

	public void view(ArrayList<DealDTO> ar) {
		System.out.println("날짜\t업무\t거래금액\t잔액");
		for(DealDTO d : ar) {
			System.out.print(d.getDealdate() + "\t");
			if(d.getKind() == 0) {
				System.out.print("입금\t");
			}else {
				System.out.print("출금\t");
			}
			System.out.print(d.getDeal() + "\t");
			System.out.print(d.getBalance() + "\t");
		}
	}

}
