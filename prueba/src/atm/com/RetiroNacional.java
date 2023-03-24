package atm.com;

public class RetiroNacional {

    public String consultarSaldo(double saldo, double monto){

        if (saldo>0 && monto<=saldo &&){

            saldo=saldo-monto;

            return "Retiro exitoso, su nuevo saldo es: C$ "+ saldo;
        }
        else{
            return "No hay suficiente saldo para realizar el retiro digitado";
        }
    }
}
