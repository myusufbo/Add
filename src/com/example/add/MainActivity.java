package com.example.add;



import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	public static String rslt="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 Button b1=(Button)findViewById(R.id.button1);
	       final  AlertDialog ad=new AlertDialog.Builder(this).create();
	         
	        b1.setOnClickListener(new OnClickListener() { 
	@Override
	public void onClick(View arg0) {
	// TODO Auto-generated method stub
		  try
        { 
            EditText ed1=(EditText)findViewById(R.id.editText1);
            EditText ed2=(EditText)findViewById(R.id.editText2); 
            int a=Integer.parseInt(ed1.getText().toString());
            int b=Integer.parseInt(ed2.getText().toString());
            rslt="START"; 
            //ad=new AlertDialog.Builder(this).create();
            Caller c=new Caller(); c.a=a;
            c.b=b; c.ad=ad;
            c.join(); c.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10); 
                }catch(Exception ex) {
                }
            }
            ad.setTitle("RESULT OF ADD of "+a+" and "+b);
            ad.setMessage(rslt); 
        }catch(Exception ex) {
            ad.setTitle("Error!"); ad.setMessage(ex.toString());
        }
        ad.show(); 
    } });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
