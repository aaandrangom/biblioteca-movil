package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class usuario extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.usuario");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.usuario.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _usr_cedula = "";
public String _usr_primer_nombre = "";
public String _usr_segundo_nombre = "";
public String _usr_primer_apellido = "";
public String _usr_segundo_apellido = "";
public String _usr_email = "";
public String _usr_contrasenia = "";
public String _usr_fecha_nacimiento = "";
public String _usr_rol = "";
public String _usr_estado = "";
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.registrousuario _registrousuario = null;
public b4a.example.validacionusuario _validacionusuario = null;
public b4a.example.principal _principal = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public usr_cedula As String";
_usr_cedula = "";
 //BA.debugLineNum = 3;BA.debugLine="Public usr_primer_nombre As String";
_usr_primer_nombre = "";
 //BA.debugLineNum = 4;BA.debugLine="Public usr_segundo_nombre As String";
_usr_segundo_nombre = "";
 //BA.debugLineNum = 5;BA.debugLine="Public usr_primer_apellido As String";
_usr_primer_apellido = "";
 //BA.debugLineNum = 6;BA.debugLine="Public usr_segundo_apellido As String";
_usr_segundo_apellido = "";
 //BA.debugLineNum = 7;BA.debugLine="Public usr_email As String";
_usr_email = "";
 //BA.debugLineNum = 8;BA.debugLine="Public usr_contrasenia As String";
_usr_contrasenia = "";
 //BA.debugLineNum = 9;BA.debugLine="Public usr_fecha_nacimiento As String";
_usr_fecha_nacimiento = "";
 //BA.debugLineNum = 10;BA.debugLine="Public usr_rol As String";
_usr_rol = "";
 //BA.debugLineNum = 11;BA.debugLine="Public usr_estado As String";
_usr_estado = "";
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 15;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
