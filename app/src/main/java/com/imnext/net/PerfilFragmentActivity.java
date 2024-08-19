package com.imnext.net;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class PerfilFragmentActivity extends Fragment {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private LinearLayout linear55;
	private ScrollView vscroll1;
	private LinearLayout linear35;
	private LinearLayout linear36;
	private LinearLayout linear37;
	private LinearLayout linear40;
	private LinearLayout linear45;
	private LinearLayout linear49;
	private LinearLayout linear50;
	private LinearLayout linear51;
	private LinearLayout linear52;
	private LinearLayout linear53;
	private LinearLayout linear54;
	private LinearLayout linear44;
	private LinearLayout linear43;
	private ImageView imageview9;
	private TextView textview19;
	private LinearLayout linear5;
	private LinearLayout linear39;
	private LinearLayout linear3;
	private ImageView image;
	private TextView nome;
	private TextView text_e;
	private ImageView imageview11;
	private LinearLayout linear41;
	private ImageView imageview12;
	private TextView textview25;
	private TextView textview24;
	private ImageView imageview13;
	private TextView textview26;
	private ImageView imageview14;
	private ImageView imageview21;
	private TextView textview30;
	private ImageView imageview22;
	private ImageView imageview23;
	private TextView textview31;
	private TextView textview35;
	private ImageView imageview24;
	private ImageView imageview25;
	private TextView textview32;
	private ImageView imageview26;
	private ImageView imageview27;
	private TextView textview33;
	private ImageView imageview28;
	private ImageView imageview29;
	private TextView textview34;
	
	private DatabaseReference usuario = _firebase.getReference("usuario");
	private ChildEventListener _usuario_child_listener;
	private FirebaseAuth w;
	private OnCompleteListener<AuthResult> _w_create_user_listener;
	private OnCompleteListener<AuthResult> _w_sign_in_listener;
	private OnCompleteListener<Void> _w_reset_password_listener;
	private OnCompleteListener<Void> w_updateEmailListener;
	private OnCompleteListener<Void> w_updatePasswordListener;
	private OnCompleteListener<Void> w_emailVerificationSentListener;
	private OnCompleteListener<Void> w_deleteUserListener;
	private OnCompleteListener<Void> w_updateProfileListener;
	private OnCompleteListener<AuthResult> w_phoneAuthListener;
	private OnCompleteListener<AuthResult> w_googleSignInListener;
	
	private SharedPreferences tema;
	private SharedPreferences foto_tv;
	private Intent in = new Intent();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.perfil_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear55 = _view.findViewById(R.id.linear55);
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear35 = _view.findViewById(R.id.linear35);
		linear36 = _view.findViewById(R.id.linear36);
		linear37 = _view.findViewById(R.id.linear37);
		linear40 = _view.findViewById(R.id.linear40);
		linear45 = _view.findViewById(R.id.linear45);
		linear49 = _view.findViewById(R.id.linear49);
		linear50 = _view.findViewById(R.id.linear50);
		linear51 = _view.findViewById(R.id.linear51);
		linear52 = _view.findViewById(R.id.linear52);
		linear53 = _view.findViewById(R.id.linear53);
		linear54 = _view.findViewById(R.id.linear54);
		linear44 = _view.findViewById(R.id.linear44);
		linear43 = _view.findViewById(R.id.linear43);
		imageview9 = _view.findViewById(R.id.imageview9);
		textview19 = _view.findViewById(R.id.textview19);
		linear5 = _view.findViewById(R.id.linear5);
		linear39 = _view.findViewById(R.id.linear39);
		linear3 = _view.findViewById(R.id.linear3);
		image = _view.findViewById(R.id.image);
		nome = _view.findViewById(R.id.nome);
		text_e = _view.findViewById(R.id.text_e);
		imageview11 = _view.findViewById(R.id.imageview11);
		linear41 = _view.findViewById(R.id.linear41);
		imageview12 = _view.findViewById(R.id.imageview12);
		textview25 = _view.findViewById(R.id.textview25);
		textview24 = _view.findViewById(R.id.textview24);
		imageview13 = _view.findViewById(R.id.imageview13);
		textview26 = _view.findViewById(R.id.textview26);
		imageview14 = _view.findViewById(R.id.imageview14);
		imageview21 = _view.findViewById(R.id.imageview21);
		textview30 = _view.findViewById(R.id.textview30);
		imageview22 = _view.findViewById(R.id.imageview22);
		imageview23 = _view.findViewById(R.id.imageview23);
		textview31 = _view.findViewById(R.id.textview31);
		textview35 = _view.findViewById(R.id.textview35);
		imageview24 = _view.findViewById(R.id.imageview24);
		imageview25 = _view.findViewById(R.id.imageview25);
		textview32 = _view.findViewById(R.id.textview32);
		imageview26 = _view.findViewById(R.id.imageview26);
		imageview27 = _view.findViewById(R.id.imageview27);
		textview33 = _view.findViewById(R.id.textview33);
		imageview28 = _view.findViewById(R.id.imageview28);
		imageview29 = _view.findViewById(R.id.imageview29);
		textview34 = _view.findViewById(R.id.textview34);
		w = FirebaseAuth.getInstance();
		tema = getContext().getSharedPreferences("tema", Activity.MODE_PRIVATE);
		foto_tv = getContext().getSharedPreferences("foto_tv", Activity.MODE_PRIVATE);
		
		linear55.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear51.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getContext().getApplicationContext(), PoliticaActivity.class);
				startActivity(in);
			}
		});
		
		linear53.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_usuario_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("ID").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					Glide.with(getContext().getApplicationContext()).load(Uri.parse(_childValue.get("foto").toString())).into(image);
					nome.setText(_childValue.get("nome").toString());
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
		
		w_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		w_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		w_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		w_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		w_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		w_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		w_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_w_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_w_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_w_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		android.graphics.drawable.GradientDrawable imageg = new android.graphics.drawable.GradientDrawable ();
		imageg.setColor(android.R.color.transparent);
		imageg.setCornerRadius((int)100);
		image.setClipToOutline(true);
		image.setBackground(imageg);
		text_e.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
		image.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(foto_tv.getString("foto", ""), 1024, 1024));
	}
	
}