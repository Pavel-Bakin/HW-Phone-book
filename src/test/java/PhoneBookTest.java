import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp () {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAddContact () {
        int result = phoneBook.add("Петя", "89998887766");
        assertEquals(1, result);
    }

    @Test
    public void testAddDuplicateContact () {
        phoneBook.add("Вася", "89225849801");
        int result = phoneBook.add("Вася", "89225849801");

        assertEquals(0, result);
    }

    @Test
    public void testFindByNumberTest () {
        phoneBook.add("Петя", "89998887766");
        String foundName = phoneBook.findByNumber("89998887766");
        assertEquals("Петя", foundName);
    }

    @Test
    public void testFindByNumberNotFound () {
        String foundName = phoneBook.findByNumber("33333333333");
        assertNull(foundName);
    }

}
