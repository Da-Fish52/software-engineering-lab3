package horse;

import java.time.Year;

/**
 * 优良品质的马：A1-1 类图对应的 Java 实现。
 * 属性全部私有，操作公有；mother、father 为自关联。
 */
public class Thoroughbred {
    private Thoroughbred mother;
    private Thoroughbred father;
    private int birthYear;

    public Thoroughbred(int birthYear) {
        this.birthYear = birthYear;
    }

    public Thoroughbred(int birthYear, Thoroughbred mother, Thoroughbred father) {
        this.birthYear = birthYear;
        this.mother = mother;
        this.father = father;
    }

    public int getCurrentAge() {
        return Year.now().getValue() - birthYear;
    }

    public Thoroughbred getFather() {
        return father;
    }

    public Thoroughbred getMother() {
        return mother;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public static void main(String[] args) {
        Thoroughbred mother = new Thoroughbred(2015);
        Thoroughbred father = new Thoroughbred(2014);
        Thoroughbred foal = new Thoroughbred(2022, mother, father);
        System.out.println("小马年龄：" + foal.getCurrentAge() + " 岁");
        System.out.println("母马出生年份：" + foal.getMother().getBirthYear());
        System.out.println("父马出生年份：" + foal.getFather().getBirthYear());
    }
}
