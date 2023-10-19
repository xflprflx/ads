public class Data {
    private int dia;
    private int mes;
    private int ano;
    
    private static final int MESES_POR_ANO = 12;

    public Data(int dia, int mes, int ano) {
        if (validaData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida. Definindo para 01/01/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (validaData(dia, mes, ano)) {
            this.dia = dia;
        } else {
            System.out.println("Data inválida. Não foi possível alterar o dia.");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (validaData(dia, mes, ano)) {
            this.mes = mes;
        } else {
            System.out.println("Data inválida. Não foi possível alterar o mês.");
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (validaData(dia, mes, ano)) {
            this.ano = ano;
        } else {
            System.out.println("Data inválida. Não foi possível alterar o ano.");
        }
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public boolean verificaAnoBissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;
    }

    private boolean validaData(int dia, int mes, int ano) {
        if (ano >= 0 && mes >= 1 && mes <= MESES_POR_ANO) {
            int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (verificaAnoBissexto() && mes == 2) {
                diasPorMes[2] = 29;
            }
            return dia >= 1 && dia <= diasPorMes[mes];
        }
        return false;
    }
}
