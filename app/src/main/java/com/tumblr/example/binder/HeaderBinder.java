package com.tumblr.example.binder;

import android.support.annotation.NonNull;
import com.tumblr.example.R;
import com.tumblr.example.model.Primitive;
import com.tumblr.example.viewholder.HeaderViewHolder;
import com.tumblr.graywater.GraywaterAdapter;

import java.util.List;

/**
 * Created by ericleong on 3/13/16.
 */
public class HeaderBinder implements GraywaterAdapter.Binder<Primitive.Header, HeaderViewHolder> {

	@Override
	public int getViewType(final Primitive.Header model) {
		return R.layout.item_header;
	}

	@Override
	public void prepare(@NonNull final Primitive.Header model,
	                    final List<GraywaterAdapter.Binder<? super Primitive.Header, ? extends HeaderViewHolder>> binders,
	                    final int binderIndex) {

	}

	@Override
	public void bind(@NonNull final Primitive.Header model,
	                 @NonNull final HeaderViewHolder holder,
	                 @NonNull final List<GraywaterAdapter.Binder<? super Primitive.Header, ? extends HeaderViewHolder>> binders,
	                 final int binderIndex,
	                 @NonNull final GraywaterAdapter.ActionListener<Primitive.Header, HeaderViewHolder> actionListener) {

	}

	@Override
	public void unbind(@NonNull final HeaderViewHolder holder) {

	}
}
