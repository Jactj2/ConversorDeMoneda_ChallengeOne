package com.challenge_one.conversordemonedas.principal;

import com.challenge_one.conversordemonedas.repository.Exchange;
import com.challenge_one.conversordemonedas.utils.References;

import java.util.Scanner;

import static com.challenge_one.conversordemonedas.utils.References.separatorTitle;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);


        while(true){
            System.out.println(separatorTitle);
            System.out.println("    Sea bienvenido/a al Conversor de Moneda =]\n ");

            for(var title: References.listTitles){
                System.out.println(title);
            }

            System.out.println(separatorTitle);
            var option = 0;
            do {
                System.out.println("    Elija una opción 1 - 7");
                option = keyboard.nextInt();
            } while (option <1 || option > 7);

            if (option == 7) { break;}

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
            }

            var exchangeConnection = new Exchange();
            exchangeConnection.setResult(References.listFinals[option-1].substring(3));
            var result = exchangeConnection.convertCurrency(amount,fromCurrency,toCurrency);

            System.out.println(References.separatorTicket);
            System.out.println(result);
            System.out.println(References.separatorTicket + "\n" );
            

        }
        System.out.println(separatorTitle);
        System.out.println("\n  El programa conversor de monedas a finalizado\n");
        System.out.println(separatorTitle);

    }
}