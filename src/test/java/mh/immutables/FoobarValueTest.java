package mh.immutables;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FoobarValueTest {

    @Test
    public void basicTest() throws Exception {
        FoobarValue value = ImmutableFoobarValue.builder()
                                                .foo(2)
                                                .bar("Bar")
                                                .addBuz(1, 3, 4)
                                                .build(); // FoobarValue{foo=2, bar=Bar, buz=[1, 3, 4], crux={}}

        assertEquals(2, value.foo());
        assertEquals(ImmutableList.of(1, 3, 4), value.buz());
    }

    @Test(expected = NullPointerException.class)
    public void nullTest() throws Exception {
        ImmutableFoobarValue.builder()
                            .foo(2)
                            .bar("Bar")
                            .addAllBuz(ImmutableList.of(1, null, 4)) // !!!
                            .build();
    }
}
