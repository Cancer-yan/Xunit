package test;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;


import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class testMockDemo {
    @Test
    public void testMock(){
        ArrayList<Integer> list1=mock(ArrayList.class);
        when(list1.size()).thenReturn(5);


    }
}
