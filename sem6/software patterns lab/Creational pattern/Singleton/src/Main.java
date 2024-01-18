public class Main {
    public static void main(String[] args) {
        MySingleton object = MySingleton.getInstance();
        System.out.println(object);
        MySingleton object2 = MySingleton.getInstance();
//        MySingleton object2 = new MySingleton();
        System.out.println(object2);
//        MySingleton object3 = new MySingleton(object);
//        System.out.println(object3);
    }
}
