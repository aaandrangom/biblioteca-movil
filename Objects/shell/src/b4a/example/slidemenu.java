
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class slidemenu {
    public static RemoteObject myClass;
	public slidemenu() {
	}
    public static PCBA staticBA = new PCBA(null, slidemenu.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _mslidepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _mbackpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _mmodule = RemoteObject.declareNull("Object");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _mlistview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _minanimation = RemoteObject.declareNull("anywheresoftware.b4a.objects.AnimationWrapper");
public static RemoteObject _moutanimation = RemoteObject.declareNull("anywheresoftware.b4a.objects.AnimationWrapper");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.registrousuario _registrousuario = null;
public static b4a.example.validacionusuario _validacionusuario = null;
public static b4a.example.principal _principal = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"DateUtils",_ref.getField(false, "_dateutils"),"mBackPanel",_ref.getField(false, "_mbackpanel"),"mEventName",_ref.getField(false, "_meventname"),"mInAnimation",_ref.getField(false, "_minanimation"),"mListView",_ref.getField(false, "_mlistview"),"mModule",_ref.getField(false, "_mmodule"),"mOutAnimation",_ref.getField(false, "_moutanimation"),"mSlidePanel",_ref.getField(false, "_mslidepanel")};
}
}