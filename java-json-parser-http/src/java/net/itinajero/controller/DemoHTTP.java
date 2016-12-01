package net.itinajero.controller;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

public class DemoHTTP {
    public static void main(String[] args) throws Exception {
        //URL url = new URL("http://itinajero.net");
        URL url = new URL("http://ipinfo.io/json");
        HttpURLConnection conn1 = (HttpURLConnection) url.openConnection();
        //HttpsURLConnection conn2 = (HttpsURLConnection) url.openConnection();
        conn1.setRequestMethod("GET");
        InputStreamReader isr = new InputStreamReader(conn1.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            sb.append(line);
        }
        Gson gson = new Gson();
        br.close();
        IpInfoBean bean = gson.fromJson(sb.toString(), IpInfoBean.class); 
        System.out.println("Bean: "+ bean);
    }
}
