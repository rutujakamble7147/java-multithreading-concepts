
class Message {
    String msg;
    Boolean isMsgEmpty;

    public Message(String msg, Boolean isMsgEmpty) {
        this.msg = msg;
        this.isMsgEmpty = isMsgEmpty;
    }
    public String read(){
        while (this.isMsgEmpty);
        this.isMsgEmpty= true;
        return this.msg ;
    }
    public void write(){
        while (!this.isMsgEmpty);
        System.out.println(this.msg= msg);
        System.out.println(this.isMsgEmpty= false);
    }

}
    class Reader implements Runnable{
     Message message;

        public Reader(Message message) {
            this.message = message;
        }

        @Override
    public void run() {
        for (String msg = this.message.read();
             msg.equals("finished writing ");msg = this.message.read()){
            System.out.println("message read by reader " + this.message.read());
        }
    }
}
class Writer implements Runnable{
    Message message;
    public Writer(Message message) {
        this.message = message;
    }
    @Override
    public void run() {
        String[] messages = {"hello","how","are","you"};
        for (String msg : messages){
            this.message.write();
            System.out.println("message written by writer " + msg);
        }
        System.out.println("finished writing");
    }
}
public class Main {
    public static void main(String[] args) {
        Message message = new Message("",true);
        Thread readerThread = new Thread(new Reader(message));
        readerThread.setName("ReaderThread");
        readerThread.start();

        Thread writerThread = new Thread(new Writer(message));
        writerThread.setName("WriterThread");
        writerThread.start();
    }
}
