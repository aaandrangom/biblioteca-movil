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

public class validacionusuario extends Activity implements B4AActivity{
	public static validacionusuario mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.validacionusuario");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (validacionusuario).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.validacionusuario");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.validacionusuario", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (validacionusuario) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (validacionusuario) Resume **");
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
		return validacionusuario.class;
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
            BA.LogInfo("** Activity (validacionusuario) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (validacionusuario) Pause event (activity is not paused). **");
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
            validacionusuario mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (validacionusuario) Resume **");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txt_codigo_verificacion = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl_nombre_usuario = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.registrousuario _registrousuario = null;
public b4a.example.principal _principal = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="validacionusuario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="Activity.LoadLayout(\"layoutValidacionUsuario\")";
mostCurrent._activity.LoadLayout("layoutValidacionUsuario",mostCurrent.activityBA);
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="xui.MsgboxAsync(\"¡Registro exitoso!\", \"OK\")";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡Registro exitoso!"),BA.ObjectToCharSequence("OK"));
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="lbl_nombre_usuario.Text = \"Estimado @\" & Registro";
mostCurrent._lbl_nombre_usuario.setText(BA.ObjectToCharSequence("Estimado @"+mostCurrent._registrousuario._usr_nombre /*String*/ ));
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="validacionusuario";
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="validacionusuario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
public static void  _btn_validar_usuario_click() throws Exception{
RDebugUtils.currentModule="validacionusuario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_validar_usuario_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btn_validar_usuario_click", null); return;}
ResumableSub_btn_validar_usuario_Click rsub = new ResumableSub_btn_validar_usuario_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btn_validar_usuario_Click extends BA.ResumableSub {
public ResumableSub_btn_validar_usuario_Click(b4a.example.validacionusuario parent) {
this.parent = parent;
}
b4a.example.validacionusuario parent;
anywheresoftware.b4a.objects.collections.Map _mapvalidation = null;
String _jsonvalidation = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jsongenerator = null;
b4a.example.validacioncodigousuario _validacion_ = null;
b4a.example.httpjob _peticion = null;
b4a.example.httpjob _respuesta = null;
anywheresoftware.b4a.objects.collections.JSONParser _jsonparser = null;
anywheresoftware.b4a.objects.collections.Map _user = null;
String _nickname = "";
Object _mensaje_usuario = null;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="validacionusuario";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="If txt_codigo_verificacion.Text = \"\" Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((parent.mostCurrent._txt_codigo_verificacion.getText()).equals("")) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="xui.MsgboxAsync(\"No puede quedar vacio el código";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("No puede quedar vacio el código único!"),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="Dim mapValidation As Map";
_mapvalidation = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="Dim jsonValidation As String";
_jsonvalidation = "";
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="Dim jsonGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=1310729;
 //BA.debugLineNum = 1310729;BA.debugLine="Dim validacion_ As validacionCodigoUsuario";
_validacion_ = new b4a.example.validacioncodigousuario();
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="validacion_.usr_email = RegistroUsuario.usr_email";
_validacion_._usr_email /*String*/  = parent.mostCurrent._registrousuario._usr_email_global /*String*/ ;
RDebugUtils.currentLine=1310732;
 //BA.debugLineNum = 1310732;BA.debugLine="validacion_.codigoVerificacion = txt_codigo_verif";
_validacion_._codigoverificacion /*String*/  = parent.mostCurrent._txt_codigo_verificacion.getText();
RDebugUtils.currentLine=1310734;
 //BA.debugLineNum = 1310734;BA.debugLine="mapValidation.Initialize";
_mapvalidation.Initialize();
RDebugUtils.currentLine=1310735;
 //BA.debugLineNum = 1310735;BA.debugLine="mapValidation.Put(\"usr_email\", validacion_.usr_em";
_mapvalidation.Put((Object)("usr_email"),(Object)(_validacion_._usr_email /*String*/ ));
RDebugUtils.currentLine=1310736;
 //BA.debugLineNum = 1310736;BA.debugLine="mapValidation.Put(\"codigoVerificacion\", validacio";
_mapvalidation.Put((Object)("codigoVerificacion"),(Object)(_validacion_._codigoverificacion /*String*/ ));
RDebugUtils.currentLine=1310738;
 //BA.debugLineNum = 1310738;BA.debugLine="jsonGenerator.Initialize(mapValidation)";
_jsongenerator.Initialize(_mapvalidation);
RDebugUtils.currentLine=1310739;
 //BA.debugLineNum = 1310739;BA.debugLine="jsonValidation = jsonGenerator.ToPrettyString(5)";
_jsonvalidation = _jsongenerator.ToPrettyString((int) (5));
RDebugUtils.currentLine=1310741;
 //BA.debugLineNum = 1310741;BA.debugLine="Dim peticion As HttpJob";
_peticion = new b4a.example.httpjob();
RDebugUtils.currentLine=1310742;
 //BA.debugLineNum = 1310742;BA.debugLine="peticion.Initialize(\"\", Me)";
_peticion._initialize /*String*/ (null,processBA,"",validacionusuario.getObject());
RDebugUtils.currentLine=1310743;
 //BA.debugLineNum = 1310743;BA.debugLine="peticion.PostString(\"https://biblioteca-3q4a.onre";
_peticion._poststring /*String*/ (null,"https://biblioteca-3q4a.onrender.com/api/usuarios/verificar",_jsonvalidation);
RDebugUtils.currentLine=1310744;
 //BA.debugLineNum = 1310744;BA.debugLine="peticion.GetRequest.SetContentType(\"application/j";
_peticion._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
RDebugUtils.currentLine=1310746;
 //BA.debugLineNum = 1310746;BA.debugLine="Wait For (peticion) JobDone (respuesta As HttpJob";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "validacionusuario", "btn_validar_usuario_click"), (Object)(_peticion));
this.state = 15;
return;
case 15:
//C
this.state = 5;
_respuesta = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=1310748;
 //BA.debugLineNum = 1310748;BA.debugLine="If respuesta.Success Then";
if (true) break;

case 5:
//if
this.state = 14;
if (_respuesta._success /*boolean*/ ) { 
this.state = 7;
}else {
this.state = 13;
}if (true) break;

case 7:
//C
this.state = 8;
RDebugUtils.currentLine=1310749;
 //BA.debugLineNum = 1310749;BA.debugLine="Dim jsonParser As JSONParser";
_jsonparser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=1310750;
 //BA.debugLineNum = 1310750;BA.debugLine="jsonParser.Initialize(respuesta.GetString)";
_jsonparser.Initialize(_respuesta._getstring /*String*/ (null));
RDebugUtils.currentLine=1310751;
 //BA.debugLineNum = 1310751;BA.debugLine="Dim user As Map";
_user = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1310752;
 //BA.debugLineNum = 1310752;BA.debugLine="user = jsonParser.NextObject.Get(\"usuario\")";
_user = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_jsonparser.NextObject().Get((Object)("usuario"))));
RDebugUtils.currentLine=1310753;
 //BA.debugLineNum = 1310753;BA.debugLine="Dim nickname As String";
