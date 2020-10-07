package ca.ciccc;

import java.math.BigDecimal;

public class Assignment1 {

    /**
     * Write a function to convert temperature from Fahrenheit to Celsius degree
     * Sample Input : 212
     *
     * @param degree
     * @return "212.0 degree Fahrenheit is equal to 100.0 in Celsius"
     */
    public static String fahrenheitToCelsius(double degree) {

        double celsius = (degree - 32) * ((double) 5 / 9);
        String result = String.format("%.1f degree Fahrenheit is equal to %.1f in Celsius", degree, celsius);

        return result;
    }

    /**
     * Write a function program that takes an integer in inches, converts in to meters.
     * Sample Input : 1000
     *
     * @param inches
     * @return "1000.0 inches is 25.4 meters"
     */
    public static String inchesToMeters(int inches) {
        double meter = inches * 0.0254;
        return String.format("1000.0 inches is %.1f meters", meter);
    }

    /**
     * Write a function that takes an integer between 0 and 1000 and adds all the digits.
     * Sample Input : 565
     *
     * @param number
     * @return "The sum of all digits in 565 is 16"
     */
    public static String addDigits(int number) {
        int answer = number;
        int sum    = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return String.format("The sum of all digits in %d is %d", answer, sum);
    }

    /**
     * Write a function that takes an integer as minutes and convert it to years and days.
     * Sample Input : 3456789
     *
     * @param mins
     * @return "3456789 minutes is approximately 6 years and 210 days"
     */
    public static String minsToYearsDays(int mins) {
        int years = mins / 525600;
        int days = mins % 525600 / 1440;
        return String.format("%d minutes is approximately %d years and %d days", mins, years, days);
    }

    /**
     * Write a function that takes weight as Kgs(Kilograms) and height as meters and compute
     * body mass index (BMI)
     * Sample Input: kgs = 70, meters = 1.75
     *
     * @param kgs
     * @param meters
     * @return "Body Mass Index is 22.857"
     */
    public static String bmi(int kgs, double meters) {
        double result = kgs / meters / meters;
        return String.format("Body Mass Index is %.3f", result);
    }

    /**
     * Write a function that takes a distance (in meters) and the time was taken
     * (as three numbers: hours, minutes, seconds), and display the speed, in meters
     * per second, kilometers per hour and miles per hour
     * (hint: 1 mile = 1609 meters).
     * Sample Input :
     * meters = 2500
     * hours = 5
     * minutes = 56
     * seconds = 23
     *
     * @param meters
     * @param hours
     * @param minutes
     * @param seconds
     * @return
     *      "Your speed in meters/second is 0.1169
     *       Your speed in km/h is 0.4208
     *       Your speed in miles/h is 0.2615"
     */
    public static String speed(int meters, int hours, int minutes, int seconds) {
        double hourToSecond = hours * 60 * 60;
        double minutToSecond = minutes * 60;
        double total = hourToSecond + minutToSecond + seconds;
        double perSecond = meters / total;
        double perHour = perSecond * 3.6;
        double perMile = perHour / 1.61;
        String formated = "Your speed in meters/second is %.4f\n" +
                "Your speed in km/h is %.4f\n" +
                "Your speed in miles/h is %.4f";
        return String.format(formated,
                perSecond,
                toDecimal(perHour, BigDecimal.ROUND_DOWN),
                toDecimal(perMile, BigDecimal.ROUND_UP));
    }

    /**
     * Write a function that reads a number and display the square,
     * cube, and the fourth power.
     * Sample Input :
     * number = 5
     *
     * @param number
     * @return "Square: 25
     *          Cube: 125
     *          Fourth power: 625"
     */
    public static String powers(int number) {
        int square = number * number;
        int qube = square * number;
        int fourthP = qube * number;
        return String.format("Square: %d\nCube: %d\nFourth power: %d", square, qube, fourthP);
    }

    /**
     * Write a function that takes two integers a and b, then prints the sum,
     * the difference, the product, the average, the distance (absolute value of
     * the difference), the maximum, and the minimum between the two.
     * Sample Input :
     * a = 25
     * b = 5
     *
     * @param a
     * @param b
     * @return "Sum of two integers: 30
     *          Difference of two integers: 20
     *          Product of two integers: 125
     *          Average of two integers: 15.00
     *          Distance of two integers: 20
     *          Max integer: 25
     *          Min integer: 5"
     */
    public static String arithmetic(int a, int b) {
        int sum = a + b;
        int diff = a - b;
        int pOfTwo = a * b;
        double average = (a + b) / 2;
        int dist = Math.abs(getBigger(a, b) - getSmaller(a, b));
        int max = getBigger(a, b);
        int min = getSmaller(a, b);
        String formated = "Sum of two integers: %d\n" +
                "Difference of two integers: %d\n" +
                "Product of two integers: %d\n" +
                "Average of two integers: %.2f\n" +
                "Distance of two integers: %d\n" +
                "Max integer: %d\nMin integer: %d";
        return String.format(formated,
                sum,
                diff,
                pOfTwo,
                average,
                dist,
                max,
                min);
    }

    public static BigDecimal toDecimal(double n, int roundingMode) {
        return new BigDecimal(n).setScale(4, roundingMode);
    }

    public static int getBigger(int x, int y) {
        return x > y? x : y;
    }

    public static int getSmaller(int x, int y) {
        return x > y? y : x;
    }
}
