package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UI {
    static int money = 1000;
    static int wave =0;
    static int life =20;
    static int score =0;
    static BitmapFont font = new BitmapFont();
    static void draw(SpriteBatch batch){
        font.setColor(Color.FIREBRICK);
        font.draw(batch,"Money: " + money,15,585);
        font.setColor(Color.BLUE);
        font.draw(batch,"Wave: " + wave,15,565);
        font.setColor(Color.GREEN);
        font.draw(batch,"Life: " + life,15,545);
        font.setColor(Color.VIOLET);
        font.draw(batch,"Score: " + score,15,525);
    }
}
