package org.finalExamTae.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WatchPage extends BasePage{
    /**
     * Constructor method.
     *
     * @param driver WebDriver
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "section.Carousel")
    private List<WebElement> carousels;

    @FindBy (css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCarouselCard;

    @FindBy (css = "section.lightbox__contentBox")
    private WebElement CarouselPopUp;

    @FindBy (css = ".lightbox__closebtn")
    private WebElement CloseButtonCarouselPopUp;

    /**
     * Allows to get all cards in the second carousel
     * @return List of WebElements
     */
    public List<WebElement> getCadsInSecondCarousel() {
        return carousels.get(1).findElements(By.cssSelector("ul.Carousel__Inner li"));
    }

    /**
     * Verifies if all cards in the second carousel have a title
     * @return true if all cards in the second carousel have a title, false otherwise
     */
    public boolean verifyCardsTitle() {
        List<Boolean> title = new ArrayList<>();
        waitForPresenceOfElements("ul.Carousel__Inner li");
        getCadsInSecondCarousel().stream().forEach(element -> {
            title.add(!element.findElement(By.cssSelector("h2.WatchTile__Title")).getText().equals(""));
        });
        return !title.contains(false);
    }

    /**
     * Verifies if all cards in the second carousel a description.
     * @return true if all cards in the second carousel have a description, false otherwise
     */
    public boolean verifyCardsDescription() {
        List<Boolean> isDescription = new ArrayList<>();
        waitForPresenceOfElements("ul.Carousel__Inner li");
        getCadsInSecondCarousel().stream().forEach(element -> {
            isDescription.add(!element.findElement(By.cssSelector(".WatchTile__Meta")).getText().equals(""));
        });
        return !isDescription.contains(false);
    }

    /**
     * Allows to click on the second card in the first carousel
     */
    public void clickCard() {
        super.waitForVisibility(this.secondCarouselCard);
        super.clickElement(this.secondCarouselCard);
    }

    /**
     * Verifies if the Close button of the modal displayed by clicking a card is visible.
     * @return true if the Close button is displayed, otherwise false
     */
    public boolean closeButtonModalIsDisplayed() {
        super.waitForVisibility(this.CarouselPopUp);
        super.waitForVisibility(this.CloseButtonCarouselPopUp);
        return this.CloseButtonCarouselPopUp.isDisplayed();
    }

    /**
     * Allows to click on the Close button of the modal displayed by clicking a card.
     */
    public void clickOnCloseButtonPopUp() {
        super.waitForVisibility(this.CloseButtonCarouselPopUp);
        super.mouseOver(this.CloseButtonCarouselPopUp);
        super.clickElement(this.CloseButtonCarouselPopUp);
    }

    /**
     * Allows to return to a previous page, 'Home' page in this case.
     * @return
     */
    public HomePage returnToHomePage() {
        super.getDriver().navigate().back();
        return new HomePage(getDriver());
    }
}
