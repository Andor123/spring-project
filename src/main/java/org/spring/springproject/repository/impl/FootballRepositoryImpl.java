package org.spring.springproject.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Football;
import org.spring.springproject.repository.FootballRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class FootballRepositoryImpl implements FootballRepository {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	private final RowMapper<Football> mapper = new RowMapper<Football>() {
		
		@Override
		public Football mapRow(ResultSet rs, int rowNum) throws SQLException {
			Football f = new Football();
			f.setLeague(rs.getString("league"));
			f.setDate(rs.getString("matchdate"));
			f.setTeamName1(rs.getString("teamName1"));
			f.setTeamName2(rs.getString("teamName2"));
			f.setResult(rs.getString("result"));
			return f;
		}
		
	};

	@Override
	public @NotNull List<Football> getFootballResultsFromDatabase() {
		final String sql = "SELECT league, matchDate, teamName1, teamName2, result FROM FOOTBALL";
		
		return jdbctemplate.query(sql, mapper);
	}

}
