package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hoadondao {
	public long maxhd() {
		   
		  try {
			  KetNoi kn= new KetNoi();
				kn.KetNoi();		
				String sql="select max(mahd) as maxhd  from hoadon";
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				ResultSet rs= cmd.executeQuery();
				long kq=0;
				if(rs.next()) {//Dang nhap thanh cong
					kq=rs.getLong("maxhd");
				}
				rs.close();
				kn.cn.close();
				return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
	   }
		public int Them(String tkid) {
			try {
				KetNoi kn= new KetNoi();
				kn.KetNoi();
				String sql="insert into hoadon(matk,ngaydat,dadat) values(?,?,?)";
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				cmd.setString(1, tkid);
				Date n= new Date();
				SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String ngay = dd.format(n);
				Date ngaymua=dd.parse(ngay);
				cmd.setDate(2, new java.sql.Date(ngaymua.getTime()));
				cmd.setBoolean(3, false);
				int kq=cmd.executeUpdate();
				kn.cn.close();
				return kq;
			} catch (Exception e) {
				e.printStackTrace();return 0;
			}
		}
}
