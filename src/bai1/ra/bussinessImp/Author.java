package bai1.ra.bussinessImp;

import bai1.ra.bussiness.IShop;
import support.InputMethods;

import java.awt.im.spi.InputMethod;

public class Author implements IShop {
    private int authorId;
    private String authorName;
    private boolean sex;
    private int year;

    public Author() {
    }

    public Author(int authorId, String authorName, boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public void inputData() {
        System.out.print("Mởi bạn nhập ID: ");
        this.authorId = InputMethods.getInteger();
        System.out.print("Mởi bạn nhập tên: ");
        this.authorName = InputMethods.getString();
        System.out.print("Mởi bạn nhập giới tính (true = nam, false =nữ): ");
        this.sex = InputMethods.getBoolean();
        System.out.print("Mởi bạn nhập năm sinh: ");
        this.year = InputMethods.getInteger();
    }
    public void displayData() {
        System.out.print(" | MÃ: " + this.authorId);
        System.out.println(" | Tên: " + this.authorName);
    }

}
