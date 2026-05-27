package com.example.controller;

import com.example.domain.Clothes;
import com.example.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 衣類関連処理を制御するコントローラー.
 */
@Controller
@RequestMapping("/clothes")
public class ClothesController {

    @Autowired
    private ClothesService service;

    /**
     * 検索（結果）画面を表示する.
     *
     * @return 検索（結果）画面
     */
    @GetMapping("")
    public String index() {
        return "search";
    }

    /**
     * 渡された値で検索し、検索（結果）画面を表示する.
     *
     * @return 検索（結果）画面
     */
    @PostMapping("")
    public String search(String gender, String color, Model model) {
        model.addAttribute("isValid", false);

        if (gender == null || color == null) {
            model.addAttribute("isValid", true);
            model.addAttribute("message", "不正な値が指定されました。");
            return "search";
        }
        List<Clothes> clothesList = service.showClothes(Integer.parseInt(gender), color);
        model.addAttribute("clothesList", clothesList);
        return "search";
    }

}
