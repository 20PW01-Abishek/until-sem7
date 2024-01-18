public class MySingleton {
    private static MySingleton obj;
    private MySingleton() {
        System.out.println("Object created!");
    }
    private MySingleton(MySingleton obj){
        MySingleton.obj = obj;
    }

    public static MySingleton getInstance() {
        MySingleton reference = obj;
        if (reference == null){
            synchronized (MySingleton.class) {
                reference = obj;
                if (reference == null)
                    obj = reference = new MySingleton();
            }
        }
        return reference;
    }
}
