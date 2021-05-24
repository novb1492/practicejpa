package com.example.practicejpa.models.boardmodel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface boarddao extends JpaRepository<boardvo,Integer> {
    
}
