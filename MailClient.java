package Network;
import java.io.*;
import java.net.*;
import java.util.*;
public class MailClient {



    // Variable contains the address of the photo
    public static String photo = "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";


    public static void main(String args[])
    {
        /* I prefer to use scanner class instead of GUI
         */
        //get input from user
        Scanner scanner = new Scanner(System.in);

        try{
            /*
            establish a connection between a client and a server.
             */
            Socket socket= new Socket("127.0.0.1",25);
            System.out.println("Client: "+"Connection is successfully ");

            /*
            reads text from a character-input stream
             */
            BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(socket.getInputStream()));

            /*
            Used to send new commands to the server
             */
            BufferedWriter bufferedWriter=  new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));



            /*i have two variables serverMessage and send */
            String serverMessage; //check the response from the server
            String send; //send new commands to the server

            // Reply Codes
            while((serverMessage = bufferedReader.readLine()) != null){
                System.out.println("Server: " + serverMessage);

                // Read a line from server and check that the reply code is 220
                if (serverMessage.startsWith("220")){
                    send = "HELO localhost";
                    bufferedWriter.write(send+"\r\n");
                    bufferedWriter.flush();
                }

                /* if the server gives a message that starts with 250 n-62,
                   we know that the server has said "Pleased to meet you" and waiting for the command MAIL FORM:
                 */
                if (serverMessage.startsWith("250 n-62")){
                    System.out.print("MAIL FROM: ");
                    send = "MAIL FROM: " + scanner.nextLine();
                    bufferedWriter.write(send+"\r\n");
                    bufferedWriter.flush();
                    continue;
                }


                else if (serverMessage.startsWith("250 2.1.0")){
                    System.out.print("MAIL TO: ");
                    send = "RCPT TO: " + scanner.nextLine();
                    bufferedWriter.write(send+"\r\n");
                    bufferedWriter.flush();
                    continue;
                }

                else if (serverMessage.startsWith("250 2.1.5")){
                    send = "DATA";
                    bufferedWriter.write(send+"\r\n");
                    bufferedWriter.flush();
                    continue;
                }
                // DATA
                else if (serverMessage.startsWith("354")){
                    System.out.println("Subject:");
                    String subject = scanner.nextLine();


                    System.out.println("What is a name for the photo");
                    String photoName = scanner.nextLine();

                    System.out.println("Type your message");
                    String message = scanner.nextLine();

                    /*
                     Help to send a photo
                      */
                    send =  "Subject:" + subject+"\n" +

                            "MIME-Version: 1.0\n" +
                            "Content-Type:multipart/mixed;boundary=\"KkK170891tpbkKk__FV_KKKkkkjjwq\"\n" +
                            "--KkK170891tpbkKk__FV_KKKkkkjjwq\n" +
                            "Content-Type:application/octet-stream;name=\""+photoName+".jpg\"\n" +
                            "Content-Transfer-Encoding:base64\n" +
                            "Content-Disposition:attachment;filename=\""+ photoName+".jpg\"\n\n" +
                            photo+"\n\n" +
                            "--KkK170891tpbkKk__FV_KKKkkkjjwq--"+"\n";

                    bufferedWriter.write(send+message+"\r\n");
                    bufferedWriter.flush();

                    send = ".";
                    bufferedWriter.write(send+"\r\n");
                    bufferedWriter.flush();


                }
            }
        }catch(Exception e)
        {
            System.out.println("Connection is unsuccessful");
        }


    }

}





