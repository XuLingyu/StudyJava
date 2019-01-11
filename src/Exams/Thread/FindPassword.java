package Exams.Thread;

import java.util.LinkedList;


/*
1. 生成一个长度是3的随机字符串，把这个字符串当作 密码

2. 创建一个破解线程，使用穷举法，为守护线程

3. 创建一个日志线程，打印都用过哪些字符串去匹配 匹配到结束进程

提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，并打印出来。 如果发现容器是空的，就休息1秒，如果发现不是空的，就不停的取出，并打印。

参考： 穷举法破解密码
 */
public class FindPassword {
    public static void main(String[] args){
        String password = random(3);
        System.out.println("password："+password);
        LinkedList<String> list = new LinkedList<>();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                char[] c=new char[3];
                for (int i = '0'; i < 'z'; i++)
                    for (int j = '0'; j < 'z'; j++)
                        for (int k = '0'; k < 'z'; k++){
                            c[0]=(char)i;
                            c[1]=(char)j;
                            c[2]=(char)k;
                            if(!isLetterOrDigit(i,j,k))
                                continue;
                            list.offer(new String(c));
                        }
            }
        };

        Thread thread2=new Thread() {
            public void run() {

                while(true) {
                    if(list.isEmpty()){
                        try {
                            Thread.sleep(500);
                        }catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    String s = list.pollFirst();
                    System.out.println("尝试密码：" + s);
                    if(s.equals(password)){
                        System.out.println("破解密码成功，密码为：" + s);
                        break;
                    }
                }
            }
        };

        thread1.setDaemon(true);
        thread1.start();
        thread2.start();


    }

    //来判断不是数字和字母
    public static boolean isLetterOrDigit(int i, int j, int k){
        return Character.isLetterOrDigit(i)&& Character.isLetterOrDigit(j)&&Character.isLetterOrDigit(k);

    }

    public static String random(int len){
        char[] chars = new char[len];
        int start = '0';
        int end = 'z'+1;
        for (int i=0;i<chars.length;i++){
            while (true){
                char c = (char) (Math.random()*(end-start)+start);
                //排除掉不是数字和字母的
                if (Character.isDigit(c) || Character.isLetter(c)){
                    chars[i] = c;
                    break;
                }
            }
        }
        String result = String.valueOf(chars);
        return result;
    }
}
