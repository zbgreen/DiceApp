package com.example.diceapp;

import android.app.Activity;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.diceapp.R;

/**
 * Activity subclass that controls the program.
 * @author Zachary Green
 * @version 11/23/14
 */
public class DiceActivity extends Activity
{
	private Die die;
	private Button button;
	private ImageView[] image; 
	private int dieRoll;
	private int previousRoll;
	private boolean firstClick;
	private final int SIZE = 7;
	
	/**
	 * Method that sets up the program.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.Roll);
		die = new Die();
		
		image = new ImageView[SIZE];
		dieRoll = 0;
		previousRoll = 0;
		firstClick = false;
		
		addImages();
		addListenerOnButton();
	}
	
	/**
	 * Inflates the menu; this adds items to the action bar if it is present.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	 * Handle action bar item clicks here. The action bar will
	 * automatically handle clicks on the Home/Up button, so long
	 * as you specify a parent activity in AndroidManifest.xml.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		int id = item.getItemId();
		if (id == R.id.action_settings)
			return true;
		return super.onOptionsItemSelected(item);
	}
	
	/*
	 * Sets up images for this class, sets the die image to visible and the
	 * numbers to gone.
	*/
	private void addImages() 
	{
		image[0] = (ImageView) findViewById(R.id.imageViewLabel);
		image[0].setImageResource(R.drawable.dice);
		
		image[1] = (ImageView) findViewById(R.id.one);
		image[1].setImageResource(R.drawable.r1);
		image[1].setVisibility(View.GONE);
		
	    image[2] = (ImageView) findViewById(R.id.two);
		image[2].setImageResource(R.drawable.r2);
		image[2].setVisibility(View.GONE);

		image[3] = (ImageView) findViewById(R.id.three);
		image[3].setImageResource(R.drawable.r3);
		image[3].setVisibility(View.GONE);

		image[4] = (ImageView) findViewById(R.id.four);
		image[4].setImageResource(R.drawable.r4);
		image[4].setVisibility(View.GONE);

		image[5] = (ImageView) findViewById(R.id.five);
		image[5].setImageResource(R.drawable.r5);
		image[5].setVisibility(View.GONE);

	    image[6] = (ImageView) findViewById(R.id.six);
		image[6].setImageResource(R.drawable.r6);
		image[6].setVisibility(View.GONE);
	}

	/**
	 * Adds a button listener for the roll button.
	 */
	public void addListenerOnButton()
	{
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				die.roll();
				dieRoll = die.getValue();
				setImage();
			}
		});
	}
	
	
	 //Sets the image to the corresponding die roll.
	private void setImage()
	{
		if (firstClick == false)
		{
			firstClick = true;
			image[0].setVisibility(View.GONE);
		}
		image[previousRoll].setVisibility(View.GONE);
		image[dieRoll].setVisibility(View.VISIBLE);
		previousRoll = dieRoll;
	}
}