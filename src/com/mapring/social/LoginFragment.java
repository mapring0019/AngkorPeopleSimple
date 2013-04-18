package com.mapring.social;

import java.io.Serializable;

import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;

import com.mapring.angkorpeople.Logged;
import com.mapring.angkorpeople.R;
import com.mapring.angkorpeople.R.id;
import com.mapring.angkorpeople.R.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class LoginFragment extends Fragment implements OnClickListener, ChangeActivity {

	ImageButton fb,twitter;
	Context ctx;
	SocialAuthAdapter adapter;
	String logout;

	@SuppressLint("ValidFragment")
	public LoginFragment(Context cn) {
		ctx = cn;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View viewLog = inflater.inflate(R.layout.fragment_login, container,
				false);
		adapter=new SocialAuthAdapter(new ReponseListener(ctx,this));
		
		logout=getArguments().getString("logout");
		
		fb = (ImageButton) viewLog.findViewById(R.id.ibFb);
		twitter=(ImageButton) viewLog.findViewById(R.id.ibTwitter);
		
		twitter.setOnClickListener(this);
		fb.setOnClickListener(this);
		
		return viewLog;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == fb) {
//			Toast.makeText(cxt, "Hi", Toast.LENGTH_SHORT).show();
			adapter.authorize(ctx, Provider.FACEBOOK);
		}
		
		if(v==twitter){
			Toast.makeText(ctx, "Test", Toast.LENGTH_LONG).show();
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
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}
}
