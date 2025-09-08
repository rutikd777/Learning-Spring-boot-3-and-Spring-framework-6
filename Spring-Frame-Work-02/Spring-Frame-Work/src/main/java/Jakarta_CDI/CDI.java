package Jakarta_CDI;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


//@Component
@Named
class BusinessClass{
    private DataService d1;

//    @Autowired
    @Inject
    public void setD1(DataService d1) {
        System.out.println("Setter Injection");
        this.d1 = d1;
    }

    public DataService getD1() {
        return d1;
    }
}


//@Component
@Named
class DataService{

}


//@Configuration
@ComponentScan
@Named
public class CDI {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(CDI.class);

        System.out.println( context.getBean(DataService.class));
    }
}
