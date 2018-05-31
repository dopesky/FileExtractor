/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zip;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

/**
 *
 * @author Kevin
 */
public class ReadZip {

        public void checkOS() {
                String os = System.getProperty("os.name");
                System.out.println("Your OS is " + os);
                if (!os.toLowerCase().contains("windows")) {
                        System.out.println("Your os is not windows.\n Shutting down");
                        System.exit(0);
                }
        }

        public ProcessBuilder cmd(String destination, String source, boolean here) throws IOException, URISyntaxException {
                Process process;
                File f = new File(source);
                File unzip = new File(getClass().getResource("/7-zipPortable/App/7-Zip/7z.exe").toURI());
                File file = new File(destination);
                if (destination.contains("\\")) {
                        file.mkdirs();
                } else {
                        file.mkdir();
                }
                ProcessBuilder builder = new ProcessBuilder(new String[]{"cmd.exe", "/c", "\"" + unzip.getAbsolutePath() + "\" x \"" + f.getAbsolutePath() + "\" -o\"" + file.getAbsolutePath() + "\" -r -y"});
                builder.redirectErrorStream(true);
                if (here) {
                        process = builder.start();
                        Scanner stdInput = new Scanner(process.getInputStream());
                        while (stdInput.hasNext()) {
                                System.out.println(stdInput.nextLine());
                        }
                }
                return builder;

        }

        public ProcessBuilder cmd2(String destination, String source, boolean here) throws IOException {
                Process process;
                File f = new File(source);
                File file = new File(destination);
                if (destination.contains("\\")) {
                        file.mkdirs();
                } else {
                        file.mkdir();
                }
                ProcessBuilder builder = new ProcessBuilder(new String[]{"cmd.exe", "/c", "cd \"" + file.getAbsolutePath() + "\" && jar xvf \"" + f.getAbsolutePath() + "\""});
                builder.redirectErrorStream(true);
                if (here) {
                        process = builder.start();
                        Scanner stdInput = new Scanner(process.getInputStream());
                        while (stdInput.hasNext()) {
                                System.out.println(stdInput.nextLine());
                        }
                }
                return builder;
        }

        public ProcessBuilder setEverythingAndExtract(String path) throws IOException, URISyntaxException {
                ProcessBuilder builder;
                checkOS();
                File temp = new File(path);
                File parent = temp.getParentFile();
                if (path.endsWith(".7z") || path.endsWith(".rar")) {
                        builder=cmd(parent.getAbsolutePath(), path,false);
                } else {
                        builder=cmd2(parent.getAbsolutePath(), path,false);
                }
                return builder;
        }

        public static void main(String[] args) {
                while (true) {
                        try {
                                ReadZip reader = new ReadZip();
                                reader.checkOS();
                                System.out.print("Input path to zipFile: ");
                                Scanner in = new Scanner(System.in);
                                String path = in.next();
                                System.out.print("Input path to destination folder: ");
                                String dest = in.next();
                                if (path.endsWith(".7z") || path.endsWith(".rar")) {
                                        reader.cmd(dest, path, true);
                                } else {
                                        reader.cmd2(dest, path, true);
                                }
                                System.out.println();
                                System.out.println();
                                System.out.println();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
        }
}
