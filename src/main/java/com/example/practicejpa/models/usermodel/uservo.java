package com.example.practicejpa.models.usermodel;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Data;

@Data
@Table(name="members")
@Entity
public class uservo {
    
    @Id
    @Column(name="email",length = 30,unique=true,nullable = false)
    private String email;

    @Column(name="pwd",length = 100,nullable = false )
    private String pwd;

    @Column(name="name",length = 20,nullable = false)
    private String name;

    
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)///테이블은 여기서 만들고 mysql에서 오토인크리먼트하면된다
    private int id;

    @Column(name="created",nullable=false)
    @CreationTimestamp  
    private Timestamp created;
}
