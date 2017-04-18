package com.skurski.cron.util;

import org.junit.Test;

/**
 * Created by psk on 03.04.17.
 */
public class StringUtilTest {

    @Test
    public void testRemove() throws Exception {
        String crontab = "* * * * * echo \"run\"\n* * * * * echo \"heja\"";

        String toRemove = "* * * * * echo \"heja\"";

        int substringStart = crontab.indexOf(toRemove);
        StringBuilder sb = new StringBuilder();

        if (substringStart == 0) {
            sb.append(crontab.substring(toRemove.length()+1)); // +1 to remove \n
        } else {
            sb.append(crontab.substring(0, substringStart-1));
            int next = substringStart + toRemove.length() -1;
            sb.append(crontab.substring(next));
        }

        System.out.println(sb.toString());
    }
}
