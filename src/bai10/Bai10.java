package bai10;

import java.util.Scanner;

public class Bai10 {
    public class Main {
        public static void main(String[] args) {
            Manager manager = new Manager();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nQuản lý danh bạ:");
                System.out.println("1. Thêm liên hệ");
                System.out.println("2. Xóa liên hệ");
                System.out.println("3. Tìm kiếm liên hệ");
                System.out.println("4. Hiển thị danh bạ");
                System.out.println("5. Thoát");
                System.out.print("Chọn một tùy chọn: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập số điện thoại: ");
                        String phone = scanner.nextLine();
                        manager.addContact(name, phone);
                        break;
                    case 2:
                        System.out.print("Nhập số điện thoại cần xóa: ");
                        String removePhone = scanner.nextLine();
                        if (manager.removeContact(removePhone)) {
                            System.out.println("Đã xóa liên hệ.");
                        } else {
                            System.out.println("Không tìm thấy liên hệ.");
                        }
                        break;
                    case 3:
                        System.out.print("Nhập số điện thoại cần tìm: ");
                        String searchPhone = scanner.nextLine();
                        Contact found = manager.findContact(searchPhone);
                        System.out.println(found != null ? found : "Không tìm thấy liên hệ.");
                        break;
                    case 4:
                        manager.displayContacts();
                        break;
                    case 5:
                        System.out.println("Đang thoát...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            }
        }
    }
}
