package models;

import enums.*;

import java.util.Objects;


public class Lead {
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String description;
    private final String street;
    private final String province;
    private final String country;
    private final String city;
    private final String title;
    private final String email;
    private final String phone;
    private final String annualRevenue;
    private final Salutation salutation;
    private final Rating rating;
    private final Industry industry;
    private final LeadStatus leadStatus;
    private final LeadSource leadSource;
    private final String postalCode;
    private final String numberOfEmployees;
    private final String webSite;
    private final String fullName;


    public Lead(Lead.LeadBuilder leadBuilder) {
        this.leadStatus = leadBuilder.leadStatus;
        this.salutation = leadBuilder.salutation;
        this.firstName = leadBuilder.firstName;
        this.lastName = leadBuilder.lastName;
        this.country = leadBuilder.country;
        this.city = leadBuilder.city;
        this.title = leadBuilder.title;
        this.email = leadBuilder.email;
        this.phone = leadBuilder.phone;
        this.annualRevenue = leadBuilder.annualRevenue;
        this.rating = leadBuilder.rating;
        this.company = leadBuilder.company;
        this.industry = leadBuilder.industry;
        this.numberOfEmployees = leadBuilder.numberOfEmployees;
        this.leadSource = leadBuilder.leadSource;
        this.description = leadBuilder.description;
        this.street = leadBuilder.street;
        this.province = leadBuilder.province;
        this.postalCode = leadBuilder.postalCode;
        this.webSite = leadBuilder.webSite;
        this.fullName = leadBuilder.fullName;
    }

    public String getFullName() {
        if (this.fullName != null) {
            return this.fullName;
        } else {
            return (this.salutation.getName() + " " + this.firstName + " " + this.lastName).trim();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return Objects.equals(fullName, lead.fullName) && Objects.equals(company, lead.company) && Objects.equals(description, lead.description) && Objects.equals(street, lead.street) && Objects.equals(province, lead.province) && Objects.equals(city, lead.city) && Objects.equals(country, lead.country) && Objects.equals(title, lead.title) && Objects.equals(email, lead.email) && Objects.equals(phone, lead.phone) && Objects.equals(annualRevenue, lead.annualRevenue) && salutation == lead.salutation && rating == lead.rating && industry == lead.industry && leadStatus == lead.leadStatus && leadSource == lead.leadSource && Objects.equals(postalCode, lead.postalCode) && Objects.equals(numberOfEmployees, lead.numberOfEmployees) && Objects.equals(webSite, lead.webSite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, firstName, lastName, company, description, street, province, country, city, title, email, phone, annualRevenue, salutation, rating, industry, leadStatus, leadSource, postalCode, numberOfEmployees, webSite);
    }

    @Override
    public String toString() {
        return "Lead{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", description='" + description + '\'' +
                ", street='" + street + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", annualRevenue='" + annualRevenue + '\'' +
                ", salutation=" + salutation +
                ", rating=" + rating +
                ", industry=" + industry +
                ", leadStatus=" + leadStatus +
                ", leadSource=" + leadSource +
                ", postalCode='" + postalCode + '\'' +
                ", numberOfEmployees='" + numberOfEmployees + '\'' +
                ", webSite='" + webSite + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public String getStreet() {
        return street;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public Rating getRating() {
        return rating;
    }

    public Industry getIndustry() {
        return industry;
    }

    public LeadStatus getLeadStatus() {
        return leadStatus;
    }

    public LeadSource getLeadSource() {
        return leadSource;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getWebSite() {
        return webSite;
    }

    public static class LeadBuilder {

        private String lastName;
        private String company;
        private LeadStatus leadStatus;
        private String firstName;
        private String description;
        private String street;
        private String province;
        private String country;
        private String city;
        private String title;
        private String email;
        private String phone;
        private String annualRevenue;
        private Salutation salutation;
        private Rating rating;
        private Industry industry;
        private LeadSource leadSource;
        private String postalCode;
        private String numberOfEmployees;
        private String webSite;
        private String fullName;
        private String address;


        public LeadBuilder(String company, LeadStatus leadStatus) {
            this.company = company;
            this.leadStatus = leadStatus;
        }

        public Lead build() {
            return new Lead(this);
        }

        public Lead.LeadBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Lead.LeadBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Lead.LeadBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Lead.LeadBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Lead.LeadBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Lead.LeadBuilder street(String street) {
            this.street = street;
            return this;
        }

        public Lead.LeadBuilder province(String province) {
            this.province = province;
            return this;
        }

        public Lead.LeadBuilder country(String country) {
            this.country = country;
            return this;
        }

        public Lead.LeadBuilder city(String city) {
            this.city = city;
            return this;
        }

        public Lead.LeadBuilder title(String title) {
            this.title = title;
            return this;
        }

        public Lead.LeadBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Lead.LeadBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Lead.LeadBuilder annualRevenue(String annualRevenue) {
            this.annualRevenue = annualRevenue;
            return this;
        }

        public Lead.LeadBuilder salutation(Salutation salutation) {
            this.salutation = salutation;
            return this;
        }

        public Lead.LeadBuilder rating(Rating rating) {
            this.rating = rating;
            return this;
        }

        public Lead.LeadBuilder industry(Industry industry) {
            this.industry = industry;
            return this;
        }

        public Lead.LeadBuilder leadSource(LeadSource leadSource) {
            this.leadSource = leadSource;
            return this;
        }

        public Lead.LeadBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Lead.LeadBuilder numberOfEmployees(String numberOfEmployees) {
            this.numberOfEmployees = numberOfEmployees;
            return this;
        }

        public Lead.LeadBuilder webSite(String webSite) {
            this.webSite = webSite;
            return this;
        }
    }
}
