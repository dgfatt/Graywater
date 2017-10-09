package com.tumblr.example;

import com.tumblr.example.binder.ColorNameToastBinder;
import com.tumblr.example.binder.HeaderBinder;
import com.tumblr.example.binder.PaletteColorBinder;
import com.tumblr.example.binder.TextPrimitiveBinder;
import com.tumblr.example.binderlist.ColorNamePrimitiveItemBinder;
import com.tumblr.example.binderlist.HeaderPrimitiveItemBinder;
import com.tumblr.example.binderlist.PaletteItemBinder;
import com.tumblr.example.model.ColorNamePrimitive;
import com.tumblr.example.model.Palette;
import com.tumblr.example.model.Primitive;
import com.tumblr.example.viewholder.ColorPrimitiveViewHolder;
import com.tumblr.example.viewholder.HeaderViewHolder;
import com.tumblr.example.viewholder.PrimitiveViewHolder;
import com.tumblr.example.viewholder.TextPrimitiveViewHolder;
import com.tumblr.example.viewholdercreator.ColorPrimitiveViewHolderCreator;
import com.tumblr.example.viewholdercreator.HeaderViewHolderCreator;
import com.tumblr.example.viewholdercreator.TextPrimitiveViewHolderCreator;
import com.tumblr.graywater.GraywaterAdapter;

import javax.inject.Inject;

/**
 * Created by ericleong on 3/13/16.
 */
public class PrimitiveAdapter extends GraywaterAdapter<
		Primitive,
		PrimitiveViewHolder,
		GraywaterAdapter.Binder<? extends Primitive, ? extends PrimitiveViewHolder>,
		Class<? extends Primitive>> {

	@Inject
	public PrimitiveAdapter(final TextPrimitiveBinder<ColorNamePrimitive> colorNameTextBinder,
	                        final ColorNameToastBinder colorNameToastBinder,
	                        final HeaderBinder headerBinder,
	                        final TextPrimitiveBinder<Palette> paletteTextPrimitiveBinder,
	                        final PaletteColorBinder paletteColorBinder) {
		register(new TextPrimitiveViewHolderCreator(), TextPrimitiveViewHolder.class);
		register(new HeaderViewHolderCreator(), HeaderViewHolder.class);
		register(new ColorPrimitiveViewHolderCreator(), ColorPrimitiveViewHolder.class);

		// A ColorNamePrimitive is composed of a string and a single color
		final ColorNamePrimitiveItemBinder colorNamePrimitiveBinderList =
				new ColorNamePrimitiveItemBinder(this, colorNameTextBinder, colorNameToastBinder);
		register(ColorNamePrimitive.class, colorNamePrimitiveBinderList, colorNamePrimitiveBinderList);

		// A header always displays the same text
		register(Primitive.Header.class, new HeaderPrimitiveItemBinder(headerBinder), null);

		// A palette is composed of a string and a variable number of colors
		final PaletteItemBinder paletteBinderList =
				new PaletteItemBinder(paletteTextPrimitiveBinder, paletteColorBinder);
		register(Palette.class, paletteBinderList, paletteBinderList);
	}

	@Override
	protected Class<? extends Primitive> getModelType(final Primitive model) {
		return model.getClass();
	}
}
