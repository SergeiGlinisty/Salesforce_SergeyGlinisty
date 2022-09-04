package enums;

public enum PriorityTask {

    HIGH("High"),
    NORMAL("Normal"),
    LOW("Low");


    public final String name;

    PriorityTask(String name) {
        this.name = name;

    }

    public static PriorityTask fromString(String value) {
        for (PriorityTask contactPriorityTask : PriorityTask.values()) {
            if (contactPriorityTask.getName().equals(value)) {
                return contactPriorityTask;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
