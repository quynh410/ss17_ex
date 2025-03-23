import java.util.*;

public class Bai8 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 5, 6, 7, 8, 9};
        int k = 10;

        Set<List<Integer>> pairs = new HashSet<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    List<Integer> pair = Arrays.asList(Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j]));
                    pairs.add(pair);
                }
            }
        }

        List<List<Integer>> sortedPairs = new ArrayList<>(pairs);
        sortedPairs.sort(Comparator.comparingInt(a -> a.get(0)));

        System.out.println("Các cặp số có tổng bằng " + k + " là:");
        for (List<Integer> pair : sortedPairs) {
            System.out.println(pair.get(0) + ", " + pair.get(1));
        }
    }
}
