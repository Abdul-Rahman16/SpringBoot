package com.luvcode.springcoredemo.rest;

import com.luvcode.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    public Coach myCoach;
    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
         return myCoach.getDailyWorkout();
    }




}
