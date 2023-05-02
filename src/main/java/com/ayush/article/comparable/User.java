package com.ayush.article.comparable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparator<User> {
    private int id;
    private String name;

    @Override
    public int compare(User user, User t1) {
        return user.getName().compareTo(t1.getName());
    }
}
