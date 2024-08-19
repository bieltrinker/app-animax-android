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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class InicioActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private LinearLayout background;
	private LinearLayout view2;
	private LinearLayout view1;
	private ImageView imageview1;
	private LinearLayout linear6;
	private TextView textview1;
	private TextView textview2;
	private Button button1;
	private LinearLayout linear7;
	
	private Intent in = new Intent();
	private DatabaseReference atualizacao = _firebase.getReference("atualizacao");
	private ChildEventListener _atualizacao_child_listener;
	private DatabaseReference manutencao = _firebase.getReference("manutencao");
	private ChildEventListener _manutencao_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.inicio);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		background = findViewById(R.id.background);
		view2 = findViewById(R.id.view2);
		view1 = findViewById(R.id.view1);
		imageview1 = findViewById(R.id.imageview1);
		linear6 = findViewById(R.id.linear6);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		button1 = findViewById(R.id.button1);
		linear7 = findViewById(R.id.linear7);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), LoginActivity.class);
				startActivity(in);
			}
		});
		
		_atualizacao_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.contains("atualizacaos")) {
					in.putExtra("Download", _childValue.get("Download").toString());
					in.setClass(getApplicationContext(), AtualizacaoActivity.class);
					startActivity(in);
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
					in.setClass(getApplicationContext(), ManutencaoActivity.class);
					startActivity(in);
					finish();
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("Manut").toString().equals("on")) {
					in.setClass(getApplicationContext(), ManutencaoActivity.class);
					startActivity(in);
					finish();
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
		manutencao.addChildEventListener(_manutencao_child_listener);
	}
	
	private void initializeLogic() {
		atualizacao.addChildEventListener(_atualizacao_child_listener);
		manutencao.addChildEventListener(_manutencao_child_listener);
		RelativeLayout rl = new RelativeLayout(this); RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT); rl.setLayoutParams(lparams); background.removeAllViews(); 
		rl.addView(view2);
		rl.addView(view1);
		background.addView(rl);
		android.graphics.drawable.GradientDrawable HDFFFAJ = new android.graphics.drawable.GradientDrawable();
		int HDFFFAJADD[] = new int[]{ Color.parseColor("#FF181A20"), Color.parseColor("#00000000") };
		HDFFFAJ.setColors(HDFFFAJADD);
		HDFFFAJ.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP);
		HDFFFAJ.setCornerRadius(0);
		view1.setBackground(HDFFFAJ);
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFF06C149));
		if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
					    setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
					            | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, true);
		}
		if (Build.VERSION.SDK_INT >= 19) {
					    getWindow().getDecorView().setSystemUiVisibility(
					            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
					                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
					                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
					    );
		}
		if (Build.VERSION.SDK_INT >= 21) {
					    setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
					            | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, false);
					    getWindow().setStatusBarColor(Color.TRANSPARENT);
					    getWindow().setNavigationBarColor(Color.TRANSPARENT);
		}
	}
	private void setWindowFlag(final int bits, boolean on) {
		    Window win = getWindow();
		    WindowManager.LayoutParams winParams = win.getAttributes();
		    if (on) {
					        winParams.flags |= bits;
					    } else {
					        winParams.flags &= ~bits;
					    }
		    win.setAttributes(winParams);
	}
	{
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