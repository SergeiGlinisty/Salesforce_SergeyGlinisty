package enums;

public enum CaseReason {

    FIRST_REASON("User didn't attend training"),
    SECOND_REASON("Complex functionality"),
    THIRD_REASON("Existing problem"),
    FOURTH_REASON("Instructions not clear"),
    FIFTH_REASON("New problem");


    public final String name;

    CaseReason(String name) {
        this.name = name;

    }

    public static CaseReason fromString(String value) {
        for (CaseReason contactCaseReason : CaseReason.values()) {
            if (contactCaseReason.getName().equals(value)) {
                return contactCaseReason;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

}
