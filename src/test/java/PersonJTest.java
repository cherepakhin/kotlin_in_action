import org.junit.jupiter.api.Test;
import ru.perm.v.kotlin_in_action.PersonK;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Использование java с kotlin
 */
public class PersonJTest {
    @Test
    void create() {
        PersonK person = new PersonK(1, "-", 10);
        Integer age = person.getAge();

        assertEquals("-", person.getName());
        assertTrue(age.equals(10));
    }
}
