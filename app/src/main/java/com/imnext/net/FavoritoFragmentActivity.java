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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class FavoritoFragmentActivity extends Fragment {
	
	private ArrayList<HashMap<String, Object>> listgenre_movie_series = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mapS = new ArrayList<>();
	
	private LinearLayout favorito;
	private LinearLayout linear55;
	private LinearLayout linear56;
	private LinearLayout linear_nada;
	private LinearLayout linear57;
	private TextView textview36;
	private GridView gridview2;
	private LinearLayout linear58;
	private ImageView imageview34;
	private TextView textview37;
	private TextView textview38;
	
	private SharedPreferences sp;
	private Intent internet = new Intent();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.favorito_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		favorito = _view.findViewById(R.id.favorito);
		linear55 = _view.findViewById(R.id.linear55);
		linear56 = _view.findViewById(R.id.linear56);
		linear_nada = _view.findViewById(R.id.linear_nada);
		linear57 = _view.findViewById(R.id.linear57);
		textview36 = _view.findViewById(R.id.textview36);
		gridview2 = _view.findViewById(R.id.gridview2);
		linear58 = _view.findViewById(R.id.linear58);
		imageview34 = _view.findViewById(R.id.imageview34);
		textview37 = _view.findViewById(R.id.textview37);
		textview38 = _view.findViewById(R.id.textview38);
		sp = getContext().getSharedPreferences("sp", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		_minha_lista();
	}
	
	public void _minha_lista() {
		if (!sp.getString("listFavoritos", "").equals("")) {
			mapS = new Gson().fromJson(sp.getString("listFavoritos", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			gridview2.setAdapter(new Gridview2Adapter(mapS));
			if (mapS.size() == 0) {
				linear58.setVisibility(View.VISIBLE);
			}
			else {
				linear58.setVisibility(View.GONE);
			}
		}
	}
	
	
	public void _ImgRound(final ImageView _imageview, final double _value) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable ();
		gd.setColor(android.R.color.transparent);
		gd.setCornerRadius((int)_value);
		_imageview.setClipToOutline(true);
		_imageview.setBackground(gd);
	}
	
	public class Gridview2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Gridview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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