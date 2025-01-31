import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submit_form")
public class ContactFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        String recipient = iogkb82225@yahoo.co.jp; // ここにあなたのメールアドレスを入力

        // メール送信設定
        String host = "smtp.example.com"; // SMTPサーバーのアドレス
        final String username = "your-email@example.com"; // ここにSMTP認証用のユーザー名を入力
        final String password = "your-email-password"; // ここにSMTP認証用のパスワードを入力

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(username));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            mimeMessage.setSubject("お問い合わせが届きました");
            mimeMessage.setText("名前: " + name + "\n"
                                + "メールアドレス: " + email + "\n"
                                + "メッセージ: \n" + message);

            Transport.send(mimeMessage);

            response.setContentType("application/json");
            response.getWriter().print("{\"message\": \"問い合わせを受け付けました。ありがとうございます、" + name + "さん。\"}");
            response.getWriter().flush();

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
