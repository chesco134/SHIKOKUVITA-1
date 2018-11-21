package Usuarios;

public class Usuario {
    private String nombreUsuario;
    private String pass;
	private boolean privilegio;

    
    public Usuario(String nombreUsuario, String contraseña, boolean privilegio){
        this.nombreUsuario = nombreUsuario;
        this.pass = contraseña;
		this.privilegio = privilegio;
    }
    public Usuario(String nombreUsuario, String contraseña){
        this.nombreUsuario = nombreUsuario;
        this.pass = contraseña;
    }
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public String getPass(){
        return pass;
    }
    public boolean getPrivilegio(){
            return privilegio;
    }
    public void setNewPasswd(String pass){
        this.pass = pass;
    }
}
