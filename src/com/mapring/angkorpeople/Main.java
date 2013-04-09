package com.mapring.angkorpeople;

import org.brickred.socialauth.android.SocialAuthAdapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class Main extends FragmentActivity {
	
	SocialAuthAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PagerAdapter pager=new PagerAdapter(getSupportFragmentManager(),this);
		ViewPager view=(ViewPager) findViewById(R.id.pager);
		view.setAdapter(pager);
	}
	
	public static class PagerAdapter extends FragmentStatePagerAdapter{
		
		Context cxt;

		public PagerAdapter(FragmentManager fm,Context cn) {
			super(fm);
			cxt=cn;
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			switch(arg0){
			case 0:
				Fragment fragmentHome=new HomeFragment();
				return fragmentHome;
			case 1:
				Fragment fragmentLog=new LoginFragment(cxt);
				return fragmentLog;
			case 2:
				Fragment fragmentSign=new SignUpFragment();
				return fragmentSign;
			}
			return null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0:
				return "Welcome";
			case 1:
				return "Log In";
			case 2:
				return "Sign Up";
			}
			return null;
		}
	}
}
