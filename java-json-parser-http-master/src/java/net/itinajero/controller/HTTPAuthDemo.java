package net.itinajero.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.util.Base64;

public class HTTPAuthDemo {
    public static void main(String[] args) throws Exception {        
        URL url = new URL("http://saaf.sazacatecas.gob.mx/getListaMuebles?wsdl");
        HttpURLConnection conn1 = (HttpURLConnection) url.openConnection();
        //HttpsURLConnection conn2 = (HttpsURLConnection) url.openConnection();
        conn1.setRequestMethod("GET");
        String base64encoded = Base64.getEncoder().encodeToString("myUser:withPass".getBytes("utf-8"));
        System.out.println("Base64 encoding:" + base64encoded);
        // "Authorization" request header 
        conn1.setRequestProperty("Authorization", "Basic " + base64encoded);
        InputStreamReader isr = new InputStreamReader(conn1.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {            
            sb.append(line);
        }
        System.out.println("Info: " +  sb.toString());        
    }
}