_nickname = "";
RDebugUtils.currentLine=1310754;
 //BA.debugLineNum = 1310754;BA.debugLine="nickname = user.Get(\"usr_nickname\")";
_nickname = BA.ObjectToString(_user.Get((Object)("usr_nickname")));
RDebugUtils.currentLine=1310756;
 //BA.debugLineNum = 1310756;BA.debugLine="Dim mensaje_usuario As Object = xui.Msgbox2Async";
_mensaje_usuario = parent._xui.Msgbox2Async(processBA,BA.ObjectToCharSequence("¡Verificacion exitosa!. Tu nuevo usuario es el siguiente: "+_nickname),BA.ObjectToCharSequence("Ok"),"Aceptar","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)));
RDebugUtils.currentLine=1310757;
 //BA.debugLineNum = 1310757;BA.debugLine="txt_codigo_verificacion.Text = \"\"";
parent.mostCurrent._txt_codigo_verificacion.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=1310758;
 //BA.debugLineNum = 1310758;BA.debugLine="Wait For (mensaje_usuario) Msgbox_Result (Resul";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "validacionusuario", "btn_validar_usuario_click"), _mensaje_usuario);
this.state = 16;
return;
case 16:
//C
this.state = 8;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=1310759;
 //BA.debugLineNum = 1310759;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 8:
//if
this.state = 11;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
RDebugUtils.currentLine=1310760;
 //BA.debugLineNum = 1310760;BA.debugLine="peticion.Release";
_peticion._release /*String*/ (null);
RDebugUtils.currentLine=1310761;
 //BA.debugLineNum = 1310761;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
 if (true) break;

case 11:
//C
this.state = 14;
;
 if (true) break;

case 13:
//C
this.state = 14;
RDebugUtils.currentLine=1310764;
 //BA.debugLineNum = 1310764;BA.debugLine="xui.MsgboxAsync(\"¡Verificacion fallida! \" & resp";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡Verificacion fallida! "+_respuesta._getstring /*String*/ (null)),BA.ObjectToCharSequence("Error"));
 if (true) break;

case 14:
//C
this.state = -1;
;
RDebugUtils.currentLine=1310766;
 //BA.debugLineNum = 1310766;BA.debugLine="peticion.Release";
_peticion._release /*String*/ (null);
RDebugUtils.currentLine=1310768;
 //BA.debugLineNum = 1310768;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}