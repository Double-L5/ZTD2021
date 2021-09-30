package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Zombie {
    int x, y,w,h,speed;
    String type;
    // ANIMATION VARIABLES
    int rows,cols;
    Animation anim;
    TextureRegion[] frames;
    TextureRegion frame;
    float frame_time =0.2f;

    Zombie(String type,int x,int y, int speed){
        this.type=type;
        this.x=x;
        this.y=y;
        this.speed = speed;
        rows = 1;
        cols=4;
        w= resources.zombie.getWidth()/ cols;
        h= resources.zombie.getHeight()/rows;
init_animations();


    }
    void draw(SpriteBatch batch){
        frame_time += Gdx.graphics.getDeltaTime();
        frame = (TextureRegion)anim.getKeyFrame(frame_time,true);
        batch.draw(frame,x,y);

    }
    void update(){
        x -= speed;
    }
    void init_animations(){
        // split texture into idivisual cells
        TextureRegion[][] sheet = TextureRegion.split(resources.zombie,resources.zombie.getWidth()/cols, resources.zombie.getHeight()/ rows);
        // init  numbers of frames to maximum number posible (all rows * cols)
        frames = new TextureRegion[rows*cols];
        // loop through texture sheet and fill frames array with cells (in order)
        int index =0;
        for(int r=0; r< rows; r++)
            for(int c=0; c<cols; c++)
                frames[index++] = sheet[r][c];
            //initialize the animation object
            anim =new Animation(frame_time,frames);
    }
}
