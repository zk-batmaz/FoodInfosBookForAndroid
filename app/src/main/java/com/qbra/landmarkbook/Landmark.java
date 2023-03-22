package com.qbra.landmarkbook;

import java.io.Serializable;

public class Landmark implements Serializable
{
    String name;
    String recipe;
    int img;

    public Landmark(String name, String recipe, int img)
    {
        this.name = name;
        this.recipe = recipe;
        this.img = img;
    }
}

