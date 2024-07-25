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
        } else if(question.contains("square")) {
            return squareAndCubeNumbers(question, regex);
        } else if(question.contains("power")) {
            return powerNumbers(question, regex);
        } else if(question.contains("minus")) {
            return minusNumbers(question, regex);
        } else if(question.contains("primes")) {
            return primes(question, regex);
        }
        return "no";
    }

    private String primes(String question, Pattern regex) {
        var matcher = regex.matcher(question);
        while (matcher.find()) {
            String group = matcher.group();
            if (isPrime(group)){
                return group;
            }
        }
        return matcher.group();
    }

    private boolean isPrime(String group) {
        int anum = Integer.parseInt(group);
        for (int i = 2; i<=Math.sqrt(anum); i++){
            if (anum % i ==0)
                return false;
        }
        return true;
    }

    private String minusNumbers(String question, Pattern regex) {
        var matcher = regex.matcher(question);
        matcher.find();
        double first =  Double.parseDouble(matcher.group() + "");
        matcher.find();
        double second = Double.parseDouble(matcher.group() + "");

        return String.valueOf((int)(first - second));
    }

    private String powerNumbers(String question, Pattern regex) {
        var matcher = regex.matcher(question);
        matcher.find();
        double first =  Double.parseDouble(matcher.group().toString());
        matcher.find();
        double second = Double.parseDouble(matcher.group());

        return (long)(Math.pow(first, second)) + "";


    }

    private String squareAndCubeNumbers(String question, Pattern regex) {
        var matcher = regex.matcher(question);

        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group());
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num) {
                int cbrt = (int) Math.cbrt(num);
                if (cbrt * cbrt * cbrt == num) {
                    return num + "";
                }
            }
        }

        return null;
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
