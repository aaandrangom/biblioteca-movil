
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class login {
    public static RemoteObject myClass;
	public login() {
	}
    public static PCBA staticBA = new PCBA(null, login.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _usr_nickname = RemoteObject.createImmutable("");
public static RemoteObject _usr_contrasenia = RemoteObject.createImmutable("");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.main _main = null;
public static b4a.example.registrousuario _registrousuario = null;
public static b4a.example.validacionusuario _validacionusuario = null;
public static b4a.example.principal _principal = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"DateUtils",_ref.getField(false, "_dateutils"),"usr_contrasenia",_ref.getField(false, "_usr_contrasenia"),"usr_nickname",_ref.getField(false, "_usr_nickname")};
}
}