package com.skurski.cron.controller;

import com.skurski.cron.model.CronDto;
import com.skurski.cron.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/job-list")
public class JobController {

    @Autowired
    private CronService cronService;

    @RequestMapping(method = RequestMethod.GET)
    public String main(Model model) {
        List<CronDto> crontab = cronService.getCrontab();
        model.addAttribute("crontab", crontab);
        return "job-list";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String resetCrontab() {
        cronService.resetCrontab();
        return "redirect:/job-list";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeCronJob(CronDto cronDto) {
        cronService.removeCronJob(cronDto);
        return "redirect:/job-list";
    }
}
