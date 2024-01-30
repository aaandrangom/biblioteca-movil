B4A=true
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
	Private xui As XUI
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private txt_codigo_verificacion As EditText
	Private lbl_nombre_usuario As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("layoutValidacionUsuario")
	xui.MsgboxAsync("¡Registro exitoso!", "OK")
	lbl_nombre_usuario.Text = "Estimado @" & RegistroUsuario.usr_nombre
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub btn_validar_usuario_Click
	If txt_codigo_verificacion.Text = "" Then
		xui.MsgboxAsync("No puede quedar vacio el código único!", "Error")
		Return
	End If
	
	Dim mapValidation As Map
	Dim jsonValidation As String
	Dim jsonGenerator As JSONGenerator
	Dim validacion_ As validacionCodigoUsuario
	
	validacion_.usr_email = RegistroUsuario.usr_email_global
	validacion_.codigoVerificacion = txt_codigo_verificacion.Text
	
	mapValidation.Initialize
	mapValidation.Put("usr_email", validacion_.usr_email)
	mapValidation.Put("codigoVerificacion", validacion_.codigoVerificacion)
	
	jsonGenerator.Initialize(mapValidation)
	jsonValidation = jsonGenerator.ToPrettyString(5)
	
	Dim peticion As HttpJob
	peticion.Initialize("", Me)
	peticion.PostString("https://biblioteca-3q4a.onrender.com/api/usuarios/verificar", jsonValidation)
	peticion.GetRequest.SetContentType("application/json")
	
	Wait For (peticion) JobDone (respuesta As HttpJob)

	If respuesta.Success Then
		Dim jsonParser As JSONParser
		jsonParser.Initialize(respuesta.GetString)
		Dim user As Map
		user = jsonParser.NextObject.Get("usuario")
		Dim nickname As String
		nickname = user.Get("usr_nickname")
		
		Dim mensaje_usuario As Object = xui.Msgbox2Async("¡Verificacion exitosa!. Tu nuevo usuario es el siguiente: " & nickname, "Ok", "Aceptar", "", "", Null)
		 txt_codigo_verificacion.Text = ""
		 Wait For (mensaje_usuario) Msgbox_Result (Result As Int)
		 If Result = xui.DialogResponse_Positive Then
			peticion.Release
			StartActivity("Main")
		End If
	Else
		xui.MsgboxAsync("¡Verificacion fallida! " & respuesta.GetString, "Error")
	End If
	peticion.Release
	
End Sub