package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registrousuario_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registrousuario) ","registrousuario",1,registrousuario.mostCurrent.activityBA,registrousuario.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.registrousuario.remoteMe.runUserSub(false, "registrousuario","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"layoutRegistroUsuario\")";
Debug.ShouldStop(536870912);
registrousuario.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("layoutRegistroUsuario")),registrousuario.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Activity_Pause (registrousuario) ","registrousuario",1,registrousuario.mostCurrent.activityBA,registrousuario.mostCurrent,37);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.registrousuario.remoteMe.runUserSub(false, "registrousuario","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Resume (registrousuario) ","registrousuario",1,registrousuario.mostCurrent.activityBA,registrousuario.mostCurrent,33);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.registrousuario.remoteMe.runUserSub(false, "registrousuario","activity_resume");}
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_calendario_fecha_nacimiento_click() throws Exception{
try {
		Debug.PushSubsStack("btn_calendario_fecha_nacimiento_Click (registrousuario) ","registrousuario",1,registrousuario.mostCurrent.activityBA,registrousuario.mostCurrent,41);
if (RapidSub.canDelegate("btn_calendario_fecha_nacimiento_click")) { return b4a.example.registrousuario.remoteMe.runUserSub(false, "registrousuario","btn_calendario_fecha_nacimiento_click");}
 BA.debugLineNum = 41;BA.debugLine="Private Sub btn_calendario_fecha_nacimiento_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_iniciar_sesion_click() throws Exception{
try {
		Debug.PushSubsStack("btn_iniciar_sesion_Click (registrousuario) ","registrousuario",1,registrousuario.mostCurrent.activityBA,registrousuario.mostCurrent,182);
if (RapidSub.canDelegate("btn_iniciar_sesion_click")) { return b4a.example.registrousuario.remoteMe.runUserSub(false, "registrousuario","btn_iniciar_sesion_click");}
 BA.debugLineNum = 182;BA.debugLine="Private Sub btn_iniciar_sesion_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 183;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(4194304);
registrousuario.mostCurrent.__c.runVoidMethod ("StartActivity",registrousuario.processBA,(Object)((RemoteObject.createImmutable("Main"))));
 BA.debugLineNum = 184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _btn_registrar_usuario_click() throws Exception{
try {
		Debug.PushSubsStack("btn_registrar_usuario_Click (registrousuario) ","registrousuario",1,registrousuario.mostCurrent.activityBA,registrousuario.mostCurrent,45);
if (RapidSub.canDelegate("btn_registrar_usuario_click")) { b4a.example.registrousuario.remoteMe.runUserSub(false, "registrousuario","btn_registrar_usuario_click"); return;}
ResumableSub_btn_registrar_usuario_Click rsub = new ResumableSub_btn_registrar_usuario_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_btn_registrar_usuario_Click extends BA.ResumableSub {
public ResumableSub_btn_registrar_usuario_Click(b4a.example.registrousuario parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.registrousuario parent;
RemoteObject _mapregister = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _jsonregister = RemoteObject.createImmutable("");
RemoteObject _jsongenerator = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
RemoteObject _usuario_ = RemoteObject.declareNull("b4a.example.usuario");
RemoteObject _peticion = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _respuesta = RemoteObject.declareNull("b4a.example.httpjob");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btn_registrar_usuario_Click (registrousuario) ","registrousuario",1,registrousuario.mostCurrent.activityBA,registrousuario.mostCurrent,45);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 47;BA.debugLine="If txt_cedula.Text = \"\" Then";
Debug.ShouldStop(16384);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txt_cedula.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 48;BA.debugLine="xui.MsgboxAsync(\"El campo 'Cédula' no puede esta";
Debug.ShouldStop(32768);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Cédula' no puede estar vacío.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 49;BA.debugLine="Return";
Debug.ShouldStop(65536);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 52;BA.debugLine="If txt_cedula.Text.Length > 13 Then";
Debug.ShouldStop(524288);

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean(">",parent.mostCurrent._txt_cedula.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 13))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 53;BA.debugLine="xui.MsgboxAsync(\"La cédula no puede tener más de";
Debug.ShouldStop(1048576);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("La cédula no puede tener más de 13 caracteres.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 54;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 57;BA.debugLine="If txt_primer_nombre.Text = \"\" Then";
Debug.ShouldStop(16777216);

case 7:
//if
this.state = 10;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txt_primer_nombre.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 58;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Nombre' no pue";
Debug.ShouldStop(33554432);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Primer Nombre' no puede estar vacío.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 59;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 62;BA.debugLine="If txt_segundo_nombre.Text = \"\" Then";
Debug.ShouldStop(536870912);

case 10:
//if
this.state = 13;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txt_segundo_nombre.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 63;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Nombre' no pu";
Debug.ShouldStop(1073741824);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Segundo Nombre' no puede estar vacío.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 64;BA.debugLine="Return";
Debug.ShouldStop(-2147483648);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 67;BA.debugLine="If txt_primer_apellido.Text = \"\" Then";
Debug.ShouldStop(4);

case 13:
//if
this.state = 16;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txt_primer_apellido.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
 BA.debugLineNum = 68;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Apellido' no p";
Debug.ShouldStop(8);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Primer Apellido' no puede estar vacío.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 69;BA.debugLine="Return";
Debug.ShouldStop(16);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 72;BA.debugLine="If txt_segundo_apellido.Text = \"\" Then";
Debug.ShouldStop(128);

case 16:
//if
this.state = 19;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txt_segundo_apellido.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 18;
}if (true) break;

case 18:
//C
this.state = 19;
 BA.debugLineNum = 73;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Apellido' no";
Debug.ShouldStop(256);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Segundo Apellido' no puede estar vacío.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 74;BA.debugLine="Return";
Debug.ShouldStop(512);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 77;BA.debugLine="If txt_primer_nombre.Text.Length > 100 Then";
Debug.ShouldStop(4096);

case 19:
//if
this.state = 22;
if (RemoteObject.solveBoolean(">",parent.mostCurrent._txt_primer_nombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 100))) { 
this.state = 21;
}if (true) break;

case 21:
//C
this.state = 22;
 BA.debugLineNum = 78;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Nombre' no pue";
Debug.ShouldStop(8192);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Primer Nombre' no puede tener más de 100 caracteres.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 79;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 82;BA.debugLine="If txt_segundo_nombre.Text.Length > 100 Then";
Debug.ShouldStop(131072);

case 22:
//if
this.state = 25;
if (RemoteObject.solveBoolean(">",parent.mostCurrent._txt_segundo_nombre.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 100))) { 
this.state = 24;
}if (true) break;

case 24:
//C
this.state = 25;
 BA.debugLineNum = 83;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Nombre' no pu";
Debug.ShouldStop(262144);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Segundo Nombre' no puede tener más de 100 caracteres.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 84;BA.debugLine="Return";
Debug.ShouldStop(524288);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 87;BA.debugLine="If txt_primer_apellido.Text.Length > 100 Then";
Debug.ShouldStop(4194304);

case 25:
//if
this.state = 28;
if (RemoteObject.solveBoolean(">",parent.mostCurrent._txt_primer_apellido.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 100))) { 
this.state = 27;
}if (true) break;

case 27:
//C
this.state = 28;
 BA.debugLineNum = 88;BA.debugLine="xui.MsgboxAsync(\"El campo 'Primer Apellido' no p";
Debug.ShouldStop(8388608);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Primer Apellido' no puede tener más de 100 caracteres.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 89;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 92;BA.debugLine="If txt_segundo_apellido.Text.Length > 100 Then";
Debug.ShouldStop(134217728);

case 28:
//if
this.state = 31;
if (RemoteObject.solveBoolean(">",parent.mostCurrent._txt_segundo_apellido.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 100))) { 
this.state = 30;
}if (true) break;

case 30:
//C
this.state = 31;
 BA.debugLineNum = 93;BA.debugLine="xui.MsgboxAsync(\"El campo 'Segundo Apellido' no";
Debug.ShouldStop(268435456);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Segundo Apellido' no puede tener más de 100 caracteres.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 94;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 97;BA.debugLine="If txt_correo.Text = \"\" Then";
Debug.ShouldStop(1);

case 31:
//if
this.state = 34;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txt_correo.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 33;
}if (true) break;

case 33:
//C
this.state = 34;
 BA.debugLineNum = 98;BA.debugLine="xui.MsgboxAsync(\"El campo 'Correo' no puede esta";
Debug.ShouldStop(2);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Correo' no puede estar vacío.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 99;BA.debugLine="Return";
Debug.ShouldStop(4);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 102;BA.debugLine="If txt_correo.Text.Length > 250 Then";
Debug.ShouldStop(32);

case 34:
//if
this.state = 37;
if (RemoteObject.solveBoolean(">",parent.mostCurrent._txt_correo.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 250))) { 
this.state = 36;
}if (true) break;

