package keyboardshortcuts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InlineTest {
    @Test
    public void testApp() {
        Assertions.assertEquals(42, new Inline().practice());
    }
}
