public class Caja {

    float capital;
    boolean cajaOcupada = false;

    public Caja(float cap) {
        this.capital = cap;
    }

    public synchronized void meterDinero(float cant){
        while(cajaOcupada){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cajaOcupada=true;
        capital = capital+cant;
        System.out.println("Se han ingresado en caja "+cant+" euros");
        System.out.println("El saldo actual en caja es "+ capital);
        cajaOcupada = false;
        notify();

    }

    public synchronized void sacarDinero(float cant){
        while(cajaOcupada){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(capital-cant<0) {
            try {
                System.out.println("Operaci�n abortada: la cantidad que desea retirar es mayor que el saldo disponible en caja.");
                wait();
            }catch(InterruptedException ex){}
        }
        cajaOcupada=true;
        capital = capital-cant;
        System.out.println("Se han extraído de caja "+cant+" euros");
        System.out.println("El saldo actual en caja es "+ capital);
        cajaOcupada = false;
        notify();
    }
}
