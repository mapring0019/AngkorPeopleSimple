package com.mapring.social;

import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;

import com.mapring.angkorpeople.Logged;
import com.mapring.angkorpeople.R;
import com.mapring.angkorpeople.R.id;
import com.mapring.angkorpeople.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener, ChangeActivity{

	SocialAuthAdapter adapter;
	ImageButton fb,twitter;
	Button buttonLog;
	String social;
	Context ctx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_login);

		fb = (ImageButton) findViewById(R.id.ibFb);
		twitter = (ImageButton) findViewById(R.id.ibTwitter);
		buttonLog=(Button)findViewById(R.id.btnLogin);

		twitter.setOnClickListener(this);
		buttonLog.setOnClickListener(this);
		fb.setOnClickListener(this);
		ctx=fb.getContext();
		
		adapter = new SocialAuthAdapter(new ReponseListener(ctx, this));
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		adapter.signOut("facebook");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == fb) {
//			Toast.makeText(cxt, "Hi", Toast.LENGTH_SHORT).show();
			adapter.authorize(ctx, Provider.FACEBOOK);
//			social=adapter.getCurrentProvider().toString();
		}
		
		if(v==twitter){
//			Toast.makeText(this, "Test", Toast.LENGTH_LONG).show();
			adapter.authorize(ctx, Provider.TWITTER);
		}
		
		if(v==buttonLog){
			Toast.makeText(this, adapter.getCurrentProvider().toString(), Toast.LENGTH_LONG).show();
			adapter.signOut(Provider.FACEBOOK.toString());
		}
	}

	public void changeIntent() {
		// TODO Auto-generated method stub
//		Toast.makeText(getApplicationContext(), adapter.getCurrentProvider()+"", Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(ctx,Logged.class);
		startActivity(intent);
	}
}
