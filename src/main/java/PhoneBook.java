import java.util.*;

public class PhoneBook {
    private Map<String, String> contacts;
    private Set<String> sortedNames;

    public PhoneBook() {
        contacts = new HashMap<>();
        sortedNames = new TreeSet<>();
    }

    public int add(String name, String phoneNumber) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, phoneNumber);
            sortedNames.add(name);
            return 1;
        } else {
            return 0;
        }
    }

    public String findByNumber(String phoneNumber) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String findByName(String name) {
        if (contacts.containsKey(name)) {
            return contacts.get(name);
        } else {
            return null;
        }
    }

    public String printAllNames() {
        List<String> sortedNamesList = new ArrayList<>(sortedNames);
        Collections.sort(sortedNamesList);
        StringBuilder output = new StringBuilder();
        for (String name : sortedNamesList) {
            output.append(name).append(System.lineSeparator());
        }
        return output.toString();
    }
}
