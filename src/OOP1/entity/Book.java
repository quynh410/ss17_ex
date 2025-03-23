package OOP1.entity;

import ra.validate.BookValidator;
import ra.validate.StringRule;
import ra.validate.Validator;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void calculateInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }

    public void inputData(Scanner scanner) {
        this.bookId = inputBookId(scanner);
        this.bookName = inputBookName(scanner);
        this.importPrice = Validator.validateInputFloat(scanner, "Nhập vào giá nhập của sách: ", 0);
        this.exportPrice = Validator.validateInputFloat(scanner, "Nhập vào giá xuất của sách: ", this.importPrice * 1.3f);
        this.author = Validator.validateInputString(scanner, "Nhập vào tên tác giả: ", new StringRule(6, 50));
        this.interest = BookValidator.calculateInterest(this.importPrice, this.exportPrice);
        this.year = Validator.validateInputInt(scanner, "Nhập vào năm xuất bản", 2000);

    }

    public String inputBookId(Scanner scanner) {
        return BookValidator.validateBookId(scanner, "Nhập vào mã sách: ");
    }

    public String inputBookName(Scanner scanner) {
        return BookValidator.validateBookName(scanner, "Nhập vào tên sách: ", "[B]\\w{3}", -1);
    }

    public void displayData() {
        System.out.printf("Mã sách: %s - Tên sách: %s - Giá nhập của sách: %.2f - Giá xuất của sách: %.2f\n",
                this.bookName, this.bookId, this.importPrice, this.exportPrice);
        System.out.printf("Tác giả: %s - Lợi nhuận của sách: %.2f - Năm xuất bản: %d\n",
                this.author, this.interest, this.year);
        System.out.println("-----------------------------------------------------");
    }

}