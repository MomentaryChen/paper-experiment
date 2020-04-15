package com.example.hw2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CheckerTest {
    Checker checker = new Checker();
    @Test
    public void accountIsNull() {
        AccountState as = checker.checkAccount("");
        assertEquals(as, AccountState.IS_NULL);
    }
    @Test
    public void accountIsNotEmail() {
        AccountState as = checker.checkAccount("zxcv1234");
        assertEquals(as, AccountState.IS_NOT_EMAIL);
    }
    @Test
    public void accountPass() {
        AccountState as = checker.checkAccount("zxcv1234@gmail.com");
        assertEquals(as, AccountState.PASS);
    }

    @Test
    public void passwordIsNUll() {
        PasswordState ps = checker.checkPassword("");
        assertEquals(ps, PasswordState.IS_NULL);
    }
    @Test
    public void passwordIsNotGreteEight() {
        PasswordState ps = checker.checkPassword("12345");
        assertEquals(ps, PasswordState.IS_NOT_GREATE_EIGHT);
    }

    @Test
    public void passwordIsNotIncludeNumber() {
        PasswordState ps = checker.checkPassword("zxcvasdasd");
        assertEquals(ps, PasswordState.IS_NOT_INCLUED_NUMBER);
    }

    @Test
    public void passwordIsNotIncludeCapital() {
        PasswordState ps = checker.checkPassword("zxcvasdasd123");
        assertEquals(ps, PasswordState.IS_NOT_INCLUDE_CAPITAL);
    }

    @Test
    public void passwordPass() {
        PasswordState ps = checker.checkPassword("Zxcv123456789");
        assertEquals(ps, PasswordState.PASS);
    }

}