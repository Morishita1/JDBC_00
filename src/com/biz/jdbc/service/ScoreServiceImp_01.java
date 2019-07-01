package com.biz.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.model.ScoreVO;

public class ScoreServiceImp_01 implements ScoreService {

	@Override
	public List<ScoreVO> selctAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreVO findBySeq(long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScoreVO> findByStNum(String stNum) {
		// TODO Auto-generated method stub
		String sql=" SELECT * FROM stb_score ";
		sql += " WHERE sc_no ? ";
		PreparedStatement ps=null;
		try {
			ps=DBConnection.dbConn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			ps.setString(1, stNum);
			List<ScoreVO> scList=new ArrayList<ScoreVO>();
			while(rs.next()) {
				ScoreVO vo=new ScoreVO(
					rs.getLong("sc_seq"),
					rs.getString("sc_date"),
					rs.getString("sc_st_no"),
					rs.getString("sc_subject"),
					rs.getInt("sc_score")
					);
				scList.add(vo);
			}
			return scList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		String sql=" INSERT INTO tbl_score ( ";
		sql +=" sc_seq, ";
		sql +=" sc_date, ";
		sql +=" sc_st_no, ";
		sql +=" sc_subject, ";
		sql +=" sc_score ) ";
		sql +=" VALUES ( ?,?,?,?,? ) ";
		PreparedStatement ps=null;
		
		try {
			ps=DBConnection.dbConn.prepareStatement(sql);
			ps.setLong(1, vo.getSc_seq());
			ps.setString(2, vo.getSc_date());
			ps.setString(3, vo.getSc_st_no());
			ps.setString(4, vo.getSc_subject());
			ps.setInt(5, vo.getSc_score());
			ps.executeUpdate();
			System.out.println("학생성적을 입력완료");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
