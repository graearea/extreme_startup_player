package com.oocode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Answerer {

    Pattern regex = Pattern.compile("\\d+");
    public String answerFor(String question) {

        if (question.equals("What is your name?")) {
            return myName();
        } else if (question.startsWith("Which of the following numbers is the largest")) {
            return biggestNumber(question);
        } else if (question.contains("plus")) {
            return addNumbers(question, regex);

        } else if (question.contains("multiplied")) {
            return multNumbers(question, regex);
        }
        return "no";
    }

    private String multNumbers(String question, Pattern regex) {
        var matcher = regex.matcher(question);
        int sum = 1;

        while (matcher.find()) {
            sum = sum * Integer.parseInt(matcher.group());
        }

        return String.valueOf(sum);
    }

    private  String myName() {
        return "JaeRae";
    }

    private  String addNumbers(String question, Pattern regex) {
        var matcher = regex.matcher(question);
        int sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }

        return String.valueOf(sum);
    }

    private  String biggestNumber(String question) {
        var biggest = 0;
        var matcher = regex.matcher(question);
        while(matcher.find()){
            int intValue = Integer.parseInt(matcher.group());
            biggest = intValue > biggest ? intValue : biggest;

        }
        return biggest + "";
    }
}
