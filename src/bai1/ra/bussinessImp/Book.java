package bai1.ra.bussinessImp;

import bai1.ra.bussiness.IShop;
import bai1.ra.run.BookManagement;
import support.InputMethods;

import static bai1.ra.run.BookManagement.authorList;

public class Book implements IShop, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;

    // Constructors
    public Book() {
        // Default constructor
    }

    public Book(int bookId, String bookName, String title, int numberOfPages,
                Author author, float importPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = calculateExportPrice();
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    private float calculateExportPrice() {
        return this.importPrice * RATE;
    }

    @Override
    public void inputData() {
        System.out.print("Mời bạn nhập ID: ");
        this.bookId = InputMethods.getInteger();
        System.out.print("Mời bạn nhập tên: ");
        this.bookName = InputMethods.getString();
        System.out.print("Mời bạn nhập tiêu đề: ");
        this.title = InputMethods.getString();
        System.out.print("Mời bạn nhập số trang sách: ");
        this.numberOfPages = InputMethods.getInteger();
        System.out.print("Mời bạn nhập giá: ");
        this.importPrice = InputMethods.getFloat();
        System.out.println("Moi bạn nhập số lượng sách");
        this.quantity=InputMethods.getInteger();
        this.author=choiceAuthor();
        this.exportPrice = calculateExportPrice();
    }

    public Author choiceAuthor() {
        if (authorList.isEmpty()) {
            System.out.println("bạn chưa có tác giả nào");
            System.out.println("1: tạo tác giả mới");
            System.out.println("2: Để = null");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    BookManagement.addAuthorInlist();
                  return  choiceAuthorInList();
                case 2:
                    return null;
                default:
                    System.out.println("lựa chọn sai");
                    break;
            }
        }
          return  choiceAuthorInList();
    }
public Author choiceAuthorInList(){
    for (int i = 0; i < authorList.size(); i++) {
        System.out.println("Tác giả thứ "+(i+1));
        authorList.get(i).displayData();
    }
    System.out.println("mời bạn chọn tác giả theo số thứ tự");
    do {
        byte choiceAuthorNumber = InputMethods.getByte();
        if (choiceAuthorNumber>authorList.size()||choiceAuthorNumber<=0){
            System.out.println("lựa chọn sai mời chọn lại");
        }else {
            return authorList.get(choiceAuthorNumber-1);
        }
    }while (true);
}
    public void displayData() {
        System.out.print("ID: " + this.bookId);
        System.out.print(" | Tên sách: " + this.bookName);
        System.out.print(" | Tiêu đề: " + this.title);
        System.out.print(" | Tác giả: " + this.author.getAuthorName());
        System.out.print(" | giá : " + this.exportPrice);
        System.out.print(" | số lượng: " + this.quantity);
        System.out.println(" | trạng thái: " + (this.bookStatus?"bán":"không bán"));
    }

    @Override
    public int compareTo(Book o) {
        return Float.compare(this.exportPrice, o.importPrice);
    }
}
