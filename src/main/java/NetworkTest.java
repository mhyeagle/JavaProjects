import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkTest {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces;

        {
            try {
                interfaces = NetworkInterface.getNetworkInterfaces();
                System.out.println(interfaces);
                System.out.println("***");
            } catch (SocketException e) {
                e.printStackTrace();
            }

            // ***
            InetAddress address = null;

            boolean bFindIp = false;
            Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();

            while(netInterfaces.hasMoreElements()) {
                if(bFindIp) {
                    break;
                }
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();

                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while(ips.hasMoreElements()) {
                    address = ips.nextElement();
                    address.isLoopbackAddress();
                    if(address.isSiteLocalAddress() && !address.isLoopbackAddress() && address.getHostAddress().indexOf(":") != -1) {
                        bFindIp = true;
                        break;
                    }
                }
            }

            System.out.println(address.getHostAddress());
        }
    }
}
