package com.translog.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.translog.user.dto.UserProfileDTO;
@Entity
@Table(name= "ftr_user")
public class User {
    @Id
    private Integer userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private Integer numberInt;
    private String password;
    private String nationality;
    private String passportNumber;
    private String permanentAddress;
    private String officeAddress;
    private Integer personalIdentificationNumber;

    public Integer getUserId() { return this.userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getFirstName() { return this.firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return this.lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmailId() { return this.emailId; }

    public void setEmailId(String emailId) { this.emailId = emailId; }

    public Integer getMobileNumber() { return this.numberInt; }

    public void setMobileNumber(Integer numberInt) { this.numberInt = numberInt; }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }

    public String getNationality() { return this.nationality; }

    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getPassportNumber() { return this.passportNumber; }

    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public String getPermanentAddress() { return this.permanentAddress; }

    public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }

    public String getOfficeAddress() { return this.officeAddress; }

    public void setOfficeAddress(String officeAddress) { this.officeAddress = officeAddress; }

    public Integer getPersonalIdentificationNumber() { return this.personalIdentificationNumber; }

    public void setPersonalIdentificationNumber(Integer personalIdentificationNumber) { this.personalIdentificationNumber = personalIdentificationNumber; }

    public static User toEntity(UserProfileDTO dto) {
        User user = new User();
        
        user.setEmailId(dto.getEmailId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setMobileNumber(dto.getMobileNumber());
        user.setNationality(dto.getNationality());
        user.setOfficeAddress(dto.getOfficeAddress());
        user.setPassportNumber(dto.getPassportNumber());
        user.setPassword(dto.getPassword());
        user.setPermanentAddress(dto.getPermanentAddress());
        user.setPersonalIdentificationNumber(dto.getPersonalIdentificationNumber());
        user.setUserId(dto.getUserId());

        return user;
    }
}
