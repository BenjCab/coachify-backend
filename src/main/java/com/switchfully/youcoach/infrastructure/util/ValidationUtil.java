package com.switchfully.youcoach.infrastructure.util;

import java.util.regex.Pattern;

final public class ValidationUtil {

    private static final String EMAIL_FORMAT = "^\\w+@\\w+\\.\\w+$";
    private static final String PASSWORD_FORMAT = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$\n";


    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isEmptyString(Object object) {
        return object.toString().isEmpty();
    }

    public static boolean isBlankString(Object object) {
        return object.toString().isBlank();
    }

    public static void throwExceptionIfNullObject(Object object, String objectName) {
        if (object == null) {
            throw new IllegalArgumentException(objectName + " cannot be null.");
        }
    }

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_FORMAT);
    }

    public static void throwExceptionIfEmailNullEmptyBlankOrInvalid(String email) {
        throwExceptionIfNullOrEmptyOrBlank(email, "Email");
        if(!isValidEmail(email)) throw new IllegalArgumentException(email + "Invalid email format.");
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(phoneNumber).matches();
    }

    public static void throwExceptionIfPhoneNumberNullEmptyBlankOrInvalid(String phonenumber, String phone){
        throwExceptionIfNullOrEmptyOrBlank(phonenumber, phone);
        if(!isValidPhoneNumber(phonenumber)) {
            throw new IllegalArgumentException(phonenumber + "Invalid phonenumber.");
        }
    }

    public static void throwExceptionIfNullOrEmptyOrBlank(Object object, String objectName) {
        if (isNull(object))
            throw new IllegalArgumentException(objectName + " cannot be null.");
        else if (isBlankString(object))
            throw new IllegalArgumentException(objectName + " cannot be blank.");
        else if (isEmptyString(object))
            throw new IllegalArgumentException(objectName + " cannot be empty.");
    }

    public static boolean isGsmPhoneValidNumber(String gsmOrPhone) {
        return isValidPhoneNumber(gsmOrPhone) && !isNull(gsmOrPhone) && !isBlankString(gsmOrPhone);
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_FORMAT);
        return pattern.matcher(password).matches();
    }

    public static void throwExceptionIfPasswordNullEmptyBlankOrInvalid(String password){
        throwExceptionIfNullOrEmptyOrBlank(password, "Password");
        if(!isValidPhoneNumber(password)) {
            throw new IllegalArgumentException("Invalid password: Password should include at least 8 minimum characters, " +
                    "including at least one uppercase, at least one lowercase and one number");
        }
    }
}
