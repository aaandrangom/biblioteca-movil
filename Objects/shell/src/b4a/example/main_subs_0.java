package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(134217728);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,35);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,31);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_registro_click() throws Exception{
try {
		Debug.PushSubsStack("btn_registro_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,101);
if (RapidSub.canDelegate("btn_registro_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btn_registro_click");}
 BA.debugLineNum = 101;BA.debugLine="Private Sub btn_registro_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="StartActivity(\"RegistroUsuario\")";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("RegistroUsuario"))));
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _btniniciarsesion_click() throws Exception{
try {
		Debug.PushSubsStack("btnIniciarSesion_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,39);
if (RapidSub.canDelegate("btniniciarsesion_click")) { b4a.example.main.remoteMe.runUserSub(false, "main","btniniciarsesion_click"); return;}
ResumableSub_btnIniciarSesion_Click rsub = new ResumableSub_btnIniciarSesion_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_btnIniciarSesion_Click extends BA.ResumableSub {
public ResumableSub_btnIniciarSesion_Click(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _usuario_ = RemoteObject.createImmutable("");
RemoteObject _contrasenia = RemoteObject.createImmutable("");
RemoteObject _maplogin = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _jsonlogin = RemoteObject.createImmutable("");
RemoteObject _jsongenerator = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
RemoteObject _login_ = RemoteObject.declareNull("b4a.example.login");
RemoteObject _peticion = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _respuesta = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _mensaje_usuario = RemoteObject.declareNull("Object");
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnIniciarSesion_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,39);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 40;BA.debugLine="Dim usuario_ As String";
Debug.ShouldStop(128);
_usuario_ = RemoteObject.createImmutable("");Debug.locals.put("usuario_", _usuario_);
 BA.debugLineNum = 41;BA.debugLine="usuario_ = txt_usuario.Text";
Debug.ShouldStop(256);
_usuario_ = parent.mostCurrent._txt_usuario.runMethod(true,"getText");Debug.locals.put("usuario_", _usuario_);
 BA.debugLineNum = 43;BA.debugLine="If usuario_ = \"\" Then";
Debug.ShouldStop(1024);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_usuario_,BA.ObjectToString(""))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 44;BA.debugLine="xui.MsgboxAsync(\"¡El usuario no puede estar vací";
Debug.ShouldStop(2048);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("¡El usuario no puede estar vacío!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 45;BA.debugLine="Return";
Debug.ShouldStop(4096);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 47;BA.debugLine="If usuario_.Length > 20 Then";
Debug.ShouldStop(16384);

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean(">",_usuario_.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 48;BA.debugLine="xui.MsgboxAsync(\"¡El usuario no puede contener m";
Debug.ShouldStop(32768);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("¡El usuario no puede contener más de 20 caracteres!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 49;BA.debugLine="Return";
Debug.ShouldStop(65536);
if (true) return ;
 if (true) break;

case 7:
//C
this.state = 8;
;
 BA.debugLineNum = 52;BA.debugLine="Dim contrasenia As String";
Debug.ShouldStop(524288);
_contrasenia = RemoteObject.createImmutable("");Debug.locals.put("contrasenia", _contrasenia);
 BA.debugLineNum = 53;BA.debugLine="contrasenia = txt_contrasenia.Text";
Debug.ShouldStop(1048576);
_contrasenia = parent.mostCurrent._txt_contrasenia.runMethod(true,"getText");Debug.locals.put("contrasenia", _contrasenia);
 BA.debugLineNum = 55;BA.debugLine="If contrasenia = \"\" Then";
Debug.ShouldStop(4194304);
if (true) break;

case 8:
//if
this.state = 11;
if (RemoteObject.solveBoolean("=",_contrasenia,BA.ObjectToString(""))) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 56;BA.debugLine="xui.MsgboxAsync(\"¡La contraseña no puede estar v";
Debug.ShouldStop(8388608);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("¡La contraseña no puede estar vacía!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 57;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 59;BA.debugLine="If contrasenia.Length > 15 Then";
Debug.ShouldStop(67108864);

case 11:
//if
this.state = 14;
if (RemoteObject.solveBoolean(">",_contrasenia.runMethod(true,"length"),BA.numberCast(double.class, 15))) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 60;BA.debugLine="xui.MsgboxAsync(\"¡La contraseña no puede contene";
Debug.ShouldStop(134217728);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("¡La contraseña no puede contener más de 15 caracteres!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 61;BA.debugLine="Return";
Debug.ShouldStop(268435456);
if (true) return ;
 if (true) break;

case 14:
//C
this.state = 15;
;
 BA.debugLineNum = 64;BA.debugLine="Dim mapLogin As Map";
Debug.ShouldStop(-2147483648);
_maplogin = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mapLogin", _maplogin);
 BA.debugLineNum = 65;BA.debugLine="Dim jsonLogin As String";
Debug.ShouldStop(1);
_jsonlogin = RemoteObject.createImmutable("");Debug.locals.put("jsonLogin", _jsonlogin);
 BA.debugLineNum = 66;BA.debugLine="Dim jsonGenerator As JSONGenerator";
Debug.ShouldStop(2);
_jsongenerator = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("jsonGenerator", _jsongenerator);
 BA.debugLineNum = 67;BA.debugLine="Dim login_ As login";
Debug.ShouldStop(4);
_login_ = RemoteObject.createNew ("b4a.example.login");Debug.locals.put("login_", _login_);
 BA.debugLineNum = 69;BA.debugLine="login_.usr_nickname = usuario_";
Debug.ShouldStop(16);
_login_.setField ("_usr_nickname" /*RemoteObject*/ ,_usuario_);
 BA.debugLineNum = 70;BA.debugLine="login_.usr_contrasenia = contrasenia";
Debug.ShouldStop(32);
_login_.setField ("_usr_contrasenia" /*RemoteObject*/ ,_contrasenia);
 BA.debugLineNum = 72;BA.debugLine="mapLogin.Initialize";
Debug.ShouldStop(128);
_maplogin.runVoidMethod ("Initialize");
 BA.debugLineNum = 73;BA.debugLine="mapLogin.Put(\"usr_nickname\", login_.usr_nickname)";
Debug.ShouldStop(256);
_maplogin.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_nickname"))),(Object)((_login_.getField(true,"_usr_nickname" /*RemoteObject*/ ))));
 BA.debugLineNum = 74;BA.debugLine="mapLogin.Put(\"usr_contrasenia\", login_.usr_contra";
Debug.ShouldStop(512);
_maplogin.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_contrasenia"))),(Object)((_login_.getField(true,"_usr_contrasenia" /*RemoteObject*/ ))));
 BA.debugLineNum = 76;BA.debugLine="jsonGenerator.Initialize(mapLogin)";
Debug.ShouldStop(2048);
_jsongenerator.runVoidMethod ("Initialize",(Object)(_maplogin));
 BA.debugLineNum = 77;BA.debugLine="jsonLogin = jsonGenerator.ToPrettyString(5)";
Debug.ShouldStop(4096);
_jsonlogin = _jsongenerator.runMethod(true,"ToPrettyString",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("jsonLogin", _jsonlogin);
 BA.debugLineNum = 79;BA.debugLine="Dim peticion As HttpJob";
Debug.ShouldStop(16384);
_peticion = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("peticion", _peticion);
 BA.debugLineNum = 80;BA.debugLine="peticion.Initialize(\"\", Me)";
Debug.ShouldStop(32768);
_peticion.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("")),(Object)(main.getObject()));
 BA.debugLineNum = 81;BA.debugLine="peticion.PostString(\"https://biblioteca-3q4a.onre";
Debug.ShouldStop(65536);
_peticion.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://biblioteca-3q4a.onrender.com/api/auth/login")),(Object)(_jsonlogin));
 BA.debugLineNum = 82;BA.debugLine="peticion.GetRequest.SetContentType(\"application/j";
Debug.ShouldStop(131072);
_peticion.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 84;BA.debugLine="Wait For (peticion) JobDone (respuesta As HttpJob";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "btniniciarsesion_click"), (_peticion));
this.state = 25;
return;
case 25:
//C
this.state = 15;
_respuesta = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("respuesta", _respuesta);
;
 BA.debugLineNum = 86;BA.debugLine="If respuesta.Success Then";
Debug.ShouldStop(2097152);
if (true) break;

case 15:
//if
this.state = 24;
if (_respuesta.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 17;
}else {
this.state = 23;
}if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 87;BA.debugLine="Dim mensaje_usuario As Object = xui.Msgbox2Async";
Debug.ShouldStop(4194304);
_mensaje_usuario = parent._xui.runMethod(false,"Msgbox2Async",main.processBA,(Object)(BA.ObjectToCharSequence("¡Login exitoso!.")),(Object)(BA.ObjectToCharSequence("SUCCESS")),(Object)(BA.ObjectToString("Aceptar")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")));Debug.locals.put("mensaje_usuario", _mensaje_usuario);Debug.locals.put("mensaje_usuario", _mensaje_usuario);
 BA.debugLineNum = 88;BA.debugLine="Wait For (mensaje_usuario) Msgbox_Result (Result";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "btniniciarsesion_click"), _mensaje_usuario);
this.state = 26;
return;
case 26:
//C
this.state = 18;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 89;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
Debug.ShouldStop(16777216);
if (true) break;

case 18:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent._xui.getField(true,"DialogResponse_Positive")))) { 
this.state = 20;
}if (true) break;

case 20:
//C
this.state = 21;
 BA.debugLineNum = 90;BA.debugLine="peticion.Release";
Debug.ShouldStop(33554432);
_peticion.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 91;BA.debugLine="StartActivity(\"Principal\")";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Principal"))));
 if (true) break;

case 21:
//C
this.state = 24;
;
 if (true) break;

case 23:
//C
this.state = 24;
 BA.debugLineNum = 94;BA.debugLine="xui.MsgboxAsync(\"¡Login fallido!\", \"ERROR\")";
Debug.ShouldStop(536870912);
parent._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("¡Login fallido!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ERROR"))));
 if (true) break;

