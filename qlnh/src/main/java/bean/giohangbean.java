package bean;

public class giohangbean {
	private String mamonan;
	private String tenmonan;
	private Long soluong;
	private Long gia;
	private String anh;
	private Long thanhtien;
	public 	giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String mamonan, String tenmonan, long soluong, long gia, String anh, long thanhtien) {
		super();
		this.mamonan = mamonan;
		this.tenmonan = tenmonan;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
		this.thanhtien = thanhtien;
	}
	
	
	public giohangbean(String mamonan, String tenmonan, long soluong, long gia, String anh) {
		super();
		this.mamonan = mamonan;
		this.tenmonan = tenmonan;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
	}
	
	
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMamonan() {
		return mamonan;
	}
	public void setMamonan(String mamonan) {
		this.mamonan = mamonan;
	}
	public String getTenmonan() {
		return tenmonan;
	}
	public void setTenmonan(String tenmonan) {
		this.tenmonan = tenmonan;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhtien() {
		return soluong*gia;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	@Override
	public String toString() {
		return "giohangbean [mamonan=" + mamonan + ", tenmonan=" + tenmonan + ", soluong=" + soluong + ", gia=" + gia
				+ ", thanhtien=" + thanhtien + "]";
	}
	
	
}
