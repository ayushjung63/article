package com.ayush.article.generic.pkg1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericClass<T> {
    private T data;

    public GenericClass(T data) {
        this.data = data;
    }
}
