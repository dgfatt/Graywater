package com.tumblr.example.binder;

import android.support.annotation.NonNull;
import com.tumblr.example.R;
import com.tumblr.example.model.Primitive;
import com.tumblr.example.viewholder.TextPrimitiveViewHolder;
import com.tumblr.graywater.GraywaterAdapter;

import java.util.List;

/**
 * Created by ericleong on 3/13/16.
 */
public class TextPrimitiveBinder<U extends Primitive.Text> implements GraywaterAdapter.Binder<U, TextPrimitiveViewHolder> {

	@Override
	public int getViewType(final U model) {
		return R.layout.item_text;
	}

	@Override
	public void prepare(@NonNull final U model,
	                    final List<GraywaterAdapter.Binder<? super U, ? extends TextPrimitiveViewHolder>> binders,
	                    final int binderIndex) {

	}

	@Override
	public void bind(@NonNull final U model,
	                 @NonNull final TextPrimitiveViewHolder holder,
	                 @NonNull final List<GraywaterAdapter.Binder<? super U, ? extends TextPrimitiveViewHolder>> binders,
	                 final int binderIndex,
	                 @NonNull final GraywaterAdapter.ActionListener<U, TextPrimitiveViewHolder> actionListener) {
		holder.getTextView().setText(model.getString());
	}

	@Override
	public void unbind(@NonNull final TextPrimitiveViewHolder holder) {

	}
}
