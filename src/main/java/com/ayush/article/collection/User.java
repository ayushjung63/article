package com.ayush.article.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User> {
    private Integer id;
    private String name;


    @Override
    public int compareTo(User user) {
        return this.getId().compareTo(user.getId());
    }
}
