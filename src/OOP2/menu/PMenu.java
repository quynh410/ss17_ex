package OOP2.menu;



import OOP2.bussiness.PBussiness;
import OOP2.entity.Product;

import java.util.Scanner;

public class PMenu {
    public static final Product[] arrProduct = new Product[100];
    public static int currentProductIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.println("Lựa chọn của bạn từ 1 - 10: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    PBussiness.addProduct(scanner);
                    break;
                case 2:
                    PBussiness.displayListProduct();
                    break;
                case 3:
                    PBussiness.calculateAllProfit();
                    break;
                case 4:
                    PBussiness.sortBookByProfit();
                    break;
                case 5:
                    PBussiness.statisticalProductByPrice(scanner);
                    break;
                case 6:
                    PBussiness.searchProductByName(scanner);
                    break;
                case 7:
                    PBussiness.importProduct(scanner);
                    break;
                case 8:
                    PBussiness.sellProduct(scanner);
                    break;
                case 9:
                    PBussiness.updateProductStatus(scanner);
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1 - 10");
            }
        } while (true);
    }
}