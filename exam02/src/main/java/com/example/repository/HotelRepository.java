package com.example.repository;

import com.example.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * hotelsテーブルを操作するリポジトリ.
 */
@Repository
public class HotelRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
        return Hotel.builder()
                .id(rs.getLong("id"))
                .areaName(rs.getString("area_name"))
                .hotelName(rs.getString("hotel_name"))
                .address(rs.getString("address"))
                .nearestStation(rs.getString("nearest_station"))
                .price((Integer) rs.getObject("price"))
                .parking(rs.getString("parking"))
                .build();
    };

    /**
     * priceが、引数で渡されたprice以下のホテル情報を取得する.
     *
     * @param price 値段
     * @return 複数のホテル情報
     */
    public List<Hotel> findByLessThanPrice(Integer price) {
        String sql = """
                SELECT
                    id
                ,   area_name
                ,   hotel_name
                ,   address
                ,   nearest_station
                ,   price
                ,   parking
                FROM
                    hotels
                WHERE
                    price <= :price
                ORDER BY
                    price DESC
                ;
                """;
        SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
        return template.query(sql, param, HOTEL_ROW_MAPPER);
    }

    /**
     * ホテル情報全件取得する.
     *
     * @return ホテル情報全件
     */
    public List<Hotel> findAll() {
        String sql = """
                SELECT
                    id
                ,   area_name
                ,   hotel_name
                ,   address
                ,   nearest_station
                ,   price
                ,   parking
                FROM
                    hotels
                ORDER BY
                    price DESC
                ;
                """;
        return template.query(sql, HOTEL_ROW_MAPPER);
    }
}
