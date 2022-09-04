package enums;

public enum Stage {
    QUALIFICATION("Qualification"),
    MEETING("Meeting Scheduled"),
    PROPOSAL("Proposal/Price Quote"),
    NEGOTIATION("Negotiation/Review"),
    CLOSED_WON("Closed Won"),
    CLOSED_LOST("Closed Lost");


   public final String name;

    Stage(String name) {
        this.name = name;

    }

    public static Stage fromString(String value) {
        for (Stage contactStage : Stage.values()) {
            if (contactStage.getName().equals(value)) {
                return contactStage;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

  }
