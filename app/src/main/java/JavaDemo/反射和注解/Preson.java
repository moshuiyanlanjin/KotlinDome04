package JavaDemo.反射和注解;

public class Preson {
    private String name;
    private int age;
    public String daihao;

    public Preson() {
    }

    public Preson(String name, int age, String daihao) {
        this.name = name;
        this.age = age;
        this.daihao = daihao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDaihao() {
        return daihao;
    }

    public void setDaihao(String daihao) {
        this.daihao = daihao;
    }
}
