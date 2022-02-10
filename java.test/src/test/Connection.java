package test;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Connection {
    public static void main(String[] args){
        //规则，当生成随机数1，则选择第一扇门，2选择第二扇门，3选择第三扇门
        //同样当生成1，2，3分别代表第一，第二，第三扇门有大奖
        //当猜中时候wintimes++，否则losttimes++
        int winTimes=0;
        int lostTimes=0;
        int rightDoorNum=0;
        int firstChance=0; //下表0，1，2分别代表1，2，3扇门，当值为1的时候锁门
        int opendoor=0;
        int chance=0;
        int scendChance=0;
        Random random=new Random();
        //统计概率
        Scanner scanner=new Scanner(System.in);
        //chance=1坚持选择，否重新作出选择
        System.out.println("如果你坚持之前的选择请输入1，否则请输入0");
        chance=scanner.nextInt();
        //开始游戏
        for(int i=0;i<10000;i++){
            //生成正确的门
            rightDoorNum=random.nextInt(3)+1;
            //挑战者作出选择
            firstChance=random.nextInt(3)+1;
            //主持人开启一扇错误的门,该门不能与挑战者选择的门相同
            while (true){
                opendoor=random.nextInt(3)+1;
                if(opendoor!=firstChance){
                    break;
                }
            }
            //坚持选择
            if(chance==1){
                if(firstChance==rightDoorNum){
                    winTimes++;
                }else{
                    lostTimes++;
                }
            }else{
                //重新选择
                while (true){
                    scendChance=random.nextInt(3)+1;
                    if(scendChance!=opendoor){
                        break;
                    }
                }
                if (scendChance==rightDoorNum){
                    winTimes++;
                }else {
                    lostTimes++;
                }
            }
        }
        System.out.println(winTimes);
        System.out.println(lostTimes);
        if(chance==1){
            System.out.println("坚持选择胜利的概率为："+((double)winTimes/(double)10000));
        }else{
            System.out.println("重新选择胜利的概率为:"+((double)lostTimes/(double)10000));
        }
    }
}
