package com.example.hw2;

public class Checker {

  AccountState checkAccount(String account) {
    String regex = "^(.+)@(.+)$";
    if (account.equals("")) {
      return AccountState.IS_NOT_EMAIL;
    } else if (!account.matches(regex)) {
      return AccountState.IS_NOT_EMAIL;
    }
    return AccountState.PASS;
  }

  PasswordState checkPassword(String password) {
    String regex = "^(.+)[0-9]+.*";
    String regexCapital = "^(.*)[A-Z]+.*";
    if (password.equals("")) {
      return PasswordState.IS_NOT_GREATE_EIGHT;
    } else if (password.length() <= 8) {
      return PasswordState.IS_NOT_GREATE_EIGHT;
    } else if (!password.matches(regex)) {
      return PasswordState.IS_NOT_GREATE_EIGHT;
    } else if (!password.matches(regexCapital)) {
      return PasswordState.IS_NOT_GREATE_EIGHT;
    }
    return PasswordState.PASS;
  }

}
