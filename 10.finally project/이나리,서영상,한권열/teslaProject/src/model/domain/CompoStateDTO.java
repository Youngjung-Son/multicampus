package model.domain;

public class CompoStateDTO {
	private int state_idx;
	private String compo_name;
	private String replaceDate;
	private String dueDate;
	private String serialno;
	private int percent;
	
	
	public CompoStateDTO() {}
	
	public CompoStateDTO(String compo_name, String replaceDate, String dueDate, String serialno, int percent) {
		super();
		this.compo_name = compo_name;
		this.replaceDate = replaceDate;
		this.dueDate = dueDate;
		this.serialno = serialno;
		this.percent = percent;
	}
	
	public CompoStateDTO(int state_idx, String compo_name, String replaceDate, String dueDate, String serialno, int percent) {
		super();
		this.state_idx = state_idx;
		this.compo_name = compo_name;
		this.replaceDate = replaceDate;
		this.dueDate = dueDate;
		this.serialno = serialno;
		this.percent = percent;
	}
	public int getState_idx() {
		return state_idx;
	}
	public void setState_idx(int state_idx) {
		this.state_idx = state_idx;
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
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	
	
	
	public double getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompoStateDTO [state_idx=");
		builder.append(state_idx);
		builder.append(", compo_name=");
		builder.append(compo_name);
		builder.append(", replaceDate=");
		builder.append(replaceDate);
		builder.append(", dueDate=");
		builder.append(dueDate);
		builder.append(", serialno=");
		builder.append(serialno);
		builder.append(", percent=");
		builder.append(percent);
		builder.append("]");
		return builder.toString();
	}

	
}
