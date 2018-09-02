package org.spring.springproject.model;

public class Football {

	private String sportName;
	private String league;
	private String date;
	private String teamName1;
	private String teamName2;
	private String result;
	
	public Football() {
		
	}

	public Football(String sportName, String league, String date, String teamName1, String teamName2, String result) {
		super();
		this.sportName = sportName;
		this.league = league;
		this.date = date;
		this.teamName1 = teamName1;
		this.teamName2 = teamName2;
		this.result = result;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTeamName1() {
		return teamName1;
	}

	public void setTeamName1(String teamName1) {
		this.teamName1 = teamName1;
	}

	public String getTeamName2() {
		return teamName2;
	}

	public void setTeamName2(String teamName2) {
		this.teamName2 = teamName2;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Football [sportName=" + sportName + ", league=" + league + ", date=" + date + ", teamName1=" + teamName1
				+ ", teamName2=" + teamName2 + ", result=" + result + "]";
	}
	
}
