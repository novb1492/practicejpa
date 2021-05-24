package com.example.practicejpa.controller;



import com.example.practicejpa.models.boardmodel.boardvo;
import com.example.practicejpa.models.usermodel.uservo;
import com.example.practicejpa.servies.boardservice;
import com.example.practicejpa.servies.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class controller {

    @Autowired
    private userservice userservice;
    @Autowired
    private boardservice boardservice;

    @PostMapping("/auth/joinprocess")
    public String name(uservo uservo) {
        boolean tf=userservice.insertmember(uservo);
        if(tf==true)
        {
            return "loginpage";
        }
        else{
            return "joinpage";
        }
    }
    @GetMapping("/auth/loginpage")
    public String loginpage() {
        return "loginpage";
    }
    @GetMapping("/auth/joinpage")
    public String joinpage() {

        return "joinpage";
        
    }
    @GetMapping("/auth/index")
    public String index() {

        return "index";
        
    }
    @GetMapping("/auth/boardlist")
    public String boardlist(Model model,@RequestParam(value = "page",defaultValue = "1")int page) {
        Page<boardvo>array=boardservice.getallboard(page);
        model.addAttribute("totalpages", array.getTotalPages());
        model.addAttribute("page", page);
        model.addAttribute("array", array);
        return "boardlist";
    }
    @GetMapping("mypage")
    public String mypage(Model model) {
    
        uservo uservo=userservice.getinfor();
        model.addAttribute("uservo", uservo);
        return "mypage";
    }
    @GetMapping("updatepwdpage")
    public String updatepwdpage() {
    
        return "updatepwdpage";
    }

    
}
