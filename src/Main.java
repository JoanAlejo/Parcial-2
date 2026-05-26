import menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu mn = new Menu();
        int x=1;//Creamos la variable donde guardaremos si el usuario quiere terminar el programa
        while (x!=0){
            x=mn.mostrarMenu();//el metodo mostrarMenu se ejecuta devuelve un entero que de ser 0 el usuario quiere terminar la ejecucion
        }
    }
}