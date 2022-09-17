package models;

import enums.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    private String contactName;
    private String accountName;
    private String webEmail;
    private Status status;
    private CaseOrigin caseOrigin;
    private Priority priority;
    private TypeCase typeCase;
    private CaseReason caseReason;
    private String subject;
    private String description;
    private String internalComments;
}
