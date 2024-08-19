package com.imnext.net;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
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
import android.widget.ScrollView;
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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

public class AnimesActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double coma = 0;
	private double numa = 0;
	private double position = 0;
	private String como = "";
	private double strike = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private double click = 0;
	private double n = 0;
	
	private ArrayList<HashMap<String, Object>> mapa = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> alta = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> dublage = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Lancame = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Aventu = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Comedial = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Roman = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> cat = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mapaD = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mapS = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listgenre_movie_series = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listFavoritos = new ArrayList<>();
	
	private LinearLayout background;
	private LinearLayout view2;
	private LinearLayout view1;
	private LinearLayout linear4;
	private LinearLayout inicio;
	private LinearLayout fragmentos;
	private LinearLayout linear7;
	private ScrollView vscroll1;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear19;
	private RecyclerView Emalta;
	private LinearLayout linear20;
	private RecyclerView dublagem;
	private LinearLayout linear21;
	private RecyclerView Lancamento;
	private LinearLayout linear22;
	private RecyclerView Aventura;
	private LinearLayout linear23;
	private RecyclerView Comedia;
	private LinearLayout linear24;
	private RecyclerView Romance;
	private ViewPager viewpager2;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;
	private TextView textview9;
	private TextView textview14;
	private TextView textview10;
	private TextView textview15;
	private TextView textview11;
	private TextView textview16;
	private TextView textview12;
	private TextView textview17;
	private LinearLayout linear12;
	private LinearLayout linear_c;
	private LinearLayout View;
	private LinearLayout content;
	private LinearLayout linear28;
	private ImageView imageview5;
	private LinearLayout linear26;
	private ImageView imageview6;
	private LinearLayout linear27;
	private ImageView imag_perfil;
	private ImageView imageview32;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private TextView textview2;
	private ImageView imageview3;
	private TextView textview3;
	private ImageView imageview4;
	private TextView textview4;
	
	private DatabaseReference animes = _firebase.getReference("animes");
	private ChildEventListener _animes_child_listener;
	private TimerTask ti_er;
	private AlertDialog.Builder D;
	private Intent internet = new Intent();
	private SharedPreferences sp;
	private FirebaseAuth Auto;
	private OnCompleteListener<AuthResult> _Auto_create_user_listener;
	private OnCompleteListener<AuthResult> _Auto_sign_in_listener;
	private OnCompleteListener<Void> _Auto_reset_password_listener;
	private OnCompleteListener<Void> Auto_updateEmailListener;
	private OnCompleteListener<Void> Auto_updatePasswordListener;
	private OnCompleteListener<Void> Auto_emailVerificationSentListener;
	private OnCompleteListener<Void> Auto_deleteUserListener;
	private OnCompleteListener<Void> Auto_updateProfileListener;
	private OnCompleteListener<AuthResult> Auto_phoneAuthListener;
	private OnCompleteListener<AuthResult> Auto_googleSignInListener;
	
	private DatabaseReference Dialogo = _firebase.getReference("Dialogo");
	private ChildEventListener _Dialogo_child_listener;
	private SharedPreferences button_13;
	private DatabaseReference atualizacao = _firebase.getReference("atualizacao");
	private ChildEventListener _atualizacao_child_listener;
	private DatabaseReference manutencao = _firebase.getReference("manutencao");
	private ChildEventListener _manutencao_child_listener;
	private SharedPreferences foto_tv;
	private DatabaseReference usuario = _firebase.getReference("usuario");
	private ChildEventListener _usuario_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.animes);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		background = findViewById(R.id.background);
		view2 = findViewById(R.id.view2);
		view1 = findViewById(R.id.view1);
		linear4 = findViewById(R.id.linear4);
		inicio = findViewById(R.id.inicio);
		fragmentos = findViewById(R.id.fragmentos);
		linear7 = findViewById(R.id.linear7);
		vscroll1 = findViewById(R.id.vscroll1);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear19 = findViewById(R.id.linear19);
		Emalta = findViewById(R.id.Emalta);
		linear20 = findViewById(R.id.linear20);
		dublagem = findViewById(R.id.dublagem);
		linear21 = findViewById(R.id.linear21);
		Lancamento = findViewById(R.id.Lancamento);
		linear22 = findViewById(R.id.linear22);
		Aventura = findViewById(R.id.Aventura);
		linear23 = findViewById(R.id.linear23);
		Comedia = findViewById(R.id.Comedia);
		linear24 = findViewById(R.id.linear24);
		Romance = findViewById(R.id.Romance);
		viewpager2 = findViewById(R.id.viewpager2);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		textview14 = findViewById(R.id.textview14);
		textview10 = findViewById(R.id.textview10);
		textview15 = findViewById(R.id.textview15);
		textview11 = findViewById(R.id.textview11);
		textview16 = findViewById(R.id.textview16);
		textview12 = findViewById(R.id.textview12);
		textview17 = findViewById(R.id.textview17);
		linear12 = findViewById(R.id.linear12);
		linear_c = findViewById(R.id.linear_c);
		View = findViewById(R.id.View);
		content = findViewById(R.id.content);
		linear28 = findViewById(R.id.linear28);
		imageview5 = findViewById(R.id.imageview5);
		linear26 = findViewById(R.id.linear26);
		imageview6 = findViewById(R.id.imageview6);
		linear27 = findViewById(R.id.linear27);
		imag_perfil = findViewById(R.id.imag_perfil);
		imageview32 = findViewById(R.id.imageview32);
		linear15 = findViewById(R.id.linear15);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		linear18 = findViewById(R.id.linear18);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		imageview3 = findViewById(R.id.imageview3);
		textview3 = findViewById(R.id.textview3);
		imageview4 = findViewById(R.id.imageview4);
		textview4 = findViewById(R.id.textview4);
		D = new AlertDialog.Builder(this);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		Auto = FirebaseAuth.getInstance();
		button_13 = getSharedPreferences("button_13", Activity.MODE_PRIVATE);
		foto_tv = getSharedPreferences("foto_tv", Activity.MODE_PRIVATE);
		
		viewpager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				
			}
			
			@Override
			public void onPageSelected(int _position) {
				coma = _position;
				numa = _position;
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				
			}
		});
		
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				internet.putExtra("categorias", "categorias");
				internet.putExtra("gênero", "Em alta");
				internet.setClass(getApplicationContext(), CategoriasActivity.class);
				startActivity(internet);
			}
		});
		
		textview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				internet.putExtra("categorias", "categorias");
				internet.putExtra("gênero", "Com dublagem");
				internet.setClass(getApplicationContext(), CategoriasActivity.class);
				startActivity(internet);
			}
		});
		
		textview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				internet.putExtra("categorias", "categorias");
				internet.putExtra("gênero", "Lançamento");
				internet.setClass(getApplicationContext(), CategoriasActivity.class);
				startActivity(internet);
			}
		});
		
		textview15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				internet.putExtra("categorias", "genero");
				internet.putExtra("gênero", "Aventura");
				internet.setClass(getApplicationContext(), CategoriasActivity.class);
				startActivity(internet);
			}
		});
		
		textview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				internet.putExtra("categorias", "genero");
				internet.putExtra("gênero", "Comédia");
				internet.setClass(getApplicationContext(), CategoriasActivity.class);
				startActivity(internet);
			}
		});
		
		textview12.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		textview17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				internet.putExtra("categorias", "genero");
				internet.putExtra("gênero", "Animação");
				internet.setClass(getApplicationContext(), CategoriasActivity.class);
				startActivity(internet);
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				internet.setClass(getApplicationContext(), PesquisaActivity.class);
				startActivity(internet);
			}
		});
		
		imag_perfil.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				internet.setClass(getApplicationContext(), AvatarActivity.class);
				startActivity(internet);
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
		
		_Dialogo_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				final AlertDialog Dg = new AlertDialog.Builder(AnimesActivity.this).create();
				
				View inflate = getLayoutInflater().inflate(R.layout.dialogo, null);
				Dg.setView(inflate);
				Dg.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				
				final LinearLayout linear_1 = (LinearLayout)
				inflate.findViewById(R.id.linear_1);
				final TextView nome_1 = (TextView)
				inflate.findViewById(R.id.nome_1);
				final TextView descrio_1 = (TextView)
				inflate.findViewById(R.id.descrio_1);
				final ImageView image_1_1 = (ImageView)
				inflate.findViewById(R.id.image_1_1);
				final Button button2 = (Button)
				inflate.findViewById(R.id.button2);
				final Button button1 = (Button)
				inflate.findViewById(R.id.button1);
				_ImgRound(image_1_1, 100);
				button2.setOnClickListener(new View.OnClickListener() {
								@Override
								public void onClick(View _view) {
										internet.setAction(Intent.ACTION_VIEW);
						internet.setData(Uri.parse(_childValue.get("link").toString()));
						startActivity(internet);
								}
						});
				button1.setOnClickListener(new View.OnClickListener() {
								@Override
								public void onClick(View _view) {
										button_13.edit().putString("button_", "button_1").commit();
						Dg.dismiss();
								}
						});
				nome_1.setText(_childValue.get("Título").toString());
				descrio_1.setText(_childValue.get("Descrição").toString());
				Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("foto").toString())).into(image_1_1);
				if (button_13.getString("button_", "").equals("button_1")) {
					Dg.dismiss();
				}
				android.graphics.drawable.GradientDrawable image_1_1g = new android.graphics.drawable.GradientDrawable ();
				image_1_1g.setColor(android.R.color.transparent);
				image_1_1g.setCornerRadius((int)100);
				image_1_1.setClipToOutline(true);
				image_1_1.setBackground(image_1_1g);
				
				Dg.show();
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
		Dialogo.addChildEventListener(_Dialogo_child_listener);
		
		_atualizacao_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.contains("atualizacaos")) {
					internet.putExtra("Download", _childValue.get("Download").toString());
					internet.setClass(getApplicationContext(), AtualizacaoActivity.class);
					startActivity(internet);
					finish();
				}
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
		atualizacao.addChildEventListener(_atualizacao_child_listener);
		
		_manutencao_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("Manut").toString().equals("on")) {
					internet.setClass(getApplicationContext(), ManutencaoActivity.class);
					startActivity(internet);
					finish();
				}
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
		manutencao.addChildEventListener(_manutencao_child_listener);
		
		_usuario_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("ID").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("foto").toString())).into(imag_perfil);
				}
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
		usuario.addChildEventListener(_usuario_child_listener);
		
		Auto_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		Auto_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		Auto_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		Auto_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		Auto_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		Auto_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		Auto_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_Auto_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_Auto_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_Auto_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_sistema();
		Dialogo.addChildEventListener(_Dialogo_child_listener);
		RelativeLayout rl = new RelativeLayout(this); RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT); rl.setLayoutParams(lparams); background.removeAllViews(); 
		rl.addView(view2);
		rl.addView(view1);
		background.addView(rl);
		imageview1.setColorFilter(0xFF06C149, PorterDuff.Mode.MULTIPLY);
		imageview2.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
		imageview3.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
		imageview4.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
		android.graphics.drawable.GradientDrawable HDJCCDA = new android.graphics.drawable.GradientDrawable();
		HDJCCDA.setColor(Color.parseColor("#D91F222A"));
		HDJCCDA.setCornerRadii(new float[] { 30, 30, 30, 30, 0, 0, 0, 0 });
		View.setBackground(HDJCCDA);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);}
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN); if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { getWindow().setStatusBarColor(Color.TRANSPARENT); }
		_NavStatusBarColor("#00000000", "#FF1F222A");
		_menu();
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		map = new HashMap<>();
		map.put("tipo", "online");
		usuario.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
	}
	
	@Override
	public void onStop() {
		super.onStop();
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			map = new HashMap<>();
			map.put("tipo", "offline");
			usuario.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
		}
	}
	public void _NavStatusBarColor(final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _slider() {
		com.google.firebase.database.Query query = FirebaseDatabase.getInstance().getReference("animes").limitToFirst(5);
		
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { mapa = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						mapa.add(_map); } 
					
					//lisview adapter listmap 
					//listview att
					
					
					viewpager2.setAdapter(new Viewpager2Adapter(mapa));
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
	
	
	public void _emalta() {
		com.google.firebase.database.Query query = animes.orderByChild("categorias").equalTo(("Em alta")); 
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { alta = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						alta.add(_map); } 
					
					//lisview adapter listmap 
					//listview att
					Emalta.setAdapter(new EmaltaAdapter(alta));
					Emalta.getAdapter().notifyDataSetChanged();
					linear_c.setBackgroundColor(Color.TRANSPARENT);
					imageview32.setVisibility(View.GONE);
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
	}
	
	
	public void _Comdublagem() {
		com.google.firebase.database.Query query = animes.orderByChild("categorias").equalTo(("Com dublagem")); 
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { dublage = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						dublage.add(_map); } 
					
					//lisview adapter listmap 
					//listview att
					dublagem.setAdapter(new DublagemAdapter(dublage));
					dublagem.getAdapter().notifyDataSetChanged();
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
	}
	
	
	public void _Lancament() {
		com.google.firebase.database.Query query = animes.orderByChild("categorias").equalTo(("Lançamento")); 
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { Lancame = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						Lancame.add(_map); } 
					
					//lisview adapter listmap 
					//listview att
					Lancamento.setAdapter(new LancamentoAdapter(Lancame));
					Lancamento.getAdapter().notifyDataSetChanged();
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
	}
	
	
	public void _Aventur() {
		com.google.firebase.database.Query query = animes.orderByChild("genero").equalTo(("Aventura")); 
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { Aventu = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						Aventu.add(_map); } 
					
					//lisview adapter listmap 
					//listview att
					Aventura.setAdapter(new AventuraAdapter(Aventu));
					Aventura.getAdapter().notifyDataSetChanged();
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
	}
	
	
	public void _Comdia() {
		com.google.firebase.database.Query query = animes.orderByChild("genero").equalTo(("Comédia")); 
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { Comedial = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						Comedial.add(_map); } 
					
					//lisview adapter listmap 
					//listview att
					Comedia.setAdapter(new ComediaAdapter(Comedial));
					Comedia.getAdapter().notifyDataSetChanged();
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
	}
	
	
	public void _Romanc() {
		com.google.firebase.database.Query query = animes.orderByChild("genero").equalTo(("Animação")); 
		
		ValueEventListener valueEventListener = new ValueEventListener() { @Override public void onDataChange(DataSnapshot dataSnapshot) { try { Roman = new ArrayList<>();
					
					 GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {}; for (DataSnapshot _data : dataSnapshot.getChildren()) { HashMap<String, Object> _map = _data.getValue(_ind); 
						Roman.add(_map); } 
					
					//lisview adapter listmap 
					//listview att
					Romance.setAdapter(new RomanceAdapter(Roman));
					Romance.getAdapter().notifyDataSetChanged();
				} catch (Exception e) { e.printStackTrace(); } } 
			
			@Override public void onCancelled(DatabaseError databaseError) { } }; query.addValueEventListener(valueEventListener);
	}
	
	
	public void _recyclerview() {
		dublagem.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		Lancamento.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		Romance.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		Comedia.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		Aventura.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		Emalta.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
	}
	
	
	public void _sistema() {
		_slider();
		_emalta();
		_Comdublagem();
		_Lancament();
		_Aventur();
		_Comdia();
		_Romanc();
		coma = 0;
		numa = 0;
		ti_er = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						viewpager2.setCurrentItem((int)numa);
						numa++;
						if (numa == mapa.size()) {
							numa = 0;
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(ti_er, (int)(0), (int)(4000));
		_recyclerview();
		_ImgRound(imag_perfil, 100);
		linear_c.setBackgroundColor(0xFF181A20);
		imageview32.setVisibility(View.VISIBLE);
		ti_er = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						imageview32.setRotation((float)(imageview32.getRotation() + 10));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(ti_er, (int)(0), (int)(20));
	}
	
	
	public void _menu() {
		linear15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inicio.setVisibility(View.VISIBLE);
				fragmentos.setVisibility(View.GONE);
				textview4.setTextColor(0xFF8C8C8C);
				textview1.setTextColor(0xFF06C149);
				textview2.setTextColor(0xFF8C8C8C);
				textview3.setTextColor(0xFF8C8C8C);
				imageview1.setColorFilter(0xFF06C149, PorterDuff.Mode.MULTIPLY);
				imageview2.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				imageview3.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				imageview4.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				content.setVisibility(View.VISIBLE);
			}
		});
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Fragment fragment = new ExploreFragmentActivity();
				getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.fragmentos, fragment)
				.commit();
				fragmentos.setVisibility(View.VISIBLE);
				inicio.setVisibility(View.GONE);
				textview4.setTextColor(0xFF8C8C8C);
				textview1.setTextColor(0xFF8C8C8C);
				textview2.setTextColor(0xFF06C149);
				textview3.setTextColor(0xFF8C8C8C);
				imageview1.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				imageview2.setColorFilter(0xFF06C149, PorterDuff.Mode.MULTIPLY);
				imageview3.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				imageview4.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				content.setVisibility(View.GONE);
			}
		});
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Fragment fragment = new FavoritoFragmentActivity();
				getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.fragmentos, fragment)
				.commit();
				fragmentos.setVisibility(View.VISIBLE);
				content.setVisibility(View.GONE);
				inicio.setVisibility(View.GONE);
				textview4.setTextColor(0xFF8C8C8C);
				textview1.setTextColor(0xFF8C8C8C);
				textview2.setTextColor(0xFF8C8C8C);
				textview3.setTextColor(0xFF06C149);
				imageview1.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				imageview2.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				imageview3.setColorFilter(0xFF06C149, PorterDuff.Mode.MULTIPLY);
				imageview4.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
			}
		});
		linear18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Fragment fragment = new PerfilFragmentActivity();
				getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.fragmentos, fragment)
				.commit();
				inicio.setVisibility(View.GONE);
				fragmentos.setVisibility(View.VISIBLE);
				textview4.setTextColor(0xFF06C149);
				textview1.setTextColor(0xFF8C8C8C);
				textview2.setTextColor(0xFF8C8C8C);
				textview3.setTextColor(0xFF8C8C8C);
				imageview1.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				imageview2.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				imageview3.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
				imageview4.setColorFilter(0xFF06C149, PorterDuff.Mode.MULTIPLY);
				content.setVisibility(View.GONE);
			}
		});
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
	
	public class EmaltaAdapter extends RecyclerView.Adapter<EmaltaAdapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public EmaltaAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
	
	public class DublagemAdapter extends RecyclerView.Adapter<DublagemAdapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public DublagemAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
			textview1.setText(dublage.get((int)_position).get("avaliacao").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(dublage.get((int)_position).get("foto").toString())).into(image);
			textview1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFF06C149));
			_ImgRound(image, 16);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sp.edit().putString("nomeD", dublage.get((int)_position).get("nome").toString()).commit();
					sp.edit().putString("anoD", dublage.get((int)_position).get("ano").toString()).commit();
					sp.edit().putString("fotoD", dublage.get((int)_position).get("foto").toString()).commit();
					sp.edit().putString("descricaoD", dublage.get((int)_position).get("descricao").toString()).commit();
					sp.edit().putString("episodiosD", dublage.get((int)_position).get("episodios").toString()).commit();
					sp.edit().putString("temporadasD", dublage.get((int)_position).get("temporadas").toString()).commit();
					sp.edit().putString("banner", dublage.get((int)_position).get("banner").toString()).commit();
					sp.edit().putString("classificação", dublage.get((int)_position).get("classificação").toString()).commit();
					sp.edit().putString("genero", dublage.get((int)_position).get("genero").toString()).commit();
					sp.edit().putString("avaliacao", dublage.get((int)_position).get("avaliacao").toString()).commit();
					sp.edit().putString("ID", dublage.get((int)_position).get("ID").toString()).commit();
					internet.setClass(getApplicationContext(), SobreAnimeActivity.class);
					startActivity(internet);
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
	
	public class LancamentoAdapter extends RecyclerView.Adapter<LancamentoAdapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public LancamentoAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
			textview1.setText(Lancame.get((int)_position).get("avaliacao").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(Lancame.get((int)_position).get("foto").toString())).into(image);
			textview1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFF06C149));
			_ImgRound(image, 16);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sp.edit().putString("nomeD", Lancame.get((int)_position).get("nome").toString()).commit();
					sp.edit().putString("anoD", Lancame.get((int)_position).get("ano").toString()).commit();
					sp.edit().putString("fotoD", Lancame.get((int)_position).get("foto").toString()).commit();
					sp.edit().putString("descricaoD", Lancame.get((int)_position).get("descricao").toString()).commit();
					sp.edit().putString("episodiosD", Lancame.get((int)_position).get("episodios").toString()).commit();
					sp.edit().putString("temporadasD", Lancame.get((int)_position).get("temporadas").toString()).commit();
					sp.edit().putString("banner", Lancame.get((int)_position).get("banner").toString()).commit();
					sp.edit().putString("classificação", Lancame.get((int)_position).get("classificação").toString()).commit();
					sp.edit().putString("genero", Lancame.get((int)_position).get("genero").toString()).commit();
					sp.edit().putString("avaliacao", Lancame.get((int)_position).get("avaliacao").toString()).commit();
					sp.edit().putString("ID", Lancame.get((int)_position).get("ID").toString()).commit();
					internet.setClass(getApplicationContext(), SobreAnimeActivity.class);
					startActivity(internet);
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
	
	public class AventuraAdapter extends RecyclerView.Adapter<AventuraAdapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public AventuraAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
			textview1.setText(Aventu.get((int)_position).get("avaliacao").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(Aventu.get((int)_position).get("foto").toString())).into(image);
			textview1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFF06C149));
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sp.edit().putString("nomeD", Aventu.get((int)_position).get("nome").toString()).commit();
					sp.edit().putString("anoD", Aventu.get((int)_position).get("ano").toString()).commit();
					sp.edit().putString("fotoD", Aventu.get((int)_position).get("foto").toString()).commit();
					sp.edit().putString("descricaoD", Aventu.get((int)_position).get("descricao").toString()).commit();
					sp.edit().putString("episodiosD", Aventu.get((int)_position).get("episodios").toString()).commit();
					sp.edit().putString("temporadasD", Aventu.get((int)_position).get("temporadas").toString()).commit();
					sp.edit().putString("banner", Aventu.get((int)_position).get("banner").toString()).commit();
					sp.edit().putString("classificação", Aventu.get((int)_position).get("classificação").toString()).commit();
					sp.edit().putString("genero", Aventu.get((int)_position).get("genero").toString()).commit();
					sp.edit().putString("avaliacao", Aventu.get((int)_position).get("avaliacao").toString()).commit();
					sp.edit().putString("ID", Aventu.get((int)_position).get("ID").toString()).commit();
					internet.setClass(getApplicationContext(), SobreAnimeActivity.class);
					startActivity(internet);
				}
			});
			_ImgRound(image, 16);
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
	
	public class ComediaAdapter extends RecyclerView.Adapter<ComediaAdapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public ComediaAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
			textview1.setText(Comedial.get((int)_position).get("avaliacao").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(Comedial.get((int)_position).get("foto").toString())).into(image);
			textview1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFF06C149));
			_ImgRound(image, 16);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sp.edit().putString("nomeD", Comedial.get((int)_position).get("nome").toString()).commit();
					sp.edit().putString("anoD", Comedial.get((int)_position).get("ano").toString()).commit();
					sp.edit().putString("fotoD", Comedial.get((int)_position).get("foto").toString()).commit();
					sp.edit().putString("descricaoD", Comedial.get((int)_position).get("descricao").toString()).commit();
					sp.edit().putString("episodiosD", Comedial.get((int)_position).get("episodios").toString()).commit();
					sp.edit().putString("temporadasD", Comedial.get((int)_position).get("temporadas").toString()).commit();
					sp.edit().putString("banner", Comedial.get((int)_position).get("banner").toString()).commit();
					sp.edit().putString("classificação", Comedial.get((int)_position).get("classificação").toString()).commit();
					sp.edit().putString("genero", Comedial.get((int)_position).get("genero").toString()).commit();
					sp.edit().putString("avaliacao", Comedial.get((int)_position).get("avaliacao").toString()).commit();
					sp.edit().putString("ID", Comedial.get((int)_position).get("ID").toString()).commit();
					internet.setClass(getApplicationContext(), SobreAnimeActivity.class);
					startActivity(internet);
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
	
	public class RomanceAdapter extends RecyclerView.Adapter<RomanceAdapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public RomanceAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
			textview1.setText(Roman.get((int)_position).get("avaliacao").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(Roman.get((int)_position).get("foto").toString())).into(image);
			textview1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFF06C149));
			_ImgRound(image, 16);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sp.edit().putString("nomeD", Roman.get((int)_position).get("nome").toString()).commit();
					sp.edit().putString("anoD", Roman.get((int)_position).get("ano").toString()).commit();
					sp.edit().putString("fotoD", Roman.get((int)_position).get("foto").toString()).commit();
					sp.edit().putString("descricaoD", Roman.get((int)_position).get("descricao").toString()).commit();
					sp.edit().putString("episodiosD", Roman.get((int)_position).get("episodios").toString()).commit();
					sp.edit().putString("temporadasD", Roman.get((int)_position).get("temporadas").toString()).commit();
					sp.edit().putString("banner", Roman.get((int)_position).get("banner").toString()).commit();
					sp.edit().putString("classificação", Roman.get((int)_position).get("classificação").toString()).commit();
					sp.edit().putString("genero", Roman.get((int)_position).get("genero").toString()).commit();
					sp.edit().putString("avaliacao", Roman.get((int)_position).get("avaliacao").toString()).commit();
					sp.edit().putString("ID", Roman.get((int)_position).get("ID").toString()).commit();
					internet.setClass(getApplicationContext(), SobreAnimeActivity.class);
					startActivity(internet);
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
	
	public class Viewpager2Adapter extends PagerAdapter {
		
		Context _context;
		ArrayList<HashMap<String, Object>> _data;
		
		public Viewpager2Adapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {
			_context = _ctx;
			_data = _arr;
		}
		
		public Viewpager2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_context = getApplicationContext();
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public boolean isViewFromObject(View _view, Object _object) {
			return _view == _object;
		}
		
		@Override
		public void destroyItem(ViewGroup _container, int _position, Object _object) {
			_container.removeView((View) _object);
		}
		
		@Override
		public int getItemPosition(Object _object) {
			return super.getItemPosition(_object);
		}
		
		@Override
		public CharSequence getPageTitle(int pos) {
			// Use the Activity Event (onTabLayoutNewTabAdded) in order to use this method
			return "page " + String.valueOf(pos);
		}
		
		@Override
		public Object instantiateItem(ViewGroup _container,  final int _position) {
			View _view = LayoutInflater.from(_context).inflate(R.layout.slider, _container, false);
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView image = _view.findViewById(R.id.image);
			final LinearLayout linearimg = _view.findViewById(R.id.linearimg);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final TextView nome = _view.findViewById(R.id.nome);
			final TextView d = _view.findViewById(R.id.d);
			final LinearLayout lineaplaye = _view.findViewById(R.id.lineaplaye);
			final LinearLayout line = _view.findViewById(R.id.line);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final ImageView imageview3 = _view.findViewById(R.id.imageview3);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			
			Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("banner").toString())).into(image);
			nome.setText(_data.get((int)_position).get("nome").toString());
			d.setText(_data.get((int)_position).get("descricao").toString().substring((int)(0), (int)(60)));
			lineaplaye.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFF06C149));
			android.graphics.drawable.GradientDrawable CFCACGB = new android.graphics.drawable.GradientDrawable();
			int CFCACGBADD[] = new int[]{ Color.parseColor("#FF181A20"), Color.parseColor("#00000000") };
			CFCACGB.setColors(CFCACGBADD);
			CFCACGB.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP);
			CFCACGB.setCornerRadius(0);
			linearimg.setBackground(CFCACGB);
			android.graphics.drawable.GradientDrawable BBJIBIG = new android.graphics.drawable.GradientDrawable();
			BBJIBIG.setColor(Color.parseColor("#00000000"));
			BBJIBIG.setCornerRadius(100);
			BBJIBIG.setStroke(3, Color.parseColor("#FFFFFFFF"));
			line.setBackground(BBJIBIG);
			linearimg.setOnClickListener(new View.OnClickListener() {
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
			if (sp.getString(_data.get((int)_position).get("nome").toString(), "").equals(_data.get((int)_position).get("nome").toString())) {
				imageview3.setImageResource(R.drawable.favorito_adicionado);
			}
			line.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (sp.getString(_data.get((int)_position).get("nome").toString(), "").equals("")) {
						if (!sp.getString("listFavoritos", "").equals("")) {
							listFavoritos = new Gson().fromJson(sp.getString("listFavoritos", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						}
						listFavoritos.add(_data.get((int)(_position)));
						sp.edit().putString("listFavoritos", new Gson().toJson(listFavoritos)).commit();
						sp.edit().putString(_data.get((int)_position).get("nome").toString(), _data.get((int)_position).get("nome").toString()).commit();
						imageview3.setImageResource(R.drawable.favorito_adicionado);
						_Favoritos("Favoritos", "Filme adicionado aos favoritos");
					}
					else {
						listFavoritos = new Gson().fromJson(sp.getString("listFavoritos", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						n = 0;
						for(int _repeat92 = 0; _repeat92 < (int)(listFavoritos.size()); _repeat92++) {
							if (listFavoritos.get((int)n).get("nome").toString().equals(_data.get((int)_position).get("nome").toString())) {
								listFavoritos.remove((int)(n));
								sp.edit().putString("listFavoritos", new Gson().toJson(listFavoritos)).commit();
							}
							n++;
						}
						imageview3.setImageResource(R.drawable.mas);
						sp.edit().remove(_data.get((int)_position).get("nome").toString()).commit();
						_Favoritos("Removido", "Filme removido dos favoritos");
					}
				}
			});
			
			_container.addView(_view);
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