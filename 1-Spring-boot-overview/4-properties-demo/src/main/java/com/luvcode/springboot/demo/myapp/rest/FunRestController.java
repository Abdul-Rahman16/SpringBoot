package com.luvcode.springboot.demo.myapp.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //injecting custom properties
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + "Team name: " + teamName;
    }


     @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
    @GetMapping("/workout")
    public String getDailyWorkout(){
      return "Run Ussain bolt";
    }

}
