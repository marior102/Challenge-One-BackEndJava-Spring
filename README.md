# Conversor de Moneda y Unidad de Medida
![imagenmeni](https://user-images.githubusercontent.com/119633101/228260570-bdc820e0-7189-40b1-b899-b00ce8bab735.png)
**Este proyecto es un programa de Java orientado a objetos que permite convertir monedas y unidades de medida. El programa fue desarrollado como parte del programa de Formación de Alura Latam-Oracle en un challenge de conversión.**


## Conversor de Monedas
![imagenmoneda](https://user-images.githubusercontent.com/119633101/228261257-fbbb09dd-2a8a-4d4b-9285-2be4d191cfb6.png)

Conversor de Monedas es un programa que te permite convertir entre diferentes monedas. Está diseñado en Java, siguiendo los principios de la programación orientada a objetos.
### 	Monedas admitidas

			El Conversor de Monedas admite las siguientes monedas:
			
* 						Dólar estadounidense (USD)
* 						Euro (EUR)
* 						Libra esterlina (GBP)
* 						Yen japonés (JPY)
* 						Real brasileño (BRL)
* 						Guaraní (PYG)
			
### Obtención de las tasas de cambio

Para obtener las tasas de cambio de cada moneda, se utilizó la librería de Jsoup para obtener los datos de la página web cambioschaco.com.py. Las tasas de cambio se almacenan en un archivo de texto llamado elementosMonedas.txt para su uso posterior.

Si el programa no tiene acceso a Internet, las tasas de cambio se recuperan del archivo elementosMonedas.txt. También existe la opción de actualizar las tasas de cambio utilizando el botón "Actualizar datos" en la interfaz gráfica del programa.
### Uso

Para ejecutar el Conversor de Monedas, simplemente abre una terminal en la carpeta del proyecto y escribe java ConversorMonedas. La interfaz gráfica del programa te pedirá que ingreses el valor que deseas convertir, la moneda original y la moneda a la que deseas convertir. Luego te mostrará el valor convertido.

También puedes utilizar la tabla en la interfaz gráfica para ver las tasas de cambio actualizadas para cada moneda

Si el programa no tiene acceso a Internet, se utilizarán las tasas de cambio almacenadas en el archivo elementosMonedas.txt

## Conversor de Unidad de Medida
![ImagenUnidad](https://user-images.githubusercontent.com/119633101/228261345-9174541f-7bb0-4c54-a51a-a8e7efdc6474.png)

   El conversor de unidad de medida admite las siguientes unidades de medida:
					
*	                             Metros
*					    Pulgadas
*                               Pies
*					    Kilómetros
*					    Millas
*					    Millas Nauticas
*					    Yarda
					
		El programa convierte las unidades de medida de forma precisa y confiable. El código está diseñado para ser fácil de leer y seguir las buenas prácticas de    programación.
		<
		
## Actualizaciones de la versión
	 La última versión del programa presenta un cambio significativo en la legibilidad del código y la orientación a las buenas prácticas de programación.*
		
		
		
## 	Requerimientos
				
* 				Java 8 o superior
* 				Librería Jsoup
				
## 	Instrucciones de Uso
		Para utilizar el conversor de moneda o unidad de medida, simplemente ejecute el programa y seleccione la opción deseada. Siga las instrucciones en pantalla para ingresar los valores y realizar la conversión.
			
		
		
## 	Cambios realizados
		 En esta versión del programa, se realizaron varios cambios para mejorar la legibilidad del código y su orientación a buenas prácticas:
			
* 				Se utilizó una estructura de paquetes para organizar el código y los archivos de prueba.
* 				Se separaron las clases de conversión de moneda y de unidad de medida en dos archivos diferentes, para mejorar la modularidad del programa.
* 				Se utilizaron nombres de variables y métodos más descriptivos y se eliminaron los nombres cortos y confusos.
* 				Se implementó el uso de excepciones para manejar errores de entrada del usuario, en lugar de utilizar condicionales anidadas.
* 				Se agregó la funcionalidad de guardar y actualizar las tasas de cambio en un archivo de texto.
##  Conclusion

    En conclusión, este proyecto de conversión de monedas y unidades de medida utiliza el patrón de diseño MVC y se basa en tres interfaces principales: 
    la clase Padre Elemento Convertible, la interfaz Moneda y la interfaz UnidadMedida. El método abstracto conversorMultifuncional de la clase Padre Elemento 
    Convertible se encarga de realizar la conversión de ambas categorías, y las diferentes divisas y unidades de medida son implementadas mediante clases hijas que 
    extienden las respectivas interfaces. Aunque el proyecto comenzó con algunas dificultades debido a la creación inicial de clases desordenadas, 
    se pudo corregir y aplicar buenas prácticas de programación gracias a la orientación y ayuda del compañero Daniel Salgado. En general, este proyecto 
    representa una solución efectiva y organizada para laconversión de monedas y unidades de medida en un contexto de programación orientada a objetos.

