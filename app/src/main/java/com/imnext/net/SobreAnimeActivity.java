package com.imnext.net;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Vibrator;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class SobreAnimeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double posTe = 0;
	private String temporada = "";
	private double pos = 0;
	private String como = "";
	private String string = "";
	private HashMap<String, Object> Serio = new HashMap<>();
	private double n = 0;
	private String share = "";
	private String atore = "";
	private String c = "";
	private HashMap<String, Object> castres = new HashMap<>();
	private String casts = "";
	private String nomes = "";
	private HashMap<String, Object> mapa = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> listTemporada = new ArrayList<>();
	private ArrayList<String> str = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmapV = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mapaD = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listFavoritos = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Johnson = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listgenre = new ArrayList<>();
	
	private LinearLayout linear15;
	private LinearLayout linear_c;
	private LinearLayout linear17;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear7;
	private TextView text;
	private LinearLayout linear18;
	private LinearLayout linear20;
	private LinearLayout linear37;
	private LinearLayout linear38;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private ImageView banner;
	private LinearLayout linear_img;
	private LinearLayout linear33;
	private LinearLayout linear34;
	private ImageView imageview7;
	private TextView nome;
	private LinearLayout linear35;
	private LinearLayout linear4;
	private ImageView imagev_favoritos;
	private LinearLayout linear5;
	private ImageView imageview3;
	private LinearLayout linear6;
	private ImageView imageview4;
	private TextView avaliacao;
	private LinearLayout linear41;
	private TextView ano;
	private LinearLayout linear40;
	private TextView text_c;
	private LinearLayout linear42;
	private RecyclerView recyclerview3;
	private TextView textview8;
	private ListView Listview1;
	private LinearLayout linear19;
	private Spinner spinner1;
	private RecyclerView episdios;
	private TextView textview11;
	private RecyclerView recyclerview2;
	private LinearLayout linear26;
	private TextView textview9;
	private LinearLayout linear_animes;
	private LinearLayout linear_chat;
	private RecyclerView recyclerview1;
	
	private SharedPreferences sp;
	private DatabaseReference animes = _firebase.getReference("animes");
	private ChildEventListener _animes_child_listener;
	private Vibrator vi;
	private RequestNetwork atores;
	private RequestNetwork.RequestListener _atores_request_listener;
	private DatabaseReference play = _firebase.getReference("play");
	private ChildEventListener _play_child_listener;
	private Intent i = new Intent();
	private TimerTask t;
	private AlertDialog.Builder Dialogo;
	private RequestNetwork animex;
	private RequestNetwork.RequestListener _animex_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.sobre_anime);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear15 = findViewById(R.id.linear15);
		linear_c = findViewById(R.id.linear_c);
		linear17 = findViewById(R.id.linear17);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear7 = findViewById(R.id.linear7);
		text = findViewById(R.id.text);
		linear18 = findViewById(R.id.linear18);
		linear20 = findViewById(R.id.linear20);
		linear37 = findViewById(R.id.linear37);
		linear38 = findViewById(R.id.linear38);
		linear21 = findViewById(R.id.linear21);
		linear22 = findViewById(R.id.linear22);
		banner = findViewById(R.id.banner);
		linear_img = findViewById(R.id.linear_img);
		linear33 = findViewById(R.id.linear33);
		linear34 = findViewById(R.id.linear34);
		imageview7 = findViewById(R.id.imageview7);
		nome = findViewById(R.id.nome);
		linear35 = findViewById(R.id.linear35);
		linear4 = findViewById(R.id.linear4);
		imagev_favoritos = findViewById(R.id.imagev_favoritos);
		linear5 = findViewById(R.id.linear5);
		imageview3 = findViewById(R.id.imageview3);
		linear6 = findViewById(R.id.linear6);
		imageview4 = findViewById(R.id.imageview4);
		avaliacao = findViewById(R.id.avaliacao);
		linear41 = findViewById(R.id.linear41);
		ano = findViewById(R.id.ano);
		linear40 = findViewById(R.id.linear40);
		text_c = findViewById(R.id.text_c);
		linear42 = findViewById(R.id.linear42);
		recyclerview3 = findViewById(R.id.recyclerview3);
		textview8 = findViewById(R.id.textview8);
		Listview1 = findViewById(R.id.Listview1);
		linear19 = findViewById(R.id.linear19);
		spinner1 = findViewById(R.id.spinner1);
		episdios = findViewById(R.id.episdios);
		textview11 = findViewById(R.id.textview11);
		recyclerview2 = findViewById(R.id.recyclerview2);
		linear26 = findViewById(R.id.linear26);
		textview9 = findViewById(R.id.textview9);
		linear_animes = findViewById(R.id.linear_animes);
		linear_chat = findViewById(R.id.linear_chat);
		recyclerview1 = findViewById(R.id.recyclerview1);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		atores = new RequestNetwork(this);
		Dialogo = new AlertDialog.Builder(this);
		animex = new RequestNetwork(this);
		
		imagev_favoritos.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString(sp.getString("nomeD", ""), "").equals("")) {
					_favoritos();
				}
				else {
					_apagar();
				}
				vi.vibrate((long)(30));
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				share = "Venha assistir o ".concat(sp.getString("nome", ""));
				Intent i = new Intent(android.content.Intent.ACTION_SEND);i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT,share); startActivity(Intent.createChooser(i,"share using"));
			}
		});
		
		Listview1.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView abs, int _scrollState) {
				
			}
			
			@Override
			public void onScroll(AbsListView abs, int _firstVisibleItem, int _visibleItemCount, int _totalItemCount) {
				
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				listmapV.clear();
				listmap.clear();
				listmapV = new Gson().fromJson(sp.getString("episodiosD", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				pos = 0;
				for(int _repeat15 = 0; _repeat15 < (int)(listmapV.size()); _repeat15++) {
					if (listTemporada.get((int)_position).get("temporadaT").toString().equals(listmapV.get((int)pos).get("temporadaE").toString())) {
						listmap.add(listmapV.get((int)pos));
						sp.edit().putString("temporadaJ", listTemporada.get((int)_position).get("temporadaT").toString()).commit();
					}
					pos++;
				}
				episdios.setAdapter(new EpisdiosAdapter(listmap));
				
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
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
		
		_atores_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (_response.contains("null")) {
					c = _response.replace("null", "\"N/A\"");
					castres = new Gson().fromJson(c, new TypeToken<HashMap<String, Object>>(){}.getType());
				}
				else {
					castres = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				}
				if (_response.contains("cast")) {
					casts = (new Gson()).toJson(castres.get("cast"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					Johnson = new Gson().fromJson(casts, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					recyclerview2.setAdapter(new Recyclerview2Adapter(Johnson));
					linear_c.setVisibility(View.GONE);
				}
				else {
					
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_play_child_listener = new ChildEventListener() {
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
		play.addChildEventListener(_play_child_listener);
		
		_animex_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				mapa = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				listgenre = new Gson().fromJson(new Gson().toJson(mapa.get("genres")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				recyclerview3.setAdapter(new Recyclerview3Adapter(listgenre));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		_temporadas();
		_episodio();
		como = sp.getString("genero", "");
		_genero();
		imageview4.setColorFilter(0xFF06C149, PorterDuff.Mode.MULTIPLY);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);}
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN); if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { getWindow().setStatusBarColor(Color.TRANSPARENT); }
		_NavStatusBarColor("#00000000", "#FF1F222A");
		Glide.with(getApplicationContext()).load(Uri.parse(sp.getString("banner", ""))).into(banner);
		nome.setText(sp.getString("nomeD", ""));
		ano.setText(sp.getString("anoD", ""));
		avaliacao.setText(sp.getString("avaliacao", ""));
		text_c.setText(sp.getString("classificação", ""));
		episdios.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		recyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		recyclerview2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		recyclerview3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		_Verde12(ano);
		_Verde12(text_c);
		string = sp.getString("descricaoD", "");
		ReadMoreOption rmo = new ReadMoreOption.Builder(this)
		.textLength(200)
		.moreLabel("Ver mais")
		.lessLabel("Ver menos")
		.moreLabelColor(Color.GREEN)
		.lessLabelColor(Color.GREEN)
		.labelUnderLine(true)
		.build();
		rmo.addReadMoreTo(text, string);
		HashMap<String, Object> mapatores = new HashMap<>();
		mapatores.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3ODI4MjMyMTk2NzExOTJjNmFhMzZmZWYzYjYwNzFjMCIsInN1YiI6IjYzYmEwZGQ3YzBhMzA4MDBiODgzYmQxNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.uFU3Lvyf609MIInOP_h6JYKqS6GKJzuhVjQStV3YS6E");
		mapatores.put("accept", "application/json");
		atores.setHeaders(mapatores);
		atores.startRequestNetwork(RequestNetworkController.GET, "https://api.themoviedb.org/3/tv/".concat(sp.getString("ID", "").concat("/credits?language=pt-BR")), "db", _atores_request_listener);
		HashMap<String, Object> mapanimex = new HashMap<>();
		mapanimex.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3ODI4MjMyMTk2NzExOTJjNmFhMzZmZWYzYjYwNzFjMCIsInN1YiI6IjYzYmEwZGQ3YzBhMzA4MDBiODgzYmQxNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.uFU3Lvyf609MIInOP_h6JYKqS6GKJzuhVjQStV3YS6E");
		mapanimex.put("accept", "application/json");
		animex.setHeaders(mapanimex);
		animex.startRequestNetwork(RequestNetworkController.GET, "https://api.themoviedb.org/3/tv/".concat(sp.getString("ID", "").concat("?language=pt-BR")), "db", _animex_request_listener);
		_ja_e_favoritos();
	}
	
	public void _genero() {
		com.google.firebase.database.Query query = animes.orderByChild("genero").equalTo((como)); 
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { mapaD = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						mapaD.add(_map); } 
					
					//lisview adapter listmap 
					//listview att
					
					recyclerview1.setAdapter(new Recyclerview1Adapter(mapaD));
					recyclerview1.getAdapter().notifyDataSetChanged();
					
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
	}
	
	
	public void _Library() {
	}
	public static enum Type {
			MORE,
			LESS
	}
	
	public static interface ReadMoreListener {
			void onClick(Type type);
	}
	public static class ReadMoreOption {
			
			private Context context;
			private boolean labelUnderLine;
			private String lessLabel;
			private int lessLabelColor;
			private String moreLabel;
			private int moreLabelColor;
			private int textLength;
			
			private ReadMoreListener readMoreListenerListener;
			
			public static class Builder {
					
					private Context context;
					private boolean labelUnderLine = false;
					private String lessLabel = "Menos";
					private int lessLabelColor = Color.parseColor("#000000");
					private String moreLabel = "Mais";
					private int moreLabelColor = Color.parseColor("#000000");
					private int textLength = 100;
					
					private ReadMoreListener readMoreListenerListener;
					
					public Builder(Context context) {
							context = context;
					}
					
					public Builder textLength(int length) {
							this.textLength = length;
							return this;
					}
					
					public Builder moreLabel(String moreLabel) {
							this.moreLabel = moreLabel;
							return this;
					}
					
					public Builder lessLabel(String lessLabel) {
							this.lessLabel = lessLabel;
							return this;
					}
					
					public Builder moreLabelColor(int moreLabelColor) {
							this.moreLabelColor = moreLabelColor;
							return this;
					}
					
					public Builder lessLabelColor(int lessLabelColor) {
							this.lessLabelColor = lessLabelColor;
							return this;
					}
					
					public Builder labelUnderLine(boolean labelUnderLine) {
							this.labelUnderLine = labelUnderLine;
							return this;
					}
					
					public Builder setReadMoreListener(ReadMoreListener listener) {
							this.readMoreListenerListener = listener;
							return this;
					}
					
					public ReadMoreOption build() {
							return new ReadMoreOption(this);
					}
			}
			
			private ReadMoreOption(Builder builder) {
					
					context = builder.context;
					textLength = builder.textLength;
					moreLabel = builder.moreLabel;
					lessLabel = builder.lessLabel;
					moreLabelColor = builder.moreLabelColor;
					lessLabelColor = builder.lessLabelColor;
					labelUnderLine = builder.labelUnderLine;
					readMoreListenerListener = builder.readMoreListenerListener;
			}
			
			public void addReadMoreTo(final TextView textView, final String text) {
					if (text.length() <= textLength) {
							textView.setText(text);
							return;
					}
					SpannableString ss = new SpannableString(text.substring(0, textLength) + "... " + moreLabel);
					ss.setSpan(new android.text.style.ClickableSpan() {
							public void onClick(View view) {
									addReadLess(textView, text);
									if (readMoreListenerListener != null) readMoreListenerListener.onClick(Type.MORE);
							}
							
							public void updateDrawState(TextPaint ds) {
									super.updateDrawState(ds);
									ds.setUnderlineText(labelUnderLine);
									ds.setColor(moreLabelColor);
							}
					}, ss.length() - moreLabel.length(), ss.length(), 33);
					textView.setText(ss);
					textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
			}
			
			private void addReadLess(final TextView textView, final String text) {
					SpannableString ss = new SpannableString(text + " " + lessLabel);
					ss.setSpan(new android.text.style.ClickableSpan() {
							public void onClick(View view) {
									new Handler().post(new Runnable() {
											public void run() {
													addReadMoreTo(textView, text);
													if (readMoreListenerListener != null) readMoreListenerListener.onClick(Type.LESS);
											}
									});
							}
							
							public void updateDrawState(TextPaint ds) {
									super.updateDrawState(ds);
									ds.setUnderlineText(labelUnderLine);
									ds.setColor(lessLabelColor);
							}
					}, ss.length() - lessLabel.length(), ss.length(), 33);
					textView.setText(ss);
					textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
			}
			
	}
	
	{
	}
	
	
	public void _NavStatusBarColor(final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _favoritos() {
		if (!sp.getString("listFavoritos", "").equals("")) {
			listFavoritos = new Gson().fromJson(sp.getString("listFavoritos", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		Serio = new HashMap<>();
		Serio.put("nome", sp.getString("nomeD", ""));
		Serio.put("foto", sp.getString("fotoD", ""));
		Serio.put("ano", sp.getString("anoD", ""));
		Serio.put("avaliacao", sp.getString("avaliacao", ""));
		Serio.put("descricao", sp.getString("descricaoD", ""));
		Serio.put("temporadas", sp.getString("temporadasD", ""));
		Serio.put("episodios", sp.getString("episodiosD", ""));
		Serio.put("banner", sp.getString("banner", ""));
		Serio.put("classificação", sp.getString("classificação", ""));
		Serio.put("genero", sp.getString("genero", ""));
		Serio.put("ID", sp.getString("ID", ""));
		listFavoritos.add(Serio);
		sp.edit().putString("listFavoritos", new Gson().toJson(listFavoritos)).commit();
		sp.edit().putString(sp.getString("nomeD", ""), sp.getString("nomeD", "")).commit();
		imagev_favoritos.setImageResource(R.drawable.favorito);
		imagev_favoritos.setColorFilter(0xFF06C149, PorterDuff.Mode.MULTIPLY);
		_Favoritos("Favoritos", "Filme adicionado aos favoritos");
	}
	
	
	public void _apagar() {
		listFavoritos = new Gson().fromJson(sp.getString("listFavoritos", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		n = 0;
		for(int _repeat13 = 0; _repeat13 < (int)(listFavoritos.size()); _repeat13++) {
			if (listFavoritos.get((int)n).get("nome").toString().equals(sp.getString("nomeD", ""))) {
				listFavoritos.remove((int)(n));
				sp.edit().putString("listFavoritos", new Gson().toJson(listFavoritos)).commit();
			}
			n++;
		}
		imagev_favoritos.setImageResource(R.drawable.favorito1);
		imagev_favoritos.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
		sp.edit().remove(sp.getString("nomeD", "")).commit();
		_Favoritos("Removido", "Filme removido dos favoritos");
	}
	
	
	public void _ja_e_favoritos() {
		if (sp.getString(sp.getString("nomeD", ""), "").equals(sp.getString("nomeD", ""))) {
			imagev_favoritos.setImageResource(R.drawable.favorito);
			imagev_favoritos.setColorFilter(0xFF06C149, PorterDuff.Mode.MULTIPLY);
		}
	}
	
	
	public void _linha(final View _view) {
		android.graphics.drawable.GradientDrawable DCFHHEJ = new android.graphics.drawable.GradientDrawable();
		DCFHHEJ.setColor(Color.parseColor("#00000000"));
		DCFHHEJ.setCornerRadius(10);
		DCFHHEJ.setStroke(3, Color.parseColor("#FF06C149"));
		_view.setBackground(DCFHHEJ);
	}
	
	
	public void _Verde12(final View _view) {
		android.graphics.drawable.GradientDrawable GJDAFFB = new android.graphics.drawable.GradientDrawable();
		GJDAFFB.setColor(Color.parseColor("#00000000"));
		GJDAFFB.setCornerRadius(10);
		GJDAFFB.setStroke(3, Color.parseColor("#FF06C149"));
		_view.setBackground(GJDAFFB);
	}
	
	
	public void _Favoritos(final String _set, final String _sets) {
		LayoutInflater Inflater = getLayoutInflater();
		
		View InfView = getLayoutInflater().inflate(R.layout.cxs, null);
		LinearLayout linear_c_ = (LinearLayout) InfView.findViewById(R.id.linear_c_);
		ImageView imageFF = (ImageView) InfView.findViewById(R.id.imageFF);
		TextView Favoritos_FF = (TextView) InfView.findViewById(R.id.Favoritos_FF);
		TextView descrio = (TextView) InfView.findViewById(R.id.descrio);
		Favoritos_FF.setText(_set);
		descrio.setText(_sets);
		imageFF.setClipToOutline(true);
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable ();
		gd.setColor(android.R.color.transparent);
		imageFF.setBackground(gd);
		gd.setCornerRadius((int)100);
		android.graphics.drawable.GradientDrawable BGAHIBI = new android.graphics.drawable.GradientDrawable();
		BGAHIBI.setColor(Color.parseColor("#CD181A20"));
		BGAHIBI.setCornerRadius(100);
		linear_c_.setBackground(BGAHIBI);
		Toast ToastName = Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
		
		ToastName.setView(InfView);
		
		ToastName.show();
	}
	
	
	public void _dialog() {
		final AlertDialog Dg = new AlertDialog.Builder(SobreAnimeActivity.this).create();
		
		View inflate = getLayoutInflater().inflate(R.layout.custon, null);
		Dg.setView(inflate);
		Dg.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		
		final LinearLayout linear1 = (LinearLayout)
		inflate.findViewById(R.id.linear1);
		final LinearLayout linear = (LinearLayout)
		inflate.findViewById(R.id.linear);
		final LinearLayout linear2 = (LinearLayout)
		inflate.findViewById(R.id.linear2);
		final ImageView image13 = (ImageView)
		inflate.findViewById(R.id.image13);
		ListView id = new ListView(this);
		
		id.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
		
		id.setAdapter(new Listview1Adapter(map));
		
		linear2.addView(id);
		id.setOnItemClickListener(new AdapterView.OnItemClickListener() {	@Override	public void onItemClick(AdapterView<?> parent, View view, int _position, long id) {		
				_position = _position;
				if (map.get((int)_position).get("tipo").toString().equals("Link")) {
					i.putExtra("nome", map.get((int)_position).get("anime").toString());
					i.putExtra("player", map.get((int)_position).get("player").toString());
					i.setClass(getApplicationContext(), PlayerVideoActivity.class);
					startActivity(i);
				}
				else {
					if (map.get((int)_position).get("tipo").toString().equals("Web")) {
						i.putExtra("player", map.get((int)_position).get("player").toString());
						i.setClass(getApplicationContext(), WebActivity.class);
						startActivity(i);
					}
				}
				Dg.dismiss();
			}});
		image13.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
								Dg.dismiss();
						}
				});
		
		Dg.show();
	}
	
	
	public void _links() {
		com.google.firebase.database.Query query = play.orderByChild("anime").equalTo((nomes)); 
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { map = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						map.add(_map); } 
					
					//lisview adapter listmap 
					//listview att
					
					Listview1.setAdapter(new Listview1Adapter(map));
					((BaseAdapter)Listview1.getAdapter()).notifyDataSetChanged();
					
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
	}
	
	
	public void _episodio() {
		if (!(sp.getString("episodiosD", "").equals("[]") || sp.getString("episodiosD", "").equals(""))) {
			listmapV = new Gson().fromJson(sp.getString("episodiosD", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			pos = 0;
			for(int _repeat43 = 0; _repeat43 < (int)(listmapV.size()); _repeat43++) {
				if (listTemporada.get((int)0).get("temporadaT").toString().equals(listmapV.get((int)pos).get("temporadaE").toString())) {
					listmap.add(listmapV.get((int)pos));
				}
				pos++;
			}
			episdios.setAdapter(new EpisdiosAdapter(listmap));
			episdios.getAdapter().notifyDataSetChanged();
		}
	}
	
	
	public void _temporadas() {
		if (!(sp.getString("temporadasD", "").equals("[]") || sp.getString("temporadasD", "").equals(""))) {
			listTemporada = new Gson().fromJson(sp.getString("temporadasD", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			posTe = 0;
			for(int _repeat45 = 0; _repeat45 < (int)(listTemporada.size()); _repeat45++) {
				temporada = listTemporada.get((int)posTe).get("temporadaT").toString();
				str.add((int)(posTe), temporada);
				posTe++;
			}
			spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, str));
			spinner1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, str) {
				
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					TextView textView1 = (TextView) super.getView(position, convertView, parent);
					textView1.setTextColor(Color.parseColor("#FF06C149"));
					textView1.setTextSize(14);
					return textView1; }
				
				@Override
				public View getDropDownView(int position, View convertView, ViewGroup parent) {
					TextView textView1 = (TextView) super.getDropDownView(position, convertView, parent); textView1.setTextColor(Color.parseColor("#e0e0e0"));
					textView1.setTextSize(12);
					textView1.setBackgroundColor(Color.parseColor("#212121"));
					return textView1; }
			});
			((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
		}
	}
	
	public class Recyclerview3Adapter extends RecyclerView.Adapter<Recyclerview3Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.gneroklas, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final TextView genero = _view.findViewById(R.id.genero);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			genero.setText(_data.get((int)_position).get("name").toString());
			_Verde12(genero);
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
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.player, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout player2 = _view.findViewById(R.id.player2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView nome = _view.findViewById(R.id.nome);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			
			player2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF1F222A));
			nome.setText(map.get((int)_position).get("nome").toString());
			
			return _view;
		}
	}
	
	public class EpisdiosAdapter extends RecyclerView.Adapter<EpisdiosAdapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public EpisdiosAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.episodios, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView image = _view.findViewById(R.id.image);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ProgressBar progressbar1 = _view.findViewById(R.id.progressbar1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final TextView nome = _view.findViewById(R.id.nome);
			final TextView ano = _view.findViewById(R.id.ano);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			nome.setText(listmap.get((int)_position).get("episodioE").toString());
			ano.setText(listmap.get((int)_position).get("ano").toString().concat(" minutos"));
			Glide.with(getApplicationContext()).load(Uri.parse(listmap.get((int)_position).get("capa").toString())).into(image);
			android.graphics.drawable.GradientDrawable imageg = new android.graphics.drawable.GradientDrawable ();
			imageg.setColor(android.R.color.transparent);
			imageg.setCornerRadius((int)20);
			image.setClipToOutline(true);
			image.setBackground(imageg);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sp.edit().putString("epJ", listmap.get((int)_position).get("episodioE").toString()).commit();
					nomes = sp.getString("nomeD", "").concat(":".concat(sp.getString("temporadaJ", "").concat(":".concat(listmap.get((int)_position).get("episodioE").toString()))));
					_links();
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									_dialog();
								}
							});
						}
					};
					_timer.schedule(t, (int)(300));
				}
			});
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
	
	public class Recyclerview2Adapter extends RecyclerView.Adapter<Recyclerview2Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.elenco, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView nome = _view.findViewById(R.id.nome);
			final TextView D = _view.findViewById(R.id.D);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			nome.setText(Johnson.get((int)_position).get("name").toString());
			D.setText(Johnson.get((int)_position).get("character").toString());
			if (Johnson.get((int)_position).get("profile_path").toString().equals("N/A")) {
				imageview1.setImageResource(R.drawable.default_image);
			}
			else {
				Glide.with(getApplicationContext()).load(Uri.parse("https://image.tmdb.org/t/p/w500".concat(Johnson.get((int)_position).get("profile_path").toString()))).into(imageview1);
			}
			android.graphics.drawable.GradientDrawable imageview1g = new android.graphics.drawable.GradientDrawable ();
			imageview1g.setColor(android.R.color.transparent);
			imageview1g.setCornerRadius((int)100);
			imageview1.setClipToOutline(true);
			imageview1.setBackground(imageview1g);
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
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.capa, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView image = _view.findViewById(R.id.image);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			textview1.setText(mapaD.get((int)_position).get("avaliacao").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(mapaD.get((int)_position).get("foto").toString())).into(image);
			textview1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFF06C149));
			android.graphics.drawable.GradientDrawable imageg = new android.graphics.drawable.GradientDrawable ();
			imageg.setColor(android.R.color.transparent);
			imageg.setCornerRadius((int)20);
			image.setClipToOutline(true);
			image.setBackground(imageg);
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