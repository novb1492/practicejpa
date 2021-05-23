package com.example.practicejpa.models.usermodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userdao extends JpaRepository<uservo,String> {///얘는 인터페이스로
    

}
