package com.example.hw3;

public enum AccountState {
  IS_NULL("isNull"), IS_NOT_EMAIL("IsNotEmail"), PASS("pass");

  private String state;

  private AccountState(String state) {
    this.state = state;
  }

  /**
   * @param state is status String
   * @return status is statusEnum object
   */
  public static AccountState getStatusEnum(String state) {
    for (AccountState accountState : AccountState.values()) {
      if (accountState.getState().equals(state)) {
        return accountState;
      }
    }
    return null;
  }

  public String getState() {
    return this.state;
  }
}
