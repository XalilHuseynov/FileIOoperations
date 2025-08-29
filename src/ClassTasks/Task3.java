package ClassTasks;

import java.io.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        File fileStudents = new File("students.txt");
        try{
            if(fileStudents.createNewFile()){
                System.out.println(fileStudents.getName()+" is created");
            }else{
                System.out.println(fileStudents.getName()+" is already exists");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        double averageScore=0;
        int counter=0;
        try(BufferedReader br = new BufferedReader(new FileReader("students.txt"))){
            String line;
            while((line= br.readLine())!=null){
                String[] names = line.split(",");
                for(int i=0;i< names.length;i++){
                    if(i%2==1){
                        System.out.println(names[i]);
                        averageScore+= Integer.parseInt(names[i]);
                        counter++;
                    }
                }
            }
            averageScore/=counter;
        }
        System.out.println(averageScore);

        File resultFile = new File("results.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("results.txt"))){
            bw.write("Average score : "+averageScore);
        }



    }
}
