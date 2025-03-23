package OOP2.validate;

import java.util.Scanner;

public class Validate {
    public static String validateInputString(Scanner scanner, String message) {
        System.out.print(message);
        do {
            String inputString = scanner.nextLine().trim();
            if (!inputString.isEmpty() && inputString.length() >= 3) {
                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ! Chuỗi không được rỗng và phải có ít nhất 3 ký tự. Vui lòng nhập lại: ");
        } while (true);
    }

    public static boolean validateInputBoolean(Scanner scanner, String message) {
        System.out.print(message);
        do {
            String inputString = scanner.nextLine().trim();
            if (inputString.equalsIgnoreCase("true") || inputString.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(inputString);
            }
            System.err.println("Kiểu dữ liệu không hợp lệ, vui lòng nhập lại (true/false): ");
        } while (true);
    }

    public static float validateInputFloat(Scanner scanner, String message, float minValue) {
        System.out.print(message);
        do {
            String input = scanner.nextLine().trim();
            try {
                float number = Float.parseFloat(input);
                if (number > minValue) {
                    return number;
                }
                System.err.printf("Giá trị phải lớn hơn %.2f, vui lòng nhập lại: ", minValue);
            } catch (NumberFormatException e) {
                System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại số thực: ");
            }
        } while (true);
    }

    public static int validateInputInt(Scanner scanner, String message, int minValue) {
        System.out.print(message);
        do {
            String input = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(input);
                if (number > minValue) {
                    return number;
                }
                System.err.printf("Giá trị phải lớn hơn %d, vui lòng nhập lại: ", minValue);
            } catch (NumberFormatException e) {
                System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại số nguyên: ");
            }
        } while (true);
    }
}
