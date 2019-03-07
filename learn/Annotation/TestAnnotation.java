package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;


// 注解的属性也叫成员变量，无方法。
// 注解的属性以“无形参的方法”的形式来声明
// 方法名定义了该成员变量的名字，返回类型为成员变量的类型

@Target(ElementType.TYPE)
// 运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    int id();        // 定义一个属性名为id 的int变量

    String msg();    // 定义一个属性名为msg 的String变量

    double price() default 2.0f;   //定义一个默认值为2.0名为price的Double变量
}

// 使用,括号内给变量赋值
// 赋值的方式是在注解的括号内以 value="" 形式，多个属性之前用 ，隔开。
// 注解中属性可以有默认值，默认值需要用 default 关键字指定；有默认值在使用时就无需进行赋值
// 注解中定义属性时它的类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组。
@TestAnnotation(id = 1, msg = "wdl")
class Test {

}




@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@interface TextAnnotation{
    int value();
}

// 当注解中只有一个value属性时，在使用时可以直接在括号里加上值，无需value=""
//  @TextAnnotation(value = 2)
@TextAnnotation(2)
class Text {

}


// 注解没有任何属性时，使用 括号也可以省略
@Retention(RetentionPolicy.CLASS)
@interface Perform{

}


@Perform
class Per{

}



// @Deprecated 标记过时
class A{
    @Deprecated
    public void say(){
        System.out.println("say....say");
    }

    public void hand(){
        System.out.println("hand....hand");
    }
}


class Main{
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        A a = new A();
        a.say();
        a.hand();
        //m(Arrays.asList("a"),Arrays.asList("b"),Arrays.asList("c"));

        boolean isAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
        if (isAnnotation){
            TestAnnotation textAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            System.out.println(textAnnotation.id());
            System.out.println(textAnnotation.msg());
            System.out.println(textAnnotation.price());
        }
    }

    @SafeVarargs
    static void m(List<String>...lists){
        Object[] array = lists;
        List<Integer> temp = Arrays.asList(42);
        array[0] = temp;
        String s = lists[0].get(0);
    }
}



