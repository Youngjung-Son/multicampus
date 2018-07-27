package model.domain;

public class CoachDTO {
	private String tname;
	private String name;
	private int stat;

	/* ----------- Constructor ----------- */
	public CoachDTO() {
		super();
	}

	public CoachDTO(String tname, String name, int stat) {
		super();
		this.tname = tname;
		this.name = name;
		this.stat = stat;
	}

	/* ----------- getter / setter ----------- */
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	/* ----------- Override ----------- */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoachDTO [tname=");
		builder.append(tname);
		builder.append(", name=");
		builder.append(name);
		builder.append(", stat=");
		builder.append(stat);
		builder.append("]");
		return builder.toString();
	}
}
