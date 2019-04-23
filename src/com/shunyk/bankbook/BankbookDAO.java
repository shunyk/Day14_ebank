package com.shunyk.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shunyk.deal.DealDAO;
import com.shunyk.deal.DealDTO;
import com.shunyk.member.memberDTO;
import com.shunyk.util.DBConnect;

public class BankbookDAO {
	PreparedStatement st;
	ResultSet rs;

	public int bankbookInsert(BankbookDTO dto) throws Exception{
		int result = 0;

		Connection con = DBConnect.dbConnect();

		String sql = "insert into bankbook values (?,?,to_date(?, 'yyyymmdd'),?,0)";

		st = con.prepareStatement(sql);

		st.setString(1, dto.getBnum());
		st.setString(2, dto.getMid());
		st.setString(3, dto.getOpendate());
		st.setString(4, dto.getBname());

		result = st.executeUpdate();

		DBConnect.disConnect(st, con);

		return result;
	}

	public int bankbookDealete(Connection con, String id) throws Exception{
		int result = 0;

		String sql = "select bnum from bankbook where mid = ?";
		st = con.prepareStatement(sql);
		st.setString(1, id);
		rs = st.executeQuery();
		rs.next();
		DealDAO dao = new DealDAO();

		result = dao.dealDelete(rs.getString("bnum"), con);

		if(result != 0) {
			sql = "delete bankbook where mid = ?";

			st = con.prepareStatement(sql);

			st.setString(1, id);

			result = st.executeUpdate();
		}
		DBConnect.disConnect(rs);
		return result;
	}

	public int bankbookDealete(String bnum) throws Exception{
		int result = 0;
		Connection con = DBConnect.dbConnect();

		DealDAO dao = new DealDAO();
		result = dao.dealDelete(bnum, con);

		if(result != 0) {
			String sql = "delete bankbook where bnum = ?";

			st = con.prepareStatement(sql);

			st.setString(1, bnum);

			result = st.executeUpdate();
		}

		DBConnect.disConnect(st, con);

		return result;
	}

	public int bankbookUpdate(DealDTO ddto, Connection con) throws Exception{
		String sql = "update bankbook set balance = ?";

		st = con.prepareStatement(sql);

		st.setInt(1, ddto.getBalance());

		int result = st.executeUpdate();

		return result;
	}

	public BankbookDTO select(String yid) throws Exception{
		Connection con = DBConnect.dbConnect();
		BankbookDTO dto = new BankbookDTO();

		String sql = "select * from bankbook where mid = ?";

		st = con.prepareStatement(sql);
		st.setString(1, yid);
		rs = st.executeQuery();

		while(rs.next()) {
			dto.setBnum(rs.getString("bnum"));
			dto.setMid(rs.getString("mid"));
			dto.setOpendate(rs.getString("opendate"));
			dto.setBname(rs.getString("bname"));
			dto.setBalance(rs.getInt("balance"));
		}

		return dto;
	}

}
