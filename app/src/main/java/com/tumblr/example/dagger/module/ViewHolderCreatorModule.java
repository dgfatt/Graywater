package com.tumblr.example.dagger.module;

import com.tumblr.example.dagger.key.PrimitiveCreatorKey;
import com.tumblr.example.viewholder.ColorPrimitiveViewHolder;
import com.tumblr.example.viewholder.HeaderViewHolder;
import com.tumblr.example.viewholder.TextPrimitiveViewHolder;
import com.tumblr.example.viewholdercreator.ColorPrimitiveViewHolderCreator;
import com.tumblr.example.viewholdercreator.HeaderViewHolderCreator;
import com.tumblr.example.viewholdercreator.TextPrimitiveViewHolderCreator;
import com.tumblr.graywater.GraywaterAdapter;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * Created by ericleong on 10/9/17.
 */
@Module
public class ViewHolderCreatorModule {
	@Provides
	@IntoMap
	@PrimitiveCreatorKey(TextPrimitiveViewHolder.class)
	static GraywaterAdapter.ViewHolderCreator providesTextPrimitiveViewHolderCreator() {
		return new TextPrimitiveViewHolderCreator();
	}

	@Provides
	@IntoMap
	@PrimitiveCreatorKey(HeaderViewHolder.class)
	static GraywaterAdapter.ViewHolderCreator providesHeaderViewHolderCreator() {
		return new HeaderViewHolderCreator();
	}

	@Provides
	@IntoMap
	@PrimitiveCreatorKey(ColorPrimitiveViewHolder.class)
	static GraywaterAdapter.ViewHolderCreator providesColorPrimitiveViewHolderCreator() {
		return new ColorPrimitiveViewHolderCreator();
	}
}
