package org.spring.springproject.model;

public class Motorsport {
	
	private String sportName;
	private String championship;
	private String grandPrix;
	private String date;
	private String driverName;
	private String teamName1;
	private String winningTime;
	
	public Motorsport() {
		
	}

	public Motorsport(String sportName, String championship, String grandPrix, String date, String driverName,
			String teamName1, String winningTime) {
		super();
		this.sportName = sportName;
		this.championship = championship;
		this.grandPrix = grandPrix;
		this.date = date;
		this.driverName = driverName;
		this.teamName1 = teamName1;
		this.winningTime = winningTime;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
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

	public String getTeamName1() {
		return teamName1;
	}

	public void setTeamName1(String teamName1) {
		this.teamName1 = teamName1;
	}

	public String getWinningTime() {
		return winningTime;
	}

	public void setWinningTime(String winningTime) {
		this.winningTime = winningTime;
	}

	@Override
	public String toString() {
		return "Motorsport [sportName=" + sportName + ", championship=" + championship + ", grandPrix=" + grandPrix
				+ ", date=" + date + ", driverName=" + driverName + ", teamName1=" + teamName1 + ", winningTime="
				+ winningTime + "]";
	}

}
