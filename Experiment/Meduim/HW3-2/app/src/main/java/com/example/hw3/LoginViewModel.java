package com.example.hw3;

import android.util.Log;

import java.util.ArrayList;

public class LoginViewModel {
  ArrayList<User> users = new ArrayList();
  static LoginViewModel loginViewModel;

  static LoginViewModel getInstance() {
    if (loginViewModel == null) {
      loginViewModel = new LoginViewModel();
    }
    return loginViewModel;
  }

  void addUser(User user) {
    this.users.add(user);
  }

  Boolean isUser(User user) {
    for (User u : users) {
      if (u.account.equals(user.account) && u.password.equals(user.password)) {
        return true;
      }
    }
    return false;
  }

  void showUser() {
    for (User u : users) {
      Log.v(u.getAccount(), u.getPassword());
    }
  }
}
