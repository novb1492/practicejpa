package com.example.practicejpa.servies;


import com.example.practicejpa.models.boardmodel.boarddao;
import com.example.practicejpa.models.boardmodel.boardvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class boardservice {
    
    @Autowired
    private boarddao boarddao;

    private final int pagesize=4;

    public Page<boardvo> getallboard(int currentpage) {
        Page<boardvo>array=boarddao.findAll(PageRequest.of(currentpage-1, pagesize,Sort.by(Sort.Direction.DESC,"bid")));;///이한줄짜리 코드가 엄청 중요하다
        return array;
    }
}
