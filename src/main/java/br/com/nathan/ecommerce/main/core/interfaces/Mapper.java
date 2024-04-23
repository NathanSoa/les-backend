package br.com.nathan.ecommerce.main.core.interfaces;

public interface Mapper<T, S> {

    S map(T raw);
}
