package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class usuario_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public usr_cedula As String";
usuario._usr_cedula = RemoteObject.createImmutable("");__ref.setField("_usr_cedula",usuario._usr_cedula);
 //BA.debugLineNum = 3;BA.debugLine="Public usr_primer_nombre As String";
usuario._usr_primer_nombre = RemoteObject.createImmutable("");__ref.setField("_usr_primer_nombre",usuario._usr_primer_nombre);
 //BA.debugLineNum = 4;BA.debugLine="Public usr_segundo_nombre As String";
usuario._usr_segundo_nombre = RemoteObject.createImmutable("");__ref.setField("_usr_segundo_nombre",usuario._usr_segundo_nombre);
 //BA.debugLineNum = 5;BA.debugLine="Public usr_primer_apellido As String";
usuario._usr_primer_apellido = RemoteObject.createImmutable("");__ref.setField("_usr_primer_apellido",usuario._usr_primer_apellido);
 //BA.debugLineNum = 6;BA.debugLine="Public usr_segundo_apellido As String";
usuario._usr_segundo_apellido = RemoteObject.createImmutable("");__ref.setField("_usr_segundo_apellido",usuario._usr_segundo_apellido);
 //BA.debugLineNum = 7;BA.debugLine="Public usr_email As String";
usuario._usr_email = RemoteObject.createImmutable("");__ref.setField("_usr_email",usuario._usr_email);
 //BA.debugLineNum = 8;BA.debugLine="Public usr_contrasenia As String";
usuario._usr_contrasenia = RemoteObject.createImmutable("");__ref.setField("_usr_contrasenia",usuario._usr_contrasenia);
 //BA.debugLineNum = 9;BA.debugLine="Public usr_fecha_nacimiento As String";
usuario._usr_fecha_nacimiento = RemoteObject.createImmutable("");__ref.setField("_usr_fecha_nacimiento",usuario._usr_fecha_nacimiento);
 //BA.debugLineNum = 10;BA.debugLine="Public usr_rol As String";
usuario._usr_rol = RemoteObject.createImmutable("");__ref.setField("_usr_rol",usuario._usr_rol);
 //BA.debugLineNum = 11;BA.debugLine="Public usr_estado As String";
usuario._usr_estado = RemoteObject.createImmutable("");__ref.setField("_usr_estado",usuario._usr_estado);
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (usuario) ","usuario",4,__ref.getField(false, "ba"),__ref,15);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "usuario","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 15;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(16384);
 BA.debugLineNum = 17;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}