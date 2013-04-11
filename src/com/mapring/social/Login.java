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
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener, ChangeActivity{

	SocialAuthAdapter adapter;
	ImageButton fb,twitter;
	Context ctx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_login);

		fb = (ImageButton) findViewById(R.id.ibFb);
		twitter = (ImageButton) findViewById(R.id.ibTwitter);

		twitter.setOnClickListener(this);
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
		}
		
		if(v==twitter){
			Toast.makeText(this, "Test", Toast.LENGTH_LONG).show();
			adapter.signOut("facebook");
		}
	}

	@Override
	public void changeIntent() {
		// TODO Auto-generated method stub
		Intent intent=new Intent(ctx,Logged.class);
		startActivity(intent);
	}

	@Override
	public void changeLogout() {
		// TODO Auto-generated method stub
		
	}
}
