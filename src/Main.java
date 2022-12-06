public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero(1, "Vasif", 100, 30, 20, 1000, 300);
        Hero h2 = new Hero(2, "Di", 50, 50, 100, 700, 700);
        Hero h3 = new Hero(3, "Lom", 70, 70, 70, 800, 500);

        System.out.println(h2.HP);
        h1.hit(h2);
        System.out.println(h2.HP);
    }
}