package OOP1.validate;


import OOP1.BookManager.BookManager;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BookValidate {
    public static String validateBookId(Scanner scanner, String message) {
        System.out.println(message);

        while (true) {
            String bookId = scanner.nextLine().trim();

            boolean isExist = false;
            for (int i = 0; i < BookManager.currentBookIndex; i++) {
                if (BookManager.arrBook[i].getBookId().equalsIgnoreCase(bookId)) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                return bookId;
            }

            System.err.println("Mã sách đã tồn tại, vui lòng nhập lại:");
        }
    }


    public static String validateBookName(Scanner scanner, String message, String regex, int indexUpdate) {
        System.out.println(message);

        while (true) {
            String inputBookName = scanner.nextLine().trim();

            if (!Pattern.matches(regex, inputBookName)) {
                System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại.");
                continue;
            }

            boolean isExist = false;
            for (int i = 0; i < BookManager.currentBookIndex; i++) {
                if (i != indexUpdate && BookManager.arrBook[i].getBookName().equalsIgnoreCase(inputBookName)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.err.println("Tên sách đã tồn tại, vui lòng nhập lại.");
            } else {
                return inputBookName;
            }
        }
    }
    public static float calculateInterest(float importPrice, float exportPrice) {
        return exportPrice - importPrice;
    }
}