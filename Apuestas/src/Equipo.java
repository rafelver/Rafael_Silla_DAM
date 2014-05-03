import java.io.Serializable;

public class Equipo implements Serializable{
	
	//creamos los atributos privados
	private String nombreEquipo;
	private int golesFavor;
	private int golesEnContra;
	private int partidosGanados;
	private int partidosPerdidos;
	
	//constructor Equipo
	public Equipo(String nom,int golesF,int golesC,int partidosG,int partidosP) {
		nombreEquipo = nom;
		golesFavor = golesF;
		golesEnContra = golesC;
		partidosGanados = partidosG;
		partidosPerdidos = partidosP;				
	}
	//creamos el constructor sin parametros
		public Equipo(){
			nombreEquipo="";
			golesFavor = 0;
			golesEnContra = 0;
			partidosGanados = 0;
			partidosPerdidos= 0;
		}
    //metodo para asignar el nombre del Equipo
	public void setNombre (String nom){
		nombreEquipo = nom;
	}
	//metodo que devuelve el nombre del Equipo
	public String getNombre(){
		return nombreEquipo;
	}
    //metodo para asignar goles a Favor
    public void setGolesFavor(int golesF){
    	golesFavor = golesF;
    }
   //metodo que devuelve los goles a Favor
   public int getGolesFavor(){
	   return golesFavor;
   }
   //metodo para asignar goles en Contra
   public void setGolesContra(int golesC){
	   golesEnContra = golesC;
   }
   //metodo que devuelve goles en Contra
   public int getGolesContra(){
	   return golesEnContra;
   }
   //metodo para asignar Partidos Ganados
   public void setPartidosGanados(int partidosG){
	   partidosGanados = partidosG;
   }
   //metodo que devuelve Partidos Ganados
   public int getPartidosGanados(){
	   return partidosGanados;
   }
   //metodo que asigna partidos Perdidos
   public void setPartidosPerdidos(int partidosP){
	   partidosPerdidos = partidosP;
   }
   //metodo que devuelve Partidos Perdidos
   public int getPartidosPerdidos(){
	   return partidosPerdidos;
   }
	
	
}
