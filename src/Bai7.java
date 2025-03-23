import java.util.*;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập một đoạn văn bản:");
        String text = scanner.nextLine();
        scanner.close();

        String[] words = text.toLowerCase().split("\\W+");

        Set<String> uniqueWords = new TreeSet<>(Arrays.asList(words));

        System.out.println("Danh sách các từ không trùng lặp:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }
}
