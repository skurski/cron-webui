package com.skurski.cron.controller;

import com.skurski.cron.model.Cron;
import com.skurski.cron.model.CronDto;
import com.skurski.cron.model.Crontab;
import com.skurski.cron.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private CronService cronService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
//        List<String> crontab = cronService.getCrontab();
        List<CronDto> crontab = cronService.getCrontab();
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

    @RequestMapping(value = "reset", method = RequestMethod.POST)
    public String resetCrontab() {
        cronService.resetCrontab();
        return "redirect:/";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCronJob() {
        cronService.resetCrontab();
        return "redirect:/";
    }
}
