package com.example.lavender.mychat;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.lavender.mychat.fragment.MsgFragment;

public class MainActivity extends TabActivity {
    public static final String TAG_CHAT = "chat";

    private TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

//        Toast.makeText(MainActivity.this, "正在进入聊天界面...", Toast.LENGTH_SHORT).show();
        tabHost=this.getTabHost();
        TabHost.TabSpec spec;

    }

//    class Client extends Thread {
//
//
//        public void run() {
//            Looper.prepare();
//            //1 创建一个socket
//            Socket socket = null;
//            //2
//            OutputStream os = null;
//
//            InputStream is = null;
//
//            Scanner scanner = null;
//            try {
//                Toast.makeText(MainActivity.this, "正在连接服务器...", Toast.LENGTH_SHORT).show();
//                socket = new Socket(InetAddress.getByName("192.168.1.211"), 5222);
//
//                os = socket.getOutputStream();
//                Toast.makeText(MainActivity.this, "服务器连接成功", Toast.LENGTH_SHORT).show();
//
//                //3 向服务端发送数据
//                System.out.println("请输入要发送的数据");
//                String str = null;
//                scanner = new Scanner(System.in);
//                str = scanner.nextLine();
//
//                os.write(str.getBytes());
//                System.out.println("发送成功");
//                socket.shutdownOutput();
//                //4 接收来自服务端的数据
//                is = socket.getInputStream();
//                byte[] b = new byte[1024];
//                int len;
//                while ((len = is.read(b)) != -1) {
//                    String str1 = new String(b, 0, len);
//                    System.out.print(str1);
//                }
//                System.out.println("服务器接收数据完成");
//
//            }catch (UnknownHostException e){
//                e.printStackTrace();
//            }
//            catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } finally {
//                if (is != null) {
//                    try {
//                        is.close();
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//
//                if (scanner != null) {
//                    scanner.close();
//                }
//                if (os != null) {
//                    //
//                    try {
//                        os.close();
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//
//                }
//                if (socket != null) {
//                    try {
//                        socket.close();
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        }
//    }
}
