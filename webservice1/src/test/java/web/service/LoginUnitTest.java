package web.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginUnitTest {
	@Test
    public void testLoginCorrectCredentials() {
        assertTrue("Test with correct credentials", LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testLoginIncorrectUsername() {
        assertFalse("Test with incorrect username", LoginService.login("wrong", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testLoginIncorrectPassword() {
        assertFalse("Test with incorrect password", LoginService.login("ahsan", "wrong_pass", "1990-01-01"));
    }

    @Test
    public void testLoginIncorrectDOB() {
        assertFalse("Test with incorrect DOB", LoginService.login("ahsan", "ahsan_pass", "1990-01-02"));
    }

    @Test
    public void testLoginBoundaryDOBBefore() {
        assertFalse("Boundary test before correct DOB", LoginService.login("ahsan", "ahsan_pass", "1989-12-31"));
    }

    @Test
    public void testLoginBoundaryDOBAfter() {
        assertFalse("Boundary test after correct DOB", LoginService.login("ahsan", "ahsan_pass", "1990-01-02"));
    }

    @Test
    public void testLoginAllIncorrect() {
        assertFalse("Test with all credentials incorrect", LoginService.login("wrong", "wrong_pass", "1988-01-01"));
    }

    @Test
    public void testLoginUsernameCorrectOthersIncorrect() {
        assertFalse("Test with only username correct", LoginService.login("ahsan", "wrong_pass", "1988-01-01"));
    }

    @Test
    public void testLoginDOBIncorrectFormat() {
        assertFalse("Test with DOB in incorrect format", LoginService.login("ahsan", "ahsan_pass", "01-01-1990"));
    }
}