case 36:
//C
this.state = 37;
 BA.debugLineNum = 103;BA.debugLine="xui.MsgboxAsync(\"El campo 'Correo/email' no pued";
Debug.ShouldStop(64);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Correo/email' no puede tener más de 250 caracteres.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 104;BA.debugLine="Return";
Debug.ShouldStop(128);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 107;BA.debugLine="If txt_contrasenia.Text = \"\" Then";
Debug.ShouldStop(1024);

case 37:
//if
this.state = 40;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txt_contrasenia.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 39;
}if (true) break;

case 39:
//C
this.state = 40;
 BA.debugLineNum = 108;BA.debugLine="xui.MsgboxAsync(\"El campo 'Contraseña' no puede";
Debug.ShouldStop(2048);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Contraseña' no puede estar vacío.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 109;BA.debugLine="Return";
Debug.ShouldStop(4096);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 112;BA.debugLine="If txt_contrasenia.Text.Length > 15 Then";
Debug.ShouldStop(32768);

case 40:
//if
this.state = 43;
if (RemoteObject.solveBoolean(">",parent.mostCurrent._txt_contrasenia.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 15))) { 
this.state = 42;
}if (true) break;

case 42:
//C
this.state = 43;
 BA.debugLineNum = 113;BA.debugLine="xui.MsgboxAsync(\"¡La contraseña no puede contene";
