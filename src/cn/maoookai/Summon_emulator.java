package cn.maoookai;
import java.io.*;
import java.util.Random;

import com.sobte.cqp.jcq.entity.Anonymous;
import com.sobte.cqp.jcq.entity.CQDebug;
import com.sobte.cqp.jcq.entity.GroupFile;
import com.sobte.cqp.jcq.entity.ICQVer;
import com.sobte.cqp.jcq.entity.IMsg;
import com.sobte.cqp.jcq.entity.IRequest;
import com.sobte.cqp.jcq.event.JcqAppAbstract;


public class Summon_emulator extends JcqAppAbstract implements ICQVer, IMsg, IRequest {

    public static String[] SP ={"少羽大天狗","炼狱茨木童子","稻荷神御馔津","苍风一目连","赤影妖刀姬","御怨般若","骁浪荒川之主","烬天玉藻前","鬼王酒吞童子","天剑韧心鬼切","聆海金鱼姬","浮世青行灯"};
    public static String[] SSR ={"大天狗","酒吞童子","荒川之主","阎魔","小鹿男","茨木童子","青行灯","妖刀姬","一目连","花鸟卷","辉夜姬","荒","彼岸花","雪童子","山风","玉藻前","御馔津","面灵气","鬼切","白藏主","八岐大蛇","不知火","大岳丸","泷夜叉姬","云外镜","鬼童丸","缘结神"};
    public static String[] SR ={"桃花妖","雪女","鬼使白","鬼使黑","孟婆","犬神","骨女","鬼女红叶","跳跳哥哥","傀儡师","海坊主","判官","凤凰火","吸血姬","妖狐","妖琴师","食梦貘","清姬","镰鼬","姑获鸟","二口女","白狼","樱花妖","惠比寿","络新妇","般若","青坊主","夜叉","黑童子","白童子","烟烟罗","金鱼姬","鸩","以津真天","匣中少女","书翁","百目鬼","追月神","熏","弈","猫掌柜","於菊虫","一反木绵","入殓师","化鲸","久次良","蟹姬","纸舞","星熊童子"};
    public static String[] R ={"三尾狐","座敷童子","鲤鱼精","九命猫","狸猫","河童","童男","童女","饿鬼","巫蛊师","鸦天狗","食发鬼","武士之灵","雨女","跳跳弟弟","跳跳妹妹","兵俑","丑时之女","独眼小僧","铁鼠","椒图","管狐","山兔","萤草","山童","首无","觉","青蛙瓷器","古笼火","虫师"};
    public static String[] six_stars = {"刻俄柏","阿","煌","莫斯提马","麦哲伦","赫拉格","黑","陈","斯卡蒂","银灰","塞雷娅","星熊","夜莺","闪灵","安洁莉娜","艾雅法拉","伊芙利特","推进之王","能天使"};
    public static String[] five_stars = {"惊蛰","吽","灰猴","布洛卡","苇草","槐琥","送葬人","星极","格劳克斯","诗怀雅","夜魔","食铁兽","狮蝎","空","真理","初雪","崖心","守林人","普罗旺斯","可颂","雷蛇","红","临光","华法琳","赫默","梅尔","天火","阿米娅","陨星","白金","蓝毒","幽灵鲨","拉普兰德","芙兰卡","德克萨斯","凛冬","白面鸮"};
    public static String[] four_stars = {"安比尔","梅","红云","坚雷","桃金娘","苏苏洛","格雷伊","猎蜂","阿消","地灵","深海色","谷米","蛇屠箱","角峰","调香师","末药","暗索","砾","慕斯","艾丝黛尔","霜叶","缠丸","杜宾","红豆","清道夫","讯使","白雪","流星","杰西卡","远山","夜烟"};
    public static String[] three_stars = {"斑点","泡普卡","月见夜","空爆","梓兰","史都华德","安塞尔","芙蓉","炎熔","安德切尔","克洛丝","米格鲁","卡缇","玫兰莎","翎羽","香草","芬"};
    public static String helpMessage = "一个小动物聊天机器人，抽卡仅供娱乐，发送十连或者单抽即可抽卡！更多描述待补充...";

    static int Counter(int total) {
            Random random = new Random();
            return random.nextInt(total);
        }


        static String SSRPicker(){
            int result = Counter(SSR.length);
            return (SSR[result]);
        }

