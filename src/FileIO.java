import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    // Tilføj metoden String[] readData(String path, int length) -  path er stien til filen der skal loades og length er antallet af linjer i filen
    public String[] readData(String path, int length) {

        // start metoden med at initialisere et String[] data med det antal pladser som er angivet i parameterlisten (length)
        String [] data = new String[length];


        //todo:
        // - Lav en instans af File til at loade den fil der er angivet i path.
        // -  Lige efter instantiering af File, tilføj en tom try-catch blok som fanger FileNotFoundException
       //  Brug Scanner klassen i kombination med et loop for at læse hver enkelt linje i filen.
        // For hver iteration I loop’et skal linjen lægges ind i data.
       //         Dette kræver at du initialiserer en counter udenfor loop’et, som tælles op med 1 inde i loopet)
        // returner data som lige er blevet fyldt op

        return data;
    }

    public ArrayList<String> readData(String path){
        File file = new File(path);
        ArrayList<String> data = new ArrayList<>(); //"Tess, 0", "Lina, 0", "Signe, 0"
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header
            while(scan.hasNextLine()){

                String s = scan.nextLine();// "Egon , 20000"
                data.add(s);

            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("der findes kun 2 værdier pr. række");
        }
      return data;
    }

    public void saveData(ArrayList<String> data, String path, String header){
           File file = new File(path);
           try {
               FileWriter writer = new FileWriter(file);
               writer.write(header+"\n");
               for(String s: data){
                   writer.write(s+"\n");
               }
               writer.close();
           }catch (IOException e){

               System.out.println("filen blev ikke fundet");
           }



    }

}
