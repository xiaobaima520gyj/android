package com.xbm.android.demo.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.xbm.android.demo.R;
import com.xbm.android.demo.fragment.XbmPlayerFragment;
import com.xbm.android.demo.utils.Contact;

import static com.xbm.android.demo.utils.Contact.IndexBarFragment;
import static com.xbm.android.demo.utils.Contact.SwipeMenuFragment;
import com.xbm.android.demo.fragment.SwipeMenuFragment;
import com.xbm.android.demo.fragment.IndexBarFragment;

/**
 * Created by xiaobaima on 17-9-5.
 */

public class DemoFuncActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_func_activity);
		int position = getIntent().getIntExtra("position", 0);
		replaceView(position);
	}

	private void replaceView(int position) {
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		switch (position){
			case Contact.XbmPlayerFragment:
			fragmentTransaction.replace(R.id.demo_content, new XbmPlayerFragment());
			break;
			case Contact.SkidMenuActivity:
				startActivity(new Intent(DemoFuncActivity.this, SkidMenuActivity.class));
				finish();
				return;
			case SwipeMenuFragment:
				fragmentTransaction.replace(R.id.demo_content, new SwipeMenuFragment());
				break;
			case IndexBarFragment:
				fragmentTransaction.replace(R.id.demo_content, new IndexBarFragment());
				break;
		}

		fragmentTransaction.commit();
	}
}
