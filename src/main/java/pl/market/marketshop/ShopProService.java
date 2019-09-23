package pl.market.marketshop;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("Pro")
public class ShopProService extends ShopPlusService {


    @Value("${rabat}")
    private double rabat;


    @EventListener(ApplicationContextEvent.class)
    @Override
    public void showkoszyk() {
        double suma = 0;


        System.out.println("\n\nJesteś w sklepie " + werShop + "\nW Twoim koszyku są następujące produkty: ");
        towarList.forEach(System.out::println);

        for (int i = 0; i < towarList.size(); i++) {
            suma += towarList.get(i).getCena();
        }
        System.out.println("\nSuma zakupów wynosi: " + suma);
        System.out.println("Vat wynosi: " + suma * vat);
        System.out.println("Brutto wynosi: " + (suma + suma * vat));
        System.out.println("Rabat wynosi: " + rabat * 100 + " %");
        System.out.println("Suma po rabacie wynosi: " + ((suma + (suma * vat)) - (suma + (suma * vat)) * rabat) + "\n\n");
    }


}
