package com.github.java5wro.email;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
public class QRCodeGenerator {

public void QrGenerator (String uuid){

    ByteArrayOutputStream stream = QRCode.from(uuid).stream();

		try

        {
            FileOutputStream fout = new FileOutputStream(new File("C:\\Users\\Jaro\\Desktop\\zadania2\\Qrcodes\\QR_Code.JPG"));


            fout.write(stream.toByteArray());

            fout.flush();
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

}
}