package org.test;

import io.appium.java_client.android.AndroidDriver;

public class MenuPage
{
    private AndroidDriver androidDriver;
    private SwipesClass swipesClass;

    public MenuPage(AndroidDriver androidDriver, SwipesClass swipesClass)
    {
        this.androidDriver = androidDriver;
        this.swipesClass = swipesClass;
    }

    public SentPage clickSent()
    {
        swipesClass.swipeUp();
        androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[1]").click();
        return new SentPage(androidDriver, swipesClass);
    }

    public InboxPage clickInbox()
    {
        swipesClass.swipeUp();
        androidDriver.findElementByAccessibilityId("Folder Inbox: 17 unread").click();
        return new InboxPage(androidDriver, swipesClass);
    }

    public SettingsPage clickSettings()
    {
        swipesClass.swipeDown();
        androidDriver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"Select email\"])[3]").click();
        return new SettingsPage(androidDriver, swipesClass);
    }

    public BeginPage clickLogout()
    {
        swipesClass.swipeDown();
        androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[16]/android.widget.RelativeLayout/android.widget.TextView").click();
        return new BeginPage(androidDriver, swipesClass);
    }

    public void closeMenu()
    {
        swipesClass.swipeLeft();
    }
}
