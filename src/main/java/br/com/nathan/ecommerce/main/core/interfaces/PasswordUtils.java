package br.com.nathan.ecommerce.main.core.interfaces;

public interface PasswordUtils {

    String hash(String password);
    boolean compare(String password, String hash);
}
