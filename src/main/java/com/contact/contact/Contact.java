package com.contact.contact;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
public class Contact {

    @Id
    private String id;


    @NotNull
    @Size(min = 1, message = "firstName is required at least 1 character")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "lastName is required at least 1 character")
    private String lastName;

    @Pattern(regexp = "^1([34578])\\d{9}$", message = "invalid phone number")
    private String phoneNumber;

    @NotBlank(message = "invalid email address")
    @Email
    private String emailAddress;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(emailAddress, contact.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, emailAddress);
    }
}