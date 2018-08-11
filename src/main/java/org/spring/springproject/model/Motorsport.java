package org.spring.springproject.model;

public class Motorsport {
	
	private String championship;
	private String grandPrix;
	private String date;
	private String driverName;
	private String teamName;
	private String winningTime;
	
	public Motorsport() {
		
	}
	
	public Motorsport(String championship, String grandPrix, String date, String driverName, String teamName,
			String winningTime) {
		super();
		this.championship = championship;
		this.grandPrix = grandPrix;
		this.date = date;
		this.driverName = driverName;
		this.teamName = teamName;
		this.winningTime = winningTime;
	}

	public String getChampionship() {
		return championship;
	}

	public void setChampionship(String championship) {
		this.championship = championship;
	}

	public String getGrandPrix() {
		return grandPrix;
	}

	public void setGrandPrix(String grandPrix) {
		this.grandPrix = grandPrix;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getWinningTime() {
		return winningTime;
	}

	public void setWinningTime(String winningTime) {
		this.winningTime = winningTime;
	}

	@Override
	public String toString() {
		return "Motorsport [championship=" + championship + ", grandPrix=" + grandPrix + ", date=" + date
				+ ", driverName=" + driverName + ", teamName=" + teamName + ", winningTime=" + winningTime + "]";
	}

}
