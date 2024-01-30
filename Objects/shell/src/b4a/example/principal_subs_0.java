package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class principal_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (principal) ","principal",7,principal.mostCurrent.activityBA,principal.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"layoutPaginaPrincipal\")";
Debug.ShouldStop(2097152);
principal.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("layoutPaginaPrincipal")),principal.mostCurrent.activityBA);
 BA.debugLineNum = 24;BA.debugLine="sm.Initialize(Activity, Me, \"SlideMenu\", 60dip, 2";
Debug.ShouldStop(8388608);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_initialize" /*RemoteObject*/ ,principal.mostCurrent.activityBA,(Object)(principal.mostCurrent._activity),(Object)(principal.getObject()),(Object)(BA.ObjectToString("SlideMenu")),(Object)(principal.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))),(Object)(principal.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 225)))));
 BA.debugLineNum = 26;BA.debugLine="sm.AddItem(\"Item #1\", Null, 1)";
Debug.ShouldStop(33554432);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_additem" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Item #1")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), principal.mostCurrent.__c.getField(false,"Null")),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 27;BA.debugLine="sm.AddItem(\"Item #2\", Null, 2)";
Debug.ShouldStop(67108864);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_additem" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Item #2")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), principal.mostCurrent.__c.getField(false,"Null")),(Object)(RemoteObject.createImmutable((2))));
 BA.debugLineNum = 28;BA.debugLine="sm.AddItem(\"Item #3\", Null, 3)";
Debug.ShouldStop(134217728);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_additem" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Item #3")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), principal.mostCurrent.__c.getField(false,"Null")),(Object)(RemoteObject.createImmutable((3))));
 BA.debugLineNum = 29;BA.debugLine="sm.AddItem(\"Item #4\", Null, 4)";
Debug.ShouldStop(268435456);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_additem" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Item #4")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), principal.mostCurrent.__c.getField(false,"Null")),(Object)(RemoteObject.createImmutable((4))));
 BA.debugLineNum = 30;BA.debugLine="sm.AddItem(\"Item #5\", Null, 5)";
Debug.ShouldStop(536870912);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_additem" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Item #5")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), principal.mostCurrent.__c.getField(false,"Null")),(Object)(RemoteObject.createImmutable((5))));
 BA.debugLineNum = 31;BA.debugLine="sm.AddItem(\"Item #6\", Null, 6)";
Debug.ShouldStop(1073741824);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_additem" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Item #6")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), principal.mostCurrent.__c.getField(false,"Null")),(Object)(RemoteObject.createImmutable((6))));
 BA.debugLineNum = 32;BA.debugLine="sm.AddItem(\"Item #7\", Null, 7)";
Debug.ShouldStop(-2147483648);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_additem" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Item #7")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), principal.mostCurrent.__c.getField(false,"Null")),(Object)(RemoteObject.createImmutable((7))));
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
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (principal) ","principal",7,principal.mostCurrent.activityBA,principal.mostCurrent,46);
if (RapidSub.canDelegate("activity_keypress")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(8192);
 BA.debugLineNum = 48;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And sm.isVisib";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, principal.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK"))) && RemoteObject.solveBoolean(".",principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_isvisible" /*RemoteObject*/ ))) { 
 BA.debugLineNum = 49;BA.debugLine="sm.Hide";
Debug.ShouldStop(65536);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_hide" /*RemoteObject*/ );
 BA.debugLineNum = 50;BA.debugLine="Return True";
Debug.ShouldStop(131072);
if (true) return principal.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 54;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_MENU Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, principal.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_MENU")))) { 
 BA.debugLineNum = 55;BA.debugLine="If sm.isVisible Then";
Debug.ShouldStop(4194304);
if (principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_isvisible" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 56;BA.debugLine="sm.Hide";
Debug.ShouldStop(8388608);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_hide" /*RemoteObject*/ );
 }else {
 BA.debugLineNum = 58;BA.debugLine="sm.Show";
Debug.ShouldStop(33554432);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_show" /*RemoteObject*/ );
 };
 BA.debugLineNum = 60;BA.debugLine="Return True";
Debug.ShouldStop(134217728);
if (true) return principal.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (principal) ","principal",7,principal.mostCurrent.activityBA,principal.mostCurrent,41);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (principal) ","principal",7,principal.mostCurrent.activityBA,principal.mostCurrent,37);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","activity_resume");}
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _btnshow_click() throws Exception{
try {
		Debug.PushSubsStack("btnShow_Click (principal) ","principal",7,principal.mostCurrent.activityBA,principal.mostCurrent,65);
if (RapidSub.canDelegate("btnshow_click")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","btnshow_click");}
 BA.debugLineNum = 65;BA.debugLine="Sub btnShow_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="sm.Show";
Debug.ShouldStop(2);
principal.mostCurrent._sm.runClassMethod (b4a.example.slidemenu.class, "_show" /*RemoteObject*/ );
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private xui As XUI";
principal.mostCurrent._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 16;BA.debugLine="Dim sm As SlideMenu";
principal.mostCurrent._sm = RemoteObject.createNew ("b4a.example.slidemenu");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _slidemenu_click(RemoteObject _item) throws Exception{
try {
		Debug.PushSubsStack("SlideMenu_Click (principal) ","principal",7,principal.mostCurrent.activityBA,principal.mostCurrent,70);
if (RapidSub.canDelegate("slidemenu_click")) { return b4a.example.principal.remoteMe.runUserSub(false, "principal","slidemenu_click", _item);}
Debug.locals.put("Item", _item);
 BA.debugLineNum = 70;BA.debugLine="Sub SlideMenu_Click(Item As Object)";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="ToastMessageShow(\"Item clicked: \" & Item, False)";
Debug.ShouldStop(64);
principal.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Item clicked: "),_item))),(Object)(principal.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}