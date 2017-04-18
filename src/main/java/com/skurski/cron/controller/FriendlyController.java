package com.skurski.cron.controller;

import com.skurski.cron.model.FriendlyCron;
import com.skurski.cron.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/friendly")
public class FriendlyController {

    @Autowired
    private CronService cronService;

    @RequestMapping(method = RequestMethod.GET)
    public String main() {
        return "friendly";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveCronJob(FriendlyCron friendlyCron) {
        System.out.println(friendlyCron);
        //todo: validation
        cronService.addCronJob(friendlyCron);
        return "redirect:/friendly";
    }
}
