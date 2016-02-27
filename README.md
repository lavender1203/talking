# talking

1.需求说明：
  开发一款能在Android系统上运行的聊天客户端，并将项目上传到github上。
要求能够实现的功能：
  能在广域网进行单聊。
2.解决方案：
（1）使用socket编程的方式。开发周期长，任务量大，需要自己编写通信协议。
（2）xmpp+openfire+asmack。
xmpp是一种即时通讯协议。
openfire（这部分我已经在阿里云ecs服务器上搭建好了）是一个开源项目，有兴趣你可以自己从网站http://www.igniterealtime.org下载搭建openfire服务器，如windows版openfire_4_0_0.exe安装配置即可。可以参考我的博客http://blog.csdn.net/u010346967/article/details/50403314。
asmack是实现了xmpp协议的Android包，asmack其实是smack的Android版本，与smack大同小异。smack用于pc端，不过现在新版的smack已经支持Android系统了，所以也可以用smack开发了。

3.参考资料：
（1）最好的资料就是开源软件的官方文档。但是英文要还行。
（2）我的百度网盘资料。在百度网盘的目录：学习-》android-》黑马62期-》day77_实战项目xmpp版即时聊天第01天（更多视频教程关注微信公众号【菜鸟要飞】）、day78_实战项目xmpp版即时聊天第02天（更多视频教程关注微信公众号【菜鸟要飞】）
学习Android基础：学习-》android-》02-Android工程师
（3）书籍：《疯狂Android讲义》第三版

4.学习顺序
  可以先看看百度网盘：day77_实战项目xmpp版即时聊天第01天 里的一些视频，了解整个项目的基本框架。然后看不懂了再回过头来学习Android的基础知识。Android的基础知识视频资料在百度网盘目录： 学习-》android-》02-Android工程师目录里。
