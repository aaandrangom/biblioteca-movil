package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class slidemenu_subs_0 {


public static RemoteObject  _additem(RemoteObject __ref,RemoteObject _text,RemoteObject _image,RemoteObject _returnvalue) throws Exception{
try {
		Debug.PushSubsStack("AddItem (slidemenu) ","slidemenu",8,__ref.getField(false, "ba"),__ref,56);
if (RapidSub.canDelegate("additem")) { return __ref.runUserSub(false, "slidemenu","additem", __ref, _text, _image, _returnvalue);}
RemoteObject _item = RemoteObject.declareNull("b4a.example.slidemenu._actionitem");
Debug.locals.put("Text", _text);
Debug.locals.put("Image", _image);
Debug.locals.put("ReturnValue", _returnvalue);
 BA.debugLineNum = 56;BA.debugLine="Public Sub AddItem(Text As String, Image As Bitmap";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="Dim item As ActionItem";
Debug.ShouldStop(16777216);
_item = RemoteObject.createNew ("b4a.example.slidemenu._actionitem");Debug.locals.put("item", _item);
 BA.debugLineNum = 58;BA.debugLine="item.Initialize";
Debug.ShouldStop(33554432);
_item.runVoidMethod ("Initialize");
 BA.debugLineNum = 59;BA.debugLine="item.Text = Text";
Debug.ShouldStop(67108864);
_item.setField ("Text" /*RemoteObject*/ ,_text);
 BA.debugLineNum = 60;BA.debugLine="item.Image = Image";
Debug.ShouldStop(134217728);
_item.setField ("Image" /*RemoteObject*/ ,_image);
 BA.debugLineNum = 61;BA.debugLine="item.Value = ReturnValue";
Debug.ShouldStop(268435456);
_item.setField ("Value" /*RemoteObject*/ ,_returnvalue);
 BA.debugLineNum = 63;BA.debugLine="If Not(Image.IsInitialized) Then";
Debug.ShouldStop(1073741824);
if (slidemenu.__c.runMethod(true,"Not",(Object)(_image.runMethod(true,"IsInitialized"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 64;BA.debugLine="mListView.AddTwoLinesAndBitmap2(Text, \"\", Null,";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence(_text)),(Object)(BA.ObjectToCharSequence("")),(Object)((slidemenu.__c.getField(false,"Null"))),(Object)(_returnvalue));
 }else {
 BA.debugLineNum = 66;BA.debugLine="mListView.AddTwoLinesAndBitmap2(Text, \"\", Image,";
Debug.ShouldStop(2);
__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runVoidMethod ("AddTwoLinesAndBitmap2",(Object)(BA.ObjectToCharSequence(_text)),(Object)(BA.ObjectToCharSequence("")),(Object)((_image.getObject())),(Object)(_returnvalue));
 };
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Type ActionItem (Text As String, Image As Bitmap,";
;
 //BA.debugLineNum = 4;BA.debugLine="Private mSlidePanel As Panel";
slidemenu._mslidepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_mslidepanel",slidemenu._mslidepanel);
 //BA.debugLineNum = 5;BA.debugLine="Private mBackPanel As Panel";
slidemenu._mbackpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_mbackpanel",slidemenu._mbackpanel);
 //BA.debugLineNum = 7;BA.debugLine="Private mModule As Object";
slidemenu._mmodule = RemoteObject.createNew ("Object");__ref.setField("_mmodule",slidemenu._mmodule);
 //BA.debugLineNum = 8;BA.debugLine="Private mEventName As String";
slidemenu._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",slidemenu._meventname);
 //BA.debugLineNum = 10;BA.debugLine="Private mListView As ListView";
slidemenu._mlistview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");__ref.setField("_mlistview",slidemenu._mlistview);
 //BA.debugLineNum = 12;BA.debugLine="Private mInAnimation As Animation";
slidemenu._minanimation = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");__ref.setField("_minanimation",slidemenu._minanimation);
 //BA.debugLineNum = 13;BA.debugLine="Private mOutAnimation As Animation";
slidemenu._moutanimation = RemoteObject.createNew ("anywheresoftware.b4a.objects.AnimationWrapper");__ref.setField("_moutanimation",slidemenu._moutanimation);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _hide(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Hide (slidemenu) ","slidemenu",8,__ref.getField(false, "ba"),__ref,84);
if (RapidSub.canDelegate("hide")) { return __ref.runUserSub(false, "slidemenu","hide", __ref);}
 BA.debugLineNum = 84;BA.debugLine="Public Sub Hide";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="If isVisible = False Then Return";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4a.example.slidemenu.class, "_isvisible" /*RemoteObject*/ ),slidemenu.__c.getField(true,"False"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 87;BA.debugLine="mBackPanel.Left = -mBackPanel.Width";
Debug.ShouldStop(4194304);
__ref.getField(false,"_mbackpanel" /*RemoteObject*/ ).runMethod(true,"setLeft",BA.numberCast(int.class, -(double) (0 + __ref.getField(false,"_mbackpanel" /*RemoteObject*/ ).runMethod(true,"getWidth").<Integer>get().intValue())));
 BA.debugLineNum = 88;BA.debugLine="mSlidePanel.Left = -mSlidePanel.Width";
Debug.ShouldStop(8388608);
__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runMethod(true,"setLeft",BA.numberCast(int.class, -(double) (0 + __ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runMethod(true,"getWidth").<Integer>get().intValue())));
 BA.debugLineNum = 89;BA.debugLine="mOutAnimation.Start(mSlidePanel)";
Debug.ShouldStop(16777216);
__ref.getField(false,"_moutanimation" /*RemoteObject*/ ).runVoidMethod ("Start",(Object)((__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).getObject())));
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _activity,RemoteObject _module,RemoteObject _eventname,RemoteObject _top,RemoteObject _width) throws Exception{
try {
		Debug.PushSubsStack("Initialize (slidemenu) ","slidemenu",8,__ref.getField(false, "ba"),__ref,22);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "slidemenu","initialize", __ref, _ba, _activity, _module, _eventname, _top, _width);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Activity", _activity);
Debug.locals.put("Module", _module);
Debug.locals.put("EventName", _eventname);
Debug.locals.put("Top", _top);
Debug.locals.put("Width", _width);
 BA.debugLineNum = 22;BA.debugLine="Sub Initialize(Activity As Activity, Module As Obj";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="mModule = Module";
Debug.ShouldStop(4194304);
__ref.setField ("_mmodule" /*RemoteObject*/ ,_module);
 BA.debugLineNum = 24;BA.debugLine="mEventName = EventName";
Debug.ShouldStop(8388608);
__ref.setField ("_meventname" /*RemoteObject*/ ,_eventname);
 BA.debugLineNum = 26;BA.debugLine="mSlidePanel.Initialize(\"mSlidePanel\")";
Debug.ShouldStop(33554432);
__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("mSlidePanel")));
 BA.debugLineNum = 28;BA.debugLine="mListView.Initialize(\"mListView\")";
Debug.ShouldStop(134217728);
__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("mListView")));
 BA.debugLineNum = 29;BA.debugLine="mListView.TwoLinesAndBitmap.SecondLabel.Visible =";
Debug.ShouldStop(268435456);
__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runMethod(false,"getTwoLinesAndBitmap").getField(false,"SecondLabel").runMethod(true,"setVisible",slidemenu.__c.getField(true,"False"));
 BA.debugLineNum = 30;BA.debugLine="mListView.TwoLinesAndBitmap.ItemHeight = 50dip";
Debug.ShouldStop(536870912);
__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"setItemHeight",slidemenu.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 31;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Gravity = Gravi";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label").runMethod(true,"setGravity",slidemenu.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 32;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Height = mListV";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label").runMethod(true,"setHeight",__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"getItemHeight"));
 BA.debugLineNum = 33;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Top = 0";
