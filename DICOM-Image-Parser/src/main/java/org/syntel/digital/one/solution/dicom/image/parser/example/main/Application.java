package org.syntel.digital.one.solution.dicom.image.parser.example.main;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.dcm4che2.imageio.plugins.dcm.DicomImageReadParam;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class Application {

	static BufferedImage myJpegImage = null;
	public static void main(String[] args) {

		File file = new File("C:\\Users\\PJ5022396\\Downloads\\DICOM_1.dcm");
		Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("DICOM");
		while (iterator.hasNext()) {
			ImageReader imageReader = (ImageReader) iterator.next();
			DicomImageReadParam dicomImageReadParam = (DicomImageReadParam) imageReader.getDefaultReadParam();
			try {
				ImageInputStream iis = ImageIO.createImageInputStream(file);
				imageReader.setInput(iis, false);
				System.out.println("input line is set");
				myJpegImage = imageReader.read(0, dicomImageReadParam);
				System.out.println(myJpegImage);
				iis.close();
				if (myJpegImage == null) {
					System.out.println("Could not read image!!");
				}
			} catch (IOException e) {
				System.out.println("first catch block");
				e.printStackTrace();}
			File file2 = new File("D:\\dicomtest3.jpg");
			try {
				OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file2));
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
				encoder.encode(myJpegImage);
				outputStream.close();
			} catch (IOException e) {
				System.out.println("second catch block");
				e.printStackTrace();}
			System.out.println("Completed");
		}
	}
}