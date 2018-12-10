package controladorqytetet;
import java.util.ArrayList;
import modeloqytetet.EstadoJuego;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.Qytetet;

public class ControladorQytetet {
    private static final ControladorQytetet instance = new ControladorQytetet();
    private ArrayList<String> nombreJugadores = new ArrayList<>();
    private static Qytetet modelo = Qytetet.getInstance();
    private EstadoJuego estado;
    private MetodoSalirCarcel metodo;
    
    private ControladorQytetet(){
        this.nombreJugadores = new ArrayList<>();
        this.estado = null;
    }
    
    public static ControladorQytetet getInstance(){
        return instance;
    }
    
    public void setNombreJugadores(ArrayList<String> nombreJugadores){
        this.nombreJugadores = nombreJugadores;
        modelo.inicializarJuego(nombreJugadores);
    }

    public EstadoJuego getEstado() {
        return estado;
    }
    
    public ArrayList<Integer> obtenerOperacionesJuegoValidas(){
        ArrayList<Integer> operacionesValidas = new ArrayList<>();
        
        if(this.nombreJugadores.isEmpty()){
            operacionesValidas.add(OpcionMenu.INICIARJUEGO.ordinal());
            
            return operacionesValidas;
        }
        
        estado = modelo.getEstadoJuego();
        switch(modelo.getEstadoJuego()){            
            case JA_ENCARCELADO:
                operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
                operacionesValidas.add(OpcionMenu.OBTENERRANKING.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
            
            case JA_ENCARCELADOCONOPCIONDELIBERTAD:
                operacionesValidas.add(OpcionMenu.INTENTARSALIRCARCELPAGANDOLIBERTAD.ordinal());
                operacionesValidas.add(OpcionMenu.INTENTARSALIRCARCELTIRANDODADO.ordinal());
                operacionesValidas.add(OpcionMenu.OBTENERRANKING.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                
            case JA_PREPARADO:
                operacionesValidas.add(OpcionMenu.JUGAR.ordinal());
                operacionesValidas.add(OpcionMenu.OBTENERRANKING.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                
            case JA_PUEDEGESTIONAR:
                operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
                operacionesValidas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                operacionesValidas.add(OpcionMenu.EDIFICARCASA.ordinal());
                operacionesValidas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                operacionesValidas.add(OpcionMenu.OBTENERRANKING.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                
            case JA_CONSORPRESA:
                operacionesValidas.add(OpcionMenu.APLICARSORPRESA.ordinal());
                operacionesValidas.add(OpcionMenu.OBTENERRANKING.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                
            case JA_PUEDECOMPRAROGESTIONAR:
                operacionesValidas.add(OpcionMenu.PASARTURNO.ordinal());
                operacionesValidas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                operacionesValidas.add(OpcionMenu.EDIFICARCASA.ordinal());
                operacionesValidas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                operacionesValidas.add(OpcionMenu.COMPRARTITULOPROPIEDAD.ordinal());
                operacionesValidas.add(OpcionMenu.OBTENERRANKING.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
                
            case ALGUNJUGADORENBANCARROTA:
                operacionesValidas.add(OpcionMenu.OBTENERRANKING.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
                operacionesValidas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
                operacionesValidas.add(OpcionMenu.TERMINARJUEGO.ordinal());
        }
        
        return operacionesValidas;       
    }
    
    public boolean necesitaElegirCasilla(int opcionMenu){
        boolean necesita_elegir = false;

        if(opcionMenu == OpcionMenu.HIPOTECARPROPIEDAD.ordinal() ||
           opcionMenu == OpcionMenu.VENDERPROPIEDAD.ordinal() ||
           opcionMenu == OpcionMenu.CANCELARHIPOTECA.ordinal() ||
           opcionMenu == OpcionMenu.EDIFICARCASA.ordinal() ||
           opcionMenu == OpcionMenu.EDIFICARHOTEL.ordinal()){
            necesita_elegir = true;
        }
        
        return necesita_elegir;
    }
    
    public ArrayList<Integer> obtenerCasillasValidas(int opcionMenu){
        ArrayList<Integer> casillasValidas = new ArrayList<>();
        
        if(opcionMenu == OpcionMenu.HIPOTECARPROPIEDAD.ordinal()){
            casillasValidas = modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(false);
        }
        
        else if(opcionMenu == OpcionMenu.EDIFICARCASA.ordinal()){
            casillasValidas = modelo.obtenerPropiedadesJugador();
        }
        
        else if(opcionMenu == OpcionMenu.EDIFICARHOTEL.ordinal()){
            casillasValidas = modelo.obtenerPropiedadesJugador();
        }
        
        else if(opcionMenu == OpcionMenu.VENDERPROPIEDAD.ordinal()){
            casillasValidas = modelo.obtenerPropiedadesJugador();
        }
        
        else if(opcionMenu == OpcionMenu.CANCELARHIPOTECA.ordinal()){
            casillasValidas = modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(true);
        }
        
        return casillasValidas;        
    }
    
    public String realizarOperacion(int opcionElegida, int casillaElegida){
        String resultado = null;
        
        switch(opcionElegida){
            case 1: // INICIARJUEGO
                modelo.inicializarJuego(nombreJugadores);
                resultado = "Iniciando juego...";
                break;
            case 2: // JUGAR
                modelo.jugar();
                resultado = "Valor del dado: " + modelo.getValorDado() + ", Casilla actual: " + modelo.obtenerCasillaJugadorActual();
                break;
            case 3: // APLICARSORPRESA                
                modelo.aplicarSorpresa();
                resultado = "La sorpresa es: " + modelo.getCartaActual();
                break;
            case 4: // INTENTARSALIRCARCELPAGANDOLIBERTAD
                metodo = MetodoSalirCarcel.PAGANDOLIBERTAD;
                boolean salido_carta = modelo.intentarSalirCarcel(metodo);
                
                if(salido_carta){
                    resultado = "¡Has conseguido salir de la cárcel!";
                }
                
                else{
                    resultado = "¡Mala suerte! La próxima vez será";
                }
                break;
            case 5: // INTENTARSALIRCARCELTIRANDODADO
                metodo = MetodoSalirCarcel.TIRANDODADO;
                boolean salido_dado = modelo.intentarSalirCarcel(metodo);
                
                if(salido_dado){
                    resultado = "¡Has conseguido salir de la cárcel!";
                }
                
                else{
                    resultado = "¡Mala suerte! La próxima vez será";
                }
                break;
            case 6: // COMPRARTITULOPROPIEDAD
                boolean comprar_titulo = modelo.comprarTituloPropiedad();
                
                if(comprar_titulo){
                    resultado = "Comprando titulo de propiedad de la casilla " + modelo.obtenerCasillaJugadorActual();
                }
                
                else{
                    resultado = "No se ha podido comprar el titulo de la propiedad";
                }
                break;
            case 7: // HIPOTECARPROPIEDAD
                modelo.hipotecarPropiedad(casillaElegida);
                resultado = "Hipotecando la propiedad de la casilla " + modelo.obtenerCasillaJugadorActual();
                break;
            case 8: // CANCELARHIPOTECA
                boolean cancelar_hipoteca = modelo.cancelarHipoteca(casillaElegida);
                
                if(cancelar_hipoteca){
                    resultado = "Cancelando la hipoteca de la propiedad de la casilla " + modelo.obtenerCasillaJugadorActual();
                }
                
                else{
                    resultado = "No se ha podido cancelar la hipoteca...";
                }
                break;
            case 9: // EDIFICARCASA
                boolean edifica_casa = modelo.edificarCasa(casillaElegida);
                
                if(edifica_casa){
                    resultado = "Edificando casa en la casilla " + modelo.obtenerCasillaJugadorActual();
                }
                
                else{
                    resultado = "No se ha podido edificar la casa...";
                }
                break;
            case 10: // EDIFICARHOTEL
                boolean edifica_hotel = modelo.edificarHotel(casillaElegida);
                
                if(edifica_hotel){
                    resultado = "Edificando hotel en la casilla " + modelo.obtenerCasillaJugadorActual();
                }
                
                else{
                    resultado = "No se ha podido edificar el hotel...";
                }
                break;
            case 11: // VENDERPROPIEDAD
                modelo.venderPropiedad(casillaElegida);
                resultado = "Vendiendo la propiedad de la casilla " + modelo.obtenerCasillaJugadorActual();
                break;
            case 12: // PASARTURNO
                modelo.siguienteJugador();
                resultado = "Pasando el turno...";
                break;
            case 13: // OBTENERRANKING
                System.out.println(modelo.getJugadores());
                break;
            case 14: // TERMINARJUEGO
                System.exit(0);
                break;
            case 15: // MOSTRARJUGADORACTUAL
                modelo.getJugadorActual();
                break;
            case 16: // MOSTRARJUGADORES
                modelo.getJugadores();
                break;
            case 17: // MOSTRARTABLERO
                modelo.getTablero();
                break;
            default:
                break;
        }
        
        return resultado;      
    }
}
