package com.ayush.article.generic.bounded;

public class GenericUserMain {
    public static void main(String[] args) {
        GenericUser<Admin> adminGenericUser=new GenericUser<>();
        adminGenericUser.login();

        GenericUser<User> userGenericUser=new GenericUser<>();
        userGenericUser.login();
    }
}
