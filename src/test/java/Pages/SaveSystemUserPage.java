package Pages;

import Base.TestBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;

public class SaveSystemUserPage extends TestBase {
    Locator usernameInput = page.locator("div:nth-child(2) > input").nth(0);
    Locator passwordInput = page.locator("div:nth-child(2) > input").nth(1);
    Locator confirmPasswordInput = page.locator("div:nth-child(2) > input").nth(2);
    Locator employeeNameInput = page.getByPlaceholder("Type for hints...");
    Locator roleSelect = page.locator("div.oxd-select-text-input").nth(0);
    Locator statusSelect = page.locator("div.oxd-select-text-input").nth(1);
    Locator cancelButton = page.locator("button:has-text('Cancel')");
    Locator saveButton = page.locator("button:has-text('Save')");

    private SaveSystemUserPage enterUsername(String name) {
        usernameInput.type(name);
        return this;
    }
    private SaveSystemUserPage enterEmployeeName(String name) throws InterruptedException {
        BoundingBox box = employeeNameInput.boundingBox();
        employeeNameInput.type(name);
        page.waitForTimeout(3000);
        page.mouse().click(box.x + box.width - 30, box.y + box.height + 20);
        return this;
    }
    private SaveSystemUserPage enterPassword(String password) {
        passwordInput.type(password);
        return this;
    }
    private SaveSystemUserPage confirmPassword(String password) {
        confirmPasswordInput.type(password);
        return this;
    }
    private SaveSystemUserPage selectUserRole(String userRole) {
        BoundingBox box = roleSelect.boundingBox();
        roleSelect.click();
        switch (userRole) {
            case "Admin" -> page.mouse().click(box.x + box.width, box.y + box.height + 70);
            case "ESS" -> page.mouse().click(box.x + box.width, box.y + box.height + 100);
        }
        return this;
    }
    private SaveSystemUserPage selectStatus(String status) {
        BoundingBox box = statusSelect.boundingBox();
        statusSelect.click();
        switch (status) {
            case "Enabled" -> page.mouse().click(box.x + box.width, box.y + box.height + 70);
            case "Disabled" -> page.mouse().click(box.x + box.width, box.y + box.height + 100);
        }
        return this;
    }
    public void saveUser() {
        saveButton.click();
    }
    public void cancelSaving() {
        cancelButton.click();
    }
    public SaveSystemUserPage inputSaveData(String username, String password, String employeeName, String userRole, String status) throws InterruptedException {
        enterUsername(username)
                .enterPassword(password)
                .confirmPassword(password)
                .enterEmployeeName(employeeName)
                .selectUserRole(userRole)
                .selectStatus(status);
        return this;
    }
}
