package DLL;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class DisableTable {

	public static void main(String[] args) throws MasterNotRunningException, IOException {
		
		Configuration config = HBaseConfiguration.create();
		@SuppressWarnings({ "deprecation", "resource" })
		HBaseAdmin admin = new HBaseAdmin(config);
		
		Boolean bool = admin.isTableDisabled("emp");
		System.out.println("Table is disable: " + bool);
		
		if(!bool){
			admin.disableTable("emp");
			System.out.println("Table Disabled");
		}

	}

}
