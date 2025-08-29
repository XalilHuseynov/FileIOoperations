package ClassTasks;

import java.io.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        File file = new File("lines.txt");
        if(file.createNewFile()){
            System.out.println(file.getName()+" is created");
        }else{
            System.out.println(file.getName()+" is already exist");
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("lines.txt"))){
            bw.write("Java is fun");
            bw.newLine();
            bw.write("I love programming");
        }
        try {
            FileWriter fw = new FileWriter("lines.txt",true);
            fw.write("\nFile handling is useful");
            fw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        int counter=0;
        try(BufferedReader br = new BufferedReader(new FileReader("lines.txt"))){
            String line ;
            while((line= br.readLine())!=null){
                System.out.println(line);
                counter++;
            }
        }
        System.out.println("Count of lines : "+counter);




        // B part
        File fileAI = new File("chars.txt");
        try(FileWriter fw = new FileWriter("chars.txt")){
            fw.write("OpenAI");
        }

        try(BufferedWriter bw2 = new BufferedWriter(new FileWriter("chars.txt",true))){
            bw2.newLine();
            bw2.write(" is powerful");
        }
        int i=0;
        counter=0;
        try(FileInputStream fis = new FileInputStream("chars.txt")){
            while((i=fis.read()) != -1){
                if((char)(i)!=' '){
                    counter++;
                }
                System.out.print((char)(i));
            }
        }
        System.out.println("\nLength of chars in txt : "+counter);



    }
}
