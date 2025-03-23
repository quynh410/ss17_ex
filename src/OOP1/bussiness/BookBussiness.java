package OOP1.bussiness;

import OOP1.BookManager.BookManager;
import OOP1.entity.Book;

import java.util.Scanner;

public class BookBussiness {
    public static void addBook(Scanner scanner) {
        System.out.println("Nhập số lượng sách cần nhập thông tin: ");
        int numberOfBook = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfBook; i++) {
            BookManager.arrBook[BookManager.currentBookIndex] = new Book();
            BookManager.arrBook[BookManager.currentBookIndex].inputData(scanner);
            BookManager.currentBookIndex++;
        }
    }

    public static void calculateAllInterests() {
        if (BookManager.currentBookIndex == 0){
            System.out.println("Danh sách sách trống");
            return;
        }
        for (int i = 0; i < BookManager.currentBookIndex; i++) {
            BookManager.arrBook[i].calculateInterest();
            BookManager.arrBook[i].displayData();
        }
    }

    public static void displayBook() {
        if (BookManager.currentBookIndex == 0) {
            System.out.println("Chưa có sách");
            return;
        }
        for (int i = 0; i < BookManager.currentBookIndex; i++) {
            BookManager.arrBook[i].displayData();
        }
    }

    public static void sortByExportPrice() {
        for (int i = 0; i < BookManager.currentBookIndex - 1; i++) {
            for (int j = 0; j < BookManager.currentBookIndex - i - 1; j++) {
                if (BookManager.arrBook[j].getExportPrice() > BookManager.arrBook[j + 1].getExportPrice()) {
                    Book temp =  BookManager.arrBook[j];
                    BookManager.arrBook[j] = BookManager.arrBook[j + 1];
                    BookManager.arrBook[j + 1] = temp;
                }
            }
        }
        System.out.println("Danh sách sách sau khi được sắp xếp theo giá bán tăng dần: ");
        for (int i = 0; i < BookManager.currentBookIndex; i++) {
            BookManager.arrBook[i].displayData();
        }
    }

    public static void sortByInterest() {
        for (int i = 0; i < BookManager.currentBookIndex - 1; i++) {
            for (int j = 0; j < BookManager.currentBookIndex - i - 1; j++) {
                if (BookManager.arrBook[j].getInterest() < BookManager.arrBook[j + 1].getInterest()) {
                    Book temp =  BookManager.arrBook[j];
                    BookManager.arrBook[j] = BookManager.arrBook[j + 1];
                    BookManager.arrBook[j + 1] = temp;
                }
            }
        }
        System.out.println("Danh sách sách sau khi được sắp xếp theo lợi nhuận giảm dần: ");
        for (int i = 0; i < BookManager.currentBookIndex; i++) {
            BookManager.arrBook[i].displayData();
        }

    }

    public static void searchByName(Scanner scanner) {
        System.out.println("Nhập vào tên sách cần tìm: ");
        String bookName = scanner.nextLine();
        for (int i = 0; i < BookManager.currentBookIndex; i++) {
            if (BookManager.arrBook[i].getBookName().toLowerCase().contains(bookName.toLowerCase().trim())) {
                BookManager.arrBook[i].displayData();
            }
        }
    }

    public static void statisticalByYear() {
        for (int i = 0; i < BookManager.currentBookIndex; i++) {
            int year = BookManager.arrBook[i].getYear();
            int count = 0;
            boolean isPrinted = false;
            for (int j = 0; j < i; j++) {
                if (BookManager.arrBook[j].getYear() == year) {
                    isPrinted = true;
                    break;
                }
            }

            if (!isPrinted) {
                for (int k = 0; k < BookManager.currentBookIndex; k++) {
                    if (BookManager.arrBook[k].getYear() == year) {
                        count++;
                    }
                }
                System.out.println("Năm xuất bản " + year + " - Số lượng: " + count);
            }
        }
    }

    public static void statisticalByAuthor() {
        for (int i = 0; i < BookManager.currentBookIndex; i++) {
            String author = BookManager.arrBook[i].getAuthor();
            int count = 0;
            boolean isPrinted = false;
            for (int j = 0; j < i; j++) {
                if (BookManager.arrBook[j].getAuthor().equals(author)) {
                    isPrinted = true;
                    break;
                }
            }

            if (!isPrinted) {
                for (int k = 0; k < BookManager.currentBookIndex; k++) {
                    if (BookManager.arrBook[k].getAuthor().equals(author)) {
                        count++;
                    }
                }
                System.out.println("Tác giả: " + author + " - Số lượng: " + count);
            }
        }
    }
}