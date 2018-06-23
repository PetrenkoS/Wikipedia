package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
            TITLE = "id:org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
            OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "xpath://*[@content-desc='Navigate up']",
            NAME_OF_SAVED_ARTICLE = "xpath://*[@text='Learning programming']",
            TITLE_IN_LIST = "id:org.wikipedia:id/page_list_item_title";


    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE,
                "Cannot find article title on page", 15);
    }

    public WebElement waitForTitleInListElement() {
        return this.waitForElementPresent(TITLE_IN_LIST,
                "Cannot find article title on list page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public String getArticleTitleInList() {
        WebElement title_element = waitForTitleInListElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find footer element", 20);
    }

    public void addArticleToMyList(String nameOfFolder) {
        this.waitForElementAndClick(OPTIONS_BUTTON,
                "Cannot find button to open article options",
                15);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find reading list",
                10);
        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                10);
        this.waitForElementAndClear(MY_LIST_NAME_INPUT,
                "Cannot find reading list",
                20);
        this.waitForElementAndSendKeys(MY_LIST_NAME_INPUT,
                nameOfFolder,
                "Cannot type the name of reading list",
                10);
        this.waitForElementAndClick(MY_LIST_OK_BUTTON,
                "Cannot find OK button",
                5);
    }

    public void addArticleToExistingList(String nameOfFolder) {
        this.waitForElementAndClick(OPTIONS_BUTTON,
                "Cannot find button to open article options",
                15);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find reading list",
                10);
        this.waitForElementAndClick(NAME_OF_SAVED_ARTICLE,
                "Cannot find the name of reading list",
                10);

    }


    public void closeArticle() {
        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON,
                "Cannot find Close button",
                5);
    }
}