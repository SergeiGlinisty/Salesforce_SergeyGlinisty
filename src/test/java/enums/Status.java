package enums;

public enum Status {
    NEW("New"),
    OPEN("Open"),
    PENDING("Pending"),
    ESCALATED("Escalated"),
    CLOSED("Closed");


    public final String name;

    Status(String name) {
        this.name = name;

    }

    public static Status fromString(String value) {
        for (Status contactStatus : Status.values()) {
            if (contactStatus.getName().equals(value)) {
                return contactStatus;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
