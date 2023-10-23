package JavaDemo.反射和注解;

import android.app.Activity;

import java.lang.reflect.Field;

public class IntentTest {

    public IntentTest(Activity activity){
        Class<? extends Activity> aClass = activity.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
//            if(declaredField.isAnnotationPresent()){
//
//            }
        }
    }
}
