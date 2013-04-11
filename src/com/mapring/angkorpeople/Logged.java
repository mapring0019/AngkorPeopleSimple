package com.mapring.angkorpeople;

import org.brickred.socialauth.android.SocialAuthAdapter;

import com.mapring.social.ChangeActivity;
import com.mapring.social.LoginFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

public class Logged extends Activity{
	
	SocialAuthAdapter adapter;
	ChangeActivity activity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logged_in);
		
		Toast.makeText(getApplicationContext(), "abc", Toast.LENGTH_LONG).show();
	}
	
	public void logout(View v){
		Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
//		Intent intent=new Intent(this,Main.class);
//		startActivity(intent);
		finish();
//		activity.changeLogout();
	}
}
