package com.imnext.net;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class CategoriasActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String categorias = "";
	private String genero = "";
	
	private ArrayList<HashMap<String, Object>> mapa = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private GridView gridview1;
	private ImageView imageview1;
	private TextView textview1;
	
	private DatabaseReference animes = _firebase.getReference("animes");
	private ChildEventListener _animes_child_listener;
	private SharedPreferences sp;
	private Intent internet = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.categorias);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		gridview1 = findViewById(R.id.gridview1);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		_animes_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		animes.addChildEventListener(_animes_child_listener);
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF181A20);	w.setNavigationBarColor(0xFF181A20);
		}
		if (getIntent().getStringExtra("categorias").equals("categorias")) {
			categorias = getIntent().getStringExtra("categorias");
			genero = getIntent().getStringExtra("gênero");
			textview1.setText(getIntent().getStringExtra("gênero"));
			_categ();
		}
		else {
			if (getIntent().getStringExtra("categorias").equals("genero")) {
				categorias = getIntent().getStringExtra("categorias");
				genero = getIntent().getStringExtra("gênero");
				textview1.setText(getIntent().getStringExtra("gênero"));
				_categ();
			}
		}
	}
	
	public void _categ() {
		com.google.firebase.database.Query query = animes.orderByChild(categorias).equalTo((genero)); 
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { mapa = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						mapa.add(_map); } 
					gridview1.setAdapter(new Gridview1Adapter(mapa));
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
	}
	
	
	public void _ImgRound(final ImageView _imageview, final double _value) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable ();
		gd.setColor(android.R.color.transparent);
		gd.setCornerRadius((int)_value);
		_imageview.setClipToOutline(true);
		_imageview.setBackground(gd);
	}
	
	public class Gridview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.capa2, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView image = _view.findViewById(R.id.image);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview1.setText(_data.get((int)_position).get("avaliacao").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("foto").toString())).into(image);
			textview1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFF06C149));
			_ImgRound(image, 16);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sp.edit().putString("nomeD", _data.get((int)_position).get("nome").toString()).commit();
					sp.edit().putString("anoD", _data.get((int)_position).get("ano").toString()).commit();
					sp.edit().putString("fotoD", _data.get((int)_position).get("foto").toString()).commit();
					sp.edit().putString("descricaoD", _data.get((int)_position).get("descricao").toString()).commit();
					sp.edit().putString("episodiosD", _data.get((int)_position).get("episodios").toString()).commit();
					sp.edit().putString("temporadasD", _data.get((int)_position).get("temporadas").toString()).commit();
					sp.edit().putString("banner", _data.get((int)_position).get("banner").toString()).commit();
					sp.edit().putString("classificação", _data.get((int)_position).get("classificação").toString()).commit();
					sp.edit().putString("genero", _data.get((int)_position).get("genero").toString()).commit();
					sp.edit().putString("avaliacao", _data.get((int)_position).get("avaliacao").toString()).commit();
					sp.edit().putString("ID", _data.get((int)_position).get("ID").toString()).commit();
					internet.setClass(getApplicationContext(), SobreAnimeActivity.class);
					startActivity(internet);
				}
			});
			
			return _view;
		}
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