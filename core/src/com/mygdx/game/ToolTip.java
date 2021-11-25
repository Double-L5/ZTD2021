package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Color;



import java.util.Collection;

public class ToolTip {
    int x,y,w,h;
    String type;
    boolean hidden = true;
    Button close;
    BitmapFont font = new BitmapFont();
    GlyphLayout layout = new GlyphLayout();
    ToolTip(String type,Button parent){
        this.type= type;
        w=200;
        h=100;
        x= (parent.x + parent.w/2) - w/2;
        y=parent.y-h-10;
         close = new Button("close", x + w - resources.button_close.getWidth() - 1, y + h - resources.button_close.getHeight() - 1);
        close.locked = false;
    }
    void draw(SpriteBatch batch){
        if(hidden) return;

        batch.draw(resources.tooltip_bg,x,y,w,h);
        close.draw(batch);
        String[] words = (Tables.tooltips.get(type)==null? "no info avaible..." : Tables.tooltips.get(type)).split(" ");
        int rx = 35,ry =5;
        for(String s:words) {
            if(rx+layout.width>=w-25){
                rx =35;
                ry+=layout.height+5;

            }
            font.setColor(Color.GREEN);
            font.draw(batch,s,x+rx,y+h-ry);
            layout.setText(font," "+s);
            rx+=layout.width;

        }
        font.getData().setScale(1.5f);
        font.setColor(Color.BLACK);
        font.draw(batch,"Unlock:" +(Tables.balance.get("unlock_"+type)==null ?0:Tables.balance.get("unlock_"+type)),x+35+1,y+45-1);
        font.setColor(Color.GOLD);
        font.draw(batch,"Unlock:" +(Tables.balance.get("unlock_"+type)==null ?0:Tables.balance.get("unlock_"+type)),x+35,y+45);
        font.getData().setScale(1.0f);

        font.setColor(Color.WHITE);
        font.draw(batch,"(tap again to unlock)",x+35+1,y+15-1);
        font.setColor(Color.BLACK);
        font.draw(batch,"(tap again to unlock)",x+35,y+15);
    }
    Rectangle hitbox(){return new Rectangle(x,y,w,h);}



    }

