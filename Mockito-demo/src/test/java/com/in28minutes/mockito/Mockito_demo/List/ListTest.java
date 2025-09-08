package com.in28minutes.mockito.Mockito_demo.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void Simple_test() {
        // Ek dummy/mock List create keli
        List Listmock = mock(List.class);

        // Jya vela Listmock.size() call hoil, tyala 3 return karaycha
        when(Listmock.size()).thenReturn(3);

        // Assert => Expectation check karatoy ki size() kharach 3 return karto ka
        assertEquals(3, Listmock.size());
        assertEquals(3, Listmock.size());
        assertEquals(3, Listmock.size());

        // 👉 Explanation:
        // Mock object la apan manually configure karto.
        // Normal List kharach elements count karun size return karte.
        // Pan mock madhe apan sangto ki "size() bolavla ki 3ch return kar".
    }

    @Test
    void Multiple_Returns() {
        List Listmock = mock(List.class);

        // size() la multiple return values dilya:
        // First call -> 1, second call -> 2, and third+ calls -> 2
        when(Listmock.size()).thenReturn(1).thenReturn(2);

        assertEquals(1, Listmock.size()); // first call -> 1
        assertEquals(2, Listmock.size()); // second call -> 2
        assertEquals(2, Listmock.size()); // next calls -> 2
        assertEquals(2, Listmock.size());

        // 👉 Explanation:
        // Chaining madhe apan sangto ki ekach method la
        // different calls sathi different output dya.
    }

    @Test
    void Specific_Parameters() {
        List Listmock = mock(List.class);

        // get(0) call kela ki "SomeString" return kar
        when(Listmock.get(0)).thenReturn("SomeString");

        assertEquals("SomeString", Listmock.get(0)); // get(0) => SomeString
        assertEquals(null, Listmock.get(1));         // baki index sathi default => null

        // 👉 Explanation:
        // Mockito default behaviour -> jar explicitly define kela nsel
        // tar object methods null, 0, false return kartat.
    }

    @Test
    void Generic_Parameters() {
        List Listmock = mock(List.class);

        // get(anyInt()) => kashihi integer index ghetla tari
        // "SomeOtherString" return kara
        when(Listmock.get(Mockito.anyInt())).thenReturn("SomeOtherString");

        assertEquals("SomeOtherString", Listmock.get(0)); // get(0) -> SomeOtherString
        assertEquals("SomeOtherString", Listmock.get(1)); // get(1) -> SomeOtherString

        // 👉 Explanation:
        // Mockito.anyInt() matcher vaparla -> parameter flexible banavla.
        // Ekach return value saglya integer indices la applicable banali.
    }
}
