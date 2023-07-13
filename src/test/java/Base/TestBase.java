package Base;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestBase {
    static Playwright playwright = Playwright.create();;
    static BrowserContext context = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        ).newContext();;
    public static Page page = context.newPage();;

    public static void closePage() {
        page.close();
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
