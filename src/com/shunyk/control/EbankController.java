package com.shunyk.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.shunyk.bankbook.BankbookDAO;
import com.shunyk.bankbook.BankbookDTO;
import com.shunyk.deal.DealDAO;
import com.shunyk.deal.DealDTO;
import com.shunyk.input.EbankInput;
import com.shunyk.member.memberDAO;
import com.shunyk.member.memberDTO;

public class EbankController {
	EbankInput ei;
	memberDTO mdto;
	memberDAO mdao;
	BankbookDTO bdto;
	BankbookDAO bdao;
	DealDTO ddto;
	DealDAO ddao;

	public EbankController() {
		ei = new EbankInput();
		mdao = new memberDAO();
		bdao = new BankbookDAO();
		ddao = new DealDAO();
	}
	public void start() throws Exception{
		Scanner sc = new Scanner(System.in);
		int select;
		int result = 0;
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			select = sc.nextInt();
			if(select == 1) {
				mdto = ei.memberInput();
				result = mdao.memberInsert(mdto);
				if(result != 0) {
					System.out.println("회원가입 성공");
				}else {
					System.out.println("회원가입 실패");
				}
			}else if (select == 2){
				System.out.println("아이디 입력");
				String yid = sc.next();
				System.out.println("비밀번호 입력");
				String ypw = sc.next();

				mdto = mdao.memberSelect(yid, ypw);

				if(mdto != null) {
					bdto = bdao.select(yid);
					if(bdto != null) {
						boolean check = true;
						while(check) {
							System.out.println("1. 입금");
							System.out.println("2. 출금");
							System.out.println("3. 계좌 조회");
							System.out.println("4. 거래 종료");
							select = sc.nextInt();

							switch(select) {
							case 1:
								ddto = new DealDTO();
								ddto = ei.deposit(bdto);
								if(ddto != null) {
									ddto = ddao.dealInsert(ddto);
									if(result != 0) {
										bdto.setBalance(ddto.getBalance());
										System.out.println("입금 성공");
									}else {
										System.out.println("실패");
									}
								}
								break;
							case 2:
								ddto = new DealDTO();
								ddto = ei.withdraw(bdto);
								if(ddto != null) {
									ddto = ddao.dealInsert(ddto);
									if(result != 0) {
										bdto.setBalance(ddto.getBalance());
										System.out.println("출금 성공");
									}else {
										System.out.println("실패");
									}
								}
								break;
							case 3:
								System.out.println("1. 전체 조회");
								System.out.println("2. 기간 설정 조회");
								System.out.println("3. 1개월내 거래 내역 조회");
								System.out.println("4. 2개월내 거래 내역 조회");
								System.out.println("5. 입금 내역 조회");
								System.out.println("6. 출금 내역 조회");
								System.out.println("7. 조회 취소");
								select = sc.nextInt();
								ArrayList<DealDTO> ar = new ArrayList<DealDTO>();
								switch(select) {
								case 1:
									ar = ddao.dealSelectList();
									break;
								case 2:
									System.out.println("기간 입력");
									String dealDate = sc.next();
									String dealDate2 = sc.next();
									ar = ddao.dealSelectOne(dealDate, dealDate2);
									break;
								case 3:
									ar = ddao.dealSelectOne("30");
									break;
								case 4:
									ar = ddao.dealSelectOne("60");
									break;
								case 5:
									ar = ddao.dealSelectOne(0);
									break;
								case 6:
									ar = ddao.dealSelectOne(1);
									break;
								default:
									System.out.println("조회를 취소합니다");
									break;
								}
								break;
							default :
								check = !check;
								break;
							}
						}

						System.out.println("종료합니다");
						break;
					}else {
						System.out.println("통장 개설");
						bdto = ei.bankbookInput(mdto);
						if(bdto != null) {
							System.out.println("개설 완료");
						}else {
							System.out.println("개설 실패");
						}
					}
				}else {
					System.out.println("로그인 실패");
				}
			}else {
				System.out.println("종료합니다");
				break;
			}
		}
	}
}
