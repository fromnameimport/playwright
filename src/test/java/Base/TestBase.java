package Base;

import Util.ConfigProperties;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestBase {
    static Playwright playwright;
    static BrowserContext context;
    public static Page page;
    public static void initialize() {
        ConfigProperties.initializePropertyFile();
        String browserType = ConfigProperties.properties.getProperty("BrowserType");

        playwright = Playwright.create();
        switch (browserType) {
            case "Chrome" -> context = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            ).newContext();
            case "Firefox" -> context = playwright.firefox().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            ).newContext();
            case "Safari" -> context = playwright.webkit().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            ).newContext();
        }
        page = context.newPage();
    }

    public static void closePage() {
        page.close();
    }

    public String getPageTitleText() {
        return page.locator("span.oxd-topbar-header-breadcrumb > h6").textContent();
    }
    public String getLoginPageUrl() {
        return "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    }
    public String getAdminPageUrl() {
        return "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
    }
    public String getDashboardPageUrl() {
        return "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    }
    public String getBuzzPageUrl() {
        return "https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz";
    }
}
