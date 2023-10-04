import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static int romanToInteger(String s){

        int totalValue = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            // with the charAt we will be able to run through all indices of the s string

            if (currentChar == 'I') {
                if (i + 1 < length && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    totalValue -= 1; // Subtract 1 if followed by 'V' or 'X'
                } else {
                    totalValue += 1;
                }
            } else if (currentChar == 'V') {
                totalValue += 5;
            } else if (currentChar == 'X') {
                if (i + 1 < length && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    totalValue -= 10; // Subtract 10 if followed by 'L' or 'C'
                } else {
                    totalValue += 10;
                }
            } else if (currentChar == 'L') {
                totalValue += 50;
            } else if (currentChar == 'C') {
                if (i + 1 < length && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    totalValue -= 100; // Subtract 100 if followed by 'D' or 'M'
                } else {
                    totalValue += 100;
                }
            } else if (currentChar == 'D') {
                totalValue += 500;
            } else if (currentChar == 'M') {
                totalValue += 1000;
            }
        }
        return totalValue;
    }
    public static boolean containsValidRomanNumeral(String input) {
        // this method's parameter includes the input the user entered in the main method.
        // Define a regular expression to match valid Roman numerals
        String validRomanNumeralPattern = "^(M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3}))$";
        // this pattern limits the roman numerals in a way that they can be combined accurately within the range of 1 to 3999
        // e.g. for M you can use it 3 times the most, or you can use CM once or other D or C combination in an accurate way (C,CC,DCC etc.)
        // Check if the input matches the valid Roman numeral pattern
        return Pattern.matches(validRomanNumeralPattern, input);
    }

    public static void main(String[] args) {
        Scanner input  =  new Scanner(System.in);
        System.out.print("Please enter a roman numeral in the range of 1-3999 : ");
         String romanNumeral = input.nextLine();
         while(romanNumeral.length() < 1 || romanNumeral.length() > 15){
             System.out.print("Please make sure the roman numeral has a character length between 1(incl.) to 15(incl.) : ");
             romanNumeral = input.nextLine();
         }

        while(!containsValidRomanNumeral(romanNumeral)){
            System.out.print("The roman numeral that you entered must contain only roman numeral and be in range of 1 to 3999 : ");
            romanNumeral = input.nextLine();
        }


        System.out.println("The roman numeral : " + romanNumeral + " and the numeric form of it : " + romanToInteger(romanNumeral));
    }
}
