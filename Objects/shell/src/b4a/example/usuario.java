
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class usuario {
    public static RemoteObject myClass;
	public usuario() {
	}
    public static PCBA staticBA = new PCBA(null, usuario.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _usr_cedula = RemoteObject.createImmutable("");
public static RemoteObject _usr_primer_nombre = RemoteObject.createImmutable("");
public static RemoteObject _usr_segundo_nombre = RemoteObject.createImmutable("");
public static RemoteObject _usr_primer_apellido = RemoteObject.createImmutable("");
public static RemoteObject _usr_segundo_apellido = RemoteObject.createImmutable("");
public static RemoteObject _usr_email = RemoteObject.createImmutable("");
public static RemoteObject _usr_contrasenia = RemoteObject.createImmutable("");
public static RemoteObject _usr_fecha_nacimiento = RemoteObject.createImmutable("");
public static RemoteObject _usr_rol = RemoteObject.createImmutable("");
public static RemoteObject _usr_estado = RemoteObject.createImmutable("");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.main _main = null;
public static b4a.example.registrousuario _registrousuario = null;
public static b4a.example.validacionusuario _validacionusuario = null;
public static b4a.example.principal _principal = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"DateUtils",_ref.getField(false, "_dateutils"),"usr_cedula",_ref.getField(false, "_usr_cedula"),"usr_contrasenia",_ref.getField(false, "_usr_contrasenia"),"usr_email",_ref.getField(false, "_usr_email"),"usr_estado",_ref.getField(false, "_usr_estado"),"usr_fecha_nacimiento",_ref.getField(false, "_usr_fecha_nacimiento"),"usr_primer_apellido",_ref.getField(false, "_usr_primer_apellido"),"usr_primer_nombre",_ref.getField(false, "_usr_primer_nombre"),"usr_rol",_ref.getField(false, "_usr_rol"),"usr_segundo_apellido",_ref.getField(false, "_usr_segundo_apellido"),"usr_segundo_nombre",_ref.getField(false, "_usr_segundo_nombre")};
}
}