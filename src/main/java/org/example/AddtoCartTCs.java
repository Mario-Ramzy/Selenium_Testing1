package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.example.Browser.driver;

public class AddtoCartTCs {
        String price = "$29.99";
        String locator;
        String itemName = "Sauce Labs Backpack";

        @BeforeTest
        public void signIn(){
            SignIn.signInNormalUser();
        }

        @Test
        public void testCase1(){

            //Validate the price
            locator = "//div[@class=\"inventory_item_name \" and contains(.,\"%s\")]/ancestor::div[@class=\"inventory_item\"]//following-sibling::div[@class=\"pricebar\"]/div";
            locator = String.format(locator,itemName);
            By priceSelector = By.xpath(locator);
            WebElement priceOfItem = driver.findElement(priceSelector);
            String foundPrice = priceOfItem.getAttribute("innerHTML");
            Assert.assertEquals(foundPrice,price,"Price Not Valid!");

            //Click add to Cart
            locator = "//div[@class=\"inventory_item_name \" and contains(.,\"%s\")]/ancestor::div[@class=\"inventory_item\"]//following-sibling::div[@class=\"pricebar\"]/button";
            locator = String.format(locator,itemName);
            By addToCartSelector = By.xpath(locator);
            WebElement addToCartButton = driver.findElement(addToCartSelector);
            addToCartButton.click();

            // Open Cart
            By cartLinkSelector = By.className("shopping_cart_link");
            WebElement cartLink = driver.findElement(cartLinkSelector);
            cartLink.click();

            // Check Item in Cart
            locator = "//div[@class=\"cart_item\"]/div[@class=\"cart_item_label\"]/a/div[@class=\"inventory_item_name\" and contains(.,\"%s\")]";
            locator = String.format(locator,itemName);
            By itemsInCartSelector = By.xpath(locator);
            WebElement itemInCart = driver.findElement(itemsInCartSelector);
            String foundItem = itemInCart.getAttribute("innerHTML");
            Assert.assertEquals(foundItem,itemName,"Item Name NOT Matched!");
        }

        @AfterTest
                public void cleanandExit(){
            driver.quit();
        }

}
