package models;

import enums.Salutation;

import java.util.Objects;

public class Contact {
    private final String firstName;
    private final String lastName;
    private final Salutation salutation;
    private final String accountName;
    private final String title;
    private final String phone;
    private final String mobile;
    private final String email;
    private final String fullName;

    private Contact(ContactBuilder contactBuilder) {
        this.firstName = contactBuilder.firstName;
        this.lastName = contactBuilder.lastName;
        this.salutation = contactBuilder.salutation;
        this.accountName = contactBuilder.accountName;
        this.phone = contactBuilder.phone;
        this.email = contactBuilder.email;
        this.title = contactBuilder.title;
        this.mobile = contactBuilder.mobile;
        this.fullName = contactBuilder.fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getTitle() {
        return title;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
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
        Contact contact = (Contact) o;
        return Objects.equals(fullName, contact.fullName) && Objects.equals(accountName, contact.accountName) && Objects.equals(title, contact.title) && Objects.equals(email, contact.email) && Objects.equals(phone, contact.phone) && Objects.equals(mobile, contact.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, accountName, salutation, email, phone, mobile, title);
    }

    @Override
    public String toString() {
        return "Lead{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salutation=" + salutation +
                ", accountName=" + accountName +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public static class ContactBuilder {
        private String firstName;
        private String lastName;
        private Salutation salutation;
        private String accountName;
        private String email;
        private String phone;
        private String mobile;
        private String title;
        private String fullName;

        public ContactBuilder(String lastName, String accountName) {
            this.lastName = lastName;
            this.accountName = accountName;

        }

        public Contact build() {
            return new Contact(this);
        }

        public Contact.ContactBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Contact.ContactBuilder salutation(Salutation salutation) {
            this.salutation = salutation;
            return this;
        }

        public Contact.ContactBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Contact.ContactBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Contact.ContactBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Contact.ContactBuilder title(String title) {
            this.title = title;
            return this;
        }

        public Contact.ContactBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }
    }


}
