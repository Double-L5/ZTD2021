package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Effect {
    String type;
    int x,y,w,h;
    boolean active = true;

    //Animation variables
    int rows,cols;
    Animation anim;
    TextureRegion[] frames;
    TextureRegion frame;
    float frame_time = 0.2f;

    Effect(String type,int x,int y){
        this.type = type;
        cols = (Tables.balance.get("cols_"+type)== null ? 1 : Tables.balance.get("cols_"+type));
        rows =1;
        w = (Tables.Resources.get("effect_"+type) == null ? resources.click_effect : Tables.Resources.get("effect_"+type)).getWidth() / cols;
        h = (Tables.Resources.get("effect_"+type) == null ? resources.click_effect : Tables.Resources.get("effect_"+type)).getHeight() / rows;
        this.x=x-w/2;
        this.y=y-h/2;
        init_animations();
    }

    void init_animations(){
        // split texture into idivisual cells
        TextureRegion[][] sheet = TextureRegion.split((Tables.Resources.get("effect_"+type) == null ? resources.click_effect : Tables.Resources.get("effect_"+type)),w, h);
        // init  numbers of frames to maximum number posible (all rows * cols)
        frames = new TextureRegion[rows*cols];
        // loop through texture sheet and fill frames array with cells (in order)
        int index =0;
        for(int r=0; r< rows; r++)
            for(int c=0; c<cols; c++)
                frames[index++] = sheet[r][c];
            anim=new Animation(frame_time,frames);

    }
    void update() {
        active = !anim.isAnimationFinished(frame_time);
    }

    void draw(SpriteBatch batch){
        frame_time += Gdx.graphics.getDeltaTime();
        frame = (TextureRegion)anim.getKeyFrame(frame_time,false);
        batch.draw(frame,x,y);
    }

    }


