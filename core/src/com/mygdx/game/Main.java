package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Tooltip;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class Main extends ApplicationAdapter {
	// GMAE VARIABLES
	Random r;
	SpriteBatch batch;

	Zombie zombie;

	// CONTROL VARIABLES
String cannon_type = "a";
	boolean paused;
	// GAME LISTS
	 static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	 static ArrayList<Cannon> cannons = new ArrayList<Cannon>();
	static ArrayList<Button> buttons = new ArrayList<Button>();
	static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	static ArrayList<Effect> effects = new ArrayList<Effect>();


	@Override
	public void create () {
		batch = new SpriteBatch();

		r = new Random();
		setup();


	}

	@Override
	public void render () {

		ScreenUtils.clear(1, 0, 0, 1);
		update();
		batch.begin();
		batch.draw(resources.bg, 0, 0);
		UI.draw(batch);

		for(Zombie z : zombies) z.draw(batch);
		for(Cannon c : cannons) c.draw(batch);
		for(Button b : buttons) b.draw(batch);
		for(Bullet b : bullets) b.draw(batch);
		for(Effect e : effects) e.draw(batch);
		//zombie.draw(batch);

		batch.end();
	}
	void update() {

		tap();
		spawn_zombies();

		if (paused == false) {
			for (Zombie z : zombies) z.update();
			for (Cannon c : cannons) c.update();
			for (Button b : buttons) b.update();
			for (Bullet b : bullets) b.update();
			for (Effect e : effects) e.update();
			housekeeping();
		}
		else{return;}
	}

	void tap() {
		if (Gdx.input.justTouched()) {
			int x = Gdx.input.getX(), y = Gdx.graphics.getHeight() - Gdx.input.getY();
effects.add(new Effect("click",x,y));

			for (Button b : buttons) {


				if (b.gethitbox().contains(x, y)) {
					if(b.type.equals("pause")||b.type.equals("play") ) {

					System.out.println("YOU CLICKED PAUSE");
					paused = !paused;
					b.type = paused ? "play":"pause";


					return;
					}

					if (b.locked) {
						if (b.t.hidden) {
							hidett();
							b.t.hidden = false;
						} else {
							b.locked = false;
							b.t.hidden = true;
						}

					} else {
						cannon_type = b.type;
						deselect();
						b.selected = true;

					}
					return;
				}else if(!b.t.hidden){
					if(b.t.close.gethitbox().contains(x,y)){hidett();return;};
					if(b.t.hitbox().contains(x,y) ) return;
					if(!b.t.hitbox().contains(x,y) ){hidett(); }

				}

			}

					for (Cannon c : cannons) if (c.gethitbox().contains(x, y)) return;
					System.out.println(2);

					if (buildable(x, y))
						if (UI.money >= (Tables.balance.get("get_" + cannon_type) == null ? 10 : Tables.balance.get("get_" + cannon_type))) {
							UI.money -= Tables.balance.get("cost_" + cannon_type) == null ? 10 : Tables.balance.get("cost_" + cannon_type);
							cannons.add(new Cannon(cannon_type, x, y));
						}
					System.out.println(3);


				}
		}

	void hidett(){
		for (Button b : buttons) b.t.hidden = true;
	}
	void deselect(){
		for (Button b:buttons) b.selected = false;
	}
	boolean buildable(int x,int y){ return (x<1000 && ((y<200 || y>300) && y<500)); }

	void setup(){
		paused = false;
		Tables.init();
		//resources.Music.loop(0.3f);
		spawn_zombies();



			buttons.add(new Button("cannon",buttons.size() * 75+200,525 ));
			buttons.get(buttons.size()-1).locked = false;
			buttons.get(buttons.size()-1).selected = true;
			buttons.add(new Button("double",buttons.size() * 75+200,525 ));
			buttons.add(new Button("super",buttons.size() * 75+200,525 ));
			buttons.add(new Button("fire",buttons.size() * 75+200,525 ));
			buttons.add(new Button("laser",buttons.size() * 75+200,525 ));
			buttons.add(new Button("Monkey",buttons.size() * 75+200,525 ));
			buttons.add(new Button("flappy",buttons.size() * 75+200,525 ));



			buttons.add(new Button("pause",1024-75,525 ));
			buttons.get(buttons.size()-1).locked = false;
			buttons.get(buttons.size()-1).selected = false;



	}
	void housekeeping(){
		for(Zombie z : zombies) if(!z.active) { zombies.remove(z); break; }
		for(Bullet b : bullets) if(!b.active) { bullets.remove(b); break; }
		for(Effect e : effects) if(!e.active) { effects.remove(e); break; }

	}
	void spawn_zombies() {
		String Zombie_type = "";
		if(!zombies.isEmpty()) return;
		UI.wave++;
		for( int i=0; i < 8*UI.wave; i++){

			int randomnumber = r.nextInt()%8;
			if (randomnumber == 1) {Zombie_type="dif";}
			else if(randomnumber == 2){Zombie_type="zzz";}
			else if(randomnumber == 3){Zombie_type="speedy";}
			else if(randomnumber == 4){Zombie_type="riot";}
			else if(randomnumber == 5){Zombie_type="zzz";}
			else if(randomnumber == 6){Zombie_type="fast";}
			else if(randomnumber == 7){Zombie_type="peng";}

			zombies.add(new Zombie(Zombie_type,1024+i*50 ,r.nextInt(450), 1));


		}
	}
	// End of File
	@Override
	public void dispose () {
		batch.dispose();

	}
}
