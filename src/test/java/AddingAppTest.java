import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddingAppTest {

    @Test
    void add() {
        AddingApp addingApp = new AddingApp();
        assertEquals(5, addingApp.add(2, 3));
    }
}