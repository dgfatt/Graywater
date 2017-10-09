package com.tumblr.example.dagger.module;

import com.tumblr.example.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ericleong on 10/9/17.
 */
@Module
public abstract class AndroidBindingModule {
	@ContributesAndroidInjector
	abstract MainActivity contributeMainActivityInjector();
}
