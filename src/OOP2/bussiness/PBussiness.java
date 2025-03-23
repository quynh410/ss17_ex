package OOP2.bussiness;

import OOP2.entity.Product;
import OOP2.menu.PMenu;
import OOP2.validate.Validate;

import java.util.Scanner;

public class PBussiness {
    public static void addProduct(Scanner scanner) {
        System.out.println("Nhập số sản phẩm cần nhập thông tin: ");
        int numberOfProduct = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfProduct; i++) {
            PMenu.arrProduct[PMenu.currentProductIndex] = new Product();
            PMenu.arrProduct[PMenu.currentProductIndex].inputData(scanner);
            PMenu.currentProductIndex++;
        }
    }

    public static void displayListProduct() {
        if (PMenu.currentProductIndex == 0) {
            System.err.println("Chưa có sản phẩm");
            return;
        }

        for (int i = 0; i < PMenu.currentProductIndex; i++) {
            PMenu.arrProduct[i].displayData();
        }
    }

    public static void calculateAllProfit() {
        if (PMenu.currentProductIndex == 0){
            System.out.println("Danh sách sản phẩm trống");
            return;
        }
        for (int i = 0; i < PMenu.currentProductIndex; i++) {
            PMenu.arrProduct[i].calProfit();
            PMenu.arrProduct[i].displayData();
        }
    }

    public static void sortBookByProfit() {
        for (int i = 0; i < PMenu.currentProductIndex - 1; i++) {
            for (int j = 0; j < PMenu.currentProductIndex - i - 1; j++) {
                if (PMenu.arrProduct[j].getProfit() < PMenu.arrProduct[j + 1].getProfit()) {
                    Product temp = PMenu.arrProduct[j];
                    PMenu.arrProduct[j] = PMenu.arrProduct[j + 1];
                    PMenu.arrProduct[j + 1] = temp;
                }
            }
        }
        System.out.println("Danh sách sản phẩm sau khi được sắp xếp theo lợi nhuận giảm dần: ");
        for (int i = 0; i < PMenu.currentProductIndex; i++) {
            PMenu.arrProduct[i].displayData();
        }
    }

    public static void statisticalProductByPrice(Scanner scanner) {
        System.out.print("Nhập vào giá thấp nhất: ");
        float fromPrice = Validate.validateInputFloat(scanner, "Nhập vào giá thấp nhất: ", 0);

        System.out.print("Nhập vào giá cao nhất: ");
        float toPrice = Validate.validateInputFloat(scanner, "Nhập vào giá cao nhất: ", fromPrice);

        int count = 0;
        System.out.println("Danh sách sản phẩm trong khoảng giá từ " + fromPrice + " đến " + toPrice + ":");
        for (int i = 0; i < PMenu.currentProductIndex; i++) {
            Product product = PMenu.arrProduct[i];
            if (product.getExportPrice() >= fromPrice && product.getExportPrice() <= toPrice) {
                count++;
                System.out.printf("Mã sản phẩm: %s - Giá bán: %.2f\n", product.getProductId(), product.getExportPrice());
            }
        }

        System.out.println("Số lượng sản phẩm trong khoảng giá: " + count);
    }

    public static void searchProductByName(Scanner scanner) {
        System.out.print("Nhập vào tên sản phẩm cần tìm: ");
        String productName = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < PMenu.currentProductIndex; i++) {
            if (PMenu.arrProduct[i].getProductName().toLowerCase().contains(productName.toLowerCase())) {
                PMenu.arrProduct[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.err.println("Không tìm thấy sản phẩm nào có tên chứa: " + productName);
        }
    }

    public static void importProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        String productId = scanner.nextLine().trim();

        for (int i = 0; i < PMenu.currentProductIndex; i++) {
            if (PMenu.arrProduct[i].getProductId().equalsIgnoreCase(productId)) {
                System.out.print("Nhập số lượng cần nhập: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                if (quantity > 0) {
                    PMenu.arrProduct[i].setQuantity(PMenu.arrProduct[i].getQuantity() + quantity);
                    System.out.println("Số lượng mới: " + PMenu.arrProduct[i].getQuantity());
                } else {
                    System.err.println("Số lượng phải lớn hơn 0!");
                }
                return;
            }
        }
        System.err.println("Không tìm thấy sản phẩm!");
    }

    public static void sellProduct(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần bán: ");
        String productName = scanner.nextLine().trim();

        for (int i = 0; i < PMenu.currentProductIndex; i++) {
            if (PMenu.arrProduct[i].getProductName().equalsIgnoreCase(productName)) {
                System.out.print("Nhập số lượng cần bán: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                if (quantity > 0 && quantity <= PMenu.arrProduct[i].getQuantity()) {
                    PMenu.arrProduct[i].setQuantity(PMenu.arrProduct[i].getQuantity() - quantity);
                    System.out.println("Bán hàng thành công! Số lượng còn lại: " + PMenu.arrProduct[i].getQuantity());
                } else {
                    System.err.println("Số lượng không hợp lệ hoặc không đủ hàng!");
                }
                return;
            }
        }
        System.err.println("Không tìm thấy sản phẩm!");
    }

    public static void updateProductStatus(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
        String productId = scanner.nextLine();

        for (int i = 0; i < PMenu.currentProductIndex; i++) {
            if (PMenu.arrProduct[i].getProductId().equalsIgnoreCase(productId)) {
                PMenu.arrProduct[i].setStatus(!PMenu.arrProduct[i].isStatus());

                System.out.println("Trạng thái mới: " +
                        (PMenu.arrProduct[i].isStatus() ? "Đang bán" : "Không bán"));
                return;
            }
        }

        System.err.println("Không tìm thấy sản phẩm có mã: " + productId);
    }
}
