import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhoneBookTest {
    @Rule
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAddContact() {
        int result = phoneBook.add("Петя", "89998887766");
        assertEquals(1, result);
    }

    @Test
    public void testAddDuplicateContact() {
        phoneBook.add("Вася", "89225849801");
        int result = phoneBook.add("Вася", "89225849801");

        assertEquals(0, result);
    }

    @Test
    public void testFindByNumberTest() {
        phoneBook.add("Петя", "89998887766");
        String foundName = phoneBook.findByNumber("89998887766");
        assertEquals("Петя", foundName);
    }

    @Test
    public void testFindByNumberNotFound() {
        String foundName = phoneBook.findByNumber("33333333333");
        assertNull(foundName);
    }

    @Test
    public void testFindByName() {
        phoneBook.add("Вася", "89225849801");
        String foundNumber = phoneBook.findByName("Вася");
        assertEquals("89225849801", foundNumber);
    }

    @Test
    public void testFindByNameNotFound() {
        String foundNumber = phoneBook.findByName("Анна");
        assertNull(foundNumber);
    }

    @Test
    public void testPrintAllNames() {
        phoneBook.add("Петя", "89998887766");
        phoneBook.add("Анна", "89126547689");
        phoneBook.add("Вася", "89225849801");

        String actualOutput = phoneBook.printAllNames();

        String expectedOutput = "Анна" + System.lineSeparator() + "Вася" + System.lineSeparator() + "Петя" + System.lineSeparator();
        assertEquals(expectedOutput, actualOutput);
    }
}
