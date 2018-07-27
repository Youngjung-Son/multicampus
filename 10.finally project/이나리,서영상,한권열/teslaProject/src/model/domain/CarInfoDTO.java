package model.domain;

public class CarInfoDTO {

	private String serialno;
	private String modelName;
	private String saleDate;
	private int certificate;
	
	public CarInfoDTO() {}
	public CarInfoDTO(String serialno, String modelName, String saleDate, int certificate) {
		super();
		this.serialno = serialno;
		this.modelName = modelName;
		this.saleDate = saleDate;
		this.certificate = certificate;
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
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public int getCertificate() {
		return certificate;
	}
	public void setCertificate(int certificate) {
		this.certificate = certificate;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarInfo [serialno=");
		builder.append(serialno);
		builder.append(", modelName=");
		builder.append(modelName);
		builder.append(", saleDate=");
		builder.append(saleDate);
		builder.append(", certificate=");
		builder.append(certificate);
		builder.append("]");
		return builder.toString();
	}
	
}
