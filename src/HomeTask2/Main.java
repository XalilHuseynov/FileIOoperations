package HomeTask2;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        Scanner input = new Scanner (System.in);

        File contactFile = new File("contacts.txt");
        if(contactFile.createNewFile()){
            System.out.println(contactFile.getName()+" is created");
        }else{
            System.out.println(contactFile.getName()+" is already exists");
        }

        String choice, name , phoneNo;
        int counter =0;
        new FileWriter("contacts.txt",false);
        do {
            System.out.print("Do you want to add contact (yes or no )): ");
            choice=input.nextLine();
            while(!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")){
                System.out.print("Invalid choice . Select again : ");
                choice=input.nextLine();
            }
            if(choice.equalsIgnoreCase("no")){
                break;
            }
            counter++;
            System.out.print("Enter name for №"+counter+" : ");
            name = input.nextLine();
            System.out.print("Enter phone number for №"+counter+" : ");
            phoneNo=input.nextLine();
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("contacts.txt",true))){
                bw.write(name);
                bw.write(",");
                bw.write(phoneNo);
                bw.newLine();
            }
        }while(!choice.equalsIgnoreCase("no"));



        counter=0;
        System.out.println("\nData collecting done...\n\n   ---   All contacts   --- ");
        try(BufferedReader br = new BufferedReader(new FileReader("contacts.txt"))){
            String line;
            while((line = br.readLine())!=null){
                counter++;
                String [] info = line.split(",");
                for (int i = 0; i < info.length ; i++) {
                    if(i%2==0){
                        System.out.print(counter+".Name: "+info[i]+", ");
                    }else{
                        System.out.print("Number: "+info[i]);
                    }
                }
                System.out.println();
            }
        }
    }
}
