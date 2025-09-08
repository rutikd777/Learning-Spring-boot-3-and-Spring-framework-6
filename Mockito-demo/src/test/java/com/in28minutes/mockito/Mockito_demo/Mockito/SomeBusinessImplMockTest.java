package com.in28minutes.mockito.Mockito_demo.Mockito;

import com.in28minutes.mockito.Mockito_demo.Business.DataService;
import com.in28minutes.mockito.Mockito_demo.Business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Mockito support enable karayla JUnit madhe extension
public class SomeBusinessImplMockTest {

    // 👉 Mock dependency (real implementation la replace karatoy)
    @Mock
    private DataService dataServiceMock;

    // 👉 @InjectMocks mule SomeBusinessImpl madhe automatically dataServiceMock inject hoto
    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void findGreatestValue_basicScenario() {
        // DataService retriveAllData() la manually response set kela
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{25, 5, 10});

        // BusinessImpl madhe findGreatestValue() call
        int result = businessImpl.findGreatestValue();

        // Expectation: Highest number = 25
        assertEquals(25, result);
    }

    @Test
    void findGreatestValue_OneValue() {
        // Fakat ekach value array madhe
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{35});

        int result = businessImpl.findGreatestValue();

        // Expected output: 35 (karan ekach element highest aahe)
        assertEquals(35, result);
    }

    @Test
    void findGreatestValue_EmptyArray() {
        // DataService empty array return kela
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{});

        int result = businessImpl.findGreatestValue();

        // BusinessImpl logic nusar jar array empty asel tar Integer.MIN_VALUE return karto
        assertEquals(Integer.MIN_VALUE, result);
    }
}
