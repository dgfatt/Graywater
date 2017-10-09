package com.tumblr.example.dagger.module;

import com.tumblr.example.R;
import com.tumblr.example.viewholdercreator.ColorPrimitiveViewHolderCreator;
import com.tumblr.example.viewholdercreator.HeaderViewHolderCreator;
import com.tumblr.example.viewholdercreator.TextPrimitiveViewHolderCreator;
import com.tumblr.graywater.GraywaterAdapter;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

/**
 * Created by ericleong on 10/9/17.
 */
@Module
public class ViewHolderCreatorModule {
	@Provides
	@IntoMap
	@IntKey(R.layout.item_text)
	static GraywaterAdapter.ViewHolderCreator providesTextPrimitiveViewHolderCreator() {
		return new TextPrimitiveViewHolderCreator();
	}

	@Provides
	@IntoMap
	@IntKey(R.layout.item_header)
	static GraywaterAdapter.ViewHolderCreator providesHeaderViewHolderCreator() {
		return new HeaderViewHolderCreator();
	}

	@Provides
	@IntoMap
	@IntKey(R.layout.item_color)
	static GraywaterAdapter.ViewHolderCreator providesColorPrimitiveViewHolderCreator() {
		return new ColorPrimitiveViewHolderCreator();
	}
}
