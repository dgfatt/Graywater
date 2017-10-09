package com.tumblr.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tumblr.example.model.ColorNamePrimitive;
import com.tumblr.example.model.Palette;
import com.tumblr.example.model.Primitive;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

		if (recyclerView != null) {
			recyclerView.setLayoutManager(new LinearLayoutManager(this));
			recyclerView.setItemAnimator(new DefaultItemAnimator());

			final PrimitiveAdapter adapter = new PrimitiveAdapter();

			// A header has nothing special
			adapter.add(new Primitive.Header());

			// Reds
			adapter.add(new ColorNamePrimitive(R.color.red_base_variant_0, "dark red"));
			adapter.add(new ColorNamePrimitive(R.color.red_base_variant_1, "red"));
			adapter.add(new ColorNamePrimitive(R.color.red_base_variant_2, "bright red"));
			adapter.add(new ColorNamePrimitive(R.color.red_base_variant_3, "shy red"));
			adapter.add(new ColorNamePrimitive(R.color.red_base_variant_4, "embarrassed red"));
			adapter.add(new Palette("Red Palette", R.color.red_base_variant_0, R.color.red_base_variant_2, R.color.red_base_variant_4));

			adapter.add(new ColorNamePrimitive(R.color.yellow_base_variant_0, "dark yellow"));
			adapter.add(new ColorNamePrimitive(R.color.yellow_base_variant_1, "yellow"));
			adapter.add(new ColorNamePrimitive(R.color.yellow_base_variant_2, "bright yellow"));
			adapter.add(new ColorNamePrimitive(R.color.yellow_base_variant_3, "shy yellow"));
			adapter.add(new ColorNamePrimitive(R.color.yellow_base_variant_4, "embarrassed yellow"));
			adapter.add(new Palette("Yellow Palette",
					R.color.yellow_base_variant_0, R.color.yellow_base_variant_2, R.color.yellow_base_variant_4));

			adapter.add(new ColorNamePrimitive(R.color.green_base_variant_0, "dark green"));
			adapter.add(new ColorNamePrimitive(R.color.green_base_variant_1, "green"));
			adapter.add(new ColorNamePrimitive(R.color.green_base_variant_2, "bright green"));
			adapter.add(new ColorNamePrimitive(R.color.green_base_variant_3, "shy green"));
			adapter.add(new ColorNamePrimitive(R.color.green_base_variant_4, "embarrassed green"));
			adapter.add(new Palette("Green Palette",
							R.color.green_base_variant_0, R.color.green_base_variant_2, R.color.green_base_variant_4));

			adapter.add(new ColorNamePrimitive(R.color.blue_base_variant_0, "dark blue"));
			adapter.add(new ColorNamePrimitive(R.color.blue_base_variant_1, "blue"));
			adapter.add(new ColorNamePrimitive(R.color.blue_base_variant_2, "bright blue"));
			adapter.add(new ColorNamePrimitive(R.color.blue_base_variant_3, "shy blue"));
			adapter.add(new ColorNamePrimitive(R.color.blue_base_variant_4, "embarrassed blue"));
			adapter.add(new Palette("Blue Palette",
							R.color.blue_base_variant_0, R.color.blue_base_variant_2, R.color.blue_base_variant_4));

			adapter.add(new ColorNamePrimitive(R.color.purple_base_variant_0, "dark purple"));
			adapter.add(new ColorNamePrimitive(R.color.purple_base_variant_1, "purple"));
			adapter.add(new ColorNamePrimitive(R.color.purple_base_variant_2, "bright purple"));
			adapter.add(new ColorNamePrimitive(R.color.purple_base_variant_3, "shy purple"));
			adapter.add(new ColorNamePrimitive(R.color.purple_base_variant_4, "embarrassed purple"));
			adapter.add(new Palette("Purple Palette",
							R.color.purple_base_variant_0, R.color.purple_base_variant_2, R.color.purple_base_variant_4));

			adapter.add(new Palette("Rainbow",
							R.color.red_base_variant_0, R.color.yellow_base_variant_0, R.color.green_base_variant_0,
							R.color.blue_base_variant_0, R.color.purple_base_variant_0));

			adapter.add(new Palette("Strange Rainbow",
					R.color.red_base_variant_0, R.color.yellow_base_variant_1, R.color.green_base_variant_2,
					R.color.blue_base_variant_3, R.color.purple_base_variant_4));

			recyclerView.setAdapter(adapter);
		}
	}
}
