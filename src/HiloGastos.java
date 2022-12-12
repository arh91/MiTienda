public class HiloGastos extends Thread{

    float cantidad;
    Caja caja;
    float saldoActual;


    HiloGastos (Caja c, float cant){
        this.cantidad = cant;
        this.caja = c;
    }


    public void run(){
        caja.sacarDinero(cantidad);
    }
}
