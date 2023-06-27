package com.ayush.article.optional;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        // create empty Optional Object
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.get());

        Optional<Object> johnOptional = Optional.ofNullable("John Doe");
        System.out.println(johnOptional.get());

        Optional<Object> john = Optional.of("John Doe");
        System.out.println(john.get());

        Optional<Object> o = Optional.of("Hello World");
        if (o.isPresent()){
            System.out.println(o.get());
        }

        Optional<Object> nullOptional = Optional.ofNullable(null);

        Optional.of(null).orElse("0");
    }
}
