package OOP2.validate;

import OOP2.menu.PMenu;


import java.util.Scanner;

public class PValidate {
    public static String validateProductId(Scanner scanner, String message, int valueLength) {
        System.out.println(message);

        while (true) {
            String productId = scanner.nextLine().trim();

            if (productId.isEmpty()) {
                System.err.println("Mã sản phẩm không được để trống, vui lòng nhập lại!");
                continue;
            }

            if (productId.length() != valueLength) {
                System.err.println("Mã sản phẩm phải có đúng " + valueLength + " ký tự, vui lòng nhập lại!");
                continue;
            }

            boolean isExist = false;
            if (PMenu.currentProductIndex > 0) {
                for (int i = 0; i < PMenu.currentProductIndex; i++) {
                    if (PMenu.arrProduct[i].getProductId().equalsIgnoreCase(productId)) {
                        isExist = true;
                        break;
                    }
                }
            }

            if (!isExist) {
                return productId;
            }

            System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại!");
        }
    }

    public static String validateProductName(Scanner scanner, String productName, int indexUpdate) {
        do {
            boolean isExist = false;
            for (int i = 0; i < PMenu.currentProductIndex; i++) {
                if (PMenu.arrProduct[i].getProductName().equals(productName) && i != indexUpdate) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                return productName;
            }
            System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
            productName = scanner.nextLine();
        } while (true);
    }
}