import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение.");
        String expression = scanner.next();
        String [] Numbers=expression.split("[+\\-/*]");
        if (Numbers.length!=2){
            System.out.println("Неверно введены данные!");
            return;
        }
        int[]arab=new int[2];
        if(isRome(Numbers)) {
           arab=RomeToArabInt(Numbers,arab);
        }
        else {
            arab=arabToInt(Numbers,arab);
        }
        String operacia=Deistvie(expression);
        int result=Podschet(arab,operacia);
        if(isRome(Numbers)){
            if(result<0){
                System.out.println("Римские числа не могут быть отрицательными!");
                return;
            }
            String resultRome=toRome(result);
            System.out.println(resultRome);
            return;
        }
        System.out.println(result);
    }


    public static boolean isRome(String[] Numbers){
        String[]romeNumb={"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};
       for(int i=0;i< Numbers.length;){
            for(int j=0;j<romeNumb.length;j++){
                if (Numbers[i].equals(romeNumb[j])&i==1){
                    return true;
                }
                if (Numbers[i].equals(romeNumb[j])) {
                    i++;
                    j=0;
                }
            }
            return false;
        }
       return false;
    }

    public static int[]RomeToArabInt(String[]Numbers,int[]arab){

        String[]romeNumb={"0","I","II","III","IV","V","VI","VII","VIII","IX","X",};
        for(int i=0;i< Numbers.length;i++){
            for (int j=0;j< romeNumb.length;j++){
                if(Numbers[i].equals(romeNumb[j])){
                    arab[i]=j;
                    break;
                }
            }
        }
        return arab;
    }

    public static int[]arabToInt(String[]Numbers,int[]arab){
        for(int i=0;i< Numbers.length;i++){
            arab[i]=Integer.parseInt(Numbers[i]);
        }
        return arab;
    }

    public  static  String Deistvie(String exp){
        if(exp.contains("+"))
            return "+";
        if(exp.contains("-"))
            return "-";
            if(exp.contains("*"))
                return "*";
                if(exp.contains("/"))
                    return "/";
                else return null;
}

public  static  int Podschet(int[]arab,String a) {
    if (a.equals("+"))
        return arab[0] + arab[1];

    if (a.equals("-"))
        return arab[0] - arab[1];

    if (a.equals("*"))
        return arab[0] * arab[1];
     else
        return arab[0] / arab[1];
}

public static String toRome(int a){
    String[]romeNumb={"0","I","II","III","IV","V","VI","VII","VIII","IX","X",
            "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
            "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
            "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
            "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
            "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
            "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
            "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
            "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
            "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};
      return romeNumb[a];
}
    }
