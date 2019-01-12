package javaapplication.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//如代码所示的这么写。。。。就表示一下运行TestCase1 和 TestCase2 了。。。
//运行之后可以看到，哪些成功了，哪些失败了
@RunWith(Suite.class)
@Suite.SuiteClasses({TestCase1.class,TestCase2.class})
public class TestSuite {

}