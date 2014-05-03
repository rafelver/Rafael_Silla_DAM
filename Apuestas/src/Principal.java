
public class Principal {
        
	public static void main(String[] args) {
        //creamos el bojeto liga 
		Liga liga = new Liga(); 
		//llamamos a la Ventana liga 
        VentanaLiga frame = new VentanaLiga(liga);
		frame.setVisible(true);
	}

}
