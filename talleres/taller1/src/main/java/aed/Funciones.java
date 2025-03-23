package aed;

class Funciones {
    int cuadrado(int x) {
        // COMPLETAR
        x = x*x ;
        return x;
    }

    double distancia(double x, double y) {
        double res = 0.0 ;
        res = Math.sqrt(x*x + y*y);
        return res;
    }

    boolean esPar(int n) {
        // COMPLETAR
        return (n % 2 == 0);
    }

    boolean esBisiesto(int n) {
        boolean res = false ;
        if ( (n%4==0 && n%100!=0 ) || (n%400==0) ){
            res = true;
        }
        return res;
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 1; i<=n ; i++ ) {
            res = res*i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n>1) {
            res = n * factorialRecursivo(n-1);
        }
        return res;
    }

    boolean esPrimo(int n) {
        int divisores = 0;
        for (int i = 1 ; i<=n ; i++){
            if (n%i==0){
                divisores = divisores + 1;
            }
        }
        return (divisores==2);
    }

    int sumatoria(int[] numeros) {
        int suma = 0;
        for (int numero : numeros){
            suma = numero + suma;
        }
        return suma;
    }

    int busqueda(int[] numeros, int buscado) {
        int indice = 0;
        for (int i = 0 ; i<numeros.length ; i++ ){
            if (numeros[i] == buscado) {
                indice = i;
            }
        } 
        return indice;
    }

    boolean tienePrimo(int[] numeros) {
        for (int numero : numeros){
            if (esPrimo(numero)) {
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int numero : numeros) {
            if (! esPar(numero)){
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        } else {
            for (int i = 0 ; i<s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }   
            }
        }        
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        } else {
            int j = 1;
            for (int i = s1.length()-1 ; i>=0; i--) {
                if (s1.charAt(i) != s2.charAt(s2.length()-j)) {
                    return false;
                }
                j++;   
            }
        }        
        return true;
     
    }
}
