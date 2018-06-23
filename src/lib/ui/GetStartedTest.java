package lib.ui;

import lib.CoreTestCase;
import org.junit.Test;


    public class GetStartedTest extends CoreTestCase {

        @Test
        public void testPassThroughWelcome() {
            if(this.Platform.isAndroid()){
                return;
            }

            WelcomePageObject WelcomePage = new WelcomePageObject(driver);
            WelcomePage.waitForLearnMoreLink();
            WelcomePage.clickNextButton();
            WelcomePage.waitForNewWayToExploreText();
            WelcomePage.clickNextButton();
            WelcomePage.waitForAddOrEditPreferredLangText();
            WelcomePage.clickNextButton();
            WelcomePage.waitForLearnMoreAboutDataCollectedText();
            WelcomePage.clickGetStartedButton();
        }

    }

