package com.imnext.net;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class AtualizacaoActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView textview1;
	private LinearLayout linear8;
	private TextView textview4;
	private TextView textview5;
	private ImageView imageview1;
	private TextView textview6;
	private LinearLayout linear7;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private TextView textview7;
	
	private Intent in = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.atualizacao);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		textview1 = findViewById(R.id.textview1);
		linear8 = findViewById(R.id.linear8);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		imageview1 = findViewById(R.id.imageview1);
		textview6 = findViewById(R.id.textview6);
		linear7 = findViewById(R.id.linear7);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		textview7 = findViewById(R.id.textview7);
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setAction(Intent.ACTION_VIEW);
				in.setData(Uri.parse(getIntent().getStringExtra("Download")));
				startActivity(in);
			}
		});
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF181A20);	w.setNavigationBarColor(0xFF181A20);
		}
		android.graphics.drawable.GradientDrawable DHFFAGH = new android.graphics.drawable.GradientDrawable();
		DHFFAGH.setColor(Color.parseColor("#FF06C149"));
		DHFFAGH.setCornerRadii(new float[] { 0, 0, 0, 0, 40, 40, 0, 0 });
		linear2.setBackground(DHFFAGH);
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFF06C149));
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}