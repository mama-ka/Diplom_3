package com.PageObject;
import org.apache.commons.lang3.RandomStringUtils;

public class UserData {
    public static final String EMAIL_POSTFIX = "@yandex.ru";
    private  String email;
    private  String password;
    private  String name;
    public UserData(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public static UserData getRandom(int countPassword) {
        final String name = RandomStringUtils.randomAlphabetic(7);
        final String email =RandomStringUtils.randomAlphabetic(7) + EMAIL_POSTFIX;
        final String password = RandomStringUtils.randomAlphabetic(countPassword);
        return new UserData(email, password, name);
    }

    public String getEmail() {
        return email;
    }
    public UserData setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getPassword() {
        return password;
    }
    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getName() {
        return name;
    }
    public UserData setName(String name) {
        this.name = name;
        return this;
    }
    public UserData() {
    }
}
