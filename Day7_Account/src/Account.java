public class Account
{
  private String id;
  private String name;
  private int balance;


    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        if(amount<=balance && amount>=50)
        {
            System.out.println("credit don and is : "+amount);
            System.out.println("your balance after cradit :"+(balance-amount));
                    return balance-amount;}
        else{
            System.out.println("you can not credit : ");
            System.out.println("your blance="+balance);
           return balance;}


    }

    public int debit(int amount) {
        if(amount<=12000){
            System.out.println("your blance after debit :"+(balance+amount));
            return balance+amount;}
        else
        {System.out.println("you can not  debit !");
            System.out.println("your blance :"+balance);
        return balance;}

    }

    public int TranseferTo(Account ob,int amount)
    {

      if(amount<=balance){
       System.out.println(" The IPan off account :" + ob.getId());
       System.out.println("The name of account :"+ob.getName());
       System.out.println(" the amount you want to transfer :"+amount);
       System.out.println("your balance after transfer to another account : "+(balance-amount));
       return balance-amount;}

      else {
          System.out.println("You can not transfer to another account");
          return balance;
      }



    }
public String toString(){
       String str=" ID: "+getId()+'\n' +"Name:"+getName()+'\n'+"Balance :"+getBalance()+'\n';
       return str;

}
}




