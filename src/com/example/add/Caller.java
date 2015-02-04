package com.example.add;

import android.app.AlertDialog;

public class Caller  extends Thread{
	
	public CallSoap cs;
    public int a,b;
	protected AlertDialog ad; 

    public void run(){
        try{
            cs=new CallSoap();
            String resp=cs.Call(a, b);
            MainActivity.rslt=resp;
        }catch(Exception ex)
        {MainActivity.rslt=ex.toString();}    
    }

}
