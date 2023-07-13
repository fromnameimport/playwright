package Pages;

import Base.TestBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;

public class AdminPage extends TestBase {
    // ---------------------------HEADER PANEL---------------------------
    Locator userManagementDropdownButton = page.locator("i.bi-chevron-down").nth(0);
    Locator jobDropdownButton = page.locator("i.bi-chevron-down").nth(1);
    Locator organizationDropdownButton = page.locator("i.bi-chevron-down").nth(2);
    Locator moreOptionsButton = page.locator("i.bi-three-dots-vertical");

    public AdminPage openUserManagementDropdown() {
        userManagementDropdownButton.click();
        return this;
    }
    public AdminPage openJobDropdown() {
        jobDropdownButton.click();
        return this;
    }
    public AdminPage openOrganizationDropdown() {
        organizationDropdownButton.click();
        return this;
    }
    public AdminPage openMoreOptions() {
        moreOptionsButton.click();
        return this;
    }

    // ---------------------------SYSTEM USERS---------------------------
    Locator openSystemUsersButton = page.locator("div.--toggle button i.bi-caret-down-fill");
    Locator systemUsersContainer = page.locator("div.oxd-table-filter-area");
    Locator systemUsersUserNameInput = page.locator("div:nth-child(2) > input");
    Locator systemUsersEmployeeNameInput = page.getByPlaceholder("Type for hints...");
    Locator systemUsersUserRoleSelect = page.locator("div.oxd-select-text-input").nth(0);
    Locator systemUsersStatusSelect = page.locator("div.oxd-select-text-input").nth(1);
    Locator systemUsersResetButton = page.locator("button:has-text('Reset')");
    Locator systemUsersSearchButton = page.locator("button:has-text('Search')");
    Locator userData = page.locator("div.oxd-padding-cell > div");
    Locator addButton = page.locator("div.orangehrm-header-container > button");
    Locator confirmDeletingButton = page.locator("button:has-text('Yes, Delete')");
    Locator cancelDeletingButton = page.locator("button:has-text('No, Cancel')");
    //multiple elements
    Locator deleteUserButtons = page.locator("button > i.bi-trash");
    Locator usersList = page.locator("div.oxd-table-body > div");

    public void openSystemUsersSearch() {
        String display = (String) systemUsersContainer.evaluate("(element) => window.getComputedStyle(element).getPropertyValue('display')");
        if (!display.equals("block")) {
            openSystemUsersButton.click();
        }
    }
    public void openSaveSystemUserPage() {
        addButton.click();
    }
    private AdminPage enterUsername(String name) {
        systemUsersUserNameInput.type(name);
        return this;
    }
    private AdminPage enterEmployeeName(String name) {
        systemUsersEmployeeNameInput.type(name);
        return this;
    }
    private AdminPage selectUserRole(String userRole) {
        BoundingBox box = systemUsersUserRoleSelect.boundingBox();
        systemUsersUserRoleSelect.click();
        switch (userRole) {
            case "Admin" -> page.mouse().click(box.x + box.width, box.y + box.height + 70);
            case "ESS" -> page.mouse().click(box.x + box.width, box.y + box.height + 100);
        }
        return this;
    }
    private AdminPage selectStatus(String status) {
        BoundingBox box = systemUsersStatusSelect.boundingBox();
        systemUsersStatusSelect.click();
        switch (status) {
            case "Enabled" -> page.mouse().click(box.x + box.width, box.y + box.height + 70);
            case "Disabled" -> page.mouse().click(box.x + box.width, box.y + box.height + 100);
        }
        return this;
    }
    public void submitSearch() {
        systemUsersSearchButton.click();
    }
    public void resetSearch() {
        systemUsersResetButton.click();
    }
    public AdminPage inputSearchData(String username, String employeeName, String userRole, String status) throws InterruptedException {
        enterUsername(username)
                .enterEmployeeName(employeeName)
                .selectUserRole(userRole)
                .selectStatus(status);
        return this;
    }
    public AdminPage deleteSearchedUser() {
        deleteUserButtons.nth(0).click();
        confirmDeletingButton.click();
        return this;
    }

    // getters
    public String getSearchedEmployeeName() {
        return userData.nth(8).textContent();
    }
    public String getSearchedUsername() {
        return userData.nth(6).textContent();
    }
    public String getSearchedUserRole() {
        return userData.nth(7).textContent();
    }
    public String getSearchedUserStatus() {
        return userData.nth(9).textContent();
    }
}