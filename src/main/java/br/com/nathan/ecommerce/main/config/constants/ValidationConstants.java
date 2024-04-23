package br.com.nathan.ecommerce.main.config.constants;

public class ValidationConstants {

    private static final int STRING_MAX_LENGTH = 255;
    public static final int NAME_MAX_LENGTH = STRING_MAX_LENGTH;
    public static final int NAME_MIN_LENGTH = 2;
    public static final int PASSWORD_MAX_LENGTH = 20;
    public static final int PASSWORD_MIN_LENGTH = 8;
    public static final String CPF_FORMATTED = "(\\d{3})[.](\\d{3})[.](\\d{3})-(\\d{2})";
    public static final String CPF_UNFORMATTED = "(\\d{3})(\\d{3})(\\d{3})(\\d{2})";
    public static final String PHONE_FORMAT = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$";
}
