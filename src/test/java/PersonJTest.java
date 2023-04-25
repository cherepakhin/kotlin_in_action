import org.junit.jupiter.api.Test;
import ru.perm.v.kotlin_in_action.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonJTest {
    @Test
    void create() {
        Person person = new Person("-",1);
        assertEquals("-", person.getName());
        assertEquals(1, person.getAge());
    }
}
