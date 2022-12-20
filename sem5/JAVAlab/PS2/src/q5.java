
public class q5 {
     static class stu {
        int id;
        String Name;
    }

    class dummy {
         String name;
    }

    public static void main(String[] args) {
        stu s1 = new stu();
        q5 obj1 = new q5();
        dummy obj2 = obj1.new dummy();
        s1.id=1;
        s1.Name="Abi";
        System.out.println("s1 id: "+s1.id+" Name: "+s1.Name);


    }
}
