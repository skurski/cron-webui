package com.skurski.cron.service;

import com.skurski.cron.model.ExpertCron;
import com.skurski.cron.model.CronDto;
import com.skurski.cron.model.FriendlyCron;
import com.skurski.cron.util.StringUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class CronService {

    private static final String CRONTAB_LIST = "crontab -l";
    private static final String CRON_CRONTAB_TXT = "cron/crontab.txt";
    private static final String CRON_RESET_TXT = "cron/reset.txt";
    private static final String CRONTAB = "crontab ";

    public List<CronDto> getCrontab() {
        List<CronDto> cronJobs = new ArrayList<>();
        String content = executeShellCommand(CRONTAB_LIST);

        for (int i = 0, j = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (c == '\n') {
                cronJobs.add(new CronDto(content.substring(j, i)));
                j = i + 1;
            }
        }

        return cronJobs;
    }

    public void addCronJob(ExpertCron expertCron) {
        Function<ExpertCron, String> converter = (cronJob) -> {
            StringBuilder sb = new StringBuilder();
            if (cronJob.isEmpty()) {
                // todo: inform client that no script to execute
                return sb.toString();
            }
            System.out.println("cronjob: " + cronJob);

            if (cronJob.isSpecial()) {
                return sb.append(cronJob.getSpecialWithScript()).toString();
            }

            return sb.append(cronJob.getParamsWithScript()).toString();
        };

        String cronJob = converter.apply(expertCron);
        if (cronJob.isEmpty()) {
            return;
        }
        File file = StringUtil.appendToFile(CRON_CRONTAB_TXT, cronJob);
        executeShellCommand(CRONTAB + file.getAbsolutePath());
    }

    public void addCronJob(FriendlyCron friendlyCron) {
        Function<FriendlyCron, String> converter = (cronJob) -> {
            StringBuilder sb = new StringBuilder();
            if (cronJob.isEmpty()) {
                // todo: inform client that no script to execute
                return sb.toString();
            }
            System.out.println("cronjob: " + cronJob);

            return friendlyCron.getCommand();
        };

        String cronJob = converter.apply(friendlyCron);
        if (cronJob.isEmpty()) {
            return;
        }
        File file = StringUtil.appendToFile(CRON_CRONTAB_TXT, cronJob);
        executeShellCommand(CRONTAB + file.getAbsolutePath());
    }

    public void resetCrontab() {
        File resetFile = StringUtil.getFile(CRON_RESET_TXT);
        executeShellCommand(CRONTAB + resetFile.getAbsolutePath());
        StringUtil.resetFile(CRON_CRONTAB_TXT);
    }

    public void removeCronJob(CronDto cronDto) {
        String crontab = executeShellCommand(CRONTAB_LIST);
        String newCrontab = StringUtil.remove(crontab, cronDto.getRow());
        if (newCrontab.isEmpty()) {
            resetCrontab();
            return;
        }
        File cronFile = StringUtil.putToFile(CRON_CRONTAB_TXT, newCrontab);
        executeShellCommand(CRONTAB + cronFile.getAbsolutePath());
    }

    private String executeShellCommand(String command) {
        StringBuffer output = new StringBuffer();
        System.out.println("Start executing shell command: " + command);

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}
