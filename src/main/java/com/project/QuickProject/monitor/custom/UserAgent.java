package com.project.QuickProject.monitor.custom;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * UserAgent
 *
 * @author Jimmey-Jiang
 * @date 2020/6/25
 */
public class UserAgent {

    public static void main(String[] args) throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName userName = new ObjectName("Jimmey-Jiang:type=customer,name=customerUserBean");
        //create mbean and register mbean
        server.registerMBean(new User(), userName);
        //Thread.sleep(60 * 60 * 1000);

//        ObjectName adapterName = new ObjectName("Jimmey-Jiang:name=htmladapter,port=8888");
//        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
//        adapter.setPort(8888);
//        server.registerMBean(adapter, adapterName);
//        adapter.start();

        try {
            //这个步骤很重要，注册一个端口，绑定url后用于客户端通过rmi方式连接JMXConnectorServer
            LocateRegistry.createRegistry(8999);
            //URL路径的结尾可以随意指定，但如果需要用Jconsole来进行连接，则必须使用jmxrmi
            JMXServiceURL url = new JMXServiceURL
                    ("service:jmx:rmi:///jndi/rmi://localhost:8999/jmxrmi");
            JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);
            System.out.println("begin rmi start");
            jcs.start();
            System.out.println("rmi start");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
