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
	Public usr_email_global As String
	Public usr_nombre As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private txt_cedula As EditText
	Private txt_primer_nombre As EditText
	Private txt_segundo_nombre As EditText
	Private txt_primer_apellido As EditText
	Private txt_segundo_apellido As EditText
	Private txt_correo As EditText
	Private txt_contrasenia As EditText
	Private txt_fecha_nacimiento As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("layoutRegistroUsuario")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub btn_calendario_fecha_nacimiento_Click
	
End Sub

Private Sub btn_registrar_usuario_Click
	
	If txt_cedula.Text = "" Then
		xui.MsgboxAsync("El campo 'Cédula' no puede estar vacío.", "Error")
		Return
	End If
	
	If txt_cedula.Text.Length > 13 Then
		xui.MsgboxAsync("La cédula no puede tener más de 13 caracteres.", "Error")
		Return
	End If
    
	If txt_primer_nombre.Text = "" Then
		xui.MsgboxAsync("El campo 'Primer Nombre' no puede estar vacío.", "Error")
		Return
	End If
    
	If txt_segundo_nombre.Text = "" Then
		xui.MsgboxAsync("El campo 'Segundo Nombre' no puede estar vacío.", "Error")
		Return
	End If
    
	If txt_primer_apellido.Text = "" Then
		xui.MsgboxAsync("El campo 'Primer Apellido' no puede estar vacío.", "Error")
		Return
	End If
    
	If txt_segundo_apellido.Text = "" Then
		xui.MsgboxAsync("El campo 'Segundo Apellido' no puede estar vacío.", "Error")
		Return
	End If
    
	If txt_primer_nombre.Text.Length > 100 Then
		xui.MsgboxAsync("El campo 'Primer Nombre' no puede tener más de 100 caracteres.", "Error")
		Return
	End If
    
	If txt_segundo_nombre.Text.Length > 100 Then
		xui.MsgboxAsync("El campo 'Segundo Nombre' no puede tener más de 100 caracteres.", "Error")
		Return
	End If
    
	If txt_primer_apellido.Text.Length > 100 Then
		xui.MsgboxAsync("El campo 'Primer Apellido' no puede tener más de 100 caracteres.", "Error")
		Return
	End If
    
	If txt_segundo_apellido.Text.Length > 100 Then
		xui.MsgboxAsync("El campo 'Segundo Apellido' no puede tener más de 100 caracteres.", "Error")
		Return
	End If
	
	If txt_correo.Text = "" Then
		xui.MsgboxAsync("El campo 'Correo' no puede estar vacío.", "Error")
		Return
	End If
    
	If txt_correo.Text.Length > 250 Then
		xui.MsgboxAsync("El campo 'Correo/email' no puede tener más de 250 caracteres.", "Error")
		Return
	End If
	
	If txt_contrasenia.Text = "" Then
		xui.MsgboxAsync("El campo 'Contraseña' no puede estar vacío.", "Error")
		Return
	End If
	
	If txt_contrasenia.Text.Length > 15 Then
		xui.MsgboxAsync("¡La contraseña no puede contener más de 15 caracteres!", "Error")
		Return
	End If
    
	If txt_fecha_nacimiento.Text = "" Then
		xui.MsgboxAsync("El campo 'Fecha de Nacimiento' no puede estar vacío.", "Error")
		Return
	End If
	
	Dim mapRegister As Map
	Dim jsonRegister As String
	Dim jsonGenerator As JSONGenerator
	Dim usuario_ As usuario
	
	usuario_.usr_cedula = txt_cedula.Text
	usuario_.usr_primer_nombre = txt_primer_nombre.Text
	usuario_.usr_segundo_nombre = txt_segundo_nombre.Text
	usuario_.usr_primer_apellido = txt_primer_apellido.Text
	usuario_.usr_segundo_apellido = txt_segundo_apellido.Text
	usr_nombre = txt_primer_nombre.Text & "" & txt_primer_apellido.Text
	usuario_.usr_email = txt_correo.Text
	usr_email_global = txt_correo.Text
	usuario_.usr_contrasenia = txt_contrasenia.Text
	usuario_.usr_fecha_nacimiento = txt_fecha_nacimiento.Text
	usuario_.usr_rol = "2"
	usuario_.usr_estado = "H"
	
	mapRegister.Initialize
	mapRegister.Put("usr_cedula", usuario_.usr_cedula)
	mapRegister.Put("usr_primer_nombre", usuario_.usr_primer_nombre)
	mapRegister.Put("usr_segundo_nombre", usuario_.usr_segundo_nombre)
	mapRegister.Put("usr_primer_apellido", usuario_.usr_primer_apellido)
	mapRegister.Put("usr_segundo_apellido", usuario_.usr_segundo_apellido)
	mapRegister.Put("usr_email", usuario_.usr_email)
	mapRegister.Put("usr_contrasenia", usuario_.usr_contrasenia)
	mapRegister.Put("usr_fecha_nacimiento", usuario_.usr_fecha_nacimiento)
	mapRegister.Put("usr_rol", usuario_.usr_rol)
	mapRegister.Put("usr_estado", usuario_.usr_estado)
	
	jsonGenerator.Initialize(mapRegister)
	jsonRegister = jsonGenerator.ToPrettyString(5)
	
	Dim peticion As HttpJob
	peticion.Initialize("", Me)
	peticion.PostString("https://biblioteca-3q4a.onrender.com/api/usuarios", jsonRegister)
	peticion.GetRequest.SetContentType("application/json")
	
	Wait For (peticion) JobDone (respuesta As HttpJob)
	
	If respuesta.Success Then
		
		txt_cedula.Text = ""
		txt_primer_nombre.Text = ""
		txt_segundo_nombre.Text = ""
		txt_primer_apellido.Text = ""
		txt_segundo_apellido.Text = ""
		txt_correo.Text = ""
		txt_contrasenia.Text = ""
		txt_fecha_nacimiento.Text = ""
		
		peticion.Release
		StartActivity("ValidacionUsuario")
	Else
		xui.MsgboxAsync("¡Registro fallido! " & respuesta.GetString, "Error")
	End If
	peticion.Release
	
End Sub

Private Sub btn_iniciar_sesion_Click
	StartActivity("Main")
End Sub