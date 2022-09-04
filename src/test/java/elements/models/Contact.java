package elements.models;

import enums.Salutation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
    private String firstName;
    private String lastName;
    private Salutation salutation;
    private String accountName;
    private String title;
    private String phone;
    private String mobile;
    private String email;

}
