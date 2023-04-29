package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.taikhoanbean;


public class taikhoandao {
	public ArrayList<taikhoanbean> getTK(){
    	ArrayList<taikhoanbean> ds= new ArrayList<taikhoanbean>();
    	try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from taikhoan";
    		PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String matk = rs.getString("matk");
    			String tendn = rs.getString("tendn");
    			String matkhau = rs.getString("matkhau");
    			boolean lanhanvien = rs.getBoolean("lanhanvien");
    			boolean laquanly = rs.getBoolean("laquanly");
    			ds.add(new taikhoanbean(matk, tendn, matkhau, lanhanvien, laquanly));
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
	
	public taikhoanbean login(String user, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql = "select * from taikhoan\r\n"
					+ "where tendn = ? and matkhau = ?";
			PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, user);
    		cmd.setString(2, pass);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			String matk = rs.getString("matk");
    			String tendn = rs.getString("tendn");
    			String matkhau = rs.getString("matkhau");
    			boolean lanhanvien = rs.getBoolean("lanhanvien");
    			boolean laquanly = rs.getBoolean("laquanly");
				return new taikhoanbean(matk, tendn, matkhau, lanhanvien, laquanly);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public taikhoanbean kiemtrataikhoantontai(String user) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from taikhoan\r\n"
					+ "where tendn=?";
			PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, user);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			String matk = rs.getString("matk");
    			String tendn = rs.getString("tendn");
    			String matkhau = rs.getString("matkhau");
    			boolean lanhanvien = rs.getBoolean("lanhanvien");
    			boolean laquanly = rs.getBoolean("laquanly");
				return new taikhoanbean(matk, tendn, matkhau, lanhanvien, laquanly);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void signup(String user, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into taikhoan\r\n"
					+ "values(?,?,1,0)";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, user);
			cmd.setString(2, pass);
			cmd.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		taikhoandao tkdao = new taikhoandao();
		tkdao.signup("nhonviet","666");
	}
}
