package bai3;

import support.InputMethods;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ByeMovieTicketQueue {
    public static void main(String[] args) {
        Queue<String> customerList = new LinkedList<>();

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập tên khách hàng chờ mua vé xem phim");
            System.out.println("2. Khách tiếp theo");
            System.out.println("3. Thoát");
            System.out.print("Mời bạn chọn: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên khách hàng: ");
                    String customerName = InputMethods.getString();
                    customerList.add(customerName);
                    System.out.println(customerName +"đang xếp hàng");
                    break;
                case 2:
                    if (customerList.isEmpty()) {
                        System.out.println("Không còn ai đang xếp hàng");
                    } else {
                        String nextCustomer = customerList.poll();
                        System.out.println("Khách hàng tiếp theo: " + nextCustomer);
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn sai");
            }
        }
    }
}
