package net.itinajero.controller;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Gson gson = new Gson();
        //URL url = new URL("http://itinajero.net");
        URL url = new URL("http://ipinfo.io/json");        
        URLConnection conn = url.openConnection();
        String encoding = conn.getContentEncoding();
        // open the stream and put it into BufferedReader 
        InputStreamReader isr = encoding == null ? new InputStreamReader(conn.getInputStream()) : new InputStreamReader(conn.getInputStream(), encoding);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            sb.append(line);
        }
        
        br.close();
        IpInfoBean bean = gson.fromJson(sb.toString(), IpInfoBean.class);         
        request.setAttribute("bean", bean);
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        rd.forward(request, response);

    }
}
