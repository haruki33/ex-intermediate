package com.example.repository;

import com.example.domain.Clothes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * clothesテーブルを操作するリポジトリ.
 */
@Repository
public class ClothesRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Clothes> CLOTHES_ROW_MAPPER = (rs, i) -> {
        return Clothes.builder()
                .id(rs.getLong("id"))
                .category(rs.getString("category"))
                .genre(rs.getString("genre"))
                .gender((Integer) rs.getObject("gender"))
                .color(rs.getString("color"))
                .price((Integer) rs.getObject("price"))
                .size(rs.getString("size"))
                .build();
    };

    /**
     * GenderとColorで衣類情報を検索する.
     *
     * @param gender 性別
     * @param color  色
     * @return 複数の衣類情報
     */
    public List<Clothes> findByGenderAndColor(Integer gender, String color) {
        String sql = """
                SELECT
                    id
                ,   category
                ,   genre
                ,   gender
                ,   color
                ,   price
                ,   size
                FROM
                    clothes
                WHERE
                    gender = :gender
                    AND
                    color = :color
                ORDER BY
                    gender
                ,   color
                ;
                """;
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("gender", gender)
                .addValue("color", color);

        return template.query(sql, param, CLOTHES_ROW_MAPPER);
    }
}
