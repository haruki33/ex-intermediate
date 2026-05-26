package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテル情報を管理するサービス.
 */
@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository repository;

    /**
     * priceが、引数で渡されたprice以下のホテル情報を取得する.
     * <p>
     * priceがnull（未入力）の場合、ホテル情報を全件取得する。
     *
     * @param price 値段
     * @return 複数のホテル情報
     */
    public List<Hotel> searchByLessThanPrice(Integer price) {
        if (price == null) {
            return repository.findAll();
        } else {
            return repository.findByLessThanPrice(price);
        }
    }
}
