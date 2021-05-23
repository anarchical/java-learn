package test;

public class Book {

    String title;
    int pageNum;
    String type;

    public Book(String title, int pageNum) {
        this.type = "计算机";
        this.title = title;
        if (pageNum < 200) {
            System.out.println("不能少于200页");
            this.pageNum = 200;
        } else {
            this.pageNum = pageNum;
        }
    }

    public Book(String title, int pageNum, String type) {
        this.type = type;
        this.title = title;
        if (pageNum < 200) {
            System.out.println("不能少于200页");
            this.pageNum = 200;
        } else {
            this.pageNum = pageNum;
        }
    }

    public void detail() {
        System.out.println("名称:" + title + ",页数:" + pageNum + ",类型:" + type);
    }
}

class BookTest {

    public static void main(String[] args) {
        Book book1 = new Book("java面向对象程序设计", 485);
        book1.detail();
        Book book2 = new Book("我的大学", 666, "小说");
        book2.detail();
    }
}
