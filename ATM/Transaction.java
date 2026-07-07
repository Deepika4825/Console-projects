import java.util.ArrayList;
public class Transaction{
    private ArrayList<String> transaction=new ArrayList<>();
    public void receipt(String name,String type,double amount,double balance){
        System.out.println();
        System.out.println("ATM Receipt");
        System.out.println("Account Name:"+name);
        System.out.println("Transaction:"+type);
        System.out.println("Amount:"+amount);
        System.out.println("Balance:"+balance);
        String store=type+" : "+amount+" Balance: "+balance;
        transaction.add(store);
    }
    public void ministatement(){
        System.out.println();
        System.out.println("Mini Statement");
        int size=transaction.size();
        int start=0;
        if(size>5){
            start=size-5;
        }
        for(int i=start;i<size;i++){
            System.out.println(transaction.get(i));
        }
        if(size==0){
            System.out.println("No transaction available");
        }
        System.out.println();
    }
}