case 24:
//C
this.state = -1;
;
 BA.debugLineNum = 96;BA.debugLine="peticion.Release";
Debug.ShouldStop(-2147483648);
_peticion.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _jobdone(RemoteObject _respuesta) throws Exception{
}
public static void  _msgbox_result(RemoteObject _result) throws Exception{
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private txt_usuario As EditText";
main.mostCurrent._txt_usuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private txt_contrasenia As EditText";
main.mostCurrent._txt_contrasenia = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
registrousuario_subs_0._process_globals();
validacionusuario_subs_0._process_globals();
principal_subs_0._process_globals();
starter_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
registrousuario.myClass = BA.getDeviceClass ("b4a.example.registrousuario");
validacionusuario.myClass = BA.getDeviceClass ("b4a.example.validacionusuario");
principal.myClass = BA.getDeviceClass ("b4a.example.principal");
slidemenu.myClass = BA.getDeviceClass ("b4a.example.slidemenu");
login.myClass = BA.getDeviceClass ("b4a.example.login");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
usuario.myClass = BA.getDeviceClass ("b4a.example.usuario");
validacioncodigousuario.myClass = BA.getDeviceClass ("b4a.example.validacioncodigousuario");
b4xdrawer.myClass = BA.getDeviceClass ("b4a.example.b4xdrawer");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}