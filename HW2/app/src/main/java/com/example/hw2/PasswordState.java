package com.example.hw2;

public enum PasswordState {
  IS_NULL("isNull"), IS_NOT_GREATE_EIGHT("IsNotGreateThanEight"),
  IS_NOT_INCLUED_NUMBER("isNotIncludeNumber"),
  IS_NOT_INCLUDE_CAPITAL("isNotIncludeCapital"), PASS("pass");

  private String state;

  private PasswordState(String state) {
    this.state = state;
  }

  /**
   * @param state is status String
   * @return status is statusEnum object
   */
  public static PasswordState getStatusEnum(String state) {
    for (PasswordState passwordState : PasswordState.values()) {
      if (passwordState.getState().equals(state)) {
        return passwordState;
      }
    }
    return null;
  }

  public String getState() {
    return this.state;
  }
}
