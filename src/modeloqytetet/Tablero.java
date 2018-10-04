package modeloqytetet;
import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> casillas;
    private Casilla carcel;
    private int NUM_CASILLAS;

    public Tablero() {
        inicializar();
    }
    
    boolean esCasillaCarcel(int numeroCasilla){
        
    }

    ArrayList getCasillas() {
        return casillas;
    }

    Casilla getCarcel() {
        return carcel;
    }

    @Override
    public String toString() {
        return "Tablero{" + "Casillas:" + casillas + "Carcel:" + carcel + '}';
    }
    
    private void inicializar(){
        casillas = new ArrayList<>();
        ArrayList<TituloPropiedad> titulos = new ArrayList<>();
        int contador = 0;
        
        // Creamos primeros todos los titulos de propiedad para las casillas de tipo CALLE
        titulos.add(new TituloPropiedad("Calle Willyrex", 625, 75, 12, 350, 400));
        titulos.add(new TituloPropiedad("Calle Guerrero", 700, 50, 10, 550, 250));
        titulos.add(new TituloPropiedad("Calle Cabronazi", 550, 80, 15, 600, 750));
        titulos.add(new TituloPropiedad("Calle Giorgio", 890, 65, 13, 1000, 300));
        titulos.add(new TituloPropiedad("Calle Picaporte", 740, 55, 19, 300, 575));
        titulos.add(new TituloPropiedad("Calle Potter", 675, 60, 20, 475, 750));
        titulos.add(new TituloPropiedad("Calle Petunia", 925, 90, 17, 875, 600));
        titulos.add(new TituloPropiedad("Calle Motorola", 777, 85, 15, 750, 470));
        titulos.add(new TituloPropiedad("Calle Focus", 830, 100, 16, 675, 500));
        titulos.add(new TituloPropiedad("Calle Rengar", 900, 80, 12, 200, 450));
        titulos.add(new TituloPropiedad("Calle Jesucristo", 1000, 60, 11, 250, 325));
        titulos.add(new TituloPropiedad("Calle Ruby", 500, 95, 14, 175, 275));
        
        // Creamos ahora el resto de casillas
        casillas.add(new Casilla(TipoCasilla.SALIDA, 0));
        casillas.add(new Casilla(TipoCasilla.CALLE, 1, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.SORPRESA, 2));
        casillas.add(new Casilla(TipoCasilla.CALLE, 3, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.JUEZ, 4));
        casillas.add(new Casilla(TipoCasilla.CALLE, 5, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.PARKING, 6));
        casillas.add(new Casilla(TipoCasilla.CALLE, 7, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.SORPRESA, 8));
        casillas.add(new Casilla(TipoCasilla.CALLE, 9, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.CALLE, 10, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.CALLE, 11, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.IMPUESTO, 12));
        casillas.add(new Casilla(TipoCasilla.CALLE, 13, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.CARCEL, 14));
        this.carcel = this.casillas.get(14);
        casillas.add(new Casilla(TipoCasilla.CALLE, 15, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.SORPRESA, 16));
        casillas.add(new Casilla(TipoCasilla.CALLE, 17, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.CALLE, 18, titulos.get(contador++)));
        casillas.add(new Casilla(TipoCasilla.CALLE, 19, titulos.get(contador++)));
        
    }
    
    Casilla obtenerCasillaFinal(Casilla casilla, int desplazamiento){
        
    }
    
    Casilla obtenerCasillaNumero(int numeroCasilla=casillaFinal){
        
    }
    
}