Debug.ShouldStop(1);
__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label").runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 34;BA.debugLine="mListView.TwoLinesAndBitmap.ImageView.SetLayout(1";
Debug.ShouldStop(2);
__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runVoidMethod ("SetLayout",(Object)(slidemenu.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 13)))),(Object)(slidemenu.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 13)))),(Object)(slidemenu.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 24)))),(Object)(slidemenu.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 24)))));
 BA.debugLineNum = 35;BA.debugLine="mListView.Color = Colors.Black";
Debug.ShouldStop(4);
__ref.getField(false,"_mlistview" /*RemoteObject*/ ).runVoidMethod ("setColor",slidemenu.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 37;BA.debugLine="mInAnimation.InitializeTranslate(\"\", -Width, 0, 0";
Debug.ShouldStop(16);
__ref.getField(false,"_minanimation" /*RemoteObject*/ ).runVoidMethod ("InitializeTranslate",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("")),(Object)(BA.numberCast(float.class, -(double) (0 + _width.<Integer>get().intValue()))),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 38;BA.debugLine="mInAnimation.Duration = 200";
Debug.ShouldStop(32);
__ref.getField(false,"_minanimation" /*RemoteObject*/ ).runMethod(true,"setDuration",BA.numberCast(long.class, 200));
 BA.debugLineNum = 39;BA.debugLine="mOutAnimation.InitializeTranslate(\"Out\", Width, 0";
Debug.ShouldStop(64);
__ref.getField(false,"_moutanimation" /*RemoteObject*/ ).runVoidMethod ("InitializeTranslate",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("Out")),(Object)(BA.numberCast(float.class, _width)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 40;BA.debugLine="mOutAnimation.Duration = 200";
Debug.ShouldStop(128);
__ref.getField(false,"_moutanimation" /*RemoteObject*/ ).runMethod(true,"setDuration",BA.numberCast(long.class, 200));
 BA.debugLineNum = 42;BA.debugLine="Activity.AddView(mSlidePanel, 0, Top, Width, 100%";
Debug.ShouldStop(512);
_activity.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_top),(Object)(_width),(Object)(RemoteObject.solve(new RemoteObject[] {slidemenu.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba")),_top}, "-",1, 1)));
 BA.debugLineNum = 44;BA.debugLine="mBackPanel.Initialize(\"mBackPanel\")";
Debug.ShouldStop(2048);
__ref.getField(false,"_mbackpanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("mBackPanel")));
 BA.debugLineNum = 45;BA.debugLine="mBackPanel.Color = Colors.Transparent";
Debug.ShouldStop(4096);
__ref.getField(false,"_mbackpanel" /*RemoteObject*/ ).runVoidMethod ("setColor",slidemenu.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 46;BA.debugLine="Activity.AddView(mBackPanel, -100%x, 0, 100%x, 10";
Debug.ShouldStop(8192);
_activity.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_mbackpanel" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, -(double) (0 + slidemenu.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba")).<Integer>get().intValue()))),(Object)(BA.numberCast(int.class, 0)),(Object)(slidemenu.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba"))),(Object)(slidemenu.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 48;BA.debugLine="mSlidePanel.AddView(mListView, 0, 0, mSlidePanel.";
Debug.ShouldStop(32768);
__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_mlistview" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runMethod(true,"getWidth")),(Object)(__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runMethod(true,"getHeight")));
 BA.debugLineNum = 49;BA.debugLine="mSlidePanel.Visible = False";
Debug.ShouldStop(65536);
__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runMethod(true,"setVisible",slidemenu.__c.getField(true,"False"));
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _isvisible(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("isVisible (slidemenu) ","slidemenu",8,__ref.getField(false, "ba"),__ref,112);
if (RapidSub.canDelegate("isvisible")) { return __ref.runUserSub(false, "slidemenu","isvisible", __ref);}
 BA.debugLineNum = 112;BA.debugLine="Public Sub isVisible As Boolean";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="Return mSlidePanel.Visible";
Debug.ShouldStop(65536);
if (true) return __ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runMethod(true,"getVisible");
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mbackpanel_touch(RemoteObject __ref,RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("mBackPanel_Touch (slidemenu) ","slidemenu",8,__ref.getField(false, "ba"),__ref,96);
if (RapidSub.canDelegate("mbackpanel_touch")) { return __ref.runUserSub(false, "slidemenu","mbackpanel_touch", __ref, _action, _x, _y);}
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 96;BA.debugLine="Private Sub mBackPanel_Touch (Action As Int, X As";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="If Action = 1 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 98;BA.debugLine="Hide";
Debug.ShouldStop(2);
__ref.runClassMethod (b4a.example.slidemenu.class, "_hide" /*RemoteObject*/ );
 };
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mlistview_itemclick(RemoteObject __ref,RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("mListView_ItemClick (slidemenu) ","slidemenu",8,__ref.getField(false, "ba"),__ref,102);
if (RapidSub.canDelegate("mlistview_itemclick")) { return __ref.runUserSub(false, "slidemenu","mlistview_itemclick", __ref, _position, _value);}
RemoteObject _subname = RemoteObject.createImmutable("");
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 102;BA.debugLine="Private Sub mListView_ItemClick (Position As Int,";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="Dim subname As String";
Debug.ShouldStop(64);
_subname = RemoteObject.createImmutable("");Debug.locals.put("subname", _subname);
 BA.debugLineNum = 104;BA.debugLine="Hide";
Debug.ShouldStop(128);
__ref.runClassMethod (b4a.example.slidemenu.class, "_hide" /*RemoteObject*/ );
 BA.debugLineNum = 105;BA.debugLine="subname = mEventName & \"_Click\"";
Debug.ShouldStop(256);
_subname = RemoteObject.concat(__ref.getField(true,"_meventname" /*RemoteObject*/ ),RemoteObject.createImmutable("_Click"));Debug.locals.put("subname", _subname);
 BA.debugLineNum = 106;BA.debugLine="If SubExists(mModule, subname) Then";
Debug.ShouldStop(512);
if (slidemenu.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mmodule" /*RemoteObject*/ )),(Object)(_subname)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 107;BA.debugLine="CallSub2(mModule, subname, Value)";
Debug.ShouldStop(1024);
slidemenu.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mmodule" /*RemoteObject*/ )),(Object)(_subname),(Object)(_value));
 };
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _out_animationend(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Out_AnimationEnd (slidemenu) ","slidemenu",8,__ref.getField(false, "ba"),__ref,92);
if (RapidSub.canDelegate("out_animationend")) { return __ref.runUserSub(false, "slidemenu","out_animationend", __ref);}
 BA.debugLineNum = 92;BA.debugLine="Private Sub Out_AnimationEnd";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="mSlidePanel.Visible = False";
Debug.ShouldStop(268435456);
__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runMethod(true,"setVisible",slidemenu.__c.getField(true,"False"));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _show(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Show (slidemenu) ","slidemenu",8,__ref.getField(false, "ba"),__ref,71);
if (RapidSub.canDelegate("show")) { return __ref.runUserSub(false, "slidemenu","show", __ref);}
 BA.debugLineNum = 71;BA.debugLine="Public Sub Show";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="If isVisible = True Then Return";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4a.example.slidemenu.class, "_isvisible" /*RemoteObject*/ ),slidemenu.__c.getField(true,"True"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 74;BA.debugLine="mBackPanel.BringToFront";
Debug.ShouldStop(512);
__ref.getField(false,"_mbackpanel" /*RemoteObject*/ ).runVoidMethod ("BringToFront");
 BA.debugLineNum = 75;BA.debugLine="mSlidePanel.BringToFront";
Debug.ShouldStop(1024);
__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runVoidMethod ("BringToFront");
 BA.debugLineNum = 76;BA.debugLine="mBackPanel.Left = 0";
Debug.ShouldStop(2048);
__ref.getField(false,"_mbackpanel" /*RemoteObject*/ ).runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 77;BA.debugLine="mSlidePanel.Left = 0";
Debug.ShouldStop(4096);
__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 79;BA.debugLine="mSlidePanel.Visible = True";
Debug.ShouldStop(16384);
__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).runMethod(true,"setVisible",slidemenu.__c.getField(true,"True"));
 BA.debugLineNum = 80;BA.debugLine="mInAnimation.Start(mSlidePanel)";
Debug.ShouldStop(32768);
__ref.getField(false,"_minanimation" /*RemoteObject*/ ).runVoidMethod ("Start",(Object)((__ref.getField(false,"_mslidepanel" /*RemoteObject*/ ).getObject())));
 BA.debugLineNum = 81;BA.debugLine="End Sub";
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