import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){

        Restaurant restaurant = new Restaurant();

        try{
            BufferedReader bufferReader = new BufferedReader(new FileReader(args[0]));
            String command;
            String state = "";
            while ((command = bufferReader.readLine()) != null){
                List<String> tokens = new ArrayList<>(Arrays.asList(command.split(" ")));

                switch (tokens.get(0)){
                    case "Diner":{
                        state = tokens.get(0);
                        break;
                    }
                    case "SubMenu":{
                        state = tokens.get(0);
                        restaurant.addLunchSubMenu();
                        break;
                    }
                    case "PancakeHouse":{
                        state = tokens.get(0);
                        break;
                    }
                    default:{
                        String value = tokens.get(0);
                        Item item = new Item(value);


                        if (state.equals("Diner"))
                            restaurant.addLunchMenuItem(item);
                        else if (state.equals("SubMenu"))
                            restaurant.addSubMenuItem(item);
                        else
                            restaurant.addBreakfastMenuItem(item);

                        break;
                    }
                }
            }
            restaurant.print();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

