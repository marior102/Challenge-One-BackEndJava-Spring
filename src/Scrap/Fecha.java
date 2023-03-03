package Scrap;

import java.util.GregorianCalendar;

public class Fecha {
	
	public static String getFecha() {
        String fechaActual = null;
        //La clase GregorianCalendar es una subclase de 
        //Calendar y maneja el calendario estandar usado en el mundo
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = (fecha.get(fecha.MONTH)) + 1;
        int anio = fecha.get(fecha.YEAR);
        fechaActual = "" + dia + "/" + mes + "/" + anio;

        return fechaActual;
    }
	public static String getHora() {
        String horaActual = null;
        GregorianCalendar fecha = new GregorianCalendar();
        int segundo = fecha.get(fecha.SECOND);
        int minuto = fecha.get(fecha.MINUTE);
        int hora = fecha.get(fecha.HOUR);

        horaActual = "" + hora + ":" + minuto + ":" + segundo;
        return horaActual;

    }
}
