package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
  TextView feedback;
  Button register;
  Button reset;
  EditText account;
  EditText password;
  EditText comfirmPassword;
  ImageView warning;

  RadioButton man;
  RadioButton woman;
  CheckBox game;
  CheckBox sleep;
  CheckBox daze;
  CheckBox other;

  LoginViewModel loginViewModel = LoginViewModel.getInstance();

  Checker checker = new Checker();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    init();
    setOnClickListener();
  }

  public void init() {
    // TextView
    this.feedback = (TextView) findViewById(R.id.feedbackTextView);
    // Button
    this.register = (Button) findViewById(R.id.register);
    this.reset = (Button) findViewById(R.id.reset);
    // EditText
    this.account = (EditText) findViewById(R.id.editAccount);
    this.password = (EditText) findViewById(R.id.editPassword);
    this.comfirmPassword = (EditText) findViewById(R.id.editCheck);
    // ImageView Default: Invisible
    this.warning = (ImageView) findViewById(R.id.warningImageView);
    this.warning.setVisibility(View.INVISIBLE);
    //RadioButton Default: wowan
    this.man = (RadioButton) findViewById(R.id.manRadioButton);
    this.woman = (RadioButton) findViewById(R.id.womanRadioButton);
    // CheckBox
    this.game = (CheckBox) findViewById(R.id.game);
    this.sleep = (CheckBox) findViewById(R.id.sleep);
    this.daze = (CheckBox) findViewById(R.id.daze);
    this.other = (CheckBox) findViewById(R.id.other);
  }

  void showWarning(String str) {
    this.warning.setVisibility(View.VISIBLE);
    this.feedback.setText(str);
  }


  public void setOnClickListener() {

    register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (checkAccount() && checkPassword() && checkComfirmPassword() && checkInterest()) {
          warning.setVisibility(View.INVISIBLE);
          loginViewModel
            .addUser(new User(account.getText().toString(), password.getText().toString()));
          feedback.setText(account.getText().toString() + " regitster successful");
          finish();
        }
      }
    });

    reset.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        resetAll();
      }
    });
  }

  boolean checkAccount() {
    AccountState state = checker.checkAccount(account.getText().toString());
    switch (state) {
      case IS_NULL: {
        showWarning(getString(R.string.accountNullWarning));
        break;
      }
      case IS_NOT_EMAIL: {
        showWarning(getString(R.string.accountWarning));
        break;
      }
      case PASS: {
        return true;
      }
      default: {
        return false;
      }
    }
    return false;
  }

  boolean checkPassword() {
    String ps = password.getText().toString();
    PasswordState passwordState = checker.checkPassword(ps);
    switch (passwordState) {
      case IS_NULL: {
        showWarning(getString(R.string.passwordNullWarning));
        break;
      }
      case IS_NOT_GREATE_EIGHT: {
        showWarning(getString(R.string.passwordLenWarning));
        break;
      }
      case IS_NOT_INCLUED_NUMBER: {
        showWarning(getString(R.string.passwordIncludeNumberWarning));
        break;
      }
      case IS_NOT_INCLUDE_CAPITAL: {
        showWarning(getString(R.string.passwordIncludeCapitalWarning));
        break;
      }
      case PASS: {
        return true;
      }
      default: {
        return false;
      }
    }
    return false;
  }

  boolean checkComfirmPassword() {
    if (comfirmPassword.getText().toString().equals("")) {
      showWarning(getString(R.string.comfirmNullWarning));
    } else if (!comfirmPassword.getText().toString().equals(password.getText().toString())) {
      showWarning(getString(R.string.comfirmWarning));
    } else {
      return true;
    }
    return false;
  }

  boolean checkInterest() {
    if (game.isChecked() || sleep.isChecked() || daze.isChecked() || other.isChecked()) {
      return true;
    } else {
      showWarning(getString(R.string.InterestWarning));
    }
    return false;
  }

  void resetAll() {
    this.feedback.setText("");
    this.account.setText("");
    this.password.setText("");
    this.comfirmPassword.setText("");
    this.warning.setVisibility(View.INVISIBLE);
  }

}
