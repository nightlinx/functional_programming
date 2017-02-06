package lab12;

import java.util.concurrent.Semaphore;

class Account {
    final static int START = 100;

    public void transferMoneyTo(int amount){
    	money+=amount;
    }
    
    public void transferMoneyFrom(int amount){
    	money-=amount;
    }
       
    public void setMoney(int money) {
        this.money = money;
    }
    
    public int getMoney() {
        return money;
    }

    private int money = START;
    public Semaphore semaphore = new Semaphore(1,true);
}