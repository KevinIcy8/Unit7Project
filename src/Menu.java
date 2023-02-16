public class Menu {
    public static void main(String[] args) {
        Address mine = new Address("1024", "71th Street", "2", "Brooklyn", "NY", 11228);
        Address copy = new Address(mine);
        Address full = new Address("1313 Mockingbird Lane Apt 6A, Springfield, MO 65123");

        System.out.println(mine);
        System.out.println(copy);
        System.out.println(full);
    }
}

