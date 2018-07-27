package model.domain;

public class ScheduleDTO {
	private String competition;
	private int sdate; // 주키
	private String stime;
	private String swhere;
	private String awayteam;
	private int home;
	private int away;
	
	/* ----------- Constructor ----------- */
	public ScheduleDTO() {
		super();
	}

	public ScheduleDTO(String competition, int sdate, String stime, String swhere, String awayteam, int home, int away) {
		super();
		this.competition = competition;
		this.sdate = sdate;
		this.stime = stime;
		this.swhere = swhere;
		this.awayteam = awayteam;
		this.home = home;
		this.away = away;
	}

	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public int getSdate() {
		return sdate;
	}

	public void setSdate(int sdate) {
		this.sdate = sdate;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getSwhere() {
		return swhere;
	}

	public void setSwhere(String swhere) {
		this.swhere = swhere;
	}

	public String getAwayteam() {
		return awayteam;
	}

	public void setAwayteam(String awayteam) {
		this.awayteam = awayteam;
	}

	public int getHome() {
		return home;
	}

	public void setHome(int home) {
		this.home = home;
	}

	public int getAway() {
		return away;
	}

	public void setAway(int away) {
		this.away = away;
	}
	
	/* ----------- Override ----------- */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScheduleDTO [competition=");
		builder.append(competition);
		builder.append(", sdate=");
		builder.append(sdate);
		builder.append(", stime=");
		builder.append(stime);
		builder.append(", swhere=");
		builder.append(swhere);
		builder.append(", awayteam=");
		builder.append(awayteam);
		builder.append(", home=");
		builder.append(home);
		builder.append(", away=");
		builder.append(away);
		builder.append("]");
		return builder.toString();
	}	
}
