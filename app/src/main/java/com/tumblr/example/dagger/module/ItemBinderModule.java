package com.tumblr.example.dagger.module;

import com.tumblr.example.binder.ColorNameToastBinder;
import com.tumblr.example.binder.HeaderBinder;
import com.tumblr.example.binder.PaletteColorBinder;
import com.tumblr.example.binder.TextPrimitiveBinder;
import com.tumblr.example.binderlist.ColorNamePrimitiveItemBinder;
import com.tumblr.example.binderlist.HeaderPrimitiveItemBinder;
import com.tumblr.example.binderlist.PaletteItemBinder;
import com.tumblr.example.dagger.key.PrimitiveItemBinderKey;
import com.tumblr.example.dagger.scope.PerActivity;
import com.tumblr.example.model.ColorNamePrimitive;
import com.tumblr.example.model.Palette;
import com.tumblr.example.model.Primitive;
import com.tumblr.example.viewholder.PrimitiveViewHolder;
import com.tumblr.graywater.GraywaterAdapter;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * Created by ericleong on 10/9/17.
 */
@Module
public abstract class ItemBinderModule {

	@PerActivity
	@Provides
	@IntoMap
	@PrimitiveItemBinderKey(ColorNamePrimitive.class)
	static GraywaterAdapter.ItemBinder<
			? extends Primitive,
			? extends PrimitiveViewHolder,
			? extends GraywaterAdapter.Binder<? extends Primitive, ? extends PrimitiveViewHolder>>
	getColorNamePrimitiveItemBinder(final TextPrimitiveBinder<ColorNamePrimitive> colorNameTextBinder,
	                                final ColorNameToastBinder colorNameToastBinder) {

		// A ColorNamePrimitive is composed of a string and a single color
		return new ColorNamePrimitiveItemBinder(colorNameTextBinder, colorNameToastBinder);
	}

	@PerActivity
	@Provides
	@IntoMap
	@PrimitiveItemBinderKey(Primitive.Header.class)
	static GraywaterAdapter.ItemBinder<
			? extends Primitive,
			? extends PrimitiveViewHolder,
			? extends GraywaterAdapter.Binder<? extends Primitive, ? extends PrimitiveViewHolder>>
	getHeaderPrimitiveItemBinder(final HeaderBinder headerBinder) {
		// A header always displays the same text
		return new HeaderPrimitiveItemBinder(headerBinder);
	}

	@PerActivity
	@Provides
	@IntoMap
	@PrimitiveItemBinderKey(Palette.class)
	static GraywaterAdapter.ItemBinder<
			? extends Primitive,
			? extends PrimitiveViewHolder,
			? extends GraywaterAdapter.Binder<? extends Primitive, ? extends PrimitiveViewHolder>>
	getPaletteItemBinder(final TextPrimitiveBinder<Palette> paletteTextPrimitiveBinder,
	                                              final PaletteColorBinder paletteColorBinder) {
		// A palette is composed of a string and a variable number of colors
		return new PaletteItemBinder(paletteTextPrimitiveBinder, paletteColorBinder);
	}
}
