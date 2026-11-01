/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - Jesanny - 
 */
public class Podometro {

    /**
     * Inicializa el podómetro con la marca indicada por el parámetro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */

    private static final char HOMBRE = 'H';
    private static final char MUJER = 'M';
    private static final double RAZON_ZANCADA_HOMBRE = 0.45;
    private static final double RAZON_ZANCADA_MUJER = 0.41;
    private static final int SABADO = 6;
    private static final int DOMINGO = 7;   

    private String marca;
    private int altura;
    private char sexo;
    private int longitudZancada;
    private int totalPasosLaborables;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;

    public Podometro(String queMarca) {
        marca = queMarca;
        altura = 0;
        sexo = MUJER;
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0.0;
        totalDistanciaFinSemana = 0.0;
        tiempo = 0;
        caminatasNoche = 0;

    }

    /**
     * accesor para la marca
     *  
     */

    public String getMarca(){
        return marca;
    }

    /**
     * Simula la configuración del podómetro.
     * Recibe como parámetros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna además el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(int queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;
        if (sexo == HOMBRE) {   
            longitudZancada = (int) Math.ceil(altura * RAZON_ZANCADA_HOMBRE); 
        } else {
            longitudZancada = (int) Math.floor(altura * RAZON_ZANCADA_MUJER);
        }   
    }

    /**
     *  Recibe cuatro parámetros que supondremos correctos:
     *    pasos - el nº de pasos caminados
     *    dia - nº de día de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - Sábado, 7 - Domingo)
     *    horaInicio – hora de inicio de la caminata
     *    horaFin – hora de fin de la caminata
     *    
     *    A partir de estos parámetros el método debe realizar ciertos cálculos
     *    y  actualizará el podómetro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,int horaFin){

        double distancia = pasos * longitudZancada / 100000.0;

        switch (dia){
            case SABADO:
                totalPasosSabado += pasos;
                break ;
            case DOMINGO:
                totalPasosDomingo += pasos;
                break ;
            default:
                totalPasosLaborables += pasos;
                break;
        }

        switch (dia) {
            case SABADO:
            case DOMINGO:
                totalDistanciaFinSemana += distancia;
                break;
        }
        totalDistanciaSemana += distancia;

        if (horaInicio >= 2100) {
            caminatasNoche++;
        }

        // me falta calcular el tiempo
       int horaEntrada = horaInicio / 100;
        int minutoEntrada = horaInicio % 100;
        int inicioEnMinutos = horaEntrada * 60 + minutoEntrada;

        int horaSalida = horaFin / 100;
        int minutoSalida = horaFin % 100;
        int finEnMinutos = horaSalida * 60 + minutoSalida;

        tiempo += finEnMinutos - inicioEnMinutos;
    } 

    /**
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {

        String queSexo;
    
        if (sexo == 'M') {
            queSexo = "MUJER";
        }
           else {
                queSexo = "HOMBRE";
        } 

        System.out.println("Configuración del podómetro\n" + //
            "*********************************\n" + //
            "Altura: " +   altura / 100.0 + " metros\n" + //
            "Sexo: " +  queSexo + "\n" + //
            "Longitud zancada: " + longitudZancada / 100.0 + " metros");

    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {

     System.out.println ( " Estadísticas\n" + 
        "*********************************\n" +
        "Distancia recorrida toda la semana: " + totalDistanciaSemana + " Km \n " +
        "Distancia recorrida fin de semana: " + totalDistanciaFinSemana + " Km  \n" +
        "Nº pasos días laborables: " + totalPasosLaborables + "\n" +
        "Nº pasos SÁBADO: " + totalPasosSabado + "\n" +
        "Nº pasos DOMINGO: " + totalPasosDomingo + "\n" +
        "Nº caminatas realizadas a partir de las 21h: " + caminatasNoche + "\n" +
        "Tiempo total caminado en la semana: " + tiempo + "m");
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {

        return "" ;

    }

    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() {
        altura = 0;
        sexo = MUJER;
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0.0;
        totalDistanciaFinSemana = 0.0;
        tiempo = 0;
        caminatasNoche = 0;
    }
}
