package test;
import mock.multiplication;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class multiplicationTest {
    multiplication mu=new multiplication();
    @Test
    public void multi() {
        assertThat(mu.multi(3,0),equalTo(0));
        assertThat(mu.multi(3,1),equalTo(3));
    }
}