package test;

public class Cuboid {
    double length; // 长
    double width;  // 宽
    double height; // 高

    public Cuboid(double length, double width, double height) {
        if (length > 0 && width > 0 && height > 0) {
            this.length = length;
            this.width = width;
            this.height = height;
        } else {
            System.out.println("长方体的长宽高必须都大于0");
            return;
        }
    }

    // 体积
    public double volume() {
        return length * width * height;
    }

    // 表面积
    public double surfaceArea() {
        return (length * width + length * height + width * height) * 2;
    }
}

class CuboidTest {

    public static void main(String[] args) {
        Cuboid c1 = new Cuboid(4, 7, 9);
        System.out.println(c1.volume());
        System.out.println(c1.surfaceArea());
        Cuboid c2 = new Cuboid(7, 4.5, 20);
        System.out.println(c2.volume());
        System.out.println(c2.surfaceArea());

    }
}
