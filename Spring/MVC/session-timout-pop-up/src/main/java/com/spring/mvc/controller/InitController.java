package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;
import org.springframework.web.HttpSessionRequiredException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

import com.spring.mvc.vo.LoginVo;


import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InitController{
    @RequestMapping(value={"","/test"}, method=RequestMethod.GET)
    public String testPage(ModelMap modelMap){
        LoginVo loginVo = new LoginVo();
        modelMap.addAttribute("loginForm",loginVo);
        return "index";
    }

     @RequestMapping(value={"/content"}, method=RequestMethod.GET)
    public String contentView(ModelMap modelMap){
        return "content";
    }

    @RequestMapping(value="login",method=RequestMethod.POST)
    public ModelAndView getDashBoard(@ModelAttribute("loginForm") LoginVo loginVo,BindingResult bindingResult
    ){
        if(null != loginVo){
            ModelAndView mv1 = new ModelAndView("dashboard");
            System.out.println("UN :: "+loginVo.getUserName()+"\nPWD"+loginVo.getPassword());
            mv1.addObject("userName",loginVo.getUserName());
            return mv1;
        }else{
            return new ModelAndView("index");
        }
    } 


    /*This method is causing the Null pointer exception - Need to figure out the issue*/
    @RequestMapping(value={"rest"}, method=RequestMethod.GET)
    @ResponseBody
    public String restPage(ModelMap modelMap){
        System.out.println("Rest Controller....");
          LoginVo loginVo = new LoginVo();
        modelMap.addAttribute("loginForm",loginVo);
        return "index";
    }

 
}