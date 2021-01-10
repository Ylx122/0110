# 20210109“1+x”大数据应用（Java）开发职业技能证书初、中级培训

## ----快捷方式-----
Ctrl+Alt+L(小写L)  (格式化IDEA种中的代码)

Alt+Enter (在IDEA中导入包)

## annie(可以多线程下载视频)

- 下载annie的地址
```https
https://github.com/iawia002/annie/releases
```

然后选择相应的包(我的电脑时64位的所以要下载64位的.zip压缩包，32位的用户要下载32位的.zip压缩包)
```
annie_0.10.3_Windows_64-bit.zip
```

- 下载ffmpeg的地址
```https
https://www.ffmpeg.org/
```

进入ffmpeg的地址直接点击Download即可下载

## 具体的下载视频过程

- 一、 annie使用前准备

```
先把annie.exe 所在路劲添加到系统环境路径path 中（在annie.exe路劲中直接打开DOS也行-----打开方法：在显示路径的位置[例如：F:\Ylx\Tools\annie_0.10.3_Windows_64-bit]直接输入cmd即可）
```

- 二、 annie 下载
```
E:\>annie -i https:...  (视频的路径path)    查看该视频有几种清晰度
E:\>annie -o F:\Ylx\TencentVideo -f fhd https:...  (视频的路径path)  下载视频到指定路径F:\Ylx\TencentVideo


下载视频过程中如果下载网速变慢了可以 Ctrl+c 中止此次下载（下载好的还在）然后再次下载视频即可它会自动根据断点来接着上一次下载。

下载完成后即可直接使用 ffmpeg 来将多线程下载的多个视频拼接在一起（单个视频也可以直接看）
```

- 三、ffmpeg使用前准备
```
把ffmpeg.exe 等三个可执行文件的所在路径添加到系统变量的path 中（在ffmpeg.exe等三个可执行文件所在路径[例如：F:\Ylx\Tools\ffmpeg-N-100581-ga454a0c14f-win64-gpl\bin]输入cmd,直接打开DOS也可以）
```

- 四、 ffmpeg 拼接视频

ffmpeg 可以拼接、剪辑视频（都是通过命令来操作）
```
ffmpeg -f concat -safe 0 -i filelist.txt output.mp4


filelist.txt 中的内容格式例如：

file '文件名1.mp4'

file '文件名2.mp4'
```


- 端口冲突时

要将另一个程序的进程杀掉然后当前应用才可以使用这个端口

## 一、Java环境的配置
1.1、 JDK的安装
jdk包含了jre

jdk: 开发用（javac、java、jps、jstack、native2ascii）

jre: 运行程序

程序为什么要先编译？

机器语言->汇编语言->高级语言（c、java、c++）

javac把源程序编译成字节码文件（jvm再去把字节码文件翻译成机器语言）

### 1.2、 环境的配置

- path:路径（可执行文件的路径）、小路

![path](./path.png)

path的应用：用annie下载腾讯视频、B站视频等
- classpath: class path(类路径)

需求：用java把导出到excel

1. 下载POI的jar包（一个用于操作 Excel 和 Word 的工具包）

使用下面的地址去下载

```https
https://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-4.1.2-20200217.zip
```

2. 写Java程序