Debug.ShouldStop(65536);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("¡La contraseña no puede contener más de 15 caracteres!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 114;BA.debugLine="Return";
Debug.ShouldStop(131072);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 117;BA.debugLine="If txt_fecha_nacimiento.Text = \"\" Then";
Debug.ShouldStop(1048576);

case 43:
//if
this.state = 46;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._txt_fecha_nacimiento.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 45;
}if (true) break;

case 45:
//C
this.state = 46;
 BA.debugLineNum = 118;BA.debugLine="xui.MsgboxAsync(\"El campo 'Fecha de Nacimiento'";
Debug.ShouldStop(2097152);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence("El campo 'Fecha de Nacimiento' no puede estar vacío.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 BA.debugLineNum = 119;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return ;
 if (true) break;

case 46:
//C
this.state = 47;
;
 BA.debugLineNum = 122;BA.debugLine="Dim mapRegister As Map";
Debug.ShouldStop(33554432);
_mapregister = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mapRegister", _mapregister);
 BA.debugLineNum = 123;BA.debugLine="Dim jsonRegister As String";
Debug.ShouldStop(67108864);
_jsonregister = RemoteObject.createImmutable("");Debug.locals.put("jsonRegister", _jsonregister);
 BA.debugLineNum = 124;BA.debugLine="Dim jsonGenerator As JSONGenerator";
Debug.ShouldStop(134217728);
_jsongenerator = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("jsonGenerator", _jsongenerator);
 BA.debugLineNum = 125;BA.debugLine="Dim usuario_ As usuario";
Debug.ShouldStop(268435456);
_usuario_ = RemoteObject.createNew ("b4a.example.usuario");Debug.locals.put("usuario_", _usuario_);
 BA.debugLineNum = 127;BA.debugLine="usuario_.usr_cedula = txt_cedula.Text";
Debug.ShouldStop(1073741824);
_usuario_.setField ("_usr_cedula" /*RemoteObject*/ ,parent.mostCurrent._txt_cedula.runMethod(true,"getText"));
 BA.debugLineNum = 128;BA.debugLine="usuario_.usr_primer_nombre = txt_primer_nombre.Te";
Debug.ShouldStop(-2147483648);
_usuario_.setField ("_usr_primer_nombre" /*RemoteObject*/ ,parent.mostCurrent._txt_primer_nombre.runMethod(true,"getText"));
 BA.debugLineNum = 129;BA.debugLine="usuario_.usr_segundo_nombre = txt_segundo_nombre.";
Debug.ShouldStop(1);
_usuario_.setField ("_usr_segundo_nombre" /*RemoteObject*/ ,parent.mostCurrent._txt_segundo_nombre.runMethod(true,"getText"));
 BA.debugLineNum = 130;BA.debugLine="usuario_.usr_primer_apellido = txt_primer_apellid";
Debug.ShouldStop(2);
_usuario_.setField ("_usr_primer_apellido" /*RemoteObject*/ ,parent.mostCurrent._txt_primer_apellido.runMethod(true,"getText"));
 BA.debugLineNum = 131;BA.debugLine="usuario_.usr_segundo_apellido = txt_segundo_apell";
Debug.ShouldStop(4);
_usuario_.setField ("_usr_segundo_apellido" /*RemoteObject*/ ,parent.mostCurrent._txt_segundo_apellido.runMethod(true,"getText"));
 BA.debugLineNum = 132;BA.debugLine="usr_nombre = txt_primer_nombre.Text & \"\" & txt_pr";
Debug.ShouldStop(8);
parent._usr_nombre = RemoteObject.concat(parent.mostCurrent._txt_primer_nombre.runMethod(true,"getText"),RemoteObject.createImmutable(""),parent.mostCurrent._txt_primer_apellido.runMethod(true,"getText"));
 BA.debugLineNum = 133;BA.debugLine="usuario_.usr_email = txt_correo.Text";
Debug.ShouldStop(16);
_usuario_.setField ("_usr_email" /*RemoteObject*/ ,parent.mostCurrent._txt_correo.runMethod(true,"getText"));
 BA.debugLineNum = 134;BA.debugLine="usr_email_global = txt_correo.Text";
Debug.ShouldStop(32);
parent._usr_email_global = parent.mostCurrent._txt_correo.runMethod(true,"getText");
 BA.debugLineNum = 135;BA.debugLine="usuario_.usr_contrasenia = txt_contrasenia.Text";
Debug.ShouldStop(64);
_usuario_.setField ("_usr_contrasenia" /*RemoteObject*/ ,parent.mostCurrent._txt_contrasenia.runMethod(true,"getText"));
 BA.debugLineNum = 136;BA.debugLine="usuario_.usr_fecha_nacimiento = txt_fecha_nacimie";
Debug.ShouldStop(128);
_usuario_.setField ("_usr_fecha_nacimiento" /*RemoteObject*/ ,parent.mostCurrent._txt_fecha_nacimiento.runMethod(true,"getText"));
 BA.debugLineNum = 137;BA.debugLine="usuario_.usr_rol = \"2\"";
Debug.ShouldStop(256);
_usuario_.setField ("_usr_rol" /*RemoteObject*/ ,BA.ObjectToString("2"));
 BA.debugLineNum = 138;BA.debugLine="usuario_.usr_estado = \"H\"";
Debug.ShouldStop(512);
_usuario_.setField ("_usr_estado" /*RemoteObject*/ ,BA.ObjectToString("H"));
 BA.debugLineNum = 140;BA.debugLine="mapRegister.Initialize";
Debug.ShouldStop(2048);
_mapregister.runVoidMethod ("Initialize");
 BA.debugLineNum = 141;BA.debugLine="mapRegister.Put(\"usr_cedula\", usuario_.usr_cedula";
Debug.ShouldStop(4096);
_mapregister.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_cedula"))),(Object)((_usuario_.getField(true,"_usr_cedula" /*RemoteObject*/ ))));
 BA.debugLineNum = 142;BA.debugLine="mapRegister.Put(\"usr_primer_nombre\", usuario_.usr";
Debug.ShouldStop(8192);
_mapregister.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_primer_nombre"))),(Object)((_usuario_.getField(true,"_usr_primer_nombre" /*RemoteObject*/ ))));
 BA.debugLineNum = 143;BA.debugLine="mapRegister.Put(\"usr_segundo_nombre\", usuario_.us";
Debug.ShouldStop(16384);
_mapregister.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_segundo_nombre"))),(Object)((_usuario_.getField(true,"_usr_segundo_nombre" /*RemoteObject*/ ))));
 BA.debugLineNum = 144;BA.debugLine="mapRegister.Put(\"usr_primer_apellido\", usuario_.u";
Debug.ShouldStop(32768);
_mapregister.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_primer_apellido"))),(Object)((_usuario_.getField(true,"_usr_primer_apellido" /*RemoteObject*/ ))));
 BA.debugLineNum = 145;BA.debugLine="mapRegister.Put(\"usr_segundo_apellido\", usuario_.";
Debug.ShouldStop(65536);
_mapregister.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_segundo_apellido"))),(Object)((_usuario_.getField(true,"_usr_segundo_apellido" /*RemoteObject*/ ))));
 BA.debugLineNum = 146;BA.debugLine="mapRegister.Put(\"usr_email\", usuario_.usr_email)";
Debug.ShouldStop(131072);
_mapregister.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_email"))),(Object)((_usuario_.getField(true,"_usr_email" /*RemoteObject*/ ))));
 BA.debugLineNum = 147;BA.debugLine="mapRegister.Put(\"usr_contrasenia\", usuario_.usr_c";
Debug.ShouldStop(262144);
_mapregister.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_contrasenia"))),(Object)((_usuario_.getField(true,"_usr_contrasenia" /*RemoteObject*/ ))));
 BA.debugLineNum = 148;BA.debugLine="mapRegister.Put(\"usr_fecha_nacimiento\", usuario_.";
Debug.ShouldStop(524288);
_mapregister.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_fecha_nacimiento"))),(Object)((_usuario_.getField(true,"_usr_fecha_nacimiento" /*RemoteObject*/ ))));
 BA.debugLineNum = 149;BA.debugLine="mapRegister.Put(\"usr_rol\", usuario_.usr_rol)";
Debug.ShouldStop(1048576);
_mapregister.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_rol"))),(Object)((_usuario_.getField(true,"_usr_rol" /*RemoteObject*/ ))));
 BA.debugLineNum = 150;BA.debugLine="mapRegister.Put(\"usr_estado\", usuario_.usr_estado";
Debug.ShouldStop(2097152);
_mapregister.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("usr_estado"))),(Object)((_usuario_.getField(true,"_usr_estado" /*RemoteObject*/ ))));
 BA.debugLineNum = 152;BA.debugLine="jsonGenerator.Initialize(mapRegister)";
