package com.tumblr.example.dagger.module;

import com.tumblr.example.MainActivity;
import com.tumblr.example.dagger.scope.PerActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ericleong on 10/9/17.
 */
@Module
public abstract class AndroidBindingModule {
	@PerActivity
	@ContributesAndroidInjector(
			modules = {
					BinderModule.class,
					ViewHolderCreatorModule.class,
					ItemBinderModule.class
			}
	)
	abstract MainActivity contributeMainActivityInjector();
}
