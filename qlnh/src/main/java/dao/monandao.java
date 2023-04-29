package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.monanbean;

public class monandao {
	public ArrayList<monanbean> getMonan(){
		ArrayList<monanbean> ds = new ArrayList<monanbean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from monan";
    		PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String mamonan=rs.getString("mamonan");
				String tenmonan=rs.getString("tenmonan");
				Long gia=rs.getLong("gia");
				String anh=rs.getString("anhmonan");
				String maloai=rs.getString("maloai");
				ds.add(new monanbean(mamonan, tenmonan, gia, anh, maloai));
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
	
	public monanbean getNewFood() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql = "select top 1 * from monan\r\n"
					+ "order by mamonan desc";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String mamonan=rs.getString("mamonan");
				String tenmonan=rs.getString("tenmonan");
				Long gia=rs.getLong("gia");
				String anh=rs.getString("anhmonan");
				String maloai=rs.getString("maloai");
				return new monanbean(mamonan, tenmonan, gia, anh, maloai);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<monanbean> getMonanByCategory(String loaiid){
		ArrayList<monanbean> ds = new ArrayList<monanbean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from monan\r\n"
    				+ "where maloai=?;";
    		PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, loaiid);		
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String mamonan=rs.getString("mamonan");
				String tenmonan=rs.getString("tenmonan");
				Long gia=rs.getLong("gia");
				String anh=rs.getString("anhmonan");
				String maloai=rs.getString("maloai");
				ds.add(new monanbean(mamonan, tenmonan, gia, anh, maloai));
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
	
	public monanbean getMonanById(String id){
		ArrayList<monanbean> ds = new ArrayList<monanbean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from monan\r\n"
    				+ "where mamonan=?;";
    		PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, id);		
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String mamonan=rs.getString("mamonan");
				String tenmonan=rs.getString("tenmonan");
				Long gia=rs.getLong("gia");
				String anh=rs.getString("anhmonan");
				String maloai=rs.getString("maloai");
				return new monanbean(mamonan, tenmonan, gia, anh, maloai);
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<monanbean> searchByName(String tma){
		ArrayList<monanbean> ds = new ArrayList<monanbean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from monan\r\n"
    				+ "where tenmonan like ? ";
    		PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, "%"+tma+"%");		
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String mamonan=rs.getString("mamonan");
				String tenmonan=rs.getString("tenmonan");
				Long gia=rs.getLong("gia");
				String anh=rs.getString("anhmonan");
				String maloai=rs.getString("maloai");
				ds.add(new monanbean(mamonan, tenmonan, gia, anh, maloai));
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
	
	public void xoa(String monanid) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "delete from monan\r\n"
					+ "where mamonan = ?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, monanid);		
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void them(String mamonan, String tenmonan, Long gia
			, String anh, String maloai) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
//			DateFormat d= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date doi= d.parse(ngaynhap);
//			java.sql.Date nn=new java.sql.Date(doi.getTime());
			String sql="insert into monan(mamonan,tenmonan,gia,anhmonan,maloai)\r\n"
					+ "values(?,?,?,?,?)";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, mamonan);
			cmd.setString(2, tenmonan);
			cmd.setLong(3, gia);
			cmd.setString(4, anh);
			cmd.setString(5, maloai);
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sua(String mamonan, String tenmonan, Long gia
			, String anh, String maloai) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="update monan\r\n"
					+ "set tenmonan=?, gia=?,\r\n"
					+ " anhmonan=?, maloai=?\r\n"
					+ " where mamonan=?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tenmonan);
			cmd.setLong(2, gia);
			cmd.setString(3, anh);
			cmd.setString(4, maloai);
			cmd.setString(5, mamonan);
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getTotalFood() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select count(*) from monan";
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
	
	public ArrayList<monanbean> pagingFood(int index){
		ArrayList<monanbean> list = new ArrayList<monanbean>();
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select * from monan\r\n"
					+ "order by mamonan\r\n"
					+ "offset ? rows fetch next 6 rows only";
			
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, (index-1)*6);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			String mamonan=rs.getString("mamonan");
				String tenmonan=rs.getString("tenmonan");
				Long gia=rs.getLong("gia");
				String anh=rs.getString("anhmonan");
				String maloai=rs.getString("maloai");
				list.add(new monanbean(mamonan, tenmonan, gia, anh, maloai));
    		}
    		rs.close();
			kn.cn.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		monandao madao = new monandao();
		System.out.println(madao.getNewFood());
	}
}
