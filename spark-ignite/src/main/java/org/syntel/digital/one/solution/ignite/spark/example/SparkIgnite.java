package org.syntel.digital.one.solution.ignite.spark.example;

import org.apache.spark.api.java.*;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;

import java.util.ArrayList;
import java.util.List;

/*import com.me.igniteclient1.ratio.Ratio;*/

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.lang.IgniteOutClosure;
import org.apache.ignite.spark.JavaIgniteContext;
import org.apache.ignite.spark.JavaIgniteRDD;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

import akka.japi.Function;

/**
 *
 */
public class SparkIgnite 
{
    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("Spark-Ignite").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaIgniteContext igniteContext = new JavaIgniteContext(sc, new IgniteConfigProvider());
        JavaIgniteRDD<Integer, Integer> sharedRDD = igniteContext.fromCache("sharedRDD");
        
        String schemaString = "name,empid,salary";
        List<StructField> fieldList = new ArrayList<StructField>();
        
        //Create 3 objects for 3 columns, please note that salary is an integer
      	fieldList.add(DataTypes.createStructField("name",DataTypes.StringType,true));
      	fieldList.add(DataTypes.createStructField("empid",DataTypes.StringType,true));
      	fieldList.add(DataTypes.createStructField("salary",DataTypes.IntegerType,true));
      	
      	StructType schema = DataTypes.createStructType(fieldList);
      	
        //Load the file which contains the data into an RDD
      	JavaRDD<String> rdd = sc.textFile("hdfs://10.119.32.93:8020/user/SelfServiceBI/dataframe.txt");
      	
        //convert the input to a list of row objects
      	
      		JavaRDD<Row> rowsRDD = rdd.map(new Function<String,Row>()){

      			public Row call(String arg0) throws Exception {
      				//arg0 contains each line from the rdd , i.e empid,name,salary
      				String [] data = arg0.split(",");
      				
      				//We made sure that we convert the salary field to integer
      				return RowFactory.create(data[0],data[1],Integer.valueOf(data[2]));
      			}});
      		
      		//Create the dataframe from the rowsRDD and schema
      		DataFrame dataFrame = sqlContext.createDataFrame(rowsRDD, schema);
      		dataFrame.registerTempTable("parul_joshi_employee");
      	
      	
      		
      		
        //step: schema creation
        //using schema create dataframe
        DataFrame df = sharedRDD.sql("select * from city_1");
        
        //SQLContext sqlcontext = new SQLContext(igniteContext);
        /*JavaIgniteRDD<String, String> javaRdd = igniteContext.fromCache("RatioCache");

        DataFrame df = javaRdd.sql("select ric, ratio1, ratio2, ratio3, ratio4 from Ratio where date = ? and ratios__Exchange = ? and ratio5 > ?", "2017-01-25", "LSE", 10);

        df.printSchema();
        df.show();

        sc.stop();*/
      }

    /**
     * Ignite configiration provider.
     */
    static class IgniteConfigProvider implements IgniteOutClosure<IgniteConfiguration> {

        public IgniteConfiguration apply() {

            Ignition.setClientMode(true);

            // Start Ignite in client mode.
            Ignite ignite = Ignition.start();
            return ignite.configuration();
        }

    }

}
