package controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
	
	public static String getFecha() {
        String fechaActual = null;
        //La clase GregorianCalendar es una subclase de 
        //Calendar y maneja el calendario estandar usado en el mundo
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = (fecha.get(Calendar.MONTH)) + 1;
        @SuppressWarnings("static-access")
		int anio = fecha.get(fecha.YEAR);
        fechaActual = "" + dia + "/" + mes + "/" + anio;

        return fechaActual;
    }
	@SuppressWarnings("static-access")
	public static String getHora() {
        String horaActual = null;
        GregorianCalendar fecha = new GregorianCalendar();
        @SuppressWarnings("static-access")
		int segundo = fecha.get(fecha.SECOND);
        @SuppressWarnings("static-access")
		int minuto = fecha.get(fecha.MINUTE);
        int hora = fecha.get(fecha.HOUR);

        horaActual = "" + hora + ":" + minuto + ":" + segundo;
        return horaActual;

    }
}
