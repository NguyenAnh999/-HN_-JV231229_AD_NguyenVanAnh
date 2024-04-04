package bai2.ra;

import support.InputMethods;

import java.util.Stack;

public class BrowserHistoryStack {
    public static void main(String[] args) {
        Stack<String> urlList = new Stack<>();
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập URL muốn truy cập");
            System.out.println("2. Quay lại");
            System.out.println("3. Thoát");
            System.out.print("Mời bạn chọn: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    System.out.print("Nhập URL muốn truy cập: ");
                    String url = InputMethods.getString();
                    urlList.push(url);
                    System.out.println("bạn đang ở trang "+url);
                    break;
                case 2:
                    if (urlList.isEmpty()) {
                        System.out.println("Lịch sử rỗng");
                    } else {
                        urlList.pop();
                        if (urlList.isEmpty()) {
                            System.out.println("Lịch sử rỗng");
                        } else {
                            System.out.println("bạn đã trở về trang: " + urlList.peek());
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn sai.");
            }
        }
    }
}
