package com.tumblr.example;

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

	private final Map<Class<?>,
			Provider<ItemBinder<
					? extends Primitive,
					? extends PrimitiveViewHolder,
					? extends Binder<? extends Primitive, ? extends PrimitiveViewHolder>>>> mItemBinderMap;

	@Inject
	public PrimitiveAdapter(final Map<Class<? extends PrimitiveViewHolder>, ViewHolderCreator> viewHolderCreatorMapClass,
	                        final Map<Class<?>,
			                        Provider<ItemBinder<
					                        ? extends Primitive,
					                        ? extends PrimitiveViewHolder,
					                        ? extends Binder<? extends Primitive, ? extends PrimitiveViewHolder>>>> itemBinderMap) {

		for (Map.Entry<Class<? extends PrimitiveViewHolder>, ViewHolderCreator> entry : viewHolderCreatorMapClass.entrySet()) {
			register(entry.getValue(), entry.getKey());
		}

		mItemBinderMap = itemBinderMap;
	}

	@Override
	protected ItemBinder getItemBinder(final Primitive model) {
		final Class<? extends Primitive> modelType = getModelType(model);

		return mItemBinderMap.get(modelType).get();
	}

	@Override
	protected Class<? extends Primitive> getModelType(final Primitive model) {
		return model.getClass();
	}
}
