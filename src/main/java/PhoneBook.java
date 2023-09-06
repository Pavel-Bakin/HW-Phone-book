import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> contacts;
    public PhoneBook () {
        contacts = new HashMap<>();
    }
    public int add (String name, String phoneNumber) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, phoneNumber);
            return 1;
        } else {
            return 0;
        }
    }

    public String findByNumber (String phoneNumber) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String findByName (String name) {
        if (contacts.containsKey(name)) {
            return contacts.get(name);
        } else {
            return null;
        }
    }
}
