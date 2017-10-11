package com.tumblr.example.dagger.module;

import com.tumblr.example.ColorsFragment;
import com.tumblr.example.MainActivity;
import com.tumblr.example.dagger.scope.PerActivity;
import com.tumblr.example.dagger.scope.PerFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ericleong on 10/9/17.
 */
@Module
public abstract class AndroidBindingModule {
	@PerActivity
	@ContributesAndroidInjector
	abstract MainActivity contributeMainActivityInjector();

	@PerFragment
	@ContributesAndroidInjector(
			modules = {
					BinderModule.class,
					ViewHolderCreatorModule.class,
					ItemBinderModule.class
			}
	)
	abstract ColorsFragment contributeColorsFragmentInjector();
}
