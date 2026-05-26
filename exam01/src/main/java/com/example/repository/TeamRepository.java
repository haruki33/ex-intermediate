package com.example.repository;

import com.example.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Teamsテーブルを操作するリポジトリ.
 */
@Repository
public class TeamRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;


    private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
        return Team.builder()
                .id(rs.getLong("id"))
                .leagueName(rs.getString("league_name"))
                .teamName(rs.getString("team_name"))
                .headquarters(rs.getString("headquarters"))
                .inauguration(rs.getString("inauguration"))
                .history(rs.getString("history"))
                .build();
    };

    /**
     * チーム全件取得する.
     *
     * @return チーム全件
     */
    public List<Team> findAll() {
        String sql = """
                SELECT
                    id
                ,   league_name
                ,   team_name
                ,   headquarters
                ,   inauguration
                ,   history
                FROM
                    teams
                ORDER BY
                    inauguration
                ;
                """;
        return template.query(sql, TEAM_ROW_MAPPER);
    }

    /**
     * 指定されたIDのチーム情報を取得する.
     *
     * @param id ID
     * @return 指定されたIDのチーム情報を取得する
     */
    public Team findById(Long id) {
        String sql = """
                SELECT
                    id
                ,   league_name
                ,   team_name
                ,   headquarters
                ,   inauguration
                ,   history
                FROM
                    teams
                WHERE
                    id = :id
                ;
                """;
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        return template.queryForObject(sql, param, TEAM_ROW_MAPPER);
    }
}
