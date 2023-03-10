import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Markt_Project {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> dagen = new ArrayList<>(Arrays.asList(new String[]{"Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag", "Zondag"}));
    static ArrayList<Integer> dagomzet = new ArrayList<>();
    static int wekelijkseOmzet = 0;

    public static void main(String[] args) {
        int dag = 1;

        while (dag <= 7) {
            System.out.print("Vul uw " + dag + ". dagelijkse omzet in : ");
            int omzet = scanner.nextInt();
            dagomzet.add(omzet);
            wekelijkseOmzet += omzet;
            dag++;
        }
        krijgtGemiddeldeOmzet();
        krijgtBovenGemiddeldeOmzetDagen();
        krijgtBenedenGemiddeldeOmzetDagen();
        System.out.println("Gemiddelde omzet is :"+krijgtGemiddeldeOmzet()+" Euro");
        System.out.println("Boven gemiddelde omzet dagen  : "+krijgtBovenGemiddeldeOmzetDagen());
        System.out.println("Beneden gemiddelde omzet dagen : " +krijgtBenedenGemiddeldeOmzetDagen());

    }

    private static String krijgtBenedenGemiddeldeOmzetDagen() {
        String benedenGemiddel = " ";

        for (int i = 0; i < dagomzet.size() ; i++) {
            if(dagomzet.get(i)<krijgtGemiddeldeOmzet()){
                benedenGemiddel+=dagen.get(i)+" ";
            }
        }

        return benedenGemiddel;
    }

    private static String krijgtBovenGemiddeldeOmzetDagen() {

        String bovenGemiddel = " ";
        for (int i = 0; i < dagomzet.size(); i++) {
            if (dagomzet.get(i) > krijgtGemiddeldeOmzet()) {
                bovenGemiddel += dagen.get(i) + " ";
            }
        }return bovenGemiddel;
    }

    private static int krijgtGemiddeldeOmzet() {
        int gemiddel = wekelijkseOmzet / 7;
        return gemiddel;
    }
}
