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
import sun.org.mozilla.javascript.internal.EcmaError;

import javax.swing.*;


public class Summon_emulator extends JcqAppAbstract implements ICQVer, IMsg, IRequest {

    public static String[] SP ={"少羽大天狗","炼狱茨木童子","稻荷神御馔津","苍风一目连","赤影妖刀姬","御怨般若","骁浪荒川之主","烬天玉藻前","鬼王酒吞童子","天剑韧心鬼切","聆海金鱼姬","浮世青行灯"};
    public static String[] SSR ={"大天狗","酒吞童子","荒川之主","阎魔","小鹿男","茨木童子","青行灯","妖刀姬","一目连","花鸟卷","辉夜姬","荒","彼岸花","雪童子","山风","玉藻前","御馔津","面灵气","鬼切","白藏主","八岐大蛇","不知火","大岳丸","泷夜叉姬","云外镜","鬼童丸","缘结神"};
    public static String[] SR ={"桃花妖","雪女","鬼使白","鬼使黑","孟婆","犬神","骨女","鬼女红叶","跳跳哥哥","傀儡师","海坊主","判官","凤凰火","吸血姬","妖狐","妖琴师","食梦貘","清姬","镰鼬","姑获鸟","二口女","白狼","樱花妖","惠比寿","络新妇","般若","青坊主","夜叉","黑童子","白童子","烟烟罗","金鱼姬","鸩","以津真天","匣中少女","书翁","百目鬼","追月神","熏","弈","猫掌柜","於菊虫","一反木绵","入殓师","化鲸","久次良","蟹姬","纸舞","星熊童子","风狸"};
    public static String[] R ={"三尾狐","座敷童子","鲤鱼精","九命猫","狸猫","河童","童男","童女","饿鬼","巫蛊师","鸦天狗","食发鬼","武士之灵","雨女","跳跳弟弟","跳跳妹妹","兵俑","丑时之女","独眼小僧","铁鼠","椒图","管狐","山兔","萤草","山童","首无","觉","青蛙瓷器","古笼火","虫师"};
    public static String[] six_stars = {"刻俄柏","阿","煌","莫斯提马","麦哲伦","赫拉格","黑","陈","斯卡蒂","银灰","塞雷娅","星熊","夜莺","闪灵","安洁莉娜","艾雅法拉","伊芙利特","推进之王","能天使"};
    public static String[] five_stars = {"惊蛰","吽","灰猴","布洛卡","苇草","槐琥","送葬人","星极","格劳克斯","诗怀雅","夜魔","食铁兽","狮蝎","空","真理","初雪","崖心","守林人","普罗旺斯","可颂","雷蛇","红","临光","华法琳","赫默","梅尔","天火","阿米娅","陨星","白金","蓝毒","幽灵鲨","拉普兰德","芙兰卡","德克萨斯","凛冬","白面鸮"};
    public static String[] four_stars = {"安比尔","梅","红云","坚雷","桃金娘","苏苏洛","格雷伊","猎蜂","阿消","地灵","深海色","谷米","蛇屠箱","角峰","调香师","末药","暗索","砾","慕斯","艾丝黛尔","霜叶","缠丸","杜宾","红豆","清道夫","讯使","白雪","流星","杰西卡","远山","夜烟"};
    public static String[] three_stars = {"斑点","泡普卡","月见夜","空爆","梓兰","史都华德","安塞尔","芙蓉","炎熔","安德切尔","克洛丝","米格鲁","卡缇","玫兰莎","翎羽","香草","芬"};
    public static String helpMessage = "功能表：\n抽卡：阴阳师单抽\n十连：阴阳师十连\n我要抽xxx：一直帮你抽xxx并统计花费（阴阳师）\n寻访：明日方舟单抽\n十连寻访：明日方舟十连\n/roll：摇一个骰子\n/roll2：摇两个骰子\n/yxh 主体 事件：营销号生成器\n以上功能基本仅群聊可用。2020.5.2更新。";
    public static int[] diceNumber ={1,2,3,4,5,6};
    public static boolean isUpEnabled = true;

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
        static String OneShot() {
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

    static String OneShot2x() {
        Random gotCard = new Random();
        String oneResult;
        int result = gotCard.nextInt(1000);
        if (result < 762)
            oneResult = "R"+'\t'+RPicker();
        else if (result < 962)
            oneResult = "SR"+'\t'+SRPicker();
        else if (result < 987)
            oneResult = "SSR"+'\t'+SSRPicker();
        else
            oneResult = "SP"+'\t'+SPPicker();
        return oneResult;
    }

    static String OneShot_Arknights() {
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

    static String OneShot_HowManyTimes2x(){
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


    public static void main(String[] args) {
        CQ = new CQDebug();
        CQ.logInfo("[JCQ] TEST Demo", "测试启动");
        Summon_emulator yys = new Summon_emulator();
        yys.startup();
        yys.enable();
        yys.groupMsg(0, 10006, 3456789012L, 3333333334L, "", "/yxh 1 2", 0);
        yys.exit();
    }

    public String appInfo() {
        String AppID = "cn.maoookai.summon_emulator";
        return CQAPIVER + "," + AppID;
    }

    public int startup() {
        //String appDirectory = CQ.getAppDirectory();
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
        return MSG_IGNORE;
    }

    public int groupMsg(int subType, int msgId, long fromGroup, long fromQQ, String fromAnonymous, String msg, int font) {

        int repeatCalc = Counter(100);
        if (repeatCalc>=99) {
            CQ.sendGroupMsg(fromGroup,msg);
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
                if (isUpEnabled)
                    result = OneShot2x();
                else
                    result = OneShot();
            } catch (Exception e) {
                e.printStackTrace();
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + e);
            }
            CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你抽到了 " + result);
        }


        if (msg.equals("十连")){
            try {
                if (isUpEnabled){
                    result1 = OneShot2x();
                    result2 = OneShot2x();
                    result3 = OneShot2x();
                    result4 = OneShot2x();
                    result5 = OneShot2x();
                    result6 = OneShot2x();
                    result7 = OneShot2x();
                    result8 = OneShot2x();
                    result9 = OneShot2x();
                    result10 = OneShot2x();
                }
                else {
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
                }
            } catch (Exception e) {
                e.printStackTrace();
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + e);
            }
            if (isUpEnabled)
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你的十连结果为... " + "\n" + result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5 + "\n" + result6 + "\n" + result7 + "\n" + result8 + "\n" + result9 + "\n" + result10 + "\n" + "当前2.5倍SSR/SP概率提升已开启");
            else
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你的十连结果为... " + "\n" + result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5 + "\n" + result6 + "\n" + result7 + "\n" + result8 + "\n" + result9 + "\n" + result10 + "\n");
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

        if(msg.contains("/yxh")){
            String[] splitString=msg.split("\\s+");
            try {
                CQ.sendGroupMsg(fromGroup,splitString[1] + splitString[2] + "是怎么回事呢？" + splitString[1] + "相信大家都很熟悉，但是" + splitString[1] +  splitString[2] + "是怎么回事呢，下面就让小编带大家一起了解吧。" + '\n' + splitString[1] +  splitString[2] + "其实就是" + splitString[1] +  splitString[2] + "，大家可能会很惊讶" + splitString[1] + "怎么会" + splitString[2] + "呢？但事实就是这样，小编也感到非常惊讶。" + '\n' + "这就是关于" + splitString[1] +  splitString[2] + "的事情了，大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！");
            } catch (Exception e) {
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "输入的格式不正确！");
            }
        }

        if (msg.equals("/help")){
            CQ.sendGroupMsg(fromGroup,helpMessage);
        }

        if (msg.equals("roll")){
            String rolledDiceNumber = String.valueOf(diceNumber[Counter(diceNumber.length)]);
            CQ.sendGroupMsg(fromGroup,CC.at(fromQQ)+"你摇到了"+rolledDiceNumber);
        }

        if (msg.equals("roll2")){
            String rolledDiceNumber = String.valueOf(diceNumber[Counter(diceNumber.length)]+diceNumber[Counter(diceNumber.length)]);
            CQ.sendGroupMsg(fromGroup,CC.at(fromQQ)+"你摇到了"+rolledDiceNumber);
        }

        if (msg.contains("我要抽")) {
            String ssrWanted = msg.replace("我要抽", "");
            boolean SSRExists = false;
            for (String s : SSR) {
                if (s.equals(ssrWanted)) {
                    SSRExists = true;
                    break;
                }
            }
            for (String s : SR) {
                if (s.equals(ssrWanted)) {
                    SSRExists = true;
                    break;
                }
            }
            for (String s : R) {
                if (s.equals(ssrWanted)) {
                    SSRExists = true;
                    break;
                }
            }
            for (String s : SP) {
                if (s.equals(ssrWanted)) {
                    SSRExists = true;
                    break;
                }
            }
            if (SSRExists) {
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "正在帮你抽卡...");
                boolean gotSSR = false;
                int picks = 0;
                while (!gotSSR) {
                    picks++;
                    if (isUpEnabled) {
                        if (OneShot_HowManyTimes2x().equals(ssrWanted))
                            gotSSR = true;
                    }
                    else {
                        if (OneShot_HowManyTimes().equals(ssrWanted))
                            gotSSR = true;
                    }
                }
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你花费了" + picks + "张神秘的符咒，终于召唤出了" + ssrWanted + "!");
            }
            else {
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你抽光了所有的符咒，并没有抽到"+ssrWanted+"。");
            }
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
        CQ.sendPrivateMsg(1220568032L,fromQQ+"在"+sendTime+"添加我为好友,"+"附加消息为"+msg);
        return MSG_IGNORE;
    }

    public int requestAddGroup(int subtype, int sendTime, long fromGroup, long fromQQ, String msg,
                               String responseFlag) {
        CQ.sendPrivateMsg(1220568032L,fromQQ+"在"+sendTime+"拉我进群："+fromGroup+",附加消息为"+msg);
        return MSG_IGNORE;
    }

}
