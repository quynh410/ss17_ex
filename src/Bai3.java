import java.util.HashSet;

public class Bai3 {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        HashSet<Integer> toRemove = new HashSet<>();
        for (int num : numbers) {
            if (num % 2 == 0) {
                toRemove.add(num);
            }
        }

        numbers.removeAll(toRemove);

        System.out.println("HashSet sau khi xóa các số chẵn: " + numbers);
    }
}
