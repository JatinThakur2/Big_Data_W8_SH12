package DLL;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class ListTable {

	public static void main(String[] args) throws MasterNotRunningException, IOException {
		
		Configuration config = HBaseConfiguration.create();
		@SuppressWarnings({ "deprecation", "resource" })
		HBaseAdmin admin = new HBaseAdmin(config);
		
		//Get list of Table Names from HBase Admin
		for(TableName name : admin.listTableNames()){
			System.out.println(name.toString());
		}
	}

}
