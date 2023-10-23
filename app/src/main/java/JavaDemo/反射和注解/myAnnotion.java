package JavaDemo.反射和注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD,METHOD})
@Inherited
public @interface myAnnotion {
    String name() default "";
    int age() default 18;
    String like();
    String IDCard() default "";
}
