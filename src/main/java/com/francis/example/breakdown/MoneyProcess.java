package com.francis.example.breakdown;

public class MoneyProcess {
    private int thousand =0;
    private int fiveHundred =0;
    private int twoHundred=0;
    private int oneHundred=0;
    private int fifty=0;
    private int twenty=0;
    private int ten=0;
    private int five=0;
    private int one=0;
    private int money;

    public MoneyProcess() {

    }

    public void breakdown(int money){
        if(money/1000>0){
            thousand = money/1000;
            money%=1000;
        }
        if(money/500>0){
            fiveHundred = money/500;
            money%=500;
        }
        if(money/200>0){
            twoHundred = money/200;
            money%=200;
        }
        if(money/100>0){
            oneHundred = money/100;
            money%=100;
        }if(money/50>0){
            fifty = money/50;
            money%=50;
        }if(money/20>0){
            twenty = money/20;
            money%=20;
        }if(money/10>0){
            ten = money/10;
            money%=10;
        }
        if(money/5>0){
            five = money/5;
            money%=5;
        }
        if(money/1>0){
            one = money/1;
        }

        System.out.println(thousand + " one thousand\n"
                + fiveHundred + " five hundred\n"
                + twoHundred + " two hundred\n"
                + oneHundred + " one hundred\n"
                + fifty + " fifty\n"
                + twenty + " twenty\n"
                +ten + " ten\n"
                + five + " five\n"
                + one  + " one");
    }

    public int getThousand() {
        return thousand;
    }

    public int getFiveHundred() {
        return fiveHundred;
    }

    public int getTwoHundred() {
        return twoHundred;
    }

    public int getOneHundred() {
        return oneHundred;
    }

    public int getFifty() {
        return fifty;
    }

    public int getTwenty() {
        return twenty;
    }

    public int getTen() {
        return ten;
    }

    public int getFive() {
        return five;
    }

    public int getOne() {
        return one;
    }

    public int getMoney() {
        return money;
    }
}
