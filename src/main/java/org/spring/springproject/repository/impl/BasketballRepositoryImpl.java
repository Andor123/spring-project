package org.spring.springproject.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Basketball;
import org.spring.springproject.repository.BasketballRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BasketballRepositoryImpl implements BasketballRepository {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	private final RowMapper<Basketball> mapper = new RowMapper<Basketball>() {

		@Override
		public Basketball mapRow(ResultSet rs, int rowNum) throws SQLException {
			Basketball b = new Basketball();
			b.setLeague(rs.getString("league"));
			b.setDate(rs.getString("matchdate"));
			b.setTeamName1(rs.getString("teamName1"));
			b.setTeamName2(rs.getString("teamName2"));
			b.setResult(rs.getString("result"));
			return b;
		}
		
	};

	@Override
	public @NotNull List<Basketball> getBasketballResultsFromDatabase() {
		final String sql = "SELECT league, matchDate, teamName1, teamName2, result FROM BASKETBALL";
		
		return jdbctemplate.query(sql, mapper);
	}

}
