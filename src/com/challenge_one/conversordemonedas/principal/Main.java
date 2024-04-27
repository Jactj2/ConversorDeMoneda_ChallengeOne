package com.challenge_one.conversordemonedas.principal;

import com.challenge_one.conversordemonedas.repository.Exchange;
import com.challenge_one.conversordemonedas.utils.References;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        var separator = "**************************************************";

        while(true){
            System.out.println(separator);
            System.out.println("    Sea bienvenido/a al Conversor de Moneda =]\n ");

            for(var title: References.listTitles){
                System.out.println(title);
            }

            System.out.println(separator);
            System.out.println("    Elija una opción valida");
            var option = keyboard.nextInt();
            if(option == 7){ break; }

            System.out.println(References.listTitles[option-1]);
            System.out.println("    Elija el monto que desea convertir");
            var amount = keyboard.nextFloat();

            String fromCurrency = "USD";
            String toCurrency = "USD";
            switch (option){
                case 1:
                    toCurrency = "ARS";
                    break;
                case 2:
                    fromCurrency = "ARS";
                    break;
                case 3:
                    toCurrency = "BRL";
                    break;
                case 4:
                    fromCurrency = "BRL";
                    break;
                case 5:
                    toCurrency = "COP";
                    break;
                case 6:
                    fromCurrency = "COP";
                    break;
                default:
                    System.out.println("Opción invalida");
                    System.out.println("Elija una opcion valida");
                    break;
            }

            var exchangeConnection = new Exchange();
            exchangeConnection.setResult(References.listFinals[option-1]);
            var result = exchangeConnection.convertCurrency(amount,fromCurrency,toCurrency);
            System.out.println(result);
            

        }
        System.out.println(separator);
        System.out.println("\n  El programa conversor de monedas a finalizado\n");
        System.out.println(separator);

    }
}