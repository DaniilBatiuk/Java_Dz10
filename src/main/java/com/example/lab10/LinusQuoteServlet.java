package com.example.lab10;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/linus-quote")
public class LinusQuoteServlet extends HttpServlet {

    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Цитата Лінуса Торвальдса:</h1>");
        response.getWriter().println("<p>Bad programmers worry about the code. Good programmers worry about data structures and their relationships</p>");
        response.getWriter().println("</body></html>");
    }

    public void destroy() {
    }
}
