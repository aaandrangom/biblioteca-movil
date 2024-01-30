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

public class registrousuario extends Activity implements B4AActivity{
	public static registrousuario mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.registrousuario");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (registrousuario).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.registrousuario");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.registrousuario", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (registrousuario) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (registrousuario) Resume **");
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
		return registrousuario.class;
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
            BA.LogInfo("** Activity (registrousuario) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (registrousuario) Pause event (activity is not paused). **");
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
            registrousuario mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (registrousuario) Resume **");
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
public static String _usr_email_global = "";
public static String _usr_nombre = "";
public anywheresoftware.b4a.objects.EditTextWrapper _txt_cedula = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txt_primer_nombre = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txt_segundo_nombre = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txt_primer_apellido = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txt_segundo_apellido = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txt_correo = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txt_contrasenia = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txt_fecha_nacimiento = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.validacionusuario _validacionusuario = null;
public b4a.example.principal _principal = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="registrousuario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Activity.LoadLayout(\"layoutRegistroUsuario\")";
mostCurrent._activity.LoadLayout("layoutRegistroUsuario",mostCurrent.activityBA);
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="registrousuario";
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="registrousuario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _btn_calendario_fecha_nacimiento_click() throws Exception{
RDebugUtils.currentModule="registrousuario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_calendario_fecha_nacimiento_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_calendario_fecha_nacimiento_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub btn_calendario_fecha_nacimiento_Click";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="End Sub";
return "";
}
public static String  _btn_iniciar_sesion_click() throws Exception{
RDebugUtils.currentModule="registrousuario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_iniciar_sesion_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btn_iniciar_sesion_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Private Sub btn_iniciar_sesion_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="End Sub";
return "";
}
public static void  _btn_registrar_usuario_click() throws Exception{
RDebugUtils.currentModule="registrousuario";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btn_registrar_usuario_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btn_registrar_usuario_click", null); return;}
ResumableSub_btn_registrar_usuario_Click rsub = new ResumableSub_btn_registrar_usuario_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btn_registrar_usuario_Click extends BA.ResumableSub {
public ResumableSub_btn_registrar_usuario_Click(b4a.example.registrousuario parent) {
this.parent = parent;
}
b4a.example.registrousuario parent;
anywheresoftware.b4a.objects.collections.Map _mapregister = null;
String _jsonregister = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jsongenerator = null;
b4a.example.usuario _usuario_ = null;
b4a.example.httpjob _peticion = null;
b4a.example.httpjob _respuesta = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="registrousuario";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="If txt_cedula.Text = \"\" Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((parent.mostCurrent._txt_cedula.getText()).equals("")) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="xui.MsgboxAsync(\"El campo 'Cédula' no puede esta";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Cédula' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="If txt_cedula.Text.Length > 13 Then";

case 4:
//if
this.state = 7;
if (parent.mostCurrent._txt_cedula.getText().length()>13) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="xui.MsgboxAsync(\"La cédula no puede tener más de";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("La cédula no puede tener más de 13 caracteres."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="If txt_primer_nombre.Text = \"\" Then";

case 7:
//if
this.state = 10;
if ((parent.mostCurrent._txt_primer_nombre.getText()).equals("")) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Nombre' no pue";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Primer Nombre' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="If txt_segundo_nombre.Text = \"\" Then";

case 10:
//if
this.state = 13;
if ((parent.mostCurrent._txt_segundo_nombre.getText()).equals("")) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=851986;
 //BA.debugLineNum = 851986;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Nombre' no pu";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Segundo Nombre' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=851987;
 //BA.debugLineNum = 851987;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=851990;
 //BA.debugLineNum = 851990;BA.debugLine="If txt_primer_apellido.Text = \"\" Then";

case 13:
//if
this.state = 16;
if ((parent.mostCurrent._txt_primer_apellido.getText()).equals("")) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
RDebugUtils.currentLine=851991;
 //BA.debugLineNum = 851991;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Apellido' no p";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Primer Apellido' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=851992;
 //BA.debugLineNum = 851992;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=851995;
 //BA.debugLineNum = 851995;BA.debugLine="If txt_segundo_apellido.Text = \"\" Then";

case 16:
//if
this.state = 19;
if ((parent.mostCurrent._txt_segundo_apellido.getText()).equals("")) { 
this.state = 18;
}if (true) break;

case 18:
//C
this.state = 19;
RDebugUtils.currentLine=851996;
 //BA.debugLineNum = 851996;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Apellido' no";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Segundo Apellido' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=851997;
 //BA.debugLineNum = 851997;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=852000;
 //BA.debugLineNum = 852000;BA.debugLine="If txt_primer_nombre.Text.Length > 100 Then";

case 19:
//if
this.state = 22;
if (parent.mostCurrent._txt_primer_nombre.getText().length()>100) { 
this.state = 21;
}if (true) break;

case 21:
//C
this.state = 22;
RDebugUtils.currentLine=852001;
 //BA.debugLineNum = 852001;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Nombre' no pue";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Primer Nombre' no puede tener más de 100 caracteres."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=852002;
 //BA.debugLineNum = 852002;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=852005;
 //BA.debugLineNum = 852005;BA.debugLine="If txt_segundo_nombre.Text.Length > 100 Then";

case 22:
//if
this.state = 25;
if (parent.mostCurrent._txt_segundo_nombre.getText().length()>100) { 
this.state = 24;
}if (true) break;

case 24:
//C
this.state = 25;
RDebugUtils.currentLine=852006;
 //BA.debugLineNum = 852006;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Nombre' no pu";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Segundo Nombre' no puede tener más de 100 caracteres."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=852007;
 //BA.debugLineNum = 852007;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=852010;
 //BA.debugLineNum = 852010;BA.debugLine="If txt_primer_apellido.Text.Length > 100 Then";

case 25:
//if
this.state = 28;
if (parent.mostCurrent._txt_primer_apellido.getText().length()>100) { 
this.state = 27;
}if (true) break;

case 27:
//C
this.state = 28;
RDebugUtils.currentLine=852011;
 //BA.debugLineNum = 852011;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Apellido' no p";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Primer Apellido' no puede tener más de 100 caracteres."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=852012;
 //BA.debugLineNum = 852012;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=852015;
 //BA.debugLineNum = 852015;BA.debugLine="If txt_segundo_apellido.Text.Length > 100 Then";

case 28:
//if
this.state = 31;
if (parent.mostCurrent._txt_segundo_apellido.getText().length()>100) { 
this.state = 30;
}if (true) break;

case 30:
//C
this.state = 31;
RDebugUtils.currentLine=852016;
 //BA.debugLineNum = 852016;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Apellido' no";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Segundo Apellido' no puede tener más de 100 caracteres."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=852017;
 //BA.debugLineNum = 852017;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=852020;
 //BA.debugLineNum = 852020;BA.debugLine="If txt_correo.Text = \"\" Then";

case 31:
//if
this.state = 34;
if ((parent.mostCurrent._txt_correo.getText()).equals("")) { 
this.state = 33;
}if (true) break;

case 33:
//C
this.state = 34;
RDebugUtils.currentLine=852021;
 //BA.debugLineNum = 852021;BA.debugLine="xui.MsgboxAsync(\"El campo 'Correo' no puede esta";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Correo' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=852022;
 //BA.debugLineNum = 852022;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=852025;
 //BA.debugLineNum = 852025;BA.debugLine="If txt_correo.Text.Length > 250 Then";

case 34:
//if
this.state = 37;
if (parent.mostCurrent._txt_correo.getText().length()>250) { 
this.state = 36;
}if (true) break;

case 36:
//C
this.state = 37;
RDebugUtils.currentLine=852026;
 //BA.debugLineNum = 852026;BA.debugLine="xui.MsgboxAsync(\"El campo 'Correo/email' no pued";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Correo/email' no puede tener más de 250 caracteres."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=852027;
 //BA.debugLineNum = 852027;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=852030;
 //BA.debugLineNum = 852030;BA.debugLine="If txt_contrasenia.Text = \"\" Then";

case 37:
//if
this.state = 40;
if ((parent.mostCurrent._txt_contrasenia.getText()).equals("")) { 
this.state = 39;
}if (true) break;

case 39:
//C
this.state = 40;
RDebugUtils.currentLine=852031;
 //BA.debugLineNum = 852031;BA.debugLine="xui.MsgboxAsync(\"El campo 'Contraseña' no puede";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Contraseña' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=852032;
 //BA.debugLineNum = 852032;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=852035;
 //BA.debugLineNum = 852035;BA.debugLine="If txt_contrasenia.Text.Length > 15 Then";

case 40:
//if
this.state = 43;
if (parent.mostCurrent._txt_contrasenia.getText().length()>15) { 
this.state = 42;
}if (true) break;

case 42:
//C
this.state = 43;
RDebugUtils.currentLine=852036;
 //BA.debugLineNum = 852036;BA.debugLine="xui.MsgboxAsync(\"¡La contraseña no puede contene";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡La contraseña no puede contener más de 15 caracteres!"),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=852037;
 //BA.debugLineNum = 852037;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=852040;
 //BA.debugLineNum = 852040;BA.debugLine="If txt_fecha_nacimiento.Text = \"\" Then";

case 43:
//if
this.state = 46;
if ((parent.mostCurrent._txt_fecha_nacimiento.getText()).equals("")) { 
this.state = 45;
}if (true) break;

case 45:
//C
this.state = 46;
RDebugUtils.currentLine=852041;
 //BA.debugLineNum = 852041;BA.debugLine="xui.MsgboxAsync(\"El campo 'Fecha de Nacimiento'";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Fecha de Nacimiento' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
RDebugUtils.currentLine=852042;
 //BA.debugLineNum = 852042;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 46:
//C
this.state = 47;
;
RDebugUtils.currentLine=852045;
 //BA.debugLineNum = 852045;BA.debugLine="Dim mapRegister As Map";
_mapregister = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=852046;
 //BA.debugLineNum = 852046;BA.debugLine="Dim jsonRegister As String";
_jsonregister = "";
RDebugUtils.currentLine=852047;
 //BA.debugLineNum = 852047;BA.debugLine="Dim jsonGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=852048;
 //BA.debugLineNum = 852048;BA.debugLine="Dim usuario_ As usuario";
_usuario_ = new b4a.example.usuario();
RDebugUtils.currentLine=852050;
 //BA.debugLineNum = 852050;BA.debugLine="usuario_.usr_cedula = txt_cedula.Text";
_usuario_._usr_cedula /*String*/  = parent.mostCurrent._txt_cedula.getText();
RDebugUtils.currentLine=852051;
 //BA.debugLineNum = 852051;BA.debugLine="usuario_.usr_primer_nombre = txt_primer_nombre.Te";
_usuario_._usr_primer_nombre /*String*/  = parent.mostCurrent._txt_primer_nombre.getText();
RDebugUtils.currentLine=852052;
 //BA.debugLineNum = 852052;BA.debugLine="usuario_.usr_segundo_nombre = txt_segundo_nombre.";
_usuario_._usr_segundo_nombre /*String*/  = parent.mostCurrent._txt_segundo_nombre.getText();
RDebugUtils.currentLine=852053;
 //BA.debugLineNum = 852053;BA.debugLine="usuario_.usr_primer_apellido = txt_primer_apellid";
_usuario_._usr_primer_apellido /*String*/  = parent.mostCurrent._txt_primer_apellido.getText();
RDebugUtils.currentLine=852054;
 //BA.debugLineNum = 852054;BA.debugLine="usuario_.usr_segundo_apellido = txt_segundo_apell";
_usuario_._usr_segundo_apellido /*String*/  = parent.mostCurrent._txt_segundo_apellido.getText();
RDebugUtils.currentLine=852055;
 //BA.debugLineNum = 852055;BA.debugLine="usr_nombre = txt_primer_nombre.Text & \"\" & txt_pr";
parent._usr_nombre = parent.mostCurrent._txt_primer_nombre.getText()+""+parent.mostCurrent._txt_primer_apellido.getText();
RDebugUtils.currentLine=852056;
 //BA.debugLineNum = 852056;BA.debugLine="usuario_.usr_email = txt_correo.Text";
_usuario_._usr_email /*String*/  = parent.mostCurrent._txt_correo.getText();
RDebugUtils.currentLine=852057;
 //BA.debugLineNum = 852057;BA.debugLine="usr_email_global = txt_correo.Text";
parent._usr_email_global = parent.mostCurrent._txt_correo.getText();
RDebugUtils.currentLine=852058;
 //BA.debugLineNum = 852058;BA.debugLine="usuario_.usr_contrasenia = txt_contrasenia.Text";
_usuario_._usr_contrasenia /*String*/  = parent.mostCurrent._txt_contrasenia.getText();
RDebugUtils.currentLine=852059;
 //BA.debugLineNum = 852059;BA.debugLine="usuario_.usr_fecha_nacimiento = txt_fecha_nacimie";
_usuario_._usr_fecha_nacimiento /*String*/  = parent.mostCurrent._txt_fecha_nacimiento.getText();
RDebugUtils.currentLine=852060;
 //BA.debugLineNum = 852060;BA.debugLine="usuario_.usr_rol = \"2\"";
_usuario_._usr_rol /*String*/  = "2";
RDebugUtils.currentLine=852061;
 //BA.debugLineNum = 852061;BA.debugLine="usuario_.usr_estado = \"H\"";
_usuario_._usr_estado /*String*/  = "H";
RDebugUtils.currentLine=852063;
 //BA.debugLineNum = 852063;BA.debugLine="mapRegister.Initialize";
_mapregister.Initialize();
RDebugUtils.currentLine=852064;
 //BA.debugLineNum = 852064;BA.debugLine="mapRegister.Put(\"usr_cedula\", usuario_.usr_cedula";
_mapregister.Put((Object)("usr_cedula"),(Object)(_usuario_._usr_cedula /*String*/ ));
RDebugUtils.currentLine=852065;
 //BA.debugLineNum = 852065;BA.debugLine="mapRegister.Put(\"usr_primer_nombre\", usuario_.usr";
_mapregister.Put((Object)("usr_primer_nombre"),(Object)(_usuario_._usr_primer_nombre /*String*/ ));
RDebugUtils.currentLine=852066;
 //BA.debugLineNum = 852066;BA.debugLine="mapRegister.Put(\"usr_segundo_nombre\", usuario_.us";
_mapregister.Put((Object)("usr_segundo_nombre"),(Object)(_usuario_._usr_segundo_nombre /*String*/ ));
RDebugUtils.currentLine=852067;
 //BA.debugLineNum = 852067;BA.debugLine="mapRegister.Put(\"usr_primer_apellido\", usuario_.u";
_mapregister.Put((Object)("usr_primer_apellido"),(Object)(_usuario_._usr_primer_apellido /*String*/ ));
RDebugUtils.currentLine=852068;
 //BA.debugLineNum = 852068;BA.debugLine="mapRegister.Put(\"usr_segundo_apellido\", usuario_.";
_mapregister.Put((Object)("usr_segundo_apellido"),(Object)(_usuario_._usr_segundo_apellido /*String*/ ));
RDebugUtils.currentLine=852069;
 //BA.debugLineNum = 852069;BA.debugLine="mapRegister.Put(\"usr_email\", usuario_.usr_email)";
_mapregister.Put((Object)("usr_email"),(Object)(_usuario_._usr_email /*String*/ ));
RDebugUtils.currentLine=852070;
 //BA.debugLineNum = 852070;BA.debugLine="mapRegister.Put(\"usr_contrasenia\", usuario_.usr_c";
_mapregister.Put((Object)("usr_contrasenia"),(Object)(_usuario_._usr_contrasenia /*String*/ ));
RDebugUtils.currentLine=852071;
 //BA.debugLineNum = 852071;BA.debugLine="mapRegister.Put(\"usr_fecha_nacimiento\", usuario_.";
_mapregister.Put((Object)("usr_fecha_nacimiento"),(Object)(_usuario_._usr_fecha_nacimiento /*String*/ ));
RDebugUtils.currentLine=852072;
 //BA.debugLineNum = 852072;BA.debugLine="mapRegister.Put(\"usr_rol\", usuario_.usr_rol)";
_mapregister.Put((Object)("usr_rol"),(Object)(_usuario_._usr_rol /*String*/ ));
RDebugUtils.currentLine=852073;
 //BA.debugLineNum = 852073;BA.debugLine="mapRegister.Put(\"usr_estado\", usuario_.usr_estado";
_mapregister.Put((Object)("usr_estado"),(Object)(_usuario_._usr_estado /*String*/ ));
RDebugUtils.currentLine=852075;
 //BA.debugLineNum = 852075;BA.debugLine="jsonGenerator.Initialize(mapRegister)";
_jsongenerator.Initialize(_mapregister);
RDebugUtils.currentLine=852076;
 //BA.debugLineNum = 852076;BA.debugLine="jsonRegister = jsonGenerator.ToPrettyString(5)";
_jsonregister = _jsongenerator.ToPrettyString((int) (5));
RDebugUtils.currentLine=852078;
 //BA.debugLineNum = 852078;BA.debugLine="Dim peticion As HttpJob";
_peticion = new b4a.example.httpjob();
RDebugUtils.currentLine=852079;
 //BA.debugLineNum = 852079;BA.debugLine="peticion.Initialize(\"\", Me)";
_peticion._initialize /*String*/ (null,processBA,"",registrousuario.getObject());
RDebugUtils.currentLine=852080;
 //BA.debugLineNum = 852080;BA.debugLine="peticion.PostString(\"https://biblioteca-3q4a.onre";
_peticion._poststring /*String*/ (null,"https://biblioteca-3q4a.onrender.com/api/usuarios",_jsonregister);
RDebugUtils.currentLine=852081;
 //BA.debugLineNum = 852081;BA.debugLine="peticion.GetRequest.SetContentType(\"application/j";
_peticion._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ (null).SetContentType("application/json");
RDebugUtils.currentLine=852083;
 //BA.debugLineNum = 852083;BA.debugLine="Wait For (peticion) JobDone (respuesta As HttpJob";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "registrousuario", "btn_registrar_usuario_click"), (Object)(_peticion));
this.state = 53;
return;
case 53:
//C
this.state = 47;
_respuesta = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=852085;
 //BA.debugLineNum = 852085;BA.debugLine="If respuesta.Success Then";
if (true) break;

case 47:
//if
this.state = 52;
if (_respuesta._success /*boolean*/ ) { 
this.state = 49;
}else {
this.state = 51;
}if (true) break;

case 49:
//C
this.state = 52;
RDebugUtils.currentLine=852087;
 //BA.debugLineNum = 852087;BA.debugLine="txt_cedula.Text = \"\"";
parent.mostCurrent._txt_cedula.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=852088;
 //BA.debugLineNum = 852088;BA.debugLine="txt_primer_nombre.Text = \"\"";
parent.mostCurrent._txt_primer_nombre.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=852089;
 //BA.debugLineNum = 852089;BA.debugLine="txt_segundo_nombre.Text = \"\"";
parent.mostCurrent._txt_segundo_nombre.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=852090;
 //BA.debugLineNum = 852090;BA.debugLine="txt_primer_apellido.Text = \"\"";
parent.mostCurrent._txt_primer_apellido.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=852091;
 //BA.debugLineNum = 852091;BA.debugLine="txt_segundo_apellido.Text = \"\"";
parent.mostCurrent._txt_segundo_apellido.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=852092;
 //BA.debugLineNum = 852092;BA.debugLine="txt_correo.Text = \"\"";
parent.mostCurrent._txt_correo.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=852093;
 //BA.debugLineNum = 852093;BA.debugLine="txt_contrasenia.Text = \"\"";
parent.mostCurrent._txt_contrasenia.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=852094;
 //BA.debugLineNum = 852094;BA.debugLine="txt_fecha_nacimiento.Text = \"\"";
parent.mostCurrent._txt_fecha_nacimiento.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=852096;
 //BA.debugLineNum = 852096;BA.debugLine="peticion.Release";
_peticion._release /*String*/ (null);
RDebugUtils.currentLine=852097;
 //BA.debugLineNum = 852097;BA.debugLine="StartActivity(\"ValidacionUsuario\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ValidacionUsuario"));
 if (true) break;

case 51:
//C
this.state = 52;
RDebugUtils.currentLine=852099;
 //BA.debugLineNum = 852099;BA.debugLine="xui.MsgboxAsync(\"¡Registro fallido! \" & respuest";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡Registro fallido! "+_respuesta._getstring /*String*/ (null)),BA.ObjectToCharSequence("Error"));
 if (true) break;

case 52:
//C
this.state = -1;
;
RDebugUtils.currentLine=852101;
 //BA.debugLineNum = 852101;BA.debugLine="peticion.Release";
_peticion._release /*String*/ (null);
RDebugUtils.currentLine=852103;
 //BA.debugLineNum = 852103;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}