package enums;


    public enum CaseOrigin {
        EMAIL("Email"),
        PHONE("Phone"),
        WEB("Web"),
        FACEBOOK("Facebook"),
        TWITTER("Twitter");


        public final String name;

        CaseOrigin(String name) {
            this.name = name;

        }

        public static CaseOrigin fromString(String value) {
            for (CaseOrigin contactCaseOrigin : CaseOrigin.values()) {
                if (contactCaseOrigin.getName().equals(value)) {
                    return contactCaseOrigin;
                }
            }
            return null;
        }

        public String getName() {
            return this.name;
        }

    }
