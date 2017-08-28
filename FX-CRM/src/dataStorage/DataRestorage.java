package dataStorage;

import java.io.*;

/**
 * Created by elad on 23/08/2017.
 */
public class DataRestorage {

    /**
     * dont eork yet
     * @param action
     * @param data
     * @return
     */
    public String getDataFromFile(String action ,String[] data  ){

        if(action.equals("getBandNumber")){
            File generalData = new File("generaldata.txt");

            try{
                if(!generalData.exists()){
                    System.out.println("We had to make a new file.");
                    generalData.createNewFile();
                    FileWriter fileWriter = new FileWriter(generalData, true);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write("BandNumber : 1");
                    return "1";

                }else {

                    FileWriter fileWriter = new FileWriter(generalData, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    FileReader fileReader = new FileReader(generalData);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String s=bufferedReader.readLine();
                   // if(s.su)
                    bufferedWriter.close();

                    System.out.println("Done");
                }
            } catch(IOException e) {
                System.out.println("COULD NOT LOG!!");
            }


        }
        if(action.equals("setNewClientToGroupTraining")){

        }
        return "";
    }
}
