package interfaces;

public interface UnidadMedida  extends ElementoConvertible{
    String getSimbolo();
    void setSimbolo(String simbolo);
    String getNombre();
    void setNombre(String nombre);
    double getLongitud();
    void setLongitud(double longitud);
    
}