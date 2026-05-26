package com.example.service;

import com.example.domain.Team;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * チーム情報を管理するサービス
 */
@Service
@Transactional
public class TeamService {
    @Autowired
    private TeamRepository repository;

    /**
     * チーム全件取得
     *
     * @return チーム情報（idとnameのみ）全件
     */
    public List<Team> showList() {
        return repository.findAll();
    }

    /**
     * チーム詳細を取得
     *
     * @param id ID
     * @return チーム情報
     */
    public Team showDetail(Long id) {
        return repository.findById(id);
    }
}
