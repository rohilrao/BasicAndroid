package com.example.gq;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class ModerateActivity extends Activity {

	
	TextView tv;
	Button BNext;
	RadioGroup rg;
	RadioButton rb1,rb2,rb3;
	Button NQ;
	TextView ANS;
	
	String question[]={"A","B","C"};
	String ans[]={"a","b","c"};
	String optn[]={"a","b","c","a","b","c","a","b","c"};
	
	
	int i=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_moderate);
		// Show the Up button in the action bar.
		setupActionBar();
		
		tv = (TextView)findViewById(R.id.AnswerTextView);
		BNext = (Button)findViewById(R.id.NextQuestionButton);
		rg = (RadioGroup)findViewById(R.id.AnsRadioGroup);
		rb1= (RadioButton)findViewById(R.id.radio0);
		rb1= (RadioButton)findViewById(R.id.radio1);
		rb1= (RadioButton)findViewById(R.id.radio2);
		ANS = (TextView)findViewById(R.id.AnsView);
		NQ = (Button)findViewById(R.id.NextquestionButton);
		
		tv.setText(question[i]);
		rb1.setText(optn[0]);
		rb2.setText(optn[1]);
		rb3.setText(optn[2]);
		 
		BNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RadioButton uans = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
			    String ansText = uans.getText().toString();
			    
			    
			     
			    if(ans[i].equalsIgnoreCase(ansText))
			    {
			    	ANS.setText("Correct");
			    }
			    else
			    {
			       ANS.setText("Incorrect");	
			    }
			    
			    i++;
			    
			    
			   
			   	   
			
			   
			    }
		});
		
		NQ.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				while(i<question.length)
				   {
				    tv.setText(question[i]);
				    rb1.setText(optn[i*3]);
				    rb1.setText(optn[(i*3)+1]);
				    rb1.setText(optn[(i*3)+2]);
				    
				    RadioButton uans = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
				    String ansText = uans.getText().toString();
				    
				    if(ans[i].equalsIgnoreCase(ansText))
				    {
				    	ANS.setText("Correct");
				    }
				    else
				    {
				       ANS.setText("Incorrect");	
				    }
				    
				    i++;
				   }
			
			}
		});
		
		
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
		getMenuInflater().inflate(R.menu.moderate, menu);
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
