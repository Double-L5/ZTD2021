package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UI {
    static int money = 99999;
    static int wave =0;
    static BitmapFont font = new BitmapFont();
    static void draw(SpriteBatch batch){
        font.setColor(Color.FIREBRICK);
        font.draw(batch,"Money: " + money,15,585);
        font.setColor(Color.BLUE);
        font.draw(batch,"Wave: " + wave,15,565);
    }
}
