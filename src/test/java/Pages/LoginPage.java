package Pages;

import Base.TestBase;
import com.microsoft.playwright.Locator;

public class LoginPage extends TestBase {
    Locator username = page.getByPlaceholder("Username");
    Locator password = page.getByPlaceholder("Password");
    Locator loginButton = page.locator("button:has-text('Login')");
    Locator forgotPasswordLink = page.locator("p:has-text('Forgot your password?')");

    // basic actions
    private LoginPage enterUsername(String username) {
        this.username.type(username);
        return this;
    }
    private LoginPage enterPassword(String password) {
        this.password.type(password);
        return this;
    }
    private LoginPage clickLoginButton() {
        this.loginButton.click();
        return this;
    }
    private LoginPage goToForgotPasswordLink() {
        this.forgotPasswordLink.click();
        return this;
    }

    // complex actions
    public void login(String name, String password) {
        enterUsername(name).enterPassword(password).clickLoginButton();
    }
}
