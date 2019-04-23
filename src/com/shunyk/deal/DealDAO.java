package com.shunyk.deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.shunyk.bankbook.BankbookDAO;
import com.shunyk.util.DBConnect;

public class DealDAO {
	PreparedStatement st;
	ResultSet rs;

	public DealDTO dealInsert(DealDTO dto) throws Exception{
		int result = 0;
		Connection con = DBConnect.dbConnect();

		BankbookDAO dao = new BankbookDAO();
		result = dao.bankbookUpdate(dto, con);

		if(result != 0) {
			String sql = "insert into deal values(?,?,?,?,?)";

			st = con.prepareStatement(sql);

			st.setString(1, dto.getBnum());
			st.setInt(2, dto.getKind());
			st.setString(3, dto.getDealdate());
			st.setInt(4, dto.getDeal());
			st.setInt(5, dto.getBalance());

			result = st.executeUpdate();
		}
		
		DBConnect.disConnect(st, con);

		return dto;
	}

	public int dealDelete(String bnum, Connection con) throws Exception{
		String sql = "delete deal where bnum = ?";

		st = con.prepareStatement(sql);

		st.setString(1, bnum);

		int result = st.executeUpdate();

		return result;
	}

	public ArrayList<DealDTO> dealSelectList() throws Exception{
		Connection con = DBConnect.dbConnect();
		ArrayList<DealDTO> ar = new ArrayList<DealDTO>();

		String sql = "select * from deal";

		st = con.prepareStatement(sql);

		rs = st.executeQuery();

		while(rs.next()) {
			DealDTO dto = new DealDTO();
			dto.setBnum(rs.getString("bnum"));
			dto.setKind(rs.getInt("kind"));
			dto.setDealdate(rs.getString("dealdate"));
			ar.add(dto);
		}
		
		DBConnect.disConnect(st, con, rs);

		return ar;
	}

	public ArrayList<DealDTO> dealSelectOne(int kind) throws Exception{
		Connection con = DBConnect.dbConnect();
		ArrayList<DealDTO> ar = new ArrayList<DealDTO>();

		String sql = "select * from deal where kind = ?";

		st = con.prepareStatement(sql);

		st.setInt(1, kind);

		rs = st.executeQuery();

		while(rs.next()) {
			DealDTO dto = new DealDTO();
			dto.setBnum(rs.getString("bnum"));
			dto.setKind(rs.getInt("kind"));
			dto.setDealdate(rs.getString("dealdate"));
			ar.add(dto);
		}
		
		DBConnect.disConnect(st, con, rs);

		return ar;
	}

	public ArrayList<DealDTO> dealSelectOne(String dealDate, String dealDate2) throws Exception{
		Connection con = DBConnect.dbConnect();
		ArrayList<DealDTO> ar = new ArrayList<DealDTO>();

		String sql = "select * from deal where dealdate between to_date(?, 'yyyymmdd') and to_date(?, 'yyyymmdd')";

		st = con.prepareStatement(sql);

		st.setString(1, dealDate);
		st.setString(2, dealDate2);

		rs = st.executeQuery();

		while(rs.next()) {
			DealDTO dto = new DealDTO();
			dto.setBnum(rs.getString("bnum"));
			dto.setKind(rs.getInt("kind"));
			dto.setDealdate(rs.getString("dealdate"));
			ar.add(dto);
		}
		
		DBConnect.disConnect(st, con, rs);

		return ar;
	}

	public ArrayList<DealDTO> dealSelectOne(String date) throws Exception{
		Connection con = DBConnect.dbConnect();
		ArrayList<DealDTO> ar = new ArrayList<DealDTO>();

		String sql = "select * from deal where dealdate = between sysdate-" + date + " and sysdate";

		st = con.prepareStatement(sql);

		rs = st.executeQuery();

		while(rs.next()) {
			DealDTO dto = new DealDTO();
			dto.setBnum(rs.getString("bnum"));
			dto.setKind(rs.getInt("kind"));
			dto.setDealdate(rs.getString("dealdate"));
			ar.add(dto);
		}
		
		DBConnect.disConnect(st, con, rs);

		return ar;
	}

}
