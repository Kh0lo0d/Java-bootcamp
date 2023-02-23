public class Main {
    public static void main(String[] args) {

Book b=new Book(" what  she saw ",300,"Julia ");
Movie m=new Movie("Like street in earth ",500,"Joni");

System.out.println("The information of book : "+'\n'+
        "The name of book : "+ b.getName()+'\n'+
        "The price of book : "+ b.getPrice()+'\n'+
        "The author of book : "+ b.getAuther());

        b.getDiscount();

        System.out.println("The information of Movie : "+'\n'+
                "The name of book :"+ m.getName()+'\n'+
                "The price of book : "+ m.getPrice()+'\n'+
                "The author of book : "+ m.getDirector());


        m.getDiscount();



    }
}