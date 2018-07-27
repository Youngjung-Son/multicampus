package model.domain;

public class CustomerDTO {
	
	private int cust_idx;
	private String cust_email;
	private String cust_name;
	private String cust_pw;
	private String modelName;
	private String serialno;
	private String saledate;
	
	public CustomerDTO() {}
	
	
	
	public CustomerDTO(String cust_email, String cust_name, String serialno) {
		super();
		this.cust_email = cust_email;
		this.cust_name = cust_name;
		this.serialno = serialno;
	}
	
	
	
	public CustomerDTO(String cust_email, String cust_name, String cust_pw, String serialno) {
		super();
		this.cust_email = cust_email;
		this.cust_name = cust_name;
		this.cust_pw = cust_pw;
		this.serialno = serialno;
	}
	
	public CustomerDTO(String cust_email, String cust_name, String cust_pw, String modelName, String serialno, String saledate) {
		super();
		this.cust_email = cust_email;
		this.cust_name = cust_name;
		this.cust_pw = cust_pw;
		this.modelName = modelName;
		this.serialno = serialno;
		this.saledate = saledate;
	}
	
	
	public CustomerDTO(int cust_idx, String cust_email, String cust_name, String cust_pw, String serialno) {
		super();
		this.cust_idx = cust_idx;
		this.cust_email = cust_email;
		this.cust_name = cust_name;
		this.cust_pw = cust_pw;
		this.serialno = serialno;
	}
	public int getCust_idx() {
		return cust_idx;
	}
	public void setCust_idx(int cust_idx) {
		this.cust_idx = cust_idx;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_pw() {
		return cust_pw;
	}
	public void setCust_pw(String cust_pw) {
		this.cust_pw = cust_pw;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	

	public String getModelName() {
		return modelName;
	}



	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	

	public String getSaledate() {
		return saledate;
	}



	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDTO [cust_idx=");
		builder.append(cust_idx);
		builder.append(", cust_email=");
		builder.append(cust_email);
		builder.append(", cust_name=");
		builder.append(cust_name);
		builder.append(", cust_pw=");
		builder.append(cust_pw);
		builder.append(", modelName=");
		builder.append(modelName);
		builder.append(", serialno=");
		builder.append(serialno);
		builder.append(", saledate=");
		builder.append(saledate);
		builder.append("]");
		return builder.toString();
	}



	

	
	
	
}
