package models;

import enums.LeadSource;
import enums.Stage;
import enums.TypeOpportunity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Opportunity {

    private String opportunityName;
    private String accountName;
    private String closeData;
    private Stage stage;
    private LeadSource leadSource;
    private TypeOpportunity typeOpportunity;
    private String description;
    private String nextStep;

}
