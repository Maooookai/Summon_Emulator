package cn.maoookai;

import com.sobte.cqp.jcq.entity.CQDebug;
import com.sobte.cqp.jcq.entity.ICQVer;
import com.sobte.cqp.jcq.entity.IMsg;
import com.sobte.cqp.jcq.entity.IRequest;
import com.sobte.cqp.jcq.event.JcqAppAbstract;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


public class Summon_emulator extends JcqAppAbstract implements ICQVer, IMsg, IRequest {

    /********信息********/

    public static String[] SP = {"少羽大天狗", "炼狱茨木童子", "稻荷神御馔津", "苍风一目连", "赤影妖刀姬", "御怨般若", "骁浪荒川之主", "烬天玉藻前", "鬼王酒吞童子", "天剑韧心鬼切", "聆海金鱼姬", "浮世青行灯", "缚骨清姬"};
    public static String[] SSR = {"大天狗", "酒吞童子", "荒川之主", "阎魔", "小鹿男", "小鹿男", "小鹿男", "小鹿男", "小鹿男", "小鹿男", "茨木童子", "青行灯", "妖刀姬", "一目连", "花鸟卷", "辉夜姬", "荒", "彼岸花", "雪童子", "山风", "玉藻前", "御馔津", "面灵气", "鬼切", "白藏主", "八岐大蛇", "不知火", "大岳丸", "泷夜叉姬", "云外镜", "鬼童丸", "缘结神", "铃鹿御前"};
    public static String[] SR = {"桃花妖", "雪女", "鬼使白", "鬼使黑", "孟婆", "犬神", "骨女", "鬼女红叶", "跳跳哥哥", "傀儡师", "海坊主", "判官", "凤凰火", "吸血姬", "妖狐", "妖琴师", "食梦貘", "清姬", "镰鼬", "姑获鸟", "二口女", "白狼", "樱花妖", "惠比寿", "络新妇", "般若", "青坊主", "夜叉", "黑童子", "白童子", "烟烟罗", "金鱼姬", "鸩", "以津真天", "匣中少女", "书翁", "百目鬼", "追月神", "熏", "弈", "猫掌柜", "於菊虫", "一反木绵", "入殓师", "化鲸", "久次良", "蟹姬", "纸舞", "星熊童子", "风狸", "蝎女"};
    public static String[] R = {"三尾狐", "座敷童子", "鲤鱼精", "九命猫", "狸猫", "河童", "童男", "童女", "饿鬼", "巫蛊师", "鸦天狗", "食发鬼", "武士之灵", "雨女", "跳跳弟弟", "跳跳妹妹", "兵俑", "丑时之女", "独眼小僧", "铁鼠", "椒图", "管狐", "山兔", "萤草", "山童", "首无", "觉", "青蛙瓷器", "古笼火", "虫师"};
    public static String helpMessage = "功能表：\n抽卡：阴阳师单抽\n十连：阴阳师十连\n我要抽+xxx：抽取式神或者其他奇怪的东西\n/roll：摇一个骰子\n/roll2：摇两个骰子\n/yxh 主体 事件：营销号生成器\n今日御魂：显示今日掉落御魂\n正能量：金山词霸每日一句\n以上功能仅群聊可用。2020.6.30更新。";
    public static String[] summonMessageLibrary = {"你能抽到SSR吗", "今天的运气怎么样", "阴阳师不要偷懒喵", "已经没有蓝票了吧", "别抽了，你抽不到的", "少年，来氪个648吧", "你渴望力量吗", "十连R警告", "想想你已经多久没出货了"};
    public static String[] summonFailLibrary = {"戳楼上一下", "拍了拍楼下的屁股", "放一个很响的屁", "在庙里求签", "消耗自己1分钟的生命", "询问你家长", "变成二次元", "在大街上撒币"};
    public static String[] summonFailPlaceLibrary = {"大马路上", "你书桌的柜子里", "你裤子的口袋里", "一个下水道", "高等数学课本里", "你的百度网盘", "拉屎的时候", "一阵西北风里", "家里的房顶上", "哆啦A梦的口袋里", "梦里", "群文件里"};
    public static int[] diceNumber = {1, 2, 3, 4, 5, 6};
    public static boolean isUpEnabled = true;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    /********主程序********/

