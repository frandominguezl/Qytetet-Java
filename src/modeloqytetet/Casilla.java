package modeloqytetet;

public class Casilla {
    private int numeroCasilla;
    private int coste;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    Casilla(TipoCasilla un_tipo, int numCasilla, TituloPropiedad un_titulo){
        this.numeroCasilla = numCasilla;
        
        if(un_tipo == TipoCasilla.CALLE){
            this.tipo = un_tipo;
            setTitulo(un_titulo);
            coste = titulo.getPrecioCompra();
        }
    }
    
    Casilla(TipoCasilla un_tipo, int numCasilla){
        numeroCasilla = numCasilla;
        
        if(un_tipo != TipoCasilla.CALLE){
            this.tipo = un_tipo;
            coste = 0;
        }
    }
    
    TituloPropiedad asignarPropietario(Jugador jugador){
        this.titulo.setPropietario(jugador);
        
        return titulo;
    }

   int getNumeroCasilla() {
        return this.numeroCasilla;
    }

    int getCoste() {
        return this.coste;
    }

    TipoCasilla getTipo() {
        return this.tipo;
    }

    TituloPropiedad getTitulo() {
        return this.titulo;
    }
    
    double pagarAlquiler(){
        return this.titulo.pagarAlquiler();
    }
    
    private void setTipo(TipoCasilla tipo){
        this.tipo = tipo;
    }

    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }
    
    boolean soyEdificable(){
        return this.tipo == TipoCasilla.CALLE;
    }
    
    boolean tengoPropietario(){
        return titulo.tienePropietario();
    }
    
    boolean propietarioEncarcelado(){
        return titulo.propietarioEncarcelado();
    }
    
    @Override
    public String toString() {
        if(this.tipo == TipoCasilla.CALLE){
            return "Casilla{" + "numeroCasilla:" + numeroCasilla + ", precioCompra:" + coste + ", tipo:" + tipo + ", titulo:" + titulo + '}';
        }
        
        else{
            return "Casilla{" + "numeroCasilla:" + numeroCasilla + ", precioCompra:" + coste + ", tipo:" + tipo + '}';
        }
    }
}
