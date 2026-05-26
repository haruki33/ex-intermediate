package com.example.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

/**
 * 野球チームを表すドメイン
 */
public class Team {
    /**
     * ID
     */
    private Long id;

    /**
     * リーグ名
     */
    private String leagueName;

    /**
     * チーム名
     */
    private String teamName;

    /**
     * 本拠地
     */
    private String headquarters;

    /**
     * 発足日
     */
    private String inauguration;

    /**
     * 歴史
     */
    private String history;
}
