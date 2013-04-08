package com.mapring.angkorpeople;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Main extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PagerAdapter pager=new PagerAdapter(getSupportFragmentManager());
		ViewPager view=(ViewPager) findViewById(R.id.pager);
		view.setAdapter(pager);
	}
	
	public static class PagerAdapter extends FragmentStatePagerAdapter{

		public PagerAdapter(FragmentManager fm) {
			super(fm);
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
				Fragment fragmentLog=new Login();
				return fragmentLog;
			case 2:
				Fragment fragmentSign=new SignUp();
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
	public static class HomeFragment extends Fragment{

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View viewHome=inflater.inflate(R.layout.fragment_home, container, false);
			return viewHome;
		}
	}
	
	public static class Login extends Fragment{

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View viewLog=inflater.inflate(R.layout.fragment_login, container, false);
			return viewLog;
		}
	}
	
	public static class SignUp extends Fragment{

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View viewSign=inflater.inflate(R.layout.fragment_signup, container,false);
			return viewSign;
		}
		
	}
}
