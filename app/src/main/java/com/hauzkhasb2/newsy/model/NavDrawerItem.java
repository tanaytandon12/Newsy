package com.hauzkhasb2.newsy.model;

/**
 * Created by tanay on 12/7/15.
 */
public class NavDrawerItem {
    public String name;
    public boolean isSelected;
    public boolean isHeader;
    public String imageUrl;
    public String sub;

    public NavDrawerItem(String name, String imageUrl, boolean isHeader, boolean isSelected) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.isHeader = isHeader;
        this.isSelected = isSelected;
    }

    public NavDrawerItem(String name, String sub, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
        this.sub = sub;
    }

    public NavDrawerItem(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }
}
