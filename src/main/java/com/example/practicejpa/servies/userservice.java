package com.example.practicejpa.servies;

import java.util.Optional;

import com.example.practicejpa.config.security;
import com.example.practicejpa.models.usermodel.userdao;
import com.example.practicejpa.models.usermodel.uservo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userservice {
    
    @Autowired
    private userdao userdao; 
    @Autowired
    private security security;//@Autowired해주고 
    

    public String checkemail(String email) {

        System.out.println(email+"userid");
        Optional<uservo> vo=userdao.findById(email);
        if(vo.isEmpty())///일단 학원가기전까지는 이방법이 제일 편리 한거같다 20200514
        {
             return "yes";
        }
     return "no";
    }

    public boolean insertmember(uservo uservo) {

        try {    
        BCryptPasswordEncoder encoder=security.encoderpwd();///암호리턴받고
        String hashpwd=encoder.encode(uservo.getPwd());//자체함수 소환해서 해쉬해주고
        uservo.setPwd(hashpwd);//셋해서
        userdao.save(uservo);///넣어준다!
        return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

}
