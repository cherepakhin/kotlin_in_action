import org.junit.jupiter.api.Test;
import ru.perm.v.kotlin_in_action.PersonK;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonJTest {
    @Test
    void create() {
        PersonK person = new PersonK(1, "-", 10);
        assertEquals("-", person.getName());
        assertEquals(10, person.getAge());
    }
}
