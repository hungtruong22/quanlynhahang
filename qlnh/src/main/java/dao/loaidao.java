package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import bean.loaibean;
import bean.monanbean;

public class loaidao {
    public ArrayList<loaibean> getloai(){
    	ArrayList<loaibean> ds= new ArrayList<loaibean>();
    	try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from loai";
    		PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String maloai = rs.getString("maloai");
    			String tenloai = rs.getString("tenloai");
    			ds.add(new loaibean(maloai, tenloai));
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    	
    }
    
    public loaibean getLoaiById(String id){
		ArrayList<loaibean> ds = new ArrayList<loaibean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from loai\r\n"
    				+ "where maloai=?;";
    		PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, id);		
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String maloai=rs.getString("maloai");
				String tenloai=rs.getString("tenloai");
				return new loaibean(maloai,tenloai);
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    
    public void xoa(String loaiid) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "delete from loai\r\n"
					+ "where maloai = ?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, loaiid);		
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void them(String maloai, String tenloai) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql="insert into loai(maloai,tenloai)\r\n"
					+ "values(?,?)";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			cmd.setString(2, tenloai);
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sua(String maloai, String tenloai) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="update loai\r\n"
					+ "set tenloai=?\r\n"
					+ " where maloai=?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tenloai);
			cmd.setString(2, maloai);
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    
    public int getTotalLoai() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select count(*) from loai";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			return rs.getInt(1);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public ArrayList<loaibean> pagingLoai(int index){
		ArrayList<loaibean> list = new ArrayList<loaibean>();
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select * from loai\r\n"
					+ "order by maloai\r\n"
					+ "offset ? rows fetch next 6 rows only";
			
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, (index-1)*6);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			String maloai=rs.getString("maloai");
				String tenloai=rs.getString("tenloai");
				list.add(new loaibean(maloai, tenloai));
    		}
    		rs.close();
			kn.cn.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
