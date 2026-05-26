package com.example.controller;

import com.example.domain.Team;
import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping("/show-list")
    public String showList(Model model) {
        List<Team> teamList = service.showList();
        model.addAttribute("teamList", teamList);
        return "show-list";
    }

    @GetMapping("/show-detail")
    public String showDetail(String id, Model model) {
        System.out.println(id);
        Team team = service.showDetail(Long.parseLong(id));
        model.addAttribute("team", team);
        return "show-detail";
    }
}
