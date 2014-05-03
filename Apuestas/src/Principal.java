
public class Principal {

	public static void main(String[] args) {
	    //creamos el objeto equipo y lo iniciamos con un valor
        Equipo equipo = new Equipo("",0,0,0,0); 
		//mostramos la Ventana Equipo
        VentanaEquipo frame = new VentanaEquipo(equipo);
		frame.setVisible(true);
	}

}
