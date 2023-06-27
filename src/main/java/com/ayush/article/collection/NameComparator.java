package com.ayush.article.collection;

import java.util.Comparator;

public class NameComparator implements Comparator<User> {

    @Override
    public int compare(User user, User t1) {
        return user.getName().compareTo(t1.getName());
    }
}