    public static void main(String[] args) {
        CQ = new CQDebug();
        Summon_emulator yys = new Summon_emulator();
        yys.startup();
        yys.groupMsg(0, 10006, 123456L, 3333333334L, "", "今日御魂", 0);
        yys.exit();
    }

    /********计算器********/

    static String currentSoulProvider() {
        String currentDay = currentWeekOfDayProvider();
        String currentSoul;
        switch (currentDay) {
            case "周一":
                currentSoul = "雪幽魂、地藏像、鸣屋、网切\n魂土额外御魂：蚌精";
                break;
            case "周二":
                currentSoul = "涅槃之火、三味、招财猫、狰\n魂土额外御魂：幽谷响";
                break;
            case "周三":
                currentSoul = "魍魉之匣、被服、阴摩罗、魅妖\n魂土额外御魂：轮入道";
                break;
            case "周四":
                currentSoul = "反枕、心眼、树妖、针女\n魂土额外御魂：蝠翼";
                break;
            case "周五":
                currentSoul = "日女巳时、镜姬、钟灵、破势\n魂土额外御魂：狂骨";
                break;
            case "周六":
            case "周日":
                currentSoul = "随机掉落全部御魂（特殊御魂除外）";
                break;
            default:
                currentSoul = "未知御魂";
                break;
        }
        return currentSoul;
    }

