package com.switchfully.youcoach.infrastructure.validations;

final public class ValidationUtil {
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

    public static void throwExceptionIfNullOrEmptyOrBlank(Object object, String objectName) {
        if (isNull(object))
            throw new IllegalArgumentException(objectName + " cannot be null.");
        else if (isBlankString(object))
            throw new IllegalArgumentException(objectName + " cannot be blank.");
        else if (isEmptyString(object))
            throw new IllegalArgumentException(objectName + " cannot be empty.");
    }

    public static boolean isEmailValid(String email) {
        if (email == null) return false;

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
