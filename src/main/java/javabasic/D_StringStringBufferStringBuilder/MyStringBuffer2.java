package javabasic.D_StringStringBufferStringBuilder;

import java.util.ArrayList;

public class MyStringBuffer2 implements StringBufferInterface {
    ArrayList sb = new ArrayList();

    public MyStringBuffer2() {
    }

    public MyStringBuffer2(String string) {
        this.append(string);
    }

    @Override
    public void append(String str) {
        this.insert(sb.size(), str);
    }

    @Override
    public void append(char c) {
        this.insert(sb.size(), c);
    }

    @Override
    public void insert(int pos, char b) {
        sb.add(pos, String.valueOf(b));
    }

    @Override
    public void insert(int pos, String b) {
        if (pos < 0 || pos > sb.size()) throw new RuntimeException("角标越界");
        if (b.equals("")) throw new IllegalArgumentException("请勿输入空字符串");
        for (int i = pos; i < b.length(); i++) {
            sb.add(i, b.charAt(i - pos));
        }
    }

    @Override
    public void delete(int start) {
        this.delete(start, sb.size());
    }

    @Override
    public void delete(int start, int end) {
        for (int i = start; i < end; i++) {
            sb.remove(i);
        }
    }

    @Override
    public void reverse() {
        for (int i = 0; i <= sb.size() - i; i++) {
            char c = (char) sb.indexOf(i);
            sb.set(i, sb.indexOf(sb.size() - i));
            sb.set(sb.size() - i, c);
        }
    }

    @Override
    public int length() {
        return sb.size();
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    public static void main(String[] args) {
        MyStringBuffer2 sb = new MyStringBuffer2("there light");
        System.out.println(sb);
        sb.insert(0, "let ");
        System.out.println(sb);

        sb.insert(10, "be ");
        System.out.println(sb);
        sb.insert(0, "God Say:");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.append('?');
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.delete(0, 4);
        System.out.println(sb);
        sb.delete(4);
        System.out.println(sb);

    }
}
