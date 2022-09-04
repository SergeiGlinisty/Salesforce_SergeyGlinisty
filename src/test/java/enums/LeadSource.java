package enums;

public enum LeadSource {
    ADVERTISEMENT("Advertisement"),
    EMPLOYEE("Employee Referral"),
    EXTERNAL("External Referral"),
    INSTORE("In-Store"),
    ONSITE("On Site"),
    OTHER("Other"),
    SOCIAL("Social"),
    TRADE("Trade Show"),
    WEB("Web"),
    WORD("Word of mouth");

    public final String name;

    LeadSource(final String name) {
        this.name = name;
    }

    public static LeadSource fromString(String value) {
        for (LeadSource contactLeadSource : LeadSource.values()) {
            if (contactLeadSource.getName().equals(value)) {
                return contactLeadSource;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
