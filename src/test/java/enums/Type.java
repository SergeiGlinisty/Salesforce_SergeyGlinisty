package enums;

public enum Type {

    ANALYST("Analyst"),
    COMPETITOR("Competitor"),
    CUSTOMER("Customer"),
    INTEGRATOR("Integrator"),
    INVESTOR("Investor"),
    PARTNER("Partner"),
    PRESS("Press"),
    PROSPECT("Prospect"),
    RESELLER("Reseller"),
    OTHER("Other");

    public final String name;

    Type(String name) {
        this.name = name;
    }

    public static Type fromString(String value) {
        for (Type contactType : Type.values()) {
            if (contactType.getName().equals(value)) {
                return contactType;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
