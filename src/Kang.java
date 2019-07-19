import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Kang {
    private static double[] files = new double[5];
    private String choice;
    private static int chooseFiles =0 ;
    private static boolean isNum(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args){
        for(int i = 0;i < files.length;i++){
            double NumRondom = Math.random() * (100 - 5) + 5;
            files[i] = NumRondom;
        }
        new Kang().menu();
    }

    public void menu(){
        System.out.append("\n");
        System.out.println("*********** Download Manager **********");
        System.out.println("* 1) Show files                       *");
        System.out.println("* 2) Download files                   *");
        System.out.println("* 0) Exit program                     *");
        System.out.println("***************************************");
        System.out.print("Make a selection from the menu: ");
        UserInput();
        int transfer = Integer.parseInt(choice);
        CheckDecision(transfer);
    }

    public void UserInput(){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        while(!isNum(str)) {
            System.out.print("That is an invalid input. Try again: ");
            str = scan.nextLine();
        }
        if (!str.equals("1") && !str.equals("2") && !str.equals("0")){
            System.out.print("That is an invalid input. Try again: ");
            UserInput();
        }
        choice = str;
    }

    public void CheckDecision(int x) {
        if (x == 1) {
            showfiles();
            System.out.println("Task completed! Returning to main menu.");
            menu();
        } else if (x == 2) {
            showfiles();
            Downloadfiles();
        } else {
            System.out.println("Exit program!");
            System.exit(-1);
        }
    }

    public void showfiles(){
            System.out.append("\n");
            System.out.println("*********** Files **********");
            BigDecimal bd = new BigDecimal(files[0]);
            System.out.println("* 1) fileOne.txt " + "["  + bd.setScale(2,BigDecimal.ROUND_DOWN).doubleValue() + " MB]");
            BigDecimal bd1 = new BigDecimal(files[1]);
            System.out.println("* 2) fileTwo.txt " + "["  + bd1.setScale(2,BigDecimal.ROUND_DOWN).doubleValue() + " MB]");
            BigDecimal bd2 = new BigDecimal(files[2]);
            System.out.println("* 3) fileThree.txt " + "["  + bd2.setScale(2,BigDecimal.ROUND_DOWN).doubleValue() + " MB]");
            BigDecimal bd3= new BigDecimal(files[3]);
            System.out.println("* 4) fileFour.txt " + "["  + bd3.setScale(2,BigDecimal.ROUND_DOWN).doubleValue() + " MB]");
            BigDecimal bd4 = new BigDecimal(files[4]);
            System.out.println("* 5) fileFive.txt " + "["  + bd4.setScale(2,BigDecimal.ROUND_DOWN).doubleValue() + " MB]");
            System.out.println("****************************");
            System.out.append("\n");
        }

    public void Downloadfiles(){
        /**
         * Test for Y7000p
         * */
        double speed = Math.random() * (6 - 1) + 1;
        BigDecimal bd = new BigDecimal(speed);
        speed = bd.setScale(2,BigDecimal.ROUND_DOWN).doubleValue();
        System.out.println("Which file would you like to download? ");
        ChooseFiles();
        System.out.append("\n");
        System.out.println("Your download speed has been determined. It is " + speed + " MB/S" );
        System.out.append("\n");
        System.out.println("Starting download!");
        double sum = 0;
        while(sum < files[chooseFiles]){
            sum += speed;
            if(sum >= files[chooseFiles]){
                sum = files[chooseFiles];
            }
            System.out.print("[");
            for(int i =0;i < (sum / files[chooseFiles])* 20; i++){
                System.out.print("=");
            }
            for(int i = 0; i< 20- (sum / files[chooseFiles]) * 20;i++){
                System.out.print(" ");
            }
            System.out.print("] " + (sum / files[chooseFiles]) * 100 + " %" );
            System.out.append("\n");
        }
        System.out.append("\n");
        System.out.println("Task completed! Returning to main menu.");
        menu();
    }

    public void ChooseFiles(){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        while(!isNum(str)) {
            System.out.print("That is an invalid input. Try again: ");
            str = scan.nextLine();
        }
        if (!str.equals("1") && !str.equals("2") && !str.equals("3") && !str.equals("4")&& !str.equals("5")){
            System.out.print("That is an invalid input. Try again: ");
            UserInput();
        }
        chooseFiles = Integer.parseInt(str) - 1;
    }

    }


