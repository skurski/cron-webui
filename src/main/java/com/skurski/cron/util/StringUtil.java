package com.skurski.cron.util;


import java.io.*;

public class StringUtil {

    public static File getFile(String filePath) {
        ClassLoader classLoader = StringUtil.class.getClassLoader();
        return  new File(classLoader.getResource(filePath).getFile());
    }

    public static String read(String filePath) {
        ClassLoader classLoader = StringUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            System.out.println("File red from path: "  + file.getAbsolutePath());
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File appendToFile(String filePath, String content) {
        ClassLoader classLoader = StringUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(content);
            bw.write('\n');
            System.out.println("ExpertCron job wrote to file successfully, filename: "  + file.getAbsolutePath());
            return file;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static File putToFile(String filePath, String content) {
        ClassLoader classLoader = StringUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            bw.write(content);
            bw.write('\n');
            System.out.println("ExpertCron job wrote to file successfully, filename: "  + file.getAbsolutePath());
            return file;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void resetFile(String filePath) {
        ClassLoader classLoader = StringUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

        try(PrintWriter pw = new PrintWriter(file);) {
            System.out.println("Reset crontab file: " + file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String remove(String content, String toRemove) {
        int substringStart = content.indexOf(toRemove);
        StringBuilder sb = new StringBuilder();

        if (substringStart == 0) {
            sb.append(content.substring(toRemove.length()+1)); // +1 to remove \n
        } else {
            sb.append(content.substring(0, substringStart-1));
            int next = substringStart + toRemove.length() -1;
            sb.append(content.substring(next));
        }

        return sb.toString().trim();
    }
}
