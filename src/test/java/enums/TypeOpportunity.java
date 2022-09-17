package enums;

public enum TypeOpportunity {

    EXISTING_BUSINESS("Existing Business"),
    NEW_BUSINESS("New Business");

    public final String name;

    TypeOpportunity(String name) {
        this.name = name;
    }

    public static TypeOpportunity fromString(String value) {
        for (TypeOpportunity contactTypeOpportunity : TypeOpportunity.values()) {
            if (contactTypeOpportunity.getName().equals(value)) {
                return contactTypeOpportunity;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
