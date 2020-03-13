package cn.maoookai;
import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;

import com.sobte.cqp.jcq.entity.Anonymous;
import com.sobte.cqp.jcq.entity.CQDebug;
import com.sobte.cqp.jcq.entity.GroupFile;
import com.sobte.cqp.jcq.entity.ICQVer;
import com.sobte.cqp.jcq.entity.IMsg;
import com.sobte.cqp.jcq.entity.IRequest;
import com.sobte.cqp.jcq.event.JcqAppAbstract;


public class Yysemulator extends JcqAppAbstract implements ICQVer, IMsg, IRequest {

    public static String[] SP ={"少羽大天狗","炼狱茨木童子","稻荷神御馔津","苍风一目连","赤影妖刀姬","御怨般若","骁浪荒川之主","烬天玉藻前","鬼王酒吞童子","天剑韧心鬼切","聆海金鱼姬"};
    public static String[] SSR ={"大天狗","酒吞童子","荒川之主","阎魔","小鹿男","茨木童子","青行灯","妖刀姬","一目连","花鸟卷","辉夜姬","荒","彼岸花","雪童子","山风","玉藻前","御馔津","面灵气","鬼切","白藏主","八岐大蛇","不知火","大岳丸","泷夜叉姬","云外镜","鬼童丸","缘结神"};
    public static String[] SR ={"桃花妖","雪女","鬼使白","鬼使黑","孟婆","犬神","骨女","鬼女红叶","跳跳哥哥","傀儡师","海坊主","判官","凤凰火","吸血姬","妖狐","妖琴师","食梦貘","清姬","镰鼬","姑获鸟","二口女","白狼","樱花妖","惠比寿","络新妇","般若","青坊主","夜叉","黑童子","白童子","烟烟罗","金鱼姬","鸩","以津真天","匣中少女","书翁","百目鬼","追月神","熏","弈","猫掌柜","於菊虫","一反木绵","入殓师","化鲸","久次良","蟹姬","纸舞","星熊童子"};
    public static String[] R ={"三尾狐","座敷童子","鲤鱼精","九命猫","狸猫","河童","童男","童女","饿鬼","巫蛊师","鸦天狗","食发鬼","武士之灵","雨女","跳跳弟弟","跳跳妹妹","兵俑","丑时之女","独眼小僧","铁鼠","椒图","管狐","山兔","萤草","山童","首无","觉","青蛙瓷器","古笼火","虫师"};

        static int Counter(int total) {
            Random random = new Random();
            return random.nextInt(total);
        }

        static String SSRPicker(){
            int result = Counter(SSR.length);
            return ("你抽到了SSR "+SSR[result]);
        }

        static String SPPicker(){
            int result = Counter(SP.length);
            return ("你抽到了SP "+SP[result]);
        }

        static String SRPicker(){
            int result = Counter(SR.length);
            return ("你抽到了SR "+SR[result]);
        }

        static String RPicker(){
            int result = Counter(R.length);
            return ("你抽到了R "+R[result]);
        }

        static String OneShot() throws IOException {
            Random getcard = new Random();
            String return_result;
            int result = getcard.nextInt(1000);
            if (result < 787)
                return_result = RPicker();
            else if (result < 987)
                return_result = SRPicker();
            else if (result < 997)
                return_result = SSRPicker();
            else
                return_result = SPPicker();
            return return_result;
        }



    public static void main(String[] args) throws IOException{
        CQ = new CQDebug();
        CQ.logInfo("[JCQ] TEST Demo", "测试启动");
        Yysemulator yys = new Yysemulator();
        yys.startup();// 程序运行开始 调用应用初始化方法
        yys.enable();// 程序初始化完成后，启用应用，让应用正常工作
        //System.out.println(OneShot());
        yys.exit();// 最后程序运行结束，调用exit方法
    }

    public String appInfo() {
        String AppID = "cn.maoookai.yysemulator";
        return CQAPIVER + "," + AppID;
    }

    /**
     * 酷Q启动 (Type=1001)<br>
     * 本方法会在酷Q【主线程】中被调用。<br>
     * 请在这里执行插件初始化代码。<br>
     * 请务必尽快返回本子程序，否则会卡住其他插件以及主程序的加载。
     *
     * @return 请固定返回0
     */
    public int startup() {
        // 获取应用数据目录(无需储存数据时，请将此行注释)
        String appDirectory = CQ.getAppDirectory();
        // 返回如：D:\CoolQ\app\com.sobte.cqp.jcq\app\com.example.demo\
        // 应用的所有数据、配置【必须】存放于此目录，避免给用户带来困扰。
        return 0;
    }

