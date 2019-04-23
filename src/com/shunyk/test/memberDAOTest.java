package com.shunyk.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shunyk.member.memberDAO;
import com.shunyk.member.memberDTO;

public class memberDAOTest {

	@Test
	public void test() throws Exception{
		memberDTO dto = new memberDTO();
		memberDAO dao = new memberDAO();
		dto.setId("ksy");
		dto.setPw("ksy");
		dto.setName("강선영");
		dto.setEmail("ksy@a.com");
		dto.setPhone("010-111-1111");
		int result = dao.memberInsert(dto);
		
		assertNotEquals(result, 0);
	}

}
