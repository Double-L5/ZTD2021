package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
public class Tables {
    static HashMap<String, Texture> cannon_resources = new HashMap<String,Texture>();
    static HashMap<String, Texture> button_resources = new HashMap<String,Texture>();
    static HashMap<String, Texture> zombie_resources = new HashMap<String,Texture>();
    static HashMap<String, Texture> bullet_resources = new HashMap<String,Texture>();
static  void init(){
    cannon_resources.put("fire",resources.cannon_fire);
    cannon_resources.put("super",resources.cannon_super);
    cannon_resources.put("laser",resources.cannon_laser);
    cannon_resources.put("double",resources.cannon_double);
    cannon_resources.put("mounted",resources.cannon_mounted);

    button_resources.put("fire",resources.button_cannon_fire);
    button_resources.put("super",resources.button_cannon_super);
    button_resources.put("laser",resources.button_cannon_laser);
    button_resources.put("double",resources.button_cannon_double);
    button_resources.put("mounted",resources.button_cannon_mounted);
    button_resources.put("play",resources.button_play);
    button_resources.put("pause",resources.button_pause);
    button_resources.put("start",resources.button_start);
    button_resources.put("exit",resources.button_exit);

    zombie_resources.put("fast",resources.zombie_fast);
    zombie_resources.put("dif",resources.zombie_dif);
    zombie_resources.put("speedy",resources.zombie_speedy);
    zombie_resources.put("riot",resources.zombie_riot);



    }
}

