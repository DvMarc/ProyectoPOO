
package Modelo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Esta clase se encarga de realizar el proceso de enviar correos a los clientes de la agencia con la información de las propiedades que cumplen con los parametros de sus alertas
 * @author Rommel Marcillo
 * @version 1.0
 */
public class Correo {
    
    /**
     * Método que realiza el proceso de envio de correos
     * @param destinatario Indica el correo del cliente
     * @param asunto Indica el asunto del correo a enviar
     * @param cuerpo Indica el texto que tendra el correo
     */
    public static void enviarConGmail(String destinatario, String asunto, String cuerpo) {
    
        String remitente = "muebleriaproyecto3@gmail.com";  

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", "Clave123");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.port", "587"); 

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario)); 
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, "Clave123");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }catch (MessagingException me) {
            me.printStackTrace();  
        }
    }
    public static class enviarCorreo implements Runnable{
        private String asunto;
        private String cuerpo;
        private String destinatario;

        public enviarCorreo(String destinatario, String asunto, String cuerpo) {
            this.asunto = asunto;
            this.cuerpo = cuerpo;
            this.destinatario = destinatario;
        }
        
        @Override
        public void run(){
            enviarConGmail(destinatario,asunto,cuerpo);
        }
    }
}
