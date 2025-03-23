import java.util.HashSet;

public class Bai6 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        int[] arr1 = {10, 20, 30, 40, 50};
        for (int num : arr1) {
            set1.add(num);
        }

        int[] arr2 = {40, 50, 60, 70, 80};
        for (int num : arr2) {
            set2.add(num);
        }

        set1.addAll(set2);

    }
}
