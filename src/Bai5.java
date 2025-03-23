import java.util.HashSet;
import java.util.ArrayList;

public class Bai5 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        int[] arr1 = {1, 2, 3, 4, 5};
        for (int num : arr1) {
            set1.add(num);
        }

        int[] arr2 = {4, 5, 6, 7, 8};
        for (int num : arr2) {
            set2.add(num);
        }

        set1.addAll(set2);

        ArrayList<Integer> sort = new ArrayList<>(set1);
        for (int i = 0; i < sort.size() - 1; i++) {
            for (int j = i + 1; j < sort.size(); j++) {
                if (sort.get(i) > sort.get(j)) {
                    int temp = sort.get(i);
                    sort.set(i, sort.get(j));
                    sort.set(j, temp);
                }
            }
        }
        System.out.println("Danh sách sau khi hợp và sắp xếp: " + sort);
    }
}