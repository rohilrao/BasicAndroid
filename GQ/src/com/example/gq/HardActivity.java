package com.example.gq;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;


public class HardActivity extends Activity {

	private int currentQuestion;
	private String [] questions;
	private String [] answers;
	private Button answerButton;
	private Button questionbutton;
	private TextView questionview;
	private TextView answerView;
	private EditText answerText;
	
	
	
	 
	

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hard);
		// Show the Up button in the action bar.
		setupActionBar();
		init();
		
			
	
	}
	
	public void init() 
	 {
		questions = new String[]{"What is the capital of Egypt?", "What class are you in right now?"}; 
		answers = new String[]{"Cairo","IST380"}; 
		currentQuestion = -1; 
		answerButton = (Button)findViewById(R.id.CheckAnswerButton); 
		questionbutton = (Button)findViewById(R.id.NextquestionButton);
		
	    questionview = (TextView) findViewById(R.id.QuestionTextView); 
		answerView = (TextView) findViewById(R.id.AnswerTextView); 
		answerText = (EditText) findViewById(R.id.AnswerEditView); 
		answerButton.setOnClickListener(new OnClickListener(){ 
			@Override public void onClick(View v) { 
				checkAnswer();
				}
			}); 
		
		questionbutton.setOnClickListener(new OnClickListener(){ 
			
			@Override public void onClick(View v) { 
				showQuestion(); }
			}); 
	 }
	
	
	public void showQuestion() { 
		currentQuestion++; 
		if(currentQuestion == questions.length) 
			currentQuestion =0; 
		    questionview.setText(questions[currentQuestion]); 
		    answerView.setText(""); 
		    answerText.setText(""); 
		    } /* * This method return true if the answer equals to correct answer * (Ignoring case) */ 
	public boolean isCorrect(String answer) 
	{ 
		return (answer.equalsIgnoreCase(answers[currentQuestion])); 
		} /* this method : * 1: Read the text ( answer) from the answerTextEdit * 2: call the isCorrect method * 3: display the appropriate message. */ 
	public void checkAnswer() { 
		String answer = answerText.getText().toString(); 
		if(isCorrect(answer)) 
			answerView.setText("You're right!"); else 
		    answerView.setText("Sorry, the correct answer is "+answers[currentQuestion]); 
		}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hard, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
