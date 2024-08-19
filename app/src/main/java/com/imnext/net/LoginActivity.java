package com.imnext.net;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.DialogInterface;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class LoginActivity extends AppCompatActivity {
	
	public final int REQ_CD_CAPA = 101;
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private double Click = 0;
	private double remember = 0;
	private double fazendo = 0;
	private HashMap<String, Object> mapa = new HashMap<>();
	private String foto = "";
	private double carreg = 0;
	private boolean carregand = false;
	private String deviceID = "";
	private double limite = 0;
	
	private ArrayList<String> s = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mapa1 = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout login;
	private LinearLayout cadastro;
	private ImageView imageview3;
	private TextView textview2;
	private LinearLayout linear_vb;
	private LinearLayout linear_nome;
	private LinearLayout linear8;
	private LinearLayout linear6;
	private LinearLayout Enviar;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private ImageView image;
	private LinearLayout linear4;
	private LinearLayout linear16;
	private ImageView imageview8;
	private ImageView imageview7;
	private EditText nome;
	private ImageView imageview4;
	private EditText email;
	private ImageView imageview5;
	private EditText senha;
	private ImageView imageview6;
	private TextView Enviarcvb;
	private ImageView imagecarregando;
	private TextView textview4;
	private TextView textview5;
	private TextView URL;
	
	private FirebaseAuth Auth;
	private OnCompleteListener<AuthResult> _Auth_create_user_listener;
	private OnCompleteListener<AuthResult> _Auth_sign_in_listener;
	private OnCompleteListener<Void> _Auth_reset_password_listener;
	private OnCompleteListener<Void> Auth_updateEmailListener;
	private OnCompleteListener<Void> Auth_updatePasswordListener;
	private OnCompleteListener<Void> Auth_emailVerificationSentListener;
	private OnCompleteListener<Void> Auth_deleteUserListener;
	private OnCompleteListener<Void> Auth_updateProfileListener;
	private OnCompleteListener<AuthResult> Auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> Auth_googleSignInListener;
	
	private DatabaseReference usuario = _firebase.getReference("usuario");
	private ChildEventListener _usuario_child_listener;
	private Intent i = new Intent();
	private SharedPreferences tela_de_login;
	private TimerTask Time;
	private Intent capa = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder D;
	private StorageReference store = _firebase_storage.getReference("store");
	private OnCompleteListener<Uri> _store_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _store_download_success_listener;
	private OnSuccessListener _store_delete_success_listener;
	private OnProgressListener _store_upload_progress_listener;
	private OnProgressListener _store_download_progress_listener;
	private OnFailureListener _store_failure_listener;
	
	private SharedPreferences ObjectAnimator;
	private SharedPreferences foto_tv;
	private DatabaseReference atualizacao = _firebase.getReference("atualizacao");
	private ChildEventListener _atualizacao_child_listener;
	private DatabaseReference manutencao = _firebase.getReference("manutencao");
	private ChildEventListener _manutencao_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		login = findViewById(R.id.login);
		cadastro = findViewById(R.id.cadastro);
		imageview3 = findViewById(R.id.imageview3);
		textview2 = findViewById(R.id.textview2);
		linear_vb = findViewById(R.id.linear_vb);
		linear_nome = findViewById(R.id.linear_nome);
		linear8 = findViewById(R.id.linear8);
		linear6 = findViewById(R.id.linear6);
		Enviar = findViewById(R.id.Enviar);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear15 = findViewById(R.id.linear15);
		image = findViewById(R.id.image);
		linear4 = findViewById(R.id.linear4);
		linear16 = findViewById(R.id.linear16);
		imageview8 = findViewById(R.id.imageview8);
		imageview7 = findViewById(R.id.imageview7);
		nome = findViewById(R.id.nome);
		imageview4 = findViewById(R.id.imageview4);
		email = findViewById(R.id.email);
		imageview5 = findViewById(R.id.imageview5);
		senha = findViewById(R.id.senha);
		imageview6 = findViewById(R.id.imageview6);
		Enviarcvb = findViewById(R.id.Enviarcvb);
		imagecarregando = findViewById(R.id.imagecarregando);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		URL = findViewById(R.id.URL);
		Auth = FirebaseAuth.getInstance();
		tela_de_login = getSharedPreferences("tela_de_login", Activity.MODE_PRIVATE);
		capa.setType("image/*");
		capa.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		D = new AlertDialog.Builder(this);
		ObjectAnimator = getSharedPreferences("ObjectAnimator", Activity.MODE_PRIVATE);
		foto_tv = getSharedPreferences("foto_tv", Activity.MODE_PRIVATE);
		
		Enviar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (fazendo == 0) {
					if (email.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Digite um e-mail");
					}
					else {
						if (senha.getText().toString().equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Digite uma senha");
						}
						else {
							Auth.signInWithEmailAndPassword(email.getText().toString(), senha.getText().toString()).addOnCompleteListener(LoginActivity.this, _Auth_sign_in_listener);
							email.setEnabled(false);
							senha.setEnabled(false);
							email.setEnabled(true);
							senha.setEnabled(true);
							Enviar.setEnabled(false);
							Enviarcvb.setVisibility(View.GONE);
							imagecarregando.setVisibility(View.VISIBLE);
							linear_vb.setVisibility(View.GONE);
							linear_nome.setVisibility(View.GONE);
						}
					}
				}
				else {
					if (email.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Digite um e-mail");
					}
					else {
						if (senha.getText().toString().equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Digite uma senha");
						}
						else {
							if (nome.getText().toString().equals("")) {
								SketchwareUtil.showMessage(getApplicationContext(), "Digite um nome");
							}
							else {
								if (URL.getText().toString().equals("")) {
									SketchwareUtil.showMessage(getApplicationContext(), "Adicione uma imagem");
								}
								else {
									_criar();
									email.setEnabled(false);
									senha.setEnabled(false);
									email.setEnabled(true);
									senha.setEnabled(true);
									Enviar.setEnabled(false);
									Enviarcvb.setVisibility(View.GONE);
									imagecarregando.setVisibility(View.VISIBLE);
									linear_vb.setVisibility(View.VISIBLE);
									linear_nome.setVisibility(View.VISIBLE);
								}
							}
						}
					}
				}
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(capa, REQ_CD_CAPA);
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Click == 0) {
					Click = 1;
					imageview6.setImageResource(R.drawable.olhovisivel);
				}
				else {
					Click = 0;
					imageview6.setImageResource(R.drawable.visivel);
				}
			}
		});
		
		imagecarregando.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		textview5.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		textview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (fazendo == 0) {
					fazendo = 1;
					textview5.setText("voltar");
					textview2.setText("Faça o seu cadastro");
					linear_vb.setVisibility(View.VISIBLE);
					linear_nome.setVisibility(View.VISIBLE);
				}
				else {
					fazendo = 0;
					textview5.setText("login");
					textview2.setText("Faça o seu login");
					linear_vb.setVisibility(View.GONE);
					linear_nome.setVisibility(View.GONE);
				}
			}
		});
		
		_usuario_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				deviceID= Build.ID;
				if (_childValue.get("deviceID").toString().equals(deviceID)) {
					limite = Double.parseDouble(_childValue.get("limite").toString());
					remember++;
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				deviceID= Build.ID;
				if (_childValue.get("deviceID").toString().equals(deviceID)) {
					limite = Double.parseDouble(_childValue.get("limite").toString());
					remember++;
				}
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
		
		_store_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				_telegramLoaderDialog(true);
			}
		};
		
		_store_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_store_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				_telegramLoaderDialog(false);
				Glide.with(getApplicationContext()).load(Uri.parse(_downloadUrl)).into(image);
				URL.setText(_downloadUrl);
			}
		};
		
		_store_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_store_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_store_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_atualizacao_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.contains("atualizacaos")) {
					i.putExtra("Download", _childValue.get("Download").toString());
					i.setClass(getApplicationContext(), AtualizacaoActivity.class);
					startActivity(i);
					finishAffinity();
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
					i.setClass(getApplicationContext(), ManutencaoActivity.class);
					startActivity(i);
					finishAffinity();
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
		
		Auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		Auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		Auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		Auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		Auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		Auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		Auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_Auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				deviceID= Build.ID;
				if (_success) {
					Enviar.setEnabled(true);
					mapa.put("senha", senha.getText().toString());
					mapa.put("email", email.getText().toString());
					mapa.put("ID", FirebaseAuth.getInstance().getCurrentUser().getUid());
					mapa.put("nome", nome.getText().toString());
					mapa.put("deviceID", deviceID);
					mapa.put("foto", URL.getText().toString());
					mapa.put("limite", "1");
					usuario.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(mapa);
					Enviarcvb.setVisibility(View.VISIBLE);
					imagecarregando.setVisibility(View.GONE);
					SketchwareUtil.showMessage(getApplicationContext(), "Usuário criado com sucesso");
					Time.cancel();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
					Enviar.setEnabled(true);
					Enviarcvb.setVisibility(View.VISIBLE);
					imagecarregando.setVisibility(View.GONE);
				}
			}
		};
		
		_Auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					tela_de_login.edit().putString("usuário criado", "usuário").commit();
					i.setClass(getApplicationContext(), AnimesActivity.class);
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
					Enviarcvb.setVisibility(View.VISIBLE);
					imagecarregando.setVisibility(View.GONE);
					Time.cancel();
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
					Enviar.setEnabled(true);
					Enviarcvb.setVisibility(View.VISIBLE);
					imagecarregando.setVisibility(View.GONE);
				}
			}
		};
		
		_Auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				if (_success) {
					SketchwareUtil.showMessage(getApplicationContext(), "E-mail enviado com sucesso");
					Enviarcvb.setVisibility(View.VISIBLE);
					imagecarregando.setVisibility(View.GONE);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Ocorreu uma falha. Tente novamente.");
					Enviarcvb.setVisibility(View.VISIBLE);
					imagecarregando.setVisibility(View.GONE);
				}
			}
		};
	}
	
	private void initializeLogic() {
		usuario.addChildEventListener(_usuario_child_listener);
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF1F222A));
		linear_nome.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF1F222A));
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF1F222A));
		Enviar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFF06C149));
		imageview6.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
		imageview5.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
		imageview4.setColorFilter(0xFF8C8C8C, PorterDuff.Mode.MULTIPLY);
		_NavStatusBarColor("FF181A20", "FF181A20");
		imagecarregando.setVisibility(View.GONE);
		Enviarcvb.setVisibility(View.VISIBLE);
		Time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						imagecarregando.setRotation((float)(imagecarregando.getRotation() + 10));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(Time, (int)(0), (int)(20));
		linear_vb.setVisibility(View.GONE);
		linear_nome.setVisibility(View.GONE);
		android.graphics.drawable.GradientDrawable imageg = new android.graphics.drawable.GradientDrawable ();
		imageg.setColor(android.R.color.transparent);
		imageg.setCornerRadius((int)100);
		image.setClipToOutline(true);
		image.setBackground(imageg);
		linear16.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFF06C149));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_CAPA:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				if (_filePath.get((int)(0)).equals("")) {
					
				}
				else {
					foto = Uri.parse(Uri.parse(_filePath.get((int)(0))).getLastPathSegment()).getLastPathSegment();
					store.child(foto).putFile(Uri.fromFile(new File(_filePath.get((int)(0))))).addOnFailureListener(_store_failure_listener).addOnProgressListener(_store_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
						@Override
						public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
							return store.child(foto).getDownloadUrl();
						}}).addOnCompleteListener(_store_upload_success_listener);
				}
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	public void _NavStatusBarColor(final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _telegramLoaderDialog(final boolean _visibility) {
		if (_visibility) {
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				coreprog.setCancelable(false);
				coreprog.setCanceledOnTouchOutside(false);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprog.show();
			coreprog.setContentView(R.layout.carregando);
			
			
			LinearLayout linear_1 = (LinearLayout)coreprog.findViewById(R.id.linear_1);
			
			
			
			linear_1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)40, 0xFF1F222A));
		}
		else {
			if (coreprog != null){
				coreprog.dismiss();
			}
		}
	}
	private ProgressDialog coreprog;
	{
	}
	
	
	public void _criar() {
		if ((limite == 0) && (remember == 0)) {
			Auth.createUserWithEmailAndPassword(email.getText().toString(), senha.getText().toString()).addOnCompleteListener(LoginActivity.this, _Auth_create_user_listener);
		}
		else {
			if ((remember > limite) || (remember == limite)) {
				SketchwareUtil.showMessage(getApplicationContext(), "O limite de cadastro é ".concat(String.valueOf((long)(limite))));
				Enviarcvb.setVisibility(View.VISIBLE);
				imagecarregando.setVisibility(View.GONE);
			}
			else {
				Auth.createUserWithEmailAndPassword(email.getText().toString(), senha.getText().toString()).addOnCompleteListener(LoginActivity.this, _Auth_create_user_listener);
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