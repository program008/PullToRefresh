package com.qf.csdn.home.my.bean;

/**
 * Created by LiuTao008
 * on 2016/2/16.
 */
public class MyCollectCotent {

    /**
     * code : 2000
     * message :
     * data : {"body":"<div>\n\n   \n\n        <div >\n        \n    <\/div>\n      <div id=\"article_content\" >\n\n\n\nJava nio 全称Java new io，是jdk1.4里提供的api。<br>\n<br>\n<br>\nJava nio 与 io最主要的区别<br>\n<h3>1、读写方式<\/h3>\nIo是面向流的，只能在一个方向上移动，一个输入流（inputStream）一个输出流（outputStream），需要从流中读一个或多个字节，直到读取完所有的字节。<br>\nNio是面向缓冲的，可以双向，无论是读写，数据都会被先放到一个缓冲区<br>\n<br>\n<h3>2.阻塞与非阻塞<\/h3>\nIo流是阻塞的，当一个线程调用read()或write()时，直到被read或write完成，在此期间，该线程处于等待阻塞模式，不干任何其他事情。<br>\nNio 是非阻塞的，当一个线程从通道发出读/写的请求的时候，数据会被先放到缓冲区里，而不需要等待全部读写完成，在此期间，这个线程可以去做别的事情，通常在空闲时候会执行其他通道上的io操作，一个线程可以管理多个通道\n\n\n<h3>Nio核心概念：<\/h3>\n<h3>Buffer (缓冲区)，Channel（通道），Selector（选择器）<\/h3>\n<div>\n<p>Buffer<\/p>\n<p>前面已经提到，Nio是面向缓冲区的，所有的读写都要先放到缓冲区。<\/p>\n<p>所有的缓冲区类型都继承于抽象类Buffer,最常用的是Bytebuffer, java基础类基本上都有相应的buffer类来一一对应，类继承关系图如下：<\/p>\n<img src=\"http://img.blog.csdn.net/20151229213445131?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"\"><br>\n<\/div>\n\n<div>\n<p>Channel<\/p>\n<p>通道和io的流类似，主要区别为：通道是双向的，可读可写，io流是单向的，只能读或写，而且操作通道不会直接从通道中写入或读取数据，都是由通道将数据放入缓冲区（buffer）中。<br>\n最常用的通道：<br>\nFilechannel 读取/写入 文件数据<br>\nSocketchannel TCP协议的socket 读写数据<br>\nDatagramchannel UDP协议读写数据<br>\n下面是客服端发送读或写的请求过程，<br>\n<\/p>\n<p><img src=\"http://img.blog.csdn.net/20151229213605644?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"\"><br>\n<\/p>\n\n<p>用Filechannel 往文件中读取和写入数据的简单例子<\/p>\n读取文件内容：\n\n<pre name=\"code\" >public static void main(String[] args) {\n\t\tFileInputStream fin = null;\n\t\ttry {\n\t\t\tfin = new FileInputStream(\"c:\\\\nio.txt\");\n\t\t} catch (FileNotFoundException e) {\n\t\t\te.printStackTrace();\n\t\t}\n\t\t// 获取通道\n\t\tFileChannel fc = fin.getChannel();\n\n\t\t// 创建缓冲区\n\t\tByteBuffer buffer = ByteBuffer.allocate(1024);\n\n\t\t// 读取数据到缓冲区\n\t\ttry {\n\t\t\tfc.read(buffer);\n\t\t} catch (IOException e) {\n\t\t\te.printStackTrace();\n\t\t}\n\n\t\tbuffer.flip();\n\n\t\twhile (buffer.remaining() > 0) {\n\t\t\tbyte b = buffer.get();\n\t\t\tSystem.out.print(((char) b));\n\t\t}\n\t\ttry {\n\t\t\tfin.close();\n\t\t} catch (IOException e) {\n\t\t\te.printStackTrace();\n\t\t}\n\t\t\n\t}<\/pre>\n\n\n写入文件内容：\n\n<pre name=\"code\" >public static void main(String[] args) {\n\t\tFile file = new File(\"c:\\\\nio.txt\"); \n\t\tFileOutputStream outputStream = null;\n\t\ttry {\n\t\t\toutputStream = new FileOutputStream(file);\n\t\t} catch (FileNotFoundException e1) {\n\t\t\te1.printStackTrace();\n\t\t} \n\t\tFileChannel channel = outputStream.getChannel(); \n\t\tByteBuffer bufferWrite = ByteBuffer.allocate(1024); \n\t\tString string = \"hello nio...\"; \n\t\tbufferWrite.put(string.getBytes()); \n\t\t//这里必须调用flip(),先读取数据到Buffer，再从Buffer中读取数据。\n\t\tbufferWrite.flip();\n\t\ttry {\n\t\t\tchannel.write(bufferWrite);\n\t\t\tchannel.close(); \n\t\t\toutputStream.close(); \n\t\t} catch (IOException e1) {\n\t\t\te1.printStackTrace();\n\t\t} \n\t}<\/pre><br>\nSelect <br>\nSelect 能检测到注册的所有通道上是否有读写请求，当有请求的时候才会进行读写，一个线程管理了多个通道，避免了多线程切换导致的开销，也不用去维护多个线程，操作原理如下图\n\n<p><img src=\"http://img.blog.csdn.net/20151229213928077?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"\"><\/p>\n\n<p>这里介绍了javaio和nio的区别，以及nio的主要概念，还有简单的nio读写文件数据的例子，对nio就不做深入了。<\/p>\n<p>有兴趣的同学可以看Jakob Jenkov的系列文章，http://tutorials.jenkov.com/java-nio/index.html<\/p>\n<p>接下来会分享nio框架netty的一些学习心得，以及netty在实际项目架构中的使用<\/p>\n<br>\n<br>\n\n<\/div>\n   \n<\/div>\n\n\n\n\n\n\n\n\n\n\n\n   \n\n    \n\n\n            \n    \n      \n<\/div>","desc":" Java nio 全称Java new io，是jdk1.4里提供的api。 Java nio 与 io最主要的区别 1、读写方式 Io是面向流的，只能在一个方向上移动，一个输入流（inputStream）一个输出流（outputStream），需要从流中读一个或多个字节，直到读取完所有的字节。 Nio是面向缓冲的，可以双向，无论是读写，数据都会被先放到一个缓冲区 2.阻塞与非阻塞 Io流是阻塞","tag":"","forum_name":"GEEKNEWS","update_timestamp":"2016-02-16 10:38:57","add_score_click_num":"0","id":"54090","title":"Java nio 概述","username":"u010926964","rank":"0","share_url":"http://ms.csdn.net/geek/54090","description":"","support_num":7,"is_markdown":"0","nickname":"邵鸿鑫","status":"1","is_fav":1,"ding_cai":0,"category_id":"0","avatar":"http://avatar.csdn.net/0/7/C/1_u010926964.jpg","operator":"","url":"http://blog.csdn.net/tuposky/article/details/50429483","is_expert":"0","ip":"0","operate_time":"0","expert_username":"","source":"<div>\n\n   \n\n        <div class=\"article_manage clearfix\">\n        \n    <\/div>\n      <div id=\"article_content\" class=\"article_content\">\n\n\n\n<span>Java nio 全称Java new io<span>，<\/span>是jdk1.4里提供的api。<\/span><br>\n<br>\n<br>\n<span>Java nio 与 io最主要的区别<\/span><br>\n<h3><span>1、读写方式<\/span><\/h3>\n<span>Io是面向流的，只能在一个方向上移动，一个输入流（inputStream）一个输出流（outputStream），需要从流中读一个或多个字节，直到读取完所有的字节。<\/span><br>\n<span>Nio是面向缓冲的，可以双向，无论是读写，数据都会被先放到一个缓冲区<\/span><br>\n<br>\n<h3><span>2.阻塞与非阻塞<\/span><\/h3>\n<span>Io流是阻塞的，当一个线程调用read()或write()时，直到被read或write完成，在此期间，该线程处于等待阻塞模式，不干任何其他事情。<\/span><br>\n<span>Nio 是非阻塞的，当一个线程从通道发出读/写的请求的时候，数据会被先放到缓冲区里，而不需要等待全部读写完成，在此期间，这个线程可以去做别的事情，通常在空闲时候会执行其他通道上的io操作，一个线程可以管理多个通道<\/span>\n\n\n<h3>Nio核心概念：<\/h3>\n<h3><span>Buffer (缓冲区)，Channel（通道），Selector（选择器）<\/span><\/h3>\n<div>\n<p><strong>Buffer<\/strong><\/p>\n<p>前面已经提到，<span>Nio<\/span><span>是面向缓冲区的，所有的读写都要先放到缓冲区。<\/span><\/p>\n<p>所有的缓冲区类型都继承于抽象类<span>Buffer,<\/span><span>最常用的是<\/span><span>Bytebuffer, java<\/span><span>基础类基本上都有相应的<\/span><span>buffer<\/span><span>类来一一对应，类继承关系图如下：<\/span><\/p>\n<img src=\"http://img.blog.csdn.net/20151229213445131?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"\"><br>\n<\/div>\n\n<div>\n<p><strong>Channel<\/strong><\/p>\n<p>通道和io的流类似，主要区别为：通道是双向的，可读可写，io流是单向的，只能读或写，而且操作通道不会直接从通道中写入或读取数据，都是由通道将数据放入缓冲区（buffer）中。<br>\n最常用的通道：<br>\nFilechannel 读取/写入 文件数据<br>\nSocketchannel TCP协议的socket 读写数据<br>\nDatagramchannel UDP协议读写数据<br>\n下面是客服端发送读或写的请求过程，<br>\n<\/p>\n<p><img src=\"http://img.blog.csdn.net/20151229213605644?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"\"><br>\n<\/p>\n\n<p>用<span>Filechannel <\/span><span>往文件中读取和写入数据的简单例子<\/span><\/p>\n读取文件内容：\n\n<pre name=\"code\" class=\"java\">public static void main(String[] args) {\n\t\tFileInputStream fin = null;\n\t\ttry {\n\t\t\tfin = new FileInputStream(\"c:\\\\nio.txt\");\n\t\t} catch (FileNotFoundException e) {\n\t\t\te.printStackTrace();\n\t\t}\n\t\t// 获取通道\n\t\tFileChannel fc = fin.getChannel();\n\n\t\t// 创建缓冲区\n\t\tByteBuffer buffer = ByteBuffer.allocate(1024);\n\n\t\t// 读取数据到缓冲区\n\t\ttry {\n\t\t\tfc.read(buffer);\n\t\t} catch (IOException e) {\n\t\t\te.printStackTrace();\n\t\t}\n\n\t\tbuffer.flip();\n\n\t\twhile (buffer.remaining() > 0) {\n\t\t\tbyte b = buffer.get();\n\t\t\tSystem.out.print(((char) b));\n\t\t}\n\t\ttry {\n\t\t\tfin.close();\n\t\t} catch (IOException e) {\n\t\t\te.printStackTrace();\n\t\t}\n\t\t\n\t}<\/pre>\n\n\n写入文件内容：\n\n<pre name=\"code\" class=\"java\">public static void main(String[] args) {\n\t\tFile file = new File(\"c:\\\\nio.txt\"); \n\t\tFileOutputStream outputStream = null;\n\t\ttry {\n\t\t\toutputStream = new FileOutputStream(file);\n\t\t} catch (FileNotFoundException e1) {\n\t\t\te1.printStackTrace();\n\t\t} \n\t\tFileChannel channel = outputStream.getChannel(); \n\t\tByteBuffer bufferWrite = ByteBuffer.allocate(1024); \n\t\tString string = \"hello nio...\"; \n\t\tbufferWrite.put(string.getBytes()); \n\t\t//这里必须调用flip(),先读取数据到Buffer，再从Buffer中读取数据。\n\t\tbufferWrite.flip();\n\t\ttry {\n\t\t\tchannel.write(bufferWrite);\n\t\t\tchannel.close(); \n\t\t\toutputStream.close(); \n\t\t} catch (IOException e1) {\n\t\t\te1.printStackTrace();\n\t\t} \n\t}<\/pre><br>\n<strong>Select <\/strong><br>\nSelect 能检测到注册的所有通道上是否有读写请求，当有请求的时候才会进行读写，一个线程管理了多个通道，避免了多线程切换导致的开销，也不用去维护多个线程，操作原理如下图\n\n<p><img src=\"http://img.blog.csdn.net/20151229213928077?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast\" alt=\"\"><\/p>\n\n<p>这里介绍了javaio和nio的区别，以及nio的主要概念，还有简单的nio读写文件数据的例子，对nio就不做深入了。<\/p>\n<p>有兴趣的同学可以看Jakob Jenkov的系列文章，http://tutorials.jenkov.com/java-nio/index.html<\/p>\n<p>接下来会分享nio框架netty的一些学习心得，以及netty在实际项目架构中的使用<\/p>\n<br>\n<br>\n\n<\/div>\n   \n<\/div>\n\n\n\n\n\n\n\n\n\n\n\n   \n\n    \n\n\n            \n    \n      \n<\/div>","fav_num":"0","forum_id":"1","click_num":2847,"from_type":"3","comment_num":4,"sort_time":"0","oppose_num":3,"created_time":"1454153697","stopwords":""}
     * sessionId : SESSIONID-csdn-ST-11554-IhhF05ZTdHP9lpXDovgt-passport.csdn.net
     * sessionExpired : 1460774185629
     */

