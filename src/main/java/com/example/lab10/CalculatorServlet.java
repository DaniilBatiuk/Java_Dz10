package com.example.lab10;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        double operand1 = Double.parseDouble(request.getParameter("operand1"));
        double operand2 = Double.parseDouble(request.getParameter("operand2"));

        double result = 0;

        switch (operation) {
            case "add":
                result = operand1 + operand2;
                break;
            case "subtract":
                result = operand1 - operand2;
                break;
            case "multiply":
                result = operand1 * operand2;
                break;
            case "divide":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    request.setAttribute("error", "Division by zero");
                }
                break;
            case "power":
                result = Math.pow(operand1, operand2);
                break;
            case "percentage":
                result = (operand1 * operand2) / 100;
                break;
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("/").forward(request, response);
    }


    public void destroy() {
    }
}
