package ClassTasks;

import java.io.*;

public class Task1 {
    public static void main(String[] args) throws IOException {

        File file = new File("task1.txt");
        if(file.createNewFile()){
            System.out.println("File created "+file.getName());
        }else{
            System.out.println(file.getName()+" is alraeady exist");
        }
        int i=0;
        String data = "Hello java";
        try(FileOutputStream fos = new FileOutputStream("task1.txt")){
            fos.write(data.getBytes());
            System.out.println("Data is written");
        }
        try (FileInputStream fis = new FileInputStream("task1.txt")){
                while((i = fis.read())!=-1 ){
                    System.out.print((char)(i));
            }
        }

        System.out.println();
        File file2 = new File("task2.txt");
        if(file2.createNewFile()){
            System.out.println("File created "+file2.getName());
        }else{
            System.out.println(file2.getName()+" is already exist");
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("task2.txt"))){
            bw.write("My name is Khalil");
            bw.newLine();
            bw.write("I am learning java");
            bw.newLine();
            bw.write("I love music");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("task2.txt"))){
            String line;
            while((line= br.readLine())!=null){
                System.out.println(line);
            }
        }




    }
}