Debug.ShouldStop(8388608);
_jsongenerator.runVoidMethod ("Initialize",(Object)(_mapregister));
 BA.debugLineNum = 153;BA.debugLine="jsonRegister = jsonGenerator.ToPrettyString(5)";
Debug.ShouldStop(16777216);
_jsonregister = _jsongenerator.runMethod(true,"ToPrettyString",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("jsonRegister", _jsonregister);
 BA.debugLineNum = 155;BA.debugLine="Dim peticion As HttpJob";
Debug.ShouldStop(67108864);
_peticion = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("peticion", _peticion);
 BA.debugLineNum = 156;BA.debugLine="peticion.Initialize(\"\", Me)";
Debug.ShouldStop(134217728);
_peticion.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,registrousuario.processBA,(Object)(BA.ObjectToString("")),(Object)(registrousuario.getObject()));
 BA.debugLineNum = 157;BA.debugLine="peticion.PostString(\"https://biblioteca-3q4a.onre";
Debug.ShouldStop(268435456);
_peticion.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(BA.ObjectToString("https://biblioteca-3q4a.onrender.com/api/usuarios")),(Object)(_jsonregister));
 BA.debugLineNum = 158;BA.debugLine="peticion.GetRequest.SetContentType(\"application/j";
Debug.ShouldStop(536870912);
_peticion.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ ).runVoidMethod ("SetContentType",(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 160;BA.debugLine="Wait For (peticion) JobDone (respuesta As HttpJob";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", registrousuario.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "registrousuario", "btn_registrar_usuario_click"), (_peticion));
this.state = 53;
return;
case 53:
//C
this.state = 47;
_respuesta = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("respuesta", _respuesta);
;
 BA.debugLineNum = 162;BA.debugLine="If respuesta.Success Then";
Debug.ShouldStop(2);
if (true) break;

case 47:
//if
this.state = 52;
if (_respuesta.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 49;
}else {
this.state = 51;
}if (true) break;

case 49:
//C
this.state = 52;
 BA.debugLineNum = 164;BA.debugLine="txt_cedula.Text = \"\"";
Debug.ShouldStop(8);
parent.mostCurrent._txt_cedula.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 165;BA.debugLine="txt_primer_nombre.Text = \"\"";
Debug.ShouldStop(16);
parent.mostCurrent._txt_primer_nombre.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 166;BA.debugLine="txt_segundo_nombre.Text = \"\"";
Debug.ShouldStop(32);
parent.mostCurrent._txt_segundo_nombre.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 167;BA.debugLine="txt_primer_apellido.Text = \"\"";
Debug.ShouldStop(64);
parent.mostCurrent._txt_primer_apellido.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 168;BA.debugLine="txt_segundo_apellido.Text = \"\"";
Debug.ShouldStop(128);
parent.mostCurrent._txt_segundo_apellido.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 169;BA.debugLine="txt_correo.Text = \"\"";
Debug.ShouldStop(256);
parent.mostCurrent._txt_correo.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 170;BA.debugLine="txt_contrasenia.Text = \"\"";
Debug.ShouldStop(512);
parent.mostCurrent._txt_contrasenia.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 171;BA.debugLine="txt_fecha_nacimiento.Text = \"\"";
Debug.ShouldStop(1024);
parent.mostCurrent._txt_fecha_nacimiento.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 173;BA.debugLine="peticion.Release";
Debug.ShouldStop(4096);
_peticion.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 174;BA.debugLine="StartActivity(\"ValidacionUsuario\")";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("StartActivity",registrousuario.processBA,(Object)((RemoteObject.createImmutable("ValidacionUsuario"))));
 if (true) break;

case 51:
//C
this.state = 52;
 BA.debugLineNum = 176;BA.debugLine="xui.MsgboxAsync(\"¡Registro fallido! \" & respuest";
Debug.ShouldStop(32768);
parent._xui.runVoidMethod ("MsgboxAsync",registrousuario.processBA,(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("¡Registro fallido! "),_respuesta.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))));
 if (true) break;

case 52:
//C
this.state = -1;
;
 BA.debugLineNum = 178;BA.debugLine="peticion.Release";
Debug.ShouldStop(131072);
_peticion.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 180;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private txt_cedula As EditText";
registrousuario.mostCurrent._txt_cedula = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private txt_primer_nombre As EditText";
registrousuario.mostCurrent._txt_primer_nombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private txt_segundo_nombre As EditText";
registrousuario.mostCurrent._txt_segundo_nombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private txt_primer_apellido As EditText";
registrousuario.mostCurrent._txt_primer_apellido = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private txt_segundo_apellido As EditText";
registrousuario.mostCurrent._txt_segundo_apellido = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private txt_correo As EditText";
registrousuario.mostCurrent._txt_correo = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private txt_contrasenia As EditText";
registrousuario.mostCurrent._txt_contrasenia = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private txt_fecha_nacimiento As EditText";
registrousuario.mostCurrent._txt_fecha_nacimiento = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private xui As XUI";
registrousuario._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 10;BA.debugLine="Public usr_email_global As String";
registrousuario._usr_email_global = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="Public usr_nombre As String";
registrousuario._usr_nombre = RemoteObject.createImmutable("");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}