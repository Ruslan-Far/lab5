package org.test;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class BeginPage
{
    private AndroidDriver androidDriver;
    private SwipesClass swipesClass;

    public BeginPage(AndroidDriver androidDriver, SwipesClass swipesClass)
    {
        this.androidDriver = androidDriver;
        this.swipesClass = swipesClass;
    }

    public LoginPage clickYandex()
    {
        androidDriver.findElementById("ru.yandex.mail:id/list_yandex").click();
        return new LoginPage(androidDriver, swipesClass);
    }

    public void isBeginPage()
    {
        Assert.assertTrue(androidDriver.findElementById("ru.yandex.mail:id/list_yandex").isDisplayed());
    }
}
