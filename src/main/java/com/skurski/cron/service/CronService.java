package com.skurski.cron.service;

import com.skurski.cron.model.Cron;
import com.skurski.cron.model.Crontab;
import com.skurski.cron.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

@Service
public class CronService {

    private static final String CRONTAB_LIST = "crontab -l";

    public Crontab getCrontab() {
        return new Crontab(executeShellCommand(CRONTAB_LIST));
    }

    public void addCronJob(Cron cron) {
        Function<Cron, String> converter = (cronJob) -> {
            StringBuilder sb = new StringBuilder();
            if (cronJob.getScript().isEmpty()) {
                // todo: inform client that no script to execute
                return sb.toString();
            }
            if (cronJob.getSpecial().isPresent()) {
                sb.append(cronJob.getSpecial().get().getParameter());
                sb.append(" ");
                sb.append(cronJob.getScript());
                return sb.toString();
            }
            //todo: implement cron job without annotation ( * * * * * )
            return "";
        };

        String cronJob = converter.apply(cron);
        StringUtil.appendToFile("cron/crontab.txt", cronJob);
        //todo: refactor path
        executeShellCommand("crontab /home/psk/IdeaProjects/cron-webui/target/classes/cron/crontab.txt");
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
