package com.shunyk.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.shunyk.util.DBConnect;

public class DBConnectTest {

	@Test
	public void test() throws Exception{
		Connection con = DBConnect.dbConnect();
		assertNotNull(con);
	}

}
