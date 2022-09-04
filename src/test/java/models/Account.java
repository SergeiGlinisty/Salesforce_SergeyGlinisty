package models;

import enums.Industry;
import enums.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private String accountName;
    private String parentAccount;
    private String phone;
    private String fax;
    private String website;
    private Type type;
    private Industry industry;
    private String employees;
    private String annualRevenue;
    private String description;
    private String billingStreet;
    private String shippingStreet;
    private String billingCity;
    private String billingProvince;
    private String billingPostalCode;
    private String billingCountry;
    private String shippingCity;
    private String shippingProvince;
    private String shippingPostalCode;
    private String shippingCountry;

}
