package com.example.a10117203;
//12-05-2020,10117203,Randi Tumbur Arjuna,IF7
public class ScreenItem {
    String Title,Description;
    int ScreenImg;

    public ScreenItem(String title, String description, int screenImg){
        Title = title;
        Description = description;
        ScreenImg = screenImg;
    }

    public void setTitle(String title){
        Title = title;
    }

    public void setDescription(String description){
        Description = description;
    }

    public String getTitle(){
        return Title;
    }

    public String getDescription(){
        return Description;
    }

    public int getScreenImg(){
        return ScreenImg;
    }
}

