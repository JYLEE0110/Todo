package org.zerock.bj2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample/")
@Log4j2
public class SampleController {

    @GetMapping("list")
    public void hello(){
        log.info("sample...");
    }

    
}
