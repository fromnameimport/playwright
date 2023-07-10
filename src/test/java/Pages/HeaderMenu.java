package Pages;

import Base.TestBase;
import com.microsoft.playwright.Locator;

public class HeaderMenu extends TestBase {
    Locator profileDropdownButton = page.locator("i.oxd-userdropdown-icon");
    Locator helpButton = page.locator("div.oxd-topbar-body-nav-slot button.oxd-icon-button");
    Locator aboutDropdownItem = page.locator("a:text('About')");
    Locator supportDropdownItem = page.locator("a:text('Support')");
    Locator changePasswordDropdownItem = page.locator("a:text('Change password')");
    Locator logoutDropdownItem = page.locator("a:text('Logout')");
    Locator adminName = page.locator("p.oxd-userdropdown-name");

    //------------------------Actions----------------------------
    public HeaderMenu openProfileDropdown() {
        profileDropdownButton.click();
        return this;
    }
    public void selectProfileDropdownOption(String option) {
        switch (option) {
            case "About" -> aboutDropdownItem.click();
            case "Support" -> supportDropdownItem.click();
            case "Change password" -> changePasswordDropdownItem.click();
            case "Logout" -> logoutDropdownItem.click();
        }
    }
    public void clickHelpButton() {
        helpButton.click();
    }
    public void logout() {
        profileDropdownButton.click();
        logoutDropdownItem.click();
    }

    //------------------------Getters----------------------------
    public String getCurrentAdminName() {
        return adminName.textContent();
    }
}
