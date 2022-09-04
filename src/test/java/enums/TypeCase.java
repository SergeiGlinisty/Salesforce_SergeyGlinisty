package enums;

public enum TypeCase {
    PROBLEM("Problem"),
    REQUEST("Feature Request"),
    QUESTION("Question");

    public final String name;

    TypeCase(String name) {
        this.name = name;
    }

    public static TypeCase fromString(String value) {
        for (TypeCase contactTypeCase : TypeCase.values()) {
            if (contactTypeCase.getName().equals(value)) {
                return contactTypeCase;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
