package com.example.practicejpa.servies;

import java.util.Optional;

import com.example.practicejpa.config.security;
import com.example.practicejpa.models.usermodel.userdao;
import com.example.practicejpa.models.usermodel.uservo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class userservice {
    
    @Autowired
    private userdao userdao; 
    @Autowired
    private security security;//@Autowired해주고 
    

    public String checkemail(String email) {

        System.out.println(email+"중복검사");
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

    public uservo getinfor() {
        Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails details=(UserDetails)principal;
        System.out.println(details.getUsername()+"조회이메일");
        uservo uservo=userdao.findById(details.getUsername()).orElseThrow();
        System.out.println(uservo.getName()+"다녀왔니");
        return uservo;
    }
    public boolean checkpwdwithdbpwd(String pwd,String email) 
    {
        BCryptPasswordEncoder bCryptPasswordEncoder=security.encoderpwd();
        String dbpwd=userdao.getpwd(email);
        if(bCryptPasswordEncoder.matches(pwd, dbpwd))
        {
            return true;
        }
        return false;
    }
    @Transactional
    public boolean updatepwd(String email,String pwd) {

        try {
            BCryptPasswordEncoder bCryptPasswordEncoder=security.encoderpwd();
            String hashpwd=bCryptPasswordEncoder.encode(pwd);
            uservo uservo=userdao.findById(email).orElseThrow();
            uservo.setPwd(hashpwd);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return true;
    }

}
