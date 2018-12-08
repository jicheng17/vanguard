package com.jaycee.zookeeper.manager;

import com.jaycee.zookeeper.connection.ZKConnection;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZKManagerImpl implements ZKManager {
    private static ZooKeeper zkeeper;
    private static ZKConnection zkConnection;

    public ZKManagerImpl() {
        initialize();
    }

    /** * Initialize connection */
    private void initialize() {
        try {
            zkConnection = new ZKConnection();
            zkeeper = zkConnection.connect("localhost");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            zkConnection.close();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(String path, byte[] data) throws KeeperException, InterruptedException {
        zkeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public Object getZNodeData(String path, boolean watchFlag) {
        try {
            byte[] b = null;
            b = zkeeper.getData(path, null, null);
            String data = new String(b, "UTF-8");
            System.out.println(data);
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void update(String path, byte[] data) throws KeeperException, InterruptedException {
        int version = zkeeper.exists(path, true)
            .getVersion();
        zkeeper.setData(path, data, version);
    }

    public static void main( String []args )throws Exception{

        ZKManager zkManager = new ZKManagerImpl();
        //zkManager.create("/jc_test", "test".getBytes());

        zkManager.getZNodeData("/jc_test", false);
        System.out.println("end test");
    }
}