```java
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Description:
 * 作者：gu.weidong(Jack)
 * date:2018年9月27日
 * ProjectName:ExcelExport
 */
public class WriteExcel {
    public static void main(String[] args) throws ParseException {
        //创建一个HSSF,对应一个excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        //在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = workbook.createSheet("学生表");
        //在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        //创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = workbook.createCellStyle();

        HSSFCell cell = row.createCell(0);
        cell.setCellValue("学号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("年龄");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("生日");
        cell.setCellStyle(style);

        //写入实体数据
        //      List list = DemoDaoImpl.getStudent();
        List list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            //     Student stu = (Student) list.get(i);
            //创建单元格，并设置值
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellValue("Jack");
            row.createCell(2).setCellValue(20);
            cell = row.createCell(3);
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        }
        //将文件存到指定位置
        try {
            FileOutputStream fout = new FileOutputStream("E:/学生表.xls");
            workbook.write(fout);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
用java操作 excel (读写)

rocketmq

java中很多第三方的应用都是以jar包的形式对外发布

spring
springmvc
springboot
springcloud

## 二、变量、流程控制

### 2.1、标识符、数据类型

- 基本类型（8种）

整形：

计算机分配内存的最小单位是：字节

声明年龄这样的变量 byte age;  节省了3个字节

byte: 8位 -128（2的7次方）~ 127（2的7次方减一）

short: 16位 -32768（2的15次方）~ 32767（2的15次方减一）

int：32位 -2147483648（2的31次方）~ 2147483647（2的31次方减一）

long：64位

字符：char 16位

浮点：float 32位 double 64位

布尔：boolean（只有true和false）

- 引用类型（3种）

类

接口

数组

### 2.2、声明变量和赋值

数据类型 数据名称；

int a;

char c;

变量本质上就是一个容器（箱子）

byte age = 22;

age = 23;

### 2.3、流程控制

- 程序可以做某件事

- 程序在某个条件下做某件事

if...else if ...else

- 程序重复做某件事

for: 明确循环次数

while: 不明确循环次数

递归： （要注意递归的出口问题）

### 2.4、Java程序什么情况下算是结束

main()线程结束，意味着jvm的退出

（main()函数其实就是一个线程）

## 三、方法

- 什么是方法？

```
能完成特定功能的代码的集合
```

- 如何定义方法

```
返回类型 方法名称（【参数1】,【参数2】...）{
    方法体
}
```

方法命名的依据？方法能完成什么功能

int c abs(-5);
c是5

## 四、前四章综合案例

- 标识符
- 变量
- 流程控制
- 一维数组
- 二维数组
- 方法

编程的本质：调用方法

- 知识点
```
声明变量
变量赋值
```

完整代码
```java
class MainCanvas extends Canvas implements Runnable
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Thread thread;
	int heroX,heroY,bossX,bossY;
	int flag;
	Image heroImg[][]=new Image[4][3];
	Image bossImg;
	//4个方向、每个方向3张图片，0表示left、1表示right、2表示up、3表示down
	/*
	规则二维数组
	*/
	Random rd=new Random();
	Image currentImg;

	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][1];
			heroX=120;
			heroY=100;

			bossX=0;
			bossY=0;

			flag=1;
			
			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	/*
	在多线程里写一个死循环，不停的比较boss和hero的坐标
	*/
	public void run(){
		while(true){
			int rdNumber=rd.nextInt(10);
			
			try
			{
				Thread.sleep(200);//FPS：屏幕刷新率
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(rdNumber%3==0){
				if(bossX<heroX){
					bossX++;
				}
				else{
					bossX--;
				}

				if(bossY<heroY){
					bossY++;
				}else{
					bossY--;
				}
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);//设置背景色
		g.fillRect(0,0,getWidth(),getHeight());//填充矩形（以上面设置的颜色填充）
		g.drawImage(currentImg,heroX,heroY,0);//120：X坐标、100：Y坐标，把一个图片显示在屏幕上
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			changePicAndDirection(0);
			heroX=heroX-1;
		}
		if(action==UP){
			changePicAndDirection(2);
			heroY=heroY-1;
		}
		if(action==RIGHT){
			changePicAndDirection(1);
			heroX=heroX+1;
		}
		if(action==DOWN){
			changePicAndDirection(3);
			heroY=heroY+1;
		}
	}
	void changePicAndDirection(int direction){
		if(flag==1){
			currentImg=heroImg[direction][0];
			flag++;
		}
		else if(flag==2){
			currentImg=heroImg[direction][2];
			flag=1;
		}
	}
}
```

### 4.2、让hero可以四个方向走动

- 声明hero的x坐标和y坐标
```java
int x, y;
```

- 给x和y赋初值

```java
x = 100;
y = 100;
```

- 把drawImage中的100和100替换为x和y
```java
g.drawImage(img, x, y, 0);  //第一个100是x坐标，第二个100是y坐标
```

- 在keyPressed中对x坐标和y坐标进行加减操作

```java
public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			changePicAndDirection(0);
			heroX=heroX-1;
		}
		if(action==UP){
			changePicAndDirection(2);
			heroY=heroY-1;
		}
		if(action==RIGHT){
			changePicAndDirection(1);
			heroX=heroX+1;
		}
		if(action==DOWN){
			changePicAndDirection(3);
			heroY=heroY+1;
		}
	}
```

### 4.3、让hero自然走动（即两个图片来回转换）

- 声明变量
- 流程控制之if...else

思路分析

```
声明一个变量，我们来回改变该变量的值，不同的值显示不同的图片
例如： int f;
如果f是1，则显示sayo00.png
如果f是2，则显示sayo20.png
```

### 4.4、使用循环和一维数组

## 五、递归

### 5.1、递归的概念

### 5.2、递归的出口

## 六、方法的结束

一个方法什么时候才算结束？
return调用时方法结束
