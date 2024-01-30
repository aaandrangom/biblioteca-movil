package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txt_usuario = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txt_contrasenia = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.registrousuario _registrousuario = null;
public b4a.example.validacionusuario _validacionusuario = null;
public b4a.example.principal _principal = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (registrousuario.mostCurrent != null);
vis = vis | (validacionusuario.mostCurrent != null);
vis = vis | (principal.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _btn_registro_click() throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Private Sub btn_registro_Click";
 //BA.debugLineNum = 102;BA.debugLine="StartActivity(\"RegistroUsuario\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("RegistroUsuario"));
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public static void  _btniniciarsesion_click() throws Exception{
ResumableSub_btnIniciarSesion_Click rsub = new ResumableSub_btnIniciarSesion_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnIniciarSesion_Click extends BA.ResumableSub {
public ResumableSub_btnIniciarSesion_Click(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
String _usuario_ = "";
String _contrasenia = "";
anywheresoftware.b4a.objects.collections.Map _maplogin = null;
String _jsonlogin = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jsongenerator = null;
b4a.example.login _login_ = null;
b4a.example.httpjob _peticion = null;
b4a.example.httpjob _respuesta = null;
Object _mensaje_usuario = null;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 40;BA.debugLine="Dim usuario_ As String";
_usuario_ = "";
 //BA.debugLineNum = 41;BA.debugLine="usuario_ = txt_usuario.Text";
_usuario_ = parent.mostCurrent._txt_usuario.getText();
 //BA.debugLineNum = 43;BA.debugLine="If usuario_ = \"\" Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((_usuario_).equals("")) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 44;BA.debugLine="xui.MsgboxAsync(\"¡El usuario no puede estar vací";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡El usuario no puede estar vacío!"),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 45;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 47;BA.debugLine="If usuario_.Length > 20 Then";

case 4:
//if
this.state = 7;
if (_usuario_.length()>20) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 48;BA.debugLine="xui.MsgboxAsync(\"¡El usuario no puede contener m";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡El usuario no puede contener más de 20 caracteres!"),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 49;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 52;BA.debugLine="Dim contrasenia As String";
_contrasenia = "";
 //BA.debugLineNum = 53;BA.debugLine="contrasenia = txt_contrasenia.Text";
_contrasenia = parent.mostCurrent._txt_contrasenia.getText();
 //BA.debugLineNum = 55;BA.debugLine="If contrasenia = \"\" Then";
if (true) break;

case 8:
//if
this.state = 11;
if ((_contrasenia).equals("")) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 56;BA.debugLine="xui.MsgboxAsync(\"¡La contraseña no puede estar v";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡La contraseña no puede estar vacía!"),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 57;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 59;BA.debugLine="If contrasenia.Length > 15 Then";

case 11:
//if
this.state = 14;
if (_contrasenia.length()>15) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 60;BA.debugLine="xui.MsgboxAsync(\"¡La contraseña no puede contene";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡La contraseña no puede contener más de 15 caracteres!"),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 61;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 14:
//C
this.state = 15;
;
 //BA.debugLineNum = 64;BA.debugLine="Dim mapLogin As Map";
_maplogin = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 65;BA.debugLine="Dim jsonLogin As String";
_jsonlogin = "";
 //BA.debugLineNum = 66;BA.debugLine="Dim jsonGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 67;BA.debugLine="Dim login_ As login";
_login_ = new b4a.example.login();
 //BA.debugLineNum = 69;BA.debugLine="login_.usr_nickname = usuario_";
_login_._usr_nickname /*String*/  = _usuario_;
 //BA.debugLineNum = 70;BA.debugLine="login_.usr_contrasenia = contrasenia";
_login_._usr_contrasenia /*String*/  = _contrasenia;
 //BA.debugLineNum = 72;BA.debugLine="mapLogin.Initialize";
_maplogin.Initialize();
 //BA.debugLineNum = 73;BA.debugLine="mapLogin.Put(\"usr_nickname\", login_.usr_nickname)";
_maplogin.Put((Object)("usr_nickname"),(Object)(_login_._usr_nickname /*String*/ ));
 //BA.debugLineNum = 74;BA.debugLine="mapLogin.Put(\"usr_contrasenia\", login_.usr_contra";
_maplogin.Put((Object)("usr_contrasenia"),(Object)(_login_._usr_contrasenia /*String*/ ));
 //BA.debugLineNum = 76;BA.debugLine="jsonGenerator.Initialize(mapLogin)";
_jsongenerator.Initialize(_maplogin);
 //BA.debugLineNum = 77;BA.debugLine="jsonLogin = jsonGenerator.ToPrettyString(5)";
_jsonlogin = _jsongenerator.ToPrettyString((int) (5));
 //BA.debugLineNum = 79;BA.debugLine="Dim peticion As HttpJob";
_peticion = new b4a.example.httpjob();
 //BA.debugLineNum = 80;BA.debugLine="peticion.Initialize(\"\", Me)";
_peticion._initialize /*String*/ (processBA,"",main.getObject());
 //BA.debugLineNum = 81;BA.debugLine="peticion.PostString(\"https://biblioteca-3q4a.onre";
_peticion._poststring /*String*/ ("https://biblioteca-3q4a.onrender.com/api/auth/login",_jsonlogin);
 //BA.debugLineNum = 82;BA.debugLine="peticion.GetRequest.SetContentType(\"application/j";
_peticion._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 84;BA.debugLine="Wait For (peticion) JobDone (respuesta As HttpJob";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_peticion));
this.state = 25;
return;
case 25:
//C
this.state = 15;
_respuesta = (b4a.example.httpjob) result[0];
;
 //BA.debugLineNum = 86;BA.debugLine="If respuesta.Success Then";
if (true) break;

case 15:
//if
this.state = 24;
if (_respuesta._success /*boolean*/ ) { 
this.state = 17;
}else {
this.state = 23;
}if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 87;BA.debugLine="Dim mensaje_usuario As Object = xui.Msgbox2Async";
_mensaje_usuario = parent._xui.Msgbox2Async(processBA,BA.ObjectToCharSequence("¡Login exitoso!."),BA.ObjectToCharSequence("SUCCESS"),"Aceptar","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 88;BA.debugLine="Wait For (mensaje_usuario) Msgbox_Result (Result";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, _mensaje_usuario);
this.state = 26;
return;
case 26:
//C
this.state = 18;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 89;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 18:
//if
this.state = 21;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 20;
}if (true) break;

case 20:
//C
this.state = 21;
 //BA.debugLineNum = 90;BA.debugLine="peticion.Release";
_peticion._release /*String*/ ();
 //BA.debugLineNum = 91;BA.debugLine="StartActivity(\"Principal\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Principal"));
 if (true) break;

case 21:
//C
this.state = 24;
;
 if (true) break;

case 23:
//C
this.state = 24;
 //BA.debugLineNum = 94;BA.debugLine="xui.MsgboxAsync(\"¡Login fallido!\", \"ERROR\")";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡Login fallido!"),BA.ObjectToCharSequence("ERROR"));
 if (true) break;

case 24:
//C
this.state = -1;
;
 //BA.debugLineNum = 96;BA.debugLine="peticion.Release";
_peticion._release /*String*/ ();
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _jobdone(b4a.example.httpjob _respuesta) throws Exception{
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private txt_usuario As EditText";
mostCurrent._txt_usuario = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private txt_contrasenia As EditText";
mostCurrent._txt_contrasenia = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
main._process_globals();
registrousuario._process_globals();
validacionusuario._process_globals();
principal._process_globals();
starter._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
}
