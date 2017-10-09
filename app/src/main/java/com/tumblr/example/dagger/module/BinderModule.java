package com.tumblr.example.dagger.module;

import com.tumblr.example.binder.ColorNameToastBinder;
import com.tumblr.example.binder.HeaderBinder;
import com.tumblr.example.binder.PaletteColorBinder;
import com.tumblr.example.binder.TextPrimitiveBinder;
import com.tumblr.example.model.ColorNamePrimitive;
import com.tumblr.example.model.Palette;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ericleong on 10/9/17.
 */
@Module
public class BinderModule {
	@Provides
	static TextPrimitiveBinder<ColorNamePrimitive> providesColorNameTextBinder() {
		return new TextPrimitiveBinder<>();
	}
	@Provides
	static ColorNameToastBinder providesColorNameToastBinder() {
		return new ColorNameToastBinder();
	}
	@Provides
	static HeaderBinder providesHeaderBinder() {
		return new HeaderBinder();
	}
	@Provides
	static TextPrimitiveBinder<Palette> providesPaletteTextPrimitiveBinder() {
		return new TextPrimitiveBinder<>();
	}
	@Provides
	static PaletteColorBinder providesPaletteColorBinder() {
		return new PaletteColorBinder();
	}
}
