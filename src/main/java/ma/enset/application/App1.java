package ma.enset.application;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class App1 {

    public static void main(String[] args) throws IOException {
        Configuration cf =new Configuration();
        cf.set("fs.defaultFS","hdfs://localhost:9000");
        FileSystem fileSystem=FileSystem.get(cf);
        Path path =new Path("/BD/file1.txt");
        FSDataOutputStream fsdos=fileSystem.create(path);
        BufferedWriter br=new BufferedWriter(new OutputStreamWriter(fsdos, StandardCharsets.UTF_8));
        System.out.println("Writing...");
        br.write("SDIA 2");
        br.newLine();
        br.write("SDIA 2");
        System.out.println("Done!");
        br.close();
        fileSystem.close();
    }
}
