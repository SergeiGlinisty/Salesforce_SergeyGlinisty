package models;

import enums.Industry;
import enums.Type;

import java.util.Objects;

public class Account {

    private final String accountName;
    private final String parentAccount;
    private final String phone;
    private final String fax;
    private final String website;
    private final Type type;
    private final Industry industry;
    private final String employees;
    private final String annualRevenue;
    private final String description;
    private final String billingStreet;
    private final String shippingStreet;
    private final String billingCity;
    private final String billingProvince;
    private final String billingPostalCode;
    private final String billingCountry;
    private final String shippingCity;
    private final String shippingProvince;
    private final String shippingPostalCode;
    private final String shippingCountry;

    public Account(Account.AccountBuilder accountBuilder) {
        this.accountName = accountBuilder.accountName;
        this.parentAccount = accountBuilder.parentAccount;
        this.phone = accountBuilder.phone;
        this.fax = accountBuilder.fax;
        this.website = accountBuilder.website;
        this.type = accountBuilder.type;
        this.industry = accountBuilder.industry;
        this.employees = accountBuilder.employees;
        this.annualRevenue = accountBuilder.annualRevenue;
        this.description = accountBuilder.description;
        this.billingStreet = accountBuilder.billingStreet;
        this.shippingStreet = accountBuilder.shippingStreet;
        this.billingCity = accountBuilder.billingCity;
        this.billingProvince = accountBuilder.billingProvince;
        this.billingPostalCode = accountBuilder.billingPostalCode;
        this.billingCountry = accountBuilder.billingCountry;
        this.shippingCity = accountBuilder.shippingCity;
        this.shippingProvince = accountBuilder.shippingProvince;
        this.shippingPostalCode = accountBuilder.shippingPostalCode;
        this.shippingCountry = accountBuilder.shippingCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountName, account.accountName) && Objects.equals(parentAccount, account.parentAccount) && Objects.equals(description, account.description) && Objects.equals(phone, account.phone) && Objects.equals(fax, account.fax) && Objects.equals(website, account.website) && Objects.equals(employees, account.employees) && Objects.equals(billingStreet, account.billingStreet) && Objects.equals(shippingStreet, account.shippingStreet) && Objects.equals(annualRevenue, account.annualRevenue) && type == account.type && industry == account.industry && Objects.equals(billingCity, account.billingCity) && Objects.equals(billingProvince, account.billingProvince) && Objects.equals(billingPostalCode, account.billingPostalCode) && Objects.equals(billingCountry, account.billingCountry) && Objects.equals(shippingCity, account.shippingCity) && Objects.equals(shippingProvince, account.shippingProvince) && Objects.equals(shippingPostalCode, account.shippingPostalCode) && Objects.equals(shippingCountry, account.shippingCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountName, parentAccount, description, phone, fax, website, employees, billingStreet, shippingStreet, annualRevenue, type, industry, billingCity, billingProvince, billingPostalCode, billingCountry, shippingCity, shippingProvince, shippingPostalCode, shippingCountry);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", parentAccount='" + parentAccount + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", website='" + website + '\'' +
                ", type=" + type +
                ", industry=" + industry +
                ", employees='" + employees + '\'' +
                ", annualRevenue='" + annualRevenue + '\'' +
                ", description='" + description + '\'' +
                ", billingStreet='" + billingStreet + '\'' +
                ", shippingStreet='" + shippingStreet + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", billingProvince='" + billingProvince + '\'' +
                ", billingPostalCode='" + billingPostalCode + '\'' +
                ", billingCountry='" + billingCountry + '\'' +
                ", shippingCity='" + shippingCity + '\'' +
                ", shippingProvince='" + shippingProvince + '\'' +
                ", shippingPostalCode='" + shippingPostalCode + '\'' +
                ", shippingCountry='" + shippingCountry + '\'' +
                '}';
    }

    public String getAccountName() {
        return accountName;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getWebsite() {
        return website;
    }

    public Type getType() {
        return type;
    }

    public Industry getIndustry() {
        return industry;
    }

    public String getEmployees() {
        return employees;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public String getDescription() {
        return description;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public String getBillingProvince() {
        return billingProvince;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public String getShippingProvince() {
        return shippingProvince;
    }

    public String getShippingPostalCode() {
        return shippingPostalCode;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public static class AccountBuilder {
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

        public AccountBuilder(String accountName) {
            this.accountName = accountName;

        }

        public Account build() {
            return new Account(this);
        }

        public Account.AccountBuilder parentAccount(String parentAccount) {
            this.parentAccount = parentAccount;
            return this;
        }


        public Account.AccountBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Account.AccountBuilder fax(String fax) {
            this.fax = fax;
            return this;
        }

        public Account.AccountBuilder website(String website) {
            this.website = website;
            return this;
        }

        public Account.AccountBuilder type(Type type) {
            this.type = type;
            return this;
        }

        public Account.AccountBuilder industry(Industry industry) {
            this.industry = industry;
            return this;
        }

        public Account.AccountBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Account.AccountBuilder employees(String employees) {
            this.employees = employees;
            return this;
        }

        public Account.AccountBuilder annualRevenue(String annualRevenue) {
            this.annualRevenue = annualRevenue;
            return this;
        }


        public Account.AccountBuilder billingStreet(String billingStreet) {
            this.billingStreet = billingStreet;
            return this;
        }

        public Account.AccountBuilder shippingStreet(String shippingStreet) {
            this.shippingStreet = shippingStreet;
            return this;
        }

        public Account.AccountBuilder billingCity(String billingCity) {
            this.billingCity = billingCity;
            return this;
        }

        public Account.AccountBuilder billingProvince(String billingProvince) {
            this.billingProvince = billingProvince;
            return this;
        }

        public Account.AccountBuilder billingPostalCode(String billingPostalCode) {
            this.billingPostalCode = billingPostalCode;
            return this;
        }

        public Account.AccountBuilder billingCountry(String billingCountry) {
            this.billingCountry = billingCountry;
            return this;
        }

        public Account.AccountBuilder shippingCity(String shippingCity) {
            this.shippingCity = shippingCity;
            return this;
        }

        public Account.AccountBuilder shippingProvince(String shippingProvince) {
            this.shippingProvince = shippingProvince;
            return this;
        }

        public Account.AccountBuilder shippingPostalCode(String shippingPostalCode) {
            this.shippingPostalCode = shippingPostalCode;
            return this;
        }

        public Account.AccountBuilder shippingCountry(String shippingCountry) {
            this.shippingCountry = shippingCountry;
            return this;
        }


    }

}
