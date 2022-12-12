public class Principal {

    public static void main(String[] args){
        float cantidad;
        Caja caja = new Caja(500);

        HiloIngresos[] ingresos = new HiloIngresos[10];
        HiloGastos[] gastos = new HiloGastos[5];
        Thread[] ing = new Thread[10];
        Thread[] ext = new Thread[5];

        for(int i=0; i<10; i++){
            cantidad = (float) (Math.random()*1000);
            ingresos[i] = new HiloIngresos(caja, cantidad);
            ing[i] = new Thread(ingresos[i]);
            ing[i].start();
        }

        for(int i=0; i<5; i++){
            cantidad = (float) (Math.random()*1000);
            gastos[i] = new HiloGastos(caja, cantidad);
            ext[i] = new Thread(gastos[i]);
            ext[i].start();
        }
    }
}
