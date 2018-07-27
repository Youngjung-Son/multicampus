package model.domain;

public class CompoHistoryDTO {

	private int hist_idx;
	private String serialno;
	private String compo_name;
	private String replaceDate;
	
	
	public CompoHistoryDTO() {}
	
	public CompoHistoryDTO(String serialno, String compo_name, String replaceDate) {
		super();
		this.serialno = serialno;
		this.compo_name = compo_name;
		this.replaceDate = replaceDate;
	}
	
	public CompoHistoryDTO(int hist_idx, String serialno, String compo_name, String replaceDate) {
		super();
		this.hist_idx = hist_idx;
		this.serialno = serialno;
		this.compo_name = compo_name;
		this.replaceDate = replaceDate;
	}
	public int getHist_idx() {
		return hist_idx;
	}
	public void setHist_idx(int hist_idx) {
		this.hist_idx = hist_idx;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public String getCompo_name() {
		return compo_name;
	}
	public void setCompo_name(String compo_name) {
		this.compo_name = compo_name;
	}
	public String getReplaceDate() {
		return replaceDate;
	}
	public void setReplaceDate(String replaceDate) {
		this.replaceDate = replaceDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompoHistory [hist_idx=");
		builder.append(hist_idx);
		builder.append(", serialno=");
		builder.append(serialno);
		builder.append(", compo_name=");
		builder.append(compo_name);
		builder.append(", replaceDate=");
		builder.append(replaceDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
