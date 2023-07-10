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

//    public static void initPlaywright() {
//        playwright = Playwright.create();
//    }
//    public static void initChromiumContext() {
//        context = playwright.chromium().launch(
//                new BrowserType.LaunchOptions()
//                        .setHeadless(false)
//        ).newContext();
//    }
//    public static void createPage() {
//        page = context.newPage();
//    }

//    public void openPage(String name) {
//        switch (name) {
//            case "Login" -> page.navigate(testData.getLoginPageUrl());
//            case "Admin" -> page.navigate(testData.getAdminPageUrl());
////            case "PIM" -> ;
////            case "Leave" -> leavePageLink.click();
////            case "Time" -> timePageLink.click();
////            case "Recruitment" -> recruitmentPageLink.click();
////            case "My Info" -> myInfoPageLink.click();
////            case "Performance" -> performancePageLink.click();
//            case "Dashboard" -> page.navigate(testData.getDashboardPageUrl());
////            case "Directory" -> directoryPageLink.click();
////            case "Maintenance" -> maintenancePageLink.click();
//            case "Buzz" -> page.navigate(testData.getBuzzPageUrl());
//        }
//    }
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
//    Page page = createPage(playwright);
//    public Playwright initialization() {
//        return Playwright.create();
//    }
//    public Page createPage(Playwright playwright) {
//        BrowserContext context = playwright.chromium().launch(
//                new BrowserType.LaunchOptions()
//                        .setHeadless(false)
//        ).newContext();
//        return context.newPage();
//    }
}