    /**
     * 酷Q退出 (Type=1002)<br>
     * 本方法会在酷Q【主线程】中被调用。<br>
     * 无论本应用是否被启用，本函数都会在酷Q退出前执行一次，请在这里执行插件关闭代码。
     *
     * @return 请固定返回0，返回后酷Q将很快关闭，请不要再通过线程等方式执行其他代码。
     */
    public int exit() {
        return 0;
    }

    /**
     * 应用已被启用 (Type=1003)<br>
     * 当应用被启用后，将收到此事件。<br>
     * 如果酷Q载入时应用已被启用，则在 {@link #startup startup}(Type=1001,酷Q启动) 被调用后，本函数也将被调用一次。<br>
     * 如非必要，不建议在这里加载窗口。
     *
     * @return 请固定返回0。
     */
    public int enable() {
        enable = true;
        return 0;
    }

    /**
     * 应用将被停用 (Type=1004)<br>
     * 当应用被停用前，将收到此事件。<br>
     * 如果酷Q载入时应用已被停用，则本函数【不会】被调用。<br>
     * 无论本应用是否被启用，酷Q关闭前本函数都【不会】被调用。
     *
     * @return 请固定返回0。
     */
    public int disable() {
        enable = false;
        return 0;
    }

    /**
     * 私聊消息 (Type=21)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subType 子类型，11/来自好友 1/来自在线状态 2/来自群 3/来自讨论组
     * @param msgId   消息ID
     * @param fromQQ  来源QQ
     * @param msg     消息内容
     * @param font    字体
     * @return 返回值*不能*直接返回文本 如果要回复消息，请调用api发送<br>
     * 这里 返回  {@link IMsg#MSG_INTERCEPT MSG_INTERCEPT} - 截断本条消息，不再继续处理<br>
     * 注意：应用优先级设置为"最高"(10000)时，不得使用本返回值<br>
     * 如果不回复消息，交由之后的应用/过滤器处理，这里 返回  {@link IMsg#MSG_IGNORE MSG_IGNORE} - 忽略本条消息
     */
    public int privateMsg(int subType, int msgId, long fromQQ, String msg, int font) {
        // 这里处理消息
        //CQ.sendPrivateMsg(fromQQ, "你发送了这样的消息：" + msg + "\n来自Java插件");
        return MSG_IGNORE;
    }

    /**
     * 群消息 (Type=2)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subType       子类型，目前固定为1
     * @param msgId         消息ID
     * @param fromGroup     来源群号
     * @param fromQQ        来源QQ号
     * @param fromAnonymous 来源匿名者
     * @param msg           消息内容
     * @param font          字体
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int groupMsg(int subType, int msgId, long fromGroup, long fromQQ, String fromAnonymous, String msg,
                        int font) {
        // 如果消息来自匿名者
        if (fromQQ == 80000000L && !fromAnonymous.equals("")) {
            // 将匿名用户信息放到 anonymous 变量中
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
                result = OneShot();
            } catch (Exception e) {
                e.printStackTrace();
                CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + e);
            }
            CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + result);
        }

        if (msg.equals("十连")){
            try {
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
            CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "\n" + result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5 + "\n" + result6 + "\n" + result7 + "\n" + result8 + "\n" + result9 + "\n" + result10);
        }

        // 解析CQ码案例 如：[CQ:at,qq=100000]
        // 解析CQ码 常用变量为 CC(CQCode) 此变量专为CQ码这种特定格式做了解析和封装
        // CC.analysis();// 此方法将CQ码解析为可直接读取的对象
        // 解析消息中的QQID
        //long qqId = CC.getAt(msg);// 此方法为简便方法，获取第一个CQ:at里的QQ号，错误时为：-1000
        //List<Long> qqIds = CC.getAts(msg); // 此方法为获取消息中所有的CQ码对象，错误时返回 已解析的数据
        // 解析消息中的图片
        //CQImage image = CC.getCQImage(msg);// 此方法为简便方法，获取第一个CQ:image里的图片数据，错误时打印异常到控制台，返回 null
        //List<CQImage> images = CC.getCQImages(msg);// 此方法为获取消息中所有的CQ图片数据，错误时打印异常到控制台，返回 已解析的数据

        // 这里处理消息
        //CQ.sendGroupMsg(fromGroup, CC.at(fromQQ) + "你发送了这样的消息：" + msg + "\n来自Java插件");
        return MSG_IGNORE;
    }

    @Override
    public int discussMsg(int i, int i1, long l, long l1, String s, int i2) {
        return 0;
    }

    /**
     * 讨论组消息 (Type=4)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype     子类型，目前固定为1
     * @param msgId       消息ID
     * @param fromDiscuss 来源讨论组
     * @param fromQQ      来源QQ号
     * @param msg         消息内容
     * @param font        字体
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    /*public int discussMsg(int subtype, int msgId, long fromDiscuss, long fromQQ, String msg, int font) {
        // 这里处理消息

        return MSG_IGNORE;
    }

     */

