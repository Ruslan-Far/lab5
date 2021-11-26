package org.test;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class SentPage
{
    private AndroidDriver androidDriver;
    private SwipesClass swipesClass;

    public SentPage(AndroidDriver androidDriver, SwipesClass swipesClass)
    {
        this.androidDriver = androidDriver;
        this.swipesClass = swipesClass;
    }

    public MenuPage openMenu()
    {
        swipesClass.swipeRight();
        return new MenuPage(androidDriver, swipesClass);
    }

    public void isSentPage()
    {
        Assert.assertTrue(androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView").getText().equals("Sent"));
    }
}
