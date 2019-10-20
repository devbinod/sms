package np.com.alon.smss;

import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;
import org.smslib.OutboundBinaryMessage;
import org.smslib.http.ClickatellHTTPGateway;

public class SmsSender {





    public void doIt(String phoneNo, String message) throws Exception
    {

//		OutboundMessage msg;
//		OutboundNotification outboundNotification = new OutboundNotification();
//		SerialModemGateway gateway = new SerialModemGateway("", "COM3", 115200, "SAMSUNG", "A50");
//                gateway.setInbound(true);
//                gateway.setOutbound(true);
//                Service.getInstance().setOutboundMessageNotification(outboundNotification);
//                Service.getInstance().addGateway(gateway);
//                Service.getInstance().startService();
//                OutboundMessage message = new OutboundMessage("+9779862073776", "Test");
//                Service.getInstance().sendMessage(message);

        OutboundNotification outboundNotification = new OutboundNotification();
        System.out.println("Example: Send message from a serial gsm modem.");
        System.out.println(Library.getLibraryDescription());
        System.out.println("Version: " + Library.getLibraryVersion());
        SerialModemGateway gateway = new SerialModemGateway("modem.com1", "COM12", 460800, "Samsung", "J7Prime");
        gateway.setInbound(true);
        gateway.setOutbound(true);
        gateway.setSimPin("0000");
        // Explicit SMSC address set is required for some modems.
        // Below is for VODAFONE GREECE - be sure to set your own!
        gateway.setSmscNumber("+9779818373839");
        Service.getInstance().setOutboundMessageNotification(outboundNotification);
        Service.getInstance().addGateway(gateway);
        Service.getInstance().startService();
        System.out.println();
        System.out.println("Modem Information:");
//		System.out.println("  Manufacturer: " + gateway.getManufacturer());
//		System.out.println("  Model: " + gateway.getModel());
//		System.out.println("  Serial No: " + gateway.getSerialNo());
//		System.out.println("  SIM IMSI: " + gateway.getImsi());
//		System.out.println("  Signal Level: " + gateway.getSignalLevel() + " dBm");
//		System.out.println("  Battery Level: " + gateway.getBatteryLevel() + "%");
        System.out.println();

        OutboundMessage msg = new OutboundMessage(phoneNo, message);
        Service.getInstance().sendMessage(msg);
        System.out.println(msg);
        // Or, send out a WAP SI message.f
        //OutboundWapSIMessage wapMsg = new OutboundWapSIMessage("306974000000",  new URL("http://www.smslib.org/"), "Visit SMSLib now!");
        //Service.getInstance().sendMessage(wapMsg);
        //System.out.println(wapMsg);
        // You can also queue some asynchronous messages to see how the callbacks
        // are called...
        //msg = new OutboundMessage("309999999999", "Wrong number!");
        //srv.queueMessage(msg, gateway.getGatewayId());
        //msg = new OutboundMessage("308888888888", "Wrong number!");
        //srv.queueMessage(msg, gateway.getGatewayId());
        System.out.println("Now Sleeping - Hit <enter> to terminate.");
        System.in.read();
        Service.getInstance().stopService();
    }

    public class OutboundNotification implements IOutboundMessageNotification
    {
        public void process(AGateway gateway, OutboundMessage msg)
        {
            System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
            System.out.println(msg);
        }
    }

    public static void main(String[] args) throws Exception {
        SmsSender smsSender = new SmsSender();
        smsSender.doIt("+9779865691198","This Message from Form JSP GSM Ncell");
    }



}