    static String currentWeekOfDayProvider() {
        Calendar calendar = Calendar.getInstance();
        String currentDayOfWeek;
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                currentDayOfWeek = "周日";
                break;
            case 2:
                currentDayOfWeek = "周一";
                break;
            case 3:
                currentDayOfWeek = "周二";
                break;
            case 4:
                currentDayOfWeek = "周三";
                break;
            case 5:
                currentDayOfWeek = "周四";
                break;
            case 6:
                currentDayOfWeek = "周五";
                break;
            case 7:
                currentDayOfWeek = "周六";
                break;
            default:
                currentDayOfWeek = "不知道星期几";
        }
        return currentDayOfWeek;
    }

    static int Counter(int total) {
        Random random = new Random();
        return random.nextInt(total);
    }

    static String summonMessage() {
        int result = Counter(summonMessageLibrary.length);
        return (summonMessageLibrary[result]);
    }

    static String summonFail() {
        int result = Counter(summonFailLibrary.length);
        return (summonFailLibrary[result]);
    }

    static String summonFailPlace() {
        int result = Counter(summonFailPlaceLibrary.length);
        return (summonFailPlaceLibrary[result]);
    }

    static String SSRPicker() {
        int result = Counter(SSR.length);
        return (SSR[result]);
    }

    static String SPPicker() {
        int result = Counter(SP.length);
        return (SP[result]);
    }

    static String SRPicker() {
        int result = Counter(SR.length);
        return (SR[result]);
    }

    static String RPicker() {
        int result = Counter(R.length);
        return (R[result]);
    }


    /********抽卡方法********/

    static String OneShot() {
        Random gotCard = new Random();
        String oneResult;
        int result = gotCard.nextInt(1000);
        if (result < 787)
            oneResult = "R" + '\t' + RPicker();
        else if (result < 987)
            oneResult = "SR" + '\t' + SRPicker();
        else if (result < 997)
            oneResult = "SSR" + '\t' + SSRPicker();
        else
            oneResult = "SP" + '\t' + SPPicker();
        return oneResult;
    }

    static String OneShot2x() {
        Random gotCard = new Random();
        String oneResult;
        int result = gotCard.nextInt(1000);
        if (result < 762)
            oneResult = "R" + '\t' + RPicker();
        else if (result < 962)
            oneResult = "SR" + '\t' + SRPicker();
        else if (result < 987)
            oneResult = "SSR" + '\t' + SSRPicker();
        else
            oneResult = "SP" + '\t' + SPPicker();
        return oneResult;
    }

    static String OneShot_HowManyTimes() {
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

    static String OneShot_HowManyTimes2x() {
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

    /********词霸每日一句********/

    static String getDailySentence() {
        StringBuilder json = new StringBuilder();
        String url = "http://open.iciba.com/dsapi/";
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    static String getDailySentenceEnglish() {
        JSONObject getDailySentence = JSONObject.fromObject(getDailySentence());
        return getDailySentence.getString("content");
    }

    static String getDailySentenceChinese() {
        JSONObject getDailySentence = JSONObject.fromObject(getDailySentence());
        return getDailySentence.getString("note");
    }

    static String getCurrentDateFromDailySentence() {
        JSONObject getDailySentence = JSONObject.fromObject(getDailySentence());
        return getDailySentence.getString("dateline");
    }

    /********CoolQ配置********/

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

    /********群聊信息处理********/

    public int groupMsg(int subType, int msgId, long fromGroup, long fromQQ, String fromAnonymous, String msg, int font) {

        int repeatCalc = Counter(100);

        if (msg.length() > 1) {
            if (msg.split("")[msg.length() - 1].equals("吗") || msg.split("")[msg.length() - 2].equals("吗")) {
                int replyCalc = Counter(100);
                if (replyCalc <= 5) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    CQ.sendGroupMsg(fromGroup, msg.replace("吗", "") + "!");
                }
            }

            if (msg.split("")[msg.length() - 1].equals("吧") || msg.split("")[msg.length() - 2].equals("吧")) {
                int replyCalc = Counter(100);
                if (replyCalc <= 5) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    CQ.sendGroupMsg(fromGroup, msg.replace("吧", "") + "!");
                }
            }
        }

        if (repeatCalc >= 99) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CQ.sendGroupMsg(fromGroup, msg);
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

        if (msg.equals("抽卡")) {
            CQ.sendGroupMsg(fromGroup, summonMessage());
            try {
                if (isUpEnabled)
                    result = OneShot2x();
                else
                    result = OneShot();
            } catch (Exception e) {
                e.printStackTrace();
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + e);
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你抽到了 " + result);
        }


        if (msg.equals("十连")) {
            CQ.sendGroupMsg(fromGroup, summonMessage());
            try {
                if (isUpEnabled) {
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
                } else {
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
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isUpEnabled)
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你的十连结果为... " + "\n" + result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5 + "\n" + result6 + "\n" + result7 + "\n" + result8 + "\n" + result9 + "\n" + result10 + "\n" + "当前2.5倍SSR/SP概率提升已开启");
            else
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你的十连结果为... " + "\n" + result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5 + "\n" + result6 + "\n" + result7 + "\n" + result8 + "\n" + result9 + "\n" + result10 + "\n");
        }

        if (msg.equals("今日御魂")) {
            CQ.sendGroupMsg(fromGroup, "今天是" + currentWeekOfDayProvider() + "，魂十掉落：" + currentSoulProvider());
        }

        if (msg.contains("/yxh")) {
            String[] splitString = msg.split("\\s+");
            try {
                CQ.sendGroupMsg(fromGroup, splitString[1] + splitString[2] + "是怎么回事呢？" + splitString[1] + "相信大家都很熟悉，但是" + splitString[1] + splitString[2] + "是怎么回事呢，下面就让小编带大家一起了解吧。" + '\n' + splitString[1] + splitString[2] + "其实就是" + splitString[1] + splitString[2] + "，大家可能会很惊讶" + splitString[1] + "怎么会" + splitString[2] + "呢？但事实就是这样，小编也感到非常惊讶。" + '\n' + "这就是关于" + splitString[1] + splitString[2] + "的事情了，大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！");
            } catch (Exception e) {
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "输入的格式不正确！");
            }
        }

        if (msg.equals("/help")) {
            CQ.sendGroupMsg(fromGroup, helpMessage);
        }

        if (msg.equals("roll")) {
            String rolledDiceNumber = String.valueOf(diceNumber[Counter(diceNumber.length)]);
            CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你摇到了" + rolledDiceNumber);
        }

        if (msg.equals("roll2")) {
            String rolledDiceNumber = String.valueOf(diceNumber[Counter(diceNumber.length)] + diceNumber[Counter(diceNumber.length)]);
            CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你摇到了" + rolledDiceNumber);
        }

        if (msg.contains("我要抽")) {
            String ssrWanted = msg.split("我要抽")[1];
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
                CQ.sendGroupMsg(fromGroup, summonMessage());
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean gotSSR = false;
                int picks = 0;
                while (! gotSSR) {
                    picks++;
                    if (isUpEnabled) {
                        if (OneShot_HowManyTimes2x().equals(ssrWanted))
                            gotSSR = true;
                    } else {
                        if (OneShot_HowManyTimes().equals(ssrWanted))
                            gotSSR = true;
                    }
                }
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你花费了" + picks + "张神秘的符咒，终于召唤出了" + ssrWanted + "!");
            } else {
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你通过" + summonFail() + "然后在" + summonFailPlace() + "获得了" + ssrWanted);
            }
        }
        if (msg.equals("每日一句") || msg.contains("正能量"))
            CQ.sendGroupMsg(fromGroup, "词霸每日一句 " + getCurrentDateFromDailySentence() + "\n" + getDailySentenceEnglish() + '\n' + getDailySentenceChinese());
        return MSG_IGNORE;
    }

    public int discussMsg(int i, int i1, long l, long l1, String s, int i2) {
        return 0;
    }

    public int groupUpload(int subType, int sendTime, long fromGroup, long fromQQ, String file) {
        return MSG_IGNORE;
    }

    public int groupAdmin(int subtype, int sendTime, long fromGroup, long beingOperateQQ) {
        return MSG_IGNORE;
    }

    public int groupMemberDecrease(int subtype, int sendTime, long fromGroup, long fromQQ, long beingOperateQQ) {
        if (fromQQ == 0)
            CQ.sendGroupMsg(fromGroup, beingOperateQQ + "退群了！");
        else {
            CQ.sendGroupMsg(fromGroup, fromQQ + "将" + beingOperateQQ + "踢出了群");
        }
        return MSG_IGNORE;
    }

    public int groupMemberIncrease(int subtype, int sendTime, long fromGroup, long fromQQ, long beingOperateQQ) {
        if (fromQQ == 0)
            CQ.sendGroupMsg(fromGroup, beingOperateQQ + "加入了本群！");
        else {
            CQ.sendGroupMsg(fromGroup, fromQQ + "邀请了" + beingOperateQQ + "加入本群，欢迎新人！来了的都是小可爱~");
        }
        return MSG_IGNORE;
    }

    public int friendAdd(int subtype, int sendTime, long fromQQ) {
        return MSG_IGNORE;
    }

    public int requestAddFriend(int subtype, int sendTime, long fromQQ, String msg, String responseFlag) {
        CQ.sendPrivateMsg(1220568032L, fromQQ + "在" + simpleDateFormat.format(Long.valueOf(sendTime + "000")) + "添加我为好友," + "附加消息为" + msg);
        return MSG_IGNORE;
    }

    public int requestAddGroup(int subtype, int sendTime, long fromGroup, long fromQQ, String msg, String responseFlag) {
        CQ.sendPrivateMsg(1220568032L, fromQQ + "在" + simpleDateFormat.format(Long.valueOf(sendTime + "000")) + "请求进群：" + fromGroup + ",附加消息为" + msg);
        return MSG_IGNORE;
    }

}
