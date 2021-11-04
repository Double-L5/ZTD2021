package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Cannon {
    Sprite sprite;
    int x,y,w,h;
    int counter =0,delay;
    float angle;
    String type;
    // ANIMATION VARIABLES
    int rows,cols;
    Animation anim;
    TextureRegion[] frames;
    TextureRegion frame;
    float frame_time =0.2f;

    Cannon(String type, int x, int y){
        sprite = new Sprite(Tables.cannon_resources.get(type) == null ? resources.cannon : Tables.cannon_resources.get(type));
        this.type = type;



        w= Tables.cannon_resources.get(type) == null ? 50 :  Tables.cannon_resources.get(type).getWidth();
        h= Tables.cannon_resources.get(type) == null ? 50 :  Tables.cannon_resources.get(type).getHeight();
        delay = Tables.balance.get("delay_"+type)== null? 30:Tables.balance.get("delay_"+type);
        this.x = gridlock(x-w/2);
        this.y = gridlock(y-h/2);
        angle = 0f;
        sprite.setPosition(this.x,this.y);

    }
    void draw(SpriteBatch batch){
sprite.draw(batch);
    }
    void update() {
        angle += 10f;
        if (counter++ > delay) {
            if (!Main.zombies.isEmpty()) {
                fire();
                counter=0;
            }
            sprite.setRotation(calc_angle());
        }
    }
    float  calc_angle(){


        float zx = Main.zombies.get(0).x + (float)Main.zombies.get(0).w/2, zy = Main.zombies.get(0).y+ (float)Main.zombies.get(0).h/2;
        return (float)Math.toDegrees(Math.atan((y-zy)/(x-zx)) +(x>= zx ? Math.PI :0));

    }
    void init_animations(){
        // split texture into idivisual cells
        TextureRegion[][] sheet = TextureRegion.split(Tables.zombie_resources.get(type) == null ? resources.zombie : Tables.zombie_resources.get(type),w, h);
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
 int gridlock(int n){
        return ((int)(n+25)/50) *50;
}
Rectangle gethitbox(){return new Rectangle(x,y,w,h);}
    void fire(){
        resources.sfx_bullet.play(0.2f);
        Main.bullets.add(new Bullet("bbb", x+w/2,y+h/2));

    }

}
