package com.example.domain;

import lombok.*;

/**
 * 衣類情報を表すドメイン.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Clothes {
    /**
     * ID
     */
    private Long id;

    /**
     * カテゴリー
     */
    private String category;

    /**
     * 分類
     */
    private String genre;

    /**
     * 性別
     */
    private Integer gender;

    /**
     * 色
     */
    private String color;

    /**
     * 価格
     */
    private Integer price;

    /**
     * サイズ
     */
    private String size;
}
