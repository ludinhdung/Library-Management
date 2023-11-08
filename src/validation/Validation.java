package validation;

import controller.DocumentManagement;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Validation {
    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String result = scanner.nextLine();
            if (result.isEmpty()) {
                System.err.println("Empty. Enter again!");
            } else {
                return result;
            }
        }
    }

    public static String inputID(DocumentManagement documentManagement) {
        while (true) {
            String result = inputString();
            if (documentManagement.checkID(result)) return result;
            else {
                System.err.println("Id already exits");
            }
        }
    }

    public static String inputDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        while (true) {
            String result = inputString();
            try {
                simpleDateFormat.parse(result);
                return result;
            } catch (Exception e) {
                System.err.println("Date to correct format(dd/mm/yyyy)");
            }
        }
    }

    public static String inputMonth() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
        simpleDateFormat.setLenient(false);
        while (true) {
            String result = inputString();
            try {
                simpleDateFormat.parse(result);
                return result;
            } catch (Exception e) {
                System.err.println("Date to correct format(mm/yyyy)");
            }
        }
    }


    public static int inputPositiveNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine());
                if (result <= 0) {
                    System.out.println("Please enter a positive number. Enter again!");
                } else return result;
            } catch (NumberFormatException e) {
                System.err.println("Invalid number. Enter again!");
            }
        }
    }

    public static int inputLimit(int min, int max) {
        while (true) {
            int result = inputPositiveNumber();
            if (result >= min && result <= max) {
                return result;
            } else {
                System.err.println("Please input a number in range " + min + ", " + max);
            }
        }
    }

}

