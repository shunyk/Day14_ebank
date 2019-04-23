package com.shunyk.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shunyk.bankbook.BankbookDAO;
import com.shunyk.util.DBConnect;

public class memberDAO {
	PreparedStatement st;
	ResultSet rs;

	public int memberInsert(memberDTO dto) throws Exception{
		int result = 0;

		Connection con = DBConnect.dbConnect();

		String sql = "insert into member values (?,?,?,?,?)";

		st = con.prepareStatement(sql);

		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		st.setString(3, dto.getName());
		st.setString(4, dto.getPhone());
		st.setString(5, dto.getEmail());

		result = st.executeUpdate();

		DBConnect.disConnect(st, con);
		
		return result;
	}

	public int memberUpdate(String str, String update) throws Exception{
		int result = 0;

		Connection con = DBConnect.dbConnect();

		String sql = "update member set" + str + " = ?";

		st = con.prepareStatement(sql);

		st.setString(1, update);

		result = st.executeUpdate();
		
		DBConnect.disConnect(st, con);

		return result;
	}

	public int memberDelete(String id) throws Exception{
		int result = 0;

		Connection con = DBConnect.dbConnect();

		BankbookDAO dao = new BankbookDAO();
		result = dao.bankbookDealete(con, id);

		if(result != 0) {
			String sql = "delete member where id = ?";

			st = con.prepareStatement(sql);

			st.setString(1, id);

			result = st.executeUpdate();
		}
		
		DBConnect.disConnect(st, con);

		return result;
	}
	
	public memberDTO memberSelect(String yid, String ypw) throws Exception{
		memberDTO dto = new memberDTO();
		Connection con = DBConnect.dbConnect();
		
		String sql = "select id from member where id = ? and pw = ?";
		
		st = con.prepareStatement(sql);
		
		st.setString(1, yid);
		st.setString(2, ypw);
		
		rs = st.executeQuery();
		
		rs.next();
		dto.setId(rs.getString("id"));
		return dto;
	}

}
