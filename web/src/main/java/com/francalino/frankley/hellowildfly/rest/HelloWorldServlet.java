package com.francalino.frankley.hellowildfly.rest;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/HelloWorld")                                           // (1)
public class HelloWorldServlet extends HttpServlet {

   static String PAGE_HEADER =
       "<html><head><title>helloworld</title></head><body>";                // (2)

   static String PAGE_FOOTER = "</body></html>";

   @Inject
   HelloService helloService;                                        // (3)

   @Override
   protected void doGet(HttpServletRequest req,
                        HttpServletResponse resp)
                        throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();
      writer.println(PAGE_HEADER);
      writer.println("<h1>" +
                     helloService.createHelloMessage("World") +      // (4)
                     "</h1>");
      writer.println(PAGE_FOOTER);
      writer.close();
   }

}