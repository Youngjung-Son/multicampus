package model.domain;

public class Coach_PlayerDTO {
	private String position;
	private int cstat;
	private int pstat;
	
	public Coach_PlayerDTO() {
		super();
	}

	public Coach_PlayerDTO(String position, int cstat, int pstat) {
		super();
		this.position = position;
		this.cstat = cstat;
		this.pstat = pstat;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getCstat() {
		return cstat;
	}

	public void setCstat(int cstat) {
		this.cstat = cstat;
	}

	public int getPstat() {
		return pstat;
	}

	public void setPstat(int pstat) {
		this.pstat = pstat;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coach_PlayerDTO [position=");
		builder.append(position);
		builder.append(", cstat=");
		builder.append(cstat);
		builder.append(", pstat=");
		builder.append(pstat);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
