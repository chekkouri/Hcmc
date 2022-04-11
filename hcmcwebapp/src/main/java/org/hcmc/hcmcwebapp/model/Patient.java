package org.hcmc.hcmcwebapp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Patient Number is required")
    private String patientNumber;
    @Column(nullable = false)
    @NotBlank(message = "IsOutPatient is required")
    private String isOutPatient;
    @Column(nullable = false)
    @NotBlank(message = "Full Name is required")
    private String fullNames;
    @Email
    @Column(nullable = true)
    private String emailAddress;
    @Column(nullable = true)
    private String contactPhone;
    @NotNull(message = "Date of birth is required")
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    public Patient() {
    }

    public Patient(Long patientId, String patientNumber, String isOutPatient, String fullNames, String emailAddress, String contactPhone, LocalDate dateOfBirth) {
        this.patientId = patientId;
        this.patientNumber = patientNumber;
        this.isOutPatient = isOutPatient;
        this.fullNames = fullNames;
        this.emailAddress = emailAddress;
        this.contactPhone = contactPhone;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getIsOutPatient() {
        return isOutPatient;
    }

    public void setIsOutPatient(String isOutPatient) {
        this.isOutPatient = isOutPatient;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isElderly() {
//        return Period.between(this.dateOfBirth, LocalDate.now()).getYears() >= 65;
        // OR
        return (this.dateOfBirth.isBefore(LocalDate.now().minusYears(65l)) ||
                this.dateOfBirth.isEqual(LocalDate.now().minusYears(65l)));

        // But this is NOT accurate
//        return (LocalDate.now().getYear() - this.dateOfBirth.getYear() >= 65);
    }
}
