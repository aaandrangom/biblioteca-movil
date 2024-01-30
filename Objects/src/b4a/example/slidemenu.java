package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class slidemenu extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.slidemenu");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.slidemenu.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public static class _actionitem{
public boolean IsInitialized;
public String Text;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper Image;
public Object Value;
public void Initialize() {
IsInitialized = true;
Text = "";
Image = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
Value = new Object();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.PanelWrapper _mslidepanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _mbackpanel = null;
public Object _mmodule = null;
public String _meventname = "";
public anywheresoftware.b4a.objects.ListViewWrapper _mlistview = null;
public anywheresoftware.b4a.objects.AnimationWrapper _minanimation = null;
public anywheresoftware.b4a.objects.AnimationWrapper _moutanimation = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.registrousuario _registrousuario = null;
public b4a.example.validacionusuario _validacionusuario = null;
public b4a.example.principal _principal = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _initialize(b4a.example.slidemenu __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,Object _module,String _eventname,int _top,int _width) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="slidemenu";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_activity,_module,_eventname,_top,_width}));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub Initialize(Activity As Activity, Module As Obj";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="mModule = Module";
__ref._mmodule /*Object*/  = _module;
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="mSlidePanel.Initialize(\"mSlidePanel\")";
__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"mSlidePanel");
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="mListView.Initialize(\"mListView\")";
__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .Initialize(ba,"mListView");
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="mListView.TwoLinesAndBitmap.SecondLabel.Visible =";
__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .getTwoLinesAndBitmap().SecondLabel.setVisible(__c.False);
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="mListView.TwoLinesAndBitmap.ItemHeight = 50dip";
__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .getTwoLinesAndBitmap().setItemHeight(__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1966089;
 //BA.debugLineNum = 1966089;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Gravity = Gravi";
__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .getTwoLinesAndBitmap().Label.setGravity(__c.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Height = mListV";
__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .getTwoLinesAndBitmap().Label.setHeight(__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .getTwoLinesAndBitmap().getItemHeight());
RDebugUtils.currentLine=1966091;
 //BA.debugLineNum = 1966091;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Top = 0";
__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .getTwoLinesAndBitmap().Label.setTop((int) (0));
RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="mListView.TwoLinesAndBitmap.ImageView.SetLayout(1";
__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .getTwoLinesAndBitmap().ImageView.SetLayout(__c.DipToCurrent((int) (13)),__c.DipToCurrent((int) (13)),__c.DipToCurrent((int) (24)),__c.DipToCurrent((int) (24)));
RDebugUtils.currentLine=1966093;
 //BA.debugLineNum = 1966093;BA.debugLine="mListView.Color = Colors.Black";
__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .setColor(__c.Colors.Black);
RDebugUtils.currentLine=1966095;
 //BA.debugLineNum = 1966095;BA.debugLine="mInAnimation.InitializeTranslate(\"\", -Width, 0, 0";
__ref._minanimation /*anywheresoftware.b4a.objects.AnimationWrapper*/ .InitializeTranslate(ba,"",(float) (-_width),(float) (0),(float) (0),(float) (0));
RDebugUtils.currentLine=1966096;
 //BA.debugLineNum = 1966096;BA.debugLine="mInAnimation.Duration = 200";
__ref._minanimation /*anywheresoftware.b4a.objects.AnimationWrapper*/ .setDuration((long) (200));
RDebugUtils.currentLine=1966097;
 //BA.debugLineNum = 1966097;BA.debugLine="mOutAnimation.InitializeTranslate(\"Out\", Width, 0";
__ref._moutanimation /*anywheresoftware.b4a.objects.AnimationWrapper*/ .InitializeTranslate(ba,"Out",(float) (_width),(float) (0),(float) (0),(float) (0));
RDebugUtils.currentLine=1966098;
 //BA.debugLineNum = 1966098;BA.debugLine="mOutAnimation.Duration = 200";
__ref._moutanimation /*anywheresoftware.b4a.objects.AnimationWrapper*/ .setDuration((long) (200));
RDebugUtils.currentLine=1966100;
 //BA.debugLineNum = 1966100;BA.debugLine="Activity.AddView(mSlidePanel, 0, Top, Width, 100%";
_activity.AddView((android.view.View)(__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),(int) (0),_top,_width,(int) (__c.PerYToCurrent((float) (100),ba)-_top));
RDebugUtils.currentLine=1966102;
 //BA.debugLineNum = 1966102;BA.debugLine="mBackPanel.Initialize(\"mBackPanel\")";
__ref._mbackpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"mBackPanel");
RDebugUtils.currentLine=1966103;
 //BA.debugLineNum = 1966103;BA.debugLine="mBackPanel.Color = Colors.Transparent";
__ref._mbackpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setColor(__c.Colors.Transparent);
RDebugUtils.currentLine=1966104;
 //BA.debugLineNum = 1966104;BA.debugLine="Activity.AddView(mBackPanel, -100%x, 0, 100%x, 10";
_activity.AddView((android.view.View)(__ref._mbackpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),(int) (-__c.PerXToCurrent((float) (100),ba)),(int) (0),__c.PerXToCurrent((float) (100),ba),__c.PerYToCurrent((float) (100),ba));
RDebugUtils.currentLine=1966106;
 //BA.debugLineNum = 1966106;BA.debugLine="mSlidePanel.AddView(mListView, 0, 0, mSlidePanel.";
__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .getObject()),(int) (0),(int) (0),__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth(),__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight());
RDebugUtils.currentLine=1966107;
 //BA.debugLineNum = 1966107;BA.debugLine="mSlidePanel.Visible = False";
