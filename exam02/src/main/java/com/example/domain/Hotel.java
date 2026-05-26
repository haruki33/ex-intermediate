package com.example.domain;

import lombok.*;

/**
 * Hotel情報を表すドメイン.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Hotel {
    /**
     * ID
     */
    private Long id;

    /**
     * 地域名
     */
    private String areaName;

    /**
     * ホテル名
     */
    private String hotelName;

    /**
     * 住所
     */
    private String address;

    /**
     * 最も近い駅
     */
    private String nearestStation;

    /**
     * 値段
     */
    private Integer price;

    /**
     * 駐車場の有無（あり or なし）
     */
    private String parking;
}
