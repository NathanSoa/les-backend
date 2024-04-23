package br.com.nathan.ecommerce.main.core.interfaces;

public interface Strategy<T> {

    String process(T object);
}