        static String SPPicker(){
            int result = Counter(SP.length);
            return (SP[result]);
        }

        static String SRPicker(){
            int result = Counter(SR.length);
            return (SR[result]);
        }

        static String RPicker(){
            int result = Counter(R.length);
            return (R[result]);
        }


        static String Six_Stars_Picker(){
            int result = Counter(six_stars.length);
            return ("★★★★★★"+'\t'+six_stars[result]);
        }

        static String Five_Stars_Picker(){
            int result = Counter(five_stars.length);
            return ("★★★★★"+'\t'+five_stars[result]);
        }

        static String Four_Stars_Picker(){
            int result = Counter(four_stars.length);
            return ("★★★★"+'\t'+four_stars[result]);
         }

        static String Three_Stars_Picker(){
            int result = Counter(three_stars.length);
            return ("★★★"+'\t'+three_stars[result]);
        }

                       /*抽卡部分*/
        static String OneShot() throws IOException {
            Random gotCard = new Random();
            String oneResult;
            int result = gotCard.nextInt(1000);
            if (result < 787)
                oneResult = "R"+'\t'+RPicker();
            else if (result < 987)
                oneResult = "SR"+'\t'+SRPicker();
            else if (result < 997)
                oneResult = "SSR"+'\t'+SSRPicker();
            else
                oneResult = "SP"+'\t'+SPPicker();
            return oneResult;
        }

    static String OneShot2x() throws IOException {
        Random gotCard = new Random();
        String oneResult;
        int result = gotCard.nextInt(1000);
        if (result < 762)
            oneResult = RPicker();
        else if (result < 962)
            oneResult = SRPicker();
        else if (result < 987)
            oneResult = SSRPicker();
        else
            oneResult = SPPicker();
        return oneResult;
    }

    static String OneShot_Arknights() throws IOException {
        Random gotCard = new Random();
        String oneResult;
        int result = gotCard.nextInt(1000);
        if (result < 420)
            oneResult = Three_Stars_Picker();
        else if (result < 900)
            oneResult = Four_Stars_Picker();
        else if (result < 980)
            oneResult = Five_Stars_Picker();
        else
            oneResult = Six_Stars_Picker();
        return oneResult;
    }

    static String OneShot_HowManyTimes(){
        Random gotCard = new Random();
        String oneResult;
        int result = gotCard.nextInt(1000);
        if (result < 787)
            oneResult = RPicker();
        else if (result < 987)
            oneResult = SRPicker();
        else if (result < 997)
            oneResult = SSRPicker();
        else
            oneResult = SPPicker();
        return oneResult;
    }


    public static void main(String[] args) throws IOException{
        CQ = new CQDebug();
        CQ.logInfo("[JCQ] TEST Demo", "测试启动");
        Summon_emulator yys = new Summon_emulator();
        yys.startup();// 程序运行开始 调用应用初始化方法
        yys.enable();// 程序初始化完成后，启用应用，让应用正常工作
        //yys.groupMsg(0,10001,123456,1225455,"","我要抽浮世青行灯",0);
        //System.out.println(OneShot());
        yys.exit();// 最后程序运行结束，调用exit方法
    }

    public String appInfo() {
        String AppID = "cn.maoookai.summon_emulator";
        return CQAPIVER + "," + AppID;
    }

    public int startup() {
        // 获取应用数据目录(无需储存数据时，请将此行注释)
        String appDirectory = CQ.getAppDirectory();
        // 返回如：D:\CoolQ\app\com.sobte.cqp.jcq\app\com.example.demo\
        // 应用的所有数据、配置【必须】存放于此目录，避免给用户带来困扰。
        return 0;
    }

    public int exit() {
        return 0;
    }

    public int enable() {
        enable = true;
        return 0;
    }

    public int disable() {
        enable = false;
        return 0;
    }

    public int privateMsg(int subType, int msgId, long fromQQ, String msg, int font) {
        // 这里处理消息
        //CQ.sendPrivateMsg(fromQQ, "你发送了这样的消息：" + msg + "\n来自Java插件");
        return MSG_IGNORE;
    }

