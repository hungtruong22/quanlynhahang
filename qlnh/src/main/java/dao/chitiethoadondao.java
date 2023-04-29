package dao;

import java.sql.PreparedStatement;

public class chitiethoadondao {
	public int Them(String mamonan, long soluongmua, long maxmahd) {
		try {
			KetNoi kn= new KetNoi();
			kn.KetNoi();
			String sql="insert into chitiethoadon(mamonan,soluongdat, mahd,dadat) values(?,?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, mamonan);
			cmd.setLong(2, soluongmua);
			cmd.setLong(3, maxmahd);
			cmd.setBoolean(4, false);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
	}
}
