package com.oocode;

import java.util.regex.Pattern;

public class Answerer {
    public String answerFor(String question) {

        if (question.equals("What is your name?")) {
            return "JaeRae";
        } else if (question.startsWith("Which of the following numbers is the largest")) {
            var splietted = question.split(":");
            var numbers = splietted[1].split(",");
            var biggest = 0;
            for (String number : numbers) {
                var intValue = Integer.parseInt(number.trim().replace("?", ""));
                biggest = intValue > biggest ? intValue : biggest;
            }
            return biggest + "";
        } else if (question.contains("plus")) {
            var regex = Pattern.compile("\\d+");
            var matcher = regex.matcher(question);

            int sum = 0;

            while (matcher.find()){
                sum += Integer.parseInt(matcher.group());
            }

            return String.valueOf( sum  );
        }
        return "no";
    }
}