    public int groupMsg(int subType, int msgId, long fromGroup, long fromQQ, String fromAnonymous, String msg, int font) {
        if (fromQQ == 80000000L && !fromAnonymous.equals("")) {
            Anonymous anonymous = CQ.getAnonymous(fromAnonymous);
        }

        String result = null;
        String result1 = null;
        String result2 = null;
        String result3 = null;
        String result4 = null;
        String result5 = null;
        String result6 = null;
        String result7 = null;
        String result8 = null;
        String result9 = null;
        String result10 = null;

        if (msg.equals("抽卡")){
            try {
                result = OneShot2x();
                //result = OneShot();
            } catch (Exception e) {
                e.printStackTrace();
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + e);
            }
            CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你抽到了 " + result);
        }


        if (msg.equals("十连")){
            try {
                /*result1 = OneShot2x();
                result2 = OneShot2x();
                result3 = OneShot2x();
                result4 = OneShot2x();
                result5 = OneShot2x();
                result6 = OneShot2x();
                result7 = OneShot2x();
                result8 = OneShot2x();
                result9 = OneShot2x();
                result10 = OneShot2x();*/
                //概率up
                result1 = OneShot();
                result2 = OneShot();
                result3 = OneShot();
                result4 = OneShot();
                result5 = OneShot();
                result6 = OneShot();
                result7 = OneShot();
                result8 = OneShot();
                result9 = OneShot();
                result10 = OneShot();
            } catch (Exception e) {
                e.printStackTrace();
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + e);
            }
            CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你的十连结果为... " + "\n" + result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5 + "\n" + result6 + "\n" + result7 + "\n" + result8 + "\n" + result9 + "\n" + result10);
        }


        if (msg.equals("寻访")){
            try {
                result = OneShot_Arknights();
            } catch (Exception e) {
                e.printStackTrace();
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + e);
            }
            CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你抽到了 " + result);
        }

        if (msg.equals("十连寻访")){
            try {
                result1 = OneShot_Arknights();
                result2 = OneShot_Arknights();
                result3 = OneShot_Arknights();
                result4 = OneShot_Arknights();
                result5 = OneShot_Arknights();
                result6 = OneShot_Arknights();
                result7 = OneShot_Arknights();
                result8 = OneShot_Arknights();
                result9 = OneShot_Arknights();
                result10 = OneShot_Arknights();
            } catch (Exception e) {
                e.printStackTrace();
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + e);
            }
            CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你的十连结果为... " + "\n" + result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5 + "\n" + result6 + "\n" + result7 + "\n" + result8 + "\n" + result9 + "\n" + result10);
        }

        if (msg.equals("关于")){
            CQ.sendGroupMsg(fromGroup,helpMessage);
        }

        if (msg.contains("我要抽")){
            String ssrWanted = msg.replace("我要抽","");
            CQ.sendGroupMsg(fromGroup,CC.at(fromQQ)+"正在帮你抽卡...");
            boolean gotSSR=false;
            int picks=0;
            while (!gotSSR){
                picks++;
                if (OneShot_HowManyTimes().equals(ssrWanted))
                    gotSSR=true;
            }
            CQ.sendGroupMsg(fromGroup,CC.at(fromQQ)+"你花费了"+picks+"张神秘的符咒，终于召唤出了"+ssrWanted+"!");
        }

        return MSG_IGNORE;
    }

    public int discussMsg(int i, int i1, long l, long l1, String s, int i2) {
        return 0;
    }

    public int groupUpload(int subType, int sendTime, long fromGroup, long fromQQ, String file) {
        GroupFile groupFile = CQ.getGroupFile(file);
        return MSG_IGNORE;
    }

    public int groupAdmin(int subtype, int sendTime, long fromGroup, long beingOperateQQ) {
        return MSG_IGNORE;
    }

    public int groupMemberDecrease(int subtype, int sendTime, long fromGroup, long fromQQ, long beingOperateQQ) {
        return MSG_IGNORE;
    }

    public int groupMemberIncrease(int subtype, int sendTime, long fromGroup, long fromQQ, long beingOperateQQ) {
        return MSG_IGNORE;
    }

    public int friendAdd(int subtype, int sendTime, long fromQQ) {
        return MSG_IGNORE;
    }

    public int requestAddFriend(int subtype, int sendTime, long fromQQ, String msg, String responseFlag) {
        return MSG_IGNORE;
    }

    public int requestAddGroup(int subtype, int sendTime, long fromGroup, long fromQQ, String msg,
                               String responseFlag) {
        return MSG_IGNORE;
    }


}
