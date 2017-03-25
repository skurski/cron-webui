package com.skurski.cron.controller;

import com.skurski.cron.model.Cron;
import com.skurski.cron.model.Crontab;
import com.skurski.cron.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private CronService cronService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        Crontab crontab = cronService.getCrontab();
        model.addAttribute("crontab", crontab);
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveCronJob(Cron cron) {
        System.out.println(cron);

        //todo: validation
        cronService.addCronJob(cron);

        return "redirect:/";
    }
}