    private int code;
    private String message;
    /**
     * body : <div>



     <div >

     </div>
     <div id="article_content" >



     Java nio 全称Java new io，是jdk1.4里提供的api。<br>
     <br>
     <br>
     Java nio 与 io最主要的区别<br>
     <h3>1、读写方式</h3>
     Io是面向流的，只能在一个方向上移动，一个输入流（inputStream）一个输出流（outputStream），需要从流中读一个或多个字节，直到读取完所有的字节。<br>
     Nio是面向缓冲的，可以双向，无论是读写，数据都会被先放到一个缓冲区<br>
     <br>
     <h3>2.阻塞与非阻塞</h3>
     Io流是阻塞的，当一个线程调用read()或write()时，直到被read或write完成，在此期间，该线程处于等待阻塞模式，不干任何其他事情。<br>
     Nio 是非阻塞的，当一个线程从通道发出读/写的请求的时候，数据会被先放到缓冲区里，而不需要等待全部读写完成，在此期间，这个线程可以去做别的事情，通常在空闲时候会执行其他通道上的io操作，一个线程可以管理多个通道


     <h3>Nio核心概念：</h3>
     <h3>Buffer (缓冲区)，Channel（通道），Selector（选择器）</h3>
     <div>
     <p>Buffer</p>
     <p>前面已经提到，Nio是面向缓冲区的，所有的读写都要先放到缓冲区。</p>
     <p>所有的缓冲区类型都继承于抽象类Buffer,最常用的是Bytebuffer, java基础类基本上都有相应的buffer类来一一对应，类继承关系图如下：</p>
     <img src="http://img.blog.csdn.net/20151229213445131?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt=""><br>
     </div>

     <div>
     <p>Channel</p>
     <p>通道和io的流类似，主要区别为：通道是双向的，可读可写，io流是单向的，只能读或写，而且操作通道不会直接从通道中写入或读取数据，都是由通道将数据放入缓冲区（buffer）中。<br>
     最常用的通道：<br>
     Filechannel 读取/写入 文件数据<br>
     Socketchannel TCP协议的socket 读写数据<br>
     Datagramchannel UDP协议读写数据<br>
     下面是客服端发送读或写的请求过程，<br>
     </p>
     <p><img src="http://img.blog.csdn.net/20151229213605644?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt=""><br>
     </p>

     <p>用Filechannel 往文件中读取和写入数据的简单例子</p>
     读取文件内容：

     <pre name="code" >public static void main(String[] args) {
     FileInputStream fin = null;
     try {
     fin = new FileInputStream("c:\\nio.txt");
     } catch (FileNotFoundException e) {
     e.printStackTrace();
     }
     // 获取通道
     FileChannel fc = fin.getChannel();

     // 创建缓冲区
     ByteBuffer buffer = ByteBuffer.allocate(1024);

     // 读取数据到缓冲区
     try {
     fc.read(buffer);
     } catch (IOException e) {
     e.printStackTrace();
     }

     buffer.flip();

     while (buffer.remaining() > 0) {
     byte b = buffer.get();
     System.out.print(((char) b));
     }
     try {
     fin.close();
     } catch (IOException e) {
     e.printStackTrace();
     }

     }</pre>


     写入文件内容：

     <pre name="code" >public static void main(String[] args) {
     File file = new File("c:\\nio.txt");
     FileOutputStream outputStream = null;
     try {
     outputStream = new FileOutputStream(file);
     } catch (FileNotFoundException e1) {
     e1.printStackTrace();
     }
     FileChannel channel = outputStream.getChannel();
     ByteBuffer bufferWrite = ByteBuffer.allocate(1024);
     String string = "hello nio...";
     bufferWrite.put(string.getBytes());
     //这里必须调用flip(),先读取数据到Buffer，再从Buffer中读取数据。
     bufferWrite.flip();
     try {
     channel.write(bufferWrite);
     channel.close();
     outputStream.close();
     } catch (IOException e1) {
     e1.printStackTrace();
     }
     }</pre><br>
     Select <br>
     Select 能检测到注册的所有通道上是否有读写请求，当有请求的时候才会进行读写，一个线程管理了多个通道，避免了多线程切换导致的开销，也不用去维护多个线程，操作原理如下图

     <p><img src="http://img.blog.csdn.net/20151229213928077?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt=""></p>

     <p>这里介绍了javaio和nio的区别，以及nio的主要概念，还有简单的nio读写文件数据的例子，对nio就不做深入了。</p>
     <p>有兴趣的同学可以看Jakob Jenkov的系列文章，http://tutorials.jenkov.com/java-nio/index.html</p>
     <p>接下来会分享nio框架netty的一些学习心得，以及netty在实际项目架构中的使用</p>
     <br>
     <br>

     </div>

     </div>



















     </div>
     * desc :  Java nio 全称Java new io，是jdk1.4里提供的api。 Java nio 与 io最主要的区别 1、读写方式 Io是面向流的，只能在一个方向上移动，一个输入流（inputStream）一个输出流（outputStream），需要从流中读一个或多个字节，直到读取完所有的字节。 Nio是面向缓冲的，可以双向，无论是读写，数据都会被先放到一个缓冲区 2.阻塞与非阻塞 Io流是阻塞
     * tag :
     * forum_name : GEEKNEWS
     * update_timestamp : 2016-02-16 10:38:57
     * add_score_click_num : 0
     * id : 54090
     * title : Java nio 概述
     * username : u010926964
     * rank : 0
     * share_url : http://ms.csdn.net/geek/54090
     * description :
     * support_num : 7
     * is_markdown : 0
     * nickname : 邵鸿鑫
     * status : 1
     * is_fav : 1
     * ding_cai : 0
     * category_id : 0
     * avatar : http://avatar.csdn.net/0/7/C/1_u010926964.jpg
     * operator :
     * url : http://blog.csdn.net/tuposky/article/details/50429483
     * is_expert : 0
     * ip : 0
     * operate_time : 0
     * expert_username :
     * source : <div>



     <div class="article_manage clearfix">

     </div>
     <div id="article_content" class="article_content">



     <span>Java nio 全称Java new io<span>，</span>是jdk1.4里提供的api。</span><br>
     <br>
     <br>
     <span>Java nio 与 io最主要的区别</span><br>
     <h3><span>1、读写方式</span></h3>
     <span>Io是面向流的，只能在一个方向上移动，一个输入流（inputStream）一个输出流（outputStream），需要从流中读一个或多个字节，直到读取完所有的字节。</span><br>
     <span>Nio是面向缓冲的，可以双向，无论是读写，数据都会被先放到一个缓冲区</span><br>
     <br>
     <h3><span>2.阻塞与非阻塞</span></h3>
     <span>Io流是阻塞的，当一个线程调用read()或write()时，直到被read或write完成，在此期间，该线程处于等待阻塞模式，不干任何其他事情。</span><br>
     <span>Nio 是非阻塞的，当一个线程从通道发出读/写的请求的时候，数据会被先放到缓冲区里，而不需要等待全部读写完成，在此期间，这个线程可以去做别的事情，通常在空闲时候会执行其他通道上的io操作，一个线程可以管理多个通道</span>


     <h3>Nio核心概念：</h3>
     <h3><span>Buffer (缓冲区)，Channel（通道），Selector（选择器）</span></h3>
     <div>
     <p><strong>Buffer</strong></p>
     <p>前面已经提到，<span>Nio</span><span>是面向缓冲区的，所有的读写都要先放到缓冲区。</span></p>
     <p>所有的缓冲区类型都继承于抽象类<span>Buffer,</span><span>最常用的是</span><span>Bytebuffer, java</span><span>基础类基本上都有相应的</span><span>buffer</span><span>类来一一对应，类继承关系图如下：</span></p>
     <img src="http://img.blog.csdn.net/20151229213445131?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt=""><br>
     </div>

     <div>
     <p><strong>Channel</strong></p>
     <p>通道和io的流类似，主要区别为：通道是双向的，可读可写，io流是单向的，只能读或写，而且操作通道不会直接从通道中写入或读取数据，都是由通道将数据放入缓冲区（buffer）中。<br>
     最常用的通道：<br>
     Filechannel 读取/写入 文件数据<br>
     Socketchannel TCP协议的socket 读写数据<br>
     Datagramchannel UDP协议读写数据<br>
     下面是客服端发送读或写的请求过程，<br>
     </p>
     <p><img src="http://img.blog.csdn.net/20151229213605644?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt=""><br>
     </p>

     <p>用<span>Filechannel </span><span>往文件中读取和写入数据的简单例子</span></p>
     读取文件内容：

     <pre name="code" class="java">public static void main(String[] args) {
     FileInputStream fin = null;
     try {
     fin = new FileInputStream("c:\\nio.txt");
     } catch (FileNotFoundException e) {
     e.printStackTrace();
     }
     // 获取通道
     FileChannel fc = fin.getChannel();

     // 创建缓冲区
     ByteBuffer buffer = ByteBuffer.allocate(1024);

     // 读取数据到缓冲区
     try {
     fc.read(buffer);
     } catch (IOException e) {
     e.printStackTrace();
     }

     buffer.flip();

     while (buffer.remaining() > 0) {
     byte b = buffer.get();
     System.out.print(((char) b));
     }
     try {
     fin.close();
     } catch (IOException e) {
     e.printStackTrace();
     }

     }</pre>


     写入文件内容：

     <pre name="code" class="java">public static void main(String[] args) {
     File file = new File("c:\\nio.txt");
     FileOutputStream outputStream = null;
     try {
     outputStream = new FileOutputStream(file);
     } catch (FileNotFoundException e1) {
     e1.printStackTrace();
     }
     FileChannel channel = outputStream.getChannel();
     ByteBuffer bufferWrite = ByteBuffer.allocate(1024);
     String string = "hello nio...";
     bufferWrite.put(string.getBytes());
     //这里必须调用flip(),先读取数据到Buffer，再从Buffer中读取数据。
     bufferWrite.flip();
     try {
     channel.write(bufferWrite);
     channel.close();
     outputStream.close();
     } catch (IOException e1) {
     e1.printStackTrace();
     }
     }</pre><br>
     <strong>Select </strong><br>
     Select 能检测到注册的所有通道上是否有读写请求，当有请求的时候才会进行读写，一个线程管理了多个通道，避免了多线程切换导致的开销，也不用去维护多个线程，操作原理如下图

     <p><img src="http://img.blog.csdn.net/20151229213928077?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt=""></p>

     <p>这里介绍了javaio和nio的区别，以及nio的主要概念，还有简单的nio读写文件数据的例子，对nio就不做深入了。</p>
     <p>有兴趣的同学可以看Jakob Jenkov的系列文章，http://tutorials.jenkov.com/java-nio/index.html</p>
     <p>接下来会分享nio框架netty的一些学习心得，以及netty在实际项目架构中的使用</p>
     <br>
     <br>

     </div>

     </div>



















     </div>
     * fav_num : 0
     * forum_id : 1
     * click_num : 2847
     * from_type : 3
     * comment_num : 4
     * sort_time : 0
     * oppose_num : 3
     * created_time : 1454153697
     * stopwords :
     */

