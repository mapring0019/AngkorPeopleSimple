package com.mapring.social;

import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthError;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public final class ReponseListener extends Activity implements DialogListener {
	
	Context ctx;
	ChangeActivity activity;
	
	public ReponseListener(Context con,ChangeActivity move){
		ctx=con;
		activity=move;
	}
	
	@Override
	public void onComplete(Bundle values) {
		// TODO Auto-generated method stub
		Toast.makeText(ctx, "Logged", Toast.LENGTH_LONG).show();
		activity.changeIntent();
	}

	@Override
	public void onError(SocialAuthError e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBack() {
		// TODO Auto-generated method stub
		
	}

}
