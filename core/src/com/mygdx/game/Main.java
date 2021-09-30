package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class Main extends ApplicationAdapter {
	// GMAE VARIABLES
	Random r;
	SpriteBatch batch;

	Zombie zombie;

	// CONTROL VARIABLES

	// GAME LISTS
	ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	@Override
	public void create () {
		batch = new SpriteBatch();

		r = new Random();

		for( int i=0; i < 1000; i++){
			zombies.add(new Zombie("zzz",i*50+526 ,r.nextInt(450), 1));
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		update();
		batch.begin();
		batch.draw(resources.bg, 0, 0);
		for(Zombie z : zombies) z.draw(batch);
		//zombie.draw(batch);

		batch.end();
	}
	void update(){
		for(Zombie z : zombies) z.update();
	}
	// End of File
	@Override
	public void dispose () {
		batch.dispose();

	}
}
