package com.skurski.cron.controller;

import com.skurski.cron.model.ExpertCron;
import com.skurski.cron.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/expert")
public class ExpertController {

    @Autowired
    private CronService cronService;

    @RequestMapping(method = RequestMethod.GET)
    public String main() {
        return "expert";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveCronJob(ExpertCron expertCron) {
        System.out.println(expertCron);
        //todo: validation
        cronService.addCronJob(expertCron);
        return "redirect:/expert";
    }
}
