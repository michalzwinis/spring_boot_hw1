package pl.market.marketshop;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.round;

@Service
@Profile("Start")
public class ShopStatrService {

    @Value("${spring.profiles.active}")
    String werShop;

    public List<Towar> towarList;

    public ShopStatrService() {
        Random liczba = new Random();

        Towar towar1 = new Towar("Mleko", liczba.nextDouble() * (300 - 50) + 50);
        Towar towar2 = new Towar("Mąka", liczba.nextDouble() * (300 - 50) + 50);
        Towar towar3 = new Towar("Jajka", liczba.nextDouble() * (300 - 50) + 50);
        Towar towar4 = new Towar("Sok", liczba.nextDouble() * (300 - 50) + 50);
        Towar towar5 = new Towar("Chleb", liczba.nextDouble() * (300 - 50) + 50);

        towarList = new ArrayList<>();
        towarList.add(towar1);
        towarList.add(towar2);
        towarList.add(towar3);
        towarList.add(towar4);
        towarList.add(towar5);

    }

    @EventListener(ApplicationContextEvent.class)
    public void showkoszyk() {
        double suma = 0;
        System.out.println("\n\nJesteś w sklepie " + werShop + "\nW Twoim koszyku są następujące produkty: ");
        towarList.forEach(System.out::println);

        for (int i = 0; i < towarList.size(); i++) {
            suma += towarList.get(i).getCena();
        }
        System.out.println("\nSuma zakupów wynosi: " + suma+ "\n\n");
    }


}






