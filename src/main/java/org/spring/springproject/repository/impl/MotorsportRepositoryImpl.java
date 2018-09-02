package org.spring.springproject.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Motorsport;
import org.spring.springproject.repository.MotorsportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MotorsportRepositoryImpl implements MotorsportRepository {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	private final RowMapper<Motorsport> mapper = new RowMapper<Motorsport>() {

		@Override
		public Motorsport mapRow(ResultSet rs, int rowNum) throws SQLException {
			Motorsport m = new Motorsport();
			m.setSportName(rs.getString("sportName"));
			m.setChampionship(rs.getString("championship"));
			m.setGrandPrix(rs.getString("grandPrix"));
			m.setDate(rs.getString("raceDate"));
			m.setDriverName(rs.getString("driverName"));
			m.setTeamName1(rs.getString("teamName1"));
			m.setWinningTime(rs.getString("winningTime"));
			return m;
		}
		
	};

	@Override
	public @NotNull List<Motorsport> getMotorsportResultsFromDatabase(@NotNull LocalDate fromTime,
			@NotNull LocalDate toTime) {
		final String sql = "SELECT sportName, championship, grandPrix, raceDate, driverName, teamName1, winningTime FROM RESULTS "
				+ "WHERE raceDate >= ? AND raceDate <= ? AND winningTime IS NOT NULL AND sportName = 'Motorsport'";
		
		return jdbctemplate.query(sql, mapper, fromTime, toTime);
	}

	@Override
	public @NotNull List<Motorsport> getMotorsportFixturesFromDatabase(@NotNull LocalDate fromTime,
			@NotNull LocalDate toTime) {
		final String sql = "SELECT sportName, championship, grandPrix, raceDate, driverName, teamName1, winningTime FROM RESULTS "
				+ "WHERE raceDate >= ? AND raceDate <= ? AND winningTime IS NULL AND sportName = 'Motorsport'";
		
		return jdbctemplate.query(sql, mapper, fromTime, toTime);
	}

}
