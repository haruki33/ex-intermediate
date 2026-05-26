package com.example.controller;

import com.example.domain.Hotel;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ホテル情報関連処理を制御するコントローラー.
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    /**
     * 検索画面を表示する.
     *
     * @return 検索（結果）画面
     */
    @GetMapping("/")
    public String index() {
        return "search";
    }

    /**
     * 検索結果を表示する.
     *
     * @param price 値段
     * @param model モデル
     * @return 検索（結果）画面
     */
    @PostMapping("/")
    public String result(Integer price, Model model) {
        List<Hotel> hotelList = service.searchByLessThanPrice(price);
        model.addAttribute("hotelList", hotelList);
        model.addAttribute("price", price);
        return "search";
    }
}
