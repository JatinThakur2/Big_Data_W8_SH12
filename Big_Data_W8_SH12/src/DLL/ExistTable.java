package DLL;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class ExistTable {

	public static void main(String[] args) throws MasterNotRunningException, IOException {
		
		Configuration config = HBaseConfiguration.create();
		@SuppressWarnings({ "deprecation", "resource" })
		HBaseAdmin admin = new HBaseAdmin(config);
		
		Boolean bool = admin.tableExists("emp");
		System.out.println("does emp table exists: " + bool);

	}

}
