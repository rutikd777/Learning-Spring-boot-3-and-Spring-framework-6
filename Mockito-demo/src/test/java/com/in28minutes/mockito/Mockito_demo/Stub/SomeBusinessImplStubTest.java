package com.in28minutes.mockito.Mockito_demo.Stub;

import com.in28minutes.mockito.Mockito_demo.Business.DataService;
import com.in28minutes.mockito.Mockito_demo.Business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SomeBusinessImplStubTest {

    @Test
    void findGreatestValue_basicScenario(){
        // इथे आपण Stub तयार करतो - DataServiceStub1
        // हा एक "Fake Implementation" aahe jo actual database call karnya peksha
        // predefined data return karto.
        DataServiceStub1 dataServiceStub1 = new DataServiceStub1();

        // हा Stub SomeBusinessImpl ला देतो (Dependency Injection)
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub1);

        // आता findGreatestValue() method call केली
        int result = businessImpl.findGreatestValue();

        // आपण assert करून पहिलं की result बरोबर आहे का
        assertEquals(25, result);
    }

    // दुसरा test case - jithe फक्त एकच value आहे
    @Test
    void findGreatestValue_withOneValue(){
        DataServiceStub2 dataServiceStub2 = new DataServiceStub2();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub2);
        int result = businessImpl.findGreatestValue();
        assertEquals(25, result);
    }
}

// ---- Stub Classes ----

// DataServiceStub1 हा DataService implement karto
// retriveAllData() method ने नेहमी fixed array return karaycha
class DataServiceStub1 implements DataService {
    @Override
    public int[] retriveAllData() {
        // इथे hardcoded values दिल्या आहेत (25, 5, 10)
        return new int[] {25, 5, 10};
    }
}

// दुसरा stub jithe फक्त एकच value 25 आहे
class DataServiceStub2 implements DataService {
    @Override
    public int[] retriveAllData() {
        return new int[] {25};
    }
}
