package com.example.lab10;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/max-number")
public class MaxNumberServlet extends HttpServlet {

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int num3 = Integer.parseInt(request.getParameter("num3"));
        String operation = request.getParameter("operation");

        int result = 0;
        String operationName = "";

        switch (operation) {
            case "max":
                result = Math.max(num1, Math.max(num2, num3));
                operationName = "Максимум";
                break;
            case "min":
                result = Math.min(num1, Math.min(num2, num3));
                operationName = "Мінімум";
                break;
            case "avg":
                result = (num1 + num2 + num3) / 3;
                operationName = "Середнє арифметичне";
                break;
        }

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("Число 1: " + num1 + "<br>");
        response.getWriter().println("Число 2: " + num2 + "<br>");
        response.getWriter().println("Число 3: " + num3 + "<br>");
        response.getWriter().println("<h1>" + operationName + ": " + result + "</h1>");
        response.getWriter().println("</body></html>");
    }

    public void destroy() {
    }
}
