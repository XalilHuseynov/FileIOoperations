package HomeTask1;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input= new Scanner(System.in);

        File file = new File("hometask1.txt");
        if(file.createNewFile()){
            System.out.println("File created");
        }else{
            System.out.println("File is already exists");
        }

        new FileWriter("hometask1.txt",false);
//16-ci sətri AI'dan komek almisam , her defe run verende txt'i silmək üçün
        String userChoice;
        do{
            System.out.print("Tapşırıq daxil edin : ");
            userChoice= input.nextLine();
            if(!userChoice.equalsIgnoreCase("exit")){
                try(BufferedWriter bw = new BufferedWriter(new FileWriter("hometask1.txt",true))){
                    bw.write(userChoice);
                    bw.newLine();
                }
            }


        }while(!userChoice.equalsIgnoreCase("exit"));

        System.out.println("Çıxış olundu...\n\nYazilmis melumatlar : ");
        try(BufferedReader br = new BufferedReader(new FileReader("hometask1.txt"))){
            String line;
            while((line= br.readLine())!=null){
                System.out.println(line);
            }
        }


    }
}
