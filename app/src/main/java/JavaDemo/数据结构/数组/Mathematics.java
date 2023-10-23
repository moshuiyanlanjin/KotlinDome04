package JavaDemo.数据结构.数组;

public class Mathematics {
    private String name;

    private String effect;

    public Mathematics(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "Mathematics{" +
                "name='" + name + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Array<Mathematics> ma = new Array<>(20);
        ma.add(0,new Mathematics("数学","运算"));
        ma.add(1,new Mathematics("加","运算"));
        ma.add(2,new Mathematics("减","运算"));

        for (int i = 0; i < ma.getSize(); i++) {
            System.out.println(ma.get(i));
        }

    }
}
