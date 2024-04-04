package bai1.ra.run;

import bai1.ra.bussinessImp.Author;
import bai1.ra.bussinessImp.Book;
import support.InputMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManagement {
    public static List<Author> authorList = new ArrayList<>();
    public static List<Book> bookList = new ArrayList<>();

    static {
        authorList.add(new Author(0, "nguyễn du", true, 1765));
        authorList.add(new Author(1, "nguyễn dương", true, 1765));
        authorList.add(new Author(2, "nguyễn for", true, 1765));
        authorList.add(new Author(3, "nguyễn if", true, 1765));
        authorList.add(new Author(4, "nguyễn Stream", true, 1765));

        bookList.add(new Book(0, "truyện kiều", "tiêu đề", 300
                , authorList.get(0)
                , 123, 12, true));

        bookList.add(new Book(1, "truyện kiều", "tiêu đề", 300
                , authorList.get(0), 143, 12, true));

        bookList.add(new Book(2, "truyện kiều", "tiêu đề", 300
                , authorList.get(0), 423, 12, true));

        bookList.add(new Book(3, "truyện kiều", "tiêu đề", 300
                , authorList.get(0), 923, 12, true));

        bookList.add(new Book(4, "truyện kiều", "tiêu đề", 300
                , authorList.get(0), 623, 12, true));

        bookList.add(new Book(5, "truyện kiều", "tiêu đề", 300
                , authorList.get(0), 1263, 12, true));

        bookList.add(new Book(6, "truyện kiều", "tiêu đề", 300
                , authorList.get(0), 12773, 12, true));

    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU*************** \n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả    \n" +
                    "2. Nhập số sách và nhập thông tin các sách     \n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator) \n" +
                    "4. Tìm kiếm sách theo tên tác giả sách      \n" +
                    "5. Thoát   ");
            System.out.print("mời bạn chọn: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    addAuthorInlist();
                    break;
                case 2:
                    addBookInlist();
                    break;
                case 3:
                    sortByExportPrice();
                    break;
                case 4:
                    searchByNameAuthor();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("lựa chọn sai");
                    break;
            }
        }
    }

    public static void addAuthorInlist() {
        System.out.println("Mời bạn nhập vào số tác giả muốn thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 0; i < quantity; i++) {
            Author author = new Author();
            author.inputData();
            authorList.add(author);
        }
        System.out.println("thêm thành công");

    }

    public static void addBookInlist() {
        System.out.println("Mời bạn nhập vào số sản sách thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 0; i < quantity; i++) {
            Book book = new Book();
            book.inputData();
            bookList.add(book);
        }
        bookList.forEach(Book::displayData);
        System.out.println("thêm thành công");
    }

    public static void sortByExportPrice() {
        Collections.sort(bookList);
        System.out.println("sắp xếp thành công");
        bookList.forEach(Book::displayData);
    }

    public static void searchByNameAuthor() {
        while (true) {
            System.out.println("mời bạn nhập tên tác giả");
            String authorName = InputMethods.getString();
            if (bookList.stream().anyMatch(book -> book.getAuthor().getAuthorName().contains(authorName))) {
                bookList.stream()
                        .filter(book -> book.getAuthor().getAuthorName().contains(authorName))
                        .forEach(Book::displayData);
                break;
            } else {
                System.out.println("Tác giả bạn nhập không tồn tại hoặc chưa có sách \n Mời chọn lại");
            }
        }

    }

}
