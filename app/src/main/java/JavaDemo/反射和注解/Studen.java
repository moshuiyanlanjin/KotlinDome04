package JavaDemo.反射和注解;

public class Studen extends Preson{

    private int bianhao;

    public String banji;

    public Studen() {
    }

    public Studen(int bianhao, String banji) {
        this.bianhao = bianhao;
        this.banji = banji;
    }

    @myAnnotion(like = "ss")
    public void jiang(){

    }

    public int getBianhao() {
        return bianhao;
    }

    public void setBianhao(int bianhao) {
        this.bianhao = bianhao;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }
}
