import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static int PORT=6666;

    private static ExecutorService es=Executors.newCachedThreadPool();
    //床架一个服务端
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(PORT);
        Socket st=server.accept();
       es.submit(new ServerTest(st));
    }
    public static class ServerTest implements Runnable{
        private Socket socket;
        public ServerTest(Socket socket) {
            this.socket=socket;
        }
        @Override
        public void run() {
            try {
                InputStream is=socket.getInputStream();
                InputStreamReader isr=new InputStreamReader(is,"UTF-8");
                BufferedReader br=new BufferedReader(isr);

                OutputStream os=socket.getOutputStream();
                PrintWriter pw=new PrintWriter(os,true);

                String line;
                while((line=br.readLine())!=null){
                    System.out.println("接受客户端数据"+line);
                    pw.println("响应:"+line);
                    pw.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
