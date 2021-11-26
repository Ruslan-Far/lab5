package org.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SettingsPage
{
    private AndroidDriver androidDriver;
    private SwipesClass swipesClass;

    public SettingsPage(AndroidDriver androidDriver, SwipesClass swipesClass)
    {
        this.androidDriver = androidDriver;
        this.swipesClass = swipesClass;
    }

    public void clickTheme()
    {
        androidDriver.findElementByXPath(ConfProperties.getProperty("themeLocator")).click();
    }

    public void setThemeDark()
    {
        clickTheme();
        androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]").click();
    }

    public void setThemeLight()
    {
        clickTheme();
        androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]").click();
    }

    public MenuPage clickBack()
    {
        androidDriver.findElementByAccessibilityId("Navigate up").click();
        return new MenuPage(androidDriver, swipesClass);
    }

    public void Wait()
    {
        WebDriverWait wait = new WebDriverWait(androidDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConfProperties.getProperty("themeLocator"))));
    }

    public void isDark()
    {
        Assert.assertTrue(androidDriver.findElementByXPath(ConfProperties.getProperty("themeLocator")).getText().equals("Dark"));
    }

    public void isLight()
    {
        Assert.assertTrue(androidDriver.findElementByXPath(ConfProperties.getProperty("themeLocator")).getText().equals("Light"));
    }
}