    private DataEntity data;
    private String sessionId;
    private String sessionExpired;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setSessionExpired(String sessionExpired) {
        this.sessionExpired = sessionExpired;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataEntity getData() {
        return data;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getSessionExpired() {
        return sessionExpired;
    }

    public static class DataEntity {
        private String body;
        private String desc;
        private String tag;
        private String forum_name;
        private String update_timestamp;
        private String add_score_click_num;
        private String id;
        private String title;
        private String username;
        private String rank;
        private String share_url;
        private String description;
        private int support_num;
        private String is_markdown;
        private String nickname;
        private String status;
        private int is_fav;
        private int ding_cai;
        private String category_id;
        private String avatar;
        private String operator;
        private String url;
        private String is_expert;
        private String ip;
        private String operate_time;
        private String expert_username;
        private String source;
        private String fav_num;
        private String forum_id;
        private int click_num;
        private String from_type;
        private int comment_num;
        private String sort_time;
        private int oppose_num;
        private String created_time;
        private String stopwords;

        public void setBody(String body) {
            this.body = body;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setForum_name(String forum_name) {
            this.forum_name = forum_name;
        }

        public void setUpdate_timestamp(String update_timestamp) {
            this.update_timestamp = update_timestamp;
        }

        public void setAdd_score_click_num(String add_score_click_num) {
            this.add_score_click_num = add_score_click_num;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setSupport_num(int support_num) {
            this.support_num = support_num;
        }

        public void setIs_markdown(String is_markdown) {
            this.is_markdown = is_markdown;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setIs_fav(int is_fav) {
            this.is_fav = is_fav;
        }

        public void setDing_cai(int ding_cai) {
            this.ding_cai = ding_cai;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setIs_expert(String is_expert) {
            this.is_expert = is_expert;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public void setOperate_time(String operate_time) {
            this.operate_time = operate_time;
        }

        public void setExpert_username(String expert_username) {
            this.expert_username = expert_username;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setFav_num(String fav_num) {
            this.fav_num = fav_num;
        }

        public void setForum_id(String forum_id) {
            this.forum_id = forum_id;
        }

        public void setClick_num(int click_num) {
            this.click_num = click_num;
        }

        public void setFrom_type(String from_type) {
            this.from_type = from_type;
        }

        public void setComment_num(int comment_num) {
            this.comment_num = comment_num;
        }

        public void setSort_time(String sort_time) {
            this.sort_time = sort_time;
        }

        public void setOppose_num(int oppose_num) {
            this.oppose_num = oppose_num;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public void setStopwords(String stopwords) {
            this.stopwords = stopwords;
        }

        public String getBody() {
            return body;
        }

        public String getDesc() {
            return desc;
        }

        public String getTag() {
            return tag;
        }

        public String getForum_name() {
            return forum_name;
        }

        public String getUpdate_timestamp() {
            return update_timestamp;
        }

        public String getAdd_score_click_num() {
            return add_score_click_num;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getUsername() {
            return username;
        }

        public String getRank() {
            return rank;
        }

        public String getShare_url() {
            return share_url;
        }

        public String getDescription() {
            return description;
        }

        public int getSupport_num() {
            return support_num;
        }

        public String getIs_markdown() {
            return is_markdown;
        }

        public String getNickname() {
            return nickname;
        }

        public String getStatus() {
            return status;
        }

        public int getIs_fav() {
            return is_fav;
        }

        public int getDing_cai() {
            return ding_cai;
        }

        public String getCategory_id() {
            return category_id;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getOperator() {
            return operator;
        }

        public String getUrl() {
            return url;
        }

        public String getIs_expert() {
            return is_expert;
        }

        public String getIp() {
            return ip;
        }

        public String getOperate_time() {
            return operate_time;
        }

        public String getExpert_username() {
            return expert_username;
        }

        public String getSource() {
            return source;
        }

        public String getFav_num() {
            return fav_num;
        }

        public String getForum_id() {
            return forum_id;
        }

        public int getClick_num() {
            return click_num;
        }

        public String getFrom_type() {
            return from_type;
        }

        public int getComment_num() {
            return comment_num;
        }

        public String getSort_time() {
            return sort_time;
        }

        public int getOppose_num() {
            return oppose_num;
        }

        public String getCreated_time() {
            return created_time;
        }

        public String getStopwords() {
            return stopwords;
        }
    }
}
