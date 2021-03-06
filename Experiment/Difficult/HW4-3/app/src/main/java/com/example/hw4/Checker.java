package com.example.hw4;

public class Checker {

  AccountState checkAccount(String account) {
    String regex = "^(.+)@(.+)$";
    if (account.equals("")) {
      return AccountState.IS_NULL;
    } else if (!account.matches(regex)) {
      return AccountState.IS_NOT_EMAIL;
    }
    return AccountState.PASS;
  }

  PasswordState checkPassword(String password) {
    String regex = "^(.+)[0-9]+.*";
    String regexCapital = "^(.*)[A-Z]+.*";
    if (password.equals("")) {
      return PasswordState.IS_NULL;
    } else if (password.length() <= 8) {
      return PasswordState.IS_NOT_GREATE_EIGHT;
    } else if (!password.matches(regex)) {
      return PasswordState.IS_NOT_INCLUED_NUMBER;
    } else if (!password.matches(regexCapital)) {
      return PasswordState.IS_NOT_INCLUDE_CAPITAL;
    }
    return PasswordState.PASS;
  }

}
