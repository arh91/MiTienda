public class HiloIngresos extends Thread{

    Caja caja;
    float cantidad;


    HiloIngresos (Caja c, float cant){
        this.caja = c;
        this.cantidad = cant;
    }


    public void run(){
        caja.meterDinero(cantidad);
        }

}
