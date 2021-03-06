package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
public class Tables {
    static HashMap<String, Texture> cannon_resources = new HashMap<String,Texture>();
    static HashMap<String, Texture> button_resources = new HashMap<String,Texture>();
    static HashMap<String, Texture> zombie_resources = new HashMap<String,Texture>();
    static HashMap<String, Texture> bullet_resources = new HashMap<String,Texture>();
    static HashMap<String, Integer> balance = new HashMap<String,Integer>();
    static HashMap<String, String> tooltips = new HashMap<String,String>();
    static HashMap<String, Texture> Resources = new HashMap<String,Texture>();
static  void init(){
    cannon_resources.put("fire",resources.cannon_fire);
    cannon_resources.put("toaster",resources.cannon_toaster);
    cannon_resources.put("super",resources.cannon_super);
    cannon_resources.put("laser",resources.cannon_laser);
    cannon_resources.put("double",resources.cannon_double);
    cannon_resources.put("mounted",resources.cannon_mounted);
    cannon_resources.put("Monkey",resources.cannon_Monkey);
    cannon_resources.put("flappy",resources.cannon_flappy);

    button_resources.put("fire",resources.button_cannon_fire);
    button_resources.put("toaster",resources.button_cannon_toaster);
    button_resources.put("super",resources.button_cannon_super);
    button_resources.put("laser",resources.button_cannon_laser);
    button_resources.put("double",resources.button_cannon_double);
    button_resources.put("mounted",resources.button_cannon_mounted);
    button_resources.put("wall",resources.button_wall);
    button_resources.put("Monkey",resources.button_cannon_Monkey);
    button_resources.put("flappy",resources.button_cannon_flappy);
    button_resources.put("play",resources.button_play);
    button_resources.put("pause",resources.button_pause);
    button_resources.put("start",resources.button_start);
    button_resources.put("exit",resources.button_exit);
    button_resources.put("close",resources.button_close);

    zombie_resources.put("fast",resources.zombie_fast);
    zombie_resources.put("dif",resources.zombie_dif);
    zombie_resources.put("speedy",resources.zombie_speedy);
    zombie_resources.put("riot",resources.zombie_riot);
    zombie_resources.put("peng",resources.zombie_peng);
Resources.put("effect_click",resources.click_effect);
Resources.put("bullet_lightning",resources.bullet_lighting);
Resources.put("bullet_flappy",resources.bullet_flappy);
Resources.put("bullet_fire",resources.bullet_fire);
Resources.put("bullet_toaster",resources.bullet_toaster);
Resources.put("bullet_super",resources.bullet_super);
    //tooltip information
    tooltips.put("fire", "Fires high damage bullets at a high rate of fire.");
    tooltips.put("super", " fires low damage bullets at a moderate rate of fire.");
    tooltips.put("laser", "Fires deadly bullets at an extremely low rate of fire.");
    tooltips.put("double", "Fires two low damage bullets at a moderate rate of fire.");
    tooltips.put("mounted", "Spawns a wall with mounted canons");


    balance.put("delay_fire",15);
    balance.put("delay_fire",20);
    balance.put("delay_double",45);
    balance.put("speed_fast",3);
    balance.put("speed_speedy",5);
    balance.put("speed_riot",1);
    balance.put("hp_fast",3);
    balance.put("hp_penguin",2);
    balance.put("hp_speedy",2);
    balance.put("hp_riot",15);
    balance.put("cols_speedy",6);
    balance.put("cols_laser",16);

//placement costs
    balance.put("cost_fire",50);
    balance.put("hp_fire",400);
    balance.put("hp_toaster",350);
    balance.put("hp_double",200);
    balance.put("cost_toaster",30);
    balance.put("cost_double",30);
    balance.put("cost_40",40);
    balance.put("cost_laser",500);
    //unlock costs
    balance.put("unlock_fire",300);
    balance.put("unlock_toaster",250);
    balance.put("unlock_double",250);
    balance.put("unlock_super",500);
    balance.put("unlock_laser",510);


    // animation variables
    balance.put("cols_speedy",6);
    balance.put("cols_laser",16);
    balance.put("cols_click",4);
    balance.put("cols_Monkey",33);






    }
}

