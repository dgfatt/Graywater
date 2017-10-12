package com.tumblr.example.dagger.component;

import com.tumblr.example.App;
import com.tumblr.example.dagger.module.ActivityBindingModule;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

/**
 * Created by ericleong on 10/9/17.
 */
@Singleton
@Component(modules = {
		AndroidSupportInjectionModule.class,
		ActivityBindingModule.class
})
public interface AppComponent {
	void inject(App app);
}
