package xhu.wncg.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * @author BZhao
 * @version 2017/10/24.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    String value() default "";
}
