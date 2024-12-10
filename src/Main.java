import Vectors.entity.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Vector v1 = new Vector(new double[]{1, 2, 3});
        Vector v2 = new Vector(new double[]{4, 5, 6});
        System.out.println(v1.add(v2));

    }
}