    /**
     * 群文件上传事件 (Type=11)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subType   子类型，目前固定为1
     * @param sendTime  发送时间(时间戳)// 10位时间戳
     * @param fromGroup 来源群号
     * @param fromQQ    来源QQ号
     * @param file      上传文件信息
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int groupUpload(int subType, int sendTime, long fromGroup, long fromQQ, String file) {
        GroupFile groupFile = CQ.getGroupFile(file);
        // 解析群文件信息，如果失败直接忽略该消息
        // 这里处理消息
        return MSG_IGNORE;
    }

    /**
     * 群事件-管理员变动 (Type=101)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype        子类型，1/被取消管理员 2/被设置管理员
     * @param sendTime       发送时间(时间戳)
     * @param fromGroup      来源群号
     * @param beingOperateQQ 被操作QQ
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int groupAdmin(int subtype, int sendTime, long fromGroup, long beingOperateQQ) {
        // 这里处理消息

        return MSG_IGNORE;
    }

    /**
     * 群事件-群成员减少 (Type=102)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype        子类型，1/群员离开 2/群员被踢
     * @param sendTime       发送时间(时间戳)
     * @param fromGroup      来源群号
     * @param fromQQ         操作者QQ(仅子类型为2时存在)
     * @param beingOperateQQ 被操作QQ
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int groupMemberDecrease(int subtype, int sendTime, long fromGroup, long fromQQ, long beingOperateQQ) {
        // 这里处理消息

        return MSG_IGNORE;
    }

    /**
     * 群事件-群成员增加 (Type=103)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype        子类型，1/管理员已同意 2/管理员邀请
     * @param sendTime       发送时间(时间戳)
     * @param fromGroup      来源群号
     * @param fromQQ         操作者QQ(即管理员QQ)
     * @param beingOperateQQ 被操作QQ(即加群的QQ)
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int groupMemberIncrease(int subtype, int sendTime, long fromGroup, long fromQQ, long beingOperateQQ) {
        // 这里处理消息

        return MSG_IGNORE;
    }

    /**
     * 好友事件-好友已添加 (Type=201)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype  子类型，目前固定为1
     * @param sendTime 发送时间(时间戳)
     * @param fromQQ   来源QQ
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int friendAdd(int subtype, int sendTime, long fromQQ) {
        // 这里处理消息

        return MSG_IGNORE;
    }

    /**
     * 请求-好友添加 (Type=301)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype      子类型，目前固定为1
     * @param sendTime     发送时间(时间戳)
     * @param fromQQ       来源QQ
     * @param msg          附言
     * @param responseFlag 反馈标识(处理请求用)
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int requestAddFriend(int subtype, int sendTime, long fromQQ, String msg, String responseFlag) {
        // 这里处理消息

        /**
         * REQUEST_ADOPT 通过
         * REQUEST_REFUSE 拒绝
         */

        // CQ.setFriendAddRequest(responseFlag, REQUEST_ADOPT, null); // 同意好友添加请求
        return MSG_IGNORE;
    }

    /**
     * 请求-群添加 (Type=302)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype      子类型，1/他人申请入群 2/自己(即登录号)受邀入群
     * @param sendTime     发送时间(时间戳)
     * @param fromGroup    来源群号
     * @param fromQQ       来源QQ
     * @param msg          附言
     * @param responseFlag 反馈标识(处理请求用)
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int requestAddGroup(int subtype, int sendTime, long fromGroup, long fromQQ, String msg,
                               String responseFlag) {
        // 这里处理消息

        /**
         * REQUEST_ADOPT 通过
         * REQUEST_REFUSE 拒绝
         * REQUEST_GROUP_ADD 群添加
         * REQUEST_GROUP_INVITE 群邀请
         */
		/*if(subtype == 1){ // 本号为群管理，判断是否为他人申请入群
			CQ.setGroupAddRequest(responseFlag, REQUEST_GROUP_ADD, REQUEST_ADOPT, null);// 同意入群
		}
		if(subtype == 2){
			CQ.setGroupAddRequest(responseFlag, REQUEST_GROUP_INVITE, REQUEST_ADOPT, null);// 同意进受邀群
		}*/

        return MSG_IGNORE;
    }

    /**
     * 本函数会在JCQ【线程】中被调用。
     *
     * @return 固定返回0
     */
    public int menuA() {
        JOptionPane.showMessageDialog(null, "这是测试菜单A，可以在这里加载窗口");
        return 0;
    }

    /**
     * 本函数会在酷Q【线程】中被调用。
     *
     * @return 固定返回0
     */
    public int menuB() {
        JOptionPane.showMessageDialog(null, "这是测试菜单B，可以在这里加载窗口");
        return 0;
    }

}
