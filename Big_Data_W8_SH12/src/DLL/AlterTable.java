package DLL;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class AlterTable  {
	
public static void main(String[] args) throws MasterNotRunningException, IOException {
		
		Configuration config = HBaseConfiguration.create();
		@SuppressWarnings("deprecation")
		HBaseAdmin admin = new HBaseAdmin(config);
		
		HColumnDescriptor columnDescriptor = new HColumnDescriptor("contactDetails");
		
		admin.addColumn("student", columnDescriptor);
		System.out.println("column added");
		admin.close();
	}

}
