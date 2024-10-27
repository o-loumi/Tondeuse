package Mower;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class MowerPosition {
    public static void main(String[] args) {
        String filePath = "input.txt"; 
        List<Mower> mowers = new ArrayList<>();
        int maxX = 0, maxY = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Lire les dimensions de la pelouse
            String[] dimensions = br.readLine().split(" ");
            maxX = Integer.parseInt(dimensions[0]);
            maxY = Integer.parseInt(dimensions[1]);

            String line;
            while ((line = br.readLine()) != null) {
                String[] mowerInfo = line.split(" ");
                int startX = Integer.parseInt(mowerInfo[0]);
                int startY = Integer.parseInt(mowerInfo[1]);
                char startDirection = mowerInfo[2].charAt(0);

                // Créer une tondeuse
                Mower mower = new Mower(startX, startY, startDirection, maxX, maxY);
                
                // Lire les instructions de mouvement dans la ligne suivante
                if ((line = br.readLine()) != null) {
                    String instructions = line.trim(); // Récupérer la ligne d'instructions
                    mower.executeInstructions(instructions);
                }
                
                mowers.add(mower);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Afficher la position finale des tondeuses
        for (Mower mower : mowers) {
            System.out.println(mower);
        }
    }
}
