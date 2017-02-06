package lab12;


public class Main {

    final static int PROGRAMMS= 10;

    public static void main(String[] args) throws InterruptedException{
    	
        Transfer[] transfers = new Transfer[PROGRAMMS];
        
        for(int i = 0; i < PROGRAMMS; i++){
            transfers[i] = new Transfer();
        }
        
        for(Transfer t: transfers){
        	t.start();
        }
        for(Transfer t: transfers){
        	t.join();
        }
        
        System.out.println(Transfer.sum());
    }
}