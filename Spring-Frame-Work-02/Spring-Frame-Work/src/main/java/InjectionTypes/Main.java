package InjectionTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class BussinessClass{

//    @Autowired            //Field Dependency Injection
//    Dependency1 d1;
//
//    @Autowired
//    Dependency2 d2;


    Dependency1 d1;
    Dependency2 d2;


    //Setter Dependency Injection

//    @Autowired
//    public void setD1(Dependency1 d1) {
//        this.d1 = d1;
//    }
//
//    @Autowired
//    public void setD2(Dependency2 d2) {
//        this.d2 = d2;
//    }

    @Autowired
    public BussinessClass(Dependency1 d1, Dependency2 d2) {
        System.out.println("C-tor DI");
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public String toString() {
        return "BussinessClass{" +
                "d1=" + d1 +
                ", d2=" + d2 +
                '}';
    }
}

@Component
class Dependency1{

}

@Component
class Dependency2{

}


@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Main.class);
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(BussinessClass.class));

    }
}
