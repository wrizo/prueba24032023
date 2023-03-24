package atm.com;

public class DepositosCordobas {
    public double sumarDepositoCordobas (double saldoInicial, double monto) {
        double saldoFinal = 0.0;
        try {
            if (monto > 0.00) {
                saldoFinal = saldoInicial + monto;
            }
        }
        catch(Exception e) {
            System.out.println("Ocurrió un error en el depósito en Córdobas");
        }
        return saldoFinal;
    }
}
