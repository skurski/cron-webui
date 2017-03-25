package com.skurski.cron.util;


import java.io.*;

public class StringUtil {

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

    public static void appendToFile(String filePath, String content) {
        ClassLoader classLoader = StringUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(content);
            bw.write('\n');
            System.out.println("Cron job wrote to file successfully, filename: "  + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
