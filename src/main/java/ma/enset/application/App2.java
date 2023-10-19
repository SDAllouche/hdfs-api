package ma.enset.application;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class App2 {

    public static void main(String[] args) throws IOException {
        Configuration cf =new Configuration();
        cf.set("fs.defaultFS","hdfs://localhost:9000");
        FileSystem fileSystem=FileSystem.get(cf);
        Path path =new Path("/BD/file1.txt");
        FSDataInputStream fdsis=fileSystem.open(path);
        BufferedReader reader=new BufferedReader(new InputStreamReader(fdsis, StandardCharsets.UTF_8));
        String ligne=null;
        while ((ligne= reader.readLine())!=null){
            System.out.println(ligne);
        }
        fdsis.close();
        fileSystem.close();
    }
}
