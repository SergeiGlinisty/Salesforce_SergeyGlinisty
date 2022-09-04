package enums;

public enum StatusTask {
    NOT_STARTED("Not Started"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    WAITING("Waiting on someone else"),
    DEFERRED("Deferred");


    public final String name;

    StatusTask(String name) {
        this.name = name;

    }

    public static StatusTask fromString(String value) {
        for (StatusTask contactStatusTask : StatusTask.values()) {
            if (contactStatusTask.getName().equals(value)) {
                return contactStatusTask;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
