public class AccessModifier {
    public static void main(String args[]){
        BankAccount myAcc = new BankAccount();
        myAcc.username = "Yuvraj Sachdeva"; 
        myAcc.setPass("Yuvii");
        myAcc.updateBalance(1000000000.23);
        System.out.println(myAcc.username);
    }
}
class BankAccount{
    public double balance; // set to public from private
    public String password; // set to public from private
    public String username;
    public void setPass(String pass){
        password = pass;
    }
    public void updateBalance(double bal){
        balance = bal;
    }
}

// Ab public pr set isliye krdia kyuki private pr rkhne se warning aa rhi thi