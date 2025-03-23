import java.util.HashSet;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        HashSet<String> IT = new HashSet<>();
        IT.add("Java");
        IT.add("Python");
        IT.add("JavaScript");
        IT.add("C++");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập một chuỗi từ bàn phím và kiểm tra xem chuỗi đó có tồn tại trong HashSet hay không");
        String  input = scanner.nextLine();
        if (IT.contains(input)) {
            System.out.println("Ngôn ngữ '" + input + "' có trong HashSet.");
        } else {
            System.out.println("Ngôn ngữ '" + input + "' không có trong HashSet.");
        }
    }
}
