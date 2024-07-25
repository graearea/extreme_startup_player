package com.oocode;

public class Answerer {
    public String answerFor(String question) {

        if (question.equals("What is your name?")) {

            return "JaeRae";
        } else if (question.startsWith("Which of the following numbers is the largest")) {
            var splietted = question.split(":");
            var numbers = splietted[1].split(",");
            var biggest = 0;
            for(String number: numbers) {
                var intValue=Integer.parseInt(number.trim().replace("?", ""));
                biggest =  intValue > biggest ? intValue: biggest;
            }
            return biggest + "";

        }




        {
            return "98";
        }
    }
}
