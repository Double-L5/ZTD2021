package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Button {
    int x,y,w,h;
boolean locked = true,selected =false;
    float angle;
    String type;

    Button(String type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
        w= Tables.button_resources.get(type) == null ? 50 :  Tables.button_resources.get(type).getWidth();
        h=Tables.button_resources.get(type) == null ? 50 : Tables.button_resources.get(type).getHeight();;
        angle = 0f;

    }
    void draw(SpriteBatch batch){

        batch.draw((Tables.button_resources.get(type) == null ? resources.button_cannon : Tables.button_resources.get(type)), x,y);
        if(locked){
            batch.draw(resources.locked,x,y);
        }
        if(selected){
            batch.draw(resources.selected,x-7,y-7);
        }
    }
    void update(){
        angle += 10f;
    }
    Rectangle gethitbox(){return new Rectangle(x,y,w,h);}
}
