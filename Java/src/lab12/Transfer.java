package lab12;

class Transfer extends Thread{

    final static int NUMBER_OF_ACC = 100;
    final static int NUMBER_OF_TRANS = 10000;
    final static int AMOUNT = 1;

    static Account[] accounts = new Account[NUMBER_OF_ACC];

    static{
        for(int i = 0; i < NUMBER_OF_ACC; i++){
        	accounts[i] = new Account();
        }
    }

    public static int sum(){
        int res = 0;
        for (Account a: accounts) {
            res+=a.getMoney();
        }
        return res;
    }


    @Override public void run(){
        for(int i = 0; i < NUMBER_OF_TRANS; i++ ){
            int k1 = (int) (Math.random() * (NUMBER_OF_ACC));
            int k2 = (int) (Math.random() * (NUMBER_OF_ACC));
            Account a1 = accounts[k1];
            Account a2 = accounts[k2];
            
            try{
                a1.semaphore.acquire();
                a1.transferMoneyFrom(AMOUNT);
                a1.semaphore.release();

                a2.semaphore.acquire();
                a2.transferMoneyTo(AMOUNT);
                a2.semaphore.release();
            }
            catch(InterruptedException e){}
         }    
    }
        
}
