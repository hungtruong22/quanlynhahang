package bean;

public class monanbean {
	private String mamonan;
	private String tenmonan;
	private Long gia;
	private String anh;
	private String maloai;
	public monanbean(String mamonan, String tenmonan, Long gia, String anh, String maloai) {
		super();
		this.mamonan = mamonan;
		this.tenmonan = tenmonan;
		this.gia = gia;
		this.anh = anh;
		this.maloai = maloai;
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
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	@Override
	public String toString() {
		return "monanbean [mamonan=" + mamonan + ", tenmonan=" + tenmonan + ", gia=" + gia + ", anh=" + anh
				+ ", maloai=" + maloai + "]";
	}
	
	
}


