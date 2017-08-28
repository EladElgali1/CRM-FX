package dataStorage;

import java.io.*;

import org.json.simple.JSONObject;

/**
 * Created by elad on 21/08/2017.
 */
public class DataStorage {


   public boolean dataToFile(String action ,String[] data  ){

       if(action.equals("setNewClietToPersonalTraining")){
           File clientFile = new File("clientFile.txt");
           //File dataFile = new File("dataFile.txt");


           try{
               /*
               //writer fot data
               FileWriter fileWriterForData = new FileWriter(dataFile, true);
               BufferedWriter bufferedWriterForData = new BufferedWriter(fileWriterForData);
*/
               //writer for client
               FileWriter fileWriter = new FileWriter(clientFile, true);
               BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

               //check if there is a file for client
               if(!clientFile.exists()){
                   System.out.println("We had to make a new file for client.");
                   clientFile.createNewFile();
               }


               for(int i =0;i<data.length;i++){
                   bufferedWriter.write(data[i]+ "\n");
               }
               //bufferedWriterForData.close();
               //create reader for data
              /* FileReader fileReaderForData = new FileReader(dataFile);
               BufferedReader bufferedReaderForData = new BufferedReader(fileReaderForData);


               String s=bufferedReaderForData.readLine();

               while(s!=null){
                   System.out.println(s);
                   if(s.equals("BandNumber")){
                       //s=bufferedReaderForData.readLine();
                       System.out.println(s);
                     break;
                   }
                   s=bufferedReaderForData.readLine();
                   System.out.println(s);
               }
               int bandNumber=0;
               System.out.println(s);

               try {
                   bandNumber =Integer.parseInt(s);
               }catch (Exception e){
                   e.printStackTrace();
               }
               bufferedReaderForData.close();
               //writer fot data
                fileWriterForData = new FileWriter(dataFile, true);
                bufferedWriterForData = new BufferedWriter(fileWriterForData);

               bufferedWriterForData.write((String.valueOf(bandNumber+1)));
*/
               bufferedWriter.close();
              // bufferedWriterForData.close();
              JSONObject jsonObject= getDataAsAJasonObj();
              int num = (int) jsonObject.get("BandNumber");
              jsonObject.put("BandNumber",num+1);
              setDataToFile(jsonObject);
              System.out.println("Done");
           } catch(IOException e) {
               System.out.println("COULD NOT LOG!!");
           }
           return true;

       }
       if(action.equals("setNewClientToGroupTraining")){

       }
       return false;
    }

    private void setDataToFile(JSONObject jsonObject) {
        System.out.println("you need to finish this function: setDataToFile");
        System.out.println("*****************");
        System.out.println("*****************");
        System.out.println("*****************");
        System.out.println("*****************");
        System.out.println("you need to finish this function: setDataToFile");
    }


    public JSONObject  getDataAsAJasonObj(){
        JSONObject obj;
        obj = new JSONObject();
        File dataFile = new File("dataFile.txt");

        try {
            FileWriter fileWriterForData = new FileWriter(dataFile, true);
            BufferedWriter bufferedWriterForData = new BufferedWriter(fileWriterForData);
            //check if there is a file for general data
            if(!dataFile.exists()){
                System.out.println("We had to make a new file for data.");
                dataFile.createNewFile();
                obj.put("BandNumber",0);
                System.out.println(obj.toJSONString()+"\n");
                System.out.println(obj.toString());
                bufferedWriterForData.write(obj.toString());
               // bufferedWriterForData.close();
                //return obj;

            }
            /*
            Writer writer = new BufferedWriter(fileWriterForData);
            obj.writeJSONString(writer);
            System.out.println(obj.toJSONString());
            */


            /*
            FileReader fileReader = new FileReader(dataFile);
            BufferedReader bufferedReader= new BufferedReader(fileReader);
            */

            obj.put("BandNumber",0);
            bufferedWriterForData.write(obj.toJSONString());
            bufferedWriterForData.close();
        } catch (IOException e){
            e.printStackTrace();
        }


        return obj;
    }


}
