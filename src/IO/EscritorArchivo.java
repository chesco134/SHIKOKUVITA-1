package IO;

/**
 *
 * @author Alumno
 */
public class EscritorArchivo {
    private String nombreArchivoDeSalida;
	private java.io.OutputStreamWriter osw;
	
	public EscritorArchivo(String nombreArchivoDeSalida, boolean deseaConcatenar) {
		this.nombreArchivoDeSalida = nombreArchivoDeSalida;
		try{
			osw = new java.io.OutputStreamWriter(new java.io.FileOutputStream(new java.io.File(nombreArchivoDeSalida), deseaConcatenar), java.nio.charset.StandardCharsets.UTF_8);
		}catch(java.io.IOException e){
			osw = null;
			System.out.println("Error en el arhivo de salida: " + e.getMessage());
		}
	}
	
	public boolean isActive(){
		return osw != null;
	}
	
	public void escribir(String linea){
		try{
			osw.write(new String(linea.getBytes(),"UTF-8"));
			osw.write("\n");
		}catch(java.io.IOException e){
			e.printStackTrace();
		}
	}
	
	public void cerrar(){
		try{
			osw.close();
		}catch(java.io.IOException e){
			e.printStackTrace();
		}
	}
}
