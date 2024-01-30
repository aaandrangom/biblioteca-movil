package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class validacionusuario_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (validacionusuario) ","validacionusuario",2,validacionusuario.mostCurrent.activityBA,validacionusuario.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.validacionusuario.remoteMe.runUserSub(false, "validacionusuario","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"layoutValidacionUsuario\")";
Debug.ShouldStop(2097152);
validacionusuario.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("layoutValidacionUsuario")),validacionusuario.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="xui.MsgboxAsync(\"¡Registro exitoso!\", \"OK\")";
Debug.ShouldStop(4194304);
validacionusuario._xui.runVoidMethod ("MsgboxAsync",validacionusuario.processBA,(Object)(BA.ObjectToCharSequence("¡Registro exitoso!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("OK"))));
 BA.debugLineNum = 24;BA.debugLine="lbl_nombre_usuario.Text = \"Estimado @\" & Registro";
Debug.ShouldStop(8388608);
validacionusuario.mostCurrent._lbl_nombre_usuario.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Estimado @"),validacionusuario.mostCurrent._registrousuario._usr_nombre /*RemoteObject*/ )));
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (validacionusuario) ","validacionusuario",2,validacionusuario.mostCurrent.activityBA,validacionusuario.mostCurrent,31);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.validacionusuario.remoteMe.runUserSub(false, "validacionusuario","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (validacionusuario) ","validacionusuario",2,validacionusuario.mostCurrent.activityBA,validacionusuario.mostCurrent,27);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.validacionusuario.remoteMe.runUserSub(false, "validacionusuario","activity_resume");}
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
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
public static void  _btn_validar_usuario_click() throws Exception{
try {
		Debug.PushSubsStack("btn_validar_usuario_Click (validacionusuario) ","validacionusuario",2,validacionusuario.mostCurrent.activityBA,validacionusuario.mostCurrent,36);
if (RapidSub.canDelegate("btn_validar_usuario_click")) { b4a.example.validacionusuario.remoteMe.runUserSub(false, "validacionusuario","btn_validar_usuario_click"); return;}
ResumableSub_btn_validar_usuario_Click rsub = new ResumableSub_btn_validar_usuario_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_btn_validar_usuario_Click extends BA.ResumableSub {
public ResumableSub_btn_validar_usuario_Click(b4a.example.validacionusuario parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.validacionusuario parent;
RemoteObject _mapvalidation = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _jsonvalidation = RemoteObject.createImmutable("");
RemoteObject _jsongenerator = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
RemoteObject _validacion_ = RemoteObject.declareNull("b4a.example.validacioncodigousuario");
RemoteObject _peticion = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _respuesta = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _jsonparser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _user = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _nickname = RemoteObject.createImmutable("");
RemoteObject _mensaje_usuario = RemoteObject.declareNull("Object");
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btn_validar_usuario_Click (validacionusuario) ","validacionusuario",2,validacionusuario.mostCurrent.activityBA,validacionusuario.mostCurrent,36);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 37;BA.debugLine="If txt_codigo_verificacion.Text = \"\" Then";
Debug.ShouldStop(16);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txt_codigo_verificacion.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 38;BA.debugLine="xui.MsgboxAsync(\"No puede quedar vacio el código";
Debug.ShouldStop(32);
parent._xui.runVoidMethod ("MsgboxAsync",validacionusuario.processBA,(Object)(BA.ObjectToCharSequence("No puede quedar vacio el código único!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 39;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 42;BA.debugLine="Dim mapValidation As Map";
Debug.ShouldStop(512);
_mapvalidation = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mapValidation", _mapvalidation);
 BA.debugLineNum = 43;BA.debugLine="Dim jsonValidation As String";
Debug.ShouldStop(1024);
_jsonvalidation = RemoteObject.createImmutable("");Debug.locals.put("jsonValidation", _jsonvalidation);
 BA.debugLineNum = 44;BA.debugLine="Dim jsonGenerator As JSONGenerator";
Debug.ShouldStop(2048);
_jsongenerator = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("jsonGenerator", _jsongenerator);
 BA.debugLineNum = 45;BA.debugLine="Dim validacion_ As validacionCodigoUsuario";
Debug.ShouldStop(4096);
_validacion_ = RemoteObject.createNew ("b4a.example.validacioncodigousuario");Debug.locals.put("validacion_", _validacion_);
 BA.debugLineNum = 47;BA.debugLine="validacion_.usr_email = RegistroUsuario.usr_email";
Debug.ShouldStop(16384);
_validacion_.setField ("_usr_email" /*RemoteObject*/ ,parent.mostCurrent._registrousuario._usr_email_global /*RemoteObject*/ );
 BA.debugLineNum = 48;BA.debugLine="validacion_.codigoVerificacion = txt_codigo_verif";
Debug.ShouldStop(32768);
_validacion_.setField ("_codigoverificacion" /*RemoteObject*/ ,parent.mostCurrent._txt_codigo_verificacion.runMethod(true,"getText"));
 BA.debugLineNum = 50;BA.debugLine="mapValidation.Initialize";
Debug.ShouldStop(131072);
_mapvalidation.runVoidMethod ("Initialize");
 BA.debugLineNum = 51;BA.debugLine="mapValidation.Put(\"usr_email\", validacion_.usr_em";
Debug.ShouldStop(262144);
_mapvalidation.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_email"))),(Object)((_validacion_.getField(true,"_usr_email" /*RemoteObject*/ ))));
 BA.debugLineNum = 52;BA.debugLine="mapValidation.Put(\"codigoVerificacion\", validacio";
Debug.ShouldStop(524288);
_mapvalidation.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("codigoVerificacion"))),(Object)((_validacion_.getField(true,"_codigoverificacion" /*RemoteObject*/ ))));
 BA.debugLineNum = 54;BA.debugLine="jsonGenerator.Initialize(mapValidation)";
Debug.ShouldStop(2097152);
_jsongenerator.runVoidMethod ("Initialize",(Object)(_mapvalidation));
 BA.debugLineNum = 55;BA.debugLine="jsonValidation = jsonGenerator.ToPrettyString(5)";
Debug.ShouldStop(4194304);
_jsonvalidation = _jsongenerator.runMethod(true,"ToPrettyString",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("jsonValidation", _jsonvalidation);
 BA.debugLineNum = 57;BA.debugLine="Dim peticion As HttpJob";
Debug.ShouldStop(16777216);
_peticion = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("peticion", _peticion);
 BA.debugLineNum = 58;BA.debugLine="peticion.Initialize(\"\", Me)";
Debug.ShouldStop(33554432);
_peticion.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,validacionusuario.processBA,(Object)(BA.ObjectToString("")),(Object)(validacionusuario.getObject()));
 BA.debugLineNum = 59;BA.debugLine="peticion.PostString(\"https://biblioteca-3q4a.onre";
Debug.ShouldStop(67108864);
_peticion.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://biblioteca-3q4a.onrender.com/api/usuarios/verificar")),(Object)(_jsonvalidation));
 BA.debugLineNum = 60;BA.debugLine="peticion.GetRequest.SetContentType(\"application/j";
Debug.ShouldStop(134217728);
_peticion.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 62;BA.debugLine="Wait For (peticion) JobDone (respuesta As HttpJob";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", validacionusuario.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "validacionusuario", "btn_validar_usuario_click"), (_peticion));
this.state = 15;
return;
case 15:
//C
this.state = 5;
_respuesta = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("respuesta", _respuesta);
;
 BA.debugLineNum = 64;BA.debugLine="If respuesta.Success Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 5:
//if
this.state = 14;
if (_respuesta.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 7;
}else {
this.state = 13;
}if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 65;BA.debugLine="Dim jsonParser As JSONParser";
Debug.ShouldStop(1);
_jsonparser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("jsonParser", _jsonparser);
 BA.debugLineNum = 66;BA.debugLine="jsonParser.Initialize(respuesta.GetString)";
Debug.ShouldStop(2);
_jsonparser.runVoidMethod ("Initialize",(Object)(_respuesta.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 67;BA.debugLine="Dim user As Map";
Debug.ShouldStop(4);
_user = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("user", _user);
 BA.debugLineNum = 68;BA.debugLine="user = jsonParser.NextObject.Get(\"usuario\")";
Debug.ShouldStop(8);
_user = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _jsonparser.runMethod(false,"NextObject").runMethod(false,"Get",(Object)((RemoteObject.createImmutable("usuario")))));Debug.locals.put("user", _user);
 BA.debugLineNum = 69;BA.debugLine="Dim nickname As String";
Debug.ShouldStop(16);
_nickname = RemoteObject.createImmutable("");Debug.locals.put("nickname", _nickname);
 BA.debugLineNum = 70;BA.debugLine="nickname = user.Get(\"usr_nickname\")";
Debug.ShouldStop(32);
_nickname = BA.ObjectToString(_user.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("usr_nickname")))));Debug.locals.put("nickname", _nickname);
 BA.debugLineNum = 72;BA.debugLine="Dim mensaje_usuario As Object = xui.Msgbox2Async";
Debug.ShouldStop(128);
_mensaje_usuario = parent._xui.runMethod(false,"Msgbox2Async",validacionusuario.processBA,(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("¡Verificacion exitosa!. Tu nuevo usuario es el siguiente: "),_nickname))),(Object)(BA.ObjectToCharSequence("Ok")),(Object)(BA.ObjectToString("Aceptar")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")));Debug.locals.put("mensaje_usuario", _mensaje_usuario);Debug.locals.put("mensaje_usuario", _mensaje_usuario);
 BA.debugLineNum = 73;BA.debugLine="txt_codigo_verificacion.Text = \"\"";
Debug.ShouldStop(256);
parent.mostCurrent._txt_codigo_verificacion.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 74;BA.debugLine="Wait For (mensaje_usuario) Msgbox_Result (Resul";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", validacionusuario.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "validacionusuario", "btn_validar_usuario_click"), _mensaje_usuario);
this.state = 16;
return;
case 16:
//C
this.state = 8;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 75;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
Debug.ShouldStop(1024);
if (true) break;

case 8:
//if
this.state = 11;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent._xui.getField(true,"DialogResponse_Positive")))) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 76;BA.debugLine="peticion.Release";
Debug.ShouldStop(2048);
_peticion.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 77;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",validacionusuario.processBA,(Object)((RemoteObject.createImmutable("Main"))));
 if (true) break;

case 11:
//C
this.state = 14;
;
 if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 80;BA.debugLine="xui.MsgboxAsync(\"¡Verificacion fallida! \" & resp";
Debug.ShouldStop(32768);
parent._xui.runVoidMethod ("MsgboxAsync",validacionusuario.processBA,(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("¡Verificacion fallida! "),_respuesta.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 if (true) break;

case 14:
//C
this.state = -1;
;
 BA.debugLineNum = 82;BA.debugLine="peticion.Release";
Debug.ShouldStop(131072);
_peticion.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private txt_codigo_verificacion As EditText";
validacionusuario.mostCurrent._txt_codigo_verificacion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private lbl_nombre_usuario As Label";
validacionusuario.mostCurrent._lbl_nombre_usuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private xui As XUI";
validacionusuario._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}