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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.registrousuario");
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

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"layoutRegistroUsuario\")";
mostCurrent._activity.LoadLayout("layoutRegistroUsuario",mostCurrent.activityBA);
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public static String  _btn_calendario_fecha_nacimiento_click() throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Private Sub btn_calendario_fecha_nacimiento_Click";
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public static String  _btn_iniciar_sesion_click() throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Private Sub btn_iniciar_sesion_Click";
 //BA.debugLineNum = 183;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public static void  _btn_registrar_usuario_click() throws Exception{
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

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 47;BA.debugLine="If txt_cedula.Text = \"\" Then";
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
 //BA.debugLineNum = 48;BA.debugLine="xui.MsgboxAsync(\"El campo 'Cédula' no puede esta";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Cédula' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 49;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 52;BA.debugLine="If txt_cedula.Text.Length > 13 Then";

case 4:
//if
this.state = 7;
if (parent.mostCurrent._txt_cedula.getText().length()>13) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 53;BA.debugLine="xui.MsgboxAsync(\"La cédula no puede tener más de";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("La cédula no puede tener más de 13 caracteres."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 54;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 57;BA.debugLine="If txt_primer_nombre.Text = \"\" Then";

case 7:
//if
this.state = 10;
if ((parent.mostCurrent._txt_primer_nombre.getText()).equals("")) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 58;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Nombre' no pue";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Primer Nombre' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 59;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 62;BA.debugLine="If txt_segundo_nombre.Text = \"\" Then";

case 10:
//if
this.state = 13;
if ((parent.mostCurrent._txt_segundo_nombre.getText()).equals("")) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 63;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Nombre' no pu";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Segundo Nombre' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 64;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 67;BA.debugLine="If txt_primer_apellido.Text = \"\" Then";

case 13:
//if
this.state = 16;
if ((parent.mostCurrent._txt_primer_apellido.getText()).equals("")) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 68;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Apellido' no p";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Primer Apellido' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 69;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 72;BA.debugLine="If txt_segundo_apellido.Text = \"\" Then";

case 16:
//if
this.state = 19;
if ((parent.mostCurrent._txt_segundo_apellido.getText()).equals("")) { 
this.state = 18;
}if (true) break;

case 18:
//C
this.state = 19;
 //BA.debugLineNum = 73;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Apellido' no";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Segundo Apellido' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 74;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 77;BA.debugLine="If txt_primer_nombre.Text.Length > 100 Then";

case 19:
//if
this.state = 22;
if (parent.mostCurrent._txt_primer_nombre.getText().length()>100) { 
this.state = 21;
}if (true) break;

case 21:
//C
this.state = 22;
 //BA.debugLineNum = 78;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Nombre' no pue";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Primer Nombre' no puede tener más de 100 caracteres."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 79;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 82;BA.debugLine="If txt_segundo_nombre.Text.Length > 100 Then";

case 22:
//if
this.state = 25;
if (parent.mostCurrent._txt_segundo_nombre.getText().length()>100) { 
this.state = 24;
}if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 83;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Nombre' no pu";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Segundo Nombre' no puede tener más de 100 caracteres."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 84;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 87;BA.debugLine="If txt_primer_apellido.Text.Length > 100 Then";

case 25:
//if
this.state = 28;
if (parent.mostCurrent._txt_primer_apellido.getText().length()>100) { 
this.state = 27;
}if (true) break;

case 27:
//C
this.state = 28;
 //BA.debugLineNum = 88;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Apellido' no p";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Primer Apellido' no puede tener más de 100 caracteres."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 89;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 92;BA.debugLine="If txt_segundo_apellido.Text.Length > 100 Then";

case 28:
//if
this.state = 31;
if (parent.mostCurrent._txt_segundo_apellido.getText().length()>100) { 
this.state = 30;
}if (true) break;

case 30:
//C
this.state = 31;
 //BA.debugLineNum = 93;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Apellido' no";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Segundo Apellido' no puede tener más de 100 caracteres."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 94;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 97;BA.debugLine="If txt_correo.Text = \"\" Then";

case 31:
//if
this.state = 34;
if ((parent.mostCurrent._txt_correo.getText()).equals("")) { 
this.state = 33;
}if (true) break;

case 33:
//C
this.state = 34;
 //BA.debugLineNum = 98;BA.debugLine="xui.MsgboxAsync(\"El campo 'Correo' no puede esta";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Correo' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 99;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 102;BA.debugLine="If txt_correo.Text.Length > 250 Then";

case 34:
//if
this.state = 37;
if (parent.mostCurrent._txt_correo.getText().length()>250) { 
this.state = 36;
}if (true) break;

case 36:
//C
this.state = 37;
 //BA.debugLineNum = 103;BA.debugLine="xui.MsgboxAsync(\"El campo 'Correo/email' no pued";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Correo/email' no puede tener más de 250 caracteres."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 104;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 107;BA.debugLine="If txt_contrasenia.Text = \"\" Then";

case 37:
//if
this.state = 40;
if ((parent.mostCurrent._txt_contrasenia.getText()).equals("")) { 
this.state = 39;
}if (true) break;

case 39:
//C
this.state = 40;
 //BA.debugLineNum = 108;BA.debugLine="xui.MsgboxAsync(\"El campo 'Contraseña' no puede";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Contraseña' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 109;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 112;BA.debugLine="If txt_contrasenia.Text.Length > 15 Then";

case 40:
//if
this.state = 43;
if (parent.mostCurrent._txt_contrasenia.getText().length()>15) { 
this.state = 42;
}if (true) break;

case 42:
//C
this.state = 43;
 //BA.debugLineNum = 113;BA.debugLine="xui.MsgboxAsync(\"¡La contraseña no puede contene";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡La contraseña no puede contener más de 15 caracteres!"),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 114;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 117;BA.debugLine="If txt_fecha_nacimiento.Text = \"\" Then";

case 43:
//if
this.state = 46;
if ((parent.mostCurrent._txt_fecha_nacimiento.getText()).equals("")) { 
this.state = 45;
}if (true) break;

case 45:
//C
this.state = 46;
 //BA.debugLineNum = 118;BA.debugLine="xui.MsgboxAsync(\"El campo 'Fecha de Nacimiento'";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("El campo 'Fecha de Nacimiento' no puede estar vacío."),BA.ObjectToCharSequence("Error"));
 //BA.debugLineNum = 119;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 46:
//C
this.state = 47;
;
 //BA.debugLineNum = 122;BA.debugLine="Dim mapRegister As Map";
_mapregister = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 123;BA.debugLine="Dim jsonRegister As String";
_jsonregister = "";
 //BA.debugLineNum = 124;BA.debugLine="Dim jsonGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 125;BA.debugLine="Dim usuario_ As usuario";
_usuario_ = new b4a.example.usuario();
 //BA.debugLineNum = 127;BA.debugLine="usuario_.usr_cedula = txt_cedula.Text";
_usuario_._usr_cedula /*String*/  = parent.mostCurrent._txt_cedula.getText();
 //BA.debugLineNum = 128;BA.debugLine="usuario_.usr_primer_nombre = txt_primer_nombre.Te";
_usuario_._usr_primer_nombre /*String*/  = parent.mostCurrent._txt_primer_nombre.getText();
 //BA.debugLineNum = 129;BA.debugLine="usuario_.usr_segundo_nombre = txt_segundo_nombre.";
_usuario_._usr_segundo_nombre /*String*/  = parent.mostCurrent._txt_segundo_nombre.getText();
 //BA.debugLineNum = 130;BA.debugLine="usuario_.usr_primer_apellido = txt_primer_apellid";
_usuario_._usr_primer_apellido /*String*/  = parent.mostCurrent._txt_primer_apellido.getText();
 //BA.debugLineNum = 131;BA.debugLine="usuario_.usr_segundo_apellido = txt_segundo_apell";
_usuario_._usr_segundo_apellido /*String*/  = parent.mostCurrent._txt_segundo_apellido.getText();
 //BA.debugLineNum = 132;BA.debugLine="usr_nombre = txt_primer_nombre.Text & \"\" & txt_pr";
parent._usr_nombre = parent.mostCurrent._txt_primer_nombre.getText()+""+parent.mostCurrent._txt_primer_apellido.getText();
 //BA.debugLineNum = 133;BA.debugLine="usuario_.usr_email = txt_correo.Text";
_usuario_._usr_email /*String*/  = parent.mostCurrent._txt_correo.getText();
 //BA.debugLineNum = 134;BA.debugLine="usr_email_global = txt_correo.Text";
parent._usr_email_global = parent.mostCurrent._txt_correo.getText();
 //BA.debugLineNum = 135;BA.debugLine="usuario_.usr_contrasenia = txt_contrasenia.Text";
_usuario_._usr_contrasenia /*String*/  = parent.mostCurrent._txt_contrasenia.getText();
 //BA.debugLineNum = 136;BA.debugLine="usuario_.usr_fecha_nacimiento = txt_fecha_nacimie";
_usuario_._usr_fecha_nacimiento /*String*/  = parent.mostCurrent._txt_fecha_nacimiento.getText();
 //BA.debugLineNum = 137;BA.debugLine="usuario_.usr_rol = \"2\"";
_usuario_._usr_rol /*String*/  = "2";
 //BA.debugLineNum = 138;BA.debugLine="usuario_.usr_estado = \"H\"";
_usuario_._usr_estado /*String*/  = "H";
 //BA.debugLineNum = 140;BA.debugLine="mapRegister.Initialize";
_mapregister.Initialize();
 //BA.debugLineNum = 141;BA.debugLine="mapRegister.Put(\"usr_cedula\", usuario_.usr_cedula";
_mapregister.Put((Object)("usr_cedula"),(Object)(_usuario_._usr_cedula /*String*/ ));
 //BA.debugLineNum = 142;BA.debugLine="mapRegister.Put(\"usr_primer_nombre\", usuario_.usr";
_mapregister.Put((Object)("usr_primer_nombre"),(Object)(_usuario_._usr_primer_nombre /*String*/ ));
 //BA.debugLineNum = 143;BA.debugLine="mapRegister.Put(\"usr_segundo_nombre\", usuario_.us";
_mapregister.Put((Object)("usr_segundo_nombre"),(Object)(_usuario_._usr_segundo_nombre /*String*/ ));
 //BA.debugLineNum = 144;BA.debugLine="mapRegister.Put(\"usr_primer_apellido\", usuario_.u";
_mapregister.Put((Object)("usr_primer_apellido"),(Object)(_usuario_._usr_primer_apellido /*String*/ ));
 //BA.debugLineNum = 145;BA.debugLine="mapRegister.Put(\"usr_segundo_apellido\", usuario_.";
_mapregister.Put((Object)("usr_segundo_apellido"),(Object)(_usuario_._usr_segundo_apellido /*String*/ ));
 //BA.debugLineNum = 146;BA.debugLine="mapRegister.Put(\"usr_email\", usuario_.usr_email)";
_mapregister.Put((Object)("usr_email"),(Object)(_usuario_._usr_email /*String*/ ));
 //BA.debugLineNum = 147;BA.debugLine="mapRegister.Put(\"usr_contrasenia\", usuario_.usr_c";
_mapregister.Put((Object)("usr_contrasenia"),(Object)(_usuario_._usr_contrasenia /*String*/ ));
 //BA.debugLineNum = 148;BA.debugLine="mapRegister.Put(\"usr_fecha_nacimiento\", usuario_.";
_mapregister.Put((Object)("usr_fecha_nacimiento"),(Object)(_usuario_._usr_fecha_nacimiento /*String*/ ));
 //BA.debugLineNum = 149;BA.debugLine="mapRegister.Put(\"usr_rol\", usuario_.usr_rol)";
_mapregister.Put((Object)("usr_rol"),(Object)(_usuario_._usr_rol /*String*/ ));
 //BA.debugLineNum = 150;BA.debugLine="mapRegister.Put(\"usr_estado\", usuario_.usr_estado";
_mapregister.Put((Object)("usr_estado"),(Object)(_usuario_._usr_estado /*String*/ ));
 //BA.debugLineNum = 152;BA.debugLine="jsonGenerator.Initialize(mapRegister)";
_jsongenerator.Initialize(_mapregister);
 //BA.debugLineNum = 153;BA.debugLine="jsonRegister = jsonGenerator.ToPrettyString(5)";
_jsonregister = _jsongenerator.ToPrettyString((int) (5));
 //BA.debugLineNum = 155;BA.debugLine="Dim peticion As HttpJob";
_peticion = new b4a.example.httpjob();
 //BA.debugLineNum = 156;BA.debugLine="peticion.Initialize(\"\", Me)";
_peticion._initialize /*String*/ (processBA,"",registrousuario.getObject());
 //BA.debugLineNum = 157;BA.debugLine="peticion.PostString(\"https://biblioteca-3q4a.onre";
_peticion._poststring /*String*/ ("https://biblioteca-3q4a.onrender.com/api/usuarios",_jsonregister);
 //BA.debugLineNum = 158;BA.debugLine="peticion.GetRequest.SetContentType(\"application/j";
_peticion._getrequest /*anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest*/ ().SetContentType("application/json");
 //BA.debugLineNum = 160;BA.debugLine="Wait For (peticion) JobDone (respuesta As HttpJob";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_peticion));
this.state = 53;
return;
case 53:
//C
this.state = 47;
_respuesta = (b4a.example.httpjob) result[0];
;
 //BA.debugLineNum = 162;BA.debugLine="If respuesta.Success Then";
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
 //BA.debugLineNum = 164;BA.debugLine="txt_cedula.Text = \"\"";
parent.mostCurrent._txt_cedula.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 165;BA.debugLine="txt_primer_nombre.Text = \"\"";
parent.mostCurrent._txt_primer_nombre.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 166;BA.debugLine="txt_segundo_nombre.Text = \"\"";
parent.mostCurrent._txt_segundo_nombre.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 167;BA.debugLine="txt_primer_apellido.Text = \"\"";
parent.mostCurrent._txt_primer_apellido.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 168;BA.debugLine="txt_segundo_apellido.Text = \"\"";
parent.mostCurrent._txt_segundo_apellido.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 169;BA.debugLine="txt_correo.Text = \"\"";
parent.mostCurrent._txt_correo.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 170;BA.debugLine="txt_contrasenia.Text = \"\"";
parent.mostCurrent._txt_contrasenia.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 171;BA.debugLine="txt_fecha_nacimiento.Text = \"\"";
parent.mostCurrent._txt_fecha_nacimiento.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 173;BA.debugLine="peticion.Release";
_peticion._release /*String*/ ();
 //BA.debugLineNum = 174;BA.debugLine="StartActivity(\"ValidacionUsuario\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ValidacionUsuario"));
 if (true) break;

case 51:
//C
this.state = 52;
 //BA.debugLineNum = 176;BA.debugLine="xui.MsgboxAsync(\"¡Registro fallido! \" & respuest";
parent._xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("¡Registro fallido! "+_respuesta._getstring /*String*/ ()),BA.ObjectToCharSequence("Error"));
 if (true) break;

case 52:
//C
this.state = -1;
;
 //BA.debugLineNum = 178;BA.debugLine="peticion.Release";
_peticion._release /*String*/ ();
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _jobdone(b4a.example.httpjob _respuesta) throws Exception{
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private txt_cedula As EditText";
mostCurrent._txt_cedula = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private txt_primer_nombre As EditText";
mostCurrent._txt_primer_nombre = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private txt_segundo_nombre As EditText";
mostCurrent._txt_segundo_nombre = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private txt_primer_apellido As EditText";
mostCurrent._txt_primer_apellido = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private txt_segundo_apellido As EditText";
mostCurrent._txt_segundo_apellido = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private txt_correo As EditText";
mostCurrent._txt_correo = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private txt_contrasenia As EditText";
mostCurrent._txt_contrasenia = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private txt_fecha_nacimiento As EditText";
mostCurrent._txt_fecha_nacimiento = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 10;BA.debugLine="Public usr_email_global As String";
_usr_email_global = "";
 //BA.debugLineNum = 11;BA.debugLine="Public usr_nombre As String";
_usr_nombre = "";
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
}
