package menu;
import DAO.MotoDAO;
import Modelado.Moto;
import java.util.List;
import java.util.Scanner;

import DAO.CascoDAO;
import Modelado.Casco;
/* MotoDAO dao = new MotoDAO();

        String tipo = "Naked";

        List<Moto> motos = dao.filtrarPorTipo(tipo);

        System.out.println("Motos tipo " + tipo);

        for (Moto m : motos) {
            System.out.println(m);
        }*/
public class Menu {
    Scanner sc = new Scanner(System.in);
    public int mostrarMenu(){
        MotoDAO motoDAO = new MotoDAO();
        CascoDAO cascoDAO = new CascoDAO();
        System.out.println("--------- DATABASE REALTIME UD ---------\n------ Developed by: Alejo Muñoz -------");
        System.out.println("SELECCIONA UN MODELO:\n1. Moto\n2. Casco");
        int md, op;
        while(true){
            try{ //try catch que depura todo lo que ingrese el usuario para que solo acepte las opciones que hay
                md = sc.nextInt();

                if(md == 1 || md == 2){
                    break;
                }
                else{
                    System.out.println("Digite un numero entre las opciones");
                }
            }
            catch(Exception e){
                System.out.println("Digite un numero entre las opciones");
                sc.nextLine();
            }
        }
        switch (md){
            case 1:
                System.out.println("------------------------\n--------- MOTOS ---------");
                System.out.println("SELECCIONA UNA OPCION:\n1. Añadir registro\n2. Consultar un registro\n3. Consultar" +
                        " todos los registros\n4. Filtrar por tipo\n5. Volver al menu anterior\n6." +
                        " Terminar ejecucion del programa");
                while(true){
                    try{ //try catch que depura todo lo que ingrese el usuario para que solo acepte las opciones que hay
                        op = sc.nextInt();

                        if(op == 1 || op == 2 || op == 3 || op == 4 || op == 5 || op == 6){
                            break;
                        }
                        else{
                            System.out.println("Digite un numero entre las opciones");
                        }
                    }
                    catch(Exception e){
                        System.out.println("Digite un numero entre las opciones");
                        sc.nextLine();
                    }
                }
                switch (op){

                    case 1:
                        sc.nextLine();
                        System.out.println("---- AÑADIR MOTO -------\nMarca:");
                        String marca = sc.nextLine();

                        System.out.println("Modelo:");
                        String modelo = sc.nextLine();

                        System.out.println("Cilindraje:");
                        int cilindraje = sc.nextInt();

                        System.out.println("Precio:");
                        int precio = sc.nextInt();

                        System.out.println("Tipo:");
                        String tipo = sc.next();

                        Moto m = new Moto(
                                marca,
                                modelo,
                                cilindraje,
                                precio,
                                tipo
                        );

                        motoDAO.insertarMoto(m);
                        break;


                    case 3:
                        System.out.println("------ CONSULTAR TODOS LOS REGISTROS -------");
                        for(Moto moto : motoDAO.consultarTodas()){
                            System.out.println(moto);
                        }
                        break;


                    case 2:
                        System.out.println("------ CONSULTAR UN REGISTRO -------");
                        System.out.println("Digite el ID:");

                        int id = sc.nextInt();

                        Moto buscada = motoDAO.consultarUno(id);

                        if(buscada != null){
                            System.out.println(buscada);
                        }
                        else{
                            System.out.println("Moto no encontrada");
                        }
                        break;


                    case 4:
                        System.out.println("------ FILTRO POR TIPO  -------\nLos tipos son:\nNaked\n" +
                                "Deportiva\n" +
                                "Adventure\n" +
                                "Cruiser\n" +
                                "Touring");
                        System.out.println("Digite tipo:");

                        String filtro = sc.next();
                        filtro = filtro.trim();
                        filtro = filtro.substring(0,1).toUpperCase()
                                + filtro.substring(1).toLowerCase();

                        List<Moto> motos = motoDAO.filtrarPorTipo(filtro);

                        if(motos.isEmpty()){
                            System.out.println("No hay motos de ese tipo");
                        }
                        else{
                            for(Moto moto : motos){
                                System.out.println(moto);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Volviendo al menu anterior ...");
                        return 1;

                    case 6:
                        System.out.println("finalizando la ejecucion del programa");
                        return 0;
                }
                break;
            case 2:
                System.out.println("------------------------\n--------- CASCOS ---------");
                System.out.println("SELECCIONA UNA OPCION:\n1. Añadir registro\n2. Consultar un registro\n3. Consultar" +
                        " todos los registros\n4. Filtrar por presupuesto\n5. Volver al menu anterior\n6." +
                        " Terminar ejecucion del programa");
                while(true){
                    try{ //try catch que depura todo lo que ingrese el usuario para que solo acepte las opciones que hay
                        op = sc.nextInt();

                        if(op == 1 || op == 2 || op == 3 || op == 4 || op == 5 || op == 6){
                            break;
                        }
                        else{
                            System.out.println("Digite un numero entre las opciones");
                        }
                    }
                    catch(Exception e){
                        System.out.println("Digite un numero entre las opciones");
                        sc.nextLine();
                    }
                }
                switch (op){

                    case 1:
                        sc.nextLine();
                        System.out.println("---- AÑADIR CASCO -------\nMarca:");
                        String marca = sc.nextLine();

                        System.out.println("Modelo:");
                        String modelo = sc.nextLine();

                        System.out.println("Talla:");
                        String talla = sc.nextLine();

                        System.out.println("Certificacion:");
                        String certificacion = sc.nextLine();

                        System.out.println("Precio:");
                        int precio = sc.nextInt();

                        Casco c = new Casco(
                                marca,
                                modelo,
                                talla,
                                certificacion,
                                precio
                        );

                        cascoDAO.insertarCasco(c);
                        break;


                    case 3:
                        System.out.println("------ CONSULTAR TODOS LOS REGISTROS -------");
                        for(Casco casco : cascoDAO.consultarTodas()){
                            System.out.println(casco);
                        }
                        break;


                    case 2:
                        System.out.println("------ CONSULTAR UN REGISTRO -------");
                        System.out.println("Digite el ID:");

                        int id = sc.nextInt();

                        Casco buscado = cascoDAO.consultarUno(id);

                        if(buscado != null){
                            System.out.println(buscado);
                        }
                        else{
                            System.out.println("Casco no encontrado");
                        }
                        break;


                    case 4:
                        System.out.println("------ FILTRO POR PRESUPUESTO -------");
                        System.out.println("Digite su presupuesto maximo:");

                        int presupuesto = sc.nextInt();

                        List<Casco> cascos = cascoDAO.filtrarPorPresupuesto(presupuesto);

                        if(cascos.isEmpty()){
                            System.out.println("No hay cascos por ese presupuesto");
                        }
                        else{
                            for(Casco casco : cascos){
                                System.out.println(casco);
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Volviendo al menu anterior ...");
                        return 1;

                    case 6:
                        System.out.println("finalizando la ejecucion del programa");
                        return 0;
                }
                break;
        }

        return 1;
    }
}
