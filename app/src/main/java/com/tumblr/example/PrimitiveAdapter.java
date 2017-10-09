package com.tumblr.example;

import android.support.annotation.NonNull;
import com.tumblr.example.model.Primitive;
import com.tumblr.example.viewholder.PrimitiveViewHolder;
import com.tumblr.graywater.GraywaterAdapter;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Map;

/**
 * Created by ericleong on 3/13/16.
 */
public class PrimitiveAdapter extends GraywaterAdapter<
		Primitive,
		PrimitiveViewHolder,
		GraywaterAdapter.Binder<? extends Primitive, ? extends PrimitiveViewHolder>,
		Class<? extends Primitive>> {

	private final Map<Integer, ViewHolderCreator> mViewHolderCreatorMap;
	private final Map<Class<?>,
			Provider<ItemBinder<
					? extends Primitive,
					? extends PrimitiveViewHolder,
					? extends Binder<? extends Primitive, ? extends PrimitiveViewHolder>>>> mItemBinderMap;

	@Inject
	public PrimitiveAdapter(final Map<Integer, ViewHolderCreator> viewHolderCreatorMap,
	                        final Map<Class<?>,
			                        Provider<ItemBinder<
					                        ? extends Primitive,
					                        ? extends PrimitiveViewHolder,
					                        ? extends Binder<? extends Primitive, ? extends PrimitiveViewHolder>>>> itemBinderMap) {
		mViewHolderCreatorMap = viewHolderCreatorMap;
		mItemBinderMap = itemBinderMap;
	}

	@Override
	protected ItemBinder getItemBinder(final Primitive model) {
		final Class<? extends Primitive> modelType = getModelType(model);

		return mItemBinderMap.get(modelType).get();
	}

	@NonNull
	@Override
	protected Map<Integer, ViewHolderCreator> getViewHolderCreatorMap() {
		return mViewHolderCreatorMap;
	}

	@Override
	protected Class<? extends Primitive> getModelType(final Primitive model) {
		return model.getClass();
	}
}
