﻿B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private xui As XUI
	Dim sm As SlideMenu
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("layoutPaginaPrincipal")
	
	sm.Initialize(Activity, Me, "SlideMenu", 60dip, 225dip)

	sm.AddItem("Gestionar Pedidos", Null, 1)
	sm.AddItem("Realizar Pedido", Null, 2)
	sm.AddItem("Informes", Null, 3)
	sm.AddItem("Cerrar Sesión", Null, 4)
	'sm.AddItem("Item #4", LoadBitmap(File.DirAssets, "wrench.png"), 4)'
	'sm.AddItem("Item #5", LoadBitmap(File.DirAssets, "wrench_orange.png"), 5)'

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

'We capture the menu and back keys
Sub Activity_KeyPress (KeyCode As Int) As Boolean
	'Pressing the back key while the slidemenu is open will close it
	If KeyCode = KeyCodes.KEYCODE_BACK And sm.isVisible Then
		sm.Hide
		Return True
	End If

	'Pressing the menu key will open/close the slidemenu
	If KeyCode = KeyCodes.KEYCODE_MENU Then
		If sm.isVisible Then 
			sm.Hide 
		Else 
			sm.Show
		End If
		Return True
	End If
End Sub

'Show the slidemenu
Sub btnShow_Click
	sm.Show
End Sub

'Event sub which is called when an item in the slidemenu is clicked
Sub SlideMenu_Click(Item As Object)
	Select Item
		Case 1
			xui.MsgboxAsync("¡Modulo en mantenimiento! Volveremos pronto", "OK")
		Case 2
			xui.MsgboxAsync("¡Modulo en mantenimiento! Volveremos pronto", "OK")
		Case 3
			xui.MsgboxAsync("¡Modulo en mantenimiento! Volveremos pronto", "OK")
		Case 4
			Dim mensaje_usuario As Object = xui.Msgbox2Async("¿Desea cerrar sesión?", "GetOut", "Aceptar", "Cancelar", "", Null)
			Wait For (mensaje_usuario) Msgbox_Result (Result As Int)
			If Result = xui.DialogResponse_Positive Then
				StartActivity("Main")
			End If
	End Select
	ToastMessageShow("Item clicked: " & Item, False)
End Sub



