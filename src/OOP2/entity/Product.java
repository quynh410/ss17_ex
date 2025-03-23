package OOP2.entity;

import OOP2.validate.PValidate;
import OOP2.validate.Validate;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    // Getter và Setter
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public float getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }

    public float getExportPrice() { return exportPrice; }
    public void setExportPrice(float exportPrice) { this.exportPrice = exportPrice; }

    public float getProfit() { return profit; }
    public void setProfit(float profit) { this.profit = profit; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDescriptions() { return descriptions; }
    public void setDescriptions(String descriptions) { this.descriptions = descriptions; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    // Tính lợi nhuận
    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice;
    }

    // Nhập dữ liệu cho sản phẩm
    public void inputData(Scanner scanner) {
        this.productId = inputProductId(scanner);
        this.productName = inputProductName(scanner);
        this.importPrice = Validate.validateInputFloat(scanner, "Nhập vào giá nhập của sản phẩm: ", 0);
        this.exportPrice = Validate.validateInputFloat(scanner, "Nhập vào giá xuất của sản phẩm: ", this.importPrice * 1.2f);
        this.quantity = Validate.validateInputInt(scanner, "Nhập vào số lượng sản phẩm: ", 0);
        this.status = Validate.validateInputBoolean(scanner, "Nhập vào trạng thái của sản phẩm (true/false): ");
    }

    // Nhập mã sản phẩm
    public String inputProductId(Scanner scanner) {
        return PValidate.validateProductId(scanner, "Nhập vào mã sản phẩm: ", 4);
    }

    // Nhập tên sản phẩm (Loại bỏ StringRule, kiểm tra trực tiếp)
    public String inputProductName(Scanner scanner) {
        String productName;
        do {
            productName = Validate.validateInputString(scanner, "Nhập vào tên sản phẩm: ");
            if (productName.length() >= 6 && productName.length() <= 50) {
                break;
            }
            System.err.println("Tên sản phẩm phải có từ 6 đến 50 ký tự. Vui lòng nhập lại!");
        } while (true);
        return PValidate.validateProductName(scanner, productName, -1);
    }

    // Hiển thị thông tin sản phẩm
    public void displayData() {
        System.out.println("\n========= THÔNG TIN SẢN PHẨM =========");
        System.out.printf("Mã sản phẩm: %s\n", this.productId);
        System.out.printf("Tên sản phẩm: %s\n", this.productName);
        System.out.printf("Giá nhập: %.2f\n", this.importPrice);
        System.out.printf("Giá xuất: %.2f\n", this.exportPrice);
        System.out.printf("Lợi nhuận: %.2f\n", this.profit);
        System.out.printf("Số lượng: %d\n", this.quantity);
        System.out.printf("Mô tả: %s\n", this.descriptions);
        System.out.printf("Trạng thái: %s\n", this.status ? "Đang bán" : "Không bán");
        System.out.println("=======================================");
    }
}
