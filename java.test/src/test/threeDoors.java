package test;
public class threeDoors {
    private int N;//定义N来表示进行实验的次数
    public  threeDoors(int N)
    {
        if(N<=0)
        {//检测N是否小于0，若是 抛出非法参数异常
            throw new IllegalArgumentException("N必须大于0");
        }
        //保存传入的N
        this.N=N;
    }
    public void run(boolean changeDoor)
    {
        int wins=0;//用来记录中奖次数
        for(int i=0;i<N;i++)
        {
            //传入是否换门的参数给play（）方法，play（）方法返回在换门/不换门情况下的是否中奖，中奖返回true，没中返回false
            if(play(changeDoor))
            {
                wins++;//若中奖，次数+1
            }
        }
        //输出前提语句
        System.out.println(changeDoor?"换门":"不换门");
        //用中奖的次数除于总次数N得到概论
        System.out.println("中奖的概论是:"+(double)wins/N);
    }
    //定义一个play（）方法，模拟参赛者抽奖过程
    private boolean play(boolean changeDoor)
    {   //1，2，3号门中随机一个为中奖门
        int prizeDoor=(int)(Math.random()*3);
        //1，2，3号门中玩家随机选一个门
        int playerChoice=(int)(Math.random()*3);
        if(prizeDoor==playerChoice)
        {
            //当玩家选的门是有车的门时，换门=输 不换门=赢
            return changeDoor?false:true;
        }
        else {
            //当玩家选的门是无车的门时，换门=赢，不换门=输
            return changeDoor?true:false;
        }
    }
    public static void main(String[] args) {
        //设置N的大小，数值越大，实验结果越准确，这里设置为一百万次
        int N=10000000;
        //创建threeDoors的对象，传入参数N
        threeDoors s=new threeDoors(N);
        s.run(true);
        System.out.println();//换行
        s.run(false);
    }
}

