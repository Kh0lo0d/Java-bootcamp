import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ArrayList<Animals>animals=new ArrayList<>();
        animals.add(new Cut("Tara", "yuyu",8));
        animals.add(new Cut("ert", "ab",10));
        animals.add(new Elephent("derty","ioioio",15));
        animals.add(new Elephent("suzi","uytr",25));

        for (Animals animal:animals
             ) {
            System.out.println(animal.getName()+" "+animal.getNoise()+" "+animal.getOld());

        }

    }
}