__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setVisible(__c.False);
RDebugUtils.currentLine=1966108;
 //BA.debugLineNum = 1966108;BA.debugLine="End Sub";
return "";
}
public String  _additem(b4a.example.slidemenu __ref,String _text,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _image,Object _returnvalue) throws Exception{
__ref = this;
RDebugUtils.currentModule="slidemenu";
if (Debug.shouldDelegate(ba, "additem", false))
	 {return ((String) Debug.delegate(ba, "additem", new Object[] {_text,_image,_returnvalue}));}
b4a.example.slidemenu._actionitem _item = null;
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Public Sub AddItem(Text As String, Image As Bitmap";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Dim item As ActionItem";
_item = new b4a.example.slidemenu._actionitem();
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="item.Initialize";
_item.Initialize();
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="item.Text = Text";
_item.Text /*String*/  = _text;
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="item.Image = Image";
_item.Image /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/  = _image;
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="item.Value = ReturnValue";
_item.Value /*Object*/  = _returnvalue;
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="If Not(Image.IsInitialized) Then";
if (__c.Not(_image.IsInitialized())) { 
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="mListView.AddTwoLinesAndBitmap2(Text, \"\", Null,";
__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .AddTwoLinesAndBitmap2(BA.ObjectToCharSequence(_text),BA.ObjectToCharSequence(""),(android.graphics.Bitmap)(__c.Null),_returnvalue);
 }else {
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="mListView.AddTwoLinesAndBitmap2(Text, \"\", Image,";
__ref._mlistview /*anywheresoftware.b4a.objects.ListViewWrapper*/ .AddTwoLinesAndBitmap2(BA.ObjectToCharSequence(_text),BA.ObjectToCharSequence(""),(android.graphics.Bitmap)(_image.getObject()),_returnvalue);
 };
RDebugUtils.currentLine=2031628;
 //BA.debugLineNum = 2031628;BA.debugLine="End Sub";
return "";
}
public boolean  _isvisible(b4a.example.slidemenu __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="slidemenu";
if (Debug.shouldDelegate(ba, "isvisible", false))
	 {return ((Boolean) Debug.delegate(ba, "isvisible", null));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Public Sub isVisible As Boolean";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Return mSlidePanel.Visible";
if (true) return __ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getVisible();
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="End Sub";
return false;
}
public String  _hide(b4a.example.slidemenu __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="slidemenu";
if (Debug.shouldDelegate(ba, "hide", false))
	 {return ((String) Debug.delegate(ba, "hide", null));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Public Sub Hide";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="If isVisible = False Then Return";
if (__ref._isvisible /*boolean*/ (null)==__c.False) { 
if (true) return "";};
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="mBackPanel.Left = -mBackPanel.Width";
__ref._mbackpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setLeft((int) (-__ref._mbackpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()));
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="mSlidePanel.Left = -mSlidePanel.Width";
__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setLeft((int) (-__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth()));
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="mOutAnimation.Start(mSlidePanel)";
__ref._moutanimation /*anywheresoftware.b4a.objects.AnimationWrapper*/ .Start((android.view.View)(__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()));
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="End Sub";
return "";
}
public String  _show(b4a.example.slidemenu __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="slidemenu";
if (Debug.shouldDelegate(ba, "show", false))
	 {return ((String) Debug.delegate(ba, "show", null));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Public Sub Show";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="If isVisible = True Then Return";
if (__ref._isvisible /*boolean*/ (null)==__c.True) { 
if (true) return "";};
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="mBackPanel.BringToFront";
__ref._mbackpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .BringToFront();
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="mSlidePanel.BringToFront";
__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .BringToFront();
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="mBackPanel.Left = 0";
__ref._mbackpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setLeft((int) (0));
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="mSlidePanel.Left = 0";
__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setLeft((int) (0));
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="mSlidePanel.Visible = True";
__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setVisible(__c.True);
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="mInAnimation.Start(mSlidePanel)";
__ref._minanimation /*anywheresoftware.b4a.objects.AnimationWrapper*/ .Start((android.view.View)(__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()));
RDebugUtils.currentLine=2097162;
 //BA.debugLineNum = 2097162;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.slidemenu __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="slidemenu";
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub Class_Globals";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Type ActionItem (Text As String, Image As Bitmap,";
;
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="Private mSlidePanel As Panel";
_mslidepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Private mBackPanel As Panel";
_mbackpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="Private mModule As Object";
_mmodule = new Object();
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="Private mEventName As String";
_meventname = "";
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="Private mListView As ListView";
_mlistview = new anywheresoftware.b4a.objects.ListViewWrapper();
RDebugUtils.currentLine=1900555;
 //BA.debugLineNum = 1900555;BA.debugLine="Private mInAnimation As Animation";
_minanimation = new anywheresoftware.b4a.objects.AnimationWrapper();
RDebugUtils.currentLine=1900556;
 //BA.debugLineNum = 1900556;BA.debugLine="Private mOutAnimation As Animation";
_moutanimation = new anywheresoftware.b4a.objects.AnimationWrapper();
RDebugUtils.currentLine=1900557;
 //BA.debugLineNum = 1900557;BA.debugLine="End Sub";
return "";
}
public String  _mbackpanel_touch(b4a.example.slidemenu __ref,int _action,float _x,float _y) throws Exception{
__ref = this;
RDebugUtils.currentModule="slidemenu";
if (Debug.shouldDelegate(ba, "mbackpanel_touch", false))
	 {return ((String) Debug.delegate(ba, "mbackpanel_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Private Sub mBackPanel_Touch (Action As Int, X As";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="If Action = 1 Then";
if (_action==1) { 
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Hide";
__ref._hide /*String*/ (null);
 };
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="End Sub";
return "";
}
public String  _mlistview_itemclick(b4a.example.slidemenu __ref,int _position,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="slidemenu";
if (Debug.shouldDelegate(ba, "mlistview_itemclick", false))
	 {return ((String) Debug.delegate(ba, "mlistview_itemclick", new Object[] {_position,_value}));}
String _subname = "";
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Private Sub mListView_ItemClick (Position As Int,";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Dim subname As String";
_subname = "";
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Hide";
__ref._hide /*String*/ (null);
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="subname = mEventName & \"_Click\"";
_subname = __ref._meventname /*String*/ +"_Click";
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="If SubExists(mModule, subname) Then";
if (__c.SubExists(ba,__ref._mmodule /*Object*/ ,_subname)) { 
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="CallSub2(mModule, subname, Value)";
__c.CallSubNew2(ba,__ref._mmodule /*Object*/ ,_subname,_value);
 };
RDebugUtils.currentLine=2359303;
 //BA.debugLineNum = 2359303;BA.debugLine="End Sub";
return "";
}
public String  _out_animationend(b4a.example.slidemenu __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="slidemenu";
if (Debug.shouldDelegate(ba, "out_animationend", false))
	 {return ((String) Debug.delegate(ba, "out_animationend", null));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Private Sub Out_AnimationEnd";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="mSlidePanel.Visible = False";
__ref._mslidepanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setVisible(__c.False);
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="End Sub";
return "";
}
}