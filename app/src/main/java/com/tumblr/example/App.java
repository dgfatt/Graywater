package com.tumblr.example;

import android.app.Activity;
import android.app.Application;
import com.tumblr.example.dagger.component.AppComponent;
import com.tumblr.example.dagger.component.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import javax.inject.Inject;

/**
 * Created by ericleong on 10/9/17.
 */

public class App extends Application implements HasActivityInjector {

	@Inject
	DispatchingAndroidInjector<Activity> mDispatchingAndroidInjector;

	@Override
	public void onCreate() {
		super.onCreate();
		DaggerAppComponent.create().inject(this);
	}

	@Override
	public AndroidInjector<Activity> activityInjector() {
		return mDispatchingAndroidInjector;
	}
}
