package com.tumblr.example;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tumblr.example.model.ColorNamePrimitive;
import com.tumblr.example.model.Palette;
import com.tumblr.example.model.Primitive;
import dagger.android.support.AndroidSupportInjection;

import javax.inject.Inject;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class ColorsFragment extends Fragment {

	@Inject
	PrimitiveAdapter adapter;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ColorsFragment() {
	}

	@SuppressWarnings("unused")
	public static ColorsFragment newInstance() {
		return new ColorsFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_colors_list, container, false);

		// Set the adapter
		if (view instanceof RecyclerView) {
			Context context = view.getContext();
			RecyclerView recyclerView = (RecyclerView) view;
			recyclerView.setLayoutManager(new LinearLayoutManager(context));
			recyclerView.setItemAnimator(new DefaultItemAnimator());

			// A header has nothing special
			adapter.add(new Primitive.Header());

			// Reds
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.red_base_variant_0, "dark red"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.red_base_variant_1, "red"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.red_base_variant_2, "bright red"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.red_base_variant_3, "shy red"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.red_base_variant_4, "embarrassed red"));
			adapter.add(new Palette("Red Palette", com.tumblr.example.R.color.red_base_variant_0, com.tumblr.example.R.color.red_base_variant_2, com.tumblr.example.R.color.red_base_variant_4));

			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.yellow_base_variant_0, "dark yellow"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.yellow_base_variant_1, "yellow"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.yellow_base_variant_2, "bright yellow"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.yellow_base_variant_3, "shy yellow"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.yellow_base_variant_4, "embarrassed yellow"));
			adapter.add(new Palette("Yellow Palette",
					com.tumblr.example.R.color.yellow_base_variant_0, com.tumblr.example.R.color.yellow_base_variant_2, com.tumblr.example.R.color.yellow_base_variant_4));

			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.green_base_variant_0, "dark green"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.green_base_variant_1, "green"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.green_base_variant_2, "bright green"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.green_base_variant_3, "shy green"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.green_base_variant_4, "embarrassed green"));
			adapter.add(new Palette("Green Palette",
					com.tumblr.example.R.color.green_base_variant_0, com.tumblr.example.R.color.green_base_variant_2, com.tumblr.example.R.color.green_base_variant_4));

			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.blue_base_variant_0, "dark blue"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.blue_base_variant_1, "blue"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.blue_base_variant_2, "bright blue"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.blue_base_variant_3, "shy blue"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.blue_base_variant_4, "embarrassed blue"));
			adapter.add(new Palette("Blue Palette",
					com.tumblr.example.R.color.blue_base_variant_0, com.tumblr.example.R.color.blue_base_variant_2, com.tumblr.example.R.color.blue_base_variant_4));

			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.purple_base_variant_0, "dark purple"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.purple_base_variant_1, "purple"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.purple_base_variant_2, "bright purple"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.purple_base_variant_3, "shy purple"));
			adapter.add(new ColorNamePrimitive(com.tumblr.example.R.color.purple_base_variant_4, "embarrassed purple"));
			adapter.add(new Palette("Purple Palette",
					com.tumblr.example.R.color.purple_base_variant_0, com.tumblr.example.R.color.purple_base_variant_2, com.tumblr.example.R.color.purple_base_variant_4));

			adapter.add(new Palette("Rainbow",
					com.tumblr.example.R.color.red_base_variant_0, com.tumblr.example.R.color.yellow_base_variant_0, com.tumblr.example.R.color.green_base_variant_0,
					com.tumblr.example.R.color.blue_base_variant_0, com.tumblr.example.R.color.purple_base_variant_0));

			adapter.add(new Palette("Strange Rainbow",
					com.tumblr.example.R.color.red_base_variant_0, com.tumblr.example.R.color.yellow_base_variant_1, com.tumblr.example.R.color.green_base_variant_2,
					com.tumblr.example.R.color.blue_base_variant_3, com.tumblr.example.R.color.purple_base_variant_4));

			recyclerView.setAdapter(adapter);
		}
		return view;
	}

	@Override
	public void onAttach(Context context) {
		AndroidSupportInjection.inject(this);
		super.onAttach(context);

	}
}
