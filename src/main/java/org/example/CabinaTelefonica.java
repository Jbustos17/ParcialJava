package org.example;

class CabinaTelefonica {

    private int id;
    private int llamadasLocales;
    private int llamadasLargaDistancia;
    private int llamadasCelular;
    private int minutosLocales;
    private int minutosLargaDistancia;
    private int minutosCelular;
    private static final int tarifaLocal = 50;
    private static final int tarifaLargaDistancia = 350;
    private static final int tarifaCelular = 150;

    public CabinaTelefonica(int id) {
        this.id = id;
        this.llamadasLocales = 0;
        this.llamadasLargaDistancia = 0;
        this.llamadasCelular = 0;
        this.minutosLocales = 0;
        this.minutosLargaDistancia = 0;
        this.minutosCelular = 0;
    }

    public int getId() {
        return id;
    }

    public int getTotalLlamadas() {
        return llamadasLocales + llamadasLargaDistancia + llamadasCelular;
    }

    public int getTotalMinutos() {
        return minutosLocales + minutosLargaDistancia + minutosCelular;
    }

    public void registrarLlamadas(int tipo, int minutos) {
        switch (tipo) {
            case 1:
                llamadasLocales+=1;
                minutosLocales += minutos;
                break;
            case 2:
                llamadasLargaDistancia+=1;
                minutosLargaDistancia += minutos;
                break;
            case 3:
                llamadasCelular+=1;
                minutosCelular += minutos;
                break;
            default:
                System.out.println("LLAMADA INCORRECTA");
        }
    }

    public void mostrarInformacion() {
        System.out.println("Cabina ID: " + id);
        System.out.println("Llamadas Locales: " + llamadasLocales + " Minutos: " + minutosLocales + " Costo: " + (minutosLocales * tarifaLocal));
        System.out.println("Llamadas Larga Distancia: " + llamadasLargaDistancia + " Minutos: " + minutosLargaDistancia + " Costo: " + (minutosLargaDistancia * tarifaLargaDistancia));
        System.out.println("Llamadas Celular: " + llamadasCelular + " Minutos: " + minutosCelular + " Costo: " + (minutosCelular * tarifaCelular));
        System.out.println("Costo Total: " + calcularCostoTotal() + " pesos");
    }

    public int calcularCostoTotal() {
        return (minutosLocales * tarifaLocal) + (minutosLargaDistancia * tarifaLargaDistancia) + (minutosCelular * tarifaCelular);
    }

    public void reiniciarCabina() {
        llamadasLocales = 0;
        llamadasLargaDistancia = 0;
        llamadasCelular = 0;
        minutosLocales = 0;
        minutosLargaDistancia = 0;
        minutosCelular = 0;
        System.out.println("Cabina " + id + " reiniciada");
    }


}