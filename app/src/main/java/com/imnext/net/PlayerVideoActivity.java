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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
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

public class PlayerVideoActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private String playingstatus = "";
	private String ssssss = "";
	private String k5 = "";
	private String touching = "";
	private double Seek = 0;
	private double oo9 = 0;
	private String temporada = "";
	private double posTe = 0;
	private double pos = 0;
	private String nomes = "";
	
	private ArrayList<HashMap<String, Object>> listmapV = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listTemporada = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<String> str = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private RelativeLayout linear2;
	private LinearLayout player;
	private LinearLayout click;
	private LinearLayout menu;
	private ListView Listview1;
	private ListView Listview2;
	private VideoView videoview1;
	private LinearLayout linear5;
	private LinearLayout linear4;
	private LinearLayout linear3;
	private ImageView imageview1;
	private TextView nome;
	private LinearLayout linear24;
	private LinearLayout linear6;
	private ImageView imageview2;
	private LinearLayout linear9;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private ImageView imageview4;
	private ImageView image_play;
	private ProgressBar progressbar2;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private TextView text1;
	private SeekBar seekbar1;
	private TextView text2;
	private LinearLayout linear23;
	private LinearLayout inicio;
	private LinearLayout Background;
	private LinearLayout Transmitir;
	private LinearLayout Velocidade;
	private ImageView imageview9;
	private TextView textview6;
	private ImageView imageview7;
	private TextView textview8;
	private ImageView imageview8;
	private TextView textview9;
	private ImageView imageview10;
	private TextView textview10;
	private LinearLayout _drawer_linear1;
	private Spinner _drawer_spinner1;
	private LinearLayout _drawer_list;
	
	private TimerTask pm;
	private SharedPreferences sp;
	private DatabaseReference play = _firebase.getReference("play");
	private ChildEventListener _play_child_listener;
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.player_video);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(PlayerVideoActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear2 = findViewById(R.id.linear2);
		player = findViewById(R.id.player);
		click = findViewById(R.id.click);
		menu = findViewById(R.id.menu);
		Listview1 = findViewById(R.id.Listview1);
		Listview2 = findViewById(R.id.Listview2);
		videoview1 = findViewById(R.id.videoview1);
		MediaController videoview1_controller = new MediaController(this);
		videoview1.setMediaController(videoview1_controller);
		linear5 = findViewById(R.id.linear5);
		linear4 = findViewById(R.id.linear4);
		linear3 = findViewById(R.id.linear3);
		imageview1 = findViewById(R.id.imageview1);
		nome = findViewById(R.id.nome);
		linear24 = findViewById(R.id.linear24);
		linear6 = findViewById(R.id.linear6);
		imageview2 = findViewById(R.id.imageview2);
		linear9 = findViewById(R.id.linear9);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		imageview4 = findViewById(R.id.imageview4);
		image_play = findViewById(R.id.image_play);
		progressbar2 = findViewById(R.id.progressbar2);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		text1 = findViewById(R.id.text1);
		seekbar1 = findViewById(R.id.seekbar1);
		text2 = findViewById(R.id.text2);
		linear23 = findViewById(R.id.linear23);
		inicio = findViewById(R.id.inicio);
		Background = findViewById(R.id.Background);
		Transmitir = findViewById(R.id.Transmitir);
		Velocidade = findViewById(R.id.Velocidade);
		imageview9 = findViewById(R.id.imageview9);
		textview6 = findViewById(R.id.textview6);
		imageview7 = findViewById(R.id.imageview7);
		textview8 = findViewById(R.id.textview8);
		imageview8 = findViewById(R.id.imageview8);
		textview9 = findViewById(R.id.textview9);
		imageview10 = findViewById(R.id.imageview10);
		textview10 = findViewById(R.id.textview10);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_spinner1 = _nav_view.findViewById(R.id.spinner1);
		_drawer_list = _nav_view.findViewById(R.id.list);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		click.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				menu.setVisibility(View.VISIBLE);
			}
		});
		
		menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				menu.setVisibility(View.GONE);
			}
		});
		
		videoview1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer _mediaPlayer) {
				getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
				text2.setText(videoview1.getDuration() > 3600000 ? String.format("%02d:%02d:%02d",(((videoview1.getDuration() / 1000) / (60 * 60)) % 24), (((videoview1.getDuration() / 1000) / 60) % 60), ((videoview1.getDuration() / 1000) % 60)) : String.format("%02d:%02d",(((videoview1.getDuration() / 1000) / 60) % 60), ((videoview1.getDuration() / 1000) % 60)));
				seekbar1.setMax((int)videoview1.getDuration());
				pm = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text1.setText(videoview1.getCurrentPosition() > 3600000 ? String.format("%02d:%02d:%02d",(((videoview1.getCurrentPosition() / 1000) / (60 * 60)) % 24), (((videoview1.getCurrentPosition() / 1000) / 60) % 60), ((videoview1.getCurrentPosition() / 1000) % 60)) : String.format("%02d:%02d",(((videoview1.getCurrentPosition() / 1000) / 60) % 60), ((videoview1.getCurrentPosition() / 1000) % 60)));
								seekbar1.setProgress((int)videoview1.getCurrentPosition());
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(pm, (int)(0), (int)(100));
				image_play.setVisibility(View.VISIBLE);
				progressbar2.setVisibility(View.GONE);
				playingstatus = "PLAY";
			}
		});
		
		videoview1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer _mediaPlayer) {
				image_play.setImageResource(R.drawable.toque);
				_drawer.openDrawer(GravityCompat.START);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				videoview1.seekTo((int) videoview1.getCurrentPosition() - 15000);
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				videoview1.seekTo((int) videoview1.getCurrentPosition() + 15000);
			}
		});
		
		image_play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_PlayAndPause();
			}
		});
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				Seek = _progressValue;
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				videoview1.seekTo((int) Seek);
			}
		});
		
		inicio.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				videoview1.resume();
			}
		});
		
		Background.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				             if (android.os.Build.VERSION.SDK_INT >= 26) {
					                //Trigger PiP mode
					                try {
						                    Rational rational = new Rational(player.getWidth(), player.getHeight());
						            
						                    PictureInPictureParams mParams =
						                            new PictureInPictureParams.Builder()
						                                    .setAspectRatio(rational)
						                                    .build();
						
						                    enterPictureInPictureMode(mParams);
						                } catch (IllegalStateException e) {
						                    e.printStackTrace();
						                }
					            } else {
					                Toast.makeText(PlayerVideoActivity.this, "Background player not supported on your device", Toast.LENGTH_SHORT).show();
					finish();
					            }
			}
		});
		
		Transmitir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent intent = new Intent(android.provider.Settings.ACTION_CAST_SETTINGS);
				startActivityForResult(intent, 0);
				
				//Francisco
			}
		});
		
		Velocidade.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.openDrawer(GravityCompat.START);
			}
		});
		
		textview10.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
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
		
		_drawer_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				listmapV.clear();
				listmap.clear();
				listmapV = new Gson().fromJson(sp.getString("episodiosD", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				pos = 0;
				for(int _repeat39 = 0; _repeat39 < (int)(listmapV.size()); _repeat39++) {
					if (listTemporada.get((int)_position).get("temporadaT").toString().equals(listmapV.get((int)pos).get("temporadaE").toString())) {
						listmap.add(listmapV.get((int)pos));
						sp.edit().putString("temporadaJ", listTemporada.get((int)_position).get("temporadaT").toString()).commit();
					}
					pos++;
				}
				Listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)Listview1.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
	}
	
	private void initializeLogic() {
		_temporadas();
		_episodio();
		_toolbar.setVisibility(View.GONE);
		nome.setText(getIntent().getStringExtra("nome"));
		videoview1.setVideoURI(Uri.parse(getIntent().getStringExtra("player")));
		videoview1.start();
		videoview1.setMediaController(null);
		image_play.setVisibility(View.GONE);
		progressbar2.setVisibility(View.VISIBLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		android.graphics.drawable.GradientDrawable FDEBGDD = new android.graphics.drawable.GradientDrawable();
		FDEBGDD.setColor(Color.parseColor("#B3000000"));
		FDEBGDD.setCornerRadius(0);
		menu.setBackground(FDEBGDD);
		_PlayAndPause();
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);  _nav_view.setBackgroundColor(Color.parseColor("#1F222A"));  androidx.drawerlayout.widget.DrawerLayout.LayoutParams params = (androidx.drawerlayout.widget.DrawerLayout.LayoutParams)_nav_view.getLayoutParams();  params.width = (int)getDip((int)180);  params.height = androidx.drawerlayout.widget.DrawerLayout.LayoutParams.MATCH_PARENT;  _nav_view.setLayoutParams(params);
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}
	public void _loading() {
		pm = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
						if (text2.getText().toString().equals(text1.getText().toString())) {
							
						}
						else {
							if (playingstatus.equals("")) {
								oo9 = 0;
								progressbar2.setVisibility(View.GONE);
								image_play.setVisibility(View.VISIBLE);
							}
							else {
								ssssss = String.valueOf((long)(videoview1.getCurrentPosition()));
								pm = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												if (String.valueOf((long)(videoview1.getCurrentPosition())).equals(ssssss)) {
													oo9++;
													image_play.setVisibility(View.GONE);
													progressbar2.setVisibility(View.VISIBLE);
												}
												else {
													oo9 = 0;
													image_play.setVisibility(View.VISIBLE);
													progressbar2.setVisibility(View.GONE);
													pm = new TimerTask() {
														@Override
														public void run() {
															runOnUiThread(new Runnable() {
																@Override
																public void run() {
																	if (k5.equals("")) {
																		menu.setVisibility(View.GONE);
																		k5 = "pronto";
																		touching = "";
																	}
																}
															});
														}
													};
													_timer.schedule(pm, (int)(100));
												}
											}
										});
									}
								};
								_timer.schedule(pm, (int)(5));
							}
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(pm, (int)(0), (int)(55));
	}
	
	
	public void _PlayAndPause() {
		if (videoview1.isPlaying()) {
			image_play.setImageResource(R.drawable.toque);
			videoview1.pause();
			playingstatus = "";
			getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		}
		else {
			image_play.setImageResource(R.drawable.pausa);
			videoview1.start();
			playingstatus = "PLAY";
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
	}
	
	
	public void _episodio() {
		if (!(sp.getString("episodiosD", "").equals("[]") || sp.getString("episodiosD", "").equals(""))) {
			listmapV = new Gson().fromJson(sp.getString("episodiosD", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			pos = 0;
			for(int _repeat47 = 0; _repeat47 < (int)(listmapV.size()); _repeat47++) {
				if (listTemporada.get((int)0).get("temporadaT").toString().equals(listmapV.get((int)pos).get("temporadaE").toString())) {
					listmap.add(listmapV.get((int)pos));
				}
				pos++;
			}
			Listview1.setAdapter(new Listview1Adapter(listmap));
			((BaseAdapter)Listview1.getAdapter()).notifyDataSetChanged();
			ListView id = new ListView(this);
			
			id.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
			
			id.setAdapter(new Listview1Adapter(listmap));
			
			_drawer_list.addView(id);
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
			_drawer_spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, str));
			_drawer_spinner1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, str) {
				
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
			((ArrayAdapter)_drawer_spinner1.getAdapter()).notifyDataSetChanged();
		}
	}
	
	
	public void _dialog() {
		final AlertDialog Dg = new AlertDialog.Builder(PlayerVideoActivity.this).create();
		
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
		
		id.setAdapter(new Listview2Adapter(map));
		
		linear2.addView(id);
		id.setOnItemClickListener(new AdapterView.OnItemClickListener() {	@Override	public void onItemClick(AdapterView<?> parent, View view, int _position, long id) {		
				_position = _position;
				if (map.get((int)_position).get("tipo").toString().equals("Link")) {
					nome.setText(map.get((int)_position).get("anime").toString());
					videoview1.setVideoURI(Uri.parse(map.get((int)_position).get("player").toString()));
					videoview1.start();
				}
				else {
					if (map.get((int)_position).get("tipo").toString().equals("Web")) {
						i.putExtra("player", map.get((int)_position).get("player").toString());
						i.setClass(getApplicationContext(), WebActivity.class);
						startActivity(i);
						finish();
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
					
					Listview2.setAdapter(new Listview2Adapter(map));
					((BaseAdapter)Listview2.getAdapter()).notifyDataSetChanged();
					
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
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
				_view = _inflater.inflate(R.layout.episodios, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView image = _view.findViewById(R.id.image);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ProgressBar progressbar1 = _view.findViewById(R.id.progressbar1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final TextView nome = _view.findViewById(R.id.nome);
			final TextView ano = _view.findViewById(R.id.ano);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			
			nome.setText(_data.get((int)_position).get("episodioE").toString());
			ano.setText(_data.get((int)_position).get("ano").toString().concat(" minutos"));
			Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("capa").toString())).into(image);
			android.graphics.drawable.GradientDrawable imageg = new android.graphics.drawable.GradientDrawable ();
			imageg.setColor(android.R.color.transparent);
			imageg.setCornerRadius((int)20);
			image.setClipToOutline(true);
			image.setBackground(imageg);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sp.edit().putString("epJ", _data.get((int)_position).get("episodioE").toString()).commit();
					nomes = sp.getString("nomeD", "").concat(":".concat(sp.getString("temporadaJ", "").concat(":".concat(_data.get((int)_position).get("episodioE").toString()))));
					_links();
					pm = new TimerTask() {
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
					_timer.schedule(pm, (int)(300));
				}
			});
			
			return _view;
		}
	}
	
	public class Listview2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
			nome.setText(_data.get((int)_position).get("nome").toString());
			
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