package com.leapfrog.filiodownloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import sun.net.URLCanonicalizer;

public class Program {

    public static void main(String[] args) {
        String link = "http://www.bigfoto.com/usa-west-road.jpg";
        String path="C:\\Users\\dell.000\\Desktop\\Icons\\";
        try {
            System.out.println("Downloading...."+link);
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            String[] tokens = link.split("/");
            FileOutputStream fileOutputStream = new FileOutputStream(path +tokens[tokens.length - 1]);

            byte[] data = new byte[1024 * 5];
            int i = 0;
            while ((i = is.read(data)) != -1) {
                 
                fileOutputStream.write(data, 0, i);
            }
            is.close();
            fileOutputStream.close();
            System.out.println("Download Completed!");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

}
