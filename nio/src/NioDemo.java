package nio.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioDemo {

	private static final int BSIZE = 1024;
	
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        FileChannel fin = null;
        FileChannel fout = null;
        try {
        	fin = new FileInputStream("filein").getChannel();
        	fout = new FileOutputStream("fileout").getChannel();
            while(fin.read(buffer) != -1) {
            	// 准备写入
            	buffer.flip(); 
                fout.write(buffer);
                // 准备读取
                buffer.clear(); 
            }
        }catch(Exception e) {
        	
        }finally {
        	try {
                if(fin != null) {
                    fin.close();
                }
                if(fout != null) {
                    fout.close();
                }
        	}catch(Exception e) {
        		
        	}

        }
	}
}
