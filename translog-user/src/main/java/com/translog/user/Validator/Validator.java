package com.translog.user.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.translog.user.exception.UserException;

public class Validator {

    /**
     * allow min 1 special character. characters are allowed. 
     * Set the appropriate error message for invalid inputs.
     * @param password
     * @return
     * @throws UserException
     */
    public Boolean validatePassword(String password) throws UserException { 

        Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        Matcher hasLetter = letter.matcher(password);
        Matcher hasDigit = digit.matcher(password);
        Matcher hasSpecial = special.matcher(password);

        if(hasLetter.find() && hasDigit.find() && hasSpecial.find())
            return true;
        
        throw new UserException("user.password.invalid");
    
    }

    public Boolean validatePhoneNumber(Long phoneNumber) throws UserException {

        if(phoneNumber <= 9999999999L)
            return true;

        throw new UserException("user.phone.invalid");
    }
    
}
