package atm.com;

public class OperacionesDolares {
    public String Retiro(double Saldo,double cantidadRetiro){
        try {
            if(cantidadRetiro>Saldo){
                return "La cantidad a retirar es mayor que la cantidad que posees de saldo";
            } else {
                double saldoRetiro = Saldo-cantidadRetiro;
                return "Su saldo anterior:"+Saldo+
                        "\n Su saldo actual: "+saldoRetiro+
                        "\n Favor retire la cantidad de: \n"+cantidadRetiro+ "dolares de la bandeja";
            }
        }
        catch(Exception e) {
            return e.getMessage();
        }
    }
    public String Deposito(double Saldo,double cantidadDeposito){
        try {
            double saldoDeposito = Saldo+cantidadDeposito;
            if (saldoDeposito<0){
                return "Tiene un sobregiro bancario de: "+saldoDeposito;
            }
            else {
                return "Su saldo anterior: "+Saldo+
                        "\n Su saldo actual: "+saldoDeposito+
                        "\n Muchas gracias por realizar el deposito de: "+cantidadDeposito+ "dolares";
            }
        }
        catch(Exception e) {
            return e.getMessage();
        }
    }
}