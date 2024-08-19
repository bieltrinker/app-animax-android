package com.imnext.net;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class AvatarActivity extends AppCompatActivity {
	
	private String s = "";
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private RecyclerView recyclerview1;
	private TextView textview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.avatar);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		recyclerview1 = findViewById(R.id.recyclerview1);
		textview1 = findViewById(R.id.textview1);
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF181A20);	w.setNavigationBarColor(0xFF181A20);
		}
		try{
			map = new Gson().fromJson("[{\"link\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVL9lJ8-f6xHZg43fdZ2N98ZqZfe22wnt38Q&amp;usqp=CAU\"}\n{\"link\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZwHnVb8RcQ9ICoVfvdeLdz02oTBChAMayhg&amp;usqp=CAU\"}\n{\"link\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuXlFaApxVnYIYKeRhy9DSRVxJZBVDsEY5qg&amp;usqp=CAU\"}\n{\"link\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqaLvfzfDgKP6Qe6v46i_0yPyzbqqyyoXpQA&amp;usqp=CAU\"}\n{\"link\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVL9lJ8-f6xHZg43fdZ2N98ZqZfe22wnt38Q&amp;usqp=CAU\"}\n{\"link\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqaLvfzfDgKP6Qe6v46i_0yPyzbqqyyoXpQA&amp;usqp=CAU\"}\n{\"link\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVL9lJ8-f6xHZg43fdZ2N98ZqZfe22wnt38Q&amp;usqp=CAU\"}\n{\"link\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZwHnVb8RcQ9ICoVfvdeLdz02oTBChAMayhg&amp;usqp=CAU\"}\n{\"link\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVL9lJ8-f6xHZg43fdZ2N98ZqZfe22wnt38Q&amp;usqp=CAU\"}\n{\"link\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZwHnVb8RcQ9ICoVfvdeLdz02oTBChAMayhg&amp;usqp=CAU\"}]".replace("\\", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			recyclerview1.setAdapter(new Recyclerview1Adapter(map));
			recyclerview1.setLayoutManager(new GridLayoutManager(this, 2));
			
			StaggeredGridLayoutManager staggeredGridManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
			recyclerview1.setLayoutManager(staggeredGridManager);
			SketchwareUtil.showMessage(getApplicationContext(), new Gson().toJson(map));
		}catch(Exception e){
			 
		}
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.foto, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			
			try{
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("link").toString())).into(imageview1);
			}catch(Exception e){
				 
			}
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
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