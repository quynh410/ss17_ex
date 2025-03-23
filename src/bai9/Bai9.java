package bai9;



import java.util.*;

public class Bai9 {
    private Set<Book> books;

    public Bai9() {
        this.books = new HashSet<>();
    }

    public void addBook(Book book) {
        if (books.add(book)) {
            System.out.println("Đã thêm sách: " + book);
        } else {
            System.out.println("Sách có ID trùng lặp, không thể thêm: " + book.getId());
        }
    }

    public List<Book> filterBooksByYear(int year) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > year) {
                filteredBooks.add(book);
            }
        }
        filteredBooks.sort(Comparator.comparing(Book::getTitle));
        return filteredBooks;
    }

    public void displayBooks(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Bai9 library = new Bai9();
        library.addBook(new Book("001", "Dế Mèn", "Tố Hiwxi", 2015));
        library.addBook(new Book("002", "Tắt Điện", "Ngô Tất Tố", 2020));


        int filterYear = 2017;
        List<Book> filteredBooks = library.filterBooksByYear(filterYear);

        System.out.println("Danh sách sách xuất bản sau năm " + filterYear + " (sắp xếp theo tên):");
        library.displayBooks(filteredBooks);
    }
}
