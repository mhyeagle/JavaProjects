package classOverWrite;

public class ChildClass implements ParentClass {
    Integer num;

    public ChildClass(Integer num) {
        this.num = num;
    }

    @Override
    public Integer getNum() {
        return num;
    }
}
