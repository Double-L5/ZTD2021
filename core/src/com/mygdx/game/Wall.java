package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class Wall {
    int x,y,w,h;
    int hp = 10;
    boolean active;
    ArrayList<Cannon> cannons = new ArrayList<Cannon>();

    Wall(int x,int y, boolean mounted){
        this.x=gridlock(x);
        this.y = gridlock(y);
w= resources.wall.getWidth();
h= resources.wall.getHeight();
if(mounted) load_cannons();
    }

    private void load_cannons() {
        for(int i = 0; i<10;i++)cannons.add(new Cannon("mounted",x,y+i*50));
    }
    void update(){
        for (Cannon c : cannons){
            c.update();
            if(!c.active) {cannons.remove(c); break;}
        }
        active = hp >0;
    }
    void draw(SpriteBatch b){
        b.draw(resources.wall,x,y);
        for (Cannon c : cannons) c.draw(b);
    }
    Rectangle gethitbox(){return new Rectangle(x,y,w,h);}
    int gridlock(int n){
        return ((int)(n+25)/50) *50;
    }
}
