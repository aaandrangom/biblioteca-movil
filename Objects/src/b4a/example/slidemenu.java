package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class slidemenu extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.slidemenu");
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
public String  _additem(String _text,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _image,Object _returnvalue) throws Exception{
b4a.example.slidemenu._actionitem _item = null;
 //BA.debugLineNum = 56;BA.debugLine="Public Sub AddItem(Text As String, Image As Bitmap";
 //BA.debugLineNum = 57;BA.debugLine="Dim item As ActionItem";
_item = new b4a.example.slidemenu._actionitem();
 //BA.debugLineNum = 58;BA.debugLine="item.Initialize";
_item.Initialize();
 //BA.debugLineNum = 59;BA.debugLine="item.Text = Text";
_item.Text /*String*/  = _text;
 //BA.debugLineNum = 60;BA.debugLine="item.Image = Image";
_item.Image /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/  = _image;
 //BA.debugLineNum = 61;BA.debugLine="item.Value = ReturnValue";
_item.Value /*Object*/  = _returnvalue;
 //BA.debugLineNum = 63;BA.debugLine="If Not(Image.IsInitialized) Then";
if (__c.Not(_image.IsInitialized())) { 
 //BA.debugLineNum = 64;BA.debugLine="mListView.AddTwoLinesAndBitmap2(Text, \"\", Null,";
_mlistview.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence(_text),BA.ObjectToCharSequence(""),(android.graphics.Bitmap)(__c.Null),_returnvalue);
 }else {
 //BA.debugLineNum = 66;BA.debugLine="mListView.AddTwoLinesAndBitmap2(Text, \"\", Image,";
_mlistview.AddTwoLinesAndBitmap2(BA.ObjectToCharSequence(_text),BA.ObjectToCharSequence(""),(android.graphics.Bitmap)(_image.getObject()),_returnvalue);
 };
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Type ActionItem (Text As String, Image As Bitmap,";
;
 //BA.debugLineNum = 4;BA.debugLine="Private mSlidePanel As Panel";
_mslidepanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 5;BA.debugLine="Private mBackPanel As Panel";
_mbackpanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private mModule As Object";
_mmodule = new Object();
 //BA.debugLineNum = 8;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 10;BA.debugLine="Private mListView As ListView";
_mlistview = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private mInAnimation As Animation";
_minanimation = new anywheresoftware.b4a.objects.AnimationWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private mOutAnimation As Animation";
_moutanimation = new anywheresoftware.b4a.objects.AnimationWrapper();
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public String  _hide() throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Public Sub Hide";
 //BA.debugLineNum = 85;BA.debugLine="If isVisible = False Then Return";
if (_isvisible()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 87;BA.debugLine="mBackPanel.Left = -mBackPanel.Width";
_mbackpanel.setLeft((int) (-_mbackpanel.getWidth()));
 //BA.debugLineNum = 88;BA.debugLine="mSlidePanel.Left = -mSlidePanel.Width";
_mslidepanel.setLeft((int) (-_mslidepanel.getWidth()));
 //BA.debugLineNum = 89;BA.debugLine="mOutAnimation.Start(mSlidePanel)";
_moutanimation.Start((android.view.View)(_mslidepanel.getObject()));
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,Object _module,String _eventname,int _top,int _width) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 22;BA.debugLine="Sub Initialize(Activity As Activity, Module As Obj";
 //BA.debugLineNum = 23;BA.debugLine="mModule = Module";
_mmodule = _module;
 //BA.debugLineNum = 24;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 26;BA.debugLine="mSlidePanel.Initialize(\"mSlidePanel\")";
_mslidepanel.Initialize(ba,"mSlidePanel");
 //BA.debugLineNum = 28;BA.debugLine="mListView.Initialize(\"mListView\")";
_mlistview.Initialize(ba,"mListView");
 //BA.debugLineNum = 29;BA.debugLine="mListView.TwoLinesAndBitmap.SecondLabel.Visible =";
_mlistview.getTwoLinesAndBitmap().SecondLabel.setVisible(__c.False);
 //BA.debugLineNum = 30;BA.debugLine="mListView.TwoLinesAndBitmap.ItemHeight = 50dip";
_mlistview.getTwoLinesAndBitmap().setItemHeight(__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 31;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Gravity = Gravi";
_mlistview.getTwoLinesAndBitmap().Label.setGravity(__c.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 32;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Height = mListV";
_mlistview.getTwoLinesAndBitmap().Label.setHeight(_mlistview.getTwoLinesAndBitmap().getItemHeight());
 //BA.debugLineNum = 33;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Top = 0";
_mlistview.getTwoLinesAndBitmap().Label.setTop((int) (0));
 //BA.debugLineNum = 34;BA.debugLine="mListView.TwoLinesAndBitmap.ImageView.SetLayout(1";
_mlistview.getTwoLinesAndBitmap().ImageView.SetLayout(__c.DipToCurrent((int) (13)),__c.DipToCurrent((int) (13)),__c.DipToCurrent((int) (24)),__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 35;BA.debugLine="mListView.Color = Colors.Black";
_mlistview.setColor(__c.Colors.Black);
 //BA.debugLineNum = 37;BA.debugLine="mInAnimation.InitializeTranslate(\"\", -Width, 0, 0";
_minanimation.InitializeTranslate(ba,"",(float) (-_width),(float) (0),(float) (0),(float) (0));
 //BA.debugLineNum = 38;BA.debugLine="mInAnimation.Duration = 200";
_minanimation.setDuration((long) (200));
 //BA.debugLineNum = 39;BA.debugLine="mOutAnimation.InitializeTranslate(\"Out\", Width, 0";
_moutanimation.InitializeTranslate(ba,"Out",(float) (_width),(float) (0),(float) (0),(float) (0));
 //BA.debugLineNum = 40;BA.debugLine="mOutAnimation.Duration = 200";
_moutanimation.setDuration((long) (200));
 //BA.debugLineNum = 42;BA.debugLine="Activity.AddView(mSlidePanel, 0, Top, Width, 100%";
_activity.AddView((android.view.View)(_mslidepanel.getObject()),(int) (0),_top,_width,(int) (__c.PerYToCurrent((float) (100),ba)-_top));
 //BA.debugLineNum = 44;BA.debugLine="mBackPanel.Initialize(\"mBackPanel\")";
_mbackpanel.Initialize(ba,"mBackPanel");
 //BA.debugLineNum = 45;BA.debugLine="mBackPanel.Color = Colors.Transparent";
_mbackpanel.setColor(__c.Colors.Transparent);
 //BA.debugLineNum = 46;BA.debugLine="Activity.AddView(mBackPanel, -100%x, 0, 100%x, 10";
_activity.AddView((android.view.View)(_mbackpanel.getObject()),(int) (-__c.PerXToCurrent((float) (100),ba)),(int) (0),__c.PerXToCurrent((float) (100),ba),__c.PerYToCurrent((float) (100),ba));
 //BA.debugLineNum = 48;BA.debugLine="mSlidePanel.AddView(mListView, 0, 0, mSlidePanel.";
_mslidepanel.AddView((android.view.View)(_mlistview.getObject()),(int) (0),(int) (0),_mslidepanel.getWidth(),_mslidepanel.getHeight());
 //BA.debugLineNum = 49;BA.debugLine="mSlidePanel.Visible = False";
_mslidepanel.setVisible(__c.False);
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public boolean  _isvisible() throws Exception{
 //BA.debugLineNum = 112;BA.debugLine="Public Sub isVisible As Boolean";
 //BA.debugLineNum = 113;BA.debugLine="Return mSlidePanel.Visible";
if (true) return _mslidepanel.getVisible();
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return false;
}
public String  _mbackpanel_touch(int _action,float _x,float _y) throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="Private Sub mBackPanel_Touch (Action As Int, X As";
 //BA.debugLineNum = 97;BA.debugLine="If Action = 1 Then";
if (_action==1) { 
 //BA.debugLineNum = 98;BA.debugLine="Hide";
_hide();
 };
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public String  _mlistview_itemclick(int _position,Object _value) throws Exception{
String _subname = "";
 //BA.debugLineNum = 102;BA.debugLine="Private Sub mListView_ItemClick (Position As Int,";
 //BA.debugLineNum = 103;BA.debugLine="Dim subname As String";
_subname = "";
 //BA.debugLineNum = 104;BA.debugLine="Hide";
_hide();
 //BA.debugLineNum = 105;BA.debugLine="subname = mEventName & \"_Click\"";
_subname = _meventname+"_Click";
 //BA.debugLineNum = 106;BA.debugLine="If SubExists(mModule, subname) Then";
if (__c.SubExists(ba,_mmodule,_subname)) { 
 //BA.debugLineNum = 107;BA.debugLine="CallSub2(mModule, subname, Value)";
__c.CallSubNew2(ba,_mmodule,_subname,_value);
 };
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public String  _out_animationend() throws Exception{
 //BA.debugLineNum = 92;BA.debugLine="Private Sub Out_AnimationEnd";
 //BA.debugLineNum = 93;BA.debugLine="mSlidePanel.Visible = False";
_mslidepanel.setVisible(__c.False);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public String  _show() throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Public Sub Show";
 //BA.debugLineNum = 72;BA.debugLine="If isVisible = True Then Return";
if (_isvisible()==__c.True) { 
if (true) return "";};
 //BA.debugLineNum = 74;BA.debugLine="mBackPanel.BringToFront";
_mbackpanel.BringToFront();
 //BA.debugLineNum = 75;BA.debugLine="mSlidePanel.BringToFront";
_mslidepanel.BringToFront();
 //BA.debugLineNum = 76;BA.debugLine="mBackPanel.Left = 0";
_mbackpanel.setLeft((int) (0));
 //BA.debugLineNum = 77;BA.debugLine="mSlidePanel.Left = 0";
_mslidepanel.setLeft((int) (0));
 //BA.debugLineNum = 79;BA.debugLine="mSlidePanel.Visible = True";
_mslidepanel.setVisible(__c.True);
 //BA.debugLineNum = 80;BA.debugLine="mInAnimation.Start(mSlidePanel)";
_minanimation.Start((android.view.View)(_mslidepanel.getObject()));
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
