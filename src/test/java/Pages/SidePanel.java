package Pages;

import Base.TestBase;
import com.microsoft.playwright.Locator;

public class SidePanel extends TestBase {
    Locator searchField = page.getByPlaceholder("Search");
    Locator mainMenuButton = page.locator("button.oxd-main-menu-button");
    Locator mobileOpenMenuButton = page.locator("i.oxd-topbar-header-hamburger");
    Locator mobileCloseMenuButton = page.locator("i.oxd-sidepanel-header-close");
    Locator adminPageLink = page.locator("span:has-text('Admin')");
    Locator pimPageLink = page.locator("span:has-text('PIM')");
    Locator leavePageLink = page.locator("span:has-text('Leave')");
    Locator timePageLink = page.locator("span:has-text('Time')");
    Locator recruitmentPageLink = page.locator("span:has-text('Recruitment')");
    Locator myInfoPageLink = page.locator("span:has-text('My Info')");
    Locator performancePageLink = page.locator("span:has-text('Performance')");
    Locator dashboardPageLink = page.locator("span:has-text('Dashboard')");
    Locator directoryPageLink = page.locator("span:has-text('Directory')");
    Locator maintenancePageLink = page.locator("span:has-text('Maintenance')");
    Locator buzzPageLink = page.locator("span:has-text('Buzz')");

    public SidePanel search(String text) {
        searchField.type(text);
        return this;
    }
    public SidePanel hideShowMenu() {
        mainMenuButton.click();
        return this;
    }
    public void goToPage(String page) {
        switch (page) {
            case "Admin" -> adminPageLink.click();
            case "PIM" -> pimPageLink.click();
            case "Leave" -> leavePageLink.click();
            case "Time" -> timePageLink.click();
            case "Recruitment" -> recruitmentPageLink.click();
            case "My Info" -> myInfoPageLink.click();
            case "Performance" -> performancePageLink.click();
            case "Dashboard" -> dashboardPageLink.click();
            case "Directory" -> directoryPageLink.click();
            case "Maintenance" -> maintenancePageLink.click();
            case "Buzz" -> buzzPageLink.click();
        }
    }
    public SidePanel mobileOpenMenu() {
        mobileOpenMenuButton.click();
        return this;
    }
    public void mobileCloseMenu() {
        mobileCloseMenuButton.click();
    }

}
