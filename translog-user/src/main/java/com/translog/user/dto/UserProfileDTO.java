package com.translog.user.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.translog.user.entity.User;

public class UserProfileDTO {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotNull(message = "{user.firstName.must}")
    @Size(max = 20, message = "{user.firstName.invalid}")
    private String firstName;

    @NotNull(message = "{user.lastName.must}")
    @Size(max = 20, message = "{user.lastName.invalid}")
    private String lastName;

    @NotNull(message = "{user.email.must}")
    @Size(max = 30)
    private String emailId;

    @NotNull(message = "{user.phone.must}")
    @Size(min = 10, max = 10, message = "{user.phone.invalid}")
    private Integer mobileNumber;

    @Pattern(regexp = "[*.!@#$%^&(){}[]:;<>,.?/~_+-=|]", message = "{user.password.invalid}")
    @NotEmpty(message = "{user.password.must}")
    @Size(min = 7, max = 15, message = "{user.password.invalidsize}" )
    private String password;

    @Size(max = 30, message = "String length cannot be more than 30 characters")
    @NotEmpty(message = "{user.nationality.must}")
    private String nationality;

    @NotEmpty(message = "{user.passportNumber.must}")
    @Size(min = 7, max = 12, message = "{user.passportNumber.invalid}")
    private String passportNumber;

    @NotEmpty(message = "{user.permanentAddress.must}")
    @Size(max = 200, message = "{user.permanentAddress.invalid}")
    private String permanentAddress;

    @NotEmpty(message = "{user.officeAddress.must}")
    @Size(max = 200, message = "{user.officeAddress.invalid}")
    private String officeAddress;

    @NotNull(message = "{user.personalIdentificationNumber.must}")
    @Size(min = 12, max = 12, message = "{user.personalIdentificationNumber.invalid}")
    private Integer personalIdentificationNumber;

    public Integer getUserId() { return this.userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getFirstName() { return this.firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return this.lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmailId() { return this.emailId; }

    public void setEmailId(String emailId) { this.emailId = emailId; }

    public Integer getMobileNumber() { return this.mobileNumber; }

    public void setMobileNumber(Integer numberInt) { this.mobileNumber = numberInt; }

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

    public static UserProfileDTO toDto(User user) {
        UserProfileDTO dto = new UserProfileDTO();

        dto.setEmailId(user.getEmailId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setNationality(user.getNationality());
        dto.setMobileNumber(user.getMobileNumber());
        dto.setOfficeAddress(user.getOfficeAddress());
        dto.setPassportNumber(user.getPassportNumber());
        dto.setPassword(user.getPassword());
        dto.setPermanentAddress(user.getPermanentAddress());
        dto.setPersonalIdentificationNumber(user.getPersonalIdentificationNumber());
        dto.setUserId(user.getUserId());

        return dto;
    }
}
