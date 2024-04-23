package br.com.nathan.ecommerce.main.core.interfaces;

import java.util.List;
import java.util.Map;

public interface Validator<T> {

        Map<String, List<String>> validate(T object);
}
