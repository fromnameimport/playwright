package Pages;

import Base.TestBase;
import com.microsoft.playwright.Locator;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

public class BuzzPage extends TestBase {
    //--------------------------Single elements--------------------------
    Locator newPostInput = page.getByPlaceholder("What's on your mind?");
    Locator postCommentInput = page.getByPlaceholder("Write your comment...");
    Locator sharePostCommentInput = page.getByPlaceholder("What's on your mind?");
    Locator sharePostButton = page.locator("button:text('Share')");
    Locator closeSharePostButton = page.locator("button.oxd-dialog-close-button-position");
    Locator postButton = page.locator("button:text('Post')").nth(0);
    Locator sharePhotosButton = page.locator("button:text('Share Photos')");
    Locator shareVideoButton = page.locator("button:text('Share Video')");
    Locator mostRecentPostsButton = page.locator("button.orangehrm-post-filters-button").nth(0);
    Locator mostLikedPostsButton = page.locator("button.orangehrm-post-filters-button").nth(1);
    Locator mostCommentPostsButton = page.locator("button.orangehrm-post-filters-button").nth(2);
    Locator deletePostButton = page.locator("i.bi-trash");
    Locator cancelDeletingButton = page.locator("div.orangehrm-modal-footer >button").nth(0);
    Locator submitDeletingButton = page.locator("div.orangehrm-modal-footer >button").nth(1);
    Locator editPostButton = page.locator("i.bi-pencil");
    Locator editPostInput = page.locator("div.oxd-buzz-post--composing > textarea");
    Locator postEditedPostButton = page.locator("div.orangehrm-buzz-post-modal-actions > button");
    //--------------------------Multiple elements--------------------------
    Locator commentMoreOptionsButtons =page.locator("i.bi-three-dots");
    Locator posts = page.locator("div.oxd-grid-item--gutters");
    Locator likePostButtons = page.locator("div.orangehrm-buzz-post-actions > div");
    Locator commentButtons = page.locator("i.bi-chat-text-fill");
    Locator sharePostButtons = page.locator("i.bi-share-fill");
    Locator postTexts = page.locator("p.orangehrm-buzz-post-body-text");
    Locator postCommentTexts = page.locator("span.orangehrm-post-comment-text");
    Locator postCommentLikeButtons = page.locator("p.orangehrm-post-comment-action:text('Like')");
    Locator postCommentEditButtons = page.locator("p.orangehrm-post-comment-action:text('Edit')");
    Locator postCommentDeleteButtons = page.locator("p.orangehrm-post-comment-action:text('Delete')");

    //getters
    private int getPostLikesQty(int postNumber) {
        if (postNumber == 0) {
            return Integer.parseInt(StringUtils.
                    getDigits(page.locator("div.orangehrm-buzz-stats-row > p").nth(0).textContent())
            );
        }
        return Integer.parseInt(StringUtils.
                getDigits(page.locator("div.orangehrm-buzz-stats-row > p").nth(postNumber * 3).textContent())
        );
    }
    private int getPostCommentsQty(int postNumber) {
        if (postNumber == 0) {
            return Integer.parseInt(StringUtils.
                    getDigits(page.locator("div.orangehrm-buzz-stats-row > p").nth(1).textContent())
            );
        }
        return Integer.parseInt(StringUtils.
                getDigits(page.locator("div.orangehrm-buzz-stats-row > p").nth(postNumber * 3 + 1).textContent())
        );
    }
    private int getPostSharesQty(int postNumber) {
        if (postNumber == 0) {
            return Integer.parseInt(StringUtils.
                    getDigits(page.locator("div.orangehrm-buzz-stats-row > p").nth(2).textContent())
            );
        }
        return Integer.parseInt(StringUtils.
                getDigits(page.locator("div.orangehrm-buzz-stats-row > p").nth(postNumber * 3 + 2).textContent())
        );
    }

    // Actions
    public void createTextPost(String text) {
        newPostInput.fill(text);
        postButton.click();
    }
    public void createComment(String comment, int postNum) {
        commentButtons.nth(postNum).click();
        postCommentInput.type(comment);
        page.keyboard().press("ENTER");
    }
    public void editLastPost(String text) {
        commentMoreOptionsButtons.nth(0).click();
        editPostButton.click();
        editPostInput.fill(text);
        postEditedPostButton.click();
    }
    public void deleteLastPost() {
        mostRecentPostsButton.click();
        commentMoreOptionsButtons.nth(0).click();
        deletePostButton.click();
        submitDeletingButton.click();
    }

    // Asserts
    public void assertNewPostIsCreated(String postBody) {
        mostRecentPostsButton.click();
        Assert.assertEquals(postTexts.nth(0).textContent(), postBody);
    }
    public void assertNewPostIsEdited(String postBody) {
        mostRecentPostsButton.click();
        page.reload();
        Assert.assertEquals(postTexts.nth(0).textContent(), postBody);
    }
    public void assertNewPostIsDeleted(String postBody) {
        mostRecentPostsButton.click();
        page.reload();
        Assert.assertNotEquals(postTexts.nth(0).textContent(), postBody);
    }
}
