package com.shunyk.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shunyk.bankbook.BankbookDAO;
import com.shunyk.bankbook.BankbookDTO;

public class BankbookDAOTest {

	@Test
	public void test() throws Exception{
		BankbookDAO dao = new BankbookDAO();
		BankbookDTO dto = new BankbookDTO();
		
		dto.setBnum("111-111-111111");
		dto.setMid("ksy");
		dto.setOpendate("20190328");
		dto.setBname("선영 통장");
		
		int result = dao.bankbookInsert(dto);
		
		assertNotEquals(result, 0);
	}

}
