package OOP1.BookManager;


import OOP1.bussiness.BookBussiness;
import OOP1.entity.Book;

import java.util.Scanner;

public class BookManager {
    public static final Book[] arrBook = new Book[100];
    public static int currentBookIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=====================MENU=====================");
            System.out.println("1. Nhập thông tin n sách (n nhập từ bàn phím)");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn từ 1 - 9: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    BookBussiness.addBook(scanner);
                    break;
                case 2:
                    BookBussiness.calculateAllInterests();
                    break;
                case 3:
                    BookBussiness.displayBook();
                    break;
                case 4:
                    BookBussiness.sortByExportPrice();
                    break;
                case 5:
                    BookBussiness.sortByInterest();
                    break;
                case 6:
                    BookBussiness.searchByName(scanner);
                    break;
                case 7:
                    BookBussiness.statisticalByYear();
                    break;
                case 8:
                    BookBussiness.statisticalByAuthor();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn lại từ 1 - 9");
            }
        }while (true);
    }
}