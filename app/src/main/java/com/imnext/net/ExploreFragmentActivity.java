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

public class ExploreFragmentActivity extends Fragment {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String como = "";
	private double click = 0;
	
	private ArrayList<HashMap<String, Object>> mapaD = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mapS = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listgenre_movie_series = new ArrayList<>();
	
	private LinearLayout Explore;
	private LinearLayout linear29;
	private LinearLayout linear30;
	private LinearLayout linear31;
	private RecyclerView recyclerview1;
	private LinearLayout linear34;
	private GridView gridview1;
	private LinearLayout linear32;
	private TextView textview18;
	
	private DatabaseReference animes = _firebase.getReference("animes");
	private ChildEventListener _animes_child_listener;
	private Intent internet = new Intent();
	private SharedPreferences sp;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.explore_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		Explore = _view.findViewById(R.id.Explore);
		linear29 = _view.findViewById(R.id.linear29);
		linear30 = _view.findViewById(R.id.linear30);
		linear31 = _view.findViewById(R.id.linear31);
		recyclerview1 = _view.findViewById(R.id.recyclerview1);
		linear34 = _view.findViewById(R.id.linear34);
		gridview1 = _view.findViewById(R.id.gridview1);
		linear32 = _view.findViewById(R.id.linear32);
		textview18 = _view.findViewById(R.id.textview18);
		sp = getContext().getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
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
		_listgenre_movie();
		click = 0;
		como = "Ação";
		_genero();
		recyclerview1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
	}
	
	public void _genero() {
		com.google.firebase.database.Query query = animes.orderByChild("genero").equalTo((como)); 
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { mapaD = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						mapaD.add(_map); } 
					
					//lisview adapter listmap 
					//listview att
					
					gridview1.setAdapter(new Gridview1Adapter(mapaD));
					
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
	}
	
	
	public void _listgenre_movie() {
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Ação");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Animação");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Aventura");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Comédia");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Crime");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Documentário");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Drama");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Família");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Fantasia");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Faroeste");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Ficção científica");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Guerra");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "História");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Mistério");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Romance");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Terror");
			listgenre_movie_series.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("genre", "Hentai");
			listgenre_movie_series.add(_item);
		}
		
		recyclerview1.setAdapter(new Recyclerview1Adapter(listgenre_movie_series));
		recyclerview1.getAdapter().notifyDataSetChanged();
	}
	
	
	public void _ImgRound(final ImageView _imageview, final double _value) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable ();
		gd.setColor(android.R.color.transparent);
		gd.setCornerRadius((int)_value);
		_imageview.setClipToOutline(true);
		_imageview.setBackground(gd);
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.genero, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			textview1.setText(_data.get((int)_position).get("genre").toString());
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					como = _data.get((int)_position).get("genre").toString();
					click = _position;
					recyclerview1.getAdapter().notifyDataSetChanged();
					_genero();
				}
			});
			if (_position == click) {
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFF06C149));
			}
			else {
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFF1F222A));
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
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.capa2, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView image = _view.findViewById(R.id.image);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview1.setText(_data.get((int)_position).get("avaliacao").toString());
			Glide.with(getContext().getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("foto").toString())).into(image);
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
					internet.setClass(getContext().getApplicationContext(), SobreAnimeActivity.class);
					startActivity(internet);
				}
			});
			
			return _view;
		}
	}
}