package com.example.lab10;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/text-analysis")
public class TextAnalysisServlet extends HttpServlet {

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");

        int vowelsCount = countVowels(text);
        String vowelsList = listVowels(text);
        int consonantsCount = countConsonants(text);
        String consonantsList = listConsonants(text);
        int punctuationCount = countPunctuation(text);
        String punctuationList = listPunctuation(text);

        request.setAttribute("vowelsCount", vowelsCount);
        request.setAttribute("vowelsList", vowelsList);
        request.setAttribute("consonantsCount", consonantsCount);
        request.setAttribute("consonantsList", consonantsList);
        request.setAttribute("punctuationCount", punctuationCount);
        request.setAttribute("punctuationList", punctuationList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/");
        dispatcher.forward(request, response);
    }

    private int countVowels(String text) {
        Pattern pattern = Pattern.compile("[AEIOUaeiou]");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private String listVowels(String text) {
        Pattern pattern = Pattern.compile("[AEIOUaeiou]");
        Matcher matcher = pattern.matcher(text);
        StringBuilder list = new StringBuilder();
        while (matcher.find()) {
            list.append(matcher.group()).append(" ");
        }
        return list.toString();
    }

    private int countConsonants(String text) {
        Pattern pattern = Pattern.compile("[BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private String listConsonants(String text) {
        Pattern pattern = Pattern.compile("[BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]");
        Matcher matcher = pattern.matcher(text);
        StringBuilder list = new StringBuilder();
        while (matcher.find()) {
            list.append(matcher.group()).append(" ");
        }
        return list.toString();
    }

    private int countPunctuation(String text) {
        Pattern pattern = Pattern.compile("[.,!?;]");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private String listPunctuation(String text) {
        Pattern pattern = Pattern.compile("[.,!?;]");
        Matcher matcher = pattern.matcher(text);
        StringBuilder list = new StringBuilder();
        while (matcher.find()) {
            list.append(matcher.group()).append(" ");
        }
        return list.toString();
    }

    public void destroy() {
    }
}