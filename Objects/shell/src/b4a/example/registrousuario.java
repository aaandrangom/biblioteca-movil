
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class registrousuario implements IRemote{
	public static registrousuario mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public registrousuario() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("registrousuario"), "b4a.example.registrousuario");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, registrousuario.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _usr_email_global = RemoteObject.createImmutable("");
public static RemoteObject _usr_nombre = RemoteObject.createImmutable("");
public static RemoteObject _txt_cedula = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txt_primer_nombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txt_segundo_nombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txt_primer_apellido = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txt_segundo_apellido = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txt_correo = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txt_contrasenia = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txt_fecha_nacimiento = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.validacionusuario _validacionusuario = null;
public static b4a.example.principal _principal = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",registrousuario.mostCurrent._activity,"DateUtils",registrousuario.mostCurrent._dateutils,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"Main",Debug.moduleToString(b4a.example.main.class),"Principal",Debug.moduleToString(b4a.example.principal.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"txt_cedula",registrousuario.mostCurrent._txt_cedula,"txt_contrasenia",registrousuario.mostCurrent._txt_contrasenia,"txt_correo",registrousuario.mostCurrent._txt_correo,"txt_fecha_nacimiento",registrousuario.mostCurrent._txt_fecha_nacimiento,"txt_primer_apellido",registrousuario.mostCurrent._txt_primer_apellido,"txt_primer_nombre",registrousuario.mostCurrent._txt_primer_nombre,"txt_segundo_apellido",registrousuario.mostCurrent._txt_segundo_apellido,"txt_segundo_nombre",registrousuario.mostCurrent._txt_segundo_nombre,"usr_email_global",registrousuario._usr_email_global,"usr_nombre",registrousuario._usr_nombre,"ValidacionUsuario",Debug.moduleToString(b4a.example.validacionusuario.class),"xui",registrousuario._xui};
}
}