package StepDefinitions;

import Base.TestBase;
import Pages.*;
import com.deque.html.axecore.playwright.AxeBuilder;
import com.deque.html.axecore.results.AxeResults;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Steps extends TestBase {
    LoginPage loginPage = new LoginPage();
    SidePanel sidePanel = new SidePanel();
    AdminPage adminPage = new AdminPage();
    HeaderMenu headerMenu = new HeaderMenu();
    BuzzPage buzzPage = new BuzzPage();
    SaveSystemUserPage saveSystemUserPage = new SaveSystemUserPage();

    // ---------------------------Test Data----------------------------
    public static String loginPageUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    String adminPageUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
    String dashboardPageUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    String buzzPageUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz";
    String adminUsername = "Admin";
    String adminRole = "Admin";
    String adminStatus = "Enabled";

    String tempNewPostBody = "";
    String tempSearchedUSerName = "";

    // ---------------------------NAVIGATION---------------------------
    @Given("I open {string} page")
    public void i_open_page(String name) {
        switch (name) {
            case "Login" -> page.navigate(loginPageUrl);
            case "Dashboard" -> page.navigate(dashboardPageUrl);
            case "Admin" -> page.navigate(adminPageUrl);
            case "Buzz" -> page.navigate(buzzPageUrl);
        }
    }
    @Given("I go to {string} page")
    public void i_go_to_page(String pageName) {
        if (pageName.equals("Save system user search")) adminPage.openSaveSystemUserPage();
        else sidePanel.goToPage(pageName);
    }
    @Then("I close page")
    public void i_close_page() {closePage();}
    @Then("I open system user search")
    public void i_open_system_user_search() {
        adminPage.openSystemUsersSearch();
    }

    // ---------------------------VERIFICATION/CHECKS---------------------------
    @Then("I verify that login is successful")
    public void i_verify_that_login_is_successful() {
        Assert.assertEquals(page.url(), dashboardPageUrl);
    }
    @Then("I verify that new post is present")
    public void i_verify_that_new_post_is_present() {
        buzzPage.assertNewPostIsCreated(tempNewPostBody);
    }
    @Then("I verify that new post is edited")
    public void i_verify_that_new_post_is_edited() {
        buzzPage.assertNewPostIsEdited(tempNewPostBody);
    }
    @Then("I verify that new post is deleted")
    public void i_verify_that_new_post_is_deleted() {
        buzzPage.assertNewPostIsDeleted(tempNewPostBody);
    }
    @Then("I verify search results for current admin")
    public void i_verify_search_results_for_current_admin() {
        Assert.assertEquals(adminPage.getSearchedEmployeeName(), headerMenu.getCurrentAdminName());
        Assert.assertEquals(adminPage.getSearchedUsername(), adminUsername);
        Assert.assertEquals(adminPage.getSearchedUserRole(), adminRole);
        Assert.assertEquals(adminPage.getSearchedUserStatus(), adminStatus);
    }
    @Then("I verify search results for user with following credentials: username {string}, user role {string} and status {string}")
    public void i_verify_search_results_for_user_with_following_credentials_username_employee_name_user_role_and_status(String username, String userRole, String status) {
        Assert.assertEquals(adminPage.getSearchedUsername(), username);
        Assert.assertEquals(adminPage.getSearchedUserRole(), userRole);
        Assert.assertEquals(adminPage.getSearchedUserStatus(), status);
    }
    @Then("I check the {string} page for accessibility")
    public void i_check_page_for_accessibility(String pageName) throws IOException {
        AxeResults accessibilityScanResults = null;
        FileWriter fileWriter = new FileWriter("reports/accessibility-violations.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        switch (pageName) {
            case "Login" -> {
                Assert.assertEquals(page.url(), loginPageUrl);
                accessibilityScanResults = new AxeBuilder(page).analyze();
                printWriter.println("------------------Login Page--------------------");
//                accessibilityScanResults.getViolations().forEach(s -> {
//                    printWriter.write(String.valueOf(s));
//                });
            }
            case "Dashboard" -> {
                Assert.assertEquals(page.url(), dashboardPageUrl);
                accessibilityScanResults = new AxeBuilder(page).analyze();
                printWriter.println("------------------Dashboard Page--------------------");
//                accessibilityScanResults.getViolations().forEach(s -> {
//                    printWriter.write(String.valueOf(s));
//                });
            }
            case "Admin" -> {
                Assert.assertEquals(page.url(), adminPageUrl);
                accessibilityScanResults = new AxeBuilder(page).analyze();
                printWriter.println("------------------Admin Page--------------------");
//                accessibilityScanResults.getViolations().forEach(s -> {
//                    printWriter.write(String.valueOf(s));
//                });
            }
            case "Buzz" -> {
                Assert.assertEquals(page.url(), buzzPageUrl);
                accessibilityScanResults = new AxeBuilder(page).analyze();
                printWriter.println("------------------Buzz Page--------------------");

            }
        }
        accessibilityScanResults.getViolations().forEach(s -> {
            printWriter.println(String.valueOf(s));
        });
        printWriter.close();
    }

    // ---------------------------ACTIONS---------------------------
    @Then("I login with following credentials: username {string}, password {string}")
    public void i_login_with_following_credentials(String name, String password) {
        loginPage.login(name, password);
    }
    @Then("I logout")
    public void i_logout() {
        headerMenu.logout();
    }
    @Then("I logged out")
    public void i_logged_out() {
        if (page.url().equals(loginPageUrl)) return;
        headerMenu.logout();
    }
    @Then("I create new post with following body: {string}")
    public void i_create_new_post(String body) {
        tempNewPostBody = body;
        buzzPage.createTextPost(body);
    }
    @Then("I create new user with following credentials: username {string}, password {string}, employee name {string}, user role {string} and status {string}")
    public void i_create_new_user_with_following_credentials_username_password_employee_name_user_role_and_status(String name, String password, String employeeName, String userRole, String status) throws InterruptedException {
        saveSystemUserPage
                .inputSaveData(name, password, employeeName, userRole, status)
                .saveUser();
    }
    @Then("I edit new post with following body: {string}")
    public void i_edit_new_post(String body) {
        tempNewPostBody = body;
        buzzPage.editLastPost(body);
    }
    @Then("I delete new post")
    public void i_delete_new_post() {
        buzzPage.deleteLastPost();
    }
    @Then("I delete searched user")
    public void i_delete_searched_user() {
        adminPage.deleteSearchedUser();
    }
    @Then("I search user with following credentials: username {string}, employee name {string}, user role {string} and status {string}")
    public void i_search_username_employee_name_user_role_and_status(String username, String userRole, String employeeName, String status) throws InterruptedException {
        adminPage
                .inputSearchData(username, userRole, employeeName, status)
                .submitSearch();
    }
    @Then("I search current admin record")
    public void i_search_admin_record_card() throws InterruptedException {
        adminPage
                .inputSearchData(adminUsername, "", adminRole, adminStatus);
        adminPage.submitSearch();
    }
}
