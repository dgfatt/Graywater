package com.tumblr.example.dagger.component;

import com.tumblr.example.App;
import com.tumblr.example.dagger.module.AndroidBindingModule;
import com.tumblr.example.dagger.module.BinderModule;
import com.tumblr.example.dagger.module.ItemBinderModule;
import com.tumblr.example.dagger.module.ViewHolderCreatorModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by ericleong on 10/9/17.
 */
@Singleton
@Component(modules = {
		AndroidBindingModule.class
})
public interface AppComponent {
	void inject(App app);
}
