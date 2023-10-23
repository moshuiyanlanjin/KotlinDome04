package JavaDemo.反射和注解;

import androidx.annotation.IntDef;

import java.io.FileInputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Properties;

public class AnnoTionMain {


    @work
    private static int ws ;

    private static final int SUNDAY = 0;
    private static final int MONDAY = 1;

    @IntDef({SUNDAY,MONDAY})
    @Target({ElementType.FIELD,ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface work{

    }

    private static void setvs(@work int w){
        ws = w;
    };
    public static void main(String[] args) {

        //startName();
        setvs(SUNDAY);

    }

    @myAnnotion(name = "张三",like = "非")
    private static void startName() {
        System.out.println();
    }


}
