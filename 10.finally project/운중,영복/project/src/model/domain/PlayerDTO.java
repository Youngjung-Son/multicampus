package model.domain;

public class PlayerDTO {
	private String tname;
	private String name;
	private int bnumber;
	private String position;
	private int stat;
	private long inumber;
	
	/* ----------- Constructor ----------- */

	public PlayerDTO() {
		super();
	}
	public PlayerDTO(String tname, String name, int bnumber, String position, int stat, long inumber) {
		super();
		this.tname = tname;
		this.name = name;
		this.bnumber = bnumber;
		this.position = position;
		this.stat = stat;
		this.inumber = inumber;
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
	public int getBnumber() {
		return bnumber;
	}
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public long getInumber() {
		return inumber;
	}
	public void setInumber(long inumber) {
		this.inumber = inumber;
	}
	/* ----------- Override ----------- */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlayerDTO [tname=");
		builder.append(tname);
		builder.append(", name=");
		builder.append(name);
		builder.append(", bnumber=");
		builder.append(bnumber);
		builder.append(", position=");
		builder.append(position);
		builder.append(", stat=");
		builder.append(stat);
		builder.append(", inumber=");
		builder.append(inumber);
		builder.append("]");
		return builder.toString();
	}
}
