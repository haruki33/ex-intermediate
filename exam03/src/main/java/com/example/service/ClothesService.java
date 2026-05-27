package com.example.service;

import com.example.domain.Clothes;
import com.example.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 衣類情報を管理するサービス.
 */
@Service
@Transactional
public class ClothesService {

    @Autowired
    private ClothesRepository repository;

    /**
     * 性別と色に基づいて衣類情報を検索する.
     *
     * @param gender 性別
     * @param color  色
     * @return 該当する衣類情報のリスト
     */
    public List<Clothes> searchClothes(Integer gender, String color) {
        return repository.findByGenderAndColor(gender, color);
    }
}
