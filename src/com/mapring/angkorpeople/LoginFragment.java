package com.mapring.angkorpeople;

import com.mapring.social.SocialLogin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class LoginFragment extends Fragment implements OnClickListener{
	
	ImageButton fb;
	Context cxt;
	
	public LoginFragment(Context cn){
		cxt=cn;
	}
	
	public LoginFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View viewLog = inflater.inflate(R.layout.fragment_login, container,
				false);
		fb=(ImageButton) viewLog.findViewById(R.id.ibFb);
		fb.setOnClickListener(this);
//		viewLog.findViewById(R.id.ibFb).setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(cxt, "Hi", Toast.LENGTH_SHORT).show();
//			}
//		});
		return viewLog;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(cxt, "Hi", Toast.LENGTH_SHORT).show();
		SocialLogin social=new SocialLogin();
	}

//	@Override
//	public void onClick(View v) {
//		// TODO Auto-generated method stub
//		if(v==fb){
//			Toast.makeText(cxt, "Hello", Toast.LENGTH_SHORT).show();
//		}
//	}
}
