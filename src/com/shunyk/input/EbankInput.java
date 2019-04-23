package com.shunyk.input;

import java.util.Scanner;

import com.shunyk.bankbook.BankbookDTO;
import com.shunyk.deal.DealDTO;
import com.shunyk.member.memberDTO;

public class EbankInput {
	Scanner sc;
	
	public EbankInput() {
		sc = new Scanner(System.in);
	}

	public DealDTO deposit(BankbookDTO bdto){
		DealDTO dto = new DealDTO();
		System.out.println("입금할 금액 입력");
		int deal = sc.nextInt();
		dto.setBnum(bdto.getBnum());
		dto.setDeal(deal);
		System.out.println("거래 일 입력");
		dto.setDealdate(sc.next());
		dto.setKind(0);
		dto.setBalance(bdto.getBalance()+deal);
		return dto;
	}
	
	public DealDTO withdraw(BankbookDTO bdto) {
		DealDTO dto = new DealDTO();
		System.out.println("출금할 금액 입력");
		int deal = sc.nextInt();
		if(bdto.getBalance()>=deal) {
			dto.setBnum(bdto.getBnum());
			dto.setDeal(deal);
			System.out.println("거래 일 입력");
			dto.setDealdate(sc.next());
			dto.setKind(1);
			dto.setBalance(bdto.getBalance()-deal);
		}
		
		return dto;
	}
	
	public memberDTO memberInput() {
		memberDTO dto = new memberDTO();
		
		System.out.println("아이디 입력");
		dto.setId(sc.next());
		System.out.println("비밀번호 입력");
		dto.setPw(sc.next());
		System.out.println("이름 입력");
		dto.setName(sc.next());
		System.out.println("전화번호 입력");
		dto.setPhone(sc.next());
		System.out.println("이메일 입력");
		dto.setEmail(sc.next());
		
		return dto;
	}
	
	public BankbookDTO bankbookInput(memberDTO mdto) {
		BankbookDTO dto = new BankbookDTO();
		
		System.out.println("계좌번호 입력");
		dto.setBnum(sc.next());
		dto.setMid(mdto.getId());
		System.out.println("통장 개설일 입력");
		dto.setOpendate(sc.next());
		System.out.println("통장 이름 입력");
		dto.setBname(sc.next());
		
		return dto;
	}
	
}
