package classOverWrite;

public class ClassMain {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass(10);

        ParentClass parent = childClass;

        System.out.println("num:" + parent.getNum());
    